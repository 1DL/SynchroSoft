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
public class Peca {
    private int codigoPeca;
    private String categoriaPeca;
    private String nomePeca;
    private int quantidadePeca;
    private float valorUnitario;

    public Peca() {
    }   
    
    public Peca(int codigoPeca, String nomePeca, String categoriaPeca, int quantidadePeca, float valorUnitario) {
        this.codigoPeca = codigoPeca;
        this.nomePeca = nomePeca;
        this.categoriaPeca = categoriaPeca;
        this.quantidadePeca = quantidadePeca;
        this.valorUnitario = valorUnitario;
    }

    public int getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(int codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public String getCategoriaPeca() {
        return categoriaPeca;
    }

    public void setCategoriaPeca(String categoriaPeca) {
        this.categoriaPeca = categoriaPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public int getQuantidadePeca() {
        return quantidadePeca;
    }

    public void setQuantidadePeca(int quantidadePeca) {
        this.quantidadePeca = quantidadePeca;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
