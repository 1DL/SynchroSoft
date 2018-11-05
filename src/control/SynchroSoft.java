/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import javax.swing.JOptionPane;


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
    private static String codFunc = "Código Func";
    private static int nvlAdm = 1;
    private static boolean acesso = false;
    private static String nvlAcessoSTR = "";

    public static void main(String[] args) throws IOException {
        ManipularArquivos.lerArquivoJanelas();
        Janelas.abrirLogin();
    }

    public static void sairDoSistema() {
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

    public static String getCodFunc() {
        return codFunc;
    }

    public static void setCodFunc(String aCodFunc) {
        codFunc = aCodFunc;
    }

    public static int getNvlAdm() {
        return nvlAdm;
    }

    public static void setNvlAdm(int aNvlAdm) {
        nvlAdm = aNvlAdm;
    }

    public static boolean isAcesso() {
        if (nvlAdm == 0) {
            acesso = false;
        } else if (nvlAdm == 1) {
            acesso = true;
        }

        return acesso;
    }

    public static String getNvlAdmSTR() {
        if (nvlAdm == 0) {
            nvlAcessoSTR = "Visualização";
        } else if (nvlAdm == 1) {
            nvlAcessoSTR = "Administrador";
        }
        return nvlAcessoSTR;
    }

}
