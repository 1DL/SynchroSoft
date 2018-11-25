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

    public PessoaFisica(Pessoa pessoa, String cpf, String dataCadastro, String celular, boolean sexo) {
        this.pessoa = pessoa;
        this.cpf = cpf;
        this.setDataCadastro(dataCadastro);
        this.setCelular(celular);
        this.setSexo(sexo);
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

    public String getDataCadastro() {
        return control.Datas.converterParaBrasileira(dataCadastro.toString());
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = Date.valueOf(control.Datas.converterParaAmericana(dataCadastro));
    }
    
    public void setDataCadastroBanco(String dataCadastro) {
        this.dataCadastro = Date.valueOf(dataCadastro);
    }
    

    public long getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        try {
            this.celular = Long.parseLong(celular);
        } catch (NumberFormatException nfe) {
            this.celular = 0;
        }
    }
    
    public int getSexo() {
        return sexo;
    }

    public String getSexoSTR() {
        if (sexo == 0) {
            return "Masculino";
        } else {
            return "Feminino";
        }
    }
    
    public int getSexoBanco() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        if (sexo) {
            this.sexo = 0;
        } else {
            this.sexo = 1;
        }
    }
    
    public void setSexoBanco(int sexo){
        this.sexo = sexo;
    }
    
    public void setSexoSTR(String sexo){
        if (sexo.equals("Masculino")) {
            this.sexo = 0;
        } else if (sexo.equals("Feminino")){
            this.sexo = 1;
        }
    }
}
