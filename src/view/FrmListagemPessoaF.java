/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoPessoa;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Pessoa;
import model.PessoaFisica;

/**
 *
 * @author Luiz
 */
public class FrmListagemPessoaF extends javax.swing.JFrame {

    /**
     * Creates new form FrmListagemPessoa
     */
    public FrmListagemPessoaF() {
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

        lblPesquisar = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        cmbFiltro = new javax.swing.JComboBox<>();
        lblDescrever = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnMenuPrincipal = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnTelaCadastro = new javax.swing.JButton();
        btnAtualizarTabela1 = new javax.swing.JButton();
        btnJuridica = new javax.swing.JButton();
        scpListagemPessoaF = new javax.swing.JScrollPane();
        tblListagemPessoaF = new javax.swing.JTable();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        lblPesquisar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar por: ");
        getContentPane().add(lblPesquisar);
        lblPesquisar.setBounds(240, 100, 120, 25);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(990, 550, 130, 50);

        cmbFiltro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Sexo", "CEP", "Endereço", "Número Endereço", "Telefone", "Celular", "Contrato", "Data de Cadastro" }));
        getContentPane().add(cmbFiltro);
        cmbFiltro.setBounds(400, 100, 107, 31);

        lblDescrever.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDescrever.setText("Descrição:");
        getContentPane().add(lblDescrever);
        lblDescrever.setBounds(540, 100, 83, 25);

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
        txtPesquisa.setBounds(660, 100, 256, 31);

        btnMenuPrincipal.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo pequeno.png"))); // NOI18N
        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuPrincipal);
        btnMenuPrincipal.setBounds(950, 220, 161, 239);

        btnAlterar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(450, 560, 100, 33);

        btnDeletar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar);
        btnDeletar.setBounds(590, 560, 110, 33);

        btnTelaCadastro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnTelaCadastro.setText("Tela Cadastro");
        btnTelaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnTelaCadastro);
        btnTelaCadastro.setBounds(743, 560, 170, 33);

        btnAtualizarTabela1.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnAtualizarTabela1.setText("AtualizarTabela");
        btnAtualizarTabela1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTabela1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizarTabela1);
        btnAtualizarTabela1.setBounds(240, 560, 180, 33);

        btnJuridica.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnJuridica.setText("Listar Pessoa Jurídica");
        btnJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuridicaActionPerformed(evt);
            }
        });
        getContentPane().add(btnJuridica);
        btnJuridica.setBounds(10, 150, 210, 80);

        scpListagemPessoaF.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        scpListagemPessoaF.setMaximumSize(new java.awt.Dimension(100, 100));
        scpListagemPessoaF.setMinimumSize(new java.awt.Dimension(100, 100));
        scpListagemPessoaF.setPreferredSize(new java.awt.Dimension(100, 100));

        tblListagemPessoaF.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        tblListagemPessoaF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblListagemPessoaF.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblListagemPessoaF.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblListagemPessoaF.setGridColor(new java.awt.Color(51, 153, 255));
        tblListagemPessoaF.setSelectionBackground(new java.awt.Color(0, 153, 255));
        scpListagemPessoaF.setViewportView(tblListagemPessoaF);

        getContentPane().add(scpListagemPessoaF);
        scpListagemPessoaF.setBounds(240, 140, 670, 402);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 1150, 740);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    DaoPessoa pessoa = new DaoPessoa();
    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed

    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
//         Chamando método de listagem com filtro, se txt preenchido
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

    private void txtPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyTyped

    }//GEN-LAST:event_txtPesquisaKeyTyped

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        
        try{
            tblListagemPessoaF.getCellEditor().stopCellEditing();
        } catch (Exception ex) {

        }
        try{
            pessoa.alterarPessoaFisica(tblListagemPessoaF);
        } catch (SQLException ex) {
            Logger.getLogger(FrmListagemPeca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemPeca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        PessoaFisica p = new PessoaFisica();
        String aux = (String) tblListagemPessoaF.getValueAt(tblListagemPessoaF.getSelectedRow(), 1);
        p.setCpf(aux);
        try {
            pessoa.deletarPessoaFisica(p.getCpf());
            atualizarTabela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemPeca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaCadastroActionPerformed
        FrmCadastroPessoa telaCadastro = new FrmCadastroPessoa();
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_btnTelaCadastroActionPerformed

    private void btnAtualizarTabela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabela1ActionPerformed
       atualizarTabela();
    }//GEN-LAST:event_btnAtualizarTabela1ActionPerformed

    private void btnJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuridicaActionPerformed
        FrmListagemPessoaJ j = new FrmListagemPessoaJ();
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnJuridicaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmListagemPessoaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPessoaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPessoaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPessoaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListagemPessoaF().setVisible(true);
            }
        });
    }  
       
    private void atualizarTabelaFiltrada (){
       
//        DaoPeca teste = new DaoPeca();
        
        //Instanciando array de pessoas para preenchimento da tabela
        //ArrayList<Pessoa> lista = new ArrayList<>();
        ArrayList<PessoaFisica> lista = new ArrayList<>();
        //Chamando método para preenchimento de Jtable com dados da tabela de peça
        lista = DaoPessoa.listarPessoaFisicaFiltrada((String) cmbFiltro.getSelectedItem(), txtPesquisa.getText().trim());
//        System.out.println(lista.get(0).);
        String[] nomeColunas = {"Nome","CPF","Sexo","CEP","Endereço", "Número", "Telefone", "Celular", "Contrato", "Data de Cadastro", "PK Ref"};
        try //Dentro deste try está a criação do modelo Jtable e o preenchimento das linhas pelo método ListarPeca()
        {
            //declaração de variável pra contrato e para sexo
            String contrato = "";
            String sexo = "";
            
            
//            DefaultTableModel modelo = new DefaultTableModel(
//        lista.toArray(new Peca[lista.size()][]), nomeColunas);
//            tblListagemPeca.setModel(modelo);
            
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 11) {
                        //Coluna 10 não poderá ser editada.
                        return false;
                    }
                    return true;
                }
            };
            tblListagemPessoaF.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
        Object rowData[] = new Object[11];
        for(int i = 0; i < lista.size(); i++)
        {
            //Se o manter contrato for 1, possui; senão, não possui
            if(lista.get(i).getPessoa().getManterContrato() == 0)
            {
                contrato = "Possui contrato";
            }
            else
            {
                contrato = "Não possui contrato";
            }
            
            //Se o sexo for 0, masculino; senão, feminino
            if(lista.get(i).getSexo() == 0)
            {
                sexo = "Masculino";
            }
            else
            {
                sexo = "Feminino";
            }
            
            rowData[0] = lista.get(i).getPessoa().getNome();
            rowData[1] = lista.get(i).getCpf();
            rowData[2] = sexo;            
            rowData[3] = lista.get(i).getPessoa().getEndereco().getCep();
            rowData[4] = lista.get(i).getPessoa().getEndereco().getLogradouro();
            rowData[5] = lista.get(i).getPessoa().getComplementoLogradouro();
            rowData[6] = Long.toString(lista.get(i).getPessoa().getTelefone());
            rowData[7] = Long.toString(lista.get(i).getCelular());
            rowData[8] = contrato;            
            rowData[9] = lista.get(i).getDataCadastro();
            rowData[10] = lista.get(i).getCpf();
            
            
            model.addRow(rowData);
            
        }
                    
        }
        catch(Exception ex)
        {
            System.out.println("Erro ao popular tabela.\n\n"+ex.getMessage());
        }
        
        tblListagemPessoaF.getColumnModel().getColumn(10).setMinWidth(0);
        tblListagemPessoaF.getColumnModel().getColumn(10).setPreferredWidth(0);
        tblListagemPessoaF.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    //Criando método de preenchimento/atualização de tabela com dados do banco
    private void atualizarTabela (){
       
        ArrayList<PessoaFisica> lista = new ArrayList<>();
        
        lista = DaoPessoa.listarPessoaFisica();

        String[] nomeColunas = {"Nome","CPF","Sexo","CEP","Endereço", "Número", "Telefone", "Celular", "Contrato", "Data de Cadastro", "PK Ref"};
        try
        {
            
            String contrato = "";
            String sexo = "";
            
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 11) {
                        //Coluna 10 não poderá ser editada.
                        return false;
                    }
                    return true;
                }
            };
            tblListagemPessoaF.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
        Object rowData[] = new Object[11];
        for(int i = 0; i < lista.size(); i++)
        {
            //Se o manter contrato for 1, possui; senão, não possui
            if(lista.get(i).getPessoa().getManterContrato() == 0)
            {
                contrato = "Possui contrato";
            }
            else
            {
                contrato = "Não possui contrato";
            }
            
            //Se o sexo for 0, masculino; senão, feminino
            if(lista.get(i).getSexo() == 0)
            {
                sexo = "Masculino";
            }
            else
            {
                sexo = "Feminino";
            }
            
            rowData[0] = lista.get(i).getPessoa().getNome();
            rowData[1] = lista.get(i).getCpf();
            rowData[2] = sexo;            
            rowData[3] = lista.get(i).getPessoa().getEndereco().getCep();
            rowData[4] = lista.get(i).getPessoa().getEndereco().getLogradouro();
            rowData[5] = lista.get(i).getPessoa().getComplementoLogradouro();
            rowData[6] = Long.toString(lista.get(i).getPessoa().getTelefone());
            rowData[7] = Long.toString(lista.get(i).getCelular());
            rowData[8] = contrato;            
            rowData[9] = lista.get(i).getDataCadastro();
            rowData[10] = lista.get(i).getCpf();
            
            
            model.addRow(rowData);
            
        }
                    
        }
        catch(Exception ex)
        {
            System.out.println("Erro ao popular tabela.\n\n"+ex.getMessage());
        }
        
        tblListagemPessoaF.getColumnModel().getColumn(10).setMinWidth(0);
        tblListagemPessoaF.getColumnModel().getColumn(10).setPreferredWidth(0);
        tblListagemPessoaF.getColumnModel().getColumn(10).setMaxWidth(0);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizarTabela1;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnJuridica;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnTelaCadastro;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel lblDescrever;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JScrollPane scpListagemPessoaF;
    private javax.swing.JTable tblListagemPessoaF;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
