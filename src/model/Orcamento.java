/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    public String getMaoDeObraSTR(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(this.maoDeObra);
        
    }

    public void setMaoDeObra(Double maoDeObra) {
        this.maoDeObra = maoDeObra;
    }
    
    public void setMaoDeObraSTR (String maoDeObra) {
        maoDeObra = maoDeObra.replace(".", "");
        maoDeObra = maoDeObra.replace(",", ".");
        try {
            this.maoDeObra = Double.parseDouble(maoDeObra);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Erro ao converter o valor da mão de obra. \n\n"
                    + "Erro: "+nfe, "Erro ao atribuir Mão de Obra", 0);
        }
    }

    public Double getValorTotal() {
        return valorTotal;
    }
    
    public String getValorTotalSTR() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(this.valorTotal);
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getStatusOrcamento() {
        return statusOrcamento;
    }
    
    public String getStatusOrcamentoSTR() {
        if (this.statusOrcamento == 0){
            return "Não";
        } else {
            return "Sim";
        }
    }

    public void setStatusOrcamento(int statusOrcamento) {
        this.statusOrcamento = statusOrcamento;
    }
}
