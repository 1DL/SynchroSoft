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
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author LuizV1
 */
public class DaoServico {

    public void cadastrarServico(int codigoServico, String tipoServico, boolean tipoCliente, String descricaoServico, Date dataServico, 
            boolean statusServico) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_SERVICO (CD_SERVICO, DS_TIPO_SERVICO, DS_TIPO_CLIENTE, DS_SERVICO, ID_STATUS_SERVICO) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoServico);
            int serv = 0;
            if (tipoServico.equals("Preventivo")) {
                serv = 0;
            } else if (tipoServico.equals("Corretivo")) {
                serv = 1;
            } else {
                serv = 2;
            }
            st.setInt(2, serv);
            int tipo = 0;
            if (tipoCliente) {
                tipo = 0;
            } else {
                tipo = 1;
            }
            st.setInt(3, tipo);
            st.setString(4, descricaoServico);
            st.setDate(5, dataServico);
//            st.setFloat(6, valorServico);
            int status = 0;
            if (statusServico) {
                status = 1;
            } else {
                status = 0;
            }
            st.setInt(6, status);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Serviço ativado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Funcionário.\n Erro:\n\n" + ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Funcionário.\n Erro:\n\n" + e.getMessage());
        }
    }
    
    
    public static boolean isFuncionarioEmServico(int codfunc) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        long[] arrayFunc = null;
        int i = 0;
        int status = 0;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_FUNCIONARIO, CD_SERVICO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_FUNCIONARIO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codfunc);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            arrayFunc[i] = rs.getLong("CD_SERVICO");
            i++;
        }
        for (int j = 0; j <= i; j++){
        sql = "SELECT ID_STATUS_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st2 = con.prepareStatement(sql);
        st2.setLong(1, arrayFunc[j]);
        while(rs.next()) {
            status = rs.getInt("ID_STATUS_SERVICO");
            if (status == 1) {
                flag = true;                
            }
        }
        }
        st.close();
        rs.close();
        return flag;
    }
}
