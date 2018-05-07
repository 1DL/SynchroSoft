/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Despesa;
import model.Endereco;
import model.Funcionario;
import model.Pessoa;
import model.PessoaFisica;

/**
 *
 * @author LuizV1
 */
public class DaoDespesa {

    public void cadastrarDespesa(String tipoDesp, Date dataDespesa, String descricao, float valor) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_DESPESA (DS_TIPO_DESPESA, DT_DESPESA, DS_DESPESA, VL_DESPESA) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tipoDesp);
            st.setDate(2, dataDespesa);
            st.setString(3, descricao);
            st.setFloat(4, valor);
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Funcionário.\n Erro SQL:\n\n" + ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Funcionário.\n Erro JAVA:\n\n" + e.getMessage());
        }
    }

    public static ArrayList listarDespesa() {
        ArrayList<Despesa> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA ORDER BY CD_DESPESA";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Despesa d = new Despesa();
                d.setCodigoDespesa(rs.getInt("CD_DESPESA"));
                d.setTipoDespesas(rs.getString("DS_TIPO_DESPESA"));
                d.setDataDespesa(rs.getDate("DT_DESPESA").toString());
                d.setDescricaoDespesa(rs.getString("DS_DESPESA"));
                d.setValorDespesa(rs.getFloat("VL_DESPESA"));
                lista.add(d);
            }
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DaoDespesa Listagem Java: " + ex.getMessage());
        }
        return lista;
    }

    public void deletarDespesa(int cod) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_DESPESA WHERE CD_DESPESA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cod);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Despesa removido com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover a Despesa.\nErro:\n\n" + ex.getMessage());
        }
    }
    
    public static ArrayList listarDespesaFiltradaData(String antes, String depois) {
        ArrayList<Despesa> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE DT_DESPESA BETWEEN TO_DATE (?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd') ORDER BY CD_DESPESA";
          
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, antes);
            st.setString(2, depois);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Despesa d = new Despesa();
                d.setCodigoDespesa(rs.getInt("CD_DESPESA"));
                d.setTipoDespesas(rs.getString("DS_TIPO_DESPESA"));
                d.setDataDespesa(rs.getDate("DT_DESPESA").toString());
                d.setDescricaoDespesa(rs.getString("DS_DESPESA"));
                d.setValorDespesa(rs.getFloat("VL_DESPESA"));
                lista.add(d);
            }
            st.close();
            rs.close();
        }catch (ClassNotFoundException | SQLException ex) {
            System.err.println("DaoDespesa Listagem Java: " + ex.getMessage());
        }
        return lista;
    }


    public static ArrayList listarDespesaFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<Despesa> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "";
            /*
Código
Tipo
Data
Descrição
Valor            
             */

            switch (cmbFiltro) {
                case "Código":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(CD_DESPESA) LIKE LOWER(?)";
                    break;
                case "Tipo":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(DS_TIPO_DESPESA) LIKE LOWER(?)";
                    break;
                case "Data":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(DT_DESPESA) LIKE LOWER(?)";
                    break;
                case "Descrição":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(DS_DESPESA) LIKE LOWER(?)";
                    break;
                case "Valor":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(VL_DESPESA) LIKE LOWER(?)";
                    break;
            }
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, "%" + txtPesquisa + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Despesa d = new Despesa();
                d.setCodigoDespesa(rs.getInt("CD_DESPESA"));
                d.setTipoDespesas(rs.getString("DS_TIPO_DESPESA"));
                d.setDataDespesa(rs.getDate("DT_DESPESA").toString());
                d.setDescricaoDespesa(rs.getString("DS_DESPESA"));
                d.setValorDespesa(rs.getFloat("VL_DESPESA"));
                lista.add(d);
            }
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DaoDespesa Listagem Java: " + ex.getMessage());
        }
        return lista;
    }

    public void alterarDespesa(JTable tabela) throws SQLException, ClassNotFoundException {
        try {
            int rows = tabela.getRowCount();
            String log = "";
            JOptionPane.showConfirmDialog(null, "Deseja realizar a alteração?");
            Connection con = Conexao.conectar();
            con.setAutoCommit(false);
            String sql = "UPDATE SYNCHROSOFT.TB_DESPESA "
                    + "SET CD_DESPESA = ?, DS_TIPO_DESPESA = ?, DT_DESPESA = ?, "
                    + "DS_DESPESA = ?, VL_DESPESA= ? "
                    + "WHERE CD_DESPESA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int row = 0; row < rows; row++) {
                String cod_alterado = (String) tabela.getValueAt(row, 0);
                String tipo = (String) tabela.getValueAt(row, 1);
                String data = (String) tabela.getValueAt(row, 2);
                Despesa d = new Despesa();
                d.setDataDespesa(data);
                String descricao = (String) tabela.getValueAt(row, 3);
                String valor = (String) tabela.getValueAt(row, 4);
                String cod_ref = (String) tabela.getValueAt(row, 5);

                st.setInt(1, Integer.parseInt(cod_alterado));
                st.setString(2, tipo);
                st.setDate(3, d.getDataDespesa());
                st.setString(4, descricao);
                st.setFloat(5, Float.parseFloat(valor));
                st.setLong(6, Integer.parseInt(cod_ref));

                st.addBatch();
                st.executeBatch();
                con.commit();
            }
            JOptionPane.showMessageDialog(null, "A base de Funcionários foi alterada com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a base de Funcionários. \n\n" + ex.getMessage());
        }

    }
}
