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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Funcionario;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Servico;

/**
 *
 * @author LuizV1
 */
public class DaoServico {

    public static boolean cadastrarServico(Servico servico) {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_SERVICO "
                    + "(CD_SERVICO, DS_TIPO_SERVICO, DS_TIPO_CLIENTE, DS_SERVICO, ID_STATUS_SERVICO, DT_SERVICO_INICIO, DT_SERVICO_FIM) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, servico.getCodigoServico());
            st.setInt(2, servico.getTipoServicoBanco());
            st.setInt(3, servico.getTipoClienteBanco());
            st.setString(4, servico.getDescricaoServicoFILE());
            st.setInt(5, servico.getStatusServico());
            st.setDate(6, Date.valueOf(control.Datas.converterParaAmericana(servico.getDataServico())));
            st.setDate(7, null);

            st.executeUpdate();

            sql = "INSERT INTO SYNCHROSOFT.TB_FUNC_SERVICO (CD_FUNCIONARIO, CD_SERVICO) VALUES (?,?)";
            PreparedStatement st2 = con.prepareStatement(sql);
            for (int i = 0; i < servico.getListaFuncionario().size(); i++) {
                st2.setString(1, servico.getListaFuncionario().get(i).getCodigoFuncionario());
                st2.setString(2, servico.getCodigoServico());
                st2.executeUpdate();
            }

            if (servico.getTipoClienteBanco() == 0) {
                sql = "INSERT INTO SYNCHROSOFT.TB_PESSOAF_SERVICO (CD_CPF, CD_SERVICO) VALUES (?,?)";
                PreparedStatement st3 = con.prepareStatement(sql);
                st3.setString(1, servico.getCnpjCliente());
                st3.setString(2, servico.getCodigoServico());
                st3.executeUpdate();
                st3.close();
            } else {
                sql = "INSERT INTO SYNCHROSOFT.TB_PESSOAJ_SERVICO (CD_CNPJ, CD_SERVICO) VALUES (?,?)";
                PreparedStatement st3 = con.prepareStatement(sql);
                st3.setString(1, servico.getCnpjCliente());
                st3.setString(2, servico.getCodigoServico());
                st3.executeUpdate();
                st3.close();
            }
            
            sql = "INSERT INTO SYNCHROSOFT.TB_ENDERECO_SERVICO (CD_CEP, CD_SERVICO) VALUES (?,?)";
            PreparedStatement st4 = con.prepareStatement(sql);
            
            st4.setString(1, servico.getEndereco().getCep());
            st4.setString(2, servico.getCodigoServico());
            st4.executeUpdate();
            
            st.close();
            st2.close();
            st4.close();

            JOptionPane.showMessageDialog(null, "Serviço cadastrado e ativado com sucesso!", "Cadastro concluído", 1);
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o serviço.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoServico - Cadastrar Serviço", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoServico.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static ArrayList listarServico() {
        ArrayList<Servico> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO ORDER BY CD_SERVICO";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Servico s = new Servico();

                s.setCodigoServico(rs.getString("CD_SERVICO"));
                s.setTipoServico(rs.getInt("DS_TIPO_SERVICO"));
                s.setTipoClienteBanco(rs.getInt("DS_TIPO_CLIENTE"));
                s.setDescricaoServicoFILE(rs.getString("DS_SERVICO"));
                s.setStatusServicoBanco(rs.getInt("ID_STATUS_SERVICO"));
                s.setDataServico(rs.getDate("DT_SERVICO_INICIO").toString());
                s.setDataServicoFim(rs.getDate("DT_SERVICO_INICIO").toString());

                lista.add(s);
            }
            st.close();
            rs.close();

            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível criar a lista de serviços.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoServico - Listar Serviço", 0);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoServico.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void alterarFuncionarioServico(ArrayList<Funcionario> lista, String codigoServico) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.conectar();
        String sql = "DELETE FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, codigoServico);
        st.executeUpdate();
        st.close();
        sql = "INSERT INTO SYNCHROSOFT.TB_FUNC_SERVICO (CD_FUNCIONARIO, CD_SERVICO) VALUES (?,?)";
        PreparedStatement st2 = con.prepareStatement(sql);
        for (int i = 0; i < lista.size(); i++) {
            st2.setString(1, lista.get(i).getCodigoFuncionario());
            st2.setString(2, codigoServico);
            st2.executeUpdate();
        }
        st2.close();

    }

    public static void deletarServico(Servico s) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.conectar();
        String sql = "DELETE FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, s.getCodigoServico());
        st.executeUpdate();
        st.close();

        sql = "DELETE FROM SYNCHROSOFT.TB_PESSOAF_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st2 = con.prepareStatement(sql);
        st2.setString(1, s.getCodigoServico());
        st2.executeUpdate();
        st2.close();

        sql = "DELETE FROM SYNCHROSOFT.TB_PESSOAJ_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st3 = con.prepareStatement(sql);
        st3.setString(1, s.getCodigoServico());
        st3.executeUpdate();
        st3.close();

        sql = "DELETE FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st4 = con.prepareStatement(sql);
        st4.setString(1, s.getCodigoServico());
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
        st.setInt(1, s.getTipoServicoBanco());
        st.setInt(2, s.getTipoClienteBanco());

        st.setString(3, s.getDescricaoServicoFILE());
        st.setDate(4, Date.valueOf(control.Datas.converterParaAmericana(s.getDataServico())));
        st.setDate(5, Date.valueOf(control.Datas.converterParaAmericana(s.getDataServicoFim())));
        st.setString(6, s.getCodigoServico());
        st.executeUpdate();
        st.close();

        alterarFuncionarioServico(lista, s.getCodigoServico());

        if (tipoPessoa) {
            sql = "UPDATE SYNCHROSOFT.TB_PESSOAF_SERVICO "
                    + "SET CD_CPF = ?"
                    + "WHERE CD_SERVICO = ?";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.setString(1, cpfcnpj);
            st2.setString(2, s.getCodigoServico());
            st2.executeUpdate();
            st2.close();

        } else {
            sql = "UPDATE SYNCHROSOFT.TB_PESSOAJ_SERVICO "
                    + "SET CD_CNPJ = ?"
                    + "WHERE CD_SERVICO = ?";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.setString(1, cpfcnpj);
            st2.setString(2, s.getCodigoServico());
            st2.executeUpdate();
            st2.close();
        }

        JOptionPane.showMessageDialog(null, "Serviço alterado com sucesso!");

    }

    public static ArrayList popularListaServicoDetalhada(String codigoServico, int tipoCliente) throws ClassNotFoundException {
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
                st.setString(1, codigoServico);
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
                st.setString(1, codigoServico);
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

    public static ArrayList listarServicoFiltrada(String cmbFiltro, String txtPesquisa, String dataDe, String dataAte) {
        ArrayList<Servico> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "";
            /*
Código Serviço
Tipo Serviço
Serviço Ativo?
Data Início
Data Encerramento
Data Início Entre/Até
Data Encerramento Entre/Até
             */

            switch (cmbFiltro) {
                case "Código Serviço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO WHERE LOWER(CD_SERVICO) LIKE LOWER(?)";
                    break;
                case "Serviço Ativo?":
                    txtPesquisa = txtPesquisa.substring(0, 1);
                    if (txtPesquisa.equals("s")) {
                        txtPesquisa = "1";
                    } else if (txtPesquisa.equals("n")) {
                        txtPesquisa = "0";
                    }
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO WHERE LOWER(ID_STATUS_SERVICO) LIKE LOWER(?)";
                    break;
                case "Tipo Serviço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO WHERE LOWER(DS_TIPO_SERVICO) LIKE LOWER(?)";
                    break;
                case "Data Início":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO "
                            + "WHERE DT_SERVICO_INICIO = TO_DATE(?, 'yyyy-mm-dd')";
                    break;
                case "Data Encerramento":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO "
                            + "WHERE DT_SERVICO_FIM = TO_DATE(?, 'yyyy-mm-dd')";
                    break;
                case "Data Início Entre/Até":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO "
                            + "WHERE DT_SERVICO_INICIO BETWEEN TO_DATE(?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd')";
                    break; 
                case "Data Encerramento Entre/Até":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_SERVICO "
                        + "WHERE DT_SERVICO_FIM BETWEEN TO_DATE(?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd')";
                    break;    
            }
            PreparedStatement st = con.prepareStatement(sql);
            
            if (cmbFiltro.equals("Data Início") || cmbFiltro.equals("Data Encerramento")) {
                try {
                    dataDe = control.Datas.converterParaAmericana(dataDe);

                } catch (Exception ex) {

                }
                st.setString(1, dataDe);
            } else if (cmbFiltro.equals("Data Início Entre/Até") || cmbFiltro.equals("Data Encerramento Entre/Até")) {
                try {
                    dataDe = control.Datas.converterParaAmericana(dataDe);
                    dataAte = control.Datas.converterParaAmericana(dataAte);
                } catch (Exception ex) {

                }
                st.setString(1, dataDe);
                st.setString(2, dataAte);
            } else {
                st.setString(1, "%" + txtPesquisa + "%");
            }
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Servico s = new Servico();
                s.setCodigoServico(rs.getString("CD_SERVICO"));
                s.setTipoServico(rs.getInt("DS_TIPO_SERVICO"));
                s.setTipoClienteBanco(rs.getInt("DS_TIPO_CLIENTE"));
                s.setDescricaoServicoFILE(rs.getString("DS_SERVICO"));
                s.setStatusServicoBanco(rs.getInt("ID_STATUS_SERVICO"));
                s.setDataServico(rs.getDate("DT_SERVICO_INICIO").toString());
                s.setDataServicoFim(rs.getDate("DT_SERVICO_INICIO").toString());
                lista.add(s);
            }
            st.close();
            rs.close();
            
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os serviços via filtro.\n\nErro Nº:"
                    + ex.getErrorCode()+"\n"+ex.getMessage(), "Erro: DaoServico - Listar Serviços Filtrado",0);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoServico.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean verificarServicoAtivo(String codigoServico) {
        int aux = 0;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT ID_STATUS_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigoServico);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                aux = rs.getInt("ID_STATUS_SERVICO");
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (aux == 1) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean existeServico(String codserv) {
        boolean flag = false;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codserv);
            ResultSet rs = st.executeQuery();
            flag = rs.isBeforeFirst();
            st.close();
            rs.close();
            return flag;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível verificar a existência do serviço.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoServico - Existe Serviço", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoServico.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean isFuncionarioEmServico(String codfunc) {
        boolean flag = false;
        try {
            ArrayList<String> arrayFunc = new ArrayList<>();
            int status = 0;
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_FUNCIONARIO, CD_SERVICO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_FUNCIONARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codfunc);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                arrayFunc.add(rs.getString("CD_SERVICO"));
            }
            for (int j = 0; j <= arrayFunc.size() - 1; j++) {
                sql = "SELECT ID_STATUS_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
                PreparedStatement st2 = con.prepareStatement(sql);
                st2.setString(1, arrayFunc.get(j));
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível verificar a se o Funcionário já está alocado em algum serviço.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoServico - Is Funcionario Em Serviço", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoServico.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static String listarServicosDoFuncionario(String codFunc) {
        String codigos = ""; 
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_SERVICO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_FUNCIONARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codFunc);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                codigos = codigos + ", " + rs.getString("CD_SERVICO");
            }
            st.close();
            rs.close();
            return codigos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível verificar a se o Funcionário já está alocado em algum serviço.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoServico - Listar servicos do Funcionario", 0);
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível verificar a se o Funcionário já está alocado em algum serviço.\n\nErro: "
                    + ex.getMessage(), "Erro: DaoServico - Listar servicos do Funcionario", 0);
            return null;
        }
    }

    public static ArrayList funcionarioEmServico(int codigoServico) throws SQLException, ClassNotFoundException {
        ArrayList<Object> lista = new ArrayList<>();
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_FUNCIONARIO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoServico);
        ResultSet rs = st.executeQuery();
        rs.next();
        String aux = "";
        aux = rs.getString("CD_FUNCIONARIO");
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
            st.setInt(1, 0);
        } else {
            st.setInt(1, 1);

        }

        st.setInt(2, codigoServico);
        st.executeUpdate();
        st.close();

    }

    public static ArrayList listarFuncionariosEmServico(String codigoServico) {
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_FUNCIONARIO, NM_FUNCIONARIO FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO IN (SELECT CD_FUNCIONARIO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_SERVICO = ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigoServico);
            ResultSet rs = st.executeQuery();
            String servFunc = "";
            while (rs.next()) {
                Pessoa p = new Pessoa();
                Funcionario f = new Funcionario();
                f.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível criar a lista de Funcionários em serviço..\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoServico - Listar Funcionarios Em Serviço", 0);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoServico.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
