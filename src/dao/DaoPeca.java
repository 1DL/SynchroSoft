/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Peca;
import model.VendaPeca;

/**
 *
 * @author LuizV1
 */
public class DaoPeca {

    public void cadastrarPeca(int codigo, String nome, String categoria, int quantidade, float valor) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "INSERT INTO SYNCHROSOFT.TB_PECA VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codigo);
            st.setString(2, nome);
            st.setString(3, categoria);
            st.setInt(4, quantidade);
            st.setFloat(5, valor);
            st.executeUpdate();
            st.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não  foi possível cadastrar a peça.\n Erro:\n\n" + ex.getMessage());
        }
    }
    
    public static void atualizarEstoque(ArrayList<VendaPeca> lista) {
        boolean estoqueInsuficiente = false;
        ArrayList<Integer> estoque = new ArrayList<>();
        
        try {
            Connection con = Conexao.conectar();
            String sql = "SELECT QT_PECA FROM SYNCHROSOFT.TB_PECA WHERE CD_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for(int i = 0; i < lista.size(); i++){
               
                st.setInt(1, lista.get(i).getPeca().getCodigoPeca());
                ResultSet rs = st.executeQuery();
                rs.next();
                estoque.add(rs.getInt("QT_PECA"));
                if (estoque.get(i) < lista.get(i).getQuantidadeVendida()) {
                    estoqueInsuficiente = true;
                }
            }
            
            if (estoqueInsuficiente){
                JOptionPane.showMessageDialog(null, "Venda de peças não concluída. \n"
                        + "Uma ou mais peças do orçamento excedem a quantidade em estoque.");
            } else {
                sql = "UPDATE SYNCHROSOFT.TB_PECA "
                        + "SET QT_PECA = ? WHERE CD_PECA = ?";
                PreparedStatement st2 = con.prepareStatement(sql);
                for(int i = 0; i < lista.size(); i++){
                    st2.setInt(1, (estoque.get(i) - lista.get(i).getQuantidadeVendida()));
                    st2.setInt(2, lista.get(i).getPeca().getCodigoPeca());
                    st2.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "Venda de peças concluída.");
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao realizar venda de peça. \n"+ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static boolean existePeca(int codigo) throws SQLException, ClassNotFoundException{
        boolean flag;
        Connection con = Conexao.conectar();
        String sql = "SELECT CD_PECA FROM SYNCHROSOFT.TB_PECA WHERE CD_PECA = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        flag = rs.isBeforeFirst();
        st.close();
        rs.close();
        return flag;
    }
    
    public static Peca popularPeca(int codigo) throws SQLException, ClassNotFoundException{
        Peca p = new Peca();
        Connection con = Conexao.conectar();
        String sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE CD_PECA = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            
            p.setCodigoPeca(rs.getInt("CD_PECA"));
            p.setNomePeca(rs.getString("NM_PECA"));
            p.setCategoriaPeca(rs.getString("DS_CATEGORIA"));
            p.setQuantidadePeca(rs.getInt("QT_PECA"));
            p.setValorUnitario(rs.getFloat("VL_PECA"));
        }
        
        st.close();
        rs.close();
        return p;
    }
    
    public void deletarPeca (int cod) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM SYNCHROSOFT.TB_PECA WHERE CD_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cod);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Peça removida com sucesso.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover a peça.\nErro:\n\n" + ex.getMessage());
        }
    }

    public static ArrayList listarPeca() {
        ArrayList<Peca> lista = new ArrayList<>();
        try {
            Connection con = Conexao.conectar();
//            DatabaseMetaData teste = con.getMetaData();
//            System.out.println(teste.supportsBatchUpdates());
            String sql = "SELECT * FROM SYNCHROSOFT.TB_PECA";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Peca pecas = new Peca(rs.getInt("CD_PECA"), rs.getString("NM_PECA"), rs.getString("DS_CATEGORIA"), rs.getInt("QT_PECA"), rs.getFloat("VL_PECA"));
                lista.add(pecas);

            }
            
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.err.println("DAOPECA Instanciamento: " + ex);
        }
        //return lista;
        return lista;
    }
    
    public static ArrayList listarPecaFiltrada(String cmbFiltro, String txtPesquisa) {
        ArrayList<Peca> lista = new ArrayList<>();
        try {
            //Chamando método de conexão ao banco
            Connection con = Conexao.conectar();
            
            //Declarando variável de String de conexão
            String sql = "";
            
//            DatabaseMetaData teste = con.getMetaData();
//            System.out.println(teste.supportsBatchUpdates());

            //Criando estrutura switch case para identificar o tipo de filtro de pesquisa
            switch(cmbFiltro)
            {
                //preparando sql de acordo com código
                case "Código":  sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(CD_PECA) LIKE LOWER(?)";
                break;
                
                //preparando tratamento de acordo com nome
                case "Nome": sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(NM_PECA) LIKE LOWER(?)";
                break;
                
                //preparando tratamento de acordo com categoria
                case "Categoria": sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(DS_CATEGORIA) LIKE LOWER(?)";
                break;
                
                //preparando tratamento de acordo com quantidade em estoque
                case "Quantidade": sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(QT_PEC)A LIKE LOWER(?)";
                break;
                
                //preparando tratamento de acordo com valor da peça
                case "Valor": sql = "SELECT * FROM SYNCHROSOFT.TB_PECA WHERE LOWER(VL_PECA) LIKE LOWER(?)";
                break;
            }
            
            //realizando preparedStatement para tratamento de variáveis
            PreparedStatement st = con.prepareStatement(sql);
            
            //colocando valor da variável ? da query 
            st.setString(1, "%"+txtPesquisa+"%");
            
            //executando query selecionada pelo switch case
            ResultSet rs = st.executeQuery();
            
            //listando dados do banco em jtable
            while (rs.next()) {
                Peca pecas = new Peca(rs.getInt("CD_PECA"), rs.getString("NM_PECA"), rs.getString("DS_CATEGORIA"), rs.getInt("QT_PECA"), rs.getFloat("VL_PECA"));
                lista.add(pecas);

                /*lista.add(new String[]{String.valueOf(rs.getInt("CD_PECA")),
                (rs.getString("NM_PECA")),(rs.getString("DS_CATEGORIA")),
                String.valueOf(rs.getInt("QT_PECA")),String.valueOf(rs.getFloat("VL_PECA"))});                
                System.out.println(lista.get(0));*/
            }
            
            //teste de funcionamento do método
            System.out.println(lista.get(0).getNomePeca());
            
            //fechamento de preparedStatement e Conexão do banco
            st.close();
            rs.close();
            
        } catch (Exception ex) { //Caso exista a possibilidade de retorno de erro
            System.err.println("DAOPECA Instanciamento: " + ex);
        }
        //return lista;
        return lista;
    }

    public void alterarPeca(JTable tabela) throws SQLException, ClassNotFoundException {

        try{
            
            int rows = tabela.getRowCount();
            String log = "";
            JOptionPane.showConfirmDialog(null, "Deseja realizar a alteração?");

            Connection con = Conexao.conectar();
            con.setAutoCommit(false);
            String sql = "UPDATE SYNCHROSOFT.TB_PECA "
                    + "SET CD_PECA = ?, NM_PECA = ?, DS_CATEGORIA = ?, "
                    + "QT_PECA = ?, VL_PECA = ? WHERE CD_PECA = ?";
            PreparedStatement st = con.prepareStatement(sql);
            for (int row = 0; row < rows; row++) {
                
                String CD_PECA_ALTERADA = (String) tabela.getValueAt(row, 0);
                String NM_PECA = (String) tabela.getValueAt(row, 1);
                String DS_CATEGORIA = (String) tabela.getValueAt(row, 2);
                String QT_PECA = (String) tabela.getValueAt(row, 3);
                String VL_PECA = (String) tabela.getValueAt(row, 4);
                String CD_PECA_REFERENCIA = (String) tabela.getValueAt(row, 5);

                st.setInt(1, Integer.parseInt(CD_PECA_ALTERADA));                
                st.setString(2, NM_PECA);
                st.setString(3, DS_CATEGORIA);
                st.setInt(4, Integer.parseInt(QT_PECA));
                st.setFloat(5, Float.parseFloat(VL_PECA));
                st.setInt(6, Integer.parseInt(CD_PECA_REFERENCIA));

                st.addBatch();
                st.executeBatch();
                con.commit();
               
            }
            
             JOptionPane.showMessageDialog(null, "A base de peças foi alterada com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar a base de Peças. \n\n"+ex.getMessage());
        }

    }


}
