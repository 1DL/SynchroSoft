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
    private long telefone;
    private String complementoLogradouro;
    private int manterContrato;

    public Pessoa() {
    }

    public Pessoa(String nome, Endereco endereco, String telefone, String complementoLogradouro, boolean manterContrato) {
        this.nome = nome;
        this.endereco = endereco;
        this.setTelefone(telefone);
        this.complementoLogradouro = complementoLogradouro;
        this.setManterContrato(manterContrato);
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

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        try {
            this.telefone = Long.parseLong(telefone);
        } catch (NumberFormatException nfe) {
            this.telefone = 0;
        }
        
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
    
    public String getManterContratoSTR(){
        if (manterContrato == 1){
            return "Sim";
        } else {
            return "Não";
        }
    }

    public void setManterContrato(boolean manterContrato) {
        if (manterContrato){
            this.manterContrato = 1;
        } else {
            this.manterContrato = 0;
        }
    }
    
    public void setManterContratoBanco(int manterContrato) {
        this.manterContrato = manterContrato;
    }
}
