/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoFuncionario;
import dao.DaoUsuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Usuario;

/**
 *
 * @author Luiz
 */
public class FrmCadastroUsuario extends javax.swing.JFrame {

    boolean flagFuncionario;

    /**
     * Creates new form FrmCadastroUsuario
     */
    public FrmCadastroUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodFuncionario = new javax.swing.JLabel();
        txtCodFuncionario = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtConfirma = new javax.swing.JPasswordField();
        lblSenha1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();
        btnListarUsuarios = new javax.swing.JButton();
        btnFecharFrame = new javax.swing.JButton();
        pnlDadosFuncionario = new javax.swing.JPanel();
        lblNomeFuncionario = new javax.swing.JLabel();
        txtNomeFuncionario = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        lblFuncionario = new javax.swing.JLabel();
        btnListarFuncionarios = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setPreferredSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        lblCodFuncionario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCodFuncionario.setText("Código do Funcionário:");
        getContentPane().add(lblCodFuncionario);
        lblCodFuncionario.setBounds(50, 70, 200, 25);

        txtCodFuncionario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtCodFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodFuncionarioKeyReleased(evt);
            }
        });
        getContentPane().add(txtCodFuncionario);
        txtCodFuncionario.setBounds(260, 70, 170, 30);

        lblLogin.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblLogin.setText("Login:");
        getContentPane().add(lblLogin);
        lblLogin.setBounds(670, 160, 60, 25);

        txtLogin.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        getContentPane().add(txtLogin);
        txtLogin.setBounds(740, 160, 280, 30);

        lblSenha.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(670, 240, 60, 25);

        txtSenha.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        getContentPane().add(txtSenha);
        txtSenha.setBounds(770, 240, 250, 31);

        txtConfirma.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        getContentPane().add(txtConfirma);
        txtConfirma.setBounds(770, 320, 250, 31);

        lblSenha1.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblSenha1.setText("Confirmar:");
        getContentPane().add(lblSenha1);
        lblSenha1.setBounds(670, 320, 90, 25);

        btnCadastrar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(100, 470, 220, 35);

        btnLimpar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnLimpar.setText("Limpar");
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(100, 560, 220, 35);

        btnMenuPrincipal.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuPrincipal);
        btnMenuPrincipal.setBounds(490, 420, 170, 210);

        btnListarUsuarios.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnListarUsuarios.setText("Listar Usuários");
        btnListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnListarUsuarios);
        btnListarUsuarios.setBounds(840, 460, 200, 30);

        btnFecharFrame.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnFecharFrame.setText("Fechar ");
        btnFecharFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharFrameActionPerformed(evt);
            }
        });
        getContentPane().add(btnFecharFrame);
        btnFecharFrame.setBounds(840, 550, 200, 35);

        pnlDadosFuncionario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlDadosFuncionario.setOpaque(false);

        lblNomeFuncionario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblNomeFuncionario.setText("Nome:");

        txtNomeFuncionario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N

        lblCpf.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCpf.setText("CPF:");

        txtCpf.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N

        lblCargo.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCargo.setText("Cargo:");

        txtCargo.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N

        lblSalario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblSalario.setText("Salário:");

        txtSalario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N

        org.jdesktop.layout.GroupLayout pnlDadosFuncionarioLayout = new org.jdesktop.layout.GroupLayout(pnlDadosFuncionario);
        pnlDadosFuncionario.setLayout(pnlDadosFuncionarioLayout);
        pnlDadosFuncionarioLayout.setHorizontalGroup(
            pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlDadosFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(pnlDadosFuncionarioLayout.createSequentialGroup()
                            .add(pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(lblNomeFuncionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(lblCpf, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(18, 18, 18)
                            .add(pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(txtNomeFuncionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(txtCpf, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(pnlDadosFuncionarioLayout.createSequentialGroup()
                            .add(lblCargo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(18, 18, 18)
                            .add(txtCargo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 193, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(63, 63, 63)))
                    .add(pnlDadosFuncionarioLayout.createSequentialGroup()
                        .add(lblSalario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(txtSalario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlDadosFuncionarioLayout.setVerticalGroup(
            pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlDadosFuncionarioLayout.createSequentialGroup()
                .add(21, 21, 21)
                .add(pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblNomeFuncionario)
                    .add(txtNomeFuncionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(32, 32, 32)
                .add(pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCpf)
                    .add(txtCpf, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblCargo)
                    .add(txtCargo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(pnlDadosFuncionarioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblSalario)
                    .add(txtSalario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(pnlDadosFuncionario);
        pnlDadosFuncionario.setBounds(50, 160, 380, 230);
        pnlDadosFuncionario.getAccessibleContext().setAccessibleName("Dados do funcionário");

        lblFuncionario.setForeground(new java.awt.Color(255, 0, 0));
        lblFuncionario.setText("Funcionário inexistente.");
        getContentPane().add(lblFuncionario);
        lblFuncionario.setBounds(260, 100, 210, 14);

        btnListarFuncionarios.setText("Listar Funcionários");
        btnListarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarFuncionariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnListarFuncionarios);
        btnListarFuncionarios.setBounds(450, 70, 150, 23);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            if (txtSenha.getText().trim().equals(txtConfirma.getText().trim())) {
                DaoUsuario dao = new DaoUsuario();
                Usuario user = new Usuario(Integer.parseInt(txtCodFuncionario.getText()), txtLogin.getText(), txtSenha.getText());
                try {
                    dao.cadastrarUsuario(user.getCodigoFuncionario(), user.getLogin(), user.getSenha());
                    JOptionPane.showMessageDialog(null, "Cadastrado!");
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmCadastroDespesa.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senha não corresponde à confirmação de senha!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        FrmPrincipal telaPrincipal = new FrmPrincipal();
        telaPrincipal.setVisible(true);
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarUsuariosActionPerformed
        FrmListagemUsuario ListagemUser = new FrmListagemUsuario();
        ListagemUser.setVisible(true);
    }//GEN-LAST:event_btnListarUsuariosActionPerformed

    private void btnFecharFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFrameActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharFrameActionPerformed

    private void txtCodFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFuncionarioKeyReleased
        Funcionario f = new Funcionario();
        DaoFuncionario dao = new DaoFuncionario();
        try {
            flagFuncionario = DaoFuncionario.existeFuncionario(Integer.parseInt(txtCodFuncionario.getText()));
            if (flagFuncionario) {
                f = DaoFuncionario.popularFuncionario(Integer.parseInt(txtCodFuncionario.getText()));
                lblFuncionario.setText("Funcionário encontrado.");
                lblFuncionario.setForeground(Color.BLACK);
                txtNomeFuncionario.setText(f.getPessoa().getNome());
                txtCpf.setText(f.getFisica().getCpf());
                txtCargo.setText(f.getCargo());
                txtSalario.setText("" + f.getSalario());
            } else {
                limparCampoFuncionario();
                flagFuncionario = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCodFuncionarioKeyReleased

    private void btnListarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarFuncionariosActionPerformed
        FrmListagemFuncionario ListagemFunc = new FrmListagemFuncionario();
        ListagemFunc.setVisible(true);
    }//GEN-LAST:event_btnListarFuncionariosActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroUsuario().setVisible(true);
            }
        });
    }

    private void limparCampoFuncionario() {
        lblFuncionario.setText("Funcionário Inexistente.");
        lblFuncionario.setForeground(Color.red);
        txtNomeFuncionario.setText("");
        txtCpf.setText("");
        txtCargo.setText("");
        txtSalario.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFecharFrame;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListarFuncionarios;
    private javax.swing.JButton btnListarUsuarios;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodFuncionario;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNomeFuncionario;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenha1;
    private javax.swing.JPanel pnlDadosFuncionario;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCodFuncionario;
    private javax.swing.JPasswordField txtConfirma;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNomeFuncionario;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
