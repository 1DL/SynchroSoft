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
import java.util.ArrayList;
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
    
    private static String versao = "1.0";
    private static String nomeUsuario = "Teste";
    private static int codFunc = 0;
    private static int nivelAdm = 1;
    
    
    
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

    public static String getVersao() {
        return versao;
    }

    public static String getNomeUsuario() {
        return nomeUsuario;
    }

    public static void setNomeUsuario(String aNomeUsuario) {
        nomeUsuario = aNomeUsuario;
    }

    public static int getCodFunc() {
        return codFunc;
    }

    public static void setCodFunc(int aCodFunc) {
        codFunc = aCodFunc;
    }

    public static int getNivelAdm() {
        return nivelAdm;
    }

    public static void setNivelAdm(int aNivelAdm) {
        nivelAdm = aNivelAdm;
    }
    
}
