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
public class Servico {
    private int codigoServico;
    private String tipoServico;
    private Date dataServico;
    private Date dataServicoFim;
    private boolean tipoCliente;
    private String cpfCliente;
    private String cnpjCliente;
    private Funcionario funcionario;
    private String descricaoServicoFILE;
    private boolean statusServico;

    public Servico() {
    }

    public Servico(int codigoServico, String tipoServico, Date dataServico, boolean tipoCliente, String cpfCliente, String cnpjCliente, Funcionario funcionario, String descricaoServicoFILE, boolean statusServico) {
        this.codigoServico = codigoServico;
        this.tipoServico = tipoServico;
        this.dataServico = dataServico;
        this.tipoCliente = tipoCliente;
        this.cpfCliente = cpfCliente;
        this.cnpjCliente = cnpjCliente;
        this.funcionario = funcionario;
        this.descricaoServicoFILE = descricaoServicoFILE;
        this.statusServico = statusServico;
    }

    public int getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(int codigoServico) {
        this.codigoServico = codigoServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public boolean isTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(boolean tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCnpjCliente() {
        return cnpjCliente;
    }

    public void setCnpjCliente(String cnpjCliente) {
        this.cnpjCliente = cnpjCliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricaoServicoFILE() {
        return descricaoServicoFILE;
    }

    public void setDescricaoServicoFILE(String descricaoServicoFILE) {
        this.descricaoServicoFILE = descricaoServicoFILE;
    }

    public boolean isStatusServico() {
        return statusServico;
    }

    public void setStatusServico(boolean statusServico) {
        this.statusServico = statusServico;
    }

    public Date getDataServicoFim() {
        return dataServicoFim;
    }

    public void setDataServicoFim(Date dataServicoFim) {
        this.dataServicoFim = dataServicoFim;
    }

    
}
