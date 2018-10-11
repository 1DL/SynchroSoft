/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Endereco;
import model.Funcionario;
import model.Orcamento;
import model.Peca;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Servico;
import model.VendaPeca;
import view.FrmListagemServico;

/**
 *
 * @author LuizV1
 */
public class DaoOrcamento {

    public static boolean existeOrcamento(int codigoServico) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoServico);
        ResultSet rs = st.executeQuery();
        flag = rs.isBeforeFirst();
        st.close();
        rs.close();
        return flag;
    }

    public static void criarOrcamento(Orcamento o, boolean flagTemPeca, boolean flagCriarOuAlterar) throws SQLException, ClassNotFoundException {

        if (flagCriarOuAlterar) {
            if (existeOrcamento(o.getServico().getCodigoServico())) {
                JOptionPane.showMessageDialog(null, "Já existe um orçamento para esse serviço. \nAltere ou exclua-o na listagem de Orçamentos.");
            } else {
                Connection con = Conexao.conectar();
                String sql = "INSERT INTO SYNCHROSOFT.TB_ORCAMENTO (CD_SERVICO, VL_MAODEOBRA, VL_ORCAMENTO, ID_STATUS_ORCAMENTO) VALUES (?,?,?,?)";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, o.getServico().getCodigoServico());
                st.setDouble(2, o.getMaoDeObra());
                st.setDouble(3, o.getValorTotal());
                st.setInt(4, 0);
                st.executeUpdate();
                st.close();
                if (flagTemPeca) {
                    criarAlterarPecaOrcamento(o);
                }
            }
        } else {
            Connection con = Conexao.conectar();
            String sql = "UPDATE SYNCHROSOFT.TB_ORCAMENTO "
                    + "SET VL_MAODEOBRA = ?, VL_ORCAMENTO = ? "
                    + "WHERE CD_SERVICO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setDouble(1, o.getMaoDeObra());
            st.setDouble(2, o.getValorTotal());
            st.setDouble(3, o.getServico().getCodigoServico());
            st.executeUpdate();
            st.close();
            if (flagTemPeca) {
                criarAlterarPecaOrcamento(o);
            }
        }

        JOptionPane.showMessageDialog(null, "Orçamento criado/Alterado com sucesso.");
    }

    public static int buscarOrcamento(int codigoServico) throws SQLException, ClassNotFoundException {
        int codigoOrcamento = 0;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_ORCAMENTO FROM SYNCHROSOFT.TB_ORCAMENTO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoServico);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            codigoOrcamento = rs.getInt("CD_ORCAMENTO");
        }
        rs.close();
        st.close();
        return codigoOrcamento;
    }

    public static void pagarOrcamento(int codigoServico, boolean flag) throws SQLException, ClassNotFoundException {
        int codigoOrcamento = 0;
        codigoOrcamento = buscarOrcamento(codigoServico);
        Connection con = Conexao.conectar();
        String sql = "UPDATE SYNCHROSOFT.TB_ORCAMENTO "
                + "SET ID_STATUS_ORCAMENTO = ? "
                + "WHERE CD_ORCAMENTO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        if (flag) {
         st.setInt(1, 1);   
        } else {
            st.setInt(1, 0);
        }
        
        st.setInt(2, codigoOrcamento);
        st.executeUpdate();
        st.close();
    }

    public static void criarAlterarPecaOrcamento(Orcamento o) throws SQLException, ClassNotFoundException {
        int codigoOrcamento = buscarOrcamento(o.getServico().getCodigoServico());
        Connection con = Conexao.conectar();
        String sql = "DELETE FROM SYNCHROSOFT.TB_PECA_ORCAMENTO WHERE CD_ORCAMENTO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoOrcamento);
        st.execute();
        sql = "INSERT INTO SYNCHROSOFT.TB_PECA_ORCAMENTO (CD_PECA, CD_ORCAMENTO, QT_PECA_VENDIDA, VL_PECA_VENDIDA) VALUES (?,?,?,?)";

        for (int i = 0; i < o.getPecas().size(); i++) {
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.setString(1, o.getPecas().get(i).getPeca().getCodigoPeca());
            st2.setInt(2, codigoOrcamento);
            st2.setInt(3, o.getPecas().get(i).getQuantidadeVendida());
            st2.setFloat(4, o.getPecas().get(i).getPeca().getValorUnitario());
            st2.executeUpdate();
            st2.close();
        }

        st.close();

        JOptionPane.showMessageDialog(null, "Peças do orçamento adicionadas/alteradas com sucesso.");

    }

    public static ArrayList listarOrcamento() {
        ArrayList<Orcamento> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Orcamento o = new Orcamento();
                o.setCodigoOrcamento(rs.getInt("CD_ORCAMENTO"));
                Servico s = new Servico();
                s.setCodigoServico(rs.getInt("CD_SERVICO"));
                o.setServico(s);
                o.setStatusOrcamento(rs.getInt("ID_STATUS_ORCAMENTO"));
                o.setValorTotal(rs.getDouble("VL_ORCAMENTO"));
                o.setMaoDeObra(rs.getDouble("VL_MAODEOBRA"));
                lista.add(o);
            }
            st.close();
            rs.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular tabela de peças.\n" + ex.getMessage());
        }
        return lista;
    }

    public static ArrayList listarOrcamentoFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<Orcamento> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "";
            /*
Código Orçamento
Código Serviço
Status
Valor Mão De Obra
Valor Total
            
             */
            switch (cmbFiltro) {

                case "Código Orçamento":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE LOWER(CD_ORCAMENTO) LIKE LOWER(?)";
                    break;
                case "Código Serviço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE LOWER(CD_SERVICO) LIKE LOWER(?)";
                    break;
                case "Status":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE LOWER(ID_STATUS_ORCAMENTO) LIKE LOWER(?)";
                    break;
                case "Valor Mão De Obra":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE LOWER(VL_MAODEOBRA) LIKE LOWER(?)";
                    break;
                case "Valor Total":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE LOWER(VL_ORCAMENTO) LIKE LOWER(?)";
                    break;

            }

            //realizando preparedStatement para tratamento de variáveis
            PreparedStatement st = con.prepareStatement(sql);

            //colocando valor da variável ? da query 
            st.setString(1, "%" + txtPesquisa + "%");

            //executando query selecionada pelo switch case
            ResultSet rs = st.executeQuery();

            //listando dados do banco em jtable
            while (rs.next()) {
                Orcamento o = new Orcamento();
                o.setCodigoOrcamento(rs.getInt("CD_ORCAMENTO"));
                Servico s = new Servico();
                s.setCodigoServico(rs.getInt("CD_SERVICO"));
                o.setServico(s);
                o.setStatusOrcamento(rs.getInt("ID_STATUS_ORCAMENTO"));
                o.setValorTotal(rs.getDouble("VL_ORCAMENTO"));
                o.setMaoDeObra(rs.getDouble("VL_MAODEOBRA"));
                lista.add(o);
            }

            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (Exception ex) { //Caso exista a possibilidade de retorno de erro
            JOptionPane.showMessageDialog(null,"Erro no carregamento da lista de Orçamento filtrada.\n\n" + ex, "Erro Carregamento", JOptionPane.ERROR_MESSAGE);
        }
        //return lista;
        return lista;
    }

    public static ArrayList listarPecaOrcamento(int codigoOrcamento) {
        ArrayList<Peca> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PECA_ORCAMENTO WHERE CD_ORCAMENTO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoOrcamento);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Peca p = new Peca();
                p = DaoPeca.popularPeca(rs.getInt("CD_PECA"));
                p.setQuantidadePeca(rs.getInt("QT_PECA_VENDIDA"));
                p.setValorUnitario(Float.toString(rs.getFloat("VL_PECA_VENDIDA")));
                lista.add(p);
            }
            st.close();
            rs.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular tabela de peças.\n" + ex.getMessage());
        }
        return lista;
    }

    public static void deletarOrcamento(int codigoOrcamento) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.conectar();
        String sql = "DELETE FROM SYNCHROSOFT.TB_ORCAMENTO WHERE CD_ORCAMENTO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoOrcamento);
        st.executeUpdate();
        JOptionPane.showMessageDialog(null, "Orçamento excluído com sucesso.");
    }

}
