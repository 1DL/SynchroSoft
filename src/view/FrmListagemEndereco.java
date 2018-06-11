/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoEndereco;
import dao.DaoPeca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Peca;

/**
 *
 * @author Administrator
 */
public class FrmListagemEndereco extends javax.swing.JFrame {

    /**
     * Creates new form FrmListagemPeca
     */
    public FrmListagemEndereco() {
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
        tblListagemEndereco = new javax.swing.JTable();
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Endereços");
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        tblListagemEndereco.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListagemEndereco);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(232, 119, 632, 404);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(990, 550, 130, 50);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(446, 552, 67, 23);

        btnAtualizarTabela.setText("AtualizarTabela");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizarTabela);
        btnAtualizarTabela.setBounds(321, 552, 109, 23);

        btnTelaCadastro.setText("Tela Cadastro");
        btnTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnTelaCadastro);
        btnTelaCadastro.setBounds(644, 552, 101, 23);

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(545, 552, 69, 23);

        lblPesquisar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar por: ");
        getContentPane().add(lblPesquisar);
        lblPesquisar.setBounds(230, 50, 160, 40);

        cmbFiltro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CEP", "Logradouro", "Bairro", "Cidade", "Estado" }));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(cmbFiltro);
        cmbFiltro.setBounds(360, 60, 107, 33);

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
        txtPesquisa.setBounds(640, 50, 221, 40);

        lblDescrever.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDescrever.setText("Descrição:");
        getContentPane().add(lblDescrever);
        lblDescrever.setBounds(520, 50, 83, 30);

        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuPrincipal);
        btnMenuPrincipal.setBounds(949, 119, 161, 239);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    DaoEndereco de = new DaoEndereco();

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            tblListagemEndereco.getCellEditor().stopCellEditing();
        } catch (Exception ex) {

        }
        try {
            de.alterarEndereco(tblListagemEndereco);
        } catch (SQLException ex) {
            Logger.getLogger(FrmListagemEndereco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void btnTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaCadastroActionPerformed
        FrmCadastroEndereco telaCadastroEnd = new FrmCadastroEndereco();
        telaCadastroEnd.setVisible(true);
    }//GEN-LAST:event_btnTelaCadastroActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Endereco end = new Endereco();
        end.setCep((String) tblListagemEndereco.getValueAt(tblListagemEndereco.getSelectedRow(), 0));
        
        try {
            de.deletarEndereco(end.getCep());
            atualizarTabela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed

    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyTyped

    }//GEN-LAST:event_txtPesquisaKeyTyped

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // Chamando método de listagem com filtro, se txt preenchido
        try {
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
        } catch (Exception ex) {
            System.out.println("Exceção: " + ex);
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        FrmPrincipal princ = new FrmPrincipal();
        princ.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(FrmListagemEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListagemEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListagemEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListagemEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListagemEndereco().setVisible(true);
            }
        });
    }

    //Criando método de preenchimento/atualização de tabela com dados do banco
    private void atualizarTabela() {
        ArrayList<Endereco> lista = new ArrayList<>();
        lista = DaoEndereco.listarEndereco();
        String[] nomeColunas = {"CEP", "Logradouro", "Bairro", "Cidade", "Estado", "PK_REF"};
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 6) {
                        return false;
                    }
                    return true;
                }
            };
            tblListagemEndereco.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
            Object rowData[] = new Object[6];
            for (int i = 0; i < lista.size(); i++) {
                rowData[0] = lista.get(i).getCep();
                rowData[1] = lista.get(i).getLogradouro();
                rowData[2] = lista.get(i).getBairro();
                rowData[3] = lista.get(i).getCidade();
                rowData[4] = lista.get(i).getEstado();
                rowData[5] = lista.get(i).getCep();
                model.addRow(rowData);

            }

        } catch (Exception ex) {
            System.out.println("Erro ao popular tabela.\n\n" + ex.getMessage());
        }
        tblListagemEndereco.getColumnModel().getColumn(5).setMinWidth(0);
        tblListagemEndereco.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblListagemEndereco.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void atualizarTabelaFiltrada() {
        ArrayList<Endereco> lista = new ArrayList<>();
        lista = DaoEndereco.listarEnderecoFiltrada((String) cmbFiltro.getSelectedItem(), txtPesquisa.getText().toLowerCase().trim()); //Filtrando dados que aparecem na pesquisa
        String[] nomeColunas = {"CEP", "Logradouro", "Bairro", "Cidade", "Estado", "PK_REF"};
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 6) {
                        return false;
                    }
                    return true;
                }
            };
            tblListagemEndereco.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
            Object rowData[] = new Object[6];
            for (int i = 0; i < lista.size(); i++) {
                rowData[0] = lista.get(i).getCep();
                rowData[1] = lista.get(i).getLogradouro();
                rowData[2] = lista.get(i).getBairro();
                rowData[3] = lista.get(i).getCidade();
                rowData[4] = lista.get(i).getEstado();
                rowData[5] = lista.get(i).getCep();
                model.addRow(rowData);

            }

        } catch (Exception ex) {
            System.out.println("Erro ao popular tabela.\n\n" + ex.getMessage());
        }
        tblListagemEndereco.getColumnModel().getColumn(5).setMinWidth(0);
        tblListagemEndereco.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblListagemEndereco.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnTelaCadastro;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescrever;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JTable tblListagemEndereco;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
