/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Orcamento;
import model.Produto;
import model.Servico;

/**
 *
 * @author LuizV1
 */
public class DaoOrcamento {

    public static boolean existeOrcamento(String codigoServico) {
        boolean flag;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE CD_SERVICO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigoServico);
            ResultSet rs = st.executeQuery();
            
            flag = rs.isBeforeFirst();
            
            st.close();
            rs.close();
            return flag;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível verificar a existência do orçamento.\n\nErro Nº "
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoOrcamento - Existe Orçamento", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public static boolean existeOrcamentoPago(String codigoServico) {
        boolean flag;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO "
                    + "WHERE CD_SERVICO = ? AND ID_STATUS_ORCAMENTO = 1";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigoServico);
            ResultSet rs = st.executeQuery();
            flag = rs.isBeforeFirst();
            st.close();
            rs.close();
            return flag;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível verificar a existência do orçamento.\n\nErro Nº "
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoOrcamento - Existe Orçamento", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean criarOrcamento(Orcamento o, boolean flagTemPeca, boolean flagCriarOuAlterar) {
        try {
            if (flagCriarOuAlterar) {
                if (existeOrcamento(o.getServico().getCodigoServico())) {
                    JOptionPane.showMessageDialog(null, "Já existe um orçamento para esse serviço. "
                            + "\nAltere ou exclua-o na listagem de orçamentos.",
                            "Erro - Serviço com orçamento já existente", 0);
                } else {
                    Connection con = Conexao.conectar();
                    String sql = "INSERT INTO SYNCHROSOFT.TB_ORCAMENTO (CD_SERVICO, VL_MAODEOBRA, VL_ORCAMENTO, ID_STATUS_ORCAMENTO) VALUES (?,?,?,?)";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, o.getServico().getCodigoServico());
                    st.setDouble(2, o.getMaoDeObra());
                    st.setDouble(3, o.getValorTotal());
                    st.setInt(4, 0);
                    st.executeUpdate();
                    st.close();
                    if (flagTemPeca) {
                        criarAlterarPecaOrcamento(o);
                    }
                    JOptionPane.showMessageDialog(null, "Orçamento criado com sucesso!",
                            "Orçamento vinculado ao serviço", 1);
                    return true;

                }
            } else {
                Connection con = Conexao.conectar();
                String sql = "UPDATE SYNCHROSOFT.TB_ORCAMENTO "
                        + "SET VL_MAODEOBRA = ?, VL_ORCAMENTO = ? "
                        + "WHERE CD_SERVICO = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setDouble(1, o.getMaoDeObra());
                st.setDouble(2, o.getValorTotal());
                st.setString(3, o.getServico().getCodigoServico());
                st.executeUpdate();
                st.close();
                if (flagTemPeca) {
                    criarAlterarPecaOrcamento(o);
                }
                JOptionPane.showMessageDialog(null, "Orçamento alterado com sucesso!",
                        "Orçamento alterado", 1);
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao vincular orçamento. \n\nErro nº: "
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoOrcamento - Criar Orçamento", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao vincular orçamento. \n\nErro: "
                    + ex, "Erro: DaoOrcamento - Criar Orçamento", 0);
            return false;
        }
        return false;
    }

    public static int buscarOrcamento(String codigoServico) {
        try {
            int codigoOrcamento = 0;
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_ORCAMENTO FROM SYNCHROSOFT.TB_ORCAMENTO WHERE CD_SERVICO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigoServico);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                codigoOrcamento = rs.getInt("CD_ORCAMENTO");
            }
            rs.close();
            st.close();
            return codigoOrcamento;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Não foi possível buscar o código do orçamento.\n\nErro nº: "
                    + ex.getErrorCode() + "\n\n" + ex.getMessage(), "Erro: DaoOrcamento - Buscar Orçamento", 0);
            return -1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static void pagarOrcamento(String codigoServico, boolean flag) throws SQLException, ClassNotFoundException {
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

    public static void criarAlterarPecaOrcamento(Orcamento o) {
        try {
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
                st2.setLong(3, o.getPecas().get(i).getQuantidadeVendida());
                st2.setFloat(4, o.getPecas().get(i).getPeca().getValorUnitarioBanco());
                st2.executeUpdate();
                st2.close();
            }

            st.close();

            JOptionPane.showMessageDialog(null, "Os produtos foram alterados e/ou adicionados com sucesso!",
                    "Alteração de produtos", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar ou adicionar produtos ao orçamento.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n\n" + ex.getMessage(),
                    "Erro: DaoOrcamento - Criar Alterar Prod. Orçamento", 1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

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
                s.setCodigoServico(rs.getString("CD_SERVICO"));
                o.setServico(s);
                o.setStatusOrcamento(rs.getInt("ID_STATUS_ORCAMENTO"));
                o.setValorTotal(rs.getDouble("VL_ORCAMENTO"));
                o.setMaoDeObra(rs.getDouble("VL_MAODEOBRA"));
                lista.add(o);
            }
            st.close();
            rs.close();
            return lista;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar a lista de orçamentos.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n\n" + ex.getMessage(), "Erro: DaoOrcamento - Listar Orçamento", 0);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static ArrayList listarOrcamentoFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<Orcamento> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "";
            /*
Código do Orçamento
Código do Serviço
Orçamento Pago?
Valor Mão De Obra
Valor Total
            
             */
            switch (cmbFiltro) {

                case "Código do Orçamento":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE LOWER(CD_ORCAMENTO) LIKE LOWER(?)";
                    break;
                case "Código do Serviço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE LOWER(CD_SERVICO) LIKE LOWER(?)";
                    break;
                case "Orçamento Pago?":
                    txtPesquisa = txtPesquisa.substring(0, 1);
                    if (txtPesquisa.equals("n")) {
                        txtPesquisa = "0";
                    } else if (txtPesquisa.equals("s")) {
                        txtPesquisa = "1";
                    }
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
                s.setCodigoServico(rs.getString("CD_SERVICO"));
                o.setServico(s);
                o.setStatusOrcamento(rs.getInt("ID_STATUS_ORCAMENTO"));
                o.setValorTotal(rs.getDouble("VL_ORCAMENTO"));
                o.setMaoDeObra(rs.getDouble("VL_MAODEOBRA"));
                lista.add(o);
            }

            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (SQLException ex) { //Caso exista a possibilidade de retorno de erro
            JOptionPane.showMessageDialog(null, "Erro ao listar orçamentos via filtro.\n\nErro nº:"
                    + ex.getErrorCode() + "\n\n" + ex.getMessage(), "Erro: DaoOrcamento - Listar Orcamento Filtrado", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar orçamentos via filtro.\n\nErro: "
                    + ex, "Erro: DaoOrcamento - Listar Orcamento Filtrado", 0);
        }
        return lista;
    }

    public static ArrayList listarPecaOrcamento(int codigoOrcamento) {
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PECA_ORCAMENTO WHERE CD_ORCAMENTO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoOrcamento);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p = DaoProduto.popularPeca(rs.getString("CD_PECA"));
                p.setQuantidadePeca(rs.getString("QT_PECA_VENDIDA"));
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

    public static void deletarOrcamento(int codigoOrcamento) {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_PECA_ORCAMENTO WHERE CD_ORCAMENTO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoOrcamento);
            st.executeUpdate();

            sql = "DELETE FROM SYNCHROSOFT.TB_ORCAMENTO WHERE CD_ORCAMENTO = ?";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.setInt(1, codigoOrcamento);
            st2.executeUpdate();

            JOptionPane.showMessageDialog(null, "Orçamento excluído com sucesso.", "Remoção concluída", 1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover o orçamento.\n\n Erro Nº:"
                    + ex.getErrorCode() + "\n\n" + ex.getMessage(), "Erro: DaoOrcamento - Deletar Orçamento", 0);
        } catch (ClassNotFoundException ex) {

        }
    }

}
