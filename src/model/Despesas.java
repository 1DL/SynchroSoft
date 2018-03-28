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
public class Despesas {
    private int codigoDespesa;
    private Date dataDespesa;
    private ArrayList<String> tipoDespesas = new ArrayList<>();
    private String descricaoDespesa;
    private float valorDespesa;

    public int getCodigoDespesa() {
        return codigoDespesa;
    }

    public void setCodigoDespesa(int codigoDespesa) {
        this.codigoDespesa = codigoDespesa;
    }

    public Date getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(Date dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public ArrayList<String> getTipoDespesas() {
        return tipoDespesas;
    }

    public void setTipoDespesas(ArrayList<String> tipoDespesas) {
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
