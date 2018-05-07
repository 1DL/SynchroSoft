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

/**
 *
 * @author LuizV1
 */
public class DaoDespesa {
    
    public void cadastrarDespesa (int cod, String tipoDesp, Date dataDespesa, String descricao, float valor) throws SQLException, ClassNotFoundException {
        try{
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO SYNCHROSOFT.TB_DESPESA VALUES (?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, cod);
        st.setString(2, tipoDesp);
        st.setDate(3, dataDespesa);
        st.setString(4, descricao);
        st.setFloat(5, valor);
        st.executeUpdate();
        st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Funcionário.\n Erro SQL:\n\n" + ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Funcionário.\n Erro JAVA:\n\n" + e.getMessage());
        }
    }
}
