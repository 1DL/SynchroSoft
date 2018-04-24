/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LuizV1
 */
public class Pessoa {
    private String nome;
    private Endereco endereco;
    private int telefone;
    private String complementoLogradouro;
    private int manterContrato;

    public Pessoa() {
    }

    public Pessoa(String nome, Endereco endereco, int telefone, String complementoLogradouro, int manterContrato) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.complementoLogradouro = complementoLogradouro;
        this.manterContrato = manterContrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getComplementoLogradouro() {
        return complementoLogradouro;
    }

    public void setComplementoLogradouro(String complementoLogradouro) {
        this.complementoLogradouro = complementoLogradouro;
    }

    public int getManterContrato() {
        return manterContrato;
    }

    public void setManterContrato(int manterContrato) {
        this.manterContrato = manterContrato;
    }
}
