/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.TextSize;
import dao.DaoPeca;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Peca;

/**
 *
 * @author Luiz
 */
public class FrmCadastroPeca extends javax.swing.JFrame {

    /**
     * Creates new form FrmCadastroPeca
     */
    public FrmCadastroPeca(int nvlAdm) {
        initComponents();
        inicializarTabela();
        if (nvlAdm == 0) {
            btnCadastrar.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMenuPrincipal = new javax.swing.JButton();
        btnFecharFrame = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCodigoPeca = new javax.swing.JLabel();
        lblCategoriaPeca = new javax.swing.JLabel();
        txtNomePeca = new javax.swing.JTextField();
        lblNomePeca = new javax.swing.JLabel();
        lblQuantidadePeca = new javax.swing.JLabel();
        lblValorUnitario = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnLimpar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnListarPeca = new javax.swing.JButton();
        txtQuantidadePeca = new javax.swing.JFormattedTextField();
        txtValorUnitario = new javax.swing.JFormattedTextField();
        lblQuantidadeMinima = new javax.swing.JLabel();
        txtQuantidadeMinima = new javax.swing.JFormattedTextField();
        lblQuantidadeMaxima = new javax.swing.JLabel();
        txtQuantidadeMaxima = new javax.swing.JFormattedTextField();
        txtCodigoPeca = new javax.swing.JTextField();
        lblProdutoRecente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutoRecente = new javax.swing.JTable();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Peça");
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setResizable(false);
        getContentPane().setLayout(null);

        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuPrincipal);
        btnMenuPrincipal.setBounds(900, 550, 130, 30);

        btnFecharFrame.setText("Fechar ");
        btnFecharFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharFrameActionPerformed(evt);
            }
        });
        getContentPane().add(btnFecharFrame);
        btnFecharFrame.setBounds(1050, 550, 80, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 510));

        lblCodigoPeca.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCodigoPeca.setText("Código de Barras");

        lblCategoriaPeca.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCategoriaPeca.setText("Categoria");

        txtNomePeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomePecaKeyReleased(evt);
            }
        });

        lblNomePeca.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblNomePeca.setText("Nome da Peça");

        lblQuantidadePeca.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblQuantidadePeca.setText("Quantidade");

        lblValorUnitario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblValorUnitario.setText("Valor Unitário");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerador", "Bombas", "Aquecedores", "Alarme de incêndio", "Pressurizadores de escada", "Alarme perimetral", "Cabine primária", "Redutoras de pressão" }));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnListarPeca.setText("Listar produtos cadastrados");
        btnListarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPecaActionPerformed(evt);
            }
        });

        txtQuantidadePeca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));
        txtQuantidadePeca.setText("0");
        txtQuantidadePeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadePecaActionPerformed(evt);
            }
        });
        txtQuantidadePeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadePecaKeyReleased(evt);
            }
        });

        txtValorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####0.00"))));
        txtValorUnitario.setText("0,00");
        txtValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorUnitarioActionPerformed(evt);
            }
        });
        txtValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorUnitarioKeyReleased(evt);
            }
        });

        lblQuantidadeMinima.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblQuantidadeMinima.setText("Alerta Qtd Mínima");

        txtQuantidadeMinima.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));
        txtQuantidadeMinima.setText("0");
        txtQuantidadeMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeMinimaActionPerformed(evt);
            }
        });
        txtQuantidadeMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeMinimaKeyReleased(evt);
            }
        });

        lblQuantidadeMaxima.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblQuantidadeMaxima.setText("Alerta Qtd Máxima");

        txtQuantidadeMaxima.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));
        txtQuantidadeMaxima.setText("0");
        txtQuantidadeMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeMaximaActionPerformed(evt);
            }
        });
        txtQuantidadeMaxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeMaximaKeyReleased(evt);
            }
        });

        txtCodigoPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoPecaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCodigoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoPeca))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblValorUnitario)
                                .addGap(33, 33, 33)
                                .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCategoriaPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(btnListarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblQuantidadePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuantidadePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(lblQuantidadeMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidadeMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(lblQuantidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuantidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoPeca)
                    .addComponent(lblCategoriaPeca)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomePeca)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValorUnitario)
                            .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidadePeca)
                    .addComponent(txtQuantidadePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidadeMinima)
                    .addComponent(txtQuantidadeMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidadeMaxima)
                    .addComponent(txtQuantidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 30, 1100, 240);

        lblProdutoRecente.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblProdutoRecente.setText("Produtos Cadastrados Recentemente:");
        getContentPane().add(lblProdutoRecente);
        lblProdutoRecente.setBounds(30, 280, 350, 25);

        tblProdutoRecente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProdutoRecente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 320, 1100, 210);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, -20, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Peca peca = new Peca(txtCodigoPeca.getText(), txtNomePeca.getText(), 
                cmbCategoria.getSelectedItem().toString(), 
                txtQuantidadePeca.getText() , txtQuantidadeMinima.getText(),
                txtQuantidadeMaxima.getText(), txtValorUnitario.getText());
        if (peca.isValidacao()) {
            DaoPeca.cadastrarPeca(peca);
            atualizarTabela(peca);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnListarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPecaActionPerformed
        control.Janelas.abrirListagemProduto();
    }//GEN-LAST:event_btnListarPecaActionPerformed

    private void btnFecharFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFrameActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharFrameActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        control.Janelas.focarPrincipal();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void txtNomePecaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomePecaKeyReleased
        txtNomePeca.setText(TextSize.maxLenghtNomePeca(txtNomePeca.getText()));
    }//GEN-LAST:event_txtNomePecaKeyReleased

    private void txtQuantidadePecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadePecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadePecaActionPerformed

    private void txtQuantidadePecaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadePecaKeyReleased
        txtQuantidadePeca.setText(TextSize.maxLenghtQuantidadePeca(txtQuantidadePeca.getText()));
    }//GEN-LAST:event_txtQuantidadePecaKeyReleased

    private void txtValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorUnitarioActionPerformed

    private void txtValorUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUnitarioKeyReleased
        txtValorUnitario.setText(TextSize.maxLenghtValorPeca(txtValorUnitario.getText()));
    }//GEN-LAST:event_txtValorUnitarioKeyReleased

    private void txtQuantidadeMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeMinimaActionPerformed

    private void txtQuantidadeMinimaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeMinimaKeyReleased
        txtQuantidadeMinima.setText(TextSize.maxLenghtQuantidadePeca(txtQuantidadeMinima.getText()));
    }//GEN-LAST:event_txtQuantidadeMinimaKeyReleased

    private void txtQuantidadeMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeMaximaActionPerformed

    private void txtQuantidadeMaximaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeMaximaKeyReleased
        txtQuantidadeMaxima.setText(TextSize.maxLenghtQuantidadePeca(txtQuantidadeMaxima.getText()));
    }//GEN-LAST:event_txtQuantidadeMaximaKeyReleased

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtCodigoPecaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPecaKeyReleased
        txtCodigoPeca.setText(TextSize.maxLenghtCodigoPeca(txtCodigoPeca.getText()));
    }//GEN-LAST:event_txtCodigoPecaKeyReleased

    private void limpar(){
        txtCodigoPeca.setText("");
        txtNomePeca.setText("");
        txtValorUnitario.setText("0,00");
        txtQuantidadePeca.setText("0");
        txtQuantidadeMinima.setText("0");
        txtQuantidadeMaxima.setText("0");
        cmbCategoria.setSelectedIndex(0);
    }
    
    private void inicializarTabela() {
        String[] nomeColunas = {"Código", "Nome", "Categoria", "Quantidade", "Alerta Qtd Mínima", "Alerta Qtd Máxima", "Valor Unitário"};
        try {
            DefaultTableModel model = new DefaultTableModel();
            tblProdutoRecente.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular tabela de cadastros recentes.\n\n" + ex.getMessage(), "Erro ao popular tabela", 0);
        }
        // tblProdutoRecente.getColumnModel().getColumn(0).setMaxWidth(0);
    }

    private void atualizarTabela(Peca peca) {
        Object rowData[] = new Object[7];

        rowData[0] = peca.getCodigoPeca();
        rowData[1] = peca.getNomePeca();
        rowData[2] = peca.getCategoriaPeca();
        rowData[3] = peca.getQuantidadePeca();
        rowData[4] = peca.getAlertaQtdMin();
        rowData[5] = peca.getAlertaQtdMax();
        rowData[6] = peca.getValorUnitario();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblProdutoRecente.getModel();
        model.addRow(rowData);
    }
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
            java.util.logging.Logger.getLogger(FrmCadastroPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroPeca(control.SynchroSoft.getNvlAdm()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFecharFrame;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListarPeca;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCategoriaPeca;
    private javax.swing.JLabel lblCodigoPeca;
    private javax.swing.JLabel lblNomePeca;
    private javax.swing.JLabel lblProdutoRecente;
    private javax.swing.JLabel lblQuantidadeMaxima;
    private javax.swing.JLabel lblQuantidadeMinima;
    private javax.swing.JLabel lblQuantidadePeca;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JTable tblProdutoRecente;
    private javax.swing.JTextField txtCodigoPeca;
    private javax.swing.JTextField txtNomePeca;
    private javax.swing.JFormattedTextField txtQuantidadeMaxima;
    private javax.swing.JFormattedTextField txtQuantidadeMinima;
    private javax.swing.JFormattedTextField txtQuantidadePeca;
    private javax.swing.JFormattedTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
