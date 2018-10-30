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
import javax.swing.JTable;
import model.Endereco;
import model.Pessoa;
import model.PessoaFisica;
import model.PessoaJuridica;

/**
 *
 * @author LuizV1
 */
public class DaoPessoa {

    public static boolean cadastrarPessoaFisica(PessoaFisica fisica) {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_PESSOA_FISICA VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, fisica.getCpf());
            st.setString(2, fisica.getPessoa().getEndereco().getCep());
            st.setString(3, fisica.getPessoa().getNome());
            st.setInt(4, fisica.getSexoBanco());
            st.setLong(5, fisica.getPessoa().getTelefone());
            st.setLong(6, fisica.getCelular());
            st.setString(7, fisica.getPessoa().getComplementoLogradouro());
            st.setDate(8, Date.valueOf(control.Datas.converterParaAmericana(fisica.getDataCadastro())));
            st.setInt(9, fisica.getPessoa().getManterContrato());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "A pessoa física foi cadastrada com sucesso!", "Cadastro de pessoa física", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar a pessoa física.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoPessoa - Cadastrar pessoa física", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static PessoaFisica popularPessoaFisica(String cpf) {
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA WHERE CD_CPF = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cpf);
            ResultSet rs = st.executeQuery();
            rs.next();

            Endereco end = new Endereco();
            end = DaoEndereco.popularEndereco(rs.getString("CD_CEP"));
            end.setCep(rs.getString("CD_CEP"));

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(rs.getString("NM_PESSOA_FISICA"));
            pessoa.setEndereco(end);
            pessoa.setTelefone(rs.getString("NR_TELEFONE"));
            pessoa.setComplementoLogradouro(rs.getString("NR_COMPLEMENTO_LOGRADOURO"));
            pessoa.setManterContratoBanco(rs.getInt("ID_CONTRATO"));

            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.setPessoa(pessoa);
            pessoaFisica.setCpf(rs.getString("CD_CPF"));
            pessoaFisica.setSexoBanco(rs.getInt("ID_SEXO"));
            pessoaFisica.setCelular(String.valueOf(rs.getLong("NR_CELULAR")));
            pessoaFisica.setDataCadastroBanco(rs.getDate("DT_CADASTRO").toString());

            st.close();
            rs.close();

            return pessoaFisica;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível popular os dados da pessoa física.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoPessoa - Popular pessoa física", 0);
            return null;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static PessoaFisica popularPessoaFisicaSemCep(String cpf) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA WHERE CD_CPF = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cpf);
        ResultSet rs = st.executeQuery();
        rs.next();

        Endereco end = new Endereco();
        end = DaoEndereco.popularEndereco(rs.getString("CD_CEP"));
        end.setCep(rs.getString("CD_CEP"));

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("NM_PESSOA_FISICA");
        pessoa.setEndereco(end);
        pessoa.setTelefone(rs.getString("NR_TELEFONE"));
        pessoa.setComplementoLogradouro(rs.getString("NR_COMPLEMENTO_LOGRADOURO"));
        pessoa.setManterContratoBanco(rs.getInt("ID_CONTRATO"));

        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setPessoa(pessoa);
        pessoaFisica.setCpf(rs.getString("CD_CPF"));
        pessoaFisica.setSexoBanco(rs.getInt("ID_SEXO"));
        pessoaFisica.setCelular(String.valueOf(rs.getLong("NR_CELULAR")));
        pessoaFisica.setDataCadastroBanco((control.Datas.converterParaBrasileira(String.valueOf(rs.getDate("DT_CADASTRO")))));

        st.close();
        rs.close();

        return pessoaFisica;
    }

    public static PessoaJuridica popularPessoaJuridica(String cnpj, String cep) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA WHERE CD_CNPJ = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cnpj);
        ResultSet rs = st.executeQuery();
        rs.next();

        Endereco end = new Endereco();
        end = DaoEndereco.popularEndereco(cep);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(rs.getString("NM_RAZAO_SOCIAL"));
        pessoa.setEndereco(end);
        pessoa.setTelefone(String.valueOf(rs.getLong("NR_TELEFONE")));
        pessoa.setComplementoLogradouro(rs.getString("NR_LOGRADOURO"));
        pessoa.setManterContratoBanco(rs.getInt("ID_CONTRATO"));

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setPessoa(pessoa);
        pessoaJuridica.setCnpj(rs.getString("CD_CNPJ"));
        pessoaJuridica.setRazaoSocial(rs.getString("NM_RAZAO_SOCIAL"));
        pessoaJuridica.setDataCadastroBanco(control.Datas.converterParaBrasileira(String.valueOf(rs.getDate("DT_CADASTRO"))));
        pessoaJuridica.setRamalCliente(String.valueOf(rs.getInt("NR_RAMAL")));

        st.close();
        rs.close();

        return pessoaJuridica;
    }

    public static PessoaJuridica popularPessoaJuridicaSemCep(String cnpj) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA WHERE CD_CNPJ = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cnpj);
        ResultSet rs = st.executeQuery();
        rs.next();
        Endereco end = new Endereco();
        end = DaoEndereco.popularEndereco(rs.getString("CD_CEP"));

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(rs.getString("NM_RAZAO_SOCIAL"));
        pessoa.setEndereco(end);
        pessoa.setTelefone(String.valueOf(rs.getLong("NR_TELEFONE")));
        pessoa.setComplementoLogradouro(rs.getString("NR_LOGRADOURO"));
        pessoa.setManterContratoBanco(rs.getInt("ID_CONTRATO"));

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setPessoa(pessoa);
        pessoaJuridica.setCnpj(rs.getString("CD_CNPJ"));
        pessoaJuridica.setRazaoSocial(rs.getString("NM_RAZAO_SOCIAL"));
        pessoaJuridica.setDataCadastroBanco(control.Datas.converterParaBrasileira(String.valueOf(rs.getDate("DT_CADASTRO"))));
        pessoaJuridica.setRamalCliente(String.valueOf(rs.getInt("NR_RAMAL")));

        st.close();
        rs.close();
        return pessoaJuridica;
    }

    public static boolean existePessoaFisica(String cpf) {
        boolean flag = false;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_CPF FROM SYNCHROSOFT.TB_PESSOA_FISICA WHERE CD_CPF = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cpf);
            ResultSet rs = st.executeQuery();
            flag = rs.isBeforeFirst();
            st.close();
            rs.close();
            return flag;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível pesquisar se a pessoa física existe.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoPessoa - Existe Pessoa Fisica", 0);
            return flag;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            return flag;
        }

    }

    public static boolean existePessoaJuridica(String cnpj) {
        boolean flag = false;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_CNPJ FROM SYNCHROSOFT.TB_PESSOA_JURIDICA WHERE CD_CNPJ = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cnpj);
            ResultSet rs = st.executeQuery();
            flag = rs.isBeforeFirst();
            st.close();
            rs.close();
            return flag;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível pesquisar se a pessoa jurídica existe.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoPessoa - Existe Pessoa Jurídica", 0);
            return flag;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
            return flag;
        }
    }

    public static boolean cadastrarPessoaJuridica(PessoaJuridica juridica) {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_PESSOA_JURIDICA VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, juridica.getCnpj());
            st.setString(2, juridica.getPessoa().getEndereco().getCep());
            st.setString(3, juridica.getPessoa().getNome());
            st.setString(4, juridica.getRazaoSocial());
            st.setString(5, juridica.getPessoa().getComplementoLogradouro());
            st.setLong(6, juridica.getPessoa().getTelefone());
            st.setLong(7, juridica.getRamalCliente());
            st.setInt(8, juridica.getPessoa().getManterContrato());
            st.setDate(9, Date.valueOf(control.Datas.converterParaAmericana(juridica.getDataCadastro())));
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "A pessoa jurídica foi cadastrada com sucesso!", "Cadastro de pessoa jurídica", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar a pessoa jurídica.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoPessoa - Cadastrar pessoa jurídica", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void deletarPessoaFisica(String cpf) throws SQLException, ClassNotFoundException {
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

    public static void deletarPessoaJuridica(String cnpj) throws SQLException, ClassNotFoundException {
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
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA "
                    + "INNER JOIN SYNCHROSOFT.TB_ENDERECO "
                    + "ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP)";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                end.setCep(rs.getString("CD_CEP"));
                end.setLogradouro(rs.getString("DS_LOGRADOURO"));

                Pessoa pessoa = new Pessoa();
                pessoa.setNome("NM_PESSOA_FISICA");
                pessoa.setEndereco(end);
                pessoa.setTelefone(rs.getString("NR_TELEFONE"));
                pessoa.setComplementoLogradouro(rs.getString("NR_COMPLEMENTO_LOGRADOURO"));
                pessoa.setManterContratoBanco(rs.getInt("ID_CONTRATO"));

                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setPessoa(pessoa);
                pessoaFisica.setCpf(rs.getString("CD_CPF"));
                pessoaFisica.setSexoBanco(rs.getInt("ID_SEXO"));
                pessoaFisica.setCelular(String.valueOf(rs.getLong("NR_CELULAR")));
                pessoaFisica.setDataCadastroBanco((control.Datas.converterParaBrasileira(String.valueOf(rs.getDate("DT_CADASTRO")))));

                lista.add(pessoaFisica);
            }

            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Pessoas Físicas.\n\nErro Nº "+ex.getErrorCode()+
                    "\n"+ex.getMessage(),"Erro: DaoPessoa - Listar Pessoa Física",0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

    public static ArrayList listarPessoaJuridica() {
        ArrayList<PessoaJuridica> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP)";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                end.setCep(rs.getString("CD_CEP"));
                end.setLogradouro("DS_LOGRADOURO");
                
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("NM_RAZAO_SOCIAL"));
                pessoa.setEndereco(end);
                pessoa.setTelefone(String.valueOf(rs.getLong("NR_TELEFONE")));
                pessoa.setComplementoLogradouro(rs.getString("NR_LOGRADOURO"));
                pessoa.setManterContratoBanco(rs.getInt("ID_CONTRATO"));

                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setPessoa(pessoa);
                pessoaJuridica.setCnpj(rs.getString("CD_CNPJ"));
                pessoaJuridica.setRazaoSocial(rs.getString("NM_RAZAO_SOCIAL"));
                pessoaJuridica.setDataCadastroBanco(control.Datas.converterParaBrasileira(String.valueOf(rs.getDate("DT_CADASTRO"))));
                pessoaJuridica.setRamalCliente(String.valueOf(rs.getInt("NR_RAMAL")));

                lista.add(pessoaJuridica);
            }

            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Pessoas Jurídicas.\n\nErro Nº "+ex.getErrorCode()+
                    "\n"+ex.getMessage(),"Erro: DaoPessoa - Listar Pessoa Jurídica",0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(NM_PESSOA_FISICA) LIKE LOWER(?)";
                    break;
                case "CPF":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(CD_CPF) LIKE LOWER(?)";
                    break;
                case "Sexo":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(ID_SEXO) LIKE LOWER(?)";
                    break;
                case "CEP":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(CD_CEP) LIKE LOWER(?)";
                    break;
                case "Eendereço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(SYNCHROSOFT.TB_ENDERECO.CD_CEP) LIKE LOWER(?)";
                    break;
                case "Número Endereço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(NR_COMPLEMENTO_LOGRADOURO) LIKE LOWER(?)";
                    break;
                case "Telefone":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(NR_TELEFONE) LIKE LOWER(?)";
                    break;
                case "Celular":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(NR_CELULAR) LIKE LOWER(?)";
                    break;
                case "Contrato":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(ID_CONTRATO) LIKE LOWER(?)";
                    break;
                case "Data de Cadastro":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_FISICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_FISICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(DT_CADASTRO) LIKE LOWER(?)";
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
                
                Pessoa pessoa = new Pessoa();
                pessoa.setNome("NM_PESSOA_FISICA");
                pessoa.setEndereco(end);
                pessoa.setTelefone(rs.getString("NR_TELEFONE"));
                pessoa.setComplementoLogradouro(rs.getString("NR_COMPLEMENTO_LOGRADOURO"));
                pessoa.setManterContratoBanco(rs.getInt("ID_CONTRATO"));

                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setPessoa(pessoa);
                pessoaFisica.setCpf(rs.getString("CD_CPF"));
                pessoaFisica.setSexoBanco(rs.getInt("ID_SEXO"));
                pessoaFisica.setCelular(String.valueOf(rs.getLong("NR_CELULAR")));
                pessoaFisica.setDataCadastroBanco((control.Datas.converterParaBrasileira(String.valueOf(rs.getDate("DT_CADASTRO")))));

                lista.add(pessoaFisica);

            }

            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (SQLException ex) { //Caso exista a possibilidade de retorno de erro
            JOptionPane.showMessageDialog(null, "Erro ao listar Pessoas Físicas via filtro.\n\nErro Nº "+ex.getErrorCode()+
                    "\n"+ex.getMessage(),"Erro: DaoPessoa - Listar Pessoa Física Filtrada",0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
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
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(CD_CNPJ) LIKE LOWER(?)";
                    break;
                case "CEP":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(CD_CEP) LIKE LOWER(?)";
                    break;
                case "Nome Fictício":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(NM_FICTICIO) LIKE LOWER(?)";
                    break;
                case "Razão Social":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(NM_RAZAO_SOCIAL) LIKE LOWER(?)";
                    break;
                case "Número Endereço":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(NR_LOGRADOURO) LIKE LOWER(?)";
                    break;
                case "Telefone":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(NR_TELEFONE) LIKE (?)";
                    break;
                case "Ramal":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(NR_RAMAL) LIKE LOWER(?)";
                    break;
                case "Contrato":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(ID_CONTRATO) LIKE LOWER(?)";
                    break;
                case "Data Cadastro":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PESSOA_JURIDICA INNER JOIN SYNCHROSOFT.TB_ENDERECO ON (SYNCHROSOFT.TB_PESSOA_JURIDICA.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) WHERE LOWER(DT_CADASTRO) LIKE LOWER(?)";
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
                
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("NM_RAZAO_SOCIAL"));
                pessoa.setEndereco(end);
                pessoa.setTelefone(String.valueOf(rs.getLong("NR_TELEFONE")));
                pessoa.setComplementoLogradouro(rs.getString("NR_LOGRADOURO"));
                pessoa.setManterContratoBanco(rs.getInt("ID_CONTRATO"));

                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setPessoa(pessoa);
                pessoaJuridica.setCnpj(rs.getString("CD_CNPJ"));
                pessoaJuridica.setRazaoSocial(rs.getString("NM_RAZAO_SOCIAL"));
                pessoaJuridica.setDataCadastroBanco(control.Datas.converterParaBrasileira(String.valueOf(rs.getDate("DT_CADASTRO"))));
                pessoaJuridica.setRamalCliente(String.valueOf(rs.getInt("NR_RAMAL")));

                lista.add(pessoaJuridica);

            }

            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (SQLException ex) { //Caso exista a possibilidade de retorno de erro
            JOptionPane.showMessageDialog(null, "Erro ao listar Pessoas Jurídicas via filtro.\n\nErro Nº "+ex.getErrorCode()+
                    "\n"+ex.getMessage(),"Erro: DaoPessoa - Listar Pessoa Jurídica Filtrada",0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return lista;
        return lista;
    }

    public static void alterarPessoaFisica(JTable tabela){
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
                    + "DT_CADASTRO = ?, ID_CONTRATO = ? "
                    + "WHERE CD_CPF = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int row = 0; row < rows; row++) {
                String CD_CPF_ALTERADO = (String) tabela.getValueAt(row, 1);
                String CD_CEP = (String) tabela.getValueAt(row, 3);
                String NM_PESSOA_FISICA = (String) tabela.getValueAt(row, 0);
                String ID_SEXO = (String) tabela.getValueAt(row, 2);
                int sexo;
                if (ID_SEXO.toLowerCase().substring(0, 1).equals("m")) {
                    sexo = 0;
                } else {
                    sexo = 1;
                }

                String NR_TELEFONE = (String) tabela.getValueAt(row, 6);
                String NR_CELULAR = (String) tabela.getValueAt(row, 7);
                String NR_COMPLEMENTO_LOGRADOURO = (String) tabela.getValueAt(row, 5);
                PessoaFisica pf = new PessoaFisica();
                String DT_CADASTRO = (String) tabela.getValueAt(row, 9);
                pf.setDataCadastro(DT_CADASTRO);
                String ID_CONTRATO = (String) tabela.getValueAt(row, 8);
                int contrato;
                if (ID_CONTRATO.toLowerCase().substring(0, 1).equals("s")) {
                    contrato = 1;
                } else {
                    contrato = 0;
                }
                String CD_CPF_REFERENCIA = (String) tabela.getValueAt(row, 10);

                st.setString(1, CD_CPF_ALTERADO);
                st.setString(2, CD_CEP);
                st.setString(3, NM_PESSOA_FISICA);
                st.setInt(4, sexo);
                st.setLong(5, Long.parseLong(NR_TELEFONE));
                st.setLong(6, Long.parseLong(NR_CELULAR));
                st.setInt(7, Integer.parseInt(NR_COMPLEMENTO_LOGRADOURO));

                st.setDate(8, Date.valueOf(control.Datas.converterParaAmericana(pf.getDataCadastro())));
                st.setInt(9, contrato);
                st.setString(10, CD_CPF_REFERENCIA);

                st.addBatch();
                st.executeBatch();
                con.commit();
            }
            JOptionPane.showMessageDialog(null, "A base de pessoas físicas foi alterada com sucesso!", "Alteração concluída", 1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a base de Pessoas Físicas.\n\nErro Nº "+ex.getErrorCode()+
                    "\n"+ex.getMessage(),"Erro: DaoPessoa - Alterar Pessoa Fisica",0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void alterarPessoaJuridica(JTable tabela) {
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
                String cnpj_alterado = (String) tabela.getValueAt(row, 0);
                String cep = (String) tabela.getValueAt(row, 1);
                String nomeFicticio = (String) tabela.getValueAt(row, 2);
                String razaoSocial = (String) tabela.getValueAt(row, 3);
                String numero = (String) tabela.getValueAt(row, 4);
                String telefone = (String) tabela.getValueAt(row, 5);
                String ramal = (String) tabela.getValueAt(row, 6);
                String contrato = (String) tabela.getValueAt(row, 7);

                String dataCadastro = (String) tabela.getValueAt(row, 8);
                PessoaJuridica pj = new PessoaJuridica();
                pj.setDataCadastro(dataCadastro);
                String cnpj_ref = (String) tabela.getValueAt(row, 9);

                if (contrato.equals("Sim")) {
                    contrato = "1";
                } else if (contrato.equals("Não")) {
                    contrato = "0";
                }
                st.setString(1, cnpj_alterado);
                st.setString(2, cep);
                st.setString(3, nomeFicticio);
                st.setString(4, razaoSocial);
                st.setString(5, numero);
                st.setLong(6, Long.parseLong(telefone));
                st.setLong(7, Long.parseLong(ramal));
                st.setInt(8, Integer.parseInt(contrato));
                st.setDate(9, Date.valueOf(control.Datas.converterParaAmericana(pj.getDataCadastro())));
                st.setString(10, cnpj_ref);
                st.addBatch();
                st.executeBatch();
                con.commit();
            }
            JOptionPane.showMessageDialog(null, "A base de pessoas Jurídicas foi alterada com sucesso!", "Alteração concluída", 1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a base de Pessoas Jurídicas.\n\nErro Nº "+ex.getErrorCode()+
                    "\n"+ex.getMessage(),"Erro: DaoPessoa - Alterar Pessoa Jurídica",0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
