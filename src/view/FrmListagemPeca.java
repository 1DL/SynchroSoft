/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoPeca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Peca;

/**
 *
 * @author Administrator
 */
public class FrmListagemPeca extends javax.swing.JFrame {

    /**
     * Creates new form FrmListagemPeca
     */
    public FrmListagemPeca() {
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
        tblListagemPeca = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();
        btnAtualizarTabela = new javax.swing.JButton();
        btnTelaCadastro = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1152, 648));

        tblListagemPeca.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListagemPeca);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnAtualizarTabela.setText("AtualizarTabela");
        btnAtualizarTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabelaActionPerformed(evt);
            }
        });

        btnTelaCadastro.setText("Tela Cadastro");
        btnTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaCadastroActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(btnAtualizarTabela)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)
                        .addGap(34, 34, 34)
                        .addComponent(btnDeletar)
                        .addGap(32, 32, 32)
                        .addComponent(btnTelaCadastro)))
                .addGap(0, 363, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAtualizarTabela)
                        .addComponent(btnAlterar)
                        .addComponent(btnDeletar))
                    .addComponent(btnTelaCadastro))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    DaoPeca dp = new DaoPeca();
    
    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        /*ArrayList<Peca> pecaAlterar = new ArrayList<>();
        JOptionPane.showMessageDialog(null,""+tblListagemPeca.getRowCount());
        JOptionPane.showMessageDialog(null,""+tblListagemPeca.getColumnCount());
        
        
        
        for (int i = 0; i <= tblListagemPeca.getRowCount();i++){
            
        }*/
        try{
        tblListagemPeca.getCellEditor().stopCellEditing();
        } catch (Exception ex) {
            
        }
        try{
            dp.alterarPeca(tblListagemPeca);
        } catch (SQLException ex) {
            Logger.getLogger(FrmListagemPeca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemPeca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnAtualizarTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabelaActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarTabelaActionPerformed

    private void btnTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaCadastroActionPerformed
        FrmCadastroPeca telaCadastro = new FrmCadastroPeca();
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_btnTelaCadastroActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        Peca peca = new Peca();
        String aux = (String) tblListagemPeca.getValueAt(tblListagemPeca.getSelectedRow(), 0);
        peca.setCodigoPeca(Integer.parseInt(aux));
        try {
            dp.deletarPeca(peca.getCodigoPeca());
            atualizarTabela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemPeca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmListagemPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListagemPeca().setVisible(true);
            }
        });
    }
    
    
    
    private void atualizarTabela (){
       
//        DaoPeca teste = new DaoPeca();
        ArrayList<Peca> lista = new ArrayList<>();
        lista = DaoPeca.listarPeca();
//        System.out.println(lista.get(0).getNomePeca());
        String[] nomeColunas = {"Código","Nome","Categoria","Quantidade","Valor Unitário"};
        try
        {
//            DefaultTableModel modelo = new DefaultTableModel(
//        lista.toArray(new Peca[lista.size()][]), nomeColunas);
//            tblListagemPeca.setModel(modelo);
            
            DefaultTableModel model = (DefaultTableModel) tblListagemPeca.getModel();
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
        Object rowData[] = new Object[5];
        for(int i = 0; i < lista.size(); i++)
        {
            rowData[0] = Integer.toString(lista.get(i).getCodigoPeca());
            rowData[1] = lista.get(i).getNomePeca();
            rowData[2] = lista.get(i).getCategoriaPeca();
            rowData[3] = Integer.toString(lista.get(i).getQuantidadePeca());
            rowData[4] = Float.toString(lista.get(i).getValorUnitario());
            model.addRow(rowData);
            
        }
                    
        }
        catch(Exception ex)
        {
            System.out.println("Erro ao popular tabela.\n\n"+ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizarTabela;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnTelaCadastro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListagemPeca;
    // End of variables declaration//GEN-END:variables
}
