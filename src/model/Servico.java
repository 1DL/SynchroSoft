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
public class Servico {

    private String codigoServico;
    private int tipoServico;
    private Date dataServico;
    private Date dataServicoFim;
    private int tipoCliente;
    private String cpfCliente;
    private String cnpjCliente;
    private ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
    private String descricaoServicoFILE;
    private int statusServico;
    private Endereco endereco;

    public Servico() {

    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public ArrayList<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(ArrayList<Funcionario> funcionario) {
        this.listaFuncionario = funcionario;
    }
    
    public void setFuncionarioNaLista(Funcionario funcionario){
        this.listaFuncionario.add(funcionario);
    }

    public void setCodigoServico(String codigoServico) {
        this.codigoServico = codigoServico;
    }

    public int getTipoServicoBanco() {
        return tipoServico;
    }

    public String getTipoServicoSTR() {
        switch (this.tipoServico) {
            case 0:
                return "Preventivo";
            case 1:
                return "Corretivo";
            case 2:
                return "Emergencial";
            default:
                return "Erro Tipo Serviço";
        }
    }

    public void setTipoServico(int tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDataServico() {
        return control.Datas.converterParaBrasileira(this.dataServico.toString());
    }

    public void setDataServico(String dataServico) {
        this.dataServico = Date.valueOf(control.Datas.converterParaAmericana(dataServico));
    }

    public void setDataServicoBanco(String dataServico) {
        this.dataServico = Date.valueOf(dataServico);
    }

    public String getDataServicoFim() {
        return control.Datas.converterParaBrasileira(this.dataServicoFim.toString());
    }

    public void setDataServicoFim(String dataServicoFim) {
        this.dataServicoFim = Date.valueOf(control.Datas.converterParaAmericana(dataServicoFim));
    }

    public void setDataServicoFimBanco(String dataServicoFim) {
        this.dataServicoFim = Date.valueOf(dataServicoFim);
    }
    /**
     * Define o valor inteiro para o atributo tipoCliente. 
     * O argumento booleano true representa o cliente do tipo Físico, 
     * atribuindo o valor inteiro 0 para o atributo tipoCliente.
     * 
     * O argumento booleano false representa o cliente do tipo Jurídico,
     * atribuindo o valor inteiro 1 para o atributo tipoCliente.
     * 
     * @param tipoCliente determina o tipo de cliente. Se true, 
     * representa cliente Físico e atribui inteiro 0 ao tipoCliente. Se false,
     * representa cliente Jurídico e atribui inteiro 1 ao tipoCliente.
     */
    public void setTipoCliente(boolean tipoCliente) {
        if (tipoCliente) {
            this.tipoCliente = 1;
        } else {
            this.tipoCliente = 0;
        }
    }

    public void setTipoClienteBanco(int tipoCliente) {
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
        if (this.statusServico == 0) {
            return "Encerrado";
        } else {
            return "Ativo";
        }
    }
    
    public boolean getStatusServicoBooleano() {
        if (this.statusServico == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void setStatusServico(boolean statusServico) {
        if (statusServico) {
            this.statusServico = 1;
        } else {
            this.statusServico = 0;
        }
    }

    public void setStatusServicoBanco(int statusServico) {
        this.statusServico = statusServico;
    }

    public int getTipoClienteBanco() {
        return tipoCliente;
    }
    
    public boolean getTipoClienteBooleano() {
        if (this.tipoCliente == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String getTipoClienteSTR() {
        if (this.tipoCliente == 0) {
            return "Física";
        } else {
            return "Jurídica";
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
