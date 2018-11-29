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
            String sql = "INSERT INTO SYNCHROSOFT.TB_FUNCIONARIO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            st.setInt(15, func.getEfetivado());
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

    public static boolean alterarFuncionario(Funcionario func, String PK_REF) {
        try {
            Connection con = Conexao.conectar();
            String sql = "UPDATE SYNCHROSOFT.TB_FUNCIONARIO "
                    + "SET CD_FUNCIONARIO = ?, CD_CEP = ?, NM_FUNCIONARIO = ?, "
                    + "CPF_FUNCIONARIO = ?, ID_SEXO = ?, NR_TELEFONE = ?, NR_CELULAR = ?,"
                    + "NR_LOGRADOURO = ?, VL_SALARIO = ?, DS_CARGO = ?, "
                    + "DT_ADMISSAO = ?, DT_DEMISSAO = ?, "
                    + "NR_HORAS_TRABALHO = ?, ID_ADMINISTRATIVO = ?,"
                    + "ID_EFETIVADO = ? "
                    + "WHERE CD_FUNCIONARIO = ?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, func.getCodigoFuncionario());
            st.setString(2, func.getFisica().getPessoa().getEndereco().getCep());
            st.setString(3, func.getFisica().getPessoa().getNome());
            st.setString(4, func.getFisica().getCpf());
            st.setInt(5, func.getFisica().getSexo());
            st.setLong(6, func.getFisica().getPessoa().getTelefone());
            st.setLong(7, func.getFisica().getCelular());
            st.setString(8, func.getFisica().getPessoa().getComplementoLogradouro());
            st.setFloat(9, func.getSalarioBanco());
            st.setString(10, func.getCargo());
            st.setDate(11, Date.valueOf(control.Datas.converterParaAmericana(func.getDataContrato())));
            if (func.getEfetivadoBooleano()) {
               st.setDate(12, null); 
            } else {
                st.setDate(12, Date.valueOf(control.Datas.converterParaAmericana(func.getDataDemissao())));
            }            
            st.setInt(13, func.getHorasTrabalhadas());
            st.setInt(14, func.getNivelAdministrativoBanco());
            st.setInt(15, func.getEfetivado());
            st.setString(16, PK_REF);

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "O funcionário foi alterado com sucesso!", "Alteração concluída", 1);
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o funcionário.\n\nErro Nº: " + ex.getErrorCode()
                    + "\n" + ex.getMessage(), "Erro: DaoFuncionario - Alterar Funcionário", 0);
            return false;
        /*} catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o funcionário.\n\nErro: " 
                    + ex, "Erro: DaoFuncionario - Alterar Funcionário", 0);
            return false;
        }*/

    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static Funcionario popularFuncionario(String codigo) {
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigo);
            ResultSet rs = st.executeQuery();
            rs.next();
            
            Funcionario func = new Funcionario();
            Endereco end = new Endereco();
            end = dao.DaoEndereco.popularEndereco(rs.getString("CD_CEP"));
            func.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
            Pessoa p = new Pessoa();
            p.setEndereco(end);
            PessoaFisica pf = new PessoaFisica();
            p.setNome(rs.getString("NM_FUNCIONARIO"));
            p.setTelefone(rs.getString("NR_TELEFONE"));
            pf.setPessoa(p);
            pf.setCpf(rs.getString("CPF_FUNCIONARIO"));
            pf.setSexoBanco(rs.getInt("ID_SEXO"));
            pf.setCelular(rs.getString("NR_CELULAR"));
            func.setSalario(rs.getString("VL_SALARIO"));
            func.setHorasTrabalhadas(rs.getString("NR_HORAS_TRABALHO"));
            func.setNivelAdministrativoBanco(rs.getInt("ID_ADMINISTRATIVO"));
            func.setPessoa(p);
            func.setFisica(pf);
            func.setCargo(rs.getString("DS_CARGO"));
            func.setEfetivado(rs.getInt("ID_EFETIVADO"));
            func.setDataContratoBanco(rs.getDate("DT_ADMISSAO").toString());
                try {
                    func.setDataDemissaoBanco(rs.getDate("DT_DEMISSAO").toString());
                } catch (NullPointerException npe) {
                    func.setDataDemissao(func.getDataContrato());
                }
            st.close();
            rs.close();
            return func;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível popular o Funcionário.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoFuncionario - Popular Funcionario", 0);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

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
                end = dao.DaoEndereco.popularEndereco(rs.getString("CD_CEP"));
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("NM_FUNCIONARIO"));
                pessoa.setEndereco(end);
                pessoa.setTelefone(rs.getString("NR_TELEFONE"));
                pessoa.setComplementoLogradouro(rs.getString("NR_LOGRADOURO"));

                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setPessoa(pessoa);
                pessoaFisica.setSexoBanco(rs.getInt("ID_SEXO"));
                pessoaFisica.setCpf(rs.getString("CPF_FUNCIONARIO"));
                pessoaFisica.setCelular(rs.getString("NR_CELULAR"));

                Funcionario func = new Funcionario();
                func.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
                func.setPessoa(pessoa);
                func.setFisica(pessoaFisica);
                func.setSalario(rs.getString("VL_SALARIO"));
                func.setCargo(rs.getString("DS_CARGO"));
                func.setDataContratoBanco(rs.getDate("DT_ADMISSAO").toString());
                try {
                    func.setDataDemissaoBanco(rs.getDate("DT_DEMISSAO").toString());
                } catch (NullPointerException npe) {
                    func.setDataDemissao(func.getDataContrato());
                }
                func.setHorasTrabalhadas(Integer.toString(rs.getInt("NR_HORAS_TRABALHO")));
                func.setNivelAdministrativoBanco(rs.getInt("ID_ADMINISTRATIVO"));
                func.setEfetivado(rs.getInt("ID_EFETIVADO"));
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

    public static void deletarFuncionario(String codigoFuncionario) {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE CD_FUNCIONARIO = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigoFuncionario);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Funcionário(a) removido com sucesso.", "Remoção concluída", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover o Funcionário.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n\n" + ex.getMessage(), "Erro: DaoFuncionario - Deletar Funcionário", 0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover o Funcionário.\n\nErro: "
                    + ex, "Erro: DaoFuncionario - Deletar Funcionário", 0);
        }
    }

    public static boolean deletarTodosFuncionarios() {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_FUNCIONARIO";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Todos os funcionários foram excluídos com sucesso.", "Exclusão total concluída.", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover os funcionários.\nErro Nº :\n\n"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoFuncionario - Deletar Todos Funcionarios", 0);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover os funcionários.\nErro: \n\n"
                    + ex, "Erro: DaoFuncionario - Deletar Todos Funcionarios", 0);
            return false;
        }
    }

    public static ArrayList listarFuncionarioFiltrada(String cmbFiltro, String txtPesquisa, String dataDe, String dataAte) {
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            //Chamando método de conexão ao banco
            Connection con = Conexao.conectar();

            //Declarando variável de String de conexão
            String sql = "";

            /*
Nome
Código
CPF
CEP
Sexo
Telefone
Celular
Salário
Cargo
Horas Trabalhadas
Nível Administrativo
Logradouro
Nr Logradouro
Data Admissão
Data Demissão
Data Admissão Entre/Até
Data Demissão Entre/Até
Efetivado
             */
            switch (cmbFiltro) {

                case "Nome":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(NM_FUNCIONARIO) LIKE LOWER(?)";
                    break;
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
                    txtPesquisa = txtPesquisa.substring(0, 1);
                    if (txtPesquisa.equals("m")) {
                        txtPesquisa = "0";
                    } else if (txtPesquisa.equals("f")) {
                        txtPesquisa = "1";
                    }
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
                case "Horas Trabalhadas":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(NR_HORAS_TRABALHO) LIKE LOWER(?)";
                    break;
                case "Nível Administrativo":
                    txtPesquisa = txtPesquisa.substring(0, 1);
                    if (txtPesquisa.equals("v")) {
                        txtPesquisa = "0";
                    } else if (txtPesquisa.equals("c")) {
                        txtPesquisa = "1";
                    }
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(ID_ADMINISTRATIVO) LIKE LOWER(?)";
                    break;
                case "Logradouro":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO "
                            + "INNER JOIN SYNCHROSOFT.TB_ENDERECO ON "
                            + "(SYNCHROSOFT.TB_FUNCIONARIO.CD_CEP = SYNCHROSOFT.TB_ENDERECO.CD_CEP) "
                            + "WHERE LOWER(TB_ENDERECO.DS_LOGRADOURO) LIKE LOWER(?)";
                    break;
                case "Nr Logradouro":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(NR_LOGRADOURO) LIKE LOWER(?)";
                    break;
                case "Data Admissão":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO "
                            + "WHERE DT_ADMISSAO = TO_DATE(?, 'yyyy-mm-dd')";
                    break;
                case "Data Demissão":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO "
                            + "WHERE DT_DEMISSAO = TO_DATE(?, 'yyyy-mm-dd')";
                    break;
                case "Data Admissão Entre/Até":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO "
                            + "WHERE DT_ADMISSAO BETWEEN TO_DATE(?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd')";
                    break;
                case "Data Demissão Entre/Até":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO "
                            + "WHERE DT_DEMISSAO BETWEEN TO_DATE(?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd')";
                    break;
                case "Efetivado":
                    txtPesquisa = txtPesquisa.substring(0, 1);
                    if (txtPesquisa.equals("s")) {
                        txtPesquisa = "1";
                    } else if (txtPesquisa.equals("n")) {
                        txtPesquisa = "0";
                    }
                    sql = "SELECT * FROM SYNCHROSOFT.TB_FUNCIONARIO WHERE LOWER(ID_EFETIVADO) LIKE LOWER(?) ";
                    break;
            }

            //realizando preparedStatement para tratamento de variáveis
            PreparedStatement st = con.prepareStatement(sql);

            if (cmbFiltro.equals("Data Admissão") || cmbFiltro.equals("Data Demissão")) {
                try {
                    dataDe = control.Datas.converterParaAmericana(dataDe);

                } catch (Exception ex) {

                }
                st.setString(1, dataDe);
            } else if (cmbFiltro.equals("Data Admissão Entre/Até") || cmbFiltro.equals("Data Demissão Entre/Até")) {
                try {
                    dataDe = control.Datas.converterParaAmericana(dataDe);
                    dataAte = control.Datas.converterParaAmericana(dataAte);
                } catch (Exception ex) {

                }
                st.setString(1, dataDe);
                st.setString(2, dataAte);
            } else {
                st.setString(1, "%" + txtPesquisa + "%");
            }

            //executando query selecionada pelo switch case
            ResultSet rs = st.executeQuery();

            //listando dados do banco em jtable
            while (rs.next()) {
                Endereco end = new Endereco();
                end = dao.DaoEndereco.popularEndereco(rs.getString("CD_CEP"));
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("NM_FUNCIONARIO"));
                pessoa.setEndereco(end);
                pessoa.setTelefone(rs.getString("NR_TELEFONE"));
                pessoa.setComplementoLogradouro(rs.getString("NR_LOGRADOURO"));

                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setPessoa(pessoa);
                pessoaFisica.setSexoBanco(rs.getInt("ID_SEXO"));
                pessoaFisica.setCpf(rs.getString("CPF_FUNCIONARIO"));
                pessoaFisica.setCelular(rs.getString("NR_CELULAR"));

                Funcionario func = new Funcionario();
                func.setCodigoFuncionario(rs.getString("CD_FUNCIONARIO"));
                func.setPessoa(pessoa);
                func.setFisica(pessoaFisica);
                func.setSalario(rs.getString("VL_SALARIO"));
                func.setCargo(rs.getString("DS_CARGO"));
                func.setDataContratoBanco(rs.getDate("DT_ADMISSAO").toString());
                try {
                    func.setDataDemissaoBanco(rs.getDate("DT_DEMISSAO").toString());
                } catch (NullPointerException npe) {
                    func.setDataDemissao(func.getDataContrato());
                }
                func.setHorasTrabalhadas(Integer.toString(rs.getInt("NR_HORAS_TRABALHO")));
                func.setNivelAdministrativoBanco(rs.getInt("ID_ADMINISTRATIVO"));
                func.setEfetivado(rs.getInt("ID_EFETIVADO"));
                lista.add(func);
            }

            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, "Erro ao listar Funcionários via filtro.\n\nErro Nº " + ex.getErrorCode()
                    + "\n" + ex.getMessage(), "Erro: DaoFuncionario - Listar Funcionarios Filtrado", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }

}
