/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import model.Pessoa;
import model.PessoaFisica;

/**
 *
 * @author Luiz
 */
public class Funcionario{
    private int codigoFuncionario;
    private String cepFuncionario;
    private Pessoa pessoa;
    private PessoaFisica fisica;
    private float Salario;
    private String cargo;
    private Date dataContrato;
    private Date dataDemissao;
    private int horasTrabalhadas;
    private int nivelAdministrativo;

    public Funcionario() {
    }

    public Funcionario(int codigoFuncionario, String cepFuncionario, Pessoa pessoa, PessoaFisica fisica, float Salario, String cargo, Date dataContrato, int horasTrabalhadas, int nivelAdministrativo) {
        this.codigoFuncionario = codigoFuncionario;
        this.cepFuncionario = cepFuncionario;
        this.pessoa = pessoa;
        this.fisica = fisica;
        this.Salario = Salario;
        this.cargo = cargo;
        this.dataContrato = dataContrato;
        this.horasTrabalhadas = horasTrabalhadas;
        this.nivelAdministrativo = nivelAdministrativo;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCepFuncionario() {
        return cepFuncionario;
    }

    public void setCepFuncionario(String cepFuncionario) {
        this.cepFuncionario = cepFuncionario;
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

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float Salario) {
        this.Salario = Salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getNivelAdministrativo() {
        return nivelAdministrativo;
    }

    public void setNivelAdministrativo(int nivelAdministrativo) {
        this.nivelAdministrativo = nivelAdministrativo;
    }
}
