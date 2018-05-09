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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FrmLogin;
import view.FrmPrincipal;

/**
 *
 * @author Luiz
 */
public class DaoUsuario {
    
    public void cadastrarUsuario(int CodFunc, String login, String senha) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_USUARIO (CD_FUNCIONARIO, DS_LOGIN, DS_SENHA) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, CodFunc);
            st.setString(2, login);
            st.setString(3, senha);
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o login do usuário.\n Erro SQL:\n\n" + ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o login do usuário.\n Erro JAVA:\n\n" + e.getMessage());
        }
    }
    
    public static boolean ChecarLogin(String login, String senha)
    {
        //criando variável booleana de controle
        boolean existe = false;
        
        //estrutura try/catch para tratamento de erro
        try
        {
            //chamada de conexão com o banco
            Connection con = Conexao.conectar();
            
            //Criando string de query para realizar verificação de existencia do login
            String sql = "SELECT DS_LOGIN, DS_SENHA FROM SYNCHROSOFT.TB_USUARIO WHERE DS_LOGIN = ? AND DS_SENHA = ?";
            
            //Criando estrutura do preparedStatement, evitar sql inject
            PreparedStatement st = con.prepareStatement(sql);
            
            //Realizando passagem por parâmetro da condicional da query
            st.setString(1, login);
            st.setString(2, senha);
            
            //Executando linha de comando
            ResultSet rs = st.executeQuery();
            
            //Executando verificação de existencia de resultado da query
            while(rs.next())
            {
                if (login.equals(rs.getString("DS_LOGIN")))
                {
                        if(senha.equals(rs.getString("DS_SENHA")))
                        {
                            existe = true;
                        }
                }
            }
            
            st.close();
            rs.close();
        }
        catch(Exception ex)
        {
            System.out.println("Erro: " + ex.getMessage());
        }
        
        return existe;
    }
    
     public static ArrayList listarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_USUARIO ORDER BY CD_USUARIO";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setCodigoUsuario(rs.getInt("CD_USUARIO"));
                user.setCodigoFuncionario(rs.getInt("CD_FUNCIONARIO"));
                user.setLogin(rs.getString("DS_LOGIN"));
                user.setSenha(rs.getString("DS_SENHA"));
                lista.add(user);
            }
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DaoUsuario Listagem Java: " + ex.getMessage());
        }
        return lista;
    }
     
     public void deletarUsuario(int cod) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_USUARIO WHERE CD_USUARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cod);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover usuário.\nErro:\n\n" + ex.getMessage());
        }
    }
    
}
