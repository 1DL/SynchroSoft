/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import dao.Conexao;
import java.sql.*;
import javax.swing.JFrame;
import view.FrmCadastroPeca;
import view.FrmListagemPeca;
import view.FrmPrincipal;
import dao.DaoPeca;
import view.FrmCadastroFuncionario;
import view.reserva.FrmCadastroFuncionario_Tabs;
import view.FrmCadastroPessoa;
import view.FrmListagemPessoaF;
import view.FrmLogin;

/**
 *
 * @author LuizV1
 */
public class SynchroSoft {

    /**
     * @param args the command line arguments
     */
    public static JFrame telaPrincipal;
    public static JFrame telaLogin;
    public static JFrame telaCadastroPeca;
    public static JFrame telaListagemPeca;
    public static JFrame telaCadastroFuncionario;
    public static void main(String[] args) {
        System.out.println("Hello, World3! Welcome to SynchroSoft!!! ");
        
        try{
        Connection con = Conexao.conectar();
        System.out.println("Conectado ao DB Oracle com sucesso!");
        } catch (ClassNotFoundException | SQLException sqlex) {
            System.out.println("Falha ao conectar no banco: "+sqlex);
        }
        
          telaLogin = new FrmLogin();
          telaLogin.setVisible(true);
        
        
        
    }
    
}
