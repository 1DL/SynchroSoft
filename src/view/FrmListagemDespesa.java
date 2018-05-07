/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoDespesa;
import dao.DaoFuncionario;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Despesa;
import model.Funcionario;

/**
 *
 * @author LuizV1
 */
public class FrmListagemDespesa extends javax.swing.JFrame {

    /**
     * Creates new form FrmListagemDespesas
     */
    public FrmListagemDespesa() {
        initComponents();
        atualizarTabela();
        txtDataDepois.setText(""+ new Date(Calendar.getInstance().getTimeInMillis()));
    }
    DaoDespesa dp = new DaoDespesa();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDataAntes = new javax.swing.JTextField();
        lblPesquisar1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescricaoSelecionada = new javax.swing.JTextArea();
        txtDataDepois = new javax.swing.JTextField();
        lblPesquisarData1 = new javax.swing.JLabel();
        btnAtualizarTabela = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        lblPesquisarData = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        btnTelaCadastro = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagemDespesa = new javax.swing.JTable();
        lblPesquisar = new javax.swing.JLabel();
        btnHoje = new javax.swing.JButton();
        cmbFiltro = new javax.swing.JComboBox<>();
        lblDescrever = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        txtDataAntes.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtDataAntes.setText("1980-01-01");
        txtDataAntes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataAntesActionPerformed(evt);
            }
        });
        txtDataAntes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataAntesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataAntesKeyTyped(evt);
            }
        });
        getContentPane().add(txtDataAntes);
        txtDataAntes.setBounds(690, 50, 130, 40);

        lblPesquisar1.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar1.setText("Descrição da Despesa Selecionada:");
        getContentPane().add(lblPesquisar1);
        lblPesquisar1.setBounds(20, 400, 420, 40);

        txaDescricaoSelecionada.setColumns(20);
        txaDescricaoSelecionada.setRows(5);
        jScrollPane2.setViewportView(txaDescricaoSelecionada);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 430, 1080, 96);

        txtDataDepois.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtDataDepois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataDepoisActionPerformed(evt);
            }
        });
        txtDataDepois.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDataDepoisKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataDepoisKeyTyped(evt);
            }
        });
        getContentPane().add(txtDataDepois);
        txtDataDepois.setBounds(870, 50, 130, 40);

        lblPesquisarData1.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisarData1.setText("Até:");
        getContentPane().add(lblPesquisarData1);
        lblPesquisarData1.setBounds(830, 50, 70, 40);

        btnAtualizarTabela.setText("AtualizarTabela");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizarTabela);
        btnAtualizarTabela.setBounds(60, 550, 190, 40);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(301, 552, 210, 40);

        lblPesquisarData.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisarData.setText("Data:  De:");
        getContentPane().add(lblPesquisarData);
        lblPesquisarData.setBounds(600, 50, 90, 40);

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(545, 552, 170, 40);

        btnTelaCadastro.setText("Tela Cadastro");
        btnTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnTelaCadastro);
        btnTelaCadastro.setBounds(770, 550, 160, 50);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(990, 550, 130, 50);

        tblListagemDespesa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListagemDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemDespesaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListagemDespesa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(14, 119, 1090, 280);

        lblPesquisar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar por: ");
        getContentPane().add(lblPesquisar);
        lblPesquisar.setBounds(30, 50, 160, 40);

        btnHoje.setText("Hoje");
        btnHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHojeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHoje);
        btnHoje.setBounds(1010, 50, 100, 40);

        cmbFiltro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Tipo", "Data", "Descrição", "Valor" }));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(cmbFiltro);
        cmbFiltro.setBounds(160, 60, 107, 31);

        lblDescrever.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDescrever.setText("Descrição:");
        getContentPane().add(lblDescrever);
        lblDescrever.setBounds(270, 50, 83, 40);

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
        txtPesquisa.setBounds(370, 50, 221, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 650);

        setSize(new java.awt.Dimension(1168, 686));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            tblListagemDespesa.getCellEditor().stopCellEditing();
        } catch (Exception ex) {

        }
        try {
            dp.alterarDespesa(tblListagemDespesa);
        } catch (SQLException ex) {
            Logger.getLogger(FrmListagemDespesa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Despesa despesa = new Despesa();
        String aux;
        aux = (String) tblListagemDespesa.getValueAt(tblListagemDespesa.getSelectedRow(), 0);
        despesa.setCodigoDespesa(Integer.parseInt(aux));

        try {
            dp.deletarDespesa(despesa.getCodigoDespesa());
            atualizarTabela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaCadastroActionPerformed
        FrmCadastroDespesa telaCadastroDesp = new FrmCadastroDespesa();
        telaCadastroDesp.setVisible(true);
    }//GEN-LAST:event_btnTelaCadastroActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed

    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // Chamando método de listagem com filtro, se txt preenchido
        try {
            //criando variável de controle
            int controle = 0;

            //Se campo de texto não estiver vazio
            if (!"".equals(txtPesquisa.getText().trim())) {
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

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyTyped

    }//GEN-LAST:event_txtPesquisaKeyTyped

    private void txtDataAntesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataAntesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataAntesActionPerformed

    private void txtDataAntesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataAntesKeyReleased
        try {
            int controle = 0;
            if (!"".equals(txtDataAntes.getText().trim())) {
                controle = 1;
                atualizarTabelaFiltradaData();
            }
            if (controle == 0) {
                atualizarTabela();
            }
        } catch (Exception ex) {
            System.out.println("Exceção: " + ex);
        }
    }//GEN-LAST:event_txtDataAntesKeyReleased

    private void txtDataAntesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataAntesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataAntesKeyTyped

    private void txtDataDepoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataDepoisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataDepoisActionPerformed

    private void txtDataDepoisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataDepoisKeyReleased
        try {
            int controle = 0;
            if (!"".equals(txtDataDepois.getText().trim())) {
                controle = 1;
                atualizarTabelaFiltradaData();
            }
            if (controle == 0) {
                atualizarTabela();
            }
        } catch (Exception ex) {
            System.out.println("Exceção: " + ex);
        }        
    }//GEN-LAST:event_txtDataDepoisKeyReleased

    private void txtDataDepoisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataDepoisKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataDepoisKeyTyped

    private void tblListagemDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemDespesaMouseClicked
        txaDescricaoSelecionada.setText((String) tblListagemDespesa.getValueAt(tblListagemDespesa.getSelectedRow(), 3));
    }//GEN-LAST:event_tblListagemDespesaMouseClicked

    private void btnHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHojeActionPerformed
        txtDataDepois.setText(""+new Date(Calendar.getInstance().getTimeInMillis()));
        atualizarTabelaFiltradaData();
    }//GEN-LAST:event_btnHojeActionPerformed

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
            java.util.logging.Logger.getLogger(FrmListagemDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListagemDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListagemDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListagemDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListagemDespesa().setVisible(true);
            }
        });
    }
    
    private void atualizarTabelaFiltrada() {
        ArrayList<Despesa> lista = new ArrayList<>();
        lista = DaoDespesa.listarDespesaFiltrada((String) cmbFiltro.getSelectedItem(), txtPesquisa.getText().trim().toLowerCase());
        String[] nomeColunas = {"Código", "Tipo Despesa", "Data", "Descrição", "Valor", "PK_REF"};
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
            tblListagemDespesa.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
            Object rowData[] = new Object[6];
            for (int i = 0; i < lista.size(); i++) {
                rowData[0] = Integer.toString(lista.get(i).getCodigoDespesa());
                rowData[1] = lista.get(i).getTipoDespesas();
                rowData[2] = lista.get(i).getDataDespesa().toString();
                rowData[3] = lista.get(i).getDescricaoDespesa();             
                rowData[4] = Float.toString(lista.get(i).getValorDespesa());
                rowData[5] = Integer.toString(lista.get(i).getCodigoDespesa());
                
                model.addRow(rowData);
            }

        } catch (Exception ex) {
            System.out.println("Erro ao popular tabela.\n\n" + ex.getMessage());
        }
        
        tblListagemDespesa.getColumnModel().getColumn(5).setMinWidth(0);
        tblListagemDespesa.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblListagemDespesa.getColumnModel().getColumn(5).setMaxWidth(0);
    }
    
    private void atualizarTabelaFiltradaData() {
        ArrayList<Despesa> lista = new ArrayList<>();
        lista = DaoDespesa.listarDespesaFiltradaData(txtDataAntes.getText().trim(), txtDataDepois.getText().trim());
        String[] nomeColunas = {"Código", "Tipo Despesa", "Data", "Descrição", "Valor", "PK_REF"};
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
            tblListagemDespesa.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
            Object rowData[] = new Object[6];
            for (int i = 0; i < lista.size(); i++) {
                rowData[0] = Integer.toString(lista.get(i).getCodigoDespesa());
                rowData[1] = lista.get(i).getTipoDespesas();
                rowData[2] = lista.get(i).getDataDespesa().toString();
                rowData[3] = lista.get(i).getDescricaoDespesa();             
                rowData[4] = Float.toString(lista.get(i).getValorDespesa());
                rowData[5] = Integer.toString(lista.get(i).getCodigoDespesa());
                
                model.addRow(rowData);
            }

        } catch (Exception ex) {
            System.out.println("Erro ao popular tabela.\n\n" + ex.getMessage());
        }
        
        tblListagemDespesa.getColumnModel().getColumn(5).setMinWidth(0);
        tblListagemDespesa.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblListagemDespesa.getColumnModel().getColumn(5).setMaxWidth(0);
    }
    
    private void atualizarTabela() {
        ArrayList<Despesa> lista = new ArrayList<>();
        lista = DaoDespesa.listarDespesa();
        String[] nomeColunas = {"Código", "Tipo Despesa", "Data", "Descrição", "Valor", "PK_REF"};
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
            tblListagemDespesa.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
            Object rowData[] = new Object[6];
            for (int i = 0; i < lista.size(); i++) {
                rowData[0] = Integer.toString(lista.get(i).getCodigoDespesa());
                rowData[1] = lista.get(i).getTipoDespesas();
                rowData[2] = lista.get(i).getDataDespesa().toString();
                rowData[3] = lista.get(i).getDescricaoDespesa();             
                rowData[4] = Float.toString(lista.get(i).getValorDespesa());
                rowData[5] = Integer.toString(lista.get(i).getCodigoDespesa());
                
                model.addRow(rowData);
            }

        } catch (Exception ex) {
            System.out.println("Erro ao popular tabela.\n\n" + ex.getMessage());
        }
        
        tblListagemDespesa.getColumnModel().getColumn(5).setMinWidth(0);
        tblListagemDespesa.getColumnModel().getColumn(5).setPreferredWidth(0);
        tblListagemDespesa.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnHoje;
    private javax.swing.JButton btnTelaCadastro;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescrever;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblPesquisar1;
    private javax.swing.JLabel lblPesquisarData;
    private javax.swing.JLabel lblPesquisarData1;
    private javax.swing.JTable tblListagemDespesa;
    private javax.swing.JTextArea txaDescricaoSelecionada;
    private javax.swing.JTextField txtDataAntes;
    private javax.swing.JTextField txtDataDepois;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
