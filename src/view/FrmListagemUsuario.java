/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.TextSize;
import dao.DaoFuncionario;
import dao.DaoUsuario;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Usuario;

/**
 *
 * @author Luiz
 */
public class FrmListagemUsuario extends javax.swing.JFrame {

    private boolean existeLogin;
    private boolean funcionarioExiste;
    private boolean ultimoTipoPesquisa;
    private String PK_REF;

    /**
     * Creates new form FrmListagemUsuario
     */
    public FrmListagemUsuario(int nvlAdm) {
        initComponents();
        inicializarTabela();
        definirNivelAcesso(nvlAdm);
    }
    DaoUsuario duser = new DaoUsuario();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panPrincipal = new javax.swing.JPanel();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();
        lblDigiteODado = new javax.swing.JLabel();
        lblPesquisar = new javax.swing.JLabel();
        pnlDadosFuncionario = new javax.swing.JPanel();
        lblExisteFuncionario = new javax.swing.JLabel();
        btnListarFuncionarios = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblCodFuncionario = new javax.swing.JLabel();
        txtCodFuncionario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblConfirmarSenha = new javax.swing.JLabel();
        txtConfirma = new javax.swing.JPasswordField();
        lblExisteLogin = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        btnLimparTabela = new javax.swing.JButton();
        btnListarTodos = new javax.swing.JButton();
        btnCadastrarProduto = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagemUsuario = new javax.swing.JTable();
        lblUsuarioEncontrado = new javax.swing.JLabel();
        btnDeletarTodosRegistros = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();
        btnFecharFrame = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Usuários");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logopng32.png")));
        setMaximumSize(new java.awt.Dimension(1152, 648));
        setMinimumSize(new java.awt.Dimension(1152, 648));
        setResizable(false);
        getContentPane().setLayout(null);

        panPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panPrincipal.setOpaque(false);
        panPrincipal.setLayout(null);

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código do Funcionário", "Login", "Senha" }));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        panPrincipal.add(cmbFiltro);
        cmbFiltro.setBounds(160, 10, 210, 25);

        txtPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPesquisaFocusGained(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        panPrincipal.add(txtPesquisa);
        txtPesquisa.setBounds(661, 10, 450, 25);

        lblDigiteODado.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblDigiteODado.setText("Digite o(a) Código do Funcionário:");
        panPrincipal.add(lblDigiteODado);
        lblDigiteODado.setBounds(375, 10, 290, 25);

        lblPesquisar.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar por: ");
        panPrincipal.add(lblPesquisar);
        lblPesquisar.setBounds(10, 10, 160, 25);

        pnlDadosFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Usuário"));
        pnlDadosFuncionario.setOpaque(false);
        pnlDadosFuncionario.setLayout(null);

        lblExisteFuncionario.setForeground(new java.awt.Color(255, 0, 0));
        lblExisteFuncionario.setText("Funcionário inexistente.");
        pnlDadosFuncionario.add(lblExisteFuncionario);
        lblExisteFuncionario.setBounds(332, 10, 170, 25);

        btnListarFuncionarios.setText("Listar Funcionários Cadastrados");
        btnListarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarFuncionariosActionPerformed(evt);
            }
        });
        pnlDadosFuncionario.add(btnListarFuncionarios);
        btnListarFuncionarios.setBounds(500, 7, 200, 30);

        lblLogin.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblLogin.setText("Login:");
        pnlDadosFuncionario.add(lblLogin);
        lblLogin.setBounds(10, 50, 170, 25);

        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginKeyReleased(evt);
            }
        });
        pnlDadosFuncionario.add(txtLogin);
        txtLogin.setBounds(190, 50, 316, 25);

        lblCodFuncionario.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblCodFuncionario.setText("Cód. do Funcionário:");
        pnlDadosFuncionario.add(lblCodFuncionario);
        lblCodFuncionario.setBounds(10, 10, 170, 25);

        txtCodFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodFuncionarioKeyReleased(evt);
            }
        });
        pnlDadosFuncionario.add(txtCodFuncionario);
        txtCodFuncionario.setBounds(190, 10, 140, 25);

        lblSenha.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblSenha.setText("Senha:");
        pnlDadosFuncionario.add(lblSenha);
        lblSenha.setBounds(10, 90, 170, 25);

        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaKeyReleased(evt);
            }
        });
        pnlDadosFuncionario.add(txtSenha);
        txtSenha.setBounds(190, 90, 316, 25);

        lblConfirmarSenha.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblConfirmarSenha.setText("Confirmar Senha:");
        pnlDadosFuncionario.add(lblConfirmarSenha);
        lblConfirmarSenha.setBounds(560, 90, 140, 25);

        txtConfirma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmaKeyReleased(evt);
            }
        });
        pnlDadosFuncionario.add(txtConfirma);
        txtConfirma.setBounds(730, 90, 316, 25);

        lblExisteLogin.setForeground(new java.awt.Color(255, 0, 0));
        lblExisteLogin.setText("Login Inválido.");
        pnlDadosFuncionario.add(lblExisteLogin);
        lblExisteLogin.setBounds(510, 50, 210, 25);

        panPrincipal.add(pnlDadosFuncionario);
        pnlDadosFuncionario.setBounds(10, 50, 1100, 130);

        btnDeletar.setText("Deletar registro selecionado");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        panPrincipal.add(btnDeletar);
        btnDeletar.setBounds(10, 190, 170, 30);

        btnLimparTabela.setText("Limpar tabela");
        btnLimparTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTabelaActionPerformed(evt);
            }
        });
        panPrincipal.add(btnLimparTabela);
        btnLimparTabela.setBounds(410, 190, 120, 30);

        btnListarTodos.setText("Listar todos os registros");
        btnListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTodosActionPerformed(evt);
            }
        });
        panPrincipal.add(btnListarTodos);
        btnListarTodos.setBounds(550, 190, 147, 30);

        btnCadastrarProduto.setText("Cadastrar novo Usuário");
        btnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutoActionPerformed(evt);
            }
        });
        panPrincipal.add(btnCadastrarProduto);
        btnCadastrarProduto.setBounds(720, 190, 150, 30);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        panPrincipal.add(btnAlterar);
        btnAlterar.setBounds(980, 190, 130, 30);

        getContentPane().add(panPrincipal);
        panPrincipal.setBounds(10, 10, 1125, 230);

        tblListagemUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListagemUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListagemUsuario);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 270, 1125, 270);

        lblUsuarioEncontrado.setFont(new java.awt.Font("Malgun Gothic", 0, 18)); // NOI18N
        lblUsuarioEncontrado.setText("Usuários encontrados no banco de dados. Para visualizar ou alterar um registro, clique em um registro exibido na tabela.");
        getContentPane().add(lblUsuarioEncontrado);
        lblUsuarioEncontrado.setBounds(10, 240, 1040, 25);

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

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, -20, 1150, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        lblDigiteODado.setText("Digite o(a) " + cmbFiltro.getSelectedItem().toString() + ":");
        limiteDigitosPesquisa(cmbFiltro.getSelectedItem().toString());
        txtPesquisa.requestFocus();
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        limiteDigitosPesquisa(cmbFiltro.getSelectedItem().toString());
        pesquisarFiltrada();
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void tblListagemUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemUsuarioMouseClicked
        popularCampos();
    }//GEN-LAST:event_tblListagemUsuarioMouseClicked

    private void btnDeletarTodosRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarTodosRegistrosActionPerformed
        removerTodosRegistros();
    }//GEN-LAST:event_btnDeletarTodosRegistrosActionPerformed

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
        control.Janelas.focarPrincipal();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnFecharFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharFrameActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharFrameActionPerformed

    private void btnListarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarFuncionariosActionPerformed
        control.Janelas.abrirListagemFuncionario();
    }//GEN-LAST:event_btnListarFuncionariosActionPerformed

    private void txtLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyReleased
        txtLogin.setText(TextSize.maxLenghtLogin(txtLogin.getText()));
        verificarLogin();
    }//GEN-LAST:event_txtLoginKeyReleased

    private void txtCodFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodFuncionarioKeyReleased
        txtCodFuncionario.setText(TextSize.maxLenghtFuncionario(txtCodFuncionario.getText()));
        verificarFuncionario();
    }//GEN-LAST:event_txtCodFuncionarioKeyReleased

    private void txtSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyReleased
        txtSenha.setText(TextSize.maxLenghtSenha(txtSenha.getText()));
    }//GEN-LAST:event_txtSenhaKeyReleased

    private void txtConfirmaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmaKeyReleased
        txtConfirma.setText(TextSize.maxLenghtSenha(txtConfirma.getText()));
    }//GEN-LAST:event_txtConfirmaKeyReleased

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
        control.Janelas.abrirCadastroUsuario();
    }//GEN-LAST:event_btnCadastrarProdutoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterarRegistro();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPesquisaFocusGained
        limiteDigitosPesquisa(cmbFiltro.getSelectedItem().toString());
        pesquisarFiltrada();
        txtPesquisa.selectAll();
    }//GEN-LAST:event_txtPesquisaFocusGained

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
            java.util.logging.Logger.getLogger(FrmListagemUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListagemUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListagemUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListagemUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListagemUsuario(control.SynchroSoft.getNvlAdm()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrarProduto;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnDeletarTodosRegistros;
    private javax.swing.JButton btnFecharFrame;
    private javax.swing.JButton btnLimparTabela;
    private javax.swing.JButton btnListarFuncionarios;
    private javax.swing.JButton btnListarTodos;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCodFuncionario;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblDigiteODado;
    private javax.swing.JLabel lblExisteFuncionario;
    private javax.swing.JLabel lblExisteLogin;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuarioEncontrado;
    private javax.swing.JPanel panPrincipal;
    private javax.swing.JPanel pnlDadosFuncionario;
    private javax.swing.JTable tblListagemUsuario;
    private javax.swing.JTextField txtCodFuncionario;
    private javax.swing.JPasswordField txtConfirma;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    private void inicializarTabela() {
        String[] nomeColunas = {"Código do Funcionário", "Login", "Senha"};
        try {
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            tblListagemUsuario.setModel(model);
            model.setColumnIdentifiers(nomeColunas);
            model.setRowCount(0);
            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao popular a tabela de usuários. \n\n" + ex.getMessage(), "Erro de população de tabela", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Define dinamicamente o limite de caracteres do campo de pesquisa
     * filtrada. O metodo apropriado da classe TextSize é chamado com base no
     * ítem selecionado na combo box que define o filtro.
     *
     * @param filtro Texto do filtro selecionado. Valores possíveis: Código do
     * Funcionário, Login, Senha
     */
    private void limiteDigitosPesquisa(String filtro) {
        switch (filtro) {
            case "Código do Funcionário":
                txtPesquisa.setText(control.TextSize.maxLenghtFuncionario(txtPesquisa.getText()));
                break;
            case "Login":
                txtPesquisa.setText(control.TextSize.maxLenghtLogin(txtPesquisa.getText()));
                break;
            case "Senha":
                txtPesquisa.setText(control.TextSize.maxLenghtSenha(txtPesquisa.getText()));
                break;
            default:
                JOptionPane.showMessageDialog(this, "Erro ao definir limite de caracteres do campo de pesquisa.",
                        "Erro - limite de dígitos dinâmico", 0);
                break;
        }
    }

    /**
     * Inicia o procedimento para atualizar a tabela através de uma busca
     * filtrada. O método da listagemFiltrada só é chamado caso o campo de texto
     * não esteja vazio.
     */
    private void pesquisarFiltrada() {
        try {
            /*
            Caso o campo de pesquisa esteja populado, o método de atualização é chamado.
            Caso não, a tabela é esvaziada.
             */
            if (!"".equals(txtPesquisa.getText().trim())) {
                atualizarTabela(true);
            } else {
                limparTabela();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao atualizar a tabela por filtro.\n\n"
                    + ex, "Erro ao popular tabela", 0);
        }
    }
    
    private void atualizarTabela(boolean filtrada) {
        /*
        Cria um novo modelo de tabela do tipo DefaultTableModel, baseado no modelo
        atual da tabela, definido no metodo inicializarTabela.
         */
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblListagemUsuario.getModel();
        model.setRowCount(0);
        /*
        Instanciamento do ArrayList lista, do tipo Usuario.
         */
        ArrayList<Usuario> lista = new ArrayList<>();
        /*
        Caso seja uma atualização por filtro, chama o metodo listarPecaFiltrada() 
        e define que o último tipo de pesquisa foi por filtro (ultimoTipoPesquisa = true).
        Caso não, chama o método listarPeca, que popula a lista com todos os dados
        armazenados no banco de dados, e define que o último tipo de pesquisa foi listar todos
        (ultimoTipoPesquisa = false).
         */
        if (filtrada) {
            lista = DaoUsuario.listarUsuarioFiltrada((String) cmbFiltro.getSelectedItem(), txtPesquisa.getText().toLowerCase().trim());
            ultimoTipoPesquisa = true;
        } else {
            lista = DaoUsuario.listarUsuario();
            ultimoTipoPesquisa = false;
        }
        /*
        Instanciamento do array dadosLinha do tipo Object. O tipo Object é genérico.
        Nele será atribuido cada atributo do objeto Usuario.
         */
        Object dadosLinha[] = new Object[3];
        /*
        Um laço de repetição para adicionar linhas a tabela.
        O for percorre até o último índice da lista, especificado pela chamada do 
        método .size(), que retorna o tamanho do ArrayList lista.
        Cada posição do array dadosLinha é populado com os dados do objeto Usuario
        presente na lista.
         */
        for (int i = 0; i < lista.size(); i++) {
            dadosLinha[0] = lista.get(i).getCodigoFuncionario();
            dadosLinha[1] = lista.get(i).getLogin();
            dadosLinha[2] = lista.get(i).getSenha();
            model.addRow(dadosLinha);
        }
        //String[] nomeColunas = {"Código", "Nome", "Categoria", "Quantidade", "Alerta Qtd Mínima", "Alerta Qtd Máxima", "Valor Unitário", "PK Ref"};
        /*
        Remove os dados do campo selecionado anteriormente.
         */
        limparCampos();
    }

    private void verificarLogin() {
        if (txtLogin.getText().length() < 4) {
            lblExisteLogin.setText("Login Inválido.");
            lblExisteLogin.setForeground(Color.red);
            existeLogin = true;
        } else {
            this.existeLogin = dao.DaoUsuario.existeLogin(txtLogin.getText());
            if (existeLogin) {
                lblExisteLogin.setText("Login já em uso!");
                lblExisteLogin.setForeground(Color.red);
                existeLogin = false;
            } else {
                lblExisteLogin.setText("Login disponível.");
                lblExisteLogin.setForeground(Color.black);
                existeLogin = false;
            }
        }
    }

    private void verificarFuncionario() {
        if (txtCodFuncionario.getText().equals("")) {
            lblExisteFuncionario.setText("Funcionário Inválido.");
            lblExisteFuncionario.setForeground(Color.red);
            this.funcionarioExiste = true;
        } else {
            this.funcionarioExiste = DaoFuncionario.existeFuncionario(txtCodFuncionario.getText());
            if (this.funcionarioExiste) {
                lblExisteFuncionario.setText("Funcionário encontrado.");
                lblExisteFuncionario.setForeground(Color.BLACK);
                this.funcionarioExiste = false;
            } else {
                this.funcionarioExiste = true;
                lblExisteFuncionario.setText("Funcionário Inexistente.");
                lblExisteFuncionario.setForeground(Color.red);
            }
        }
    }

    /**
     * Limpa todos os campos da janela e atualiza o status do Código informado,
     * para fins estéticos e de validação.
     */
    private void limparCampos() {
        txtCodFuncionario.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtConfirma.setText("");
        PK_REF = null;
        verificarFuncionario();
        verificarLogin();        
    }
    
    /**
     * Esvazia todo o conteúdo da tabela e limpa os campos.
     */
    private void limparTabela() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tblListagemUsuario.getModel();
        model.setRowCount(0);
        /*
        Chama o metodo limparCampos para limpar os dados do registro anteriormente
        selecionado.
         */
        limparCampos();
    }
    
    private void alterarRegistro() {
        if (validarCampos()) {
            Usuario usuario = new Usuario();

            usuario.setCodigoFuncionario(txtCodFuncionario.getText());
            usuario.setLogin(txtLogin.getText());
            usuario.setSenha(txtSenha.getText());
            /*
            String de controle PK_REF. Seu valor é baseado no campo oculto PK_REF da tabela.
            Irá armazenar o código original, inalterado, da linha selecionada. Esse valor
            será utilizado na cláusula WHERE da query no banco, pois é possível que
            usuário altere o código do registro selecionado, sendo o PK_REF
            a referência da Primary Key (código original)
             */
            boolean alteracaoSucedida;
            alteracaoSucedida = dao.DaoUsuario.alterarUsuario(usuario, PK_REF);

            if (alteracaoSucedida) {
                atualizarTabela(ultimoTipoPesquisa);
                limparCampos();
            }
        }
    }
    
    private boolean validarCampos() {
        boolean selectionEmpty = tblListagemUsuario.getSelectionModel().isSelectionEmpty();
        if (selectionEmpty) {
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado da tabela.\n\n"
                    + "Pesquise por algum registro e clique em alguma linha da tabela.", "Erro - Não há registro selecionado", 0);
            return false;
        } else if (txtLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Login em branco. "
                    + "\n\nInforme o Login a ser utilizado pelo Usuário.",
                    "Erro - Login Inválido", 0);
            txtLogin.requestFocus();
            return false;
        } else if (txtLogin.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Login Inválido. "
                    + "\n\nInforme um Login com pelo menos 4 caractéres.",
                    "Erro - Login Inválido", 0);
            txtLogin.requestFocus();
            return false;
        } else if (existeLogin) {
            JOptionPane.showMessageDialog(null, "Login Inválido. "
                    + "\n\nO Login informado já está em uso. Digite um Login diferente.",
                    "Erro - Login Inválido", 0);
            txtLogin.requestFocus();
            return false;
        } else if (txtSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Senha em branco. "
                    + "\n\nInforme a Senha a ser utilizada pelo Usuário.",
                    "Erro - Senha Inválida", 0);
            txtSenha.requestFocus();
            return false;
        } else if (txtConfirma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Confirmação da senha em branco. "
                    + "\n\nInforme a confirmação da Senha igual ao campo de Senha informado.",
                    "Erro - Confirmação de Senha Inválida", 0);
            txtConfirma.requestFocus();
            return false;
        } else if (txtSenha.getText().length() < 4) {
            JOptionPane.showMessageDialog(null, "Senha Inválida. "
                    + "\n\nInforme uma senha com pelo menos 4 caractéres.",
                    "Erro - Senha Inválida", 0);
            txtSenha.requestFocus();
            return false;
        } else if (!txtConfirma.getText().equals(txtSenha.getText())) {
            JOptionPane.showMessageDialog(null, "A Confirmação da Senha está diferente da Senha informada. "
                    + "\n\nInforme a confirmação da Senha igual ao campo de Senha informado.",
                    "Erro - Razão Social Inválido", 0);
            txtSenha.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    private void popularCampos() {

        Usuario usuario = new Usuario();

        String login = (String) tblListagemUsuario.getValueAt(tblListagemUsuario.getSelectedRow(), 1);

        usuario = dao.DaoUsuario.popularUsuario(login);

        txtCodFuncionario.setText(usuario.getCodigoFuncionario());
        txtLogin.setText(usuario.getLogin());
        txtSenha.setText(usuario.getSenha());
        txtConfirma.setText(usuario.getSenha());
        PK_REF = usuario.getLogin();
        verificarLogin();
    }

    private void deletarRegistro() {
        /*
        Variável de controle opcao. Armazena o retorno do JOPtionPane.
        O mesmo retorna 0 quando a opção SIM/YES é selecionada,
        1 para quando a opção NÃO/NO é selecionada.
         */
        int opcao;
        opcao = JOptionPane.showConfirmDialog(this, "Atenção! Todos os registros relacionados ao login "
                + ((String) tblListagemUsuario.getValueAt(tblListagemUsuario.getSelectedRow(), 1))
                + " serão permanentemente removidos.\n\nDeseja realmente excluir o registro?",
                "Confirmação de exclusão",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        /*
        Caso a opção SIM seja selecionada, o atributo código é populado do objeto 
        produto, e o mesmo é passado como parâmetro para o metodo deletarPeca.
        Após a execução do método, a tabela é atualizada de acordo com o último
        tipo de pesquisa realizada.
        ultimoTipoPesquisa - true = filtrada. false = listar todos.
         */
        if (opcao == 0) {
            Usuario usuario = new Usuario();
            usuario.setLogin((String) tblListagemUsuario.getValueAt(tblListagemUsuario.getSelectedRow(), 1));
            dao.DaoUsuario.deletarUsuario(usuario.getLogin());
            atualizarTabela(ultimoTipoPesquisa);
            limparCampos();
        }
    }

    private void removerTodosRegistros() {
        int opcao;
        opcao = JOptionPane.showConfirmDialog(this, "Deseja REALMENTE remover todos os usuários do banco de dados?\n\n",
                "Alerta - remoção de todos os registros", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == 0) {
            opcao = JOptionPane.showConfirmDialog(this, "Essa operação tem grandes chances de falhar, devido a existência\n"
                    + "de restrições de chaves estrangeiras no banco de dados.\n\n"
                    + "Deseja REALMENTE tentar excluir todos os registros do banco de dados?\n\n"
                    + "Caso a operação suceda, todos os dados serão permanentemente excluídos.\n"
                    + "Caso ela falhe, talvez alguns registros possam ter sidos excluidos, e outros não."
                    + "\n\n"
                    + "Deseja prosseguir?",
                    "Alerta - remoção de todos os registros", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcao == 0) {
                boolean exclusaoSucedida;
                exclusaoSucedida = dao.DaoUsuario.deletarTodosUsuarios();
                if (exclusaoSucedida) {
                    atualizarTabela(ultimoTipoPesquisa);
                }
            }
        }
    }
    private void definirNivelAcesso(int nvlAdm) {
        if (nvlAdm == 0) {
            btnDeletarTodosRegistros.setEnabled(false);
            btnAlterar.setEnabled(false);
            btnDeletar.setEnabled(false);
            btnCadastrarProduto.setEnabled(false);
            cmbFiltro.setEnabled(false);
            txtPesquisa.setEnabled(false);
            btnListarTodos.setEnabled(false);
        }
    }
}
