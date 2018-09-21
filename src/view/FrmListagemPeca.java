/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoPeca;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Peca;

/**
 *
 * @author Administrator
 */
public class FrmListagemPeca extends javax.swing.JFrame {

    /**
     * Creates new form FrmListagemPeca
     */
    public FrmListagemPeca(int nvlAdm) {
        initComponents();
        atualizarTabela();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagemPeca = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnAtualizarTabela = new javax.swing.JButton();
        btnTelaCadastro = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        lblPesquisar = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();
        lblDescrever = new javax.swing.JLabel();
        btnMenuPrincipal = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Peças Cadastradas");
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setPreferredSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        tblListagemPeca.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        tblListagemPeca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblListagemPeca);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(230, 130, 660, 402);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(990, 550, 130, 50);

        btnAlterar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(440, 560, 87, 35);

        btnAtualizarTabela.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnAtualizarTabela.setText("AtualizarTabela");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizarTabela);
        btnAtualizarTabela.setBounds(230, 560, 155, 35);

        btnTelaCadastro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnTelaCadastro.setText("Tela Cadastro");
        btnTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnTelaCadastro);
        btnTelaCadastro.setBounds(750, 560, 145, 35);

        btnDeletar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(590, 560, 93, 35);

        lblPesquisar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar por: ");
        getContentPane().add(lblPesquisar);
        lblPesquisar.setBounds(230, 60, 120, 25);

        cmbFiltro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome", "Categoria", "Quantidade", "Valor" }));
        getContentPane().add(cmbFiltro);
        cmbFiltro.setBounds(370, 60, 107, 33);

        txtPesquisa.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyTyped(evt);
            }
        });
        getContentPane().add(txtPesquisa);
        txtPesquisa.setBounds(670, 60, 221, 31);

        lblDescrever.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDescrever.setText("Descrição:");
        getContentPane().add(lblDescrever);
        lblDescrever.setBounds(530, 60, 83, 25);

        btnMenuPrincipal.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuPrincipal);
        btnMenuPrincipal.setBounds(960, 170, 161, 239);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    DaoPeca dp = new DaoPeca();

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        /*ArrayList<Peca> pecaAlterar = new ArrayList<>();
        JOptionPane.showMessageDialog(null,""+tblListagemPeca.getRowCount());
        JOptionPane.showMessageDialog(null,""+tblListagemPeca.getColumnCount());
        
        
        
        for (int i = 0; i <= tblListagemPeca.getRowCount();i++){
            
        }*/
        try {
            tblListagemPeca.getCellEditor().stopCellEditing();
        } catch (Exception ex) {

        }
        try {
            dp.alterarPeca(tblListagemPeca);
        } catch (SQLException ex) {
            Logger.getLogger(FrmListagemPeca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemPeca.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        atualizarTabela();

    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void btnTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaCadastroActionPerformed
        control.SynchroSoft.abrirCadastroProduto();
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        telaCadastro.setLocation(dim.width / 2 - this.getPreferredSize().width / 2, dim.height / 2 - this.getPreferredSize().height / 2);
//        telaCadastro.setVisible(true);
//        telaCadastro.setSize(1152, 648);

    }//GEN-LAST:event_btnTelaCadastroActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Peca peca = new Peca();
        String aux = (String) tblListagemPeca.getValueAt(tblListagemPeca.getSelectedRow(), 0);
        peca.setCodigoPeca(Integer.parseInt(aux));
        try {
            dp.deletarPeca(peca.getCodigoPeca());
            atualizarTabela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemPeca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed

    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyTyped

    }//GEN-LAST:event_txtPesquisaKeyTyped

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // Chamando método de listagem com filtro, se txt preenchido
//        try {
            //criando variável de controle
            int controle = 0;

            //Se campo de texto não estiver vazio
            if (txtPesquisa.getText().trim() != "") {
                controle = 1;
                atualizarTabelaFiltrada();
            }

            //Se a variável de controle for 0, diz-se que o campo está vazio e, portanto, atualiza a JTable
            if (controle == 0) {
                atualizarTabela();
            }
//        } catch (Exception ex) {
//            System.out.println("Exceção: " + ex);
//        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        control.SynchroSoft.abrirPrincipal();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListagemPeca(control.SynchroSoft.getNvlAdm()).setVisible(true);
            }
        });
    }

    //Criando método de preenchimento/atualização de tabela com dados do banco
    private void atualizarTabela() {
        //Instanciando array de peças para preenchimento da tabela
        ArrayList<Peca> lista = new ArrayList<>();
        //Chamando método para preenchimento de Jtable com dados da tabela de peça
        lista = DaoPeca.listarPeca();
        //Criando array com os nomes para cada coluna.
        String[] nomeColunas = {"Código", "Nome", "Categoria", "Quantidade", "Valor Unitário", "PK Ref"};
        try //Dentro deste try está a criação do modelo Jtable e o preenchimento das linhas pelo método ListarPeca()
        {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 5) {
                        //Coluna 6 não poderá ser editada.
                        return false;
                    }
                    return true;
                }
            };
            //atribui o modelo para a tabela.
            tblListagemPeca.setModel(model);
            //atribui os cabeçalhos para o modelo.
            model.setColumnIdentifiers(nomeColunas);
            //Remove as linhas da tabela.
            model.setRowCount(0);
            //declara um array de objetos para armazenar os valores.
            Object rowData[] = new Object[6];
            for (int i = 0; i < lista.size(); i++) {
                rowData[0] = Integer.toString(lista.get(i).getCodigoPeca());
                rowData[1] = lista.get(i).getNomePeca();
                rowData[2] = lista.get(i).getCategoriaPeca();
                rowData[3] = Integer.toString(lista.get(i).getQuantidadePeca());
                rowData[4] = Float.toString(lista.get(i).getValorUnitario());
                rowData[5] = Integer.toString(lista.get(i).getCodigoPeca());
                model.addRow(rowData);

            }

        } catch (Exception ex) {
            System.out.println("Erro ao popular tabela.\n\n" + ex.getMessage());
        }

        tblListagemPeca.getColumnModel().getColumn(5).setMinWidth(0);
        tblListagemPeca.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblListagemPeca.getColumnModel().getColumn(5).setMaxWidth(0);

    }

    private void atualizarTabelaFiltrada() { //Igual método de ListarPeca, mas chama o método de ListarPecaFiltrada()


        ArrayList<Peca> lista = new ArrayList<>();
        lista = DaoPeca.listarPecaFiltrada((String) cmbFiltro.getSelectedItem(), txtPesquisa.getText().trim().toLowerCase()); //Filtrando 
         String[] nomeColunas = {"Código", "Nome", "Categoria", "Quantidade", "Valor Unitário", "PK Ref"};
        try //Dentro deste try está a criação do modelo Jtable e o preenchimento das linhas pelo método ListarPeca()
        {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 5) {
                        //Coluna 6 não poderá ser editada.
                        return false;
                    }
                    return true;
                }
            };
            //atribui o modelo para a tabela.
            tblListagemPeca.setModel(model);
            //atribui os cabeçalhos para o modelo.
            model.setColumnIdentifiers(nomeColunas);
            //Remove as linhas da tabela.
            model.setRowCount(0);
            //declara um array de objetos para armazenar os valores.
            Object rowData[] = new Object[6];
            for (int i = 0; i < lista.size(); i++) {
                rowData[0] = Integer.toString(lista.get(i).getCodigoPeca());
                rowData[1] = lista.get(i).getNomePeca();
                rowData[2] = lista.get(i).getCategoriaPeca();
                rowData[3] = Integer.toString(lista.get(i).getQuantidadePeca());
                rowData[4] = Float.toString(lista.get(i).getValorUnitario());
                rowData[5] = Integer.toString(lista.get(i).getCodigoPeca());
                model.addRow(rowData);

            }

        } catch (Exception ex) {
            System.out.println("Erro ao popular tabela.\n\n" + ex.getMessage());
        }

        tblListagemPeca.getColumnModel().getColumn(5).setMinWidth(0);
        tblListagemPeca.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblListagemPeca.getColumnModel().getColumn(5).setMaxWidth(0);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnTelaCadastro;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescrever;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JTable tblListagemPeca;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
