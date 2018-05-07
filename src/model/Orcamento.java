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
    private Servico codigoServico;
    private boolean possuiPeca;
    private ArrayList<VendaPeca> pecas = new ArrayList<>();
    private float maoDeObra;
    private float valorTotal;
    private float statusOrcamento;

    public int getCodigoOrcamento() {
        return codigoOrcamento;
    }

    public void setCodigoOrcamento(int codigoOrcamento) {
        this.codigoOrcamento = codigoOrcamento;
    }

    public Servico getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(Servico codigoServico) {
        this.codigoServico = codigoServico;
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

    public float getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(float maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getStatusOrcamento() {
        return statusOrcamento;
    }

    public void setStatusOrcamento(float statusOrcamento) {
        this.statusOrcamento = statusOrcamento;
    }
}
