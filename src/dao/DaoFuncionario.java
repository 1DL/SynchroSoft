/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.PessoaFisica;

/**
 *
 * @author Luiz
 */
public class DaoFuncionario {
    
    public void cadastrarFuncionario(int codigoFuncionario, String cepFuncionario, String nome, String cpf, boolean sexo, int telefone, int celular, String complementoLogradouro, float salario, String cargo, Date dataContrato, int horasTrabalhadas, boolean nivelAdministrativo) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_FUNCIONARIO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigoFuncionario);
            st.setString(2, cepFuncionario.toLowerCase());
            st.setString(3, nome.toLowerCase());
            st.setString(4, cpf.toLowerCase());
            st.setBoolean(5, sexo);
            st.setInt(6, telefone);
            st.setInt(7, celular);
            st.setString(8, complementoLogradouro);
            st.setFloat(9, salario);
            st.setString(10, cargo);
            st.setDate(11, dataContrato);
            st.setDate(12, null);
            st.setInt(13, horasTrabalhadas);
            st.setBoolean(14, nivelAdministrativo);
            st.executeUpdate();
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar a peça.\n Erro:\n\n" + ex.getMessage());
        }
    }
    
}
