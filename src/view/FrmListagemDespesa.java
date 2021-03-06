/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Texto;
import dao.DaoDespesa;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Despesa;

/**
 *
 * @author LuizV1
 */
public class FrmListagemDespesa extends javax.swing.JFrame {
    
    private boolean ultimoTipoPesquisa;
    private long PK_REF;
    
    /**
     * Creates new form FrmListagemDespesas
     */
    public FrmListagemDespesa(int nvlAdm) {
        initComponents();
        inicializarTabela();
        txtfDataDe.setText(control.Datas.getDiaHoje());
        txtfDataAte.setText(control.Datas.getDiaHoje());
        selecionarAoFocar();
        modoPesquisaNormal();
        definirNivelAcesso(nvlAdm);
    }
    
    public FrmListagemDespesa(int nvlAdm, int codigoDespesa) {
        initComponents();
        inicializarTabela();
        txtfDataDe.setText(control.Datas.getDiaHoje());
        txtfDataAte.setText(control.Datas.getDiaHoje());
        selecionarAoFocar();
        modoPesquisaNormal();
        
        txtPesquisa.setText(String.valueOf(codigoDespesa));
        pesquisarFiltrada();
        selecionarLinhaTabela(codigoDespesa);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoQuitada = new javax.swing.ButtonGroup();
        panPrincipal = new javax.swing.JPanel();
        lblPesquisar = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox<>();
        panPrincipal1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDescricaoDespesa = new javax.swing.JTextArea();
        lblDescrição = new javax.swing.JLabel();
        cmbTipoDespesa = new javax.swing.JComboBox<>();
        lblTipoDespesa = new javax.swing.JLabel();
        lblValorDespesa = new javax.swing.JLabel();
        lblVencimento = new javax.swing.JLabel();
        txtfDataVencimento = new javax.swing.JFormattedTextField();
        txtfValorDespesa = new javax.swing.JFormattedTextField();
        lblQuitada = new javax.swing.JLabel();
        rbtQuitadaSim = new javax.swing.JRadioButton();
        rbtQuitadaNao = new javax.swing.JRadioButton();
        btnDeletar = new javax.swing.JButton();
        btnLimparTabela = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();
        btnCadastrarDespesa = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        lblDigiteODado = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        txtfDataDe = new javax.swing.JFormattedTextField();
        btnHojePesquisa = new javax.swing.JButton();
        lblDataAte = new javax.swing.JLabel();
        txtfDataAte = new javax.swing.JFormattedTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagemDespesa = new javax.swing.JTable();
        btnDeletarTodosRegistros = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();
        btnFecharFrame = new javax.swing.JButton();
        lblDespesaEncontrado = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Despesas");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logopng32.png")));
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setResizable(false);
        getContentPane().setLayout(null);

        panPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panPrincipal.setOpaque(false);
        panPrincipal.setLayout(null);

        lblPesquisar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar por: ");
        panPrincipal.add(lblPesquisar);
        lblPesquisar.setBounds(10, 10, 160, 25);

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Tipo de Despesa", "Descrição Detalhada", "Valor", "Quitada?", "Data de Vencimento", "Data de Vencimento Entre/Até" }));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        panPrincipal.add(cmbFiltro);
        cmbFiltro.setBounds(160, 10, 210, 25);

        panPrincipal1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Despesa"));
        panPrincipal1.setOpaque(false);
        panPrincipal1.setLayout(null);

        txaDescricaoDespesa.setColumns(20);
        txaDescricaoDespesa.setLineWrap(true);
        txaDescricaoDespesa.setRows(5);
        txaDescricaoDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDescricaoDespesaKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txaDescricaoDespesa);

        panPrincipal1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 123, 1070, 120);

        lblDescrição.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDescrição.setText("Descrição detalhada da Despesa:");
        panPrincipal1.add(lblDescrição);
        lblDescrição.setBounds(10, 100, 343, 25);

        cmbTipoDespesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serviço", "Obrigações", "Salarios a pagar" }));
        panPrincipal1.add(cmbTipoDespesa);
        cmbTipoDespesa.setBounds(166, 10, 215, 25);

        lblTipoDespesa.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblTipoDespesa.setText("Tipo de despesa:");
        panPrincipal1.add(lblTipoDespesa);
        lblTipoDespesa.setBounds(10, 10, 150, 25);

        lblValorDespesa.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblValorDespesa.setText("Valor da despesa:");
        panPrincipal1.add(lblValorDespesa);
        lblValorDespesa.setBounds(770, 10, 150, 25);

        lblVencimento.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblVencimento.setText("Data de Vencimento:");
        panPrincipal1.add(lblVencimento);
        lblVencimento.setBounds(409, 10, 171, 25);

        txtfDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        panPrincipal1.add(txtfDataVencimento);
        txtfDataVencimento.setBounds(590, 10, 128, 25);

        txtfValorDespesa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtfValorDespesa.setText("0,00");
        txtfValorDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfValorDespesaKeyReleased(evt);
            }
        });
        panPrincipal1.add(txtfValorDespesa);
        txtfValorDespesa.setBounds(930, 10, 125, 25);

        lblQuitada.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblQuitada.setText("Quitada:");
        panPrincipal1.add(lblQuitada);
        lblQuitada.setBounds(10, 50, 140, 25);

        grupoQuitada.add(rbtQuitadaSim);
        rbtQuitadaSim.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        rbtQuitadaSim.setText("Sim");
        rbtQuitadaSim.setOpaque(false);
        rbtQuitadaSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtQuitadaSimActionPerformed(evt);
            }
        });
        panPrincipal1.add(rbtQuitadaSim);
        rbtQuitadaSim.setBounds(160, 50, 55, 25);

        grupoQuitada.add(rbtQuitadaNao);
        rbtQuitadaNao.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        rbtQuitadaNao.setText("Não");
        rbtQuitadaNao.setOpaque(false);
        rbtQuitadaNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtQuitadaNaoActionPerformed(evt);
            }
        });
        panPrincipal1.add(rbtQuitadaNao);
        rbtQuitadaNao.setBounds(220, 50, 105, 25);

        panPrincipal.add(panPrincipal1);
        panPrincipal1.setBounds(10, 50, 1100, 250);

        btnDeletar.setText("Deletar registro selecionado");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        panPrincipal.add(btnDeletar);
        btnDeletar.setBounds(10, 310, 170, 30);

        btnLimparTabela.setText("Limpar tabela");
        btnLimparTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTabelaActionPerformed(evt);
            }
        });
        panPrincipal.add(btnLimparTabela);
        btnLimparTabela.setBounds(410, 310, 120, 30);

        btnListarTodos.setText("Listar todos os registros");
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
            }
        });
        panPrincipal.add(btnListarTodos);
        btnListarTodos.setBounds(550, 310, 147, 30);

        btnCadastrarDespesa.setText("Cadastrar nova despesa");
        btnCadastrarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarDespesaActionPerformed(evt);
            }
        });
        panPrincipal.add(btnCadastrarDespesa);
        btnCadastrarDespesa.setBounds(720, 310, 150, 30);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        panPrincipal.add(btnAlterar);
        btnAlterar.setBounds(980, 310, 130, 30);

        lblDigiteODado.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDigiteODado.setText("Digite o cód. da despesa:");
        panPrincipal.add(lblDigiteODado);
        lblDigiteODado.setBounds(375, 10, 280, 25);

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        panPrincipal.add(txtPesquisa);
        txtPesquisa.setBounds(620, 10, 60, 25);

        txtfDataDe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtfDataDe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfDataDeKeyReleased(evt);
            }
        });
        panPrincipal.add(txtfDataDe);
        txtfDataDe.setBounds(620, 10, 100, 25);

        btnHojePesquisa.setText("Hoje");
        btnHojePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHojePesquisaActionPerformed(evt);
            }
        });
        panPrincipal.add(btnHojePesquisa);
        btnHojePesquisa.setBounds(730, 10, 55, 25);

        lblDataAte.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDataAte.setText("Até:");
        panPrincipal.add(lblDataAte);
        lblDataAte.setBounds(800, 10, 34, 25);

        txtfDataAte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtfDataAte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfDataAteKeyReleased(evt);
            }
        });
        panPrincipal.add(txtfDataAte);
        txtfDataAte.setBounds(840, 10, 100, 25);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        panPrincipal.add(btnPesquisar);
        btnPesquisar.setBounds(950, 10, 79, 25);

        getContentPane().add(panPrincipal);
        panPrincipal.setBounds(10, 10, 1125, 350);

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
        jScrollPane1.setBounds(10, 390, 1125, 150);

        btnDeletarTodosRegistros.setText("Deletar todos os registros");
        btnDeletarTodosRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarTodosRegistrosActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletarTodosRegistros);
        btnDeletarTodosRegistros.setBounds(10, 550, 160, 30);

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

        lblDespesaEncontrado.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDespesaEncontrado.setText("Despesas encontradas no banco de dados. Para visualizar ou alterar um registro, clique em um registro exibido na tabela.");
        getContentPane().add(lblDespesaEncontrado);
        lblDespesaEncontrado.setBounds(10, 360, 1120, 25);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, -20, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        lblDigiteODado.setText("Digite o(a) " + cmbFiltro.getSelectedItem().toString() + ":");
        limiteDigitosPesquisa(cmbFiltro.getSelectedItem().toString());
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void tblListagemDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemDespesaMouseClicked
        popularCampos();
    }//GEN-LAST:event_tblListagemDespesaMouseClicked

    private void txaDescricaoDespesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescricaoDespesaKeyReleased
        txaDescricaoDespesa.setText(Texto.maxLenghtDescricaoDespesa(txaDescricaoDespesa.getText()));
    }//GEN-LAST:event_txaDescricaoDespesaKeyReleased

    private void txtfValorDespesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfValorDespesaKeyReleased
        txtfValorDespesa.setText(control.Texto.maxLenghtValorDespesa(txtfValorDespesa.getText()));
    }//GEN-LAST:event_txtfValorDespesaKeyReleased

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        deletarRegistro();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnLimparTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTabelaActionPerformed
        limparTabela();
    }//GEN-LAST:event_btnLimparTabelaActionPerformed

    private void btnListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosActionPerformed
        atualizarTabela(false);
    }//GEN-LAST:event_btnListarTodosActionPerformed

    private void btnCadastrarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarDespesaActionPerformed
        control.Janelas.abrirCadastroDespesa();
    }//GEN-LAST:event_btnCadastrarDespesaActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarRegistro();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarTodosRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarTodosRegistrosActionPerformed
        removerTodosRegistros();
    }//GEN-LAST:event_btnDeletarTodosRegistrosActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        control.Janelas.focarPrincipal();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnFecharFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFrameActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharFrameActionPerformed

    private void rbtQuitadaSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtQuitadaSimActionPerformed

    }//GEN-LAST:event_rbtQuitadaSimActionPerformed

    private void rbtQuitadaNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtQuitadaNaoActionPerformed

    }//GEN-LAST:event_rbtQuitadaNaoActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        limiteDigitosPesquisa(cmbFiltro.getSelectedItem().toString());
        pesquisarFiltrada();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void txtfDataDeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfDataDeKeyReleased
        txtfDataDe.setText(control.Texto.maxLenghtData(txtfDataDe.getText()));
    }//GEN-LAST:event_txtfDataDeKeyReleased

    private void btnHojePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHojePesquisaActionPerformed
        txtfDataDe.setText(control.Datas.getDiaHoje());
        txtfDataAte.setText(control.Datas.getDiaHoje());
    }//GEN-LAST:event_btnHojePesquisaActionPerformed

    private void txtfDataAteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfDataAteKeyReleased
        txtfDataAte.setText(control.Texto.maxLenghtData(txtfDataAte.getText()));
    }//GEN-LAST:event_txtfDataAteKeyReleased

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        txtfDataDe.setText(txtfDataDe.getText().trim());
        txtfDataAte.setText(txtfDataAte.getText().trim());
        if (txtfDataDe.getText().length() == 10 && txtfDataAte.getText().length() == 10) {
            atualizarTabela(true);
        } else {
            limparTabela();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

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
                new FrmListagemDespesa(control.SynchroSoft.getNvlAdm()).setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrarDespesa;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnDeletarTodosRegistros;
    private javax.swing.JButton btnFecharFrame;
    private javax.swing.JButton btnHojePesquisa;
    private javax.swing.JButton btnLimparTabela;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JComboBox<String> cmbTipoDespesa;
    private javax.swing.ButtonGroup grupoQuitada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDataAte;
    private javax.swing.JLabel lblDescrição;
    private javax.swing.JLabel lblDespesaEncontrado;
    private javax.swing.JLabel lblDigiteODado;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblQuitada;
    private javax.swing.JLabel lblTipoDespesa;
    private javax.swing.JLabel lblValorDespesa;
    private javax.swing.JLabel lblVencimento;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JPanel panPrincipal1;
    private javax.swing.JRadioButton rbtQuitadaNao;
    private javax.swing.JRadioButton rbtQuitadaSim;
    private javax.swing.JTable tblListagemDespesa;
    private javax.swing.JTextArea txaDescricaoDespesa;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JFormattedTextField txtfDataAte;
    private javax.swing.JFormattedTextField txtfDataDe;
    private javax.swing.JFormattedTextField txtfDataVencimento;
    private javax.swing.JFormattedTextField txtfValorDespesa;
    // End of variables declaration//GEN-END:variables

      
        
    private void selecionarLinhaTabela(int codigoDespesa) {
        int indiceTabela = 0;
        for (int i = 0; i < tblListagemDespesa.getModel().getRowCount(); i++) {
            String codigoDaLinha = String.valueOf(tblListagemDespesa.getModel().getValueAt(i, 0));
            if (codigoDespesa == Integer.parseInt(codigoDaLinha)) {
                indiceTabela = i;
            }
        }
        tblListagemDespesa.getSelectionModel().setSelectionInterval(indiceTabela, indiceTabela);
        popularCampos();
    }

    private void selecionarAoFocar() {
        //Código para selecionar o texto todo ao ganhar foco
        txtfDataDe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtfDataDe.selectAll();
                    }
                });
            }
        });

        txtfDataAte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtfDataAte.selectAll();
                    }
                });
            }
        });

        txtfDataVencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtfDataVencimento.selectAll();
                    }
                });
            }
        });
    }

    private void inicializarTabela() {
        String[] nomeColunas = {"Código", "Tipo de Despesa", "Data de Vencimento", "Valor", "Quitada?", "Descrição Detalhada"};

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblListagemDespesa.setModel(model);
        model.setColumnIdentifiers(nomeColunas);
        model.setRowCount(0);
    }

    private void modoPesquisaNormal() {
        txtPesquisa.setSize(490, 25);
        txtPesquisa.setVisible(true);
        txtfDataDe.setVisible(false);
        txtfDataAte.setVisible(false);
        lblDataAte.setVisible(false);
        btnPesquisar.setVisible(false);
    }

    private void pesquisarFiltrada() {
        int opcaoFiltro = cmbFiltro.getSelectedIndex();
        int opcaoDataCadastro = 5;
        int opcaoDataDeAte = 6;

        if ((opcaoFiltro != opcaoDataCadastro) && (opcaoFiltro != opcaoDataDeAte)) {
            if (!"".equals(txtPesquisa.getText().trim())) {
                atualizarTabela(true);
            } else {
                limparTabela();
            }
        }
    }

    private void atualizarTabela(boolean filtrada) {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblListagemDespesa.getModel();
        model.setRowCount(0);

        ArrayList<Despesa> lista = new ArrayList<>();

        if (filtrada) {
            lista = DaoDespesa.listarDespesaFiltrada(String.valueOf(cmbFiltro.getSelectedItem()),
                    txtPesquisa.getText().toLowerCase().trim(), txtfDataDe.getText().toLowerCase().trim(),
                    txtfDataAte.getText().toLowerCase().trim());
            ultimoTipoPesquisa = true;
        } else {
            lista = DaoDespesa.listarDespesa();
            ultimoTipoPesquisa = false;
        }

        Object dadosLinha[] = new Object[6];

        for (int i = 0; i < lista.size(); i++) {
            dadosLinha[0] = lista.get(i).getCodigoDespesa();
            dadosLinha[1] = lista.get(i).getTipoDespesas();
            dadosLinha[2] = lista.get(i).getDataDespesa();
            dadosLinha[3] = lista.get(i).getValorDespesaSTR();
            dadosLinha[4] = lista.get(i).getQuitadaSTR();
            dadosLinha[5] = lista.get(i).getDescricaoDespesa();
            model.addRow(dadosLinha);
        }
        //String[] nomeColunas = {"Código", "Tipo de Despesa", "Data de Vencimento", "Valor", "Quitada?", "Descrição Detalhada"};

        limparCampos();

    }

    private void limparCampos() {
        cmbTipoDespesa.setSelectedIndex(0);
        txtfDataVencimento.setText("");
        txtfValorDespesa.setText("0,00");
        txaDescricaoDespesa.setText("");
        rbtQuitadaNao.setSelected(false);
        rbtQuitadaSim.setSelected(false);
        PK_REF = -1;
    }

    private void limparTabela() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblListagemDespesa.getModel();
        model.setRowCount(0);
        /*
        Chama o metodo limparCampos para limpar os dados do registro anteriormente
        selecionado.
         */
        limparCampos();
    }

    private void popularCampos() {
        Despesa despesa = new Despesa();

        String codigoDespesaSTR = String.valueOf(tblListagemDespesa.getValueAt(tblListagemDespesa.getSelectedRow(), 0));
        long codigoDespesa = Long.parseLong(codigoDespesaSTR);
        despesa = dao.DaoDespesa.popularDespesa(codigoDespesa);
        
        boolean despesaQuitada = despesa.getQuitadaBoolean();
        
        if (despesaQuitada) {
            rbtQuitadaSim.setSelected(true);
            rbtQuitadaNao.setSelected(false);
        } else {
            rbtQuitadaSim.setSelected(false);
            rbtQuitadaNao.setSelected(true);
        }
        
        cmbTipoDespesa.setSelectedItem((String) despesa.getTipoDespesas());
        txtfDataVencimento.setText(despesa.getDataDespesa());
        txtfValorDespesa.setText(despesa.getValorDespesaSTR());
        txaDescricaoDespesa.setText(despesa.getDescricaoDespesa());
        PK_REF = despesa.getCodigoDespesa();

    }

    private void limiteDigitosPesquisa(String filtro) {
        /*
Código
Tipo de Despesa
Descrição Detalhada
Valor
Quitada?
Data de Vencimento
Data de Vencimento Entre/Até
        */
        
        
        switch (filtro) {
            case "Código":
                lblDigiteODado.setText("Digite o cód. da despesa:");
                txtPesquisa.setText(control.Texto.maxLenghtCodigoDespesa(txtPesquisa.getText()));
                modoPesquisaNormal();
                txtPesquisa.requestFocus();
                break;
            case "Tipo de Despesa":
                lblDigiteODado.setText("Digite o tipo:");
                txtPesquisa.setText(control.Texto.maxLenghtTipoDespesa(txtPesquisa.getText()));
                modoPesquisaNormal();
                txtPesquisa.requestFocus();
                break;
            case "Descrição Detalhada":
                lblDigiteODado.setText("Digite a descrição:");
                txtPesquisa.setText(control.Texto.maxLenghtDescricaoDespesa(txtPesquisa.getText()));
                modoPesquisaNormal();
                txtPesquisa.requestFocus();
                break;
            case "Valor":
                lblDigiteODado.setText("Digite o valor:");
                txtPesquisa.setText(control.Texto.maxLenghtValorDespesa(txtPesquisa.getText()));
                modoPesquisaNormal();
                txtPesquisa.requestFocus();
                break;
            case "Quitada?":
                lblDigiteODado.setText("Digite Sim ou Não:");
                txtPesquisa.setText(control.Texto.maxLenghtDespesaQuitada(txtPesquisa.getText()));
                modoPesquisaNormal();
                txtPesquisa.requestFocus();
                break;            
            case "Data de Vencimento":
                lblDigiteODado.setText("Digite a data de vencimento:");
                modoPesquisaData(false);
                txtfDataDe.requestFocus();
                break;
            case "Data de Vencimento Entre/Até":
                lblDigiteODado.setText("Digite a data Inicial:");
                modoPesquisaData(true);
                txtfDataDe.requestFocus();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Erro ao definir limite de caracteres do campo de pesquisa.",
                        "Erro - limite de dígitos dinâmico", 0);
                break;
        }

    }

    private void modoPesquisaData(boolean fixaOuEntre) {
        boolean dataFixa = false;
        boolean dataEntreAte = true;

        if (fixaOuEntre == dataEntreAte) {
            txtPesquisa.setVisible(false);
            txtfDataDe.setVisible(true);
            txtfDataAte.setVisible(true);
            lblDataAte.setVisible(true);
            btnPesquisar.setVisible(true);
        } else if (fixaOuEntre == dataFixa) {
            txtPesquisa.setVisible(false);
            txtfDataDe.setVisible(true);
            txtfDataAte.setVisible(false);
            lblDataAte.setVisible(false);
            btnPesquisar.setVisible(true);
        }
    }

    private void deletarRegistro() {
        int opcao;
        String codigoDespesaSTR = String.valueOf(tblListagemDespesa.getValueAt(tblListagemDespesa.getSelectedRow(), 0));
        long codigoDespesa = Long.parseLong(codigoDespesaSTR);
        opcao = JOptionPane.showConfirmDialog(this, "Atenção! Todos os registros relacionados a despesa de código "
                + codigoDespesa + " serão permanentemente removidos.\n\nDeseja realmente excluir o registro?",
                "Confirmação de exclusão",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == 0) {          
            dao.DaoDespesa.deletarDespesa(codigoDespesa);
            atualizarTabela(ultimoTipoPesquisa);
            limparCampos();
        }
    }

    private void removerTodosRegistros() {
        int opcao;
        opcao = JOptionPane.showConfirmDialog(this, "Deseja REALMENTE remover todas as despesas do banco de dados?\n\n",
                "Alerta - remoção de todos os registros", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == 0) {
            opcao = JOptionPane.showConfirmDialog(this, "Essa operação tem grandes chances de falhar, devido a existência\n"
                    + "de restrições de chaves estrangeiras no banco de dados.\n\n"
                    + "Deseja REALMENTE tentar excluir todos os registros do banco de dados?\n\n"
                    + "Caso a operação suceda, todos os dados serão permanentemente excluídos.\n"
                    + "Caso ela falhe, talvez alguns registros possam ter sidos excluidos, e outros não."
                    + "\n\n"
                    + "Deseja prosseguir?",
                    "Alerta - remoção de todos os registros", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcao == 0) {
                boolean exclusaoSucedida;
                exclusaoSucedida = dao.DaoDespesa.deletarTodasDespesas();
                if (exclusaoSucedida) {
                    atualizarTabela(ultimoTipoPesquisa);
                }
            }
        }
    }

    private void alterarRegistro() {
        if (validarCampos()) {
            Despesa despesa = new Despesa();
            
            despesa.setTipoDespesas((String) cmbTipoDespesa.getSelectedItem());
            despesa.setDataDespesa(txtfDataVencimento.getText());
            despesa.setValorDespesa(txtfValorDespesa.getText());
            despesa.setQuitada(rbtQuitadaSim.isSelected());
            despesa.setDescricaoDespesa(txaDescricaoDespesa.getText());
            
            boolean alteracaoSucedida;
            alteracaoSucedida = dao.DaoDespesa.alterarDespesa(despesa, PK_REF);

            if (alteracaoSucedida) {
                atualizarTabela(ultimoTipoPesquisa);
                limparCampos();
            }
        }
    }
    
    private boolean validarCampos() {
        boolean selectionEmpty = tblListagemDespesa.getSelectionModel().isSelectionEmpty();
        if (selectionEmpty){
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado da tabela.\n\n"
                    + "Pesquise por algum registro e clique em alguma linha da tabela.", "Erro - Não há registro selecionado", 0);
            return false;
        } else if (txtfDataVencimento.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data de vencimento em branco. Digite uma data válida.", "Erro - DAta de Vencimento Inválida", 0);
            txtfDataVencimento.requestFocus();
            return false;
        } else if (txtfValorDespesa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Valor da despesa em branco. Digite um valor para a despesa diferente de zero.", "Erro - Valor da Despesa Inválida", 0);
            txtfValorDespesa.requestFocus();
            return false;
        } else if (txtfValorDespesa.getText().equals("0,00")) {
            JOptionPane.showMessageDialog(null, "Valor da despesa zerada. Digite um valor para a despesa diferente de zero.", "Erro - Valor da Despesa Inválida", 0);
            txtfValorDespesa.requestFocus();
            return false;
        } else if (rbtQuitadaNao.isSelected() == false && rbtQuitadaSim.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Estado da quitação da despesa não selecionada", "Erro - Quitação da Despesa Inválida", 0);
            rbtQuitadaNao.requestFocus();
            return false;
        } else if (txaDescricaoDespesa.getText().isEmpty()) {
            txaDescricaoDespesa.setText("Sem descrição.");
            return true;
        } else {
            return true;
        }
    }

    private void definirNivelAcesso(int nvlAdm) {
        if (nvlAdm == 0) {
            btnDeletarTodosRegistros.setEnabled(false);
            btnAlterar.setEnabled(false);
            btnDeletar.setEnabled(false);
            btnCadastrarDespesa.setEnabled(false);
            cmbTipoDespesa.setEnabled(false);
            txtfDataVencimento.setEnabled(false);
            txtfValorDespesa.setEnabled(false);
            rbtQuitadaNao.setEnabled(false);
            rbtQuitadaSim.setEnabled(false);
            txaDescricaoDespesa.setEnabled(false);
        }
    }
}
