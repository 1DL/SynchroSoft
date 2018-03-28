/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author LuizV1
 */
public class Funcionario {
    private int codigoFuncionario;
    private float salarioHora;
    private String cargoFuncionario;
    private Date dataAdmissao;
    private Date dataDemissao;
    private int cargaHoraria;

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public float getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(float salarioHora) {
        this.salarioHora = salarioHora;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
