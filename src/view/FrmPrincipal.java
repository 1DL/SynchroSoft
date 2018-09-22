/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author LuizV1
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setTitle("Menu Principal - " + control.SynchroSoft.getNomeUsuario() + " - " + control.SynchroSoft.getCodFunc() + " - " + control.SynchroSoft.getNvlAdm());
        if (control.SynchroSoft.getNvlAdm() == 0) {
            menu_cadastro.setEnabled(false);
        }

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtAlerta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menu_sistema = new javax.swing.JMenu();
        menu_logoff = new javax.swing.JMenuItem();
        menu_fecharJanelas = new javax.swing.JMenuItem();
        menu_sairSistema = new javax.swing.JMenuItem();
        menu_vendas = new javax.swing.JMenu();
        menu_vendaPeca = new javax.swing.JMenuItem();
        menu_cadastro = new javax.swing.JMenu();
        menu_os = new javax.swing.JMenuItem();
        menu_pessoa = new javax.swing.JMenuItem();
        menu_produto = new javax.swing.JMenuItem();
        menu_funcionario = new javax.swing.JMenuItem();
        menu_despesa = new javax.swing.JMenuItem();
        menu_usuario = new javax.swing.JMenuItem();
        menu_endereco = new javax.swing.JMenuItem();
        menu_listagem = new javax.swing.JMenu();
        menu_listaOrdemServico = new javax.swing.JMenuItem();
        menu_listaPessoaF = new javax.swing.JMenuItem();
        menu_listaPessoaJ = new javax.swing.JMenuItem();
        menu_listaProduto = new javax.swing.JMenuItem();
        menu_listaFuncionario = new javax.swing.JMenuItem();
        menu_listaDespesa = new javax.swing.JMenuItem();
        menu_listaUsuario = new javax.swing.JMenuItem();
        menu_listaEndereco = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setPreferredSize(new java.awt.Dimension(1152, 648));
        setSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        jLabel2.setText("Mensagens de Alerta:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 560, 120, 30);

        txtAlerta.setText("Alerta de Despesas para vencer: ");
        getContentPane().add(txtAlerta);
        txtAlerta.setBounds(190, 560, 920, 30);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(950, 440, 75, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 650);

        menu_sistema.setText("Sistema");

        menu_logoff.setText("Fazer Log-off");
        menu_logoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_logoffActionPerformed(evt);
            }
        });
        menu_sistema.add(menu_logoff);

        menu_fecharJanelas.setText("Fechar todas as janelas");
        menu_fecharJanelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_fecharJanelasActionPerformed(evt);
            }
        });
        menu_sistema.add(menu_fecharJanelas);

        menu_sairSistema.setText("Sair do sistema");
        menu_sairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sairSistemaActionPerformed(evt);
            }
        });
        menu_sistema.add(menu_sairSistema);

        menu.add(menu_sistema);

        menu_vendas.setText("Vendas");

        menu_vendaPeca.setText("Peças e Produtos");
        menu_vendaPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_vendaPecaActionPerformed(evt);
            }
        });
        menu_vendas.add(menu_vendaPeca);

        menu.add(menu_vendas);

        menu_cadastro.setText("Cadastro");

        menu_os.setText("Ordem de Serviço");
        menu_os.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_osActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_os);

        menu_pessoa.setText("Pessoa Física ou Jurídica");
        menu_pessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_pessoaActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_pessoa);

        menu_produto.setText("Produto");
        menu_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_produtoActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_produto);

        menu_funcionario.setText("Funcionário");
        menu_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_funcionarioActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_funcionario);

        menu_despesa.setText("Despesa");
        menu_despesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_despesaActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_despesa);

        menu_usuario.setText("Usuário");
        menu_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_usuarioActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_usuario);

        menu_endereco.setText("Endereço");
        menu_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_enderecoActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_endereco);

        menu.add(menu_cadastro);

        menu_listagem.setText("Listagem");

        menu_listaOrdemServico.setText("Ordem de Serviço");
        menu_listaOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaOrdemServicoActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaOrdemServico);

        menu_listaPessoaF.setText("Pessoa Física");
        menu_listaPessoaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaPessoaFActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaPessoaF);

        menu_listaPessoaJ.setText("Pessoa Jurídica");
        menu_listaPessoaJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaPessoaJActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaPessoaJ);

        menu_listaProduto.setText("Produto");
        menu_listaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaProdutoActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaProduto);

        menu_listaFuncionario.setText("Funcionário");
        menu_listaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaFuncionarioActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaFuncionario);

        menu_listaDespesa.setText("Despesa");
        menu_listaDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaDespesaActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaDespesa);

        menu_listaUsuario.setText("Usuário");
        menu_listaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaUsuarioActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaUsuario);

        menu_listaEndereco.setText("Endereço");
        menu_listaEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaEnderecoActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaEndereco);

        menu.add(menu_listagem);

        jMenu5.setText("Ajuda");

        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        menu.add(jMenu5);

        setJMenuBar(menu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        control.SynchroSoft.abrirSobre();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menu_osActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_osActionPerformed
        control.SynchroSoft.abrirCadastroServico();
    }//GEN-LAST:event_menu_osActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String teste = "";
        Frame[] telas = Frame.getFrames();
        for (Frame fr : telas) {
            teste += fr.getClass().getName() + "\n";
            if (fr.getClass().getName().equals("view.FrmPrincipal")) {
                JOptionPane.showMessageDialog(null, "Existe!");
                //fr.dispose();

            }
        }
        JOptionPane.showMessageDialog(null, teste);
        teste = "";

    }//GEN-LAST:event_jButton1ActionPerformed

    private void menu_listaPessoaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaPessoaFActionPerformed
        control.SynchroSoft.abrirListagemPessoaFisica();
    }//GEN-LAST:event_menu_listaPessoaFActionPerformed

    private void menu_logoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_logoffActionPerformed
        int aux;
        aux = JOptionPane.showConfirmDialog(null, "Deseja realmente fazer o log-off?", "Log-off", JOptionPane.YES_NO_OPTION);
        if (aux == 0) {
            this.dispose();
            control.SynchroSoft.setCodFunc(0);
            control.SynchroSoft.setNvlAdm(99);
            control.SynchroSoft.setNomeUsuario("Deslogado");
            FrmLogin login = new FrmLogin();
            login.setVisible(true);
        }
    }//GEN-LAST:event_menu_logoffActionPerformed

    private void menu_listaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaProdutoActionPerformed
        control.SynchroSoft.abrirListagemProduto();
    }//GEN-LAST:event_menu_listaProdutoActionPerformed

    private void menu_pessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_pessoaActionPerformed
        control.SynchroSoft.abrirCadastroPessoa();
    }//GEN-LAST:event_menu_pessoaActionPerformed

    private void menu_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_produtoActionPerformed
        control.SynchroSoft.abrirCadastroProduto();
    }//GEN-LAST:event_menu_produtoActionPerformed

    private void menu_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_funcionarioActionPerformed
        control.SynchroSoft.abrirCadastroFuncionário();
    }//GEN-LAST:event_menu_funcionarioActionPerformed

    private void menu_despesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_despesaActionPerformed
        control.SynchroSoft.abrirCadastroDespesa();
    }//GEN-LAST:event_menu_despesaActionPerformed

    private void menu_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_usuarioActionPerformed
        control.SynchroSoft.abrirCadastroUsuario();
    }//GEN-LAST:event_menu_usuarioActionPerformed

    private void menu_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_enderecoActionPerformed
        control.SynchroSoft.abrirCadastroEndereco();
    }//GEN-LAST:event_menu_enderecoActionPerformed

    private void menu_listaOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaOrdemServicoActionPerformed
        control.SynchroSoft.abrirListagemServico();
    }//GEN-LAST:event_menu_listaOrdemServicoActionPerformed

    private void menu_listaPessoaJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaPessoaJActionPerformed
        control.SynchroSoft.abrirListagemPessoaJuridica();
    }//GEN-LAST:event_menu_listaPessoaJActionPerformed

    private void menu_listaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaFuncionarioActionPerformed
        control.SynchroSoft.abrirListagemFuncionario();
    }//GEN-LAST:event_menu_listaFuncionarioActionPerformed

    private void menu_listaDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaDespesaActionPerformed
        control.SynchroSoft.abrirListagemDespesa();
    }//GEN-LAST:event_menu_listaDespesaActionPerformed

    private void menu_listaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaUsuarioActionPerformed
        control.SynchroSoft.abrirListagemUsuario();
    }//GEN-LAST:event_menu_listaUsuarioActionPerformed

    private void menu_listaEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaEnderecoActionPerformed
        control.SynchroSoft.abrirListagemEndereco();
    }//GEN-LAST:event_menu_listaEnderecoActionPerformed

    private void menu_vendaPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_vendaPecaActionPerformed
        control.SynchroSoft.abrirVendaPeca();
    }//GEN-LAST:event_menu_vendaPecaActionPerformed

    private void menu_sairSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sairSistemaActionPerformed
        int aux;
        aux = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?\n"
                + "\nAviso! Todas as janelas serão fechadas e os dados não salvos serão perdidos.", "Sair do Sistema", JOptionPane.YES_NO_OPTION);
        if (aux == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_menu_sairSistemaActionPerformed

    private void menu_fecharJanelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_fecharJanelasActionPerformed
        int aux;
        aux = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar todas as janelas?\n"
                + "\nAviso! Todos os dados não salvos serão perdidos.", "Fechar Janelas", JOptionPane.YES_NO_OPTION);
        if (aux == 0) {
            for (Frame fr : Frame.getFrames()) {
                fr.dispose();
            }

            control.SynchroSoft.abrirPrincipal();
        }
    }//GEN-LAST:event_menu_fecharJanelasActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menu_cadastro;
    private javax.swing.JMenuItem menu_despesa;
    private javax.swing.JMenuItem menu_endereco;
    private javax.swing.JMenuItem menu_fecharJanelas;
    private javax.swing.JMenuItem menu_funcionario;
    private javax.swing.JMenuItem menu_listaDespesa;
    private javax.swing.JMenuItem menu_listaEndereco;
    private javax.swing.JMenuItem menu_listaFuncionario;
    private javax.swing.JMenuItem menu_listaOrdemServico;
    private javax.swing.JMenuItem menu_listaPessoaF;
    private javax.swing.JMenuItem menu_listaPessoaJ;
    private javax.swing.JMenuItem menu_listaProduto;
    private javax.swing.JMenuItem menu_listaUsuario;
    private javax.swing.JMenu menu_listagem;
    private javax.swing.JMenuItem menu_logoff;
    private javax.swing.JMenuItem menu_os;
    private javax.swing.JMenuItem menu_pessoa;
    private javax.swing.JMenuItem menu_produto;
    private javax.swing.JMenuItem menu_sairSistema;
    private javax.swing.JMenu menu_sistema;
    private javax.swing.JMenuItem menu_usuario;
    private javax.swing.JMenuItem menu_vendaPeca;
    private javax.swing.JMenu menu_vendas;
    private javax.swing.JTextField txtAlerta;
    // End of variables declaration//GEN-END:variables
}
