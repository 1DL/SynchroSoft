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
import java.awt.Frame;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.FrmCadastroDespesa;
import view.FrmCadastroEndereco;
import view.FrmCadastroFuncionario;
import view.FrmCadastroOrcamento;
import view.reserva.FrmCadastroFuncionario_Tabs;
import view.FrmCadastroPessoa;
import view.FrmCadastroServico;
import view.FrmCadastroUsuario;
import view.FrmListagemDespesa;
import view.FrmListagemEndereco;
import view.FrmListagemFuncionario;
import view.FrmListagemOrcamento;
import view.FrmListagemPessoaF;
import view.FrmListagemPessoaJ;
import view.FrmListagemServico;
import view.FrmListagemUsuario;
import view.FrmLogin;
import view.FrmSobre;
import view.FrmVendaPeca;

/**
 *
 * @author LuizV1
 */
public class SynchroSoft {

    /**
     * @param args the command line arguments .
     */
    private static String versao = "1.0";
    private static String nomeUsuario = "Teste";
    private static int codFunc = 0;
    private static int nvlAdm = 1;
    private static boolean acesso = false;

    

    public static void main(String[] args) throws IOException {

        LeitorArquivo.lerArquivoJanelas();
        Janelas.abrirLogin();
    }
    
    public static void sairDoSistema(){
        int aux;
        aux = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?\n"
                + "\nAviso! Todas as janelas serão fechadas e os dados não salvos serão perdidos.", "Sair do Sistema", JOptionPane.YES_NO_OPTION);
        if (aux == 0) {
            System.exit(0);
        }
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

    public static int getNvlAdm() {
        return nvlAdm;
    }

    public static void setNvlAdm(int aNvlAdm) {
        nvlAdm = aNvlAdm;
    }

    public static boolean isAcesso() {
        return acesso;
    }

    public static void setAcesso() {
        if (nvlAdm == 0) {
            acesso = false;
        } else if (nvlAdm == 1) {
            acesso = true;
        }
    }

    
}
