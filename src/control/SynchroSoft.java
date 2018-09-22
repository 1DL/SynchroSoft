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
     * .
     */
    private static String versao = "1.0";
    private static String nomeUsuario = "Teste";
    private static int codFunc = 0;
    private static int nvlAdm = 1;
    
    public static ArrayList<Integer> acessoTelas = new ArrayList<>();
    

   

    public static void main(String[] args) {
        LeitorArquivo.lerArquivo();
        abrirLogin();
    }
    
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
        FrmCadastroServico telaCadServ = new FrmCadastroServico(nvlAdm);
        telaCadServ.setVisible(true);
        acessoTelas.set(0, acessoTelas.get(0) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirCadastroPessoa() {
        FrmCadastroPessoa telaCadPessoa = new FrmCadastroPessoa(nvlAdm);
        telaCadPessoa.setVisible(true);
        acessoTelas.set(1,acessoTelas.get(1) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirCadastroProduto() {
        FrmCadastroPeca telaCadProduto = new FrmCadastroPeca(nvlAdm);
        telaCadProduto.setVisible(true);
        acessoTelas.set(2,acessoTelas.get(2) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirCadastroFuncionário() {
        FrmCadastroFuncionario telaCadFunc = new FrmCadastroFuncionario(nvlAdm);
        telaCadFunc.setVisible(true);
        acessoTelas.set(3,acessoTelas.get(3) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    
    public static void abrirCadastroDespesa() {
        FrmCadastroDespesa telaCadDesp = new FrmCadastroDespesa(nvlAdm);
        telaCadDesp.setVisible(true);
        acessoTelas.set(4,acessoTelas.get(4) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirCadastroUsuario() {
        FrmCadastroUsuario telaCadUsuario = new FrmCadastroUsuario(nvlAdm);
        telaCadUsuario.setVisible(true);
        acessoTelas.set(5,acessoTelas.get(5) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirCadastroOrçamento() {
        FrmCadastroOrcamento telaCadOrc = new FrmCadastroOrcamento(nvlAdm);
        telaCadOrc.setVisible(true);
    }
    
    public static void abrirCadastroEndereco() {
        FrmCadastroEndereco telaCadEnd = new FrmCadastroEndereco(nvlAdm);
        telaCadEnd.setVisible(true);
        acessoTelas.set(6,acessoTelas.get(6) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    //Telas de Listagem
    
    public static void abrirListagemServico() {
        FrmListagemServico telaListaServ = new FrmListagemServico(nvlAdm);
        telaListaServ.setVisible(true);
        acessoTelas.set(7,acessoTelas.get(7) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirListagemPessoaFisica() {
        FrmListagemPessoaF telaListaPessoa = new FrmListagemPessoaF(nvlAdm);
        telaListaPessoa.setVisible(true);
        acessoTelas.set(8,acessoTelas.get(8) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirListagemPessoaJuridica() {
        FrmListagemPessoaJ telaListaPessoa = new FrmListagemPessoaJ(nvlAdm);
        telaListaPessoa.setVisible(true);
        acessoTelas.set(9,acessoTelas.get(9) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirListagemProduto() {
        FrmListagemPeca telaListaProduto = new FrmListagemPeca(nvlAdm);
        telaListaProduto.setVisible(true);
        acessoTelas.set(10,acessoTelas.get(10) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirListagemFuncionario() {
        FrmListagemFuncionario telaListaFunc = new FrmListagemFuncionario(nvlAdm);
        telaListaFunc.setVisible(true);
        acessoTelas.set(11,acessoTelas.get(11) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    
    public static void abrirListagemDespesa() {
        FrmListagemDespesa telaListaDesp = new FrmListagemDespesa(nvlAdm);
        telaListaDesp.setVisible(true);
        acessoTelas.set(12,acessoTelas.get(12) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirListagemUsuario() {
        FrmListagemUsuario telaListaUsuario = new FrmListagemUsuario(nvlAdm);
        telaListaUsuario.setVisible(true);
        acessoTelas.set(13,acessoTelas.get(13) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    public static void abrirListagemOrçamento() throws SQLException, ClassNotFoundException {
        FrmListagemOrcamento telaListaOrc = new FrmListagemOrcamento(nvlAdm);
        telaListaOrc.setVisible(true);
    }
    
    public static void abrirListagemEndereco() {
        FrmListagemEndereco telaListaEnd = new FrmListagemEndereco(nvlAdm);
        telaListaEnd.setVisible(true);
        acessoTelas.set(14,acessoTelas.get(14) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    //Telas de Vendas
    
    public static void abrirVendaPeca(){
        FrmVendaPeca telaVendaPeca = new FrmVendaPeca(nvlAdm);
        telaVendaPeca.setVisible(true);
        acessoTelas.set(15,acessoTelas.get(15) + 1);
        LeitorArquivo.escreverArquivo();
    }
    
    //Telas de Ajuda
    
    public static void abrirSobre(){
        FrmSobre telaSobre = new FrmSobre();
        telaSobre.setVisible(true);
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
