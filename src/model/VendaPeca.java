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
public class VendaPeca {
    private Produto peca;
    private int quantidadeVendida;

    public Produto getPeca() {
        return peca;
    }

    public void setPeca(Produto peca) {
        this.peca = peca;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
}
