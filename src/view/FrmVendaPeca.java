/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.TextSize;
import dao.DaoOrcamento;
import dao.DaoPeca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Orcamento;
import model.Peca;
import model.Servico;
import model.VendaPeca;

/**
 *
 * @author Luiz
 */
public class FrmVendaPeca extends javax.swing.JFrame {

    /**
     * Creates new form FrmCadastroOrcamento
     */
    public FrmVendaPeca(int nvlAdm) {
        initComponents();
        iniciarTabela();
        if (nvlAdm == 0) {
            btnVender.setEnabled(false);
        }
    }

    
    
    public FrmVendaPeca(int codigoServico, boolean flag) {
        
        initComponents();
        iniciarTabela();
        s.setCodigoServico(codigoServico);
        flagCriarAlterar = flag;
    }

    boolean flagCriarAlterar;
    Servico s = new Servico();
    boolean flagPeca;
    int limitePeca = 0;
    double valorTotal;
    double valorMaoDeObra;
    double valorPecas;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngPeca = new javax.swing.ButtonGroup();
        jLabel9 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btnVender = new javax.swing.JButton();
        pnlPeca = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCodPeca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNomePeca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtQuantidadePeca = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtQtdEstoque = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtValorXQtd = new javax.swing.JTextField();
        btnAdicionarPeca = new javax.swing.JButton();
        btnListarPeca = new javax.swing.JButton();
        lblPecaExiste = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();
        btnExcluirTodasPecas = new javax.swing.JButton();
        btnRemoveLinhaPeca = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda de Peças");
        setMinimumSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel9.setText("Valor Total:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(670, 450, 190, 25);

        txtValorTotal.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtValorTotal.setFocusable(false);
        txtValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorTotal);
        txtValorTotal.setBounds(870, 450, 150, 30);

        btnVender.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        getContentPane().add(btnVender);
        btnVender.setBounds(720, 510, 210, 80);

        pnlPeca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPeca.setOpaque(false);
        pnlPeca.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Quantidade em Estoque:");
        pnlPeca.add(jLabel5);
        jLabel5.setBounds(210, 90, 156, 20);

        txtCodPeca.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txtCodPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodPecaActionPerformed(evt);
            }
        });
        txtCodPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodPecaKeyReleased(evt);
            }
        });
        pnlPeca.add(txtCodPeca);
        txtCodPeca.setBounds(120, 10, 120, 26);

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Nome:");
        pnlPeca.add(jLabel6);
        jLabel6.setBounds(10, 60, 42, 20);

        txtNomePeca.setEditable(false);
        txtNomePeca.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txtNomePeca.setFocusable(false);
        txtNomePeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePecaActionPerformed(evt);
            }
        });
        pnlPeca.add(txtNomePeca);
        txtNomePeca.setBounds(60, 60, 400, 26);

        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Categoria:");
        pnlPeca.add(jLabel7);
        jLabel7.setBounds(10, 130, 63, 20);

        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Quantidade:");
        pnlPeca.add(jLabel10);
        jLabel10.setBounds(260, 10, 76, 20);

        txtQuantidadePeca.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
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
        pnlPeca.add(txtQuantidadePeca);
        txtQuantidadePeca.setBounds(350, 10, 100, 26);

        txtCategoria.setEditable(false);
        txtCategoria.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txtCategoria.setFocusable(false);
        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });
        pnlPeca.add(txtCategoria);
        txtCategoria.setBounds(80, 130, 180, 30);

        jLabel12.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Código da Peça: ");
        pnlPeca.add(jLabel12);
        jLabel12.setBounds(10, 10, 107, 20);

        txtQtdEstoque.setEditable(false);
        txtQtdEstoque.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txtQtdEstoque.setFocusable(false);
        txtQtdEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdEstoqueActionPerformed(evt);
            }
        });
        pnlPeca.add(txtQtdEstoque);
        txtQtdEstoque.setBounds(380, 90, 80, 26);

        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Valor Unitário:");
        pnlPeca.add(jLabel13);
        jLabel13.setBounds(10, 90, 89, 20);

        txtValorUnitario.setEditable(false);
        txtValorUnitario.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txtValorUnitario.setFocusable(false);
        txtValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorUnitarioActionPerformed(evt);
            }
        });
        pnlPeca.add(txtValorUnitario);
        txtValorUnitario.setBounds(120, 90, 80, 26);

        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel14.setText("Valor un. x qtd");
        pnlPeca.add(jLabel14);
        jLabel14.setBounds(280, 130, 130, 20);

        txtValorXQtd.setEditable(false);
        txtValorXQtd.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        txtValorXQtd.setFocusable(false);
        txtValorXQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorXQtdActionPerformed(evt);
            }
        });
        pnlPeca.add(txtValorXQtd);
        txtValorXQtd.setBounds(380, 130, 80, 26);

        btnAdicionarPeca.setText("Adicionar peça a lista de venda");
        btnAdicionarPeca.setEnabled(false);
        btnAdicionarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPecaActionPerformed(evt);
            }
        });
        pnlPeca.add(btnAdicionarPeca);
        btnAdicionarPeca.setBounds(130, 170, 260, 40);

        btnListarPeca.setText("Listar Peças");
        btnListarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPecaActionPerformed(evt);
            }
        });
        pnlPeca.add(btnListarPeca);
        btnListarPeca.setBounds(190, 40, 130, 20);

        lblPecaExiste.setText("Peça não encontrada.");
        pnlPeca.add(lblPecaExiste);
        lblPecaExiste.setBounds(30, 40, 190, 14);

        getContentPane().add(pnlPeca);
        pnlPeca.setBounds(20, 210, 490, 220);
        pnlPeca.getAccessibleContext().setAccessibleName("Venda de peça");

        tblPecas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPecas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(520, 70, 500, 360);

        btnExcluirTodasPecas.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        btnExcluirTodasPecas.setText("Excluir todas");
        btnExcluirTodasPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTodasPecasActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluirTodasPecas);
        btnExcluirTodasPecas.setBounds(1040, 150, 100, 20);

        btnRemoveLinhaPeca.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        btnRemoveLinhaPeca.setText("Excluir Peça");
        btnRemoveLinhaPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveLinhaPecaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemoveLinhaPeca);
        btnRemoveLinhaPeca.setBounds(1040, 110, 100, 20);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(1060, 540, 67, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodPecaActionPerformed

    private void txtNomePecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePecaActionPerformed

    private void txtValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorTotalActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        if (valorTotal>0){
            
            ArrayList<VendaPeca> lista = new ArrayList<>();
            for(int i = 0; i < tblPecas.getRowCount(); i++){
                Peca p = new Peca();
                p.setCodigoPeca(Integer.parseInt((String)tblPecas.getValueAt(i, 0)));
                p.setNomePeca((String) tblPecas.getValueAt(i, 1));
                p.setCategoriaPeca((String) tblPecas.getValueAt(i, 2));
                p.setValorUnitario((String) tblPecas.getValueAt(i, 3));
                p.setQuantidadePeca(Integer.parseInt((String) tblPecas.getValueAt(i, 4)));
                VendaPeca vp = new VendaPeca();
                vp.setPeca(p);
                vp.setQuantidadeVendida(p.getQuantidadePeca());
                lista.add(vp);
            }
            
            if (tblPecas.getRowCount() !=0) {
                DaoPeca.atualizarEstoque(lista);
                iniciarTabela();
                txtValorTotal.setText("0");
                txtCodPeca.requestFocus();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione ao menos uma peça para vender.");
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione ao menos uma peça para vender.");
        }
    }//GEN-LAST:event_btnVenderActionPerformed

    private void txtQuantidadePecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadePecaActionPerformed

    }//GEN-LAST:event_txtQuantidadePecaActionPerformed

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void txtQtdEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdEstoqueActionPerformed

    private void txtValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorUnitarioActionPerformed

    private void txtValorXQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorXQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorXQtdActionPerformed

    private void btnListarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPecaActionPerformed
        control.Janelas.abrirListagemProduto();
    }//GEN-LAST:event_btnListarPecaActionPerformed

    private void txtCodPecaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodPecaKeyReleased
        txtCodPeca.setText(TextSize.maxLenghtCodigoPeca(txtCodPeca.getText()));
        if (txtCodPeca.getText().equals("")) {
            limparPeca();
            lblPecaExiste.setText("Digite um código de peça.");
            btnAdicionarPeca.setEnabled(false);
        } else {
            try {
                flagPeca = DaoPeca.existePeca(Integer.parseInt(txtCodPeca.getText()));
                if (flagPeca) {
                    lblPecaExiste.setText("Peça encontrada.");
                    popularPeca(Integer.parseInt(txtCodPeca.getText()));
                    btnAdicionarPeca.setEnabled(true);

                } else {
                    lblPecaExiste.setText("Peça não encontrada.");
                    limparPeca();
                    btnAdicionarPeca.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmVendaPeca.class.getName()).log(Level.SEVERE, null, ex);
                limparPeca();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmVendaPeca.class.getName()).log(Level.SEVERE, null, ex);
                limparPeca();
            } catch (NumberFormatException nfe) {
                lblPecaExiste.setText("Peça não encontrada.");
                limparPeca();
                btnAdicionarPeca.setEnabled(false);
            }
        }
    }//GEN-LAST:event_txtCodPecaKeyReleased

    private void txtQuantidadePecaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadePecaKeyReleased
        txtQuantidadePeca.setText(TextSize.maxLenghtQuantidadePeca(txtQuantidadePeca.getText()));
        int qtd;
        float produto;
        float vlunit;
        try {
            qtd = Integer.parseInt(txtQuantidadePeca.getText());
            if (qtd > limitePeca) {
                txtQuantidadePeca.setText("" + limitePeca);
                qtd = limitePeca;
                vlunit = Float.parseFloat(txtValorUnitario.getText());
                produto = qtd * vlunit;
                txtValorXQtd.setText("" + produto);
            } else {
                vlunit = Float.parseFloat(txtValorUnitario.getText());
                produto = qtd * vlunit;
                txtValorXQtd.setText("" + produto);
            }
        } catch (NumberFormatException ex) {
            txtQuantidadePeca.setText("");
        }
    }//GEN-LAST:event_txtQuantidadePecaKeyReleased

    private void btnAdicionarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPecaActionPerformed
        boolean flag = true;
        int flagQtd = Integer.parseInt(txtQuantidadePeca.getText());
        if (flagQtd <= 0 || txtQtdEstoque.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite uma quantidade válida.");
        } else {
            DefaultTableModel model = (DefaultTableModel) tblPecas.getModel();
            Object rowData[] = new Object[6];
            rowData[0] = (String) txtCodPeca.getText();
            rowData[1] = (String) txtNomePeca.getText();
            rowData[2] = (String) txtCategoria.getText();
            rowData[3] = (String) txtValorUnitario.getText();
            rowData[4] = (String) txtQuantidadePeca.getText();
            rowData[5] = (String) txtValorXQtd.getText();

            String aux = (String) rowData[0];
            String aux2 = "";
            for (int i = 0; i < model.getRowCount(); i++) {
                aux2 = (String) model.getValueAt(i, 0);
                if (aux.equals(aux2)) {
                    flag = false;
                }
            }
            if (flag) {
                model.addRow(rowData);
                tblPecas.setModel(model);
                txtCodPeca.setText("");
                limparPeca();
                txtCodPeca.requestFocus();
            }
        }
        
       
        
       atualizarValorTotal();
    }//GEN-LAST:event_btnAdicionarPecaActionPerformed

    private void btnExcluirTodasPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTodasPecasActionPerformed
        iniciarTabela();
        atualizarValorTotal();
    }//GEN-LAST:event_btnExcluirTodasPecasActionPerformed

    private void btnRemoveLinhaPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveLinhaPecaActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblPecas.getModel();
        if (model.getRowCount() != 0) {
            model.removeRow(tblPecas.getSelectedRow());
            tblPecas.setModel(model);
        }
        atualizarValorTotal();
    }//GEN-LAST:event_btnRemoveLinhaPecaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVendaPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVendaPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVendaPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVendaPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVendaPeca(control.SynchroSoft.getNvlAdm()).setVisible(true);
            }
        });
    }

    public void popularPeca(int codigo) throws SQLException, ClassNotFoundException {
        Peca p = new Peca();
        p = DaoPeca.popularPeca(codigo);
        limitePeca = p.getQuantidadePeca();
        txtNomePeca.setText("" + p.getNomePeca());
        txtValorUnitario.setText("" + p.getValorUnitario());
        txtQtdEstoque.setText("" + p.getQuantidadePeca());
        txtCategoria.setText("" + p.getCategoriaPeca());
    }

    public void limparPeca() {
        txtQuantidadePeca.setText("0");
        txtNomePeca.setText("");
        txtValorUnitario.setText("0.00");
        txtQtdEstoque.setText("0");
        txtCategoria.setText("");
        txtValorXQtd.setText("");
        limitePeca = 0;

    }

    public void iniciarTabela() {
        String[] nomeColunas = {"Código", "Nome", "Categoria", "Valor Unitário", "Quantidade", "Valor Sub Total"};
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {

                    return false;
                }
            };
            tblPecas.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
        } catch (Exception ex) {
            System.out.println("Erro ao reiniciar tabela.\n\n" + ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarPeca;
    private javax.swing.JButton btnExcluirTodasPecas;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnListarPeca;
    private javax.swing.JButton btnRemoveLinhaPeca;
    private javax.swing.JButton btnVender;
    private javax.swing.ButtonGroup btngPeca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPecaExiste;
    private javax.swing.JPanel pnlPeca;
    private javax.swing.JTable tblPecas;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodPeca;
    private javax.swing.JTextField txtNomePeca;
    private javax.swing.JTextField txtQtdEstoque;
    private javax.swing.JTextField txtQuantidadePeca;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    private javax.swing.JTextField txtValorXQtd;
    // End of variables declaration//GEN-END:variables

    private void atualizarValorTotal() {
        
        valorPecas = 0;
        for (int i = 0; i < tblPecas.getRowCount(); i++){
            valorPecas += Double.parseDouble((String) tblPecas.getValueAt(i, 5));
        }
        
        valorTotal = valorPecas + valorMaoDeObra;
        txtValorTotal.setText(""+valorTotal);
        
        
    }
}
