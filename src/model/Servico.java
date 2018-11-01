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
public class Servico {

    private String codigoServico;
    private String tipoServico;
    private Date dataServico;
    private Date dataServicoFim;
    private int tipoCliente;
    private String cpfCliente;
    private String cnpjCliente;
    private Funcionario funcionario;
    private String descricaoServicoFILE;
    private int statusServico;

    public Servico() {
    }

    public Servico(String codigoServico, String tipoServico, String dataServico, 
            boolean tipoCliente, String cpfCliente, 
            String cnpjCliente, String descricaoServicoFILE) {
        this.setCodigoServico(codigoServico);
        this.tipoServico = tipoServico;
        this.setDataServico(dataServico);
        this.setTipoCliente(tipoCliente);
        this.cpfCliente = cpfCliente;
        this.cnpjCliente = cnpjCliente;
        this.descricaoServicoFILE = descricaoServicoFILE;

    }

    public Servico(String codigoServico, String tipoServico, Date dataServico, 
            boolean tipoCliente, String cpfCliente, String cnpjCliente, 
            Funcionario funcionario, String descricaoServicoFILE, boolean statusServico) {
        this.setCodigoServico(codigoServico);
        this.tipoServico = tipoServico;
        this.dataServico = dataServico;
        this.setTipoCliente(tipoCliente);
        this.cpfCliente = cpfCliente;
        this.cnpjCliente = cnpjCliente;
        this.funcionario = funcionario;
        this.descricaoServicoFILE = descricaoServicoFILE;
        this.setStatusServico(statusServico);
    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(String codigoServico) {
        this.codigoServico = codigoServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDataServico() {
        return control.Datas.converterParaBrasileira(this.dataServico.toString());
    }

    public void setDataServico(String dataServico) {
        this.dataServico = Date.valueOf(control.Datas.converterParaAmericana(dataServico));
    }
    
    public void setDataServicoBanco (String dataServico) {
        this.dataServico = Date.valueOf(dataServico);
    }

   

    public void setTipoCliente(boolean tipoCliente) {
        if (tipoCliente) {
            this.tipoCliente = 0;
        } else {
            this.tipoCliente = 1;
        }
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

    public int getStatusServico() {
        return statusServico;
    }
    
    public String getStatusServicoSTR() {
        if(this.statusServico == 0) {
            return "Inativo";
        } else {
            return "Ativo";
        }
    }

    public void setStatusServico(boolean statusServico) {
        if (statusServico) {
            this.statusServico = 1;
        } else {
            this.statusServico = 0;
        }
    }

    public Date getDataServicoFim() {
        return dataServicoFim;
    }

    public void setDataServicoFim(Date dataServicoFim) {
        this.dataServicoFim = dataServicoFim;
    }

    public int getTipoClienteBanco() {
        return tipoCliente;
    }
    
    public String getTipoClienteSTR() {
        if (this.tipoCliente == 0) {
            return "Física";
        } else {
            return "Jurídica";
        }
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

}
