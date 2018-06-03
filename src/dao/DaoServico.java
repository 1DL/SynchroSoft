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
public class DaoServico {

    public static boolean verificarServicoAtivo(int codigoServico) throws SQLException, ClassNotFoundException {
        int aux = 0;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT ID_STATUS_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoServico);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                aux = rs.getInt("ID_STATUS_SERVICO");
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (aux == 1) {
            return true;
        } else {
            return false;
        }

    }

    public void cadastrarServico(String cpfcnpj, int codFunc, int codigoServico, String tipoServico, boolean tipoCliente, String descricaoServico, Date dataServico,
            boolean statusServico) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_SERVICO (CD_SERVICO, DS_TIPO_SERVICO, DS_TIPO_CLIENTE, DS_SERVICO, ID_STATUS_SERVICO, DT_SERVICO_INICIO, DT_SERVICO_FIM) VALUES (?,?,?,?,?,?,?)";
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

            int status = 0;
            if (statusServico) {
                status = 1;
            } else {
                status = 0;
            }
            st.setInt(5, status);

            st.setDate(6, dataServico);
            st.setDate(7, dataServico);

            st.executeUpdate();

            sql = "INSERT INTO SYNCHROSOFT.TB_FUNC_SERVICO (CD_FUNCIONARIO, CD_SERVICO) VALUES (?,?)";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.setInt(1, codFunc);
            st2.setInt(2, codigoServico);
            st2.executeUpdate();

            if (tipoCliente) {
                sql = "INSERT INTO SYNCHROSOFT.TB_PESSOAJ_SERVICO (CD_CNPJ, CD_SERVICO) VALUES (?,?)";
                PreparedStatement st3 = con.prepareStatement(sql);
                st3.setString(1, cpfcnpj);
                st3.setInt(2, codigoServico);
                st3.executeUpdate();
                st3.close();
            } else {
                sql = "INSERT INTO SYNCHROSOFT.TB_PESSOAF_SERVICO (CD_CPF, CD_SERVICO) VALUES (?,?)";
                PreparedStatement st3 = con.prepareStatement(sql);
                st3.setString(1, cpfcnpj);
                st3.setInt(2, codigoServico);
                st3.executeUpdate();
                st3.close();
            }

            st.close();
            st2.close();

            JOptionPane.showMessageDialog(null, "Serviço ativado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Serviço.\n Erro SQL:\n\n" + ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Serviço.\n Erro JAVA:\n\n" + e.getMessage());
        }
    }

    public boolean existeServico(int codserv) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codserv);
        ResultSet rs = st.executeQuery();
        flag = rs.isBeforeFirst();
        st.close();
        rs.close();
        return flag;

    }

    public static boolean isFuncionarioEmServico(int codfunc) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        ArrayList<Long> arrayFunc = new ArrayList<>();
        int status = 0;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_FUNCIONARIO, CD_SERVICO FROM SYNCHROSOFT.TB_FUNC_SERVICO WHERE CD_FUNCIONARIO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codfunc);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            arrayFunc.add(rs.getLong("CD_SERVICO"));
        }
        for (int j = 0; j <= arrayFunc.size() - 1; j++) {
            sql = "SELECT ID_STATUS_SERVICO FROM SYNCHROSOFT.TB_SERVICO WHERE CD_SERVICO = ?";
            PreparedStatement st2 = con.prepareStatement(sql);
            st2.setLong(1, arrayFunc.get(j));
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                status = rs2.getInt("ID_STATUS_SERVICO");
                if (status == 1) {
                    flag = true;
                }
            }
            st2.close();
            rs2.close();
        }
        st.close();
        rs.close();

        return flag;
    }
}
