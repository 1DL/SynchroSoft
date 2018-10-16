/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Datas;
import control.TextSize;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Despesa;

/**
 *
 * @author Luiz
 */
public class FrmCadastroDespesa extends javax.swing.JFrame {

    public FrmCadastroDespesa(int nvlAdm) {
        initComponents();
        MaskFormatter dateMask;
        try {
            dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('/');
            dateMask.install(txtfDataVencimento);
        } catch (ParseException ex) {
            Logger.getLogger(FrmCadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtfDataVencimento.setText(Datas.converterParaBrasileira("" + new Date(Calendar.getInstance().getTimeInMillis())));

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescricaoDespesa = new javax.swing.JTextArea();
        lblDescrição = new javax.swing.JLabel();
        cmbTipoDespesa = new javax.swing.JComboBox<>();
        btnListarDespesas = new javax.swing.JButton();
        lblTipoDespesa = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        lblValorDespesa = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        lblVencimento = new javax.swing.JLabel();
        txtfDataVencimento = new javax.swing.JFormattedTextField();
        txtfValorDespesa = new javax.swing.JFormattedTextField();
        btnMenuPrincipal = new javax.swing.JButton();
        btnFecharFrame = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Despesa");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logopng32.png")));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        txaDescricaoDespesa.setColumns(20);
        txaDescricaoDespesa.setLineWrap(true);
        txaDescricaoDespesa.setRows(5);
        txaDescricaoDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDescricaoDespesaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txaDescricaoDespesa);

        lblDescrição.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDescrição.setText("Descrição detalhada da Despesa:");

        cmbTipoDespesa.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        cmbTipoDespesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serviço", "Obrigações", "Salarios a pagar" }));

        btnListarDespesas.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        btnListarDespesas.setText("Listar Despesas");
        btnListarDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarDespesasActionPerformed(evt);
            }
        });

        lblTipoDespesa.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblTipoDespesa.setText("Tipo de despesa:");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lblValorDespesa.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblValorDespesa.setText("Valor da despesa:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblVencimento.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblVencimento.setText("Data de Vencimento:");

        txtfDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtfDataVencimento.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N

        txtfValorDespesa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtfValorDespesa.setText("0,00");
        txtfValorDespesa.setNextFocusableComponent(txaDescricaoDespesa);
        txtfValorDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfValorDespesaActionPerformed(evt);
            }
        });
        txtfValorDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfValorDespesaKeyReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(btnLimpar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(31, 31, 31)
                        .add(btnCadastrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(35, 35, 35)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1010, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jPanel1Layout.createSequentialGroup()
                                    .add(lblTipoDespesa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(cmbTipoDespesa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 215, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(28, 28, 28)
                                    .add(lblVencimento)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(txtfDataVencimento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 52, Short.MAX_VALUE)
                                    .add(lblValorDespesa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(txtfValorDespesa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(jPanel1Layout.createSequentialGroup()
                                    .add(lblDescrição, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 343, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(btnListarDespesas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lblValorDespesa)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(lblTipoDespesa)
                        .add(cmbTipoDespesa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(lblVencimento))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtfDataVencimento)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtfValorDespesa))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(lblDescrição))
                    .add(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnListarDespesas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 260, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCadastrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnLimpar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 30, 1100, 420);

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

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, -20, 1150, 670);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
        Despesa desp = new Despesa(txtfDataVencimento.getText(), cmbTipoDespesa.getSelectedItem().toString(), 
                txaDescricaoDespesa.getText(), txtfValorDespesa.getText());
        
        dao.DaoDespesa.cadastrarDespesa(desp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular atributos de despesa. \n\nExceção JAVA:\n" +
                    ex.getMessage(), "Erro ao cadastrar despesas", 0);
        }
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnListarDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarDespesasActionPerformed
        control.Janelas.abrirListagemDespesa();
    }//GEN-LAST:event_btnListarDespesasActionPerformed

    private void txaDescricaoDespesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescricaoDespesaKeyReleased
        txaDescricaoDespesa.setText(TextSize.maxLenghtDescricaoDespesa(txaDescricaoDespesa.getText()));
    }//GEN-LAST:event_txaDescricaoDespesaKeyReleased

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        control.Janelas.focarPrincipal();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnFecharFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFrameActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharFrameActionPerformed

    private void txtfValorDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfValorDespesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfValorDespesaActionPerformed

    private void txtfValorDespesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfValorDespesaKeyReleased
        txtfValorDespesa.setText(control.TextSize.maxLenghtValorDespesa(txtfValorDespesa.getText()));
    }//GEN-LAST:event_txtfValorDespesaKeyReleased

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void limpar() {
        cmbTipoDespesa.setSelectedIndex(0);
        txtfValorDespesa.setText("0,00");
        txaDescricaoDespesa.setText("");
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
            java.util.logging.Logger.getLogger(FrmCadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroDespesa(control.SynchroSoft.getNvlAdm()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFecharFrame;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListarDespesas;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JComboBox<String> cmbTipoDespesa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDescrição;
    private javax.swing.JLabel lblTipoDespesa;
    private javax.swing.JLabel lblValorDespesa;
    private javax.swing.JLabel lblVencimento;
    private javax.swing.JTextArea txaDescricaoDespesa;
    private javax.swing.JFormattedTextField txtfDataVencimento;
    private javax.swing.JFormattedTextField txtfValorDespesa;
    // End of variables declaration//GEN-END:variables
}
