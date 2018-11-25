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
import javax.swing.JTable;
import model.Usuario;

/**
 *
 * @author Luiz
 */
public class DaoUsuario {

    public static boolean cadastrarUsuario(Usuario usuario) {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_USUARIO (CD_USUARIO, CD_FUNCIONARIO, DS_SENHA) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, usuario.getLogin());
            st.setString(2, usuario.getCodigoFuncionario());
            st.setString(3, usuario.getSenha());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastro de Usuário", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Usuário.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoUsuario - Cadastrar Usuário", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Método de conexão do sistema com o Banco de dados. O funcionário deverá
     * inserir seu login e senha.
     *
     * @param login String
     * @param senha String
     * @return 0 - caso a conexão seja bem sucedida. 1 - caso o login e/ou senha
     * estão errados. 2 - caso os parâmetros do banco de dados estejam errados.
     */
    public static int ChecarLogin(String login, String senha) {
        //criando variável booleana de controle
        boolean existe = false;
        int retorno = 1;
        String codFuncionario;

        //estrutura try/catch para tratamento de erro
        try {
            //chamada de conexão com o banco
            Connection con = Conexao.conectar();

            //Criando string de query para realizar verificação de existencia do login
            String sql = "SELECT CD_FUNCIONARIO, CD_USUARIO, DS_SENHA FROM SYNCHROSOFT.TB_USUARIO WHERE CD_USUARIO = ? AND DS_SENHA = ?";

            //Criando estrutura do preparedStatement, evitar sql inject
            PreparedStatement st = con.prepareStatement(sql);

            //Realizando passagem por parâmetro da condicional da query
            st.setString(1, login);
            st.setString(2, senha);

            //Executando linha de comando
            ResultSet rs = st.executeQuery();

            //Executando verificação de existencia de resultado da query
            while (rs.next()) {
                if (login.equals(rs.getString("CD_USUARIO"))) {
                    if (senha.equals(rs.getString("DS_SENHA"))) {
                        existe = true;
                        codFuncionario = rs.getString("CD_FUNCIONARIO");
                        logarUsuario(existe, codFuncionario);
                        retorno = 0;
                    }
                }
            }

            st.close();
            rs.close();

        } catch (Exception ex) {
            retorno = 2;
            System.out.println("Erro: " + ex.getMessage());
        }

        return retorno;
    }

    public static void logarUsuario(boolean existe, String codigoFuncionario) {
        if (existe) {
            try {
                Connection con = Conexao.conectar();
                String sql = "SELECT cd_funcionario, nm_funcionario, id_administrativo "
                        + "FROM SYNCHROSOFT.TB_FUNCIONARIO "
                        + "WHERE cd_funcionario = ?";
                PreparedStatement st = con.prepareStatement(sql);

                st.setString(1, codigoFuncionario);

                ResultSet rs = st.executeQuery();
                rs.next();

                control.SynchroSoft.setCodFunc(rs.getString("cd_funcionario"));
                control.SynchroSoft.setNomeUsuario(rs.getString("nm_funcionario"));
                control.SynchroSoft.setNvlAdm(rs.getInt("id_administrativo"));

                st.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, "Erro ao acessar dados de usuário no banco de dados.\n\nErro Nº" + ex.getErrorCode() + ""
                        + "\n" + ex.getMessage(),
                        "Erro de Banco de Dados - DaoUsuario Logar Usuario", 0);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean existeLogin(String login) {
        boolean flag;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_USUARIO "
                    + "FROM SYNCHROSOFT.TB_USUARIO "
                    + "WHERE CD_USUARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, login);
            ResultSet rs = st.executeQuery();
            flag = rs.isBeforeFirst();
            st.close();
            rs.close();
            return flag;
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao verificar se o Login já existe.\n\nErro Nº" + ex.getErrorCode() + ""
                    + "\n" + ex.getMessage(),
                    "Erro: DaoUsuario - Existe Login", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static ArrayList listarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * "
                    + "FROM SYNCHROSOFT.TB_USUARIO "
                    + "ORDER BY CD_USUARIO";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                //user.setCodigoUsuario(rs.getInt("CD_USUARIO"));
                user.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
                user.setLogin(rs.getString("CD_USUARIO"));
                user.setSenha(rs.getString("DS_SENHA"));
                lista.add(user);
            }
            st.close();
            rs.close();
            
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao acessar dados de usuário no banco de dados.\n\nErro Nº: "
                    +ex.getErrorCode()+"\n"+ex.getMessage(),"Erro : DaoUsuario - Listar Usuário",0);
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao acessar dados de usuário no banco de dados.\n\nErro: "
                    +ex,"Erro : DaoUsuario - Listar Usuário",0);
        }
        return lista;
    }

    public static void deletarUsuario(String login) {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_USUARIO "
                    + "WHERE CD_USUARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, login);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso.", "Remoção concluída", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover usuário.\n\nErro Nº:"
                +ex.getErrorCode()+"\n"+ex.getMessage(), "Erro: DaoUsuario - Deletar Usuário", 0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover usuário.\n\nErro:"
                +ex, "Erro: DaoUsuario - Deletar Usuário", 0);
        }
    }
    
    public static boolean deletarTodosUsuarios() {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_USUARIO";
            PreparedStatement st = con.prepareStatement(sql);
    
            st.executeUpdate();
            st.close();
            
            JOptionPane.showMessageDialog(null, "Todos os registros de Usuários foram removidos do banco de dados.",
                    "Exclusão total concluída", 1);
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover os usuários.\n\nErro Nº :"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro : DaoUsuario - Deletar Todos Usuários", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover os usuários.\n\nErro:"
                    + ex, "Erro : DaoUsuario - Deletar Todos Usuários", 0);
            return false;
        }
    }

    public static boolean alterarUsuario(Usuario usuario, String PK_REF) {
        try {
            Connection con = Conexao.conectar();
            String sql = "UPDATE SYNCHROSOFT.TB_USUARIO "
                    + "SET CD_FUNCIONARIO = ?, CD_USUARIO = ?, "
                    + "DS_SENHA = ? WHERE CD_USUARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, usuario.getCodigoFuncionario());
            st.setString(2, usuario.getLogin());
            st.setString(3, usuario.getSenha());
            st.setString(4, PK_REF);

            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "O usuário foi alterado com sucesso!", "Alteração concluída", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar o usuário.\n\nErro Nº: "
                    +ex.getErrorCode()+"\n"+ex.getMessage(), "Erro: DaoUsuario - Alterar Usuário", 0);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar o usuário.\n\nErro: "
                    +ex, "Erro: DaoUsuario - Alterar Usuário", 0);            
            return false;
        }

    }

    public static Usuario popularUsuario(String login) {
        try {
            Connection con = Conexao.conectar();

            String sql = "SELECT * "
                    + "FROM SYNCHROSOFT.TB_USUARIO "
                    + "WHERE CD_USUARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, login);
            ResultSet rs = st.executeQuery();

            rs.next();

            Usuario usuario = new Usuario();

            usuario.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
            usuario.setLogin(rs.getString("CD_USUARIO"));
            usuario.setSenha(rs.getString("DS_SENHA"));

            st.close();
            rs.close();
            return usuario;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao popular o usuário.\n\nErro Nº: "
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoUsuario - Popular Usuário", 0);
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao popular o usuário.\n\nErro: "
                    + ex, "Erro: DaoUsuario - Popular Usuário", 0);
            return null;
        }
    }

    public static ArrayList listarUsuarioFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "";
            /*
Código", "Codigo do Funcionário", "Login", "Senha            
             */

            switch (cmbFiltro) {
//                case "Código":
//                    sql = "SELECT * FROM SYNCHROSOFT.TB_USUARIO WHERE LOWER(CD_USUARIO) LIKE LOWER(?)";
//                    break;
                case "Código do Funcionário":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_USUARIO WHERE LOWER(CD_FUNCIONARIO) LIKE LOWER(?)";
                    break;
                case "Login":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_USUARIO WHERE LOWER(CD_USUARIO) LIKE LOWER(?)";
                    break;
                case "Senha":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_USUARIO WHERE LOWER(DS_SENHA) LIKE LOWER(?)";
                    break;
            }
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + txtPesquisa + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                //u.setCodigoUsuario(rs.getInt("CD_USUARIO"));
                u.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
                u.setLogin(rs.getString("CD_USUARIO").toString());
                u.setSenha(rs.getString("DS_SENHA"));
                lista.add(u);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuários via filtro.\n\nErro nº:" 
                    +ex.getErrorCode()+"\n\n"+ex.getMessage(),"Erro: DaoUsuário - Listar Usuário Filtrado", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
