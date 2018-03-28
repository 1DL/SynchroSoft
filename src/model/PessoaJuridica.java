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
    private Pessoa nomeFicticio;
    private int ramalCliente;

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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Pessoa getNomeFicticio() {
        return nomeFicticio;
    }

    public void setNomeFicticio(Pessoa nomeFicticio) {
        this.nomeFicticio = nomeFicticio;
    }

    public int getRamalCliente() {
        return ramalCliente;
    }

    public void setRamalCliente(int ramalCliente) {
        this.ramalCliente = ramalCliente;
    }
}
