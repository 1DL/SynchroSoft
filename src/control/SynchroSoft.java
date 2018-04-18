/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.sql.*;
import javax.swing.JFrame;
import view.FrmCadastroPeca;
import view.FrmListagemPeca;
import view.FrmPrincipal;
import dao.DaoPeca;

/**
 *
 * @author LuizV1
 */
public class SynchroSoft {

    /**
     * @param args the command line arguments
     */
    public static JFrame telaPrincipal;
    public static JFrame telaCadastroPeca;
    public static JFrame telaListagemPeca;
    public static void main(String[] args) {
        System.out.println("Hello, World3! Welcome to SynchroSoft!!! ");
        Connection conn = null;
        try{
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            String serverName = "localhost";
            String serverPort = "1521";
            String sid = "XE";
            String url = "jdbc:oracle:thin:@"+ serverName + ":" + serverPort + ":" + sid;
            String username = "system";
            String password = "system";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado ao DB Oracle com sucesso!");
        } catch(ClassNotFoundException e) {
            System.out.println("Não foi possível achar o driver do banco de dados. "+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados. "+ e.getMessage());
        }
        
//        try {
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM SYNCHROSOFT.TB_PECA");
//            while (rs.next()){
//                System.out.println(""+rs.getString("NM_PECA"));
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
//        telaPrincipal = new FrmPrincipal();
//        telaPrincipal.setVisible(true);
        telaListagemPeca = new FrmListagemPeca();
        telaListagemPeca.setVisible(true);
        
        DaoPeca d = new DaoPeca();
        d.listarPeca();
        
        
        
    }
    
}
