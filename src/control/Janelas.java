/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Frame;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.FrmCadastroDespesa;
import view.FrmCadastroEndereco;
import view.FrmCadastroFuncionario;
import view.FrmCadastroOrcamento;
import view.FrmCadastroPeca;
import view.FrmCadastroPessoa;
import view.FrmCadastroServico;
import view.FrmCadastroUsuario;
import view.FrmListagemDespesa;
import view.FrmListagemEndereco;
import view.FrmListagemFuncionario;
import view.FrmListagemOrcamento;
import view.FrmListagemPeca;
import view.FrmListagemPessoaF;
import view.FrmListagemPessoaJ;
import view.FrmListagemServico;
import view.FrmListagemUsuario;
import view.FrmLogin;
import view.FrmPrincipal;
import view.FrmSobre;
import view.FrmVendaPeca;

/**
 *
 * @author LuizV1
 */
public class Janelas {

    public Janelas(String nome, int acesso) {
        this.nome = nome;
        this.acesso = acesso;
    }
    
    public static ArrayList<Janelas> acessoTelas = new ArrayList<>();
    
    static int qtdJanelas = 18;
    private String nome;
    private int acesso;
    
    public static void fecharTodasJanelas(){
        for (Frame fr : Frame.getFrames()) {
                fr.dispose();
            }
    }
    
    
    //Métodos para chamada de telas. Telas de Sistema
    public static void abrirLogin() throws IOException {
        FrmLogin telaLogin = new FrmLogin();
        telaLogin.setVisible(true);
    }

    public static void abrirPrincipal() {
        FrmPrincipal telaPrin = new FrmPrincipal();
        telaPrin.setVisible(true);
    }

    //Telas de Cadastro
    public static void abrirCadastroServico() {
        FrmCadastroServico telaCadServ = new FrmCadastroServico(SynchroSoft.getNvlAdm());
        telaCadServ.setVisible(true);
        acessoTelas.get(0).setAcesso(acessoTelas.get(0).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirCadastroPessoa() {
        FrmCadastroPessoa telaCadPessoa = new FrmCadastroPessoa(SynchroSoft.getNvlAdm());
        telaCadPessoa.setVisible(true);
        acessoTelas.get(1).setAcesso(acessoTelas.get(1).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirCadastroProduto() {
        FrmCadastroPeca telaCadProduto = new FrmCadastroPeca(SynchroSoft.getNvlAdm());
        telaCadProduto.setVisible(true);
        acessoTelas.get(2).setAcesso(acessoTelas.get(2).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirCadastroFuncionário() {
        FrmCadastroFuncionario telaCadFunc = new FrmCadastroFuncionario(SynchroSoft.getNvlAdm());
        telaCadFunc.setVisible(true);
        acessoTelas.get(3).setAcesso(acessoTelas.get(3).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirCadastroDespesa() {
        FrmCadastroDespesa telaCadDesp = new FrmCadastroDespesa(SynchroSoft.getNvlAdm());
        telaCadDesp.setVisible(true);
        acessoTelas.get(4).setAcesso(acessoTelas.get(4).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirCadastroUsuario() {
        FrmCadastroUsuario telaCadUsuario = new FrmCadastroUsuario(SynchroSoft.getNvlAdm());
        telaCadUsuario.setVisible(true);
        acessoTelas.get(5).setAcesso(acessoTelas.get(5).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirCadastroOrçamento() {
        FrmCadastroOrcamento telaCadOrc = new FrmCadastroOrcamento(SynchroSoft.getNvlAdm());
        telaCadOrc.setVisible(true);
    }

    public static void abrirCadastroEndereco() {
        FrmCadastroEndereco telaCadEnd = new FrmCadastroEndereco(SynchroSoft.getNvlAdm());
        telaCadEnd.setVisible(true);
        acessoTelas.get(6).setAcesso(acessoTelas.get(6).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    //Telas de Listagem
    public static void abrirListagemServico() {
        FrmListagemServico telaListaServ = new FrmListagemServico(SynchroSoft.getNvlAdm());
        telaListaServ.setVisible(true);
        acessoTelas.get(7).setAcesso(acessoTelas.get(7).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirListagemPessoaFisica() {
        FrmListagemPessoaF telaListaPessoa = new FrmListagemPessoaF(SynchroSoft.getNvlAdm());
        telaListaPessoa.setVisible(true);
        acessoTelas.get(8).setAcesso(acessoTelas.get(8).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirListagemPessoaJuridica() {
        FrmListagemPessoaJ telaListaPessoa = new FrmListagemPessoaJ(SynchroSoft.getNvlAdm());
        telaListaPessoa.setVisible(true);
        acessoTelas.get(9).setAcesso(acessoTelas.get(9).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirListagemProduto() {
        FrmListagemPeca telaListaProduto = new FrmListagemPeca(SynchroSoft.getNvlAdm());
        telaListaProduto.setVisible(true);
        acessoTelas.get(10).setAcesso(acessoTelas.get(10).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirListagemFuncionario() {
        FrmListagemFuncionario telaListaFunc = new FrmListagemFuncionario(SynchroSoft.getNvlAdm());
        telaListaFunc.setVisible(true);
        acessoTelas.get(11).setAcesso(acessoTelas.get(11).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirListagemDespesa() {
        FrmListagemDespesa telaListaDesp = new FrmListagemDespesa(SynchroSoft.getNvlAdm());
        telaListaDesp.setVisible(true);
        acessoTelas.get(12).setAcesso(acessoTelas.get(12).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirListagemUsuario() {
        FrmListagemUsuario telaListaUsuario = new FrmListagemUsuario(SynchroSoft.getNvlAdm());
        telaListaUsuario.setVisible(true);
        acessoTelas.get(13).setAcesso(acessoTelas.get(13).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirListagemOrçamento() throws SQLException, ClassNotFoundException {
        FrmListagemOrcamento telaListaOrc = new FrmListagemOrcamento(SynchroSoft.getNvlAdm());
        telaListaOrc.setVisible(true);
    }

    public static void abrirListagemEndereco() {
        FrmListagemEndereco telaListaEnd = new FrmListagemEndereco(SynchroSoft.getNvlAdm());
        telaListaEnd.setVisible(true);
        acessoTelas.get(14).setAcesso(acessoTelas.get(14).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    //Telas de Vendas
    public static void abrirVendaPeca() {
        FrmVendaPeca telaVendaPeca = new FrmVendaPeca(SynchroSoft.getNvlAdm());
        telaVendaPeca.setVisible(true);
        acessoTelas.get(15).setAcesso(acessoTelas.get(15).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    //Telas de Relatório
    public static void abrirRelatorioServico() {
        //Código pendente para relatorio
        acessoTelas.get(16).setAcesso(acessoTelas.get(16).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
    }

    public static void abrirRelatorioDespesa() {
        //Código Pendente para relatório
        acessoTelas.get(17).setAcesso(acessoTelas.get(17).getAcesso() + 1);
        LeitorArquivo.escreverArquivoJanelas();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public int getQtdJanelas() {
        return qtdJanelas;
    }

    
    
    
    

    

    

    
}
