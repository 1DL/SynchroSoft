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
     * @param args the command line arguments
     */
    private static String versao = "1.0";
    private static String nomeUsuario = "Teste";
    private static int codFunc = 0;
    private static int nvlAdm = 1;

    //Métodos para chamada de telas. Telas de Sistema

    public static void abrirLogin() {
        FrmLogin telaLogin = new FrmLogin();
        telaLogin.setVisible(true);
    }

    public static void abrirPrincipal() {
        FrmPrincipal telaPrin = new FrmPrincipal();
        telaPrin.setVisible(true);
    }
    
    //Telas de Cadastro
    
    

    public static void abrirCadastroServico() {
//        for (Frame fr : Frame.getFrames()) {
//            if (fr.getClass().getName().equals("view.FrmCadastroServico")) {
//                JOptionPane.showMessageDialog(null, "Já existe uma janela de Cadastro de Serviço aberta.");
//                fr.setVisible(true);
//                fr.toFront();
//                
//            }
//        }
        FrmCadastroServico telaCadServ = new FrmCadastroServico(nvlAdm);
        telaCadServ.setVisible(true);
    }
    
    public static void abrirCadastroPessoa() {
        FrmCadastroPessoa telaCadPessoa = new FrmCadastroPessoa(nvlAdm);
        telaCadPessoa.setVisible(true);
    }
    
    public static void abrirCadastroProduto() {
        FrmCadastroPeca telaCadProduto = new FrmCadastroPeca(nvlAdm);
        telaCadProduto.setVisible(true);
    }
    
    public static void abrirCadastroFuncionário() {
        FrmCadastroFuncionario telaCadFunc = new FrmCadastroFuncionario(nvlAdm);
        telaCadFunc.setVisible(true);
    }
    
    
    public static void abrirCadastroDespesa() {
        FrmCadastroDespesa telaCadDesp = new FrmCadastroDespesa(nvlAdm);
        telaCadDesp.setVisible(true);
    }
    
    public static void abrirCadastroUsuario() {
        FrmCadastroUsuario telaCadUsuario = new FrmCadastroUsuario(nvlAdm);
        telaCadUsuario.setVisible(true);
    }
    
    public static void abrirCadastroOrçamento() {
        FrmCadastroOrcamento telaCadOrc = new FrmCadastroOrcamento(nvlAdm);
        telaCadOrc.setVisible(true);
    }
    
    public static void abrirCadastroEndereco() {
        FrmCadastroEndereco telaCadEnd = new FrmCadastroEndereco(nvlAdm);
        telaCadEnd.setVisible(true);
    }
    
    //Telas de Listagem
    
    public static void abrirListagemServico() {
        FrmListagemServico telaListaServ = new FrmListagemServico(nvlAdm);
        telaListaServ.setVisible(true);
    }
    
    public static void abrirListagemPessoaFisica() {
        FrmListagemPessoaF telaListaPessoa = new FrmListagemPessoaF(nvlAdm);
        telaListaPessoa.setVisible(true);
    }
    
    public static void abrirListagemPessoaJuridica() {
        FrmListagemPessoaJ telaListaPessoa = new FrmListagemPessoaJ(nvlAdm);
        telaListaPessoa.setVisible(true);
    }
    
    public static void abrirListagemProduto() {
        FrmListagemPeca telaListaProduto = new FrmListagemPeca(nvlAdm);
        telaListaProduto.setVisible(true);
    }
    
    public static void abrirListagemFuncionario() {
        FrmListagemFuncionario telaListaFunc = new FrmListagemFuncionario(nvlAdm);
        telaListaFunc.setVisible(true);
    }
    
    
    public static void abrirListagemDespesa() {
        FrmListagemDespesa telaListaDesp = new FrmListagemDespesa(nvlAdm);
        telaListaDesp.setVisible(true);
    }
    
    public static void abrirListagemUsuario() {
        FrmListagemUsuario telaListaUsuario = new FrmListagemUsuario(nvlAdm);
        telaListaUsuario.setVisible(true);
    }
    
    public static void abrirListagemOrçamento() throws SQLException, ClassNotFoundException {
        FrmListagemOrcamento telaListaOrc = new FrmListagemOrcamento(nvlAdm);
        telaListaOrc.setVisible(true);
    }
    
    public static void abrirListagemEndereco() {
        FrmListagemEndereco telaListaEnd = new FrmListagemEndereco(nvlAdm);
        telaListaEnd.setVisible(true);
    }
    
    //Telas de Vendas
    
    public static void abrirVendaPeca(){
        FrmVendaPeca telaVendaPeca = new FrmVendaPeca(nvlAdm);
        telaVendaPeca.setVisible(true);
    }
    
    //Telas de Ajuda
    
    public static void abrirSobre(){
        FrmSobre telaSobre = new FrmSobre();
        telaSobre.setVisible(true);
    }
    
    
    

    public static void main(String[] args) {
        System.out.println("Hello, World3! Welcome to SynchroSoft!!! ");

        try {
            Connection con = Conexao.conectar();
            System.out.println("Conectado ao DB Oracle com sucesso!");
        } catch (ClassNotFoundException | SQLException sqlex) {
            System.out.println("Falha ao conectar no banco: " + sqlex);
        }
        abrirLogin();
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

}
