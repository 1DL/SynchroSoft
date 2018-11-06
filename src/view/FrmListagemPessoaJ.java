/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DaoPessoa;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.PessoaJuridica;

/**
 *
 * @author Luiz
 */
public class FrmListagemPessoaJ extends javax.swing.JFrame {

    /**
     * Creates new form FrmListagemPessoa
     */
    public FrmListagemPessoaJ(int nvlAdm) {
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

        btnFechar = new javax.swing.JButton();
        lblPesquisar = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox<>();
        lblDescrever = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnMenuPrincipal = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnTelaCadastro = new javax.swing.JButton();
        btnAtualizarTabela1 = new javax.swing.JButton();
        btnFisica = new javax.swing.JButton();
        scpListagemPessoaF = new javax.swing.JScrollPane();
        tblListagemPessoaJ = new javax.swing.JTable();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Pessoas Jurídicas");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logopng32.png")));
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setResizable(false);
        setSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(990, 550, 130, 50);

        lblPesquisar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar por: ");
        getContentPane().add(lblPesquisar);
        lblPesquisar.setBounds(240, 100, 120, 25);

        cmbFiltro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNPJ", "CEP", "Nome Fictício", "Razão Social", "Número Endereço", "Telefone", "Ramal", "Contrato", "Data Cadastro" }));
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

        btnFisica.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        btnFisica.setText("Listar Pessoa Física");
        btnFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFisicaActionPerformed(evt);
            }
        });
        getContentPane().add(btnFisica);
        btnFisica.setBounds(10, 150, 210, 80);

        scpListagemPessoaF.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        scpListagemPessoaF.setMaximumSize(new java.awt.Dimension(100, 100));
        scpListagemPessoaF.setMinimumSize(new java.awt.Dimension(100, 100));
        scpListagemPessoaF.setPreferredSize(new java.awt.Dimension(100, 100));

        tblListagemPessoaJ.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        tblListagemPessoaJ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblListagemPessoaJ.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblListagemPessoaJ.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblListagemPessoaJ.setGridColor(new java.awt.Color(51, 153, 255));
        tblListagemPessoaJ.setSelectionBackground(new java.awt.Color(0, 153, 255));
        scpListagemPessoaF.setViewportView(tblListagemPessoaJ);

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
            tblListagemPessoaJ.getCellEditor().stopCellEditing();
        } catch (Exception ex) {

        }
        
            pessoa.alterarPessoaJuridica(tblListagemPessoaJ);
        

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        PessoaJuridica pj = new PessoaJuridica();
        String aux = (String) tblListagemPessoaJ.getValueAt(tblListagemPessoaJ.getSelectedRow(), 1);
        pj.setCnpj(aux);
        try {
            pessoa.deletarPessoaJuridica(pj.getCnpj());
            atualizarTabela();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FrmListagemProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnTelaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaCadastroActionPerformed
        control.Janelas.abrirCadastroPessoa();
    }//GEN-LAST:event_btnTelaCadastroActionPerformed

    private void btnAtualizarTabela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTabela1ActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarTabela1ActionPerformed

    private void btnFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFisicaActionPerformed
        control.Janelas.abrirListagemPessoaFisica();
        this.dispose();
    }//GEN-LAST:event_btnFisicaActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        control.Janelas.abrirPrincipal();
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
            java.util.logging.Logger.getLogger(FrmListagemPessoaJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPessoaJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPessoaJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListagemPessoaJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListagemPessoaJ(control.SynchroSoft.getNvlAdm()).setVisible(true);
            }
        });
    }  
       
    private void atualizarTabelaFiltrada (){
       
//        DaoPeca teste = new DaoPeca();
        
        //Instanciando array de pessoas para preenchimento da tabela
        //ArrayList<Pessoa> lista = new ArrayList<>();
        ArrayList<PessoaJuridica> lista = new ArrayList<>();
        //Chamando método para preenchimento de Jtable com dados da tabela de peça
        lista = DaoPessoa.listarPessoaJuridicaFiltrada((String) cmbFiltro.getSelectedItem(), txtPesquisa.getText().toLowerCase().trim());
//        System.out.println(lista.get(0).);
        String[] nomeColunas = {"CNPJ","CEP","Nome Fictício","Razão Social","Nº", "Telefone", "Ramal", "Contrato", 
            "Data Cadastro","PK Ref"};
        try //Dentro deste try está a criação do modelo Jtable e o preenchimento das linhas pelo método ListarPeca()
        {
            //declaração de variável pra contrato
            String contrato = "";
 
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 10) {
                        //Coluna 9 não poderá ser editada.
                        return false;
                    }
                    return true;
                }
            };
            tblListagemPessoaJ.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
        Object rowData[] = new Object[10];
        for(int i = 0; i < lista.size(); i++)
        {
            //Se o manter contrato for 1, possui; senão, não possui
            if(lista.get(i).getPessoa().getManterContrato() == 0)
            {
                contrato = "Sim";
            }
            else
            {
                contrato = "Não";
            }
            
            
            rowData[0] = lista.get(i).getCnpj();
            rowData[1] = lista.get(i).getPessoa().getEndereco().getCep();
            rowData[2] = lista.get(i).getPessoa().getNome();
            rowData[3] = lista.get(i).getRazaoSocial();
            rowData[4] = lista.get(i).getPessoa().getComplementoLogradouro();
            rowData[5] = Long.toString(lista.get(i).getPessoa().getTelefone());
            rowData[6] = Long.toString(lista.get(i).getRamalCliente());
            rowData[7] = contrato;
            rowData[8] = lista.get(i).getDataCadastro().toString();
            rowData[9] = lista.get(i).getCnpj();
            
            
            model.addRow(rowData);
            
        }
                    
        }
        catch(Exception ex)
        {
            System.out.println("Erro ao popular tabela.\n\n"+ex.getMessage());
        }
        
        tblListagemPessoaJ.getColumnModel().getColumn(9).setMinWidth(0);
        tblListagemPessoaJ.getColumnModel().getColumn(9).setPreferredWidth(0);
        tblListagemPessoaJ.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    //Criando método de preenchimento/atualização de tabela com dados do banco
    private void atualizarTabela (){
       
//        DaoPeca teste = new DaoPeca();
        
        //Instanciando array de pessoas para preenchimento da tabela
        //ArrayList<Pessoa> lista = new ArrayList<>();
        ArrayList<PessoaJuridica> lista = new ArrayList<>();
        //Chamando método para preenchimento de Jtable com dados da tabela de peça
        lista = DaoPessoa.listarPessoaJuridica();
//        System.out.println(lista.get(0).);
        String[] nomeColunas = {"CNPJ","CEP","Nome Fictício","Razão Social","Nº", "Telefone", "Ramal", "Contrato", 
            "Data Cadastro","PK Ref"};
        try //Dentro deste try está a criação do modelo Jtable e o preenchimento das linhas pelo método ListarPeca()
        {
            //declaração de variável pra contrato
            String contrato = "";
 
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 10) {
                        //Coluna 9 não poderá ser editada.
                        return false;
                    }
                    return true;
                }
            };
            tblListagemPessoaJ.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
        Object rowData[] = new Object[10];
        for(int i = 0; i < lista.size(); i++)
        {
            //Se o manter contrato for 1, possui; senão, não possui
            if(lista.get(i).getPessoa().getManterContrato() == 0)
            {
                contrato = "Sim";
            }
            else
            {
                contrato = "Não";
            }
            
            
            rowData[0] = lista.get(i).getCnpj();
            rowData[1] = lista.get(i).getPessoa().getEndereco().getCep();
            rowData[2] = lista.get(i).getPessoa().getNome();
            rowData[3] = lista.get(i).getRazaoSocial();
            rowData[4] = lista.get(i).getPessoa().getComplementoLogradouro();
            rowData[5] = Long.toString(lista.get(i).getPessoa().getTelefone());
            rowData[6] = Long.toString(lista.get(i).getRamalCliente());
            rowData[7] = contrato;            
            rowData[8] = lista.get(i).getDataCadastro().toString();
            rowData[9] = lista.get(i).getCnpj();
            
            
            model.addRow(rowData);
            
        }
                    
        }
        catch(Exception ex)
        {
            System.out.println("Erro ao popular tabela.\n\n"+ex.getMessage());
        }
        
        tblListagemPessoaJ.getColumnModel().getColumn(9).setMinWidth(0);
        tblListagemPessoaJ.getColumnModel().getColumn(9).setPreferredWidth(0);
        tblListagemPessoaJ.getColumnModel().getColumn(9).setMaxWidth(0);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizarTabela1;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFisica;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnTelaCadastro;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel lblDescrever;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JScrollPane scpListagemPessoaF;
    private javax.swing.JTable tblListagemPessoaJ;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
