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
     * @param args the command line arguments .
     */
    private static String versao = "1.0";
    private static String nomeUsuario = "Teste";
    private static int codFunc = 0;
    private static int nvlAdm = 1;

    public static ArrayList<Janelas> acessoTelas = new ArrayList<>();

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
        acessoTelas.get(0).setAcesso(acessoTelas.get(0).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirCadastroPessoa() {
        FrmCadastroPessoa telaCadPessoa = new FrmCadastroPessoa(nvlAdm);
        telaCadPessoa.setVisible(true);
        acessoTelas.get(1).setAcesso(acessoTelas.get(1).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirCadastroProduto() {
        FrmCadastroPeca telaCadProduto = new FrmCadastroPeca(nvlAdm);
        telaCadProduto.setVisible(true);
        acessoTelas.get(2).setAcesso(acessoTelas.get(2).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirCadastroFuncionário() {
        FrmCadastroFuncionario telaCadFunc = new FrmCadastroFuncionario(nvlAdm);
        telaCadFunc.setVisible(true);
        acessoTelas.get(3).setAcesso(acessoTelas.get(3).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirCadastroDespesa() {
        FrmCadastroDespesa telaCadDesp = new FrmCadastroDespesa(nvlAdm);
        telaCadDesp.setVisible(true);
        acessoTelas.get(4).setAcesso(acessoTelas.get(4).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirCadastroUsuario() {
        FrmCadastroUsuario telaCadUsuario = new FrmCadastroUsuario(nvlAdm);
        telaCadUsuario.setVisible(true);
        acessoTelas.get(5).setAcesso(acessoTelas.get(5).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirCadastroOrçamento() {
        FrmCadastroOrcamento telaCadOrc = new FrmCadastroOrcamento(nvlAdm);
        telaCadOrc.setVisible(true);
    }

    public static void abrirCadastroEndereco() {
        FrmCadastroEndereco telaCadEnd = new FrmCadastroEndereco(nvlAdm);
        telaCadEnd.setVisible(true);
        acessoTelas.get(6).setAcesso(acessoTelas.get(6).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    //Telas de Listagem
    public static void abrirListagemServico() {
        FrmListagemServico telaListaServ = new FrmListagemServico(nvlAdm);
        telaListaServ.setVisible(true);
        acessoTelas.get(7).setAcesso(acessoTelas.get(7).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirListagemPessoaFisica() {
        FrmListagemPessoaF telaListaPessoa = new FrmListagemPessoaF(nvlAdm);
        telaListaPessoa.setVisible(true);
        acessoTelas.get(8).setAcesso(acessoTelas.get(8).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirListagemPessoaJuridica() {
        FrmListagemPessoaJ telaListaPessoa = new FrmListagemPessoaJ(nvlAdm);
        telaListaPessoa.setVisible(true);
        acessoTelas.get(9).setAcesso(acessoTelas.get(9).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirListagemProduto() {
        FrmListagemPeca telaListaProduto = new FrmListagemPeca(nvlAdm);
        telaListaProduto.setVisible(true);
        acessoTelas.get(10).setAcesso(acessoTelas.get(10).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirListagemFuncionario() {
        FrmListagemFuncionario telaListaFunc = new FrmListagemFuncionario(nvlAdm);
        telaListaFunc.setVisible(true);
        acessoTelas.get(11).setAcesso(acessoTelas.get(11).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirListagemDespesa() {
        FrmListagemDespesa telaListaDesp = new FrmListagemDespesa(nvlAdm);
        telaListaDesp.setVisible(true);
        acessoTelas.get(12).setAcesso(acessoTelas.get(12).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirListagemUsuario() {
        FrmListagemUsuario telaListaUsuario = new FrmListagemUsuario(nvlAdm);
        telaListaUsuario.setVisible(true);
        acessoTelas.get(13).setAcesso(acessoTelas.get(13).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirListagemOrçamento() throws SQLException, ClassNotFoundException {
        FrmListagemOrcamento telaListaOrc = new FrmListagemOrcamento(nvlAdm);
        telaListaOrc.setVisible(true);
    }

    public static void abrirListagemEndereco() {
        FrmListagemEndereco telaListaEnd = new FrmListagemEndereco(nvlAdm);
        telaListaEnd.setVisible(true);
        acessoTelas.get(14).setAcesso(acessoTelas.get(14).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    //Telas de Vendas
    public static void abrirVendaPeca() {
        FrmVendaPeca telaVendaPeca = new FrmVendaPeca(nvlAdm);
        telaVendaPeca.setVisible(true);
        acessoTelas.get(15).setAcesso(acessoTelas.get(15).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    //Telas de Relatório
    public static void abrirRelatorioServico() {
        //Código pendente para relatorio
        acessoTelas.get(16).setAcesso(acessoTelas.get(16).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    public static void abrirRelatorioDespesa() {
        //Código Pendente para relatório
        acessoTelas.get(17).setAcesso(acessoTelas.get(17).getAcesso() + 1);
        LeitorArquivo.escreverArquivo();
    }

    //Telas de Ajuda
    public static void abrirSobre() {
        FrmSobre telaSobre = new FrmSobre();
        telaSobre.setVisible(true);
    }

    public static String abrirMaisAcessada(String jan, boolean flag) {
        switch (jan) {
            case "J00":
                if (flag) {
                    abrirCadastroServico();
                }
                return "Cadastrar Ordem de Serviço";
            case "J01":
                if (flag) {
                    abrirCadastroPessoa();
                }
                return "Cadastrar Pessoa";
            case "J02":
                if (flag) {
                    abrirCadastroProduto();
                }
                return "Cadastrar Produto";
            case "J03":
                if (flag){
                abrirCadastroFuncionário();
                }
                return "Cadastrar Funcionário";
            case "J04":
                if (flag) {
                abrirCadastroDespesa();
                }
                return "Cadastrar Despesa";
            case "J05":
                if (flag) {
                abrirCadastroUsuario();
                }
                return "Cadastrar Usuario";
            case "J06":
                if (flag) {
                abrirCadastroEndereco();
                }
                return "Cadastrar Endereço";
            case "J07":
                if (flag) {
                abrirListagemServico();
                }
                return "Listar Ordens de Serviço";
            case "J08":
                if (flag) {
                abrirListagemPessoaFisica();
                }
                return "Listar Pessoas Físicas";
            case "J09":
                if (flag) {
                abrirListagemPessoaJuridica();
                } return "Listar Pessoas Jurídicas";
            case "J10":
                if (flag) {
                abrirListagemProduto();
                }
                return "Listar Produtos";
            case "J11":
                if (flag) {
                    abrirListagemFuncionario();
                }
                return "Listar Funcionários";                
            case "J12":
                if (flag) {
                    abrirListagemDespesa();
                }
                return "Listar Despesas";                
            case "J13":
                if (flag) {
                    abrirListagemUsuario();
                }
                return "Listar Usuários";                
            case "J14":
                if (flag) {
                    abrirListagemEndereco();
                }
                return "Listar Endereços";                
            case "J15": 
                if (flag) {
                    abrirVendaPeca();
                }
                return "Vender Produtos";
            case "J16":
                if (flag) {
                    abrirRelatorioServico();
                }
                return "Gerar Relatório de OS";                
            case "J17":
                if (flag) {
                    abrirRelatorioDespesa();
                }
                return "Gerar Relatório de Despesas";                
            default:
                JOptionPane.showMessageDialog(null, "Erro - Código de Janela desconhecido.", "Código de Janela "+jan, JOptionPane.ERROR_MESSAGE);
        }
        return "Erro";
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
