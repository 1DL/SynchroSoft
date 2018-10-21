/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author LuizV1
 */
public class PessoaJuridica {
    private String cnpj;
    private String razaoSocial;
    private Date dataCadastro;
    private Pessoa pessoa;
    private long ramalCliente;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Pessoa pessoa, String cnpj, String razaoSocial, String dataCadastro, String ramalCliente) {
        this.pessoa = pessoa;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.setDataCadastro(dataCadastro);
        this.setRamalCliente(ramalCliente);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getDataCadastro() {
        return control.Datas.converterParaBrasileira(dataCadastro.toString());
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = Date.valueOf(control.Datas.converterParaAmericana(dataCadastro));
    }
    
    public void setDataCadastroBanco(String dataCadastro) {
        this.dataCadastro = Date.valueOf(dataCadastro);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public long getRamalCliente() {
        return ramalCliente;
    }

    public void setRamalCliente(String ramalCliente) {
        this.ramalCliente = Long.parseLong(ramalCliente);
    }
}
