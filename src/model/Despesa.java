/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
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
    
    public Despesa(String dataDespesa, String tipoDespesas, String descricaoDespesa, String valorDespesa) {
        this.setDataDespesa(dataDespesa);
        this.tipoDespesas = tipoDespesas;
        this.descricaoDespesa = descricaoDespesa;
        this.setValorDespesa(valorDespesa);
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

    public float getValorDespesa() {
        return valorDespesa;
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
}
