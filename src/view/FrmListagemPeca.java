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
        lblPesquisar = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();
        lblDescrever = new javax.swing.JLabel();
        btnPesquisa = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();

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

        lblPesquisar.setText("Pesquisar por: ");

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nome", "Categoria", "Quantidade", "Valor", " " }));

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

        lblDescrever.setText("Descrição:");

        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        btnMenuPrincipal.setText("Menu Principal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnAtualizarTabela)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)
                        .addGap(34, 34, 34)
                        .addComponent(btnDeletar)
                        .addGap(32, 32, 32)
                        .addComponent(btnTelaCadastro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(lblDescrever)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnPesquisa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(btnMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisar)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescrever)
                    .addComponent(btnPesquisa))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAtualizarTabela)
                        .addComponent(btnAlterar)
                        .addComponent(btnDeletar))
                    .addComponent(btnTelaCadastro))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyTyped
        
    }//GEN-LAST:event_txtPesquisaKeyTyped

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // Chamando método de listagem com filtro, se txt preenchido
        try
        {
            //criando variável de controle
            int controle = 0;
            
            //Se campo de texto não estiver vazio
            if (txtPesquisa.getText().trim() != "")
            {
                controle = 1;
                atualizarTabelaFiltrada();
            }
            
            //Se a variável de controle for 0, diz-se que o campo está vazio e, portanto, atualiza a JTable
            if (controle == 0)
            {
                atualizarTabela();
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exceção: "+ex);
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

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
    
    
    //Criando método de preenchimento/atualização de tabela com dados do banco
    private void atualizarTabela (){
       
//        DaoPeca teste = new DaoPeca();
        
        //Instanciando array de peças para preenchimento da tabela
        ArrayList<Peca> lista = new ArrayList<>();
        
        //Chamando método para preenchimento de Jtable com dados da tabela de peça
        lista = DaoPeca.listarPeca();
//        System.out.println(lista.get(0).getNomePeca());
        String[] nomeColunas = {"Código","Nome","Categoria","Quantidade","Valor Unitário"};
        try //Dentro deste try está a criação do modelo Jtable e o preenchimento das linhas pelo método ListarPeca()
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
    
    private void atualizarTabelaFiltrada (){ //Igual método de ListarPeca, mas chama o método de ListarPecaFiltrada()
       
//        DaoPeca teste = new DaoPeca();
        ArrayList<Peca> lista = new ArrayList<>();
        lista = DaoPeca.listarPecaFiltrada((String) cmbFiltro.getSelectedItem(), txtPesquisa.getText().trim()); //Filtrando dados que aparecem na pesquisa
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
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnTelaCadastro;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescrever;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JTable tblListagemPeca;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
