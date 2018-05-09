/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoEndereco;
import dao.DaoFuncionario;
import dao.DaoPeca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Funcionario;
import model.Peca;

/**
 *
 * @author Administrator
 */
public class FrmListagemFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form FrmListagemPeca
     */
    public FrmListagemFuncionario() {
        initComponents();
        atualizarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagemFuncionario = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnAtualizarTabela = new javax.swing.JButton();
        btnTelaCadastro = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        lblPesquisar = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();
        lblDescrever = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnMenuPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        tblListagemFuncionario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListagemFuncionario);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(14, 119, 1090, 402);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(990, 550, 130, 50);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(301, 552, 210, 40);

        btnAtualizarTabela.setText("AtualizarTabela");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizarTabela);
        btnAtualizarTabela.setBounds(60, 550, 190, 40);

        btnTelaCadastro.setText("Tela Cadastro");
        btnTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnTelaCadastro);
        btnTelaCadastro.setBounds(770, 550, 160, 50);

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(545, 552, 170, 40);

        lblPesquisar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar por: ");
        getContentPane().add(lblPesquisar);
        lblPesquisar.setBounds(230, 50, 160, 40);

        cmbFiltro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Código", "CPF", "CEP", "Sexo", "Telefone", "Celular", "Salário", "Cargo", "Data Admissão", "Data Demissão", "Horas Trabalhadas", "Nível Admnistrativo", "Número Endereço" }));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        getContentPane().add(cmbFiltro);
        cmbFiltro.setBounds(360, 60, 107, 31);

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
        txtPesquisa.setBounds(640, 50, 221, 40);

        lblDescrever.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDescrever.setText("Descrição:");
        getContentPane().add(lblDescrever);
        lblDescrever.setBounds(520, 50, 83, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 650);

        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuPrincipal);
        btnMenuPrincipal.setBounds(949, 119, 161, 239);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    DaoFuncionario df = new DaoFuncionario();

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            tblListagemFuncionario.getCellEditor().stopCellEditing();
        } catch (Exception ex) {

        }
        try {
            df.alterarFuncionario(tblListagemFuncionario);
        } catch (SQLException ex) {
            Logger.getLogger(FrmListagemFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void btnTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaCadastroActionPerformed
        FrmCadastroFuncionario telaCadastroFunc = new FrmCadastroFuncionario();
        telaCadastroFunc.setVisible(true);
    }//GEN-LAST:event_btnTelaCadastroActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Funcionario func = new Funcionario();
        String aux;
        aux = (String) tblListagemFuncionario.getValueAt(tblListagemFuncionario.getSelectedRow(), 0);
        func.setCodigoFuncionario(Integer.parseInt(aux));
        
        try {
            df.deletarFuncionario(func.getCodigoFuncionario());
            atualizarTabela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed

    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyTyped

    }//GEN-LAST:event_txtPesquisaKeyTyped

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // Chamando método de listagem com filtro, se txt preenchido
        try {
            //criando variável de controle
            int controle = 0;

            //Se campo de texto não estiver vazio
            if (txtPesquisa.getText().trim() != "") {
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

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        FrmPrincipal princ = new FrmPrincipal();
        princ.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

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
            java.util.logging.Logger.getLogger(FrmListagemFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListagemFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListagemFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListagemFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListagemFuncionario().setVisible(true);
            }
        });
    }

    //Criando método de preenchimento/atualização de tabela com dados do banco
    private void atualizarTabela() {
        ArrayList<Funcionario> lista = new ArrayList<>();
        lista = DaoFuncionario.listarFuncionario();
        String[] nomeColunas = {"Código", "CEP", "Nome", "CPF", "Sexo", "Telefone", "Celular", "Número", 
            "Salário", "Cargo", "Admissão", "Demissão", "Horas Trabalhadas", "Nível Administrativo", "PK_REF" };
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 15) {
                        return false;
                    }
                    return true;
                }
            };
            tblListagemFuncionario.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
            Object rowData[] = new Object[15];
            for (int i = 0; i < lista.size(); i++) {
                rowData[0] = Integer.toString(lista.get(i).getCodigoFuncionario());
                rowData[1] = lista.get(i).getPessoa().getEndereco().getCep();
                rowData[2] = lista.get(i).getPessoa().getNome();
                rowData[3] = lista.get(i).getFisica().getCpf();
                if (lista.get(i).getFisica().getSexo() == 0) {
                    rowData[4] = "Masculino";
                } else {
                    rowData[4] = "Feminino";
                }
                
                rowData[5] = Long.toString(lista.get(i).getPessoa().getTelefone());
                rowData[6] = Long.toString(lista.get(i).getFisica().getCelular());
                rowData[7] = lista.get(i).getPessoa().getComplementoLogradouro();
                rowData[8] = Float.toString(lista.get(i).getSalario());
                rowData[9] = lista.get(i).getCargo();
                rowData[10] = lista.get(i).getDataContrato().toString();
                rowData[11] = lista.get(i).getDataDemissao().toString();
                rowData[12] = Integer.toString(lista.get(i).getHorasTrabalhadas());
                if (lista.get(i).getNivelAdministrativo()== 0) {
                    rowData[13] = "Visualização";
                } else {
                    rowData[13] = "Administrador";
                }
                rowData[14] = Integer.toString(lista.get(i).getCodigoFuncionario());
                
                model.addRow(rowData);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao popular tabela.\n\n" + ex.getMessage());
        }
        
        tblListagemFuncionario.getColumnModel().getColumn(14).setMinWidth(0);
        tblListagemFuncionario.getColumnModel().getColumn(14).setPreferredWidth(0);
        tblListagemFuncionario.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    private void atualizarTabelaFiltrada() {
        ArrayList<Funcionario> lista = new ArrayList<>();
        lista = DaoFuncionario.listarFuncionarioFiltrada((String) cmbFiltro.getSelectedItem(), txtPesquisa.getText().toLowerCase().trim()); //Filtrando dados que aparecem na pesquisa
        String[] nomeColunas = {"Código", "CEP", "Nome", "CPF", "Sexo", "Telefone", "Celular", "Número", 
            "Salário", "Cargo", "Admissão", "Demissão", "Horas Trabalhadas", "Nível Administrativo", "PK_REF" };
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 15) {
                        return false;
                    }
                    return true;
                }
            };
            tblListagemFuncionario.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
            Object rowData[] = new Object[15];
            for (int i = 0; i < lista.size(); i++) {
                rowData[0] = Integer.toString(lista.get(i).getCodigoFuncionario());
                rowData[1] = lista.get(i).getPessoa().getEndereco().getCep();
                rowData[2] = lista.get(i).getPessoa().getNome();
                rowData[3] = lista.get(i).getFisica().getCpf();
                if (lista.get(i).getFisica().getSexo() == 0) {
                    rowData[4] = "Masculino";
                } else {
                    rowData[4] = "Feminino";
                }
                
                rowData[5] = Long.toString(lista.get(i).getPessoa().getTelefone());
                rowData[6] = Long.toString(lista.get(i).getFisica().getCelular());
                rowData[7] = lista.get(i).getPessoa().getComplementoLogradouro();
                rowData[8] = Float.toString(lista.get(i).getSalario());
                rowData[9] = lista.get(i).getCargo();
                rowData[10] = lista.get(i).getDataContrato().toString();
                rowData[11] = lista.get(i).getDataDemissao().toString();
                rowData[12] = Integer.toString(lista.get(i).getHorasTrabalhadas());
                if (lista.get(i).getNivelAdministrativo()== 0) {
                    rowData[13] = "Visualização";
                } else {
                    rowData[13] = "Administrador";
                }
                rowData[14] = Integer.toString(lista.get(i).getCodigoFuncionario());
                
                model.addRow(rowData);

            }

        } catch (Exception ex) {
            System.out.println("Erro ao popular tabela.\n\n" + ex.getMessage());
        }
        
        tblListagemFuncionario.getColumnModel().getColumn(14).setMinWidth(0);
        tblListagemFuncionario.getColumnModel().getColumn(14).setPreferredWidth(0);
        tblListagemFuncionario.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnTelaCadastro;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescrever;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JTable tblListagemFuncionario;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
