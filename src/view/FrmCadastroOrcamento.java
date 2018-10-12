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
public class FrmCadastroOrcamento extends javax.swing.JFrame {

    /**
     * Creates new form FrmCadastroOrcamento
     */
    public FrmCadastroOrcamento(int nvlAdm) {
        initComponents();
        iniciarTabela();
        if (nvlAdm == 0) {
            btnCadOrcamento.setEnabled(false);
        }
    }

    
    
    public FrmCadastroOrcamento(int codigoServico, boolean flag) {
        
        initComponents();
        iniciarTabela();
        txtCodServico.setText("" + codigoServico);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btnCadOrcamento = new javax.swing.JButton();
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
        txtCodServico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrcamento = new javax.swing.JTable();
        btnListarOrcamentos = new javax.swing.JButton();
        btnExcluirTodasPecas = new javax.swing.JButton();
        btnRemoveLinhaPeca = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        txtMaoDeObra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Orçamento");
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel3.setText("Código do serviço:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 100, 190, 25);

        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel8.setText("Mão de obra total:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 140, 190, 25);

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        jLabel9.setText("Valor Total:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 450, 190, 25);

        txtValorTotal.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtValorTotal.setFocusable(false);
        txtValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorTotal);
        txtValorTotal.setBounds(220, 450, 150, 30);

        btnCadOrcamento.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnCadOrcamento.setText("Vincular Orçamento");
        btnCadOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadOrcamentoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadOrcamento);
        btnCadOrcamento.setBounds(270, 510, 210, 80);

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

        btnAdicionarPeca.setText("Adicionar peça ao orçamento");
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

        txtCodServico.setEditable(false);
        txtCodServico.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtCodServico.setFocusable(false);
        txtCodServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodServicoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodServico);
        txtCodServico.setBounds(220, 100, 150, 30);

        tblOrcamento.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblOrcamento);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(520, 70, 500, 540);

        btnListarOrcamentos.setText("Listar Orçamentos");
        getContentPane().add(btnListarOrcamentos);
        btnListarOrcamentos.setBounds(20, 70, 130, 30);

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
        btnFechar.setBounds(1060, 540, 65, 23);

        txtMaoDeObra.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        txtMaoDeObra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaoDeObraFocusLost(evt);
            }
        });
        txtMaoDeObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaoDeObraActionPerformed(evt);
            }
        });
        txtMaoDeObra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaoDeObraKeyReleased(evt);
            }
        });
        getContentPane().add(txtMaoDeObra);
        txtMaoDeObra.setBounds(220, 140, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodServicoActionPerformed

    private void txtCodPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodPecaActionPerformed

    private void txtNomePecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePecaActionPerformed

    private void txtValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorTotalActionPerformed

    private void btnCadOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadOrcamentoActionPerformed
        if (valorTotal>0){
            Orcamento o = new Orcamento();
            s.setCodigoServico(Integer.parseInt(txtCodServico.getText()));
            o.setServico(s);
            o.setMaoDeObra(Double.parseDouble(txtMaoDeObra.getText()));
            ArrayList<VendaPeca> lista = new ArrayList<>();
            for(int i = 0; i < tblOrcamento.getRowCount(); i++){
                Peca p = new Peca();
                p.setCodigoPeca((String)tblOrcamento.getValueAt(i, 0));
                p.setNomePeca((String) tblOrcamento.getValueAt(i, 1));
                p.setCategoriaPeca((String) tblOrcamento.getValueAt(i, 2));
                p.setValorUnitario((String) tblOrcamento.getValueAt(i, 3));
                p.setQuantidadePeca(((String) tblOrcamento.getValueAt(i, 4)));
                VendaPeca vp = new VendaPeca();
                vp.setPeca(p);
                vp.setQuantidadeVendida(p.getQuantidadePeca());
                lista.add(vp);
            }
            o.setPecas(lista);
            o.setValorTotal(0.0);
            for (int i = 0; i < lista.size(); i++){
                o.setValorTotal(o.getValorTotal() + (lista.get(i).getPeca().getValorUnitario() * lista.get(i).getQuantidadeVendida()));
            }
            o.setValorTotal(o.getValorTotal() + o.getMaoDeObra());
            try {
                if (tblOrcamento.getRowCount() !=0) {
                    DaoOrcamento.criarOrcamento(o, true, flagCriarAlterar); 
                } else {
                    DaoOrcamento.criarOrcamento(o, false, flagCriarAlterar); 
                }
               
               
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadastroOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmCadastroOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Insira um valor de mão de obra e/ou peça.");
        }
    }//GEN-LAST:event_btnCadOrcamentoActionPerformed

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
                flagPeca = DaoPeca.existePeca((txtCodPeca.getText()));
                if (flagPeca) {
                    lblPecaExiste.setText("Peça encontrada.");
                    popularPeca((txtCodPeca.getText()));
                    btnAdicionarPeca.setEnabled(true);

                } else {
                    lblPecaExiste.setText("Peça não encontrada.");
                    limparPeca();
                    btnAdicionarPeca.setEnabled(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadastroOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                limparPeca();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmCadastroOrcamento.class.getName()).log(Level.SEVERE, null, ex);
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
            DefaultTableModel model = (DefaultTableModel) tblOrcamento.getModel();
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
                tblOrcamento.setModel(model);
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
        DefaultTableModel model = (DefaultTableModel) tblOrcamento.getModel();
        if (model.getRowCount() != 0) {
            model.removeRow(tblOrcamento.getSelectedRow());
            tblOrcamento.setModel(model);
        }
        atualizarValorTotal();
    }//GEN-LAST:event_btnRemoveLinhaPecaActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtMaoDeObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaoDeObraActionPerformed

    }//GEN-LAST:event_txtMaoDeObraActionPerformed

    private void txtMaoDeObraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaoDeObraFocusLost
        try {
            valorMaoDeObra = Double.parseDouble(txtMaoDeObra.getText());
        } catch (NumberFormatException nfe) {
            txtMaoDeObra.setText("0");
            valorMaoDeObra = 0;
        }
        atualizarValorTotal();
    }//GEN-LAST:event_txtMaoDeObraFocusLost

    private void txtMaoDeObraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaoDeObraKeyReleased
        txtMaoDeObra.setText(TextSize.maxLenghtMaoDeObra(txtMaoDeObra.getText()));
    }//GEN-LAST:event_txtMaoDeObraKeyReleased

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
            java.util.logging.Logger.getLogger(FrmCadastroOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroOrcamento(control.SynchroSoft.getNvlAdm()).setVisible(true);
            }
        });
    }

    public void popularPeca(String codigo) throws SQLException, ClassNotFoundException {
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
            tblOrcamento.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
        } catch (Exception ex) {
            System.out.println("Erro ao reiniciar tabela.\n\n" + ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarPeca;
    private javax.swing.JButton btnCadOrcamento;
    private javax.swing.JButton btnExcluirTodasPecas;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnListarOrcamentos;
    private javax.swing.JButton btnListarPeca;
    private javax.swing.JButton btnRemoveLinhaPeca;
    private javax.swing.ButtonGroup btngPeca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPecaExiste;
    private javax.swing.JPanel pnlPeca;
    private javax.swing.JTable tblOrcamento;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCodPeca;
    private javax.swing.JTextField txtCodServico;
    private javax.swing.JTextField txtMaoDeObra;
    private javax.swing.JTextField txtNomePeca;
    private javax.swing.JTextField txtQtdEstoque;
    private javax.swing.JTextField txtQuantidadePeca;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    private javax.swing.JTextField txtValorXQtd;
    // End of variables declaration//GEN-END:variables

    private void atualizarValorTotal() {
        
        valorPecas = 0;
        for (int i = 0; i < tblOrcamento.getRowCount(); i++){
            valorPecas += Double.parseDouble((String) tblOrcamento.getValueAt(i, 5));
        }
        
        valorTotal = valorPecas + valorMaoDeObra;
        txtValorTotal.setText(""+valorTotal);
        
        
    }
}
