/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Peca;

/**
 *
 * @author LuizV1
 */
public class DaoPessoa {
 
    public void cadastrarPessoaFisica (String cpf, String cep, String nomeFisica, int sexo, long telefone, long celular, String complemento, Date dataCadastro, int isContratado) {
       try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_PESSOA_FISICA VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cpf);
            st.setString(2, cep);
            st.setString(3, nomeFisica.toLowerCase());
            st.setInt(4, sexo);
            st.setLong(5, telefone);
            st.setLong(6, celular);
            st.setString(7, complemento.toLowerCase());
            st.setDate(8, dataCadastro);
            st.setInt(9, isContratado);
            st.executeUpdate();
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar a Pessoa Física.\n Erro:\n\n" + ex.getMessage());
        } 
    }
    
    public static boolean existePessoaFisica(String cpf) throws SQLException, ClassNotFoundException{
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_CPF FROM SYNCHROSOFT.TB_PESSOA_FISICA WHERE CD_CPF = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cpf);
        ResultSet rs = st.executeQuery();
        flag = rs.isBeforeFirst(); 
        st.close();
        rs.close();
        return flag;
    }
    
    public void cadastrarPessoaJuridica (String cnpj, String cep, String nomeFicticio, String razaoSocial, String logradouro, long telefone, long ramal, int isContratado, Date dataCadastro) {
       try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_PESSOA_JURIDICA VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cnpj);
            st.setString(2, cep);
            st.setString(3, nomeFicticio.toLowerCase());
            st.setString(4, razaoSocial.toLowerCase());
            st.setString(5, logradouro.toLowerCase());
            st.setLong(6, telefone);
            st.setLong(7, ramal);
            st.setInt(8, isContratado);
            st.setDate(9, dataCadastro);
            st.executeUpdate();
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar a Pessoa Juridica.\n Erro:\n\n" + ex.getMessage());
        } 
    }
    
    public void deletarPessoaFisica (String cpf) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_PESSOA_FISICA WHERE CD_CPF = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cpf);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Pessoa física removida com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover a pessoa física.\nErro:\n\n" + ex.getMessage());
        }
    }
    
    public void deletarPessoaJuridica (String cnpj) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_PESSOA_JURIDICA WHERE CD_CNPJ = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cnpj);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Pessoa jurídica removida com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover a pessoa jurídica.\nErro:\n\n" + ex.getMessage());
        }
    }
    
    
}


