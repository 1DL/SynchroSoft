/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Peca;

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
    
    public static ArrayList listarPeca (){
        ArrayList<Peca> lista = new ArrayList<>();
        try{
            Connection con = Conexao.conectar();
            DatabaseMetaData teste = con.getMetaData();
            System.out.println(teste.supportsBatchUpdates());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SYNCHROSOFT.TB_PECA");
            while(rs.next()){
                Peca pecas = new Peca(rs.getInt("CD_PECA"), rs.getString("NM_PECA"), rs.getString("DS_CATEGORIA"), rs.getInt("QT_PECA"), rs.getFloat("VL_PECA"));
                lista.add(pecas);
                
                
                /*lista.add(new String[]{String.valueOf(rs.getInt("CD_PECA")),
                (rs.getString("NM_PECA")),(rs.getString("DS_CATEGORIA")),
                String.valueOf(rs.getInt("QT_PECA")),String.valueOf(rs.getFloat("VL_PECA"))});                
                System.out.println(lista.get(0));*/
            }
            System.out.println(lista.get(0).getNomePeca());
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DAOPECA Instanciamento: "+ex);
        }
        //return lista;
        return lista;
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
