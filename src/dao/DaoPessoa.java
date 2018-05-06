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
import model.PessoaJuridica;

/**
 *
 * @author LuizV1
 */
public class DaoPessoa {

    public void cadastrarPessoaFisica(String cpf, String cep, String nomeFisica, int sexo, long telefone, long celular, String complemento, Date dataCadastro, int isContratado) {
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

    public static PessoaFisica popularPessoaFisica(String cpf, String cep) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA WHERE CD_CPF = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cpf);
        ResultSet rs = st.executeQuery();
        rs.next();
        Endereco end = new Endereco();
        end = DaoEndereco.popularEndereco(cep);
        Pessoa p = new Pessoa(rs.getString("NM_PESSOA_FISICA"), end, rs.getLong("NR_TELEFONE"), rs.getString("NR_COMPLEMENTO_LOGRADOURO"), rs.getInt("ID_CONTRATO"));
        PessoaFisica pf = new PessoaFisica(p, rs.getString("CD_CPF"), rs.getDate("DT_CADASTRO"), rs.getLong("NR_CELULAR"), rs.getInt("ID_SEXO"));
        st.close();
        rs.close();
        return pf;
    }

    public static boolean existePessoaFisica(String cpf) throws SQLException, ClassNotFoundException {
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

    public void cadastrarPessoaJuridica(String cnpj, String cep, String nomeFicticio, String razaoSocial, String logradouro, long telefone, long ramal, int isContratado, Date dataCadastro) {
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

    public void deletarPessoaFisica(String cpf) throws SQLException, ClassNotFoundException {
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

    public void deletarPessoaJuridica(String cnpj) throws SQLException, ClassNotFoundException {
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
                end.setCep(rs.getString("CD_CEP"));
                end.setLogradouro(rs.getString("DS_LOGRADOURO"));
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
            System.err.println("DaoPessoa Instanciamento: " + ex);
        }
        //return lista;
        return lista;
    }

    public static ArrayList listarPessoaJuridica() {
        ArrayList<PessoaJuridica> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
//            DatabaseMetaData teste = con.getMetaData();
//            System.out.println(teste.supportsBatchUpdates());
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP)";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                end.setCep(rs.getString("CD_CEP"));
                end.setLogradouro("DS_LOGRADOURO");
                Pessoa p = new Pessoa(rs.getString("NM_FICTICIO"),
                        end,
                        rs.getLong("NR_TELEFONE"),
                        rs.getString("NR_LOGRADOURO"),
                        rs.getInt("ID_CONTRATO"));
                PessoaJuridica pessoaJ = new PessoaJuridica(p,
                        rs.getString("CD_CNPJ"),
                        rs.getString("NM_RAZAO_SOCIAL"),
                        rs.getDate("DT_CADASTRO"),
                        rs.getInt("NR_RAMAL"));

                lista.add(pessoaJ);

                /*lista.add(new String[]{String.valueOf(rs.getInt("CD_PECA")),
                (rs.getString("NM_PECA")),(rs.getString("DS_CATEGORIA")),
                String.valueOf(rs.getInt("QT_PECA")),String.valueOf(rs.getFloat("VL_PECA"))});                
                System.out.println(lista.get(0));*/
            }

            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DAOPESSOA Instanciamento: " + ex);
        }
        //return lista;
        return lista;
    }

    public static ArrayList listarPessoaFisicaFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<PessoaFisica> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "";
            /*
Nome
CPF
Sexo
CEP
Endereço
Número Endereço
Telefone
Celular
Contrato
Data de Cadastro
            
             */
            switch (cmbFiltro) {

                case "Nome":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE NM_PESSOA_FISICA LIKE ?";
                    break;
                case "CPF":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE CD_CPF LIKE ?";
                    break;
                case "Sexo":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE ID_SEXO LIKE ?";
                    break;
                case "CEP":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE CD_CEP LIKE ?";
                    break;
                case "Eendereço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE SYNCHROSOFT.TB_ENDERECO.CD_CEP LIKE ?";
                    break;
                case "Número Endereço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE NR_COMPLEMENTO_LOGRADOURO LIKE ?";
                    break;
                case "Telefone":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE NR_TELEFONE LIKE ?";
                    break;
                case "Celular":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE NR_CELULAR LIKE ?";
                    break;
                case "Contrato":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE ID_CONTRATO LIKE ?";
                    break;
                case "Data de Cadastro":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE DT_CADASTRO LIKE ?";
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
                end.setLogradouro(rs.getString("DS_LOGRADOURO"));
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

            }

            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (Exception ex) { //Caso exista a possibilidade de retorno de erro
            System.err.println("DAOPessoa Instanciamento: " + ex);
        }
        //return lista;
        return lista;
    }

    public static ArrayList listarPessoaJuridicaFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<PessoaJuridica> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "";
            /*
CNPJ
CEP
Nome Fictício
Razão Social
Número Endereço
Telefone
Ramal
Contrato
Data Cadastro
            
             */
            switch (cmbFiltro) {

                case "CNPJ":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE CD_CNPJ LIKE ?";
                    break;
                case "CEP":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE CD_CEP LIKE ?";
                    break;
                case "Nome Fictício":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE NM_FICTICIO LIKE ?";
                    break;
                case "Razão Social":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE NM_RAZAO_SOCIAL LIKE ?";
                    break;
                case "Número Endereço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE NR_LOGRADOURO LIKE ?";
                    break;
                case "Telefone":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE NR_TELEFONE LIKE ?";
                    break;
                case "Ramal":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE NR_RAMAL LIKE ?";
                    break;
                case "Contrato":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE ID_CONTRATO LIKE ?";
                    break;
                case "Data Cadastro":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE DT_CADASTRO LIKE ?";
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
                end.setLogradouro("DS_LOGRADOURO");
                Pessoa p = new Pessoa(rs.getString("NM_FICTICIO"),
                        end,
                        rs.getLong("NR_TELEFONE"),
                        rs.getString("NR_LOGRADOURO"),
                        rs.getInt("ID_CONTRATO"));
                PessoaJuridica pessoaJ = new PessoaJuridica(p,
                        rs.getString("CD_CNPJ"),
                        rs.getString("NM_RAZAO_SOCIAL"),
                        rs.getDate("DT_CADASTRO"),
                        rs.getInt("NR_RAMAL"));

                lista.add(pessoaJ);

            }

            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (Exception ex) { //Caso exista a possibilidade de retorno de erro
            System.err.println("DAOPessoa Instanciamento: " + ex);
        }
        //return lista;
        return lista;
    }

    public void alterarPessoaFisica(JTable tabela) throws SQLException, ClassNotFoundException {
//      
        try {

            int rows = tabela.getRowCount();
            String log = "";
            JOptionPane.showConfirmDialog(null, "Deseja realizar a alteração?");

            Connection con = Conexao.conectar();
            con.setAutoCommit(false);
            String sql = "UPDATE SYNCHROSOFT.TB_PESSOA_FISICA "
                    + "SET CD_CPF = ?, CD_CEP = ?, NM_PESSOA_FISICA = ?, "
                    + "ID_SEXO = ?, NR_TELEFONE = ?, NR_CELULAR = ?, NR_COMPLEMENTO_LOGRADOURO = ?,"
                    + "DT_CADASTRO = ?, ID_CONTRATO = ? WHERE CD_CPF = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int row = 0; row < rows; row++) {
                String CD_CPF = (String) tabela.getValueAt(row, 1);
                String CD_CEP = (String) tabela.getValueAt(row, 3);
                String NM_PESSOA_FISICA = (String) tabela.getValueAt(row, 0);
                String ID_SEXO = (String) tabela.getValueAt(row, 2);
                int sexo;
                if (ID_SEXO == "Masculino") {
                    sexo = 0;
                } else {
                    sexo = 1;
                }

                String NR_TELEFONE = (String) tabela.getValueAt(row, 6);
                String NR_CELULAR = (String) tabela.getValueAt(row, 7);
                String NR_COMPLEMENTO_LOGRADOURO = (String) tabela.getValueAt(row, 5);
                Object DT_CADASTRO = tabela.getValueAt(row, 9);
                String ID_CONTRATO = (String) tabela.getValueAt(row, 8);

                int contrato;
                if (ID_CONTRATO == "Não possui contrato") {
                    contrato = 1;
                } else {
                    contrato = 0;
                }

                st.setString(1, CD_CPF);
                st.setString(2, CD_CEP);
                st.setString(3, NM_PESSOA_FISICA);
                st.setInt(4, sexo);
                st.setLong(5, Long.parseLong(NR_TELEFONE));
                st.setLong(6, Long.parseLong(NR_CELULAR));
                st.setInt(7, Integer.parseInt(NR_COMPLEMENTO_LOGRADOURO));

                st.setDate(8, (Date) DT_CADASTRO);
                st.setInt(9, contrato);
                st.setString(10, CD_CPF);

                st.addBatch();
                st.executeBatch();
                con.commit();
            }
            JOptionPane.showMessageDialog(null, "A base de pessoas físicas foi alterada com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a base de pessoas físicas. \n\n" + ex.getMessage());
        }

    }

    public void alterarPessoaJuridica(JTable tabela) throws SQLException, ClassNotFoundException {
//      
        try {

            int rows = tabela.getRowCount();
            String log = "";
            JOptionPane.showConfirmDialog(null, "Deseja realizar a alteração?");

            Connection con = Conexao.conectar();
            con.setAutoCommit(false);
            String sql = "UPDATE SYNCHROSOFT.TB_PESSOA_JURIDICA "
                    + "SET CD_CNPJ = ?, CD_CEP = ?, NM_FICTICIO = ?, "
                    + "NM_RAZAO_SOCIAL = ?, NR_LOGRADOURO = ?, NR_TELEFONE = ?, "
                    + "NR_RAMAL = ?,"
                    + "ID_CONTRATO = ?, DT_CADASTRO = ? WHERE CD_CNPJ = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int row = 0; row < rows; row++) {
                String cnpj = (String) tabela.getValueAt(row, 0);
                String cep = (String) tabela.getValueAt(row, 1);
                String nomeFicticio = (String) tabela.getValueAt(row, 2);
                String razaoSocial = (String) tabela.getValueAt(row, 3);
                String numero = (String) tabela.getValueAt(row, 4);
                String telefone = (String) tabela.getValueAt(row, 5);
                String ramal = (String) tabela.getValueAt(row, 6);
                String contrato = (String) tabela.getValueAt(row, 7);
                Object dataCadastro = tabela.getValueAt(row, 8);

                if (contrato.equals("Sim")) {
                    contrato = "1";
                } else if (contrato.equals("Não")) {
                    contrato = "0";
                }
                st.setString(1, cnpj);
                st.setString(2, cep);
                st.setString(3, nomeFicticio);
                st.setString(4, razaoSocial);
                st.setString(5, numero);
                st.setLong(6, Long.parseLong(telefone));
                st.setLong(7, Long.parseLong(ramal));
                st.setInt(8, Integer.parseInt(contrato));
                st.setDate(9, (Date) dataCadastro);
                st.setString(10, cnpj);
                st.addBatch();
                st.executeBatch();
                con.commit();
            }
            JOptionPane.showMessageDialog(null, "A base de pessoas Jurídicas foi alterada com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a base de pessoas Jurídicas. \n\n" + ex.getMessage());
        }
    }

}
