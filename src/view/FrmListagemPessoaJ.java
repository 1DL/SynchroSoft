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

        panPrincipal = new javax.swing.JPanel();
        lblPesquisar = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox<>();
        lblDigiteODado = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        panPrincipal1 = new javax.swing.JPanel();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblNumeroLogradouro = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNomePessoaFicticio = new javax.swing.JTextField();
        lblCep = new javax.swing.JLabel();
        lblCepExiste = new javax.swing.JLabel();
        btnCadastrarCep = new javax.swing.JButton();
        txtNumeroLogradouro = new javax.swing.JTextField();
        lblTipoPessoa1 = new javax.swing.JLabel();
        rbtSimCadastro = new javax.swing.JRadioButton();
        rbtNaoCadastro = new javax.swing.JRadioButton();
        lblCpfCnpj = new javax.swing.JLabel();
        txtRazaoSocial = new javax.swing.JTextField();
        lblRazaoSocial = new javax.swing.JLabel();
        lblCelRamal = new javax.swing.JLabel();
        txtCelRamal = new javax.swing.JTextField();
        lblDataCadastro = new javax.swing.JLabel();
        txtfDataCadastro = new javax.swing.JFormattedTextField();
        btnHoje = new javax.swing.JButton();
        lblCpfCnpjExiste = new javax.swing.JLabel();
        txtfCep = new javax.swing.JFormattedTextField();
        txtCpfCnpj = new javax.swing.JTextField();
        btnDeletar = new javax.swing.JButton();
        btnLimparTabela = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();
        btnCadastrarProduto = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagemPessoaJ = new javax.swing.JTable();
        btnDeletarTodosRegistros = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();
        btnFecharFrame = new javax.swing.JButton();
        lblPessoaJEncontrado = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Pessoas Jurídicas");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logopng32.png")));
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setResizable(false);
        setSize(new java.awt.Dimension(1152, 648));
        getContentPane().setLayout(null);

        panPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panPrincipal.setOpaque(false);
        panPrincipal.setLayout(null);

        lblPesquisar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar por: ");
        panPrincipal.add(lblPesquisar);
        lblPesquisar.setBounds(10, 10, 120, 25);

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome Fictício", "CNPJ", "CEP", "Logradouro", "Razão Social", "Número Endereço", "Telefone", "Ramal", "Contrato", "Data Cadastro" }));
        panPrincipal.add(cmbFiltro);
        cmbFiltro.setBounds(160, 10, 210, 25);

        lblDigiteODado.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDigiteODado.setText("Descrição:");
        panPrincipal.add(lblDigiteODado);
        lblDigiteODado.setBounds(375, 10, 83, 25);

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
        panPrincipal.add(txtPesquisa);
        txtPesquisa.setBounds(660, 10, 256, 25);

        panPrincipal1.setBackground(new java.awt.Color(204, 204, 204));
        panPrincipal1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Pessoa Jurídica"));
        panPrincipal1.setOpaque(false);
        panPrincipal1.setLayout(null);

        lblTelefone.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblTelefone.setText("Telefone:");
        panPrincipal1.add(lblTelefone);
        lblTelefone.setBounds(10, 130, 140, 25);

        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyReleased(evt);
            }
        });
        panPrincipal1.add(txtTelefone);
        txtTelefone.setBounds(150, 130, 316, 25);

        lblNumeroLogradouro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblNumeroLogradouro.setText("Nº Logradouro:");
        panPrincipal1.add(lblNumeroLogradouro);
        lblNumeroLogradouro.setBounds(530, 90, 150, 25);

        lblNome.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblNome.setText("Nome Fictício:");
        panPrincipal1.add(lblNome);
        lblNome.setBounds(10, 50, 150, 25);

        txtNomePessoaFicticio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomePessoaFicticioKeyReleased(evt);
            }
        });
        panPrincipal1.add(txtNomePessoaFicticio);
        txtNomePessoaFicticio.setBounds(150, 50, 316, 25);

        lblCep.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCep.setText("CEP:");
        panPrincipal1.add(lblCep);
        lblCep.setBounds(10, 90, 140, 25);

        lblCepExiste.setForeground(java.awt.Color.red);
        lblCepExiste.setText("Cep Inválido.");
        panPrincipal1.add(lblCepExiste);
        lblCepExiste.setBounds(280, 90, 90, 25);

        btnCadastrarCep.setText("Cadastrar");
        btnCadastrarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCepActionPerformed(evt);
            }
        });
        panPrincipal1.add(btnCadastrarCep);
        btnCadastrarCep.setBounds(384, 87, 80, 29);

        txtNumeroLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroLogradouroActionPerformed(evt);
            }
        });
        txtNumeroLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroLogradouroKeyReleased(evt);
            }
        });
        panPrincipal1.add(txtNumeroLogradouro);
        txtNumeroLogradouro.setBounds(680, 90, 120, 25);

        lblTipoPessoa1.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblTipoPessoa1.setText("Possui Contrato:");
        panPrincipal1.add(lblTipoPessoa1);
        lblTipoPessoa1.setBounds(10, 10, 140, 25);

        rbtSimCadastro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        rbtSimCadastro.setText("Sim");
        rbtSimCadastro.setOpaque(false);
        rbtSimCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtSimCadastroActionPerformed(evt);
            }
        });
        panPrincipal1.add(rbtSimCadastro);
        rbtSimCadastro.setBounds(148, 10, 55, 25);

        rbtNaoCadastro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        rbtNaoCadastro.setSelected(true);
        rbtNaoCadastro.setText("Não");
        rbtNaoCadastro.setOpaque(false);
        rbtNaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNaoCadastroActionPerformed(evt);
            }
        });
        panPrincipal1.add(rbtNaoCadastro);
        rbtNaoCadastro.setBounds(210, 10, 59, 25);

        lblCpfCnpj.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCpfCnpj.setText("CPF:");
        panPrincipal1.add(lblCpfCnpj);
        lblCpfCnpj.setBounds(530, 50, 140, 25);

        txtRazaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRazaoSocialKeyReleased(evt);
            }
        });
        panPrincipal1.add(txtRazaoSocial);
        txtRazaoSocial.setBounds(150, 170, 316, 25);

        lblRazaoSocial.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblRazaoSocial.setText("Razão Social:");
        panPrincipal1.add(lblRazaoSocial);
        lblRazaoSocial.setBounds(10, 170, 140, 25);

        lblCelRamal.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCelRamal.setText("Ramal");
        panPrincipal1.add(lblCelRamal);
        lblCelRamal.setBounds(530, 130, 140, 25);

        txtCelRamal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCelRamalKeyReleased(evt);
            }
        });
        panPrincipal1.add(txtCelRamal);
        txtCelRamal.setBounds(680, 130, 316, 25);

        lblDataCadastro.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDataCadastro.setText("Data Cadastro:");
        panPrincipal1.add(lblDataCadastro);
        lblDataCadastro.setBounds(530, 10, 118, 25);

        txtfDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        panPrincipal1.add(txtfDataCadastro);
        txtfDataCadastro.setBounds(680, 10, 120, 25);

        btnHoje.setText("Hoje");
        btnHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHojeActionPerformed(evt);
            }
        });
        panPrincipal1.add(btnHoje);
        btnHoje.setBounds(810, 10, 55, 25);

        lblCpfCnpjExiste.setForeground(java.awt.Color.red);
        lblCpfCnpjExiste.setText("CPF Inválido.");
        panPrincipal1.add(lblCpfCnpjExiste);
        lblCpfCnpjExiste.setBounds(810, 50, 190, 25);

        try {
            txtfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtfCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfCepFocusLost(evt);
            }
        });
        txtfCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfCepKeyReleased(evt);
            }
        });
        panPrincipal1.add(txtfCep);
        txtfCep.setBounds(150, 90, 127, 25);

        txtCpfCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfCnpjFocusLost(evt);
            }
        });
        txtCpfCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCpfCnpjKeyReleased(evt);
            }
        });
        panPrincipal1.add(txtCpfCnpj);
        txtCpfCnpj.setBounds(680, 50, 120, 25);

        panPrincipal.add(panPrincipal1);
        panPrincipal1.setBounds(10, 50, 1100, 210);

        btnDeletar.setText("Deletar registro selecionado");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        panPrincipal.add(btnDeletar);
        btnDeletar.setBounds(10, 270, 170, 30);

        btnLimparTabela.setText("Limpar tabela");
        btnLimparTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTabelaActionPerformed(evt);
            }
        });
        panPrincipal.add(btnLimparTabela);
        btnLimparTabela.setBounds(410, 270, 120, 30);

        btnListarTodos.setText("Listar todos os registros");
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
            }
        });
        panPrincipal.add(btnListarTodos);
        btnListarTodos.setBounds(550, 270, 147, 30);

        btnCadastrarProduto.setText("Cadastrar novo CPF");
        btnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutoActionPerformed(evt);
            }
        });
        panPrincipal.add(btnCadastrarProduto);
        btnCadastrarProduto.setBounds(720, 270, 150, 30);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        panPrincipal.add(btnAlterar);
        btnAlterar.setBounds(980, 270, 130, 30);

        getContentPane().add(panPrincipal);
        panPrincipal.setBounds(10, 10, 1125, 310);

        tblListagemPessoaJ.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListagemPessoaJ);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 350, 1125, 190);

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

        lblPessoaJEncontrado.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPessoaJEncontrado.setText("Pessoas Jurídicas encontradas no banco de dados. Para visualizar ou alterar um registro, clique em um registro exibido na tabela.");
        getContentPane().add(lblPessoaJEncontrado);
        lblPessoaJEncontrado.setBounds(10, 320, 1120, 25);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, -20, 1150, 650);

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

    private void btnDeletarTodosRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarTodosRegistrosActionPerformed
        removerTodosRegistros();
    }//GEN-LAST:event_btnDeletarTodosRegistrosActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        control.Janelas.focarPrincipal();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnFecharFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFrameActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharFrameActionPerformed

    private void txtTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyReleased
        txtTelefone.setText(TextSize.maxLenghtTelefone(txtTelefone.getText()));
    }//GEN-LAST:event_txtTelefoneKeyReleased

    private void txtNomePessoaFicticioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomePessoaFicticioKeyReleased
        txtNomePessoaFicticio.setText(TextSize.maxLenghtNomeRazao(txtNomePessoaFicticio.getText()));
    }//GEN-LAST:event_txtNomePessoaFicticioKeyReleased

    private void btnCadastrarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCepActionPerformed
        control.Janelas.abrirCadastroEnderecoParametrizada(txtfCep.getText().replace("-", ""));
    }//GEN-LAST:event_btnCadastrarCepActionPerformed

    private void txtNumeroLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroLogradouroActionPerformed

    }//GEN-LAST:event_txtNumeroLogradouroActionPerformed

    private void txtNumeroLogradouroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroLogradouroKeyReleased
        txtNumeroLogradouro.setText(TextSize.maxLenghtNrLogradouro(txtNumeroLogradouro.getText()));
    }//GEN-LAST:event_txtNumeroLogradouroKeyReleased

    private void rbtSimCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtSimCadastroActionPerformed

    }//GEN-LAST:event_rbtSimCadastroActionPerformed

    private void rbtNaoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNaoCadastroActionPerformed

    }//GEN-LAST:event_rbtNaoCadastroActionPerformed

    private void txtRazaoSocialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazaoSocialKeyReleased
        txtRazaoSocial.setText(TextSize.maxLenghtNomeRazao(txtRazaoSocial.getText()));
    }//GEN-LAST:event_txtRazaoSocialKeyReleased

    private void txtCelRamalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelRamalKeyReleased
        textSizeCelRamal();
    }//GEN-LAST:event_txtCelRamalKeyReleased

    private void btnHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHojeActionPerformed
        txtfDataCadastro.setText(control.Datas.getDiaHoje());
    }//GEN-LAST:event_btnHojeActionPerformed

    private void txtfCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfCepFocusLost
        verificarCep();
    }//GEN-LAST:event_txtfCepFocusLost

    private void txtfCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfCepKeyReleased
        verificarCep();
    }//GEN-LAST:event_txtfCepKeyReleased

    private void txtCpfCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfCnpjFocusLost
        textSizeCPFJCNPJ();
    }//GEN-LAST:event_txtCpfCnpjFocusLost

    private void txtCpfCnpjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfCnpjKeyReleased
        textSizeCPFJCNPJ();
    }//GEN-LAST:event_txtCpfCnpjKeyReleased

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        deletarRegistro();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnLimparTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTabelaActionPerformed
        limparTabela();
    }//GEN-LAST:event_btnLimparTabelaActionPerformed

    private void btnListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTodosActionPerformed
        atualizarTabela(false);
    }//GEN-LAST:event_btnListarTodosActionPerformed

    private void btnCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdutoActionPerformed
        control.Janelas.abrirCadastroPessoa();
    }//GEN-LAST:event_btnCadastrarProdutoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarRegistro();
    }//GEN-LAST:event_btnAlterarActionPerformed

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
    private javax.swing.JButton btnCadastrarCep;
    private javax.swing.JButton btnCadastrarProduto;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnDeletarTodosRegistros;
    private javax.swing.JButton btnFecharFrame;
    private javax.swing.JButton btnHoje;
    private javax.swing.JButton btnLimparTabela;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCelRamal;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCepExiste;
    private javax.swing.JLabel lblCpfCnpj;
    private javax.swing.JLabel lblCpfCnpjExiste;
    private javax.swing.JLabel lblDataCadastro;
    private javax.swing.JLabel lblDigiteODado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumeroLogradouro;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblPessoaJEncontrado;
    private javax.swing.JLabel lblRazaoSocial;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTipoPessoa1;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JPanel panPrincipal1;
    private javax.swing.JRadioButton rbtNaoCadastro;
    private javax.swing.JRadioButton rbtSimCadastro;
    private javax.swing.JTable tblListagemPessoaJ;
    private javax.swing.JTextField txtCelRamal;
    private javax.swing.JTextField txtCpfCnpj;
    private javax.swing.JTextField txtNomePessoaFicticio;
    private javax.swing.JTextField txtNumeroLogradouro;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtRazaoSocial;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JFormattedTextField txtfCep;
    private javax.swing.JFormattedTextField txtfDataCadastro;
    // End of variables declaration//GEN-END:variables
}
