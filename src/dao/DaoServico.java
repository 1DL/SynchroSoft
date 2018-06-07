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
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Servico;
import view.FrmListagemServico;

/**
 *
 * @author LuizV1
 */
public class DaoServico {

    public static ArrayList listarServico() {
        ArrayList<Servico> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO ORDER BY CD_SERVICO";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Servico s = new Servico();
                s.setCodigoServico(rs.getInt("CD_SERVICO"));

                switch (rs.getInt("DS_TIPO_SERVICO")) {
                    case 0:
                        s.setTipoServico("Preventivo");
                        break;
                    case 1:
                        s.setTipoServico("Corretivo");
                        break;
                    case 2:
                        s.setTipoServico("Emergencial");
                        break;
                }

                if (rs.getInt("DS_TIPO_CLIENTE") == 0) {
                    s.setTipoCliente(true);
                } else {
                    s.setTipoCliente(false);
                }

                s.setDescricaoServicoFILE(rs.getString("DS_SERVICO"));

                if (rs.getInt("ID_STATUS_SERVICO") == 0) {
                    s.setStatusServico(false);
                } else {
                    s.setStatusServico(true);
                }

                s.setDataServico(rs.getDate("DT_SERVICO_INICIO"));
                s.setDataServicoFim(rs.getDate("DT_SERVICO_INICIO"));
                lista.add(s);
            }
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DaoServico Listagem Java: " + ex.getMessage());
        }
        return lista;
    }

    public static void alterarFuncionarioServico(ArrayList<Funcionario> lista, int codigoServico) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.conectar();
        String sql = "DELETE FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoServico);
        st.executeUpdate();
        st.close();
        sql = "INSERT INTO SYNCHROSOFT.TB_FUNC_SERVICO (CD_FUNCIONARIO, CD_SERVICO) VALUES (?,?)";
        PreparedStatement st2 = con.prepareStatement(sql);
        for (int i = 0; i < lista.size(); i++) {
            st2.setInt(1, lista.get(i).getCodigoFuncionario());
            st2.setInt(2, codigoServico);
            st2.executeUpdate();
        }
        st2.close();
        
    }
    
    public static void deletarServico(Servico s) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.conectar();
        String sql = "DELETE FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, s.getCodigoServico());
        st.executeUpdate();
        st.close();
        
        sql = "DELETE FROM SYNCHROSOFT.TB_PESSOAF_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st2 = con.prepareStatement(sql);
        st2.setInt(1, s.getCodigoServico());
        st2.executeUpdate();
        st2.close();
        
        sql = "DELETE FROM SYNCHROSOFT.TB_PESSOAJ_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st3 = con.prepareStatement(sql);
        st3.setInt(1, s.getCodigoServico());
        st3.executeUpdate();
        st3.close();
        
        sql = "DELETE FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st4 = con.prepareStatement(sql);
        st4.setInt(1, s.getCodigoServico());
        st4.executeUpdate();
        st4.close();
        JOptionPane.showMessageDialog(null, "O Serviço foi removido com sucesso, sem nenhum funcionário atribuído ao mesmo.");
    }
    
    public static void alterarServico(Servico s, ArrayList<Funcionario> lista, boolean tipoPessoa, String cpfcnpj) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.conectar();
        String sql = "UPDATE SYNCHROSOFT.TB_SERVICO "
                + "SET DS_TIPO_SERVICO = ?, DS_TIPO_CLIENTE = ?, DS_SERVICO = ?, "
                + "DT_SERVICO_INICIO = ?, DT_SERVICO_FIM = ?"
                + "WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        switch (s.getTipoServico()){
            case "Preventivo":
                st.setInt(1, 0);
                break;
            case "Corretivo":
                st.setInt(1, 1);
                break;
            case "Emergencial":
                st.setInt(1, 2);
                break;
        }
        if (s.isTipoCliente()){
            st.setInt(2, 1);
        } else {
            st.setInt(2, 0);
        }
        
        st.setString(3, s.getDescricaoServicoFILE());
        st.setDate(4, s.getDataServico());
        st.setDate(5, s.getDataServicoFim());
        st.setInt(6, s.getCodigoServico());
        st.executeUpdate();
        st.close();
        
        alterarFuncionarioServico(lista, s.getCodigoServico());
        
        if (tipoPessoa) {
            sql = "UPDATE SYNCHROSOFT.TB_PESSOAF_SERVICO "
                    + "SET CD_CPF = ?"
                    + "WHERE CD_SERVICO = ?";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.setString(1, cpfcnpj);
            st2.setInt(2, s.getCodigoServico());
            st2.executeUpdate();
            st2.close();
            
        } else {
            sql = "UPDATE SYNCHROSOFT.TB_PESSOAJ_SERVICO "
                    + "SET CD_CNPJ = ?"
                    + "WHERE CD_SERVICO = ?";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.setString(1, cpfcnpj);
            st2.setInt(2, s.getCodigoServico());
            st2.executeUpdate();
            st2.close();
        }
        
        JOptionPane.showMessageDialog(null, "Serviço alterado com sucesso!");
        
    }

    public static ArrayList popularListaServicoDetalhada(int codigoServico, int tipoCliente) throws ClassNotFoundException {
        Servico s = new Servico();
        PessoaJuridica pj = new PessoaJuridica();
        PessoaFisica pf = new PessoaFisica();
        Endereco end = new Endereco();
        Boolean flag = false;
        ArrayList<Object> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            if (tipoCliente == 0) {
                String sql = "SELECT CD_CNPJ FROM SYNCHROSOFT.TB_PESSOAJ_SERVICO WHERE CD_SERVICO = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, codigoServico);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    s.setCnpjCliente(rs.getString("CD_CNPJ"));
                    pj = DaoPessoa.popularPessoaJuridicaSemCep(s.getCnpjCliente());
                    end = DaoEndereco.popularEndereco(pj.getPessoa().getEndereco().getCep());
                }
                st.close();
                rs.close();
                flag = false;

            } else {
                String sql = "SELECT CD_CPF FROM SYNCHROSOFT.TB_PESSOAF_SERVICO WHERE CD_SERVICO = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, codigoServico);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    s.setCpfCliente(rs.getString("CD_CPF"));
                    pf = DaoPessoa.popularPessoaFisicaSemCep(s.getCpfCliente());
                    end = DaoEndereco.popularEndereco(pf.getPessoa().getEndereco().getCep());
                }
                st.close();
                rs.close();
                flag = true;

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        lista.add(pf);
        lista.add(pj);
        lista.add(end);
        lista.add(flag);

        return lista;
    }

    public static ArrayList listarServicoFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<Servico> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "";
            /*
Código Serviço
Status Serviço
Tipo Serviço
Descrição Serviço
Data Início
Data Encerramento        
             */

            switch (cmbFiltro) {
                case "Código Serviço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO WHERE LOWER(CD_SERVICO) LIKE LOWER(?)";
                    break;
                case "Status Serviço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO WHERE LOWER(ID_STATUS_SERVICO) LIKE LOWER(?)";
                    break;
                case "Tipo Serviço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO WHERE LOWER(DS_TIPO_SERVICO) LIKE LOWER(?)";
                    break;
                case "Descrição Serviço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO WHERE LOWER(DS_SERVICO) LIKE LOWER(?)";
                    break;
                case "Data Início":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO WHERE LOWER(DT_SERVICO_INICIO) LIKE LOWER(?)";
                    break;
                case "Data Encerramento":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO WHERE LOWER(DT_SERVICO_FIM) LIKE LOWER(?)";
                    break;
            }
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + txtPesquisa + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Servico s = new Servico();
                s.setCodigoServico(rs.getInt("CD_SERVICO"));

                switch (rs.getInt("DS_TIPO_SERVICO")) {
                    case 0:
                        s.setTipoServico("Preventivo");
                        break;
                    case 1:
                        s.setTipoServico("Corretivo");
                        break;
                    case 2:
                        s.setTipoServico("Emergencial");
                        break;
                }

                if (rs.getInt("DS_TIPO_CLIENTE") == 0) {
                    s.setTipoCliente(false);
                } else {
                    s.setTipoCliente(true);
                }

                s.setDescricaoServicoFILE(rs.getString("DS_SERVICO"));

                if (rs.getInt("ID_STATUS_SERVICO") == 0) {
                    s.setStatusServico(false);
                } else {
                    s.setStatusServico(true);
                }

                s.setDataServico(rs.getDate("DT_SERVICO_INICIO"));
                s.setDataServicoFim(rs.getDate("DT_SERVICO_INICIO"));
                lista.add(s);
            }
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DaoServico Listagem Java: " + ex.getMessage());
        }
        return lista;
    }

    public static boolean verificarServicoAtivo(int codigoServico) throws SQLException, ClassNotFoundException {
        int aux = 0;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT ID_STATUS_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoServico);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                aux = rs.getInt("ID_STATUS_SERVICO");
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (aux == 1) {
            return true;
        } else {
            return false;
        }

    }

    public void cadastrarServico(String cpfcnpj, ArrayList<Funcionario> lista, int codigoServico, String tipoServico, boolean tipoCliente, String descricaoServico, Date dataServico,
            boolean statusServico) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_SERVICO (CD_SERVICO, DS_TIPO_SERVICO, DS_TIPO_CLIENTE, DS_SERVICO, ID_STATUS_SERVICO, DT_SERVICO_INICIO, DT_SERVICO_FIM) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, codigoServico);

            int serv = 0;
            if (tipoServico.equals("Preventivo")) {
                serv = 0;
            } else if (tipoServico.equals("Corretivo")) {
                serv = 1;
            } else {
                serv = 2;
            }
            st.setInt(2, serv);

            int tipo;
            if (tipoCliente) {
                tipo = 1;
            } else {
                tipo = 0;
            }
            st.setInt(3, tipo);

            st.setString(4, descricaoServico);

            int status = 0;
            if (statusServico) {
                status = 1;
            } else {
                status = 0;
            }
            st.setInt(5, status);

            st.setDate(6, dataServico);
            st.setDate(7, dataServico);

            st.executeUpdate();

            sql = "INSERT INTO SYNCHROSOFT.TB_FUNC_SERVICO (CD_FUNCIONARIO, CD_SERVICO) VALUES (?,?)";
            PreparedStatement st2 = con.prepareStatement(sql);
            for (int i = 0; i < lista.size(); i++) {
                st2.setInt(1, lista.get(i).getCodigoFuncionario());
                st2.setInt(2, codigoServico);
                st2.executeUpdate();
            }

            if (tipoCliente) {
                sql = "INSERT INTO SYNCHROSOFT.TB_PESSOAF_SERVICO (CD_CPF, CD_SERVICO) VALUES (?,?)";
                PreparedStatement st3 = con.prepareStatement(sql);
                st3.setString(1, cpfcnpj);
                st3.setInt(2, codigoServico);
                st3.executeUpdate();
                st3.close();
            } else {
                sql = "INSERT INTO SYNCHROSOFT.TB_PESSOAJ_SERVICO (CD_CNPJ, CD_SERVICO) VALUES (?,?)";
                PreparedStatement st3 = con.prepareStatement(sql);
                st3.setString(1, cpfcnpj);
                st3.setInt(2, codigoServico);
                st3.executeUpdate();
                st3.close();
            }

            st.close();
            st2.close();

            JOptionPane.showMessageDialog(null, "Serviço ativado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Serviço.\n Erro SQL:\n\n" + ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Serviço.\n Erro JAVA:\n\n" + e.getMessage());
        }
    }

    public boolean existeServico(int codserv) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codserv);
        ResultSet rs = st.executeQuery();
        flag = rs.isBeforeFirst();
        st.close();
        rs.close();
        return flag;

    }

    public static boolean isFuncionarioEmServico(int codfunc) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        ArrayList<Long> arrayFunc = new ArrayList<>();
        int status = 0;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_FUNCIONARIO, CD_SERVICO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_FUNCIONARIO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codfunc);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            arrayFunc.add(rs.getLong("CD_SERVICO"));
        }
        for (int j = 0; j <= arrayFunc.size() - 1; j++) {
            sql = "SELECT ID_STATUS_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.setLong(1, arrayFunc.get(j));
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                status = rs2.getInt("ID_STATUS_SERVICO");
                if (status == 1) {
                    flag = true;
                }
            }
            st2.close();
            rs2.close();
        }
        st.close();
        rs.close();

        return flag;
    }

    public static String listarServicosDoFuncionario(int codigoServico) throws SQLException, ClassNotFoundException {
        String codigos = "";
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_SERVICO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_FUNCIONARIO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoServico);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            codigos = codigos + ", " + rs.getInt("CD_SERVICO");
        }
        st.close();
        rs.close();
        return codigos;
    }

    public static ArrayList funcionarioEmServico(int codigoServico) throws SQLException, ClassNotFoundException {
        ArrayList<Object> lista = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_FUNCIONARIO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoServico);
        ResultSet rs = st.executeQuery();
        rs.next();
        int aux = 0;
        aux = rs.getInt("CD_FUNCIONARIO");
        Funcionario f = new Funcionario();
        f = DaoFuncionario.popularFuncionario(aux);
        st.close();
        rs.close();

        lista.add(aux);
        lista.add(f);

        return lista;
    }

    public static void ativarDesativarServico(int codigoServico, boolean flag) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.conectar();
        String sql = "UPDATE SYNCHROSOFT.TB_SERVICO "
                + "SET ID_STATUS_SERVICO = ? "
                + "WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        if (flag) {
            st.setInt(1, 1);
        } else {
            st.setInt(1, 0);

        }

        st.setInt(2, codigoServico);
        st.executeUpdate();
        st.close();
        if (flag) {
            JOptionPane.showMessageDialog(null, "O Serviço foi ativado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "O Serviço foi desativado com sucesso!");
        }

    }

    public static ArrayList listarFuncionariosEmServico(int codigoServico) throws SQLException, ClassNotFoundException {
        ArrayList<Funcionario> lista = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_FUNCIONARIO, NM_FUNCIONARIO FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO IN (SELECT CD_FUNCIONARIO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_SERVICO = ?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoServico);
        ResultSet rs = st.executeQuery();
        String servFunc = "";
        while (rs.next()) {
            Pessoa p = new Pessoa();
            Funcionario f = new Funcionario();
            f.setCodigoFuncionario(rs.getInt("CD_FUNCIONARIO"));
            p.setNome(rs.getString("NM_FUNCIONARIO"));
            f.setPessoa(p);
            servFunc = listarServicosDoFuncionario(f.getCodigoFuncionario());

            servFunc = servFunc.substring(2);
            f.setCargo(servFunc);
            lista.add(f);
        }
        st.close();
        rs.close();

        return lista;
    }
}
