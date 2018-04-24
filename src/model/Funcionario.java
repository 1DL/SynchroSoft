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
    private Pessoa nome;
    private PessoaFisica cpf;
    private PessoaFisica sexo;
    private Pessoa telefone;
    private PessoaFisica celular;
    private Pessoa complementoLogradouro;
    private float Salario;
    private String cargo;
    private Date dataContrato;
    private Date dataDemissao;
    private int horasTrabalhadas;
    private boolean nivelAdministrativo;

    public Funcionario(int codigoFuncionario, String cepFuncionario, Pessoa nome, PessoaFisica cpf, PessoaFisica sexo, PessoaFisica celular, Pessoa complementoLogradouro, int Salario, String cargo, Date dataContrato, Date dataDemissao, int horasTrabalhadas, boolean nivelAdministrativo) {
        this.codigoFuncionario = codigoFuncionario;
        this.cepFuncionario = cepFuncionario;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.celular = celular;
        this.complementoLogradouro = complementoLogradouro;
        this.Salario = Salario;
        this.cargo = cargo;
        this.dataContrato = dataContrato;
        this.dataDemissao = dataDemissao;
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

    public Pessoa getNome() {
        return nome;
    }

    public void setNome(Pessoa nome) {
        this.nome = nome;
    }

    public PessoaFisica getCpf() {
        return cpf;
    }

    public void setCpf(PessoaFisica cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica getSexo() {
        return sexo;
    }

    public void setSexo(PessoaFisica sexo) {
        this.sexo = sexo;
    }

    public PessoaFisica getCelular() {
        return celular;
    }

    public void setCelular(PessoaFisica celular) {
        this.celular = celular;
    }

    public Pessoa getComplementoLogradouro() {
        return complementoLogradouro;
    }

    public void setComplementoLogradouro(Pessoa complementoLogradouro) {
        this.complementoLogradouro = complementoLogradouro;
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

    public boolean isNivelAdministrativo() {
        return nivelAdministrativo;
    }

    public void setNivelAdministrativo(boolean nivelAdministrativo) {
        this.nivelAdministrativo = nivelAdministrativo;
    }

    public Pessoa getTelefone() {
        return telefone;
    }

    public void setTelefone(Pessoa telefone) {
        this.telefone = telefone;
    }
}
