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
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Endereco;
import model.Funcionario;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Servico;
import view.FrmListagemServico;

/**
 *
 * @author LuizV1
 */
public class DaoOrcamento {

    public static boolean existeOrcamento (int codigoServico) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM SYNCHROSOFT.TB_ORCAMENTO WHERE CD_SERVICO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoServico);
        ResultSet rs = st.executeQuery();
        flag = rs.isBeforeFirst();
        st.close();
        rs.close();
        return flag;
    }
    
    
}
