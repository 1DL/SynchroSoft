/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author LuizV1
 */
public class Orcamento {
    private int codigoOrcamento;
    private Servico servico;
    private boolean possuiPeca;
    private ArrayList<VendaPeca> pecas = new ArrayList<>();
    private Double maoDeObra;
    private Double valorTotal;
    private int statusOrcamento;

    public int getCodigoOrcamento() {
        return codigoOrcamento;
    }

    public void setCodigoOrcamento(int codigoOrcamento) {
        this.codigoOrcamento = codigoOrcamento;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public boolean isPossuiPeca() {
        return possuiPeca;
    }

    public void setPossuiPeca(boolean possuiPeca) {
        this.possuiPeca = possuiPeca;
    }

    public ArrayList<VendaPeca> getPecas() {
        return pecas;
    }

    public void setPecas(ArrayList<VendaPeca> pecas) {
        this.pecas = pecas;
    }

    public Double getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(Double maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getStatusOrcamento() {
        return statusOrcamento;
    }

    public void setStatusOrcamento(int statusOrcamento) {
        this.statusOrcamento = statusOrcamento;
    }
}
