/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Texto;
import dao.DaoFuncionario;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Usuario;

/**
 *
 * @author Luiz
 */
public class FrmCadastroUsuario extends javax.swing.JFrame {

    boolean funcionarioExiste;
    boolean existeLogin;

    /**
     * Creates new form FrmCadastroUsuario
     */
    public FrmCadastroUsuario(int nvlAdm) {
        initComponents();
        if (nvlAdm == 0) {
            btnCadastrar.setEnabled(false);
        }
        iniciarlizarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoSexoExib = new javax.swing.ButtonGroup();
        pnlDadosFuncionario = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblExisteFuncionario = new javax.swing.JLabel();
        btnListarFuncionarios = new javax.swing.JButton();
        panDadosFunc = new javax.swing.JPanel();
        txtNomeFuncionario = new javax.swing.JTextField();
        lblNomeFuncionario = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        lblSexoDesc = new javax.swing.JLabel();
        lblHorasMensais = new javax.swing.JLabel();
        txtHorasMensais = new javax.swing.JTextField();
        lblNivelAdm = new javax.swing.JLabel();
        lblDescAdm = new javax.swing.JLabel();
        lblSexoValor = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblCodFuncionario = new javax.swing.JLabel();
        txtCodFuncionario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblConfirmarSenha = new javax.swing.JLabel();
        txtConfirma = new javax.swing.JPasswordField();
        btnListarUsuarios = new javax.swing.JButton();
        lblExisteLogin = new javax.swing.JLabel();
        btnMenuPrincipal = new javax.swing.JButton();
        btnFecharFrame = new javax.swing.JButton();
        lblUsuarioRecente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarioRecente = new javax.swing.JTable();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logopng32.png")));
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setPreferredSize(new java.awt.Dimension(1152, 648));
        setResizable(false);
        getContentPane().setLayout(null);

        pnlDadosFuncionario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlDadosFuncionario.setOpaque(false);
        pnlDadosFuncionario.setLayout(null);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setNextFocusableComponent(txtCodFuncionario);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        pnlDadosFuncionario.add(btnCadastrar);
        btnCadastrar.setBounds(690, 125, 130, 30);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        pnlDadosFuncionario.add(btnLimpar);
        btnLimpar.setBounds(560, 125, 100, 30);

        lblExisteFuncionario.setForeground(new java.awt.Color(255, 0, 0));
        lblExisteFuncionario.setText("Funcionário inexistente.");
        pnlDadosFuncionario.add(lblExisteFuncionario);
        lblExisteFuncionario.setBounds(342, 10, 160, 25);

        btnListarFuncionarios.setText("Listar Funcionários Cadastrados");
        btnListarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarFuncionariosActionPerformed(evt);
            }
        });
        pnlDadosFuncionario.add(btnListarFuncionarios);
        btnListarFuncionarios.setBounds(500, 7, 200, 30);

        panDadosFunc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Funcionário"), "Dados do funcionário")));
        panDadosFunc.setOpaque(false);
        panDadosFunc.setLayout(null);

        txtNomeFuncionario.setEditable(false);
        txtNomeFuncionario.setFocusable(false);
        panDadosFunc.add(txtNomeFuncionario);
        txtNomeFuncionario.setBounds(180, 20, 316, 25);

        lblNomeFuncionario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblNomeFuncionario.setText("Nome:");
        panDadosFunc.add(lblNomeFuncionario);
        lblNomeFuncionario.setBounds(10, 20, 140, 25);

        lblCpf.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCpf.setText("CPF:");
        panDadosFunc.add(lblCpf);
        lblCpf.setBounds(550, 20, 40, 25);

        txtCpf.setEditable(false);
        txtCpf.setFocusable(false);
        panDadosFunc.add(txtCpf);
        txtCpf.setBounds(630, 20, 130, 25);

        txtCargo.setEditable(false);
        txtCargo.setFocusable(false);
        panDadosFunc.add(txtCargo);
        txtCargo.setBounds(180, 60, 316, 25);

        lblCargo.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCargo.setText("Cargo:");
        panDadosFunc.add(lblCargo);
        lblCargo.setBounds(10, 60, 130, 25);

        lblSalario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblSalario.setText("Salário:");
        panDadosFunc.add(lblSalario);
        lblSalario.setBounds(790, 20, 70, 25);

        txtSalario.setEditable(false);
        txtSalario.setFocusable(false);
        panDadosFunc.add(txtSalario);
        txtSalario.setBounds(870, 20, 120, 25);

        lblSexoDesc.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblSexoDesc.setText("Sexo:");
        panDadosFunc.add(lblSexoDesc);
        lblSexoDesc.setBounds(550, 60, 50, 25);

        lblHorasMensais.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblHorasMensais.setText("Horas Mensais:");
        panDadosFunc.add(lblHorasMensais);
        lblHorasMensais.setBounds(10, 100, 140, 25);

        txtHorasMensais.setEditable(false);
        panDadosFunc.add(txtHorasMensais);
        txtHorasMensais.setBounds(180, 100, 140, 25);

        lblNivelAdm.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblNivelAdm.setText("Nível Administrativo do Sistema:");
        panDadosFunc.add(lblNivelAdm);
        lblNivelAdm.setBounds(550, 100, 264, 25);

        lblDescAdm.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDescAdm.setText("-");
        panDadosFunc.add(lblDescAdm);
        lblDescAdm.setBounds(850, 100, 180, 25);

        lblSexoValor.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblSexoValor.setText("-");
        panDadosFunc.add(lblSexoValor);
        lblSexoValor.setBounds(630, 60, 220, 25);

        pnlDadosFuncionario.add(panDadosFunc);
        panDadosFunc.setBounds(10, 160, 1060, 140);

        lblLogin.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblLogin.setText("Login:");
        pnlDadosFuncionario.add(lblLogin);
        lblLogin.setBounds(10, 50, 170, 25);

        txtLogin.setNextFocusableComponent(txtSenha);
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginKeyReleased(evt);
            }
        });
        pnlDadosFuncionario.add(txtLogin);
        txtLogin.setBounds(190, 50, 316, 25);

        lblCodFuncionario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCodFuncionario.setText("Cód. do Funcionário:");
        pnlDadosFuncionario.add(lblCodFuncionario);
        lblCodFuncionario.setBounds(10, 10, 170, 25);

        txtCodFuncionario.setNextFocusableComponent(txtLogin);
        txtCodFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodFuncionarioKeyReleased(evt);
            }
        });
        pnlDadosFuncionario.add(txtCodFuncionario);
        txtCodFuncionario.setBounds(190, 10, 140, 25);

        lblSenha.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblSenha.setText("Senha:");
        pnlDadosFuncionario.add(lblSenha);
        lblSenha.setBounds(10, 90, 170, 25);

        txtSenha.setNextFocusableComponent(txtConfirma);
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaKeyReleased(evt);
            }
        });
        pnlDadosFuncionario.add(txtSenha);
        txtSenha.setBounds(190, 90, 316, 25);

        lblConfirmarSenha.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblConfirmarSenha.setText("Confirmar Senha:");
        pnlDadosFuncionario.add(lblConfirmarSenha);
        lblConfirmarSenha.setBounds(560, 90, 140, 25);

        txtConfirma.setNextFocusableComponent(btnCadastrar);
        txtConfirma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmaKeyReleased(evt);
            }
        });
        pnlDadosFuncionario.add(txtConfirma);
        txtConfirma.setBounds(730, 90, 316, 25);

        btnListarUsuarios.setText("Listar Usuários Cadastrados");
        btnListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarUsuariosActionPerformed(evt);
            }
        });
        pnlDadosFuncionario.add(btnListarUsuarios);
        btnListarUsuarios.setBounds(730, 47, 200, 30);

        lblExisteLogin.setForeground(new java.awt.Color(255, 0, 0));
        lblExisteLogin.setText("Login Inválido.");
        pnlDadosFuncionario.add(lblExisteLogin);
        lblExisteLogin.setBounds(510, 50, 210, 25);

        getContentPane().add(pnlDadosFuncionario);
        pnlDadosFuncionario.setBounds(10, 10, 1125, 310);
        pnlDadosFuncionario.getAccessibleContext().setAccessibleName("Dados do funcionário");

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
        btnFecharFrame.setBounds(1055, 550, 80, 30);

        lblUsuarioRecente.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblUsuarioRecente.setText("Usuários Cadastrados Recentemente:");
        getContentPane().add(lblUsuarioRecente);
        lblUsuarioRecente.setBounds(10, 320, 350, 25);

        tblUsuarioRecente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblUsuarioRecente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 350, 1125, 170);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, -20, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrarUsuario();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarUsuariosActionPerformed
        control.Janelas.abrirListagemUsuario();
    }//GEN-LAST:event_btnListarUsuariosActionPerformed

    private void txtCodFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFuncionarioKeyReleased
        txtCodFuncionario.setText(Texto.maxLenghtFuncionario(txtCodFuncionario.getText()));
        verificarFuncionario();
    }//GEN-LAST:event_txtCodFuncionarioKeyReleased

    private void btnListarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarFuncionariosActionPerformed
        control.Janelas.abrirListagemFuncionario();
    }//GEN-LAST:event_btnListarFuncionariosActionPerformed

    private void txtLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyReleased
        txtLogin.setText(Texto.maxLenghtLogin(txtLogin.getText()));
        verificarLogin();
    }//GEN-LAST:event_txtLoginKeyReleased

    private void txtSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyReleased
        txtSenha.setText(Texto.maxLenghtSenha(txtSenha.getText()));
    }//GEN-LAST:event_txtSenhaKeyReleased

    private void txtConfirmaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmaKeyReleased
        txtConfirma.setText(Texto.maxLenghtSenha(txtConfirma.getText()));
    }//GEN-LAST:event_txtConfirmaKeyReleased

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        control.Janelas.focarPrincipal();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnFecharFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFrameActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharFrameActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

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
                new FrmCadastroUsuario(control.SynchroSoft.getNvlAdm()).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnFecharFrame;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListarFuncionarios;
    private javax.swing.JButton btnListarUsuarios;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.ButtonGroup grupoSexoExib;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodFuncionario;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDescAdm;
    private javax.swing.JLabel lblExisteFuncionario;
    private javax.swing.JLabel lblExisteLogin;
    private javax.swing.JLabel lblHorasMensais;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNivelAdm;
    private javax.swing.JLabel lblNomeFuncionario;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSexoDesc;
    private javax.swing.JLabel lblSexoValor;
    private javax.swing.JLabel lblUsuarioRecente;
    private javax.swing.JPanel panDadosFunc;
    private javax.swing.JPanel pnlDadosFuncionario;
    private javax.swing.JTable tblUsuarioRecente;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCodFuncionario;
    private javax.swing.JPasswordField txtConfirma;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtHorasMensais;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNomeFuncionario;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    private void limparCampoFuncionario() {
        lblExisteFuncionario.setText("Funcionário Inexistente.");
        lblExisteFuncionario.setForeground(Color.red);
        txtNomeFuncionario.setText("");
        txtCpf.setText("");
        txtCargo.setText("");
        txtSalario.setText("");
        txtHorasMensais.setText("");
        lblSexoValor.setText("-");
        lblDescAdm.setText("-");
    }

    private void iniciarlizarTabela() {
        String[] nomeColunas = {"Código Funcionario", "Nome", "Login"};
        try {
            DefaultTableModel model = new DefaultTableModel();
            tblUsuarioRecente.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao popular tabela.\n\n" + ex.getMessage(), "Erro de população de tabela", 0);
        }

    }

    private void atualizarTabela(Usuario usuario, String codigo, String nome) {
        Object rowData[] = new Object[4];

        rowData[0] = codigo;
        rowData[1] = nome;
        rowData[2] = usuario.getLogin();

        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblUsuarioRecente.getModel();
        model.addRow(rowData);
    }

    private void limpar() {
        txtCodFuncionario.setText("");
        limparCampoFuncionario();
        lblExisteFuncionario.setText("Código Inválido.");
        lblExisteFuncionario.setForeground(Color.red);
        txtLogin.setText("");
        txtSenha.setText("");
        txtConfirma.setText("");
        verificarLogin();
    }

    private void verificarFuncionario() {
        Funcionario func = new Funcionario();

        this.funcionarioExiste = DaoFuncionario.existeFuncionario(txtCodFuncionario.getText());
        if (this.funcionarioExiste) {
            func = DaoFuncionario.popularFuncionario(txtCodFuncionario.getText());
            lblExisteFuncionario.setText("Funcionário encontrado.");
            lblExisteFuncionario.setForeground(Color.BLACK);
            txtNomeFuncionario.setText(func.getPessoa().getNome());
            txtCpf.setText(func.getFisica().getCpf());
            txtCargo.setText(func.getCargo());
            txtSalario.setText("" + func.getSalarioSTR());
            txtHorasMensais.setText("" + func.getHorasTrabalhadas());
            if (func.getFisica().getSexoBanco() == 0) {
                lblSexoValor.setText("Masculino");
            } else {
                lblSexoValor.setText("Feminino");
            }
            lblDescAdm.setText(func.getNivelAdministrativo());
        } else {
            limparCampoFuncionario();
            this.funcionarioExiste = false;
        }
    }

    private void verificarLogin() {
        if (txtLogin.getText().length() < 4) {
            lblExisteLogin.setText("Login Inválido.");
            lblExisteLogin.setForeground(Color.red);
        } else {
            this.existeLogin = dao.DaoUsuario.existeLogin(txtLogin.getText());
            if (existeLogin) {
                lblExisteLogin.setText("Login já em uso!");
                lblExisteLogin.setForeground(Color.red);
            } else {
                lblExisteLogin.setText("Login disponível.");
                lblExisteLogin.setForeground(Color.black);
            }
        }
    }

    private boolean validarCampos() {
        if (!funcionarioExiste) {
            JOptionPane.showMessageDialog(null, "Funcionário inválido. "
                    + "\n\nInforme o Código de Funcionário existente", "Erro - Código de Funcionário inválido", 0);
            txtConfirma.requestFocus();
            return false;
        } else if (txtLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Login em branco. "
                    + "\n\nInforme o Login a ser utilizado pelo Usuário.",
                    "Erro - Login Inválido", 0);
            txtLogin.requestFocus();
            return false;
        } else if (txtLogin.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Login Inválido. "
                    + "\n\nInforme um Login com pelo menos 4 caractéres.",
                    "Erro - Login Inválido", 0);
            txtLogin.requestFocus();
            return false;
        } else if (existeLogin) {
            JOptionPane.showMessageDialog(null, "Login Inválido. "
                    + "\n\nO Login informado já está em uso. Digite um Login diferente.",
                    "Erro - Login Inválido", 0);
            txtLogin.requestFocus();
            return false;
        } else if (txtSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Senha em branco. "
                    + "\n\nInforme a Senha a ser utilizada pelo Usuário.",
                    "Erro - Senha Inválida", 0);
            txtSenha.requestFocus();
            return false;
        } else if (txtConfirma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Confirmação da senha em branco. "
                    + "\n\nInforme a confirmação da Senha igual ao campo de Senha informado.",
                    "Erro - Confirmação de Senha Inválida", 0);
            txtConfirma.requestFocus();
            return false;
        } else if (txtSenha.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Senha Inválida. "
                    + "\n\nInforme uma senha com pelo menos 4 caractéres.",
                    "Erro - Senha Inválida", 0);
            txtSenha.requestFocus();
            return false;
        } else if (!txtConfirma.getText().equals(txtSenha.getText())) {
            JOptionPane.showMessageDialog(null, "A Confirmação da Senha está diferente da Senha informada. "
                    + "\n\nInforme a confirmação da Senha igual ao campo de Senha informado.",
                    "Erro - Razão Social Inválido", 0);
            txtSenha.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void cadastrarUsuario() {
        if (validarCampos()) {
            Usuario usuario = new Usuario(txtCodFuncionario.getText(), txtLogin.getText(),
                    txtSenha.getText());
            boolean cadastroSucedido = dao.DaoUsuario.cadastrarUsuario(usuario);
            if (cadastroSucedido) {
                atualizarTabela(usuario, txtCodFuncionario.getText(), txtNomeFuncionario.getText());
                verificarFuncionario();
                verificarLogin();
            }
        }
    }

}
