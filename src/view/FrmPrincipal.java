/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Janelas;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LuizV1
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    ArrayList<Janelas> maisAcessadas = new ArrayList<>(control.Janelas.acessoTelas);

    public FrmPrincipal() {
        definirMaisAcessadas();
        initComponents();
        this.setTitle("Menu Principal - " + control.SynchroSoft.getNomeUsuario() + " - " + control.SynchroSoft.getCodFunc() + " - " + control.SynchroSoft.getNvlAdm());
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
        btn_janMaisAcessada1 = new javax.swing.JButton();
        btn_janMaisAcessada2 = new javax.swing.JButton();
        btn_janMaisAcessada3 = new javax.swing.JButton();
        btn_janMaisAcessada4 = new javax.swing.JButton();
        btn_janMaisAcessada5 = new javax.swing.JButton();
        btn_janMaisAcessada6 = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();
        btnFecharFrame = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menu_sistema = new javax.swing.JMenu();
        menu_logoff = new javax.swing.JMenuItem();
        menu_fecharJanelas = new javax.swing.JMenuItem();
        menu_sairSistema = new javax.swing.JMenuItem();
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
        menu_vendas = new javax.swing.JMenu();
        menu_vendaPeca = new javax.swing.JMenuItem();
        menu_relatorio = new javax.swing.JMenu();
        menu_relatorioOS = new javax.swing.JMenuItem();
        menu_relatorioDespesa = new javax.swing.JMenuItem();
        menu_ajuda = new javax.swing.JMenu();
        menu_sobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal - " + control.SynchroSoft.getNomeUsuario() + 
            " - Nível de Acesso: " + control.SynchroSoft.getNvlAdmSTR());
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logopng32.png")));
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setPreferredSize(new java.awt.Dimension(1152, 648));
        setResizable(false);
        setSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        jLabel2.setText("Mensagens de Alerta:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 560, 120, 30);

        txtAlerta.setText("Alerta de Despesas para vencer: ");
        getContentPane().add(txtAlerta);
        txtAlerta.setBounds(190, 560, 530, 30);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(950, 470, 73, 23);

        btn_janMaisAcessada1.setIcon(new javax.swing.ImageIcon(getClass().getResource(control.Janelas.setIconeMaisAcessada(maisAcessadas.get(0).getNome()))));
        btn_janMaisAcessada1.setText(control.Janelas.abrirMaisAcessada(maisAcessadas.get(0).getNome(), false)
        );
        btn_janMaisAcessada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_janMaisAcessada1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_janMaisAcessada1);
        btn_janMaisAcessada1.setBounds(80, 350, 280, 40);

        btn_janMaisAcessada2.setIcon(new javax.swing.ImageIcon(getClass().getResource(control.Janelas.setIconeMaisAcessada(maisAcessadas.get(1).getNome()))));
        btn_janMaisAcessada2.setText(control.Janelas.abrirMaisAcessada(maisAcessadas.get(1).getNome(), false)
        );
        btn_janMaisAcessada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_janMaisAcessada2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_janMaisAcessada2);
        btn_janMaisAcessada2.setBounds(410, 350, 280, 40);

        btn_janMaisAcessada3.setIcon(new javax.swing.ImageIcon(getClass().getResource(control.Janelas.setIconeMaisAcessada(maisAcessadas.get(2).getNome()))));
        btn_janMaisAcessada3.setText(control.Janelas.abrirMaisAcessada(maisAcessadas.get(2).getNome(), false)
        );
        btn_janMaisAcessada3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_janMaisAcessada3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_janMaisAcessada3);
        btn_janMaisAcessada3.setBounds(730, 350, 280, 40);

        btn_janMaisAcessada4.setIcon(new javax.swing.ImageIcon(getClass().getResource(control.Janelas.setIconeMaisAcessada(maisAcessadas.get(3).getNome()))));
        btn_janMaisAcessada4.setText(control.Janelas.abrirMaisAcessada(maisAcessadas.get(3).getNome(), false)
        );
        btn_janMaisAcessada4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_janMaisAcessada4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_janMaisAcessada4);
        btn_janMaisAcessada4.setBounds(80, 410, 280, 40);

        btn_janMaisAcessada5.setIcon(new javax.swing.ImageIcon(getClass().getResource(control.Janelas.setIconeMaisAcessada(maisAcessadas.get(4).getNome()))));
        btn_janMaisAcessada5.setText(control.Janelas.abrirMaisAcessada(maisAcessadas.get(4).getNome(), false)
        );
        btn_janMaisAcessada5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_janMaisAcessada5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_janMaisAcessada5);
        btn_janMaisAcessada5.setBounds(410, 410, 280, 40);

        btn_janMaisAcessada6.setIcon(new javax.swing.ImageIcon(getClass().getResource(control.Janelas.setIconeMaisAcessada(maisAcessadas.get(5).getNome()))));
        btn_janMaisAcessada6.setText(control.Janelas.abrirMaisAcessada(maisAcessadas.get(5).getNome(), false)
        );
        btn_janMaisAcessada6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_janMaisAcessada6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_janMaisAcessada6);
        btn_janMaisAcessada6.setBounds(730, 410, 280, 40);

        btnMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logopng32.png"))); // NOI18N
        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuPrincipal);
        btnMenuPrincipal.setBounds(900, 550, 130, 30);

        btnFecharFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logopng16.png"))); // NOI18N
        btnFecharFrame.setText("Fechar ");
        btnFecharFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharFrameActionPerformed(evt);
            }
        });
        getContentPane().add(btnFecharFrame);
        btnFecharFrame.setBounds(1050, 550, 80, 30);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, -20, 1150, 650);

        menu_sistema.setText("Sistema");

        menu_logoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/sistema_logoff.png"))); // NOI18N
        menu_logoff.setText("Fazer Log-off");
        menu_logoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_logoffActionPerformed(evt);
            }
        });
        menu_sistema.add(menu_logoff);

        menu_fecharJanelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/sistema_fecharjanelas.png"))); // NOI18N
        menu_fecharJanelas.setText("Fechar todas as janelas");
        menu_fecharJanelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_fecharJanelasActionPerformed(evt);
            }
        });
        menu_sistema.add(menu_fecharJanelas);

        menu_sairSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/sistema_sairdosistema.png"))); // NOI18N
        menu_sairSistema.setText("Sair do sistema");
        menu_sairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sairSistemaActionPerformed(evt);
            }
        });
        menu_sistema.add(menu_sairSistema);

        menu.add(menu_sistema);

        menu_cadastro.setText("Cadastro");

        menu_os.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/cadastro_ordemdeservico.png"))); // NOI18N
        menu_os.setText("Ordem de Serviço");
        menu_os.setEnabled(control.SynchroSoft.isAcesso());
        menu_os.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_osActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_os);

        menu_pessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/cadastro_pessoa.png"))); // NOI18N
        menu_pessoa.setText("Pessoa Física ou Jurídica");
        menu_pessoa.setEnabled(control.SynchroSoft.isAcesso());
        menu_pessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_pessoaActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_pessoa);

        menu_produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/cadastro_produto.png"))); // NOI18N
        menu_produto.setText("Produto");
        menu_produto.setEnabled(control.SynchroSoft.isAcesso());
        menu_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_produtoActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_produto);

        menu_funcionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/cadastro_funcionario.png"))); // NOI18N
        menu_funcionario.setText("Funcionário");
        menu_funcionario.setEnabled(control.SynchroSoft.isAcesso());
        menu_funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_funcionarioActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_funcionario);

        menu_despesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/cadastro_despesa.png"))); // NOI18N
        menu_despesa.setText("Despesa");
        menu_despesa.setEnabled(control.SynchroSoft.isAcesso());
        menu_despesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_despesaActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_despesa);

        menu_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/cadastro_usuario.png"))); // NOI18N
        menu_usuario.setText("Usuário");
        menu_usuario.setEnabled(control.SynchroSoft.isAcesso());
        menu_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_usuarioActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_usuario);

        menu_endereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/cadastro_endereco.png"))); // NOI18N
        menu_endereco.setText("Endereço");
        menu_endereco.setEnabled(control.SynchroSoft.isAcesso());
        menu_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_enderecoActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_endereco);

        menu.add(menu_cadastro);

        menu_listagem.setText("Listagem");

        menu_listaOrdemServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/listagem_ordemdeservico.png"))); // NOI18N
        menu_listaOrdemServico.setText("Ordem de Serviço");
        menu_listaOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaOrdemServicoActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaOrdemServico);

        menu_listaPessoaF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/listagem_pessoafisica.png"))); // NOI18N
        menu_listaPessoaF.setText("Pessoa Física");
        menu_listaPessoaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaPessoaFActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaPessoaF);

        menu_listaPessoaJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/listagem_pessoajuridica.png"))); // NOI18N
        menu_listaPessoaJ.setText("Pessoa Jurídica");
        menu_listaPessoaJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaPessoaJActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaPessoaJ);

        menu_listaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/listagem_produto.png"))); // NOI18N
        menu_listaProduto.setText("Produto");
        menu_listaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaProdutoActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaProduto);

        menu_listaFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/listagem_funcionario.png"))); // NOI18N
        menu_listaFuncionario.setText("Funcionário");
        menu_listaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaFuncionarioActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaFuncionario);

        menu_listaDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/listagem_despesa.png"))); // NOI18N
        menu_listaDespesa.setText("Despesa");
        menu_listaDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaDespesaActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaDespesa);

        menu_listaUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/listagem_usuario.png"))); // NOI18N
        menu_listaUsuario.setText("Usuário");
        menu_listaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaUsuarioActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaUsuario);

        menu_listaEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/listagem_endereco.png"))); // NOI18N
        menu_listaEndereco.setText("Endereço");
        menu_listaEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_listaEnderecoActionPerformed(evt);
            }
        });
        menu_listagem.add(menu_listaEndereco);

        menu.add(menu_listagem);

        menu_vendas.setText("Vendas");

        menu_vendaPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/venda_produto.png"))); // NOI18N
        menu_vendaPeca.setText("Peças e Produtos");
        menu_vendaPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_vendaPecaActionPerformed(evt);
            }
        });
        menu_vendas.add(menu_vendaPeca);

        menu.add(menu_vendas);

        menu_relatorio.setText("Relatórios");

        menu_relatorioOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/relatorio_ordemdeservico.png"))); // NOI18N
        menu_relatorioOS.setText("Ordens de Serviço");
        menu_relatorioOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_relatorioOSActionPerformed(evt);
            }
        });
        menu_relatorio.add(menu_relatorioOS);

        menu_relatorioDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/relatorio_despesa.png"))); // NOI18N
        menu_relatorioDespesa.setText("Despesas");
        menu_relatorio.add(menu_relatorioDespesa);

        menu.add(menu_relatorio);

        menu_ajuda.setText("Ajuda");

        menu_sobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icone/ajuda_sobre.png"))); // NOI18N
        menu_sobre.setText("Sobre");
        menu_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sobreActionPerformed(evt);
            }
        });
        menu_ajuda.add(menu_sobre);

        menu.add(menu_ajuda);

        setJMenuBar(menu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sobreActionPerformed
        control.Janelas.abrirSobre();
    }//GEN-LAST:event_menu_sobreActionPerformed

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
        control.Janelas.abrirListagemPessoaFisica();
    }//GEN-LAST:event_menu_listaPessoaFActionPerformed

    private void menu_logoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_logoffActionPerformed
        int aux;
        aux = JOptionPane.showConfirmDialog(null, "Deseja realmente fazer o log-off?", "Log-off", JOptionPane.YES_NO_OPTION);
        if (aux == 0) {
            this.dispose();
            control.SynchroSoft.setCodFunc("Codigo Func");
            control.SynchroSoft.setNvlAdm(99);
            control.SynchroSoft.setNomeUsuario("Deslogado");
            control.Janelas.fecharTodasJanelas();
            try {
                control.Janelas.abrirLogin();
            } catch (IOException ex) {
                Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_menu_logoffActionPerformed

    private void menu_listaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaProdutoActionPerformed
        control.Janelas.abrirListagemProduto();
    }//GEN-LAST:event_menu_listaProdutoActionPerformed

    private void menu_pessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_pessoaActionPerformed
        control.Janelas.abrirCadastroPessoa();
    }//GEN-LAST:event_menu_pessoaActionPerformed

    private void menu_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_produtoActionPerformed
        control.Janelas.abrirCadastroProduto();
    }//GEN-LAST:event_menu_produtoActionPerformed

    private void menu_funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_funcionarioActionPerformed
        control.Janelas.abrirCadastroFuncionário();
    }//GEN-LAST:event_menu_funcionarioActionPerformed

    private void menu_despesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_despesaActionPerformed
        control.Janelas.abrirCadastroDespesa();
    }//GEN-LAST:event_menu_despesaActionPerformed

    private void menu_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_usuarioActionPerformed
        control.Janelas.abrirCadastroUsuario();
    }//GEN-LAST:event_menu_usuarioActionPerformed

    private void menu_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_enderecoActionPerformed
        control.Janelas.abrirCadastroEndereco();
    }//GEN-LAST:event_menu_enderecoActionPerformed

    private void menu_listaOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaOrdemServicoActionPerformed
        control.Janelas.abrirListagemServico();
    }//GEN-LAST:event_menu_listaOrdemServicoActionPerformed

    private void menu_listaPessoaJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaPessoaJActionPerformed
        control.Janelas.abrirListagemPessoaJuridica();
    }//GEN-LAST:event_menu_listaPessoaJActionPerformed

    private void menu_listaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaFuncionarioActionPerformed
        control.Janelas.abrirListagemFuncionario();
    }//GEN-LAST:event_menu_listaFuncionarioActionPerformed

    private void menu_listaDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaDespesaActionPerformed
        control.Janelas.abrirListagemDespesa();
    }//GEN-LAST:event_menu_listaDespesaActionPerformed

    private void menu_listaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaUsuarioActionPerformed
        control.Janelas.abrirListagemUsuario();
    }//GEN-LAST:event_menu_listaUsuarioActionPerformed

    private void menu_listaEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_listaEnderecoActionPerformed
        control.Janelas.abrirListagemEndereco();
    }//GEN-LAST:event_menu_listaEnderecoActionPerformed

    private void menu_vendaPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_vendaPecaActionPerformed
        control.Janelas.abrirVendaPeca();
    }//GEN-LAST:event_menu_vendaPecaActionPerformed

    private void menu_sairSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sairSistemaActionPerformed
        control.SynchroSoft.sairDoSistema();
    }//GEN-LAST:event_menu_sairSistemaActionPerformed

    private void menu_fecharJanelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_fecharJanelasActionPerformed
        int aux;
        aux = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar todas as janelas?\n"
                + "\nAviso! Todos os dados não salvos serão perdidos.", "Fechar Janelas", JOptionPane.YES_NO_OPTION);
        if (aux == 0) {
            control.Janelas.fecharTodasJanelas();

            control.Janelas.focarPrincipal();
        }
    }//GEN-LAST:event_menu_fecharJanelasActionPerformed

    private void menu_relatorioOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_relatorioOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_relatorioOSActionPerformed

    private void btn_janMaisAcessada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_janMaisAcessada1ActionPerformed
        control.Janelas.abrirMaisAcessada(maisAcessadas.get(0).getNome(), true);
    }//GEN-LAST:event_btn_janMaisAcessada1ActionPerformed

    private void btn_janMaisAcessada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_janMaisAcessada2ActionPerformed
        control.Janelas.abrirMaisAcessada(maisAcessadas.get(1).getNome(), true);
    }//GEN-LAST:event_btn_janMaisAcessada2ActionPerformed

    private void btn_janMaisAcessada3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_janMaisAcessada3ActionPerformed
        control.Janelas.abrirMaisAcessada(maisAcessadas.get(2).getNome(), true);
    }//GEN-LAST:event_btn_janMaisAcessada3ActionPerformed

    private void btn_janMaisAcessada4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_janMaisAcessada4ActionPerformed
        control.Janelas.abrirMaisAcessada(maisAcessadas.get(3).getNome(), true);
    }//GEN-LAST:event_btn_janMaisAcessada4ActionPerformed

    private void btn_janMaisAcessada5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_janMaisAcessada5ActionPerformed
        control.Janelas.abrirMaisAcessada(maisAcessadas.get(4).getNome(), true);
    }//GEN-LAST:event_btn_janMaisAcessada5ActionPerformed

    private void btn_janMaisAcessada6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_janMaisAcessada6ActionPerformed
        control.Janelas.abrirMaisAcessada(maisAcessadas.get(5).getNome(), true);
    }//GEN-LAST:event_btn_janMaisAcessada6ActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        control.Janelas.focarPrincipal();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnFecharFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFrameActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharFrameActionPerformed

    private void menu_osActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_osActionPerformed
        control.Janelas.abrirCadastroServico();
    }//GEN-LAST:event_menu_osActionPerformed

    private void definirMaisAcessadas() {
        Collections.sort(maisAcessadas, new Comparator<Janelas>() {
            @Override
            public int compare(Janelas j1, Janelas j2) {
                return j1.getAcesso() - j2.getAcesso(); // Ascending
            }

        });

        Collections.reverse(maisAcessadas);
        System.out.println("Ordenação");
        for (Janelas j : maisAcessadas) {
            System.out.println(j.getNome() + " " + j.getAcesso());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

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
    private javax.swing.JButton btnFecharFrame;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btn_janMaisAcessada1;
    private javax.swing.JButton btn_janMaisAcessada2;
    private javax.swing.JButton btn_janMaisAcessada3;
    private javax.swing.JButton btn_janMaisAcessada4;
    private javax.swing.JButton btn_janMaisAcessada5;
    private javax.swing.JButton btn_janMaisAcessada6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menu_ajuda;
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
    private javax.swing.JMenu menu_relatorio;
    private javax.swing.JMenuItem menu_relatorioDespesa;
    private javax.swing.JMenuItem menu_relatorioOS;
    private javax.swing.JMenuItem menu_sairSistema;
    private javax.swing.JMenu menu_sistema;
    private javax.swing.JMenuItem menu_sobre;
    private javax.swing.JMenuItem menu_usuario;
    private javax.swing.JMenuItem menu_vendaPeca;
    private javax.swing.JMenu menu_vendas;
    private javax.swing.JTextField txtAlerta;
    // End of variables declaration//GEN-END:variables
}
