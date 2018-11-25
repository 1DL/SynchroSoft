/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author LuizV1
 */
public class Produto {
    private String codigoPeca;
    private String categoriaPeca;
    private String nomePeca;
    private long quantidadePeca;
    private float valorUnitario;
    private long alertaQtdMin;
    private long alertaQtdMax;
    private boolean validacao = true;
    

    public Produto() {
    }   
    
    public Produto(String codigoPeca, String nomePeca, String categoriaPeca,
            String quantidadePeca, String alertaQtdMin, String alertaQtdMax,
            String valorUnitario) {
        this.codigoPeca = codigoPeca;
        this.nomePeca = nomePeca;
        this.categoriaPeca = categoriaPeca;
        this.setQuantidadePeca(quantidadePeca);
        this.setAlertaQtdMin(alertaQtdMin);
        this.setAlertaQtdMax(alertaQtdMax);
        this.setValorUnitario(valorUnitario);
    }


    public String getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(String codigoPeca) {
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

    public long getQuantidadePeca() {
        return quantidadePeca;
    }

    public void setQuantidadePeca(String quantidadePeca) {
        quantidadePeca = quantidadePeca.replace(".", "");
        quantidadePeca = quantidadePeca.replace(",", "");
        quantidadePeca = quantidadePeca.replace("-", "");
        try{
            this.quantidadePeca = Long.parseLong(quantidadePeca);
            validacao = true;
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Erro ao definir a quantidade de produtos. \n\nUse somente valores inteiros.", "Erro - Quantidade inválida", 0);
            validacao = false;
        }
    }

    public float getValorUnitarioBanco() {
        return valorUnitario;
    }
    public String getValorUnitarioSTR(){
        String valorSTR;
        valorSTR = (new DecimalFormat("#0.00").format(valorUnitario));
        valorSTR = valorSTR.replace(".", ",");
        return valorSTR;
    }

    public void setValorUnitario(String valorUnitario) {
        valorUnitario = valorUnitario.replace(",", ".");
        try {
        this.valorUnitario = Float.parseFloat(valorUnitario);
        validacao = true;
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Valor unitário inválido. Use somente números inteiros e/ou decimais.", "Erro - Valor Unitário inválido", 0);
            validacao = false;
        }
    }

    public long getAlertaQtdMin() {
        return alertaQtdMin;
    }

    public void setAlertaQtdMin(String alertaQtdMin) {
        try{
            this.alertaQtdMin = Long.parseLong(alertaQtdMin);
            validacao = true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao definir a o alerta de quantidade mínima. \n\nUse somente valores inteiros.", "Erro - Alerta mínimo inválido", 0);
            validacao = false;
        }
    }

    public long getAlertaQtdMax() {
        return alertaQtdMax;
    }

    public void setAlertaQtdMax(String alertaQtdMax) {
        try{
            this.alertaQtdMax = Long.parseLong(alertaQtdMax);
            validacao = true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao definir a o alerta de quantidade máxima. \n\nUse somente valores inteiros.", "Erro - Alerta máxima inválido", 0);
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
