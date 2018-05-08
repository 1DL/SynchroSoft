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
import model.Endereco;
import model.Funcionario;
import model.Pessoa;
import model.PessoaFisica;

/**
 *
 * @author Luiz
 */
public class DaoFuncionario {

    public void cadastrarFuncionario(int codigoFuncionario, String cepFuncionario, String nome, String cpf, int sexo, long telefone,
            long celular, String numeroCasa, float salario, String cargo, Date dataContrato, int horasTrabalhadas,
            int nivelAdministrativo) throws SQLException, ClassNotFoundException {
        try {
        Connection con = Conexao.conectar();
        String sql = "INSERT INTO SYNCHROSOFT.TB_FUNCIONARIO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigoFuncionario);
        st.setString(2, cepFuncionario);
        st.setString(3, nome);
        st.setString(4, cpf);
        st.setInt(5, sexo);
        st.setLong(6, telefone);
        st.setLong(7, celular);
        st.setString(8, numeroCasa);
        st.setFloat(9, salario);
        st.setString(10, cargo);
        st.setDate(11, dataContrato);
        st.setDate(12, dataContrato);
        st.setInt(13, horasTrabalhadas);
        st.setInt(14, nivelAdministrativo);
        st.executeUpdate();
        st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Funcionário.\n Erro:\n\n" + ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Funcionário.\n Erro:\n\n" + e.getMessage());
        }
    }
    
    public void alterarFuncionario(JTable tabela) throws SQLException, ClassNotFoundException {
//      
        try {

            int rows = tabela.getRowCount();
            String log = "";
            JOptionPane.showConfirmDialog(null, "Deseja realizar a alteração?");

            Connection con = Conexao.conectar();
            con.setAutoCommit(false);
            String sql = "UPDATE SYNCHROSOFT.TB_FUNCIONARIO "
                    + "SET CD_FUNCIONARIO = ?, CD_CEP = ?, NM_FUNCIONARIO = ?, "
                    + "CPF_FUNCIONARIO = ?, ID_SEXO = ?, NR_TELEFONE = ?, NR_CELULAR = ?,"
                    + "NR_LOGRADOURO = ?, VL_SALARIO = ?, DS_CARGO = ?, NR_HORAS_TRABALHO = ?, ID_ADMINISTRATIVO =?"
                    + " WHERE CD_FUNCIONARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int row = 0; row < rows; row++) {
                String cod_alterado = (String) tabela.getValueAt(row, 0);
                String cep = (String) tabela.getValueAt(row, 1);
                String nome = (String) tabela.getValueAt(row, 2);
                String cpf = (String) tabela.getValueAt(row, 3);
                String idsexo = (String) tabela.getValueAt(row, 4);
                int sexo;
                if (idsexo.toLowerCase().substring(0,1).equals("m")) {
                    sexo = 0;
                } else {
                    sexo = 1;
                }

                String tel = (String) tabela.getValueAt(row, 5);
                String cel = (String) tabela.getValueAt(row, 6);
                String nrend = (String) tabela.getValueAt(row, 7);
                String salario = (String) tabela.getValueAt(row, 8);
                String cargo = (String) tabela.getValueAt(row, 9);
                String admissao = (String) tabela.getValueAt(row, 10);
                String demissao = (String) tabela.getValueAt(row, 11);
                Funcionario func = new Funcionario();
                func.setDataContrato(admissao);
                func.setDataDemissao(demissao);
                String horatrab =  (String) tabela.getValueAt(row, 12);
                String nvladm = (String) tabela.getValueAt(row, 13);

                int nivel = 0;
                if ("Visualização".equals(nvladm)) {
                    nivel = 0;
                } else if ("Administrador".equals(nvladm)) {
                    nivel = 1;
                }
                String cod_ref = (String) tabela.getValueAt(row, 14);
                        
                st.setInt(1,Integer.parseInt(cod_alterado));
                st.setString(2, cep);
                st.setString(3, nome);
                st.setString(4, cpf);
                st.setInt(5, sexo);
                st.setLong(6, Long.parseLong(tel));
                st.setLong(7, Long.parseLong(cel));
                st.setString(8, nrend);
                st.setFloat(9, Float.parseFloat(salario));
                st.setString(10, cargo);
                st.setDate(10, func.getDataContrato());
                st.setDate(11, func.getDataDemissao());
                st.setInt(11, Integer.parseInt(horatrab));
                st.setInt(12, nivel);
                st.setInt(13, Integer.parseInt(cod_ref));

                st.addBatch();
                st.executeBatch();
                con.commit();
            }
            JOptionPane.showMessageDialog(null, "A base de Funcionários foi alterada com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a base de Funcionários. \n\n" + ex.getMessage());
        }
        
    }
    
    public static Funcionario popularFuncionario(int codigo) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_FUNCIONARIO, NM_FUNCIONARIO FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        rs.next();
        Funcionario func = new Funcionario();
        func.setCodigoFuncionario(rs.getInt("CD_FUNCIONARIO"));
        Pessoa p = new Pessoa();
        p.setNome(rs.getString("NM_FUNCIONARIO"));
        func.setPessoa(p);
        st.close();
        rs.close();
        return func;
    }
    
    public static boolean existeFuncionario(int codigo) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_FUNCIONARIO FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        flag = rs.isBeforeFirst();
        st.close();
        rs.close();
        return flag;
    }

    public static ArrayList listarFuncionario() {
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                end.setCep(rs.getString("CD_CEP"));
                Pessoa p = new Pessoa(rs.getString("NM_FUNCIONARIO"), end, rs.getLong("NR_TELEFONE"), rs.getString("NR_LOGRADOURO"), 0);
                PessoaFisica pf = new PessoaFisica();
                pf.setPessoa(p);
                pf.setSexo(rs.getInt("ID_SEXO"));
                pf.setCpf(rs.getString("CPF_FUNCIONARIO"));

                Funcionario func = new Funcionario(rs.getInt("CD_FUNCIONARIO"), p, pf, rs.getFloat("VL_SALARIO"),
                        rs.getString("DS_CARGO"), rs.getDate("DT_ADMISSAO"), rs.getDate("DT_DEMISSAO"), rs.getInt("NR_HORAS_TRABALHO"),
                        rs.getInt("ID_ADMINISTRATIVO"));
                lista.add(func);
            }
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DaoFuncionario Instanciamento: " + ex.getMessage());
        }
        return lista;
    }
    
    public void deletarFuncionario(int codigo) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigo);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Funcionário(a) removido com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover o Funcionário.\nErro:\n\n" + ex.getMessage());
        }
    }

    public static ArrayList listarFuncionarioFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            //Chamando método de conexão ao banco
            Connection con = Conexao.conectar();

            //Declarando variável de String de conexão
            String sql = "";
                    

            //            DatabaseMetaData teste = con.getMetaData();
            //            System.out.println(teste.supportsBatchUpdates());
            //Criando estrutura switch case para identificar o tipo de filtro de pesquisa
            switch (cmbFiltro) {
                //preparando sql de acordo com código
                case "Nome":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(NM_FUNCIONARIO) LIKE LOWER(?)";
                    break;

                //preparando tratamento de acordo com nome
                case "Código":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(CD_FUNCIONARIO) LIKE LOWER(?)";
                    break;
                case "CPF":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(CPF_FUNCIONARIO) LIKE LOWER(?)";
                    break;
                case "CEP":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(CD_CEP) LIKE LOWER(?)";
                    break;
                case "Sexo":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(ID_SEXO) LIKE LOWER(?)";
                    break;
                case "Telefone":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(NR_TELEFONE) LIKE LOWER(?)";
                    break;
                case "Celular":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(NR_CELULAR) LIKE LOWER(?)";
                    break;
                case "Salário":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(VL_SALARIO) LIKE LOWER(?)";
                    break;
                case "Cargo":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(DS_CARGO) LIKE LOWER(?)";
                    break;
                case "Data Admissão":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(DT_ADMISSAO) LIKE LOWER(?)";
                    break;
                case "Data Demissão":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(DT_DEMISSAO) LIKE LOWER(?)";
                    break;
                case "Horas Trabalhadas":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(NR_HORAS_TRABALHO) LIKE LOWER(?)";
                    break;
                case "Nível Administrativo":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(ID_ADMINISTRATIVO) LIKE LOWER(?)";
                    break;
                case "Número Endereço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(NR_LOGRADOURO) LIKE LOWER(?)";
                    break;

            }

            //realizando preparedStatement para tratamento de variáveis
            PreparedStatement st = con.prepareStatement(sql);

            //colocando valor da variável ? da query 
            st.setString(1, "%" + txtPesquisa + "%");

            //executando query selecionada pelo switch case
            ResultSet rs = st.executeQuery();

            //listando dados do banco em jtable
           while (rs.next()) {
                Endereco end = new Endereco();
                end.setCep(rs.getString("CD_CEP"));
                Pessoa p = new Pessoa(rs.getString("NM_FUNCIONARIO"), end, rs.getLong("NR_TELEFONE"), rs.getString("NR_LOGRADOURO"), 0);
                PessoaFisica pf = new PessoaFisica();
                pf.setPessoa(p);
                pf.setSexo(rs.getInt("ID_SEXO"));
                pf.setCpf(rs.getString("CPF_FUNCIONARIO"));

                Funcionario func = new Funcionario(rs.getInt("CD_FUNCIONARIO"), p, pf, rs.getFloat("VL_SALARIO"),
                        rs.getString("DS_CARGO"), rs.getDate("DT_ADMISSAO"), rs.getDate("DT_DEMISSAO"), rs.getInt("NR_HORAS_TRABALHO"),
                        rs.getInt("ID_ADMINISTRATIVO"));
                lista.add(func);
            }

            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (Exception ex) { //Caso exista a possibilidade de retorno de erro
            System.err.println("DAOPECA Instanciamento: " + ex);
        }
        //return lista;
        return lista;
    }

    

}
