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
import model.Despesa;

/**
 *
 * @author LuizV1
 */
public class DaoDespesa {

    public static boolean cadastrarDespesa(Despesa desp) {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_DESPESA (DS_TIPO_DESPESA, "
                    + "DT_DESPESA, DS_DESPESA, VL_DESPESA, ID_QUITADA) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, desp.getTipoDespesas());
            st.setDate(2, Date.valueOf(control.Datas.converterParaAmericana(desp.getDataDespesa())));
            st.setString(3, desp.getDescricaoDespesa());
            st.setFloat(4, desp.getValorDespesaBanco());
            st.setInt(5, desp.getQuitada());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso!",
                    "Cadastro realizado", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar a despesa.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoDespesa - Cadastro despesa", 0);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar a despesa.\n\nErro: "
                    + ex, "Erro: DaoDespesa - Cadastro despesa", 0);
            return false;
        }
    }

    public static ArrayList listarDespesa() {
        ArrayList<Despesa> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA "
                    + "ORDER BY CD_DESPESA";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Despesa desp = new Despesa();
                desp.setCodigoDespesa(rs.getInt("CD_DESPESA"));
                desp.setTipoDespesas(rs.getString("DS_TIPO_DESPESA"));
                desp.setDataDespesaBanco(rs.getDate("DT_DESPESA").toString());
                desp.setDescricaoDespesa(rs.getString("DS_DESPESA"));
                desp.setValorDespesa(rs.getString("VL_DESPESA"));
                desp.setQuitadaBanco(rs.getInt("ID_QUITADA"));
                lista.add(desp);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível listar as despesas.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoDespesa - Listar despesas", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static void deletarDespesa(long codigoDespesa) {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_DESPESA WHERE CD_DESPESA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setLong(1, codigoDespesa);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Despesa removida com sucesso.", "Remoção concluída", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível remover a despesa selecionada.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoDespesa - Deletar despesa", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean deletarTodasDespesas() {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_DESPESA";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Todas as despesas foram excluídas com sucesso.", "Exclusão total concluída.", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover as despesas.\nErro Nº :\n\n"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoDespesa - Deletar Todas Despesas", 0);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover as despesas.\nErro:\n\n"
                    + ex, "Erro: DaoDespesa - Deletar Todas Despesas", 0);
            return false;
        }
    }

    public static ArrayList listarDespesaFiltradaData(String antes, String depois) {
        ArrayList<Despesa> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA "
                    + "WHERE DT_DESPESA BETWEEN TO_DATE (?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd') "
                    + "ORDER BY CD_DESPESA";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, antes);
            st.setString(2, depois);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Despesa desp = new Despesa();
                desp.setCodigoDespesa(rs.getInt("CD_DESPESA"));
                desp.setTipoDespesas(rs.getString("DS_TIPO_DESPESA"));
                desp.setDataDespesa(rs.getDate("DT_DESPESA").toString());
                desp.setDescricaoDespesa(rs.getString("DS_DESPESA"));
                desp.setValorDespesa(rs.getString("VL_DESPESA"));
                desp.setQuitadaBanco(rs.getInt("ID_QUITADA"));
                lista.add(desp);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível listar despesas por pesquisa filtrada.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoDespesa - Listar despesas via filtro", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static ArrayList listarDespesaFiltrada(String cmbFiltro, String txtPesquisa, String dataDe, String dataAte) {
        ArrayList<Despesa> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "";
            /*
Código
Tipo de Despesa
Descrição Detalhada
Valor
Quitada?
Data de Vencimento
Data de Vencimento Entre/Até        
             */

            switch (cmbFiltro) {
                case "Código":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(CD_DESPESA) LIKE LOWER(?)";
                    break;
                case "Tipo de Despesa":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(DS_TIPO_DESPESA) LIKE LOWER(?)";
                    break;
                case "Descrição Detalhada":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(DS_DESPESA) LIKE LOWER(?)";
                    break;
                case "Valor":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(VL_DESPESA) LIKE LOWER(?)";
                    break;
                case "Quitada?":
                    txtPesquisa = txtPesquisa.substring(0, 1);
                    if (txtPesquisa.equals("n")) {
                        txtPesquisa = "0";
                    } else if (txtPesquisa.equals("s")) {
                        txtPesquisa = "1";
                    }
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA WHERE LOWER(ID_QUITADA) LIKE LOWER(?)";
                    break;
                case "Data de Vencimento":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA "
                            + "WHERE DT_DESPESA = TO_DATE(?, 'yyyy-mm-dd')";
                    break;
                case "Data de Vencimento Entre/Até":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA "
                            + "WHERE DT_DESPESA BETWEEN TO_DATE(?, 'yyyy-mm-dd') AND TO_DATE (?, 'yyyy-mm-dd')";
                    break;
            }

            PreparedStatement st = con.prepareStatement(sql);

            //colocando valor da variável ? da query 
            if (cmbFiltro.equals("Data de Vencimento")) {
                try {
                    dataDe = control.Datas.converterParaAmericana(dataDe);

                } catch (Exception ex) {

                }
                st.setString(1, dataDe);
            } else if (cmbFiltro.equals("Data de Vencimento Entre/Até")) {
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

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Despesa desp = new Despesa();
                desp.setCodigoDespesa(rs.getInt("CD_DESPESA"));
                desp.setTipoDespesas(rs.getString("DS_TIPO_DESPESA"));
                desp.setDataDespesaBanco(String.valueOf(rs.getDate("DT_DESPESA")));
                desp.setDescricaoDespesa(rs.getString("DS_DESPESA"));
                desp.setValorDespesa(rs.getString("VL_DESPESA"));
                desp.setQuitadaBanco(rs.getInt("ID_QUITADA"));
                lista.add(desp);
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível listar despesas por pesquisa filtrada.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoDespesa - Listar despesas via filtro", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static boolean alterarDespesa(Despesa despesa, long PK_REF) {
        try {
            Connection con = Conexao.conectar();

            String sql = "UPDATE SYNCHROSOFT.TB_DESPESA "
                    + "SET DS_TIPO_DESPESA = ?, DT_DESPESA = ?, "
                    + "DS_DESPESA = ?, VL_DESPESA= ?, ID_QUITADA = ? "
                    + "WHERE CD_DESPESA = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, despesa.getTipoDespesas());
            st.setDate(2, Date.valueOf(control.Datas.converterParaAmericana(despesa.getDataDespesa())));
            st.setString(3, despesa.getDescricaoDespesa());
            st.setFloat(4, despesa.getValorDespesaBanco());
            st.setInt(5, despesa.getQuitada());
            st.setLong(6, PK_REF);

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "A despesa foi alterada com sucesso!", "Atualização da despesa concluída", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível alterar a despesa.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoDespesa - Alterar Despesa", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoDespesa.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static ArrayList<Despesa> gerarAlertaDespesaParaVencer() {
        ArrayList<Despesa> lista = new ArrayList<>();

        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA "
                    + "WHERE DT_DESPESA BETWEEN SYSDATE-1 AND SYSDATE+? "
                    + "AND ID_QUITADA = 0";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, control.Opcoes.getIntervaloDiasVencimento());

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Despesa desp = new Despesa();
                desp.setCodigoDespesa(rs.getInt("CD_DESPESA"));
                desp.setTipoDespesas(rs.getString("DS_TIPO_DESPESA"));
                desp.setDataDespesaBanco(rs.getDate("DT_DESPESA").toString());
                desp.setDescricaoDespesa(rs.getString("DS_DESPESA"));
                desp.setValorDespesa(rs.getString("VL_DESPESA"));
                desp.setQuitadaBanco(rs.getInt("ID_QUITADA"));
                lista.add(desp);
            }

            st.close();
            rs.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar alerta das despesas para vencer.\n\nErro Nº: "
                    + ex.getErrorCode() + "\n\n" + ex.getMessage(), "Erro: DaoDespesa - Gerar Alerta Despesa A Vencer", 0);
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar alerta das despesas para vencer.\n\nErro: "
                    + ex, "Erro: DaoDespesa - Gerar Alerta Despesa A Vencer", 0);
            return null;
        }
    }

    public static ArrayList<Despesa> gerarAlertaDespesaVencida() {
        ArrayList<Despesa> lista = new ArrayList<>();

        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA "
                    + "WHERE SYSDATE > DT_DESPESA+1 "
                    + "AND ID_QUITADA = 0";
            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Despesa desp = new Despesa();
                desp.setCodigoDespesa(rs.getInt("CD_DESPESA"));
                desp.setTipoDespesas(rs.getString("DS_TIPO_DESPESA"));
                desp.setDataDespesaBanco(rs.getDate("DT_DESPESA").toString());
                desp.setDescricaoDespesa(rs.getString("DS_DESPESA"));
                desp.setValorDespesa(rs.getString("VL_DESPESA"));
                desp.setQuitadaBanco(rs.getInt("ID_QUITADA"));
                lista.add(desp);
            }

            st.close();
            rs.close();
            return lista;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar alerta das despesas para vencer.\n\nErro Nº: "
                    + ex.getErrorCode() + "\n\n" + ex.getMessage(), "Erro: DaoDespesa - Gerar Alerta Despesa A Vencer", 0);
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar alerta das despesas para vencer.\n\nErro: "
                    + ex, "Erro: DaoDespesa - Gerar Alerta Despesa A Vencer", 0);
            return null;
        }
    }

    public static Despesa popularDespesa(long codigoDespesa) {
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_DESPESA "
                    + "WHERE CD_DESPESA = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setLong(1, codigoDespesa);

            ResultSet rs = st.executeQuery();

            rs.next();

            Despesa desp = new Despesa();
            desp.setCodigoDespesa(rs.getInt("CD_DESPESA"));
            desp.setTipoDespesas(rs.getString("DS_TIPO_DESPESA"));
            desp.setDataDespesaBanco(rs.getDate("DT_DESPESA").toString());
            desp.setDescricaoDespesa(rs.getString("DS_DESPESA"));
            desp.setValorDespesa(rs.getString("VL_DESPESA"));
            desp.setQuitadaBanco(rs.getInt("ID_QUITADA"));

            st.close();
            rs.close();

            return desp;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível popular a despesa.\n\nErro Nº:"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoDespesa - Poular Despesa", 0);
            return null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível alterar a base de despesas.\n\nErro: "
                    + ex, "Erro: DaoDespesa - Popular Despesa", 0);
            return null;
        }
    }
}
