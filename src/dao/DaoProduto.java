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
import model.Produto;
import model.VendaPeca;

/**
 *
 * @author LuizV1
 */
public class DaoProduto {

    public static boolean cadastrarPeca(Produto peca) {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_PECA "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, peca.getCodigoPeca());
            st.setString(2, peca.getNomePeca());
            st.setString(3, peca.getCategoriaPeca());
            st.setLong(4, peca.getQuantidadePeca());
            st.setFloat(5, peca.getValorUnitarioBanco());
            st.setLong(6, peca.getAlertaQtdMin());
            st.setFloat(7, peca.getAlertaQtdMax());
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!",
                    "Cadastro realizado", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto. \n\nErro Nº: "
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoPeca - Cadastrar Produto", 0);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void atualizarEstoque(ArrayList<VendaPeca> lista) {
        boolean estoqueInsuficiente = false;
        ArrayList<Integer> estoque = new ArrayList<>();

        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT QT_PECA FROM SYNCHROSOFT.TB_PECA "
                    + "WHERE CD_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int i = 0; i < lista.size(); i++) {

                st.setString(1, lista.get(i).getPeca().getCodigoPeca());
                ResultSet rs = st.executeQuery();
                rs.next();
                estoque.add(rs.getInt("QT_PECA"));
                if (estoque.get(i) < lista.get(i).getQuantidadeVendida()) {
                    estoqueInsuficiente = true;
                }
            }

            if (estoqueInsuficiente) {
                JOptionPane.showMessageDialog(null, "A venda de produtos não foi concluída. \n"
                        + "Uma ou mais produtos do orçamento excedem a quantidade disponível em estoque.",
                        "DaoPeca - Atualizar Estoque", 0);
            } else {
                sql = "UPDATE SYNCHROSOFT.TB_PECA "
                        + "SET QT_PECA = ? WHERE CD_PECA = ?";
                PreparedStatement st2 = con.prepareStatement(sql);
                for (int i = 0; i < lista.size(); i++) {
                    st2.setLong(1, (estoque.get(i) - lista.get(i).getQuantidadeVendida()));
                    st2.setString(2, lista.get(i).getPeca().getCodigoPeca());
                    st2.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "Venda de produtos concluída!", "Venda concluída", 1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar venda de peça. \n\n Erro Nº: "
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoPeca - Atualizar Estoque", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean existePeca(String codigo) {
        boolean flag = false;
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT CD_PECA "
                    + "FROM SYNCHROSOFT.TB_PECA "
                    + "WHERE CD_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigo);
            ResultSet rs = st.executeQuery();
            flag = rs.isBeforeFirst();
            st.close();
            rs.close();
            return flag;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar a existência do produto. \n\nErro Nº: "
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro: DaoPeca - Existe Produto", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public static Produto popularPeca(String codigo) {
        Produto peca = new Produto();
        peca.setValidacao(false);
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PECA "
                    + "WHERE CD_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, codigo);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                peca.setCodigoPeca(rs.getString("CD_PECA"));
                peca.setNomePeca(rs.getString("NM_PECA"));
                peca.setCategoriaPeca(rs.getString("DS_CATEGORIA"));
                peca.setQuantidadePeca(rs.getString("QT_PECA"));
                peca.setAlertaQtdMin(rs.getString("QT_PECAMIN"));
                peca.setAlertaQtdMax(rs.getString("QT_PECAMAX"));
                peca.setValorUnitario(rs.getString("VL_PECA"));
            }
            st.close();
            rs.close();
            peca.setValidacao(true);
            return peca;
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return peca;
    }

    public static void deletarPeca(String cod) {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_PECA "
                    + "WHERE CD_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cod);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso.", "Remoção concluída", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover o produto.\n\nErro Nº: " + ex.getErrorCode()
                    + "\n" + ex.getMessage(), "Erro: DaoPeca - Deletar Peca", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList listarPeca() {
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PECA";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Produto peca = new Produto();
                peca.setCodigoPeca(rs.getString("CD_PECA"));
                peca.setNomePeca(rs.getString("NM_PECA"));
                peca.setCategoriaPeca(rs.getString("DS_CATEGORIA"));
                peca.setQuantidadePeca(rs.getString("QT_PECA"));
                peca.setAlertaQtdMin(rs.getString("QT_PECAMIN"));
                peca.setAlertaQtdMax(rs.getString("QT_PECAMAX"));
                peca.setValorUnitario(rs.getString("VL_PECA"));
                lista.add(peca);
            }

            st.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar uma lista de protudos.\n\nErro Nº: " + ex.getErrorCode()
                    + "\n" + ex.getMessage(), "Erro: DaoPeca - Listar Produtos", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static ArrayList listarPecaFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            //Chamando método de conexão ao banco
            Connection con = Conexao.conectar();
            //Declarando variável de String de conexão
            String sql = "";
            //Criando estrutura switch case para identificar o tipo de filtro de pesquisa
            switch (cmbFiltro) {
                case "Código":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(CD_PECA) LIKE LOWER(?)";
                    break;

                case "Nome":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(NM_PECA) LIKE LOWER(?)";
                    break;

                case "Categoria":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(DS_CATEGORIA) LIKE LOWER(?)";
                    break;

                case "Quantidade":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(QT_PECA)A LIKE LOWER(?)";
                    break;
                case "Alerta Qtd Min":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(QT_PECAMIN)A LIKE LOWER(?)";
                    break;

                case "Alerta Qtd Max":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(QT_PECMAX)A LIKE LOWER(?)";
                    break;

                case "Valor":
                    sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(VL_PECA) LIKE LOWER(?)";
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
                Produto peca = new Produto();
                peca.setCodigoPeca(rs.getString("CD_PECA"));
                peca.setNomePeca(rs.getString("NM_PECA"));
                peca.setCategoriaPeca(rs.getString("DS_CATEGORIA"));
                peca.setQuantidadePeca(rs.getString("QT_PECA"));
                peca.setAlertaQtdMin(rs.getString("QT_PECAMIN"));
                peca.setAlertaQtdMax(rs.getString("QT_PECAMAX"));
                peca.setValorUnitario(rs.getString("VL_PECA"));
                lista.add(peca);
            }
            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();

        } catch (SQLException ex) { //Caso exista a possibilidade de retorno de erro
            JOptionPane.showMessageDialog(null, "Não foi possível listar os produtos por pesquisa filtrada.\n\nErro Nº: " + ex.getErrorCode()
                    + "\n" + ex.getMessage(), "Erro: DaoPeca - Listar Produtos Filtrados", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static boolean alterarPeca(Produto produto, String PK_REF) {
        try {
            Connection con = Conexao.conectar();
            String sql = "UPDATE SYNCHROSOFT.TB_PECA "
                    + "SET CD_PECA = ?, NM_PECA = ?, DS_CATEGORIA = ?, "
                    + "QT_PECA = ?, QT_PECAMIN = ?, QT_PECAMAX = ?, VL_PECA = ? "
                    + "WHERE CD_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, produto.getCodigoPeca());
            st.setString(2, produto.getNomePeca());
            st.setString(3, produto.getCategoriaPeca());
            st.setLong(4, produto.getQuantidadePeca());
            st.setLong(5, produto.getAlertaQtdMin());
            st.setLong(6, produto.getAlertaQtdMax());
            st.setFloat(7, produto.getValorUnitarioBanco());
            st.setString(8, PK_REF);

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "O produto foi alterado com sucesso!",
                    "Alteração concluída", 1);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar o produto. \n\nErro nº :"
            +ex.getErrorCode()+"\n"+ex.getMessage(), "Erro: DaoProduto - Alterar Peça",0);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao alterar o produto. \n\nErro:"
            +ex, "Erro: DaoProduto - Alterar Peça",0);
            return false;
        }
    }
    
    public static boolean deletarTodasPecas() {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_PECA";
            PreparedStatement st = con.prepareStatement(sql);
    
            st.executeUpdate();
            st.close();
            
            JOptionPane.showMessageDialog(null, "Todos os registros de Produtos foram removidos do banco de dados.",
                    "Exclusão total concluída", 1);
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover os produtos.\n\nErro Nº :"
                    + ex.getErrorCode() + "\n" + ex.getMessage(), "Erro : DaoProduto - Deletar Todas Peças", 0);
            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover os endereços.\n\nErro:"
                    + ex, "Erro : DaoProduto - Deletar Todas Peças", 0);
            return false;
        }
    }
}
