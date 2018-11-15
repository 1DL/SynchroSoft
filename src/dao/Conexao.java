/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class Conexao {
    
    private static String serverName;
    private static String serverPort;
    private static String username;
    private static String password;
    private static String sid;
   
    
    public static Connection conectar() throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        
        String driverName = "oracle.jdbc.driver.OracleDriver";
        Class.forName(driverName);
        String url = "jdbc:oracle:thin:@"+ serverName + ":" + serverPort + ":" + sid;
        
        int retornoJOPane = 99;
        try{
            conn = DriverManager.getConnection(url, username, password);
        } catch(SQLException ex) {
            retornoJOPane = JOptionPane.showConfirmDialog(null, "<html>Erro ao acessar o banco de dados. <br><br>"
                    + "Verifique se o IP, porta, SID, usuário e senha do banco de dados "
                    + "estão corretos, e tente novamente.<br><br>"
                    + ex + "<br><br> Deseja encerrar o sistema?<br><br>", "Erro ao conectar no Banco de Dados", JOptionPane.YES_NO_OPTION, 0);
        }
        
        if (retornoJOPane == 0) {
            System.exit(0);
        }
        
        return conn;
    }

    public static String getServerName() {
        return serverName;
    }

    public static void setServerName(String aServerName) {
        serverName = aServerName;
    }

    public static String getServerPort() {
        return serverPort;
    }

    public static void setServerPort(String aServerPort) {
        serverPort = aServerPort;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String aUsername) {
        username = aUsername;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String aPassword) {
        password = aPassword;
    }

    public static String getSid() {
        return sid;
    }

    public static void setSid(String aSid) {
        sid = aSid;
    }
}
