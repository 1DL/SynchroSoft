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
public class PessoaFisica {
    private Pessoa pessoa;
    private String cpf;
    private Date dataCadastro;
    private long celular;
    private int sexo;

    public PessoaFisica() {
    }

    public PessoaFisica(Pessoa pessoa, String cpf, Date dataCadastro, long celular, int sexo) {
        this.pessoa = pessoa;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
        this.celular = celular;
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
//        int dd,mm,aa;
//        aa = Integer.parseInt(dataCadastro.substring(0, 4));
//        mm = Integer.parseInt(dataCadastro.substring(5, 2));
//        dd = Integer.parseInt(dataCadastro.substring(8, 4));
        this.dataCadastro = Date.valueOf(dataCadastro);
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getSexo() {
        if (sexo == 0) {
            return "Masculino";
        } else {
            return "Feminino";
        }
    }
    
    public int getSexoBanco() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}
