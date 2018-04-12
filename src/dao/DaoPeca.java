/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;

/**
 *
 * @author LuizV1
 */
public class DaoPeca {
    private int codigoPeca;
    private int categoriaPeca;
    private String nomePeca;
    private int quantidadePeca;
    private float valorUnitario;
    
    public void cadastrarPeca(int cod, String nome, String cat, int qtd, float valor) throws SQLException, ClassNotFoundException {
        try{
        Connection con = Conexao.conectar();
        Statement st = con.createStatement();
        st.executeQuery("INSERT INTO SYNCHROSOFT.TB_PECA VALUES ("+cod+",'"+nome+"','"+cat+"',"+qtd+","+valor+")");
        st.close();
        con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    public int getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(int codigoPeca) throws SQLException, ClassNotFoundException {
        this.codigoPeca = codigoPeca;
        
    }

    public int getCategoriaPeca() {
        return categoriaPeca;
    }

    public void setCategoriaPeca(int categoriaPeca) {
        this.categoriaPeca = categoriaPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public int getQuantidadePeca() {
        return quantidadePeca;
    }

    public void setQuantidadePeca(int quantidadePeca) {
        this.quantidadePeca = quantidadePeca;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
   
}
