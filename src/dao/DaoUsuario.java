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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.FrmLogin;
import view.FrmPrincipal;

/**
 *
 * @author Luiz
 */
public class DaoUsuario {
    
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
    
}
