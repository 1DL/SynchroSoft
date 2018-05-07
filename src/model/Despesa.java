/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

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
    
    public Despesa(int codigoDespesa, Date dataDespesa, String tipoDespesas, String descricaoDespesa, float valorDespesa) {
        this.codigoDespesa = codigoDespesa;
        this.dataDespesa = dataDespesa;
        this.tipoDespesas = tipoDespesas;
        this.descricaoDespesa = descricaoDespesa;
        this.valorDespesa = valorDespesa;
    }

    public Despesa () {
        
    }

    public int getCodigoDespesa() {
        return codigoDespesa;
    }

    public void setCodigoDespesa(int codigoDespesa) {
        this.codigoDespesa = codigoDespesa;
    }

    public Date getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(String dataDespesa) {
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

    public void setValorDespesa(float valorDespesa) {
        this.valorDespesa = valorDespesa;
    }
}
