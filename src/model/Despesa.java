/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author LuizV1
 */
public class Despesa {
    private int codigoDespesa;
    private Date dataDespesa;
    private String tipoDespesas;
    private String descricaoDespesa;
    private float valorDespesa;
    private boolean validacao;
    private int quitada;
    
    public Despesa(String dataDespesa, String tipoDespesas, String descricaoDespesa, String valorDespesa, boolean quitada) {
        this.setDataDespesa(dataDespesa);
        this.tipoDespesas = tipoDespesas;
        this.descricaoDespesa = descricaoDespesa;
        this.setValorDespesa(valorDespesa);
        this.setQuitada(quitada);
    }

    public Despesa () {
        
    }

    public int getCodigoDespesa() {
        return codigoDespesa;
    }

    public void setCodigoDespesa(int codigoDespesa) {
        this.codigoDespesa = codigoDespesa;
    }

    public String getDataDespesa() {
        return control.Datas.converterParaBrasileira(dataDespesa.toString());
    }

    public void setDataDespesa(String dataDespesa) {
        this.dataDespesa = Date.valueOf(control.Datas.converterParaAmericana(dataDespesa));
    }
    
    public void setDataDespesaBanco(String dataDespesa) {
        this.dataDespesa = Date.valueOf(dataDespesa);
    }

    public String getTipoDespesas() {
        return tipoDespesas;
    }

    public void setTipoDespesas(String tipoDespesas) {
        this.tipoDespesas = tipoDespesas;
    }

    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    public float getValorDespesaBanco() {
        return valorDespesa;
    }
    
    public String getValorDespesaSTR(){
        String valorSTR;
        valorSTR = (new DecimalFormat("#0.00").format(valorDespesa));
        valorSTR = valorSTR.replace(".", ",");
        return valorSTR;
    }

    public void setValorDespesa(String valorDespesa) {
        valorDespesa = valorDespesa.replace(",", ".");
        try {
        this.valorDespesa = Float.parseFloat(valorDespesa);
        validacao = true;
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Valor da despesa inválido. Use somente números inteiros e/ou decimais.", "Erro - Valor Despesa inválido", 0);
            validacao = false;
        }
    }

    public boolean isValidacao() {
        return validacao;
    }

    public void setValidacao(boolean validacao) {
        this.validacao = validacao;
    }
    
    public void setQuitada(boolean quitada) {
        if (quitada) {
            this.quitada = 1;
        } else {
            this.quitada = 0;
        }
    }
    
    public int getQuitada() {
        return quitada;
    }
    
    public void setQuitadaBanco(int quitada) {
        this.quitada = quitada;
    }
    
    public boolean getQuitadaBoolean() {
        if (quitada == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public void setQuitadaSTR(String quitada) {
        if (quitada.equals("Sim")) {
            this.quitada = 1;
        } else {
            this.quitada = 0;
        }
    }
    
    public String getQuitadaSTR() {
        if (quitada == 0) {
            return "Não";
        } else {
            return "Sim";
        }
    }
}
