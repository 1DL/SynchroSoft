/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoEndereco;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;

/**
 *
 * @author Luiz
 */
public class FrmCadastroServico extends javax.swing.JFrame {

    boolean cepCadastrado;
    Endereco endExibicao;
    
    public FrmCadastroServico() {
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

        btngTipoCliente = new javax.swing.ButtonGroup();
        lblCNPJ = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        txtCep = new javax.swing.JTextField();
        txtCpfCnpj = new javax.swing.JTextField();
        lblCep1 = new javax.swing.JLabel();
        txtCep1 = new javax.swing.JTextField();
        lblCpfExiste = new javax.swing.JLabel();
        btnCadastrarPessoaF = new javax.swing.JButton();
        lblCepExiste = new javax.swing.JLabel();
        btnCadastrarCep = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rbtFisica = new javax.swing.JRadioButton();
        rbtJuridica = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNomePessoa = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        lblLogradouro = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        Bairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        Bairro1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        rbtFeminino = new javax.swing.JRadioButton();
        rbtMasculino = new javax.swing.JRadioButton();
        lblSexo = new javax.swing.JLabel();
        cmbTipoServico = new javax.swing.JComboBox<>();
        lblCnpjExiste = new javax.swing.JLabel();
        btnCadastrarPessoaJ = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        lblCNPJ.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCNPJ.setText("CNPJ:");
        getContentPane().add(lblCNPJ);
        lblCNPJ.setBounds(420, 120, 60, 50);

        lblCPF.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCPF.setText("CPF:");
        getContentPane().add(lblCPF);
        lblCPF.setBounds(420, 120, 60, 50);

        lblCep.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCep.setText("CEP:");
        getContentPane().add(lblCep);
        lblCep.setBounds(770, 120, 60, 50);

        txtCep.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCepKeyReleased(evt);
            }
        });
        getContentPane().add(txtCep);
        txtCep.setBounds(850, 130, 240, 30);

        txtCpfCnpj.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        getContentPane().add(txtCpfCnpj);
        txtCpfCnpj.setBounds(500, 130, 250, 30);

        lblCep1.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCep1.setText("Data de Cadastro:");
        getContentPane().add(lblCep1);
        lblCep1.setBounds(770, 50, 160, 50);

        txtCep1.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        getContentPane().add(txtCep1);
        txtCep1.setBounds(940, 60, 150, 30);

        lblCpfExiste.setText("Cpf inválido.");
        getContentPane().add(lblCpfExiste);
        lblCpfExiste.setBounds(550, 180, 60, 14);

        btnCadastrarPessoaF.setText("Cadastrar");
        btnCadastrarPessoaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPessoaFActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrarPessoaF);
        btnCadastrarPessoaF.setBounds(670, 180, 81, 23);

        lblCepExiste.setText("Cep inválido.");
        getContentPane().add(lblCepExiste);
        lblCepExiste.setBounds(880, 180, 62, 14);

        btnCadastrarCep.setText("Cadastrar");
        btnCadastrarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCepActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrarCep);
        btnCadastrarCep.setBounds(1010, 180, 81, 23);

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Tipo de Cliente:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 120, 160, 50);

        btngTipoCliente.add(rbtFisica);
        rbtFisica.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        rbtFisica.setSelected(true);
        rbtFisica.setText("Física");
        rbtFisica.setOpaque(false);
        rbtFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFisicaActionPerformed(evt);
            }
        });
        getContentPane().add(rbtFisica);
        rbtFisica.setBounds(210, 130, 69, 33);

        btngTipoCliente.add(rbtJuridica);
        rbtJuridica.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        rbtJuridica.setText("Jurídica");
        rbtJuridica.setOpaque(false);
        rbtJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtJuridicaActionPerformed(evt);
            }
        });
        getContentPane().add(rbtJuridica);
        rbtJuridica.setBounds(310, 130, 85, 33);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Pessoa"));

        lblNome.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblNome.setText("Nome");

        txtNomePessoa.setEditable(false);

        lblTelefone.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblTelefone.setText("Telefone");

        txtTelefone.setEditable(false);

        lblCelular.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCelular.setText("Celular");

        lblLogradouro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblLogradouro.setText("Logradouro");

        txtLogradouro.setEditable(false);

        lblCidade.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCidade.setText("Cidade");

        txtCidade.setEditable(false);

        lblEstado.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblEstado.setText("Estado");

        txtEstado.setEditable(false);

        Bairro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        Bairro.setText("Bairro");

        txtBairro.setEditable(false);

        Bairro1.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        Bairro1.setText("N°");

        txtNumero.setEditable(false);

        txtCelular.setEditable(false);

        rbtFeminino.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        rbtFeminino.setText("Feminino");
        rbtFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtFemininoActionPerformed(evt);
            }
        });

        rbtMasculino.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        rbtMasculino.setText("Masculino");
        rbtMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMasculinoActionPerformed(evt);
            }
        });

        lblSexo.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblSexo.setText("Sexo");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(lblSexo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(rbtMasculino)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(rbtFeminino)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                                    .add(lblNome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(txtNomePessoa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 316, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                                    .add(lblCidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(txtCidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(lblEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(txtEstado)))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(lblTelefone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtTelefone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 316, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(62, 62, 62)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel2Layout.createSequentialGroup()
                                        .add(Bairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .add(lblLogradouro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(27, 27, 27)))
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jPanel2Layout.createSequentialGroup()
                                        .add(txtBairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 178, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(Bairro1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(txtNumero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(txtLogradouro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 316, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(lblCelular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(txtCelular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 316, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(29, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblNome)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtNomePessoa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(lblLogradouro)
                        .add(txtLogradouro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lblCidade)
                                .add(txtCidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(18, 18, 18))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(lblEstado)
                                .add(txtEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(18, 18, 18)))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(Bairro)
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(txtBairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(Bairro1)
                                .add(txtNumero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblTelefone)
                    .add(txtTelefone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblCelular)
                    .add(txtCelular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblSexo)
                    .add(rbtMasculino)
                    .add(rbtFeminino))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 220, 1056, 193);

        cmbTipoServico.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        cmbTipoServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preventivo", "Corretivo", "Emergencial" }));
        getContentPane().add(cmbTipoServico);
        cmbTipoServico.setBounds(580, 60, 170, 31);

        lblCnpjExiste.setText("Cnpj inválido.");
        getContentPane().add(lblCnpjExiste);
        lblCnpjExiste.setBounds(550, 180, 70, 14);

        btnCadastrarPessoaJ.setText("Cadastrar");
        btnCadastrarPessoaJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPessoaJActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrarPessoaJ);
        btnCadastrarPessoaJ.setBounds(670, 180, 81, 23);

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Tipo de serviço:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 50, 160, 50);

        jTextField1.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 60, 180, 30);

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Código do serviço: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 50, 160, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFemininoActionPerformed

    }//GEN-LAST:event_rbtFemininoActionPerformed

    private void rbtMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMasculinoActionPerformed

    }//GEN-LAST:event_rbtMasculinoActionPerformed

    private void rbtFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtFisicaActionPerformed
    modoFisico();
    }//GEN-LAST:event_rbtFisicaActionPerformed

    private void rbtJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtJuridicaActionPerformed
        modoJuridico();
    }//GEN-LAST:event_rbtJuridicaActionPerformed

    private void btnCadastrarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCepActionPerformed
        FrmCadastroEndereco telaCep = new FrmCadastroEndereco();
        telaCep.setVisible(true);
    }//GEN-LAST:event_btnCadastrarCepActionPerformed

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCepActionPerformed

    private void txtCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyReleased
        if ((txtCep.getText().length() < 8) || (txtCep.getText().length() > 8)) {
            lblCepExiste.setText("Cep Inválido.");
            limparExibicaoEndereco();
        } else {
            DaoEndereco de = new DaoEndereco();
            try {
                cepCadastrado = de.existeEndereco(txtCep.getText());
                if (cepCadastrado) {
                    lblCepExiste.setText("CEP Cadastrado.");
                    endExibicao = de.popularEndereco(txtCep.getText());
                    popularExibicaoEndereco(endExibicao);
                } else {
                    lblCepExiste.setText("CEP Inexistente.");
                    limparExibicaoEndereco();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmCadastroPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCepKeyReleased

    private void btnCadastrarPessoaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPessoaFActionPerformed
        FrmCadastroPessoa telaCadPessoa = new FrmCadastroPessoa();
        telaCadPessoa.setVisible(true);
    }//GEN-LAST:event_btnCadastrarPessoaFActionPerformed

    private void btnCadastrarPessoaJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPessoaJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastrarPessoaJActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroServico().setVisible(true);
            }
        });
    }
    
    public void modoFisico()
    {
        lblCPF.setVisible(true);
        lblCNPJ.setVisible(false);
    }
    
    public void modoJuridico()
    {
        lblCPF.setVisible(false);
        lblCNPJ.setVisible(true);
    }
    
    public void popularExibicaoEndereco (Endereco end){
        txtLogradouro.setText(end.getLogradouro());
        txtCidade.setText(end.getCidade());
        txtBairro.setText(end.getBairro());
        txtEstado.setText(end.getEstado());
    }
    
    public void limparExibicaoEndereco (){
        txtLogradouro.setText("");
        txtCidade.setText("");
        txtBairro.setText("");
        txtEstado.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bairro;
    private javax.swing.JLabel Bairro1;
    private javax.swing.JButton btnCadastrarCep;
    private javax.swing.JButton btnCadastrarPessoaF;
    private javax.swing.JButton btnCadastrarPessoaJ;
    private javax.swing.ButtonGroup btngTipoCliente;
    private javax.swing.JComboBox<String> cmbTipoServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCNPJ;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCep1;
    private javax.swing.JLabel lblCepExiste;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCnpjExiste;
    private javax.swing.JLabel lblCpfExiste;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JRadioButton rbtFeminino;
    private javax.swing.JRadioButton rbtFisica;
    private javax.swing.JRadioButton rbtJuridica;
    private javax.swing.JRadioButton rbtMasculino;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCep1;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCpfCnpj;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtNomePessoa;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
