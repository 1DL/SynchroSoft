/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Endereco;

/**
 *
 * @author LuizV1
 */
public class DaoEndereco {

    public static boolean cadastrarEndereco(Endereco end) {
        boolean aux = false;
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_ENDERECO VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, end.getCep());
            st.setString(2, end.getLogradouro());
            st.setString(3, end.getBairro());
            st.setString(4, end.getCidade());
            st.setString(5, end.getEstado());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!", "Cadastro de Endereço", JOptionPane.INFORMATION_MESSAGE);
            aux = true;
            return aux;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o Endereço.\n\nNº Erro: "
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "DaoEndereco Cadastro", JOptionPane.ERROR_MESSAGE);
            aux = false;
            return aux;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEndereco.class.getName()).log(Level.SEVERE, null, ex);
            aux = false;
            return aux;
        }
    }

    public static void deletarEndereco(String cep) {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_ENDERECO WHERE CD_CEP = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cep);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "O Endereço cujo o CEP - " + cep + " foi removido com sucesso.",
                    "Exclusão concluída", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover o endereço.\n\nErro Nº :"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro : DaoEndereco - Deletar Endereço", 0);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover o endereço.\n\nErro:"
                    + ex, "Erro : DaoEndereco - Deletar Endereço", 0);
        }
    }
    
    public static boolean deletarTodosEnderecos() {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_ENDERECO";
            PreparedStatement st = con.prepareStatement(sql);
    
            st.executeUpdate();
            st.close();
            
            JOptionPane.showMessageDialog(null, "Todos os registros de Endereços foram removidos do banco de dados.",
                    "Exclusão total concluída", 1);
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover os endereços.\n\nErro Nº :"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro : DaoEndereco - Deletar Endereço", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover os endereços.\n\nErro:"
                    + ex, "Erro : DaoEndereco - Deletar Endereço", 0);
            return false;
        }
    }

    public static ArrayList listarEndereco() {
        ArrayList<Endereco> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_ENDERECO";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco(rs.getString("CD_CEP"), rs.getString("DS_LOGRADOURO"),
                        rs.getString("NM_BAIRRO"), rs.getString("NM_CIDADE"), rs.getString("SG_ESTADO"));
                lista.add(end);
            }
            st.close();
            rs.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os endereços.\n\n Erro Nº"
            +ex.getErrorCode()+"\n"+ex.getMessage(), "Erro: DaoEndereco - Listar Endereço",0);
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os endereços.\n\n Erro:"
            +ex, "Erro: DaoEndereco - Listar Endereço",0);
            return null;
        }
    }

    public static boolean existeEndereco(String cep) {
        boolean flag = false;
        try {

            Connection con = Conexao.conectar();
            String sql = "SELECT CD_CEP FROM SYNCHROSOFT.TB_ENDERECO WHERE CD_CEP = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cep);
            ResultSet rs = st.executeQuery();
            flag = rs.isBeforeFirst();
            st.close();
            rs.close();
            return flag;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível verificar a existência  do Endereço.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoEndereco - Existe Endereco", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEndereco.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static Endereco popularEndereco(String cep) {
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * "
                    + "FROM SYNCHROSOFT.TB_ENDERECO "
                    + "WHERE CD_CEP = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cep);
            ResultSet rs = st.executeQuery();
            rs.next();
            Endereco end = new Endereco(rs.getString("CD_CEP"), rs.getString("DS_LOGRADOURO"),
                    rs.getString("NM_BAIRRO"), rs.getString("NM_CIDADE"), rs.getString("SG_ESTADO"));
            st.close();
            rs.close();
            return end;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível popular o Endereço.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoEndereco - Popular Endereco", 0);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoEndereco.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static boolean alterarEndereco(Endereco end, String PK_REF) {
        try {
            Connection con = Conexao.conectar();
            String sql = "UPDATE SYNCHROSOFT.TB_ENDERECO "
                    + "SET CD_CEP = ?, DS_LOGRADOURO = ?, NM_BAIRRO = ?, "
                    + "NM_CIDADE= ?, SG_ESTADO= ? WHERE CD_CEP = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, end.getCep());
            st.setString(2, end.getLogradouro());
            st.setString(3, end.getBairro());
            st.setString(4, end.getCidade());
            st.setString(5, end.getEstado());
            st.setString(6, PK_REF);
            
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "O endereço foi alterado com sucesso!",
                    "Alteração concluída", 1);
            
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar alterar o endereço.\n\nErro Nº "+
                ex.getErrorCode()+"\n"+ex.getMessage(),"Erro: DaoEndereco - Alterar Endereço", 0);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar alterar o endereço.\n\nErro:"+
                ex,"Erro: DaoEndereco - Alterar Endereço", 0);
            return false;
        }
    }

    public static ArrayList listarEnderecoFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<Endereco> lista = new ArrayList<>();
        try {
            //Chamando método de conexão ao banco
            Connection con = Conexao.conectar();
            //Declarando variável de String de conexão
            String sql = "";
            //Criando estrutura switch case para identificar o tipo de filtro de pesquisa
            switch (cmbFiltro) {
                //preparando sql de acordo com cep
                case "CEP":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ENDERECO WHERE LOWER(CD_CEP) LIKE LOWER(?)";
                    break;

                //preparando tratamento de acordo com o logradouro
                case "Logradouro":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ENDERECO WHERE LOWER(DS_LOGRADOURO) LIKE LOWER(?)";
                    break;

                //preparando tratamento de acordo com o bairro
                case "Bairro":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ENDERECO WHERE LOWER(NM_BAIRRO) LIKE LOWER(?)";
                    break;

                //preparando tratamento de acordo com a cidade
                case "Cidade":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ENDERECO WHERE LOWER(NM_CIDADE) LIKE LOWER(?)";
                    break;

                //preparando tratamento de acordo com valor do estado
                case "Estado":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_ENDERECO WHERE LOWER(SG_ESTADO) LIKE LOWER(?)";
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
                Endereco end = new Endereco(rs.getString("CD_CEP"), rs.getString("DS_LOGRADOURO"),
                        rs.getString("NM_BAIRRO"), rs.getString("NM_CIDADE"), rs.getString("SG_ESTADO"));
                lista.add(end);
            }

            //teste de funcionamento do método
            System.out.println(lista.get(0).getCidade());

            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (Exception ex) { //Caso exista a possibilidade de retorno de erro
            System.err.println("DaoEndereco Instanciamento: " + ex.getMessage());
        }
        //return lista;
        return lista;
    }

}
