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
 * @author Luiz
 */
public class Funcionario{
    
    
    
    private String codigoFuncionario;
    private Pessoa pessoa;
    private PessoaFisica fisica;
    private float salario;
    private String cargo;
    private Date dataContrato;
    private Date dataDemissao;
    private int horasTrabalhadas;
    private int nivelAdministrativo;
    private int efetivado;
    private boolean validacao;

    public Funcionario() {
    }

    

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public Funcionario(String codigoFuncionario, Pessoa pessoa, PessoaFisica fisica, 
            String salario, String cargo, String dataContrato, String dataDemissao, 
            String horasTrabalhadas, boolean nivelAdministrativo) {
        this.codigoFuncionario = codigoFuncionario;
        this.pessoa = pessoa;
        this.fisica = fisica;
        this.setSalario(salario);
        this.cargo = cargo;
        this.setDataContrato(dataContrato);
        this.setDataDemissao(dataDemissao);
        this.setHorasTrabalhadas(horasTrabalhadas);
        this.setNivelAdministrativo(nivelAdministrativo);
    }
    
    public Funcionario(String codigoFuncionario, Pessoa pessoa, PessoaFisica fisica, 
            String salario, String cargo, String dataContrato, String dataDemissao, 
            String horasTrabalhadas, int nivelAdministrativo) {
        this.codigoFuncionario = codigoFuncionario;
        this.pessoa = pessoa;
        this.fisica = fisica;
        this.setSalario(salario);
        this.cargo = cargo;
        this.setDataContrato(dataContrato);
        this.setDataDemissao(dataDemissao);
        this.setHorasTrabalhadas(horasTrabalhadas);
        this.setNivelAdministrativoBanco(nivelAdministrativo);
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaFisica getFisica() {
        return fisica;
    }

    public void setFisica(PessoaFisica fisica) {
        this.fisica = fisica;
    }

    public float getSalarioBanco() {
        return salario;
    }
    
    public String getSalarioSTR() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(this.salario);
    }

    public void setSalario(String salario) {
        salario = salario.replace(",", ".");
        try {
        this.salario = Float.parseFloat(salario);
        validacao = true;
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Valor do salário inválido. Use somente números inteiros e/ou decimais.", "Erro - Valor do Salário inválido", 0);
            validacao = false;
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    

    public String getDataContrato() {
        return control.Datas.converterParaBrasileira(dataContrato.toString());
    }
    
    public void setDataContrato(String dataContrato) {
        this.dataContrato = Date.valueOf(control.Datas.converterParaAmericana(dataContrato));
    }

    public void setDataContratoBanco(String dataContrato) {
        this.dataContrato = Date.valueOf(dataContrato);
    }

    public String getDataDemissao() {
        return control.Datas.converterParaBrasileira(dataDemissao.toString());
    }

    public void setDataDemissaoBanco(String dataDemissao) {
        this.dataDemissao = Date.valueOf(dataDemissao);
    }
    
    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = Date.valueOf(control.Datas.converterParaAmericana(dataDemissao));
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(String horasTrabalhadas) {
        try{
            this.horasTrabalhadas = Integer.parseInt(horasTrabalhadas);
            validacao = true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao definir as horas mensais. \n\nUse somente valores inteiros.", "Erro - Horas mensais inválida", 0);
            validacao = false;
        }
    }

    public String getNivelAdministrativo() {
        if (nivelAdministrativo == 0) {
            return "Visualização";
        } else {
            return "Completo";
        }
    }
    
    public int getNivelAdministrativoBanco(){
        return nivelAdministrativo;
    }

    public void setNivelAdministrativo(boolean nivelAdministrativo) {
        if (nivelAdministrativo) {
            this.nivelAdministrativo = 0;
        } else {
            this.nivelAdministrativo = 1;
        }
    }
    
    public void setNivelAdministrativoBanco(int nivelAdministrativo) {
        this.nivelAdministrativo = nivelAdministrativo;
    }

    public boolean isValidacao() {
        return validacao;
    }

    public void setValidacao(boolean validacao) {
        this.validacao = validacao;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public int getEfetivado() {
        return efetivado;
    }

    public void setEfetivado(int efetivado) {
        this.efetivado = efetivado;
    }
    
    public String getEfetivadoSTR() {
        if (efetivado == 1) {
            return "Sim";
        } else {
            return "Não";
        }
    }
    
    public void setEfetivadoSTR(String efetivado) {
        if (efetivado.equals("Sim")) {
            this.efetivado = 1;
        } else if (efetivado.equals("Não")) {
            this.efetivado = 0;
        }
    }
    
    public boolean getEfetivadoBooleano() {
        if (this.efetivado == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public void setEfetivadoBooleano(boolean efetivado) {
        if (efetivado) {
            this.efetivado = 1;
        } else {
            this.efetivado = 0;
        }
    }
    
    public boolean getNivelAdministrativoBooleano(){ 
        if (this.nivelAdministrativo == 0){
            return true;
        } else {
            return false;
        }
    }
}
