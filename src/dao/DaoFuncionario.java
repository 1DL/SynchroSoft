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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static boolean cadastrarFuncionario(Funcionario func) {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_FUNCIONARIO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, func.getCodigoFuncionario());
            st.setString(2, func.getPessoa().getEndereco().getCep());
            st.setString(3, func.getPessoa().getNome());
            st.setString(4, func.getFisica().getCpf());
            st.setInt(5, func.getFisica().getSexoBanco());
            st.setLong(6, func.getPessoa().getTelefone());
            st.setLong(7, func.getFisica().getCelular());
            st.setString(8, func.getPessoa().getComplementoLogradouro());
            st.setFloat(9, func.getSalarioBanco());
            st.setString(10, func.getCargo());
            st.setDate(11, Date.valueOf(control.Datas.converterParaAmericana(func.getDataContrato())));
            st.setDate(12, null);
            st.setInt(13, func.getHorasTrabalhadas());
            st.setInt(14, func.getNivelAdministrativoBanco());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Cadastro de Funcionário", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar o funcionário.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoFuncionario - Cadastro Funcionario", 0);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular atributos do funcionário. \n\nExceção JAVA:\n"
                    + ex.getMessage(), "Erro ao cadastrar funcionário", 0);
            return false;
        }
    }

    public static void alterarFuncionario(JTable tabela) throws SQLException, ClassNotFoundException {
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
                    + "NR_LOGRADOURO = ?, VL_SALARIO = ?, DS_CARGO = ?, "
                    + "NR_HORAS_TRABALHO = ?, ID_ADMINISTRATIVO =? "
                    + "WHERE CD_FUNCIONARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int row = 0; row < rows; row++) {
                String cod_alterado = (String) tabela.getValueAt(row, 0);
                String cep = (String) tabela.getValueAt(row, 1);
                String nome = (String) tabela.getValueAt(row, 2);
                String cpf = (String) tabela.getValueAt(row, 3);
                String idsexo = (String) tabela.getValueAt(row, 4);
                int sexo;
                if (idsexo.toLowerCase().substring(0, 1).equals("m")) {
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
                String horatrab = (String) tabela.getValueAt(row, 12);
                String nvladm = (String) tabela.getValueAt(row, 13);

                int nivel = 0;
                if ("Visualização".equals(nvladm)) {
                    nivel = 0;
                } else if ("Administrador".equals(nvladm)) {
                    nivel = 1;
                }
                String cod_ref = (String) tabela.getValueAt(row, 14);

                st.setInt(1, Integer.parseInt(cod_alterado));
                st.setString(2, cep);
                st.setString(3, nome);
                st.setString(4, cpf);
                st.setInt(5, sexo);
                st.setLong(6, Long.parseLong(tel));
                st.setLong(7, Long.parseLong(cel));
                st.setString(8, nrend);
                st.setFloat(9, Float.parseFloat(salario));
                st.setString(10, cargo);
                st.setDate(10, Date.valueOf(control.Datas.converterParaAmericana(func.getDataContrato())));
                st.setDate(11, Date.valueOf(control.Datas.converterParaAmericana(func.getDataDemissao())));
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

    public static Funcionario popularFuncionario(String codigo) throws SQLException, ClassNotFoundException {
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, codigo);
        ResultSet rs = st.executeQuery();
        rs.next();
        Funcionario func = new Funcionario();
        func.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
        Pessoa p = new Pessoa();
        PessoaFisica pf = new PessoaFisica();
        p.setNome(rs.getString("NM_FUNCIONARIO"));
        pf.setPessoa(p);
        pf.setCpf(rs.getString("CPF_FUNCIONARIO"));
        func.setSalario(rs.getString("VL_SALARIO"));
        func.setPessoa(p);
        func.setFisica(pf);
        func.setCargo(rs.getString("DS_CARGO"));
        st.close();
        rs.close();
        return func;
    }

    public static boolean existeFuncionario(String codigo) {
        boolean flag = false;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_FUNCIONARIO FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigo);
            ResultSet rs = st.executeQuery();
            flag = rs.isBeforeFirst();
            st.close();
            rs.close();
            return flag;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível pesquisar se o funcionário existe.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoFuncionario - Existe Funcionario", 0);
            return flag;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            return flag;
        }
        
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
                Pessoa pessoa = new Pessoa();
                pessoa.setNome("NM_FUNCIONARIO");
                pessoa.setEndereco(end);
                pessoa.setTelefone(rs.getString("NR_TELEFONE"));
                pessoa.setComplementoLogradouro(rs.getString("NR_LOGRADOURO"));
                
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setPessoa(pessoa);
                pessoaFisica.setSexoBanco(rs.getInt("ID_SEXO"));
                pessoaFisica.setCpf(rs.getString("CPF_FUNCIONARIO"));

                Funcionario func = new Funcionario();
                func.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
                func.setPessoa(pessoa);
                func.setFisica(pessoaFisica);
                func.setSalario(rs.getString("VL_SALARIO"));
                func.setCargo(rs.getString("DS_CARGO"));
                func.setDataContratoBanco(rs.getDate("DT_ADMISSAO").toString());
                try{
                func.setDataDemissaoBanco(rs.getDate("DT_DEMISSAO").toString());
                } catch (NullPointerException npe) {
                    func.setDataDemissao(func.getDataContrato());
                }
                func.setHorasTrabalhadas(Integer.toString(rs.getInt("NR_HORAS_TRABALHO")));
                func.setNivelAdministrativoBanco(rs.getInt("ID_ADMINISTRATIVO"));
                lista.add(func);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi criar a lista de funcionários.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoFuncionario - Listar Funcionários", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static void deletarFuncionario(String codigo) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigo);
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
                Pessoa pessoa = new Pessoa();
                pessoa.setNome("NM_FUNCIONARIO");
                pessoa.setEndereco(end);
                pessoa.setTelefone(rs.getString("NR_TELEFONE"));
                pessoa.setComplementoLogradouro(rs.getString("NR_LOGRADOURO"));
                
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setPessoa(pessoa);
                pessoaFisica.setSexoBanco(rs.getInt("ID_SEXO"));
                pessoaFisica.setCpf(rs.getString("CPF_FUNCIONARIO"));

                Funcionario func = new Funcionario();
                func.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
                func.setPessoa(pessoa);
                func.setFisica(pessoaFisica);
                func.setSalario(rs.getString("VL_SALARIO"));
                func.setCargo(rs.getString("DS_CARGO"));
                func.setDataContratoBanco(rs.getDate("DT_ADMISSAO").toString());
                try{
                func.setDataDemissaoBanco(rs.getDate("DT_DEMISSAO").toString());
                } catch (NullPointerException npe) {
                    func.setDataDemissao(func.getDataContrato());
                }
                func.setHorasTrabalhadas(Integer.toString(rs.getInt("NR_HORAS_TRABALHO")));
                func.setNivelAdministrativoBanco(rs.getInt("ID_ADMINISTRATIVO"));
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
