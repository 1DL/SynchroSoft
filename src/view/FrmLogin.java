/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.TextSize;
import dao.DaoUsuario;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Luiz
 */
public class FrmLogin extends javax.swing.JFrame {
    
    //instanciando frm principal e login
//    FrmPrincipal principal = new FrmPrincipal();
//    FrmLogin telaLogin = new FrmLogin();
    
    public FrmLogin() throws IOException {
        control.LeitorArquivo.lerArquivoConfiguracoes();
        try {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
    }
    
    public void logar() throws IOException{
        //Parametrizando dados do banco de dados ORACLE
        dao.Conexao.setServerName(txt_ipBanco.getText());
        dao.Conexao.setServerPort(txt_portaBanco.getText());
        dao.Conexao.setUsername(txtp_usuarioDB.getText());
        dao.Conexao.setPassword(txtp_senhaDB.getText());
        dao.Conexao.setSid(txt_sid.getText());
        
        
        //chamando método de login de usuário
        int aux;
        aux = DaoUsuario.ChecarLogin(txtLogin.getText().trim(), txtPassword.getText().trim());
        
        if (aux == 0)
        {
            //Instanciando tela principal e chamando-a
            control.Janelas.abrirPrincipal();
            //Salva os parâmetros de login
            control.Opcoes.setLogin(txtLogin.getText());
            control.Opcoes.setIp(txt_ipBanco.getText());
            control.Opcoes.setPorta(txt_portaBanco.getText());
            control.Opcoes.setSID(txt_sid.getText());
            control.Opcoes.setUsuarioDB(txtp_usuarioDB.getText());
            control.Opcoes.setSenhaDB(txtp_senhaDB.getText());
            
            control.LeitorArquivo.escreverArquivoConfiguracoes();
            
            //eliminando a tela de login da memória
            this.dispose();
        }
        else if (aux == 1)
        {
            JOptionPane.showMessageDialog(null, "login e/ou senha não encontrados!");
        } else {
            
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

        jpnLogin = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        BtnAcesso = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        lbl_ip = new javax.swing.JLabel();
        txt_ipBanco = new javax.swing.JTextField();
        lbl_porta = new javax.swing.JLabel();
        txt_portaBanco = new javax.swing.JTextField();
        lbl_user = new javax.swing.JLabel();
        txtp_usuarioDB = new javax.swing.JPasswordField();
        lbl_senhaDB = new javax.swing.JLabel();
        txtp_senhaDB = new javax.swing.JPasswordField();
        lbl_sid = new javax.swing.JLabel();
        txt_sid = new javax.swing.JTextField();
        btn_debugrun = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Synchrosoft - Login");
        setIconImage(getIconImage());
        setSize(new java.awt.Dimension(1152, 648));

        jpnLogin.setAutoscrolls(true);
        jpnLogin.setOpaque(false);
        jpnLogin.setLayout(null);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/teste.png"))); // NOI18N
        jpnLogin.add(lblLogo);
        lblLogo.setBounds(10, 20, 203, 292);

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Login:");
        jpnLogin.add(jLabel2);
        jLabel2.setBounds(230, 20, 49, 25);

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Senha:");
        jpnLogin.add(jLabel3);
        jLabel3.setBounds(230, 80, 53, 25);

        txtLogin.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtLogin.setText(control.Opcoes.getLogin());
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginKeyReleased(evt);
            }
        });
        jpnLogin.add(txtLogin);
        txtLogin.setBounds(230, 50, 246, 31);

        BtnAcesso.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        BtnAcesso.setText("Acessar");
        BtnAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAcessoActionPerformed(evt);
            }
        });
        BtnAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAcessoKeyPressed(evt);
            }
        });
        jpnLogin.add(BtnAcesso);
        BtnAcesso.setBounds(360, 150, 110, 30);

        txtPassword.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        jpnLogin.add(txtPassword);
        txtPassword.setBounds(230, 110, 246, 31);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Banco de Dados"));
        jPanel1.setOpaque(false);

        lbl_ip.setText("IP:");

        txt_ipBanco.setText(control.Opcoes.getIp());
        txt_ipBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ipBancoActionPerformed(evt);
            }
        });

        lbl_porta.setText("Porta:");

        txt_portaBanco.setText(control.Opcoes.getPorta());

        lbl_user.setText("Usuário:");

        txtp_usuarioDB.setText(control.Opcoes.getUsuarioDB());

        lbl_senhaDB.setText("Senha:");

        txtp_senhaDB.setText(control.Opcoes.getSenhaDB());

        lbl_sid.setText("SID:");

        txt_sid.setText(control.Opcoes.getSID());

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(lbl_ip)
                        .add(30, 30, 30)
                        .add(txt_ipBanco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lbl_porta)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                                .add(lbl_senhaDB)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(txtp_senhaDB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                                .add(lbl_user)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtp_usuarioDB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lbl_sid)
                        .add(13, 13, 13)))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(txt_portaBanco, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .add(txt_sid))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_ip)
                    .add(txt_ipBanco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lbl_porta)
                    .add(txt_portaBanco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_user)
                    .add(txtp_usuarioDB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lbl_sid)
                    .add(txt_sid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbl_senhaDB)
                    .add(txtp_senhaDB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 6, Short.MAX_VALUE))
        );

        jpnLogin.add(jPanel1);
        jPanel1.setBounds(220, 190, 290, 100);

        btn_debugrun.setText("Debug run");
        btn_debugrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_debugrunActionPerformed(evt);
            }
        });
        jpnLogin.add(btn_debugrun);
        btn_debugrun.setBounds(230, 150, 100, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo pequeno.png"))); // NOI18N
        jLabel4.setLabelFor(this);
        jpnLogin.add(jLabel4);
        jLabel4.setBounds(0, 0, 540, 320);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpnLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 538, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpnLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 320, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAcessoActionPerformed
        try {
            logar();
        } catch (IOException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnAcessoActionPerformed

    private void txtLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyReleased
        txtLogin.setText(TextSize.maxLenghtLogin(txtLogin.getText()));
    }//GEN-LAST:event_txtLoginKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        txtPassword.setText(TextSize.maxLenghtSenha(txtPassword.getText()));
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                logar();
            } catch (IOException ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtLoginKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                logar();
            } catch (IOException ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void BtnAcessoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAcessoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                logar();
            } catch (IOException ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BtnAcessoKeyPressed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txt_ipBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ipBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ipBancoActionPerformed

    private void btn_debugrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_debugrunActionPerformed
        control.Janelas.abrirPrincipal();
        control.SynchroSoft.setNvlAdm(1);
        dao.Conexao.setServerName(txt_ipBanco.getText());
        dao.Conexao.setServerPort(txt_portaBanco.getText());
        dao.Conexao.setUsername(txtp_usuarioDB.getText());
        dao.Conexao.setPassword(txtp_senhaDB.getText());
        dao.Conexao.setSid(txt_sid.getText());
        this.dispose();
    }//GEN-LAST:event_btn_debugrunActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmLogin().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAcesso;
    private javax.swing.JButton btn_debugrun;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpnLogin;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lbl_ip;
    private javax.swing.JLabel lbl_porta;
    private javax.swing.JLabel lbl_senhaDB;
    private javax.swing.JLabel lbl_sid;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txt_ipBanco;
    private javax.swing.JTextField txt_portaBanco;
    private javax.swing.JTextField txt_sid;
    private javax.swing.JPasswordField txtp_senhaDB;
    private javax.swing.JPasswordField txtp_usuarioDB;
    // End of variables declaration//GEN-END:variables
}
