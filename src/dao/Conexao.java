/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;

/**
 *
 * @author Luiz
 */
public class Conexao {
    
    public static Connection conectar() throws SQLException, ClassNotFoundException {
        
        Connection conn = null;
        
        String driverName = "oracle.jdbc.driver.OracleDriver";
        Class.forName(driverName);
        String serverName = "localhost";
        String serverPort = "1521";
        String sid = "XE";
        String url = "jdbc:oracle:thin:@"+ serverName + ":" + serverPort + ":" + sid;
        String username = "system";
        String password = "system";
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}
