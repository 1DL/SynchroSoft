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
    private int categoriaPeca;
    private String nomePeca;
    private int quantidadePeca;
    private float valorUnitario;

    public int getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(int codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public int getCategoriaPeca() {
        return categoriaPeca;
    }

    public void setCategoriaPeca(int categoriaPeca) {
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
