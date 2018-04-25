/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Peca;
import model.Pessoa;
import model.PessoaFisica;

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
    
    public static ArrayList listarPessoaFisica() {
        ArrayList<PessoaFisica> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
//            DatabaseMetaData teste = con.getMetaData();
//            System.out.println(teste.supportsBatchUpdates());
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP)";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                Pessoa p = new Pessoa(rs.getString("NM_PESSOA_FISICA"),
                                      end,
                                      rs.getLong("NR_TELEFONE"),
                                      rs.getString("NR_COMPLEMENTO_LOGRADOURO"),
                                      rs.getInt("ID_CONTRATO"));
                PessoaFisica pessoaF = new PessoaFisica(p, 
                                                        rs.getString("CD_CPF"),
                                                        rs.getDate("DT_CADASTRO"),
                                                        rs.getLong("NR_CELULAR"),
                                                        rs.getInt("ID_SEXO"));
                
                lista.add(pessoaF);

                /*lista.add(new String[]{String.valueOf(rs.getInt("CD_PECA")),
                (rs.getString("NM_PECA")),(rs.getString("DS_CATEGORIA")),
                String.valueOf(rs.getInt("QT_PECA")),String.valueOf(rs.getFloat("VL_PECA"))});                
                System.out.println(lista.get(0));*/
            }
            
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DAOPECA Instanciamento: " + ex);
        }
        //return lista;
        return lista;
    }
    
    public void alterarPessoaFisica(JTable tabela) throws SQLException, ClassNotFoundException, ParseException {
//      
        try{
            
            int rows = tabela.getRowCount();
            String log = "";
            JOptionPane.showConfirmDialog(null, "Deseja realizar a alteração?");

            Connection con = Conexao.conectar();
            con.setAutoCommit(false);
            String sql = "UPDATE SYNCHROSOFT.TB_PESSOA_FISICA "
                    + "SET CD_CPF = ?, NM_PESSOA_FISICA = ?, "
                    + "ID_SEXO = ?, NR_TELEFONE = ?, NR_CELULAR = ?, NR_COMPLEMENTO_LOGRADOURO = ?,"
                    + "DT_CADASTRO = ?, ID_CONTRATO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int row = 0; row < rows; row++) {
                
                String CD_CPF = (String) tabela.getValueAt(row, 1);
                String NM_PESSOA_FISICA = (String) tabela.getValueAt(row, 0);
                String ID_SEXO = (String) tabela.getValueAt(row, 2);
                String NR_TELEFONE = (String) tabela.getValueAt(row, 6);
                String NR_CELULAR = (String) tabela.getValueAt(row, 7);
                String NR_COMPLEMENTO_LOGRADOURO = (String) tabela.getValueAt(row, 5);
                String DT_CADASTRO = (String) tabela.getValueAt(row, 9);
                String ID_CONTRATO = (String) tabela.getValueAt(row, 8);
                
                st.setInt(1, Integer.parseInt(CD_CPF));
                st.setString(2, NM_PESSOA_FISICA);
                st.setInt(3, Integer.parseInt(ID_SEXO));
                st.setInt(4, Integer.parseInt(NR_TELEFONE));
                st.setInt(4, Integer.parseInt(NR_CELULAR));
                st.setInt(4, Integer.parseInt(NR_COMPLEMENTO_LOGRADOURO));
                
                //aplicando formato de data oracle
                final String OLD_FORMAT = "yyyy/MM/dd";
                final String NEW_FORMAT = "dd/MM/yyyy";

                // August 12, 2010
                String oldDateString = DT_CADASTRO;
                String newDateString;

                SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
                Date d = (Date) sdf.parse(oldDateString);
                sdf.applyPattern(NEW_FORMAT);
                newDateString = sdf.format(d);
                
                st.setDate(5, Date.valueOf(DT_CADASTRO));
                st.setInt(3, Integer.parseInt(ID_CONTRATO));
                

                st.addBatch();
                st.executeBatch();
                con.commit();
                JOptionPane.showMessageDialog(null, "A base de pessoas físicas foi alterada com sucesso!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a base de pessoas físicas. \n\n"+ex.getMessage());
        }
    }
    
}


