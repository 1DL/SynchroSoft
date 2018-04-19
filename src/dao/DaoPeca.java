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
import model.Peca;

/**
 *
 * @author LuizV1
 */
public class DaoPeca {

    public void cadastrarPeca(int cod, String nome, String cat, int qtd, float valor) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_PECA VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cod);
            st.setString(2, nome);
            st.setString(3, cat);
            st.setInt(4, qtd);
            st.setFloat(5, valor);
            st.executeUpdate();
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a peça.\nErro:\n\n" + ex.getMessage());
        }
    }
    
    public void deletarPeca (int cod) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_PECA WHERE CD_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cod);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Peça removida com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover a peça.\nErro:\n\n" + ex.getMessage());
        }
    }

    public static ArrayList listarPeca() {
        ArrayList<Peca> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
//            DatabaseMetaData teste = con.getMetaData();
//            System.out.println(teste.supportsBatchUpdates());
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PECA";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
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
            System.err.println("DAOPECA Instanciamento: " + ex);
        }
        //return lista;
        return lista;
    }

    public void alterarPeca(JTable tabela) throws SQLException, ClassNotFoundException {
        
        try{
            int rows = tabela.getRowCount();
            String log = "";

            Connection con = Conexao.conectar();
            con.setAutoCommit(false);
            String sql = "UPDATE SYNCHROSOFT.TB_PECA "
                    + "SET CD_PECA = ?, NM_PECA = ?, DS_CATEGORIA = ?, "
                    + "QT_PECA = ?, VL_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int row = 0; row < rows; row++) {
                
                int CD_PECA = (int) tabela.getValueAt(row, 0);
                String NM_PECA = (String) tabela.getValueAt(row, 1);
                String DS_CATEGORIA = (String) tabela.getValueAt(row, 2);
                int QT_PECA = (int) tabela.getValueAt(row, 3);
                float VL_PECA = (float) tabela.getValueAt(row, 4);

                st.setInt(1, CD_PECA);                
                st.setString(2, NM_PECA);
                st.setString(3, DS_CATEGORIA);
                st.setInt(4, QT_PECA);
                st.setFloat(5, VL_PECA);
                
                
//                log = "" + CD_PECA + " ";
//                System.out.println(CD_PECA);
//                log = "" + NM_PECA + " ";
//                log = "" + DS_CATEGORIA + " ";
//                log = "" + QT_PECA + " ";
//                log = "" + VL_PECA + " /n/n";

                st.addBatch();
                st.executeBatch();
                con.commit();
                JOptionPane.showMessageDialog(null, "A base de peças foi alterada com sucesso!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a base de Peças. \n\n"+ex.getMessage());
        }

    }


}
