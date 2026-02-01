package academia_dev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author FabricioSimoes
 */
public class telaCadFuncionarios extends javax.swing.JFrame {
   String operacao;
   private final String nomeArquivo = "arquivos/funcionarios.txt";
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(telaCadFuncionarios.class.getName());

    /**
     * Creates new form telaCadastro
     */
    public telaCadFuncionarios() {
        initComponents();
        setLocationRelativeTo(null); //Centraliza na tela
        habilitarBotoes(false);
        lerArquivoTexto();
        limparCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupSexo = new javax.swing.ButtonGroup();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        radMasculino = new javax.swing.JRadioButton();
        radFeminino = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFuncao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboEstCivil = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCarteiraTrab = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPisPasep = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ckbIngles = new javax.swing.JCheckBox();
        ckbEspanhol = new javax.swing.JCheckBox();
        ckbFrances = new javax.swing.JCheckBox();
        ckbItaliano = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabFuncionario = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnConsultarFun = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblCodigo1 = new javax.swing.JLabel();
        txtCodigoFun = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNomeFun = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtCPFFun = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDataNascimentoFun = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        radMasculinoFun = new javax.swing.JRadioButton();
        radFemininoFun = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        txtTelefoneFun = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtFuncaoFun = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cmbEstCivilFun = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtCarteiraTrabFun = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        txtEnderecoFun = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtPesquisaFun = new javax.swing.JTextField();
        ckbInglesFun = new javax.swing.JCheckBox();
        ckbEspanholFun = new javax.swing.JCheckBox();
        ckbFrancesFun = new javax.swing.JCheckBox();
        ckbItalianoFun = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        lblCodigo.setText("Código");

        jLabel6.setText("Nome do Funcionário");

        jLabel3.setText("CPF");

        jLabel4.setText("Data de Nascimento (dd/mm/aaaa)");

        jLabel1.setText("Sexo");

        radMasculino.setText("Masculino");
        radMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMasculinoActionPerformed(evt);
            }
        });

        radFeminino.setText("Feminino");

        jLabel7.setText("Telefone (What'sApp)");

        jLabel8.setText("Função");

        jLabel5.setText("Estado Civíl");

        jComboEstCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Casado", "Viúvo", "Divorciado" }));
        jComboEstCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEstCivilActionPerformed(evt);
            }
        });

        jLabel11.setText("Carteira de Trabalho");

        jLabel9.setText("PIS/PASEP");

        jLabel12.setText("Endereço Completo");

        jLabel13.setText("Idiomas");

        ckbIngles.setText("Inglês");

        ckbEspanhol.setText("Espanhol");
        ckbEspanhol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbEspanholActionPerformed(evt);
            }
        });

        ckbFrances.setText("Francês");

        ckbItaliano.setText("Italiano");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionários");
        setMinimumSize(new java.awt.Dimension(1000, 625));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Nascimento", "Idioma", "Sexo", "Telefone", "Função", "Cart.Trabalho", "Est. Civíl", "Endereço"
            }
        ));
        tabFuncionario.setAutoResizeMode(0);
        tabFuncionario.setAutoscrolls(false);
        tabFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabFuncionarioMouseClicked(evt);
            }
        });
        tabFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabFuncionarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabFuncionario);
        if (tabFuncionario.getColumnModel().getColumnCount() > 0) {
            tabFuncionario.getColumnModel().getColumn(0).setMinWidth(70);
            tabFuncionario.getColumnModel().getColumn(1).setMinWidth(200);
            tabFuncionario.getColumnModel().getColumn(2).setMinWidth(100);
            tabFuncionario.getColumnModel().getColumn(3).setMinWidth(100);
            tabFuncionario.getColumnModel().getColumn(4).setMinWidth(200);
            tabFuncionario.getColumnModel().getColumn(5).setMinWidth(100);
            tabFuncionario.getColumnModel().getColumn(6).setMinWidth(100);
            tabFuncionario.getColumnModel().getColumn(6).setMaxWidth(150);
            tabFuncionario.getColumnModel().getColumn(7).setMinWidth(100);
            tabFuncionario.getColumnModel().getColumn(8).setMinWidth(100);
            tabFuncionario.getColumnModel().getColumn(9).setMinWidth(100);
            tabFuncionario.getColumnModel().getColumn(10).setMinWidth(450);
            tabFuncionario.getColumnModel().getColumn(10).setMaxWidth(500);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 950, 160));

        btnAtualizar.setBackground(new java.awt.Color(54, 70, 78));
        btnAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setBorderPainted(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 90, -1));

        btnCadastrar.setBackground(new java.awt.Color(54, 70, 78));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));

        btnExcluir.setBackground(new java.awt.Color(54, 70, 78));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorderPainted(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 90, -1));

        btnCancelar.setBackground(new java.awt.Color(54, 70, 78));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 90, -1));

        btnSalvar.setBackground(new java.awt.Color(54, 70, 78));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.setBorderPainted(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1000, 230));

        btnConsultarFun.setBackground(new java.awt.Color(54, 70, 78));
        btnConsultarFun.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultarFun.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarFun.setText("Consultar");
        btnConsultarFun.setBorderPainted(false);
        btnConsultarFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarFunActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, -1, -1));

        btnSair.setBackground(new java.awt.Color(54, 70, 78));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        lblCodigo1.setText("Código");
        getContentPane().add(lblCodigo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));
        getContentPane().add(txtCodigoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 90, -1));

        jLabel14.setText("Nome do Funcionário");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));
        getContentPane().add(txtNomeFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 200, -1));

        jLabel15.setText("CPF");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        try {
            txtCPFFun.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtCPFFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 140, -1));

        jLabel16.setText("Data de Nascimento ");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        try {
            txtDataNascimentoFun.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtDataNascimentoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 120, -1));

        jLabel17.setText("Sexo");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        GroupSexo.add(radMasculinoFun);
        radMasculinoFun.setSelected(true);
        radMasculinoFun.setText("Masculino");
        radMasculinoFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMasculinoFunActionPerformed(evt);
            }
        });
        getContentPane().add(radMasculinoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        GroupSexo.add(radFemininoFun);
        radFemininoFun.setText("Feminino");
        getContentPane().add(radFemininoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        resultArea.setColumns(20);
        resultArea.setRows(5);
        resultArea.setBorder(null);
        jScrollPane2.setViewportView(resultArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 460, 210));

        jLabel18.setText("Telefone (What'sApp)");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        try {
            txtTelefoneFun.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtTelefoneFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 140, -1));

        jLabel19.setText("Função");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));
        getContentPane().add(txtFuncaoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 140, -1));

        jLabel20.setText("Estado Civíl");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        cmbEstCivilFun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro", "Casado", "Viúvo", "Divorciado" }));
        cmbEstCivilFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstCivilFunActionPerformed(evt);
            }
        });
        getContentPane().add(cmbEstCivilFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));

        jLabel21.setText("Carteira de Trabalho");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        try {
            txtCarteiraTrabFun.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###### #### ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtCarteiraTrabFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 140, -1));

        jLabel23.setText("Endereço Completo");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, -1, -1));
        getContentPane().add(txtEnderecoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 200, -1));

        jLabel24.setText("Idiomas");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, -1));
        getContentPane().add(txtPesquisaFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 370, -1));

        ckbInglesFun.setText("Inglês");
        getContentPane().add(ckbInglesFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, -1));

        ckbEspanholFun.setText("Espanhol");
        ckbEspanholFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbEspanholFunActionPerformed(evt);
            }
        });
        getContentPane().add(ckbEspanholFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, -1, -1));

        ckbFrancesFun.setText("Francês");
        ckbFrancesFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbFrancesFunActionPerformed(evt);
            }
        });
        getContentPane().add(ckbFrancesFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        ckbItalianoFun.setText("Italiano");
        getContentPane().add(ckbItalianoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 70, -1, -1));

        jPanel1.setBackground(new java.awt.Color(54, 70, 78));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cadastro de Funcionários");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 5, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Fundo.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1000, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radMasculinoActionPerformed

    private void jComboEstCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEstCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEstCivilActionPerformed

    private void ckbEspanholActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbEspanholActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbEspanholActionPerformed

    private void radMasculinoFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMasculinoFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radMasculinoFunActionPerformed

    private void cmbEstCivilFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstCivilFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstCivilFunActionPerformed

    private void ckbEspanholFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbEspanholFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbEspanholFunActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if(txtCodigoFun.getText().trim().isEmpty()){ // retira os espacamentos e verifica se o campo está vazio.
            JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja editar");
        }else{
            operacao="atualizar";
            habilitarBotoes(true);
            txtNomeFun.requestFocus();//Colocar o foco no campo Nome.
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        habilitarBotoes(true); 
        limparCampos();
        operacao="cadastrar";
        txtCodigoFun.requestFocus(); // Coloca o foco de volta no campo txtCodigo       
    }//GEN-LAST:event_btnCadastrarActionPerformed
      
        //--------------------------------------------------------------
    private void inserirRegistroTabela(){
       
        String codigo = txtCodigoFun.getText();
        String nome = txtNomeFun.getText();
        String CPF = txtCPFFun.getText();
        String nascimento = txtDataNascimentoFun.getText();
        String idioma="", sexo;
        String telefone = txtTelefoneFun.getText();
        String funcao = txtFuncaoFun.getText();
        String carteiraTrab = txtCarteiraTrabFun.getText();
        String estCivil = cmbEstCivilFun.getSelectedItem().toString();
        String endereco = txtEnderecoFun.getText();
    
        //--------------------------------------------------------------
    
        if (radMasculinoFun.isSelected())
            sexo = "Masculino";
        else
            sexo = "Feminino";
        //---------------------------------------
        if(ckbInglesFun.isSelected())
            idioma += " Inglês";
        if(ckbFrancesFun.isSelected())
            idioma += " Francês";
        if(ckbEspanholFun.isSelected())
            idioma += " Espanhol";
        if(ckbItalianoFun.isSelected())
            idioma += " Italiano";
        
        if(idioma.isEmpty())
            idioma = "Não Selecionado";
        //---------------------------------------
    
        DefaultTableModel dtm_funcionario = (DefaultTableModel) tabFuncionario.getModel();
        //Object[] Vetor que pode guardar qualquer tipo(String, Integer, Float, etc)
        Object[] dados = {codigo,nome,CPF,nascimento,idioma,sexo,telefone,funcao,carteiraTrab,estCivil,endereco};//cria um array
        if (operacao.equals("cadastrar")){
            dtm_funcionario.addRow(dados);
        }else if(operacao.equals("atualizar")){
            int linha = tabFuncionario.getSelectedRow(); //linha selecionada
            //Alualiza coluna a coluna usando array
            for (int i = 0; i < dados.length; i++) {
                dtm_funcionario.setValueAt(dados[i], linha, i);
            }
        } 
    }
    
    public void lerArquivoTexto(){
        try{
            File arquivo = new File(nomeArquivo);
            
            if(arquivo.exists()){
                FileReader fileReader = new FileReader(arquivo);
                BufferedReader reader = new BufferedReader(fileReader);
                
                String linha;
                DefaultTableModel dtm_funcionario = (DefaultTableModel)tabFuncionario.getModel();
                
                dtm_funcionario.setRowCount(0); // Limpar antes de carregar
                
                while ((linha = reader.readLine()) != null){
                String[] dados = linha.split(";", -1);
                dtm_funcionario.addRow(dados);
                }
                
                reader.close();
                fileReader.close();
                
            }
            
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo de dados não encontrado.");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
        }
    }
    
    public void salvarFuncionarioArqTexto()throws IOException{
    
        String linha;
        BufferedWriter w_funcionario = new BufferedWriter(new FileWriter(nomeArquivo));//abre o arquivo para escrita, apagando todo seu conteúdo,
        DefaultTableModel dtm_funcionarios = (DefaultTableModel) tabFuncionario.getModel();
        int linhasTabela = dtm_funcionarios.getRowCount(); //quantidade de linhas na tabela
        
        try{
            for (int i=0; i<linhasTabela; i++){
                Object codigo = dtm_funcionarios.getValueAt(i, 0);
                Object nome = dtm_funcionarios.getValueAt(i, 1);
                Object cpf = dtm_funcionarios.getValueAt(i, 2);
                Object nascimento = dtm_funcionarios.getValueAt(i, 3);
                Object idiomas = dtm_funcionarios.getValueAt(i, 4);
                Object sexo = dtm_funcionarios.getValueAt(i, 5);
                Object telefone = dtm_funcionarios.getValueAt(i, 6);
                Object funcao = dtm_funcionarios.getValueAt(i, 7);
                Object carteira = dtm_funcionarios.getValueAt(i, 8);
                Object estadoCivil = dtm_funcionarios.getValueAt(i, 9);
                Object endereco = dtm_funcionarios.getValueAt(i, 10);

                String linhaParaGravar = codigo + ";" + nome + ";" + cpf + ";" + nascimento + ";" + 
                                     idiomas + ";" + sexo + ";" + telefone + ";" + funcao + ";" + 
                                     carteira + ";" + estadoCivil + ";" + endereco;
                w_funcionario.write(linhaParaGravar); //grava a linha no arquivo cliente.txt
                w_funcionario.newLine(); //cria (pula para) nova linha
            }
            w_funcionario.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo" + e.getMessage());
        }
            
    }
    
    private void limparCampos(){
    //Limpar o conteúdo dos componentes
    txtCodigoFun.setText("");
    txtNomeFun.setText("");
    txtCPFFun.setText("");
    txtDataNascimentoFun.setText("");
    ckbInglesFun.setSelected(false);
    ckbFrancesFun.setSelected(false);
    ckbEspanholFun.setSelected(false);
    ckbItalianoFun.setSelected(false);
    txtTelefoneFun.setText("");
    txtFuncaoFun.setText("");
    txtCarteiraTrabFun.setText("");
    txtCarteiraTrabFun.setText("");
    txtEnderecoFun.setText("");
    }
           
    private void carregarDados(){
        int lin = tabFuncionario.getSelectedRow(); //Obtém o número de linhas
        if(lin != -1){
            txtCodigoFun.setText((String) tabFuncionario.getValueAt(lin, 0));
            txtNomeFun.setText((String) tabFuncionario.getValueAt(lin, 1));
            txtCPFFun.setText((String) tabFuncionario.getValueAt(lin, 2));
            txtDataNascimentoFun.setText((String) tabFuncionario.getValueAt(lin, 3));
            txtTelefoneFun.setText((String) tabFuncionario.getValueAt(lin, 6));
            txtFuncaoFun.setText((String) tabFuncionario.getValueAt(lin, 7));
            txtCarteiraTrabFun.setText((String) tabFuncionario.getValueAt(lin, 8));
            
            String estadoCivil = (String) tabFuncionario.getValueAt(lin, 9);
            cmbEstCivilFun.setSelectedItem(estadoCivil);
            
            txtEnderecoFun.setText((String) tabFuncionario.getValueAt(lin, 10));
            String sexo = (String) tabFuncionario.getValueAt(lin, 5);
            if (sexo.equalsIgnoreCase("Masculino")){
                radMasculinoFun.setSelected(true);
            }else {
                radFemininoFun.setSelected(true);
            }
            
            String idiomas = (String) tabFuncionario.getValueAt(lin, 4);
            
            if (idiomas.contains("Inglês")) 
                ckbInglesFun.setSelected(true);
            if (idiomas.contains("Francês"))
                ckbFrancesFun.setSelected(true);
            if (idiomas.contains("Espanhol"))
                ckbEspanholFun.setSelected(true);
            if (idiomas.contains("Italiano"))
                ckbItalianoFun.setSelected(true);
        }
    }
            
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        excluir();
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConsultarFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarFunActionPerformed
        // TODO add your handling code here:
        buscarFuncionario(txtPesquisaFun.getText());
        txtPesquisaFun.setText("");
    }//GEN-LAST:event_btnConsultarFunActionPerformed

    private void excluir(){       
        int linhaSelecionada = tabFuncionario.getSelectedRow();//pega a linha selecionada
        //-----
        if (linhaSelecionada == -1) { //Nenhuma linha foi selecionada
            JOptionPane.showMessageDialog(
                    null, 
                    "Selecione uma linha para excluir.",
                    "aviso",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }else{    
            int confirma = JOptionPane.showConfirmDialog(
                    null,
                    "Confirma exclusão do registro?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
                );
            if (confirma == JOptionPane.YES_OPTION) { //Se o usuário clicou no botão "Yes"
                //excluir linha da tabela;
                DefaultTableModel dtm_funcionario = (DefaultTableModel) tabFuncionario.getModel();
                    dtm_funcionario.removeRow(linhaSelecionada);
                    //------
                    
                try {
                    salvarFuncionarioArqTexto(); //transfere os dados da table para o arquivo texto
                } catch (IOException ex) {
                    Logger.getLogger(telaCadFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                }
                    JOptionPane.showMessageDialog(
                        null, 
                        "Registro excluído com sucesso!", 
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE
                    );
            }else{  //O usuário clicou no botão "No"
                JOptionPane.showMessageDialog(
                    null,
                    "Exclusão cancelada!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
    
    private void habilitarBotoes(boolean valor){
    btnSalvar.setEnabled(valor);
    btnCancelar.setEnabled(valor);
    btnCadastrar.setEnabled(!valor);
    btnAtualizar.setEnabled(!valor);
    btnExcluir.setEnabled(!valor);
    btnSair.setEnabled(!valor);
    
    txtCodigoFun.setEnabled(valor);
    txtNomeFun.setEnabled(valor);
    txtCPFFun.setEnabled(valor);
    txtDataNascimentoFun.setEnabled(valor);
    txtTelefoneFun.setEnabled(valor);
    txtFuncaoFun.setEnabled(valor);
    txtCarteiraTrabFun.setEnabled(valor);
    txtEnderecoFun.setEnabled(valor);
    }
    
    public boolean validarDados(){
        boolean valido = true;
        String codigo = txtCodigoFun.getText();
        String nome = txtNomeFun.getText();
        String CPF = txtCPFFun.getText();
        String nascimento = txtDataNascimentoFun.getText();
        String telefone = txtTelefoneFun.getText();
        String funcao = txtFuncaoFun.getText();
        String cartTrab = txtCarteiraTrabFun.getText();
        String endereco = txtEnderecoFun.getText();
         //-------
        if (!codigo.trim().isEmpty() && //trim: retira espaços em branco. lenght: tamanho em qtde de caracteres.
                !nome.trim().isEmpty() && 
                !CPF.trim().isEmpty() && 
                !nascimento.trim().isEmpty() && 
                !telefone.trim().isEmpty()&& 
                !funcao.trim().isEmpty()&& 
                !cartTrab.trim().isEmpty()&& 
                !endereco.trim().isEmpty()) {  //Se código e nome estão preenchids
            valido=true;
            try {
                Integer.valueOf(txtCodigoFun.getText()); //transforma de Object para número inteiro.
            } catch (NumberFormatException e) {
                valido = false;
                JOptionPane.showMessageDialog(
                    null,
                    "Campo código, CPF, Data Nascimento, Telefone e Endereço deve ser apenas numéros",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        }else{
            valido=false;
            JOptionPane.showMessageDialog(
                    null,
                    "Preencha todos os campos obrigatórios",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        return valido;
    }
    
    private String retiraAcentos(String texto) {
        /*
        Essa função serve para remover acentos e caracteres especiais, deixando o texto 
        “puro”, o que facilita comparações e buscas. Esse método separa as letras dos acentos.
        NFD = Normalization Form Decomposition
        .replaceAll("\\p{M}", "") => Remove os acentos, trocando-os por ""
        */
        return java.text.Normalizer
            .normalize(texto, java.text.Normalizer.Form.NFD)
            .replaceAll("\\p{M}", ""); // Remove os acentos, trocando-os por ""
    }
    
    private void buscarFuncionario(String nomePesquisa) {
        // Verifica se usuário digitou nome para pesquisa
        if (nomePesquisa == null || nomePesquisa.trim().isEmpty()) {
            resultArea.setText("Digite um nome para pesquisar.");
            return;
        }
        //Chama o método que retira acentos do nome digitado pelo usuário
        nomePesquisa = retiraAcentos(nomePesquisa).toLowerCase();

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("R E S U L T A D O   D A   P E S Q U I S A:\n");
        relatorio.append("===========================================\n");

        DefaultTableModel dtm_funcionario = (DefaultTableModel) tabFuncionario.getModel();
        boolean encontrou = false;

        // Percorre as linhas da tabela tabClientes
        for (int i = 0; i < dtm_funcionario.getRowCount(); i++) {
            String codigo = String.valueOf(dtm_funcionario.getValueAt(i, 0));
            String nome   = String.valueOf(dtm_funcionario.getValueAt(i, 1));
            String CPF    = String.valueOf(dtm_funcionario.getValueAt(i, 2));
            String nascimento = String.valueOf(dtm_funcionario.getValueAt (i, 3));
            String idioma = String.valueOf(dtm_funcionario.getValueAt(i, 4));
            String sexo   = String.valueOf(dtm_funcionario.getValueAt(i, 5));
            String telefone = String.valueOf(dtm_funcionario.getValueAt(i, 6));
            String funcao = String.valueOf(dtm_funcionario.getValueAt(i, 7));
            String carteiraTrab = String.valueOf(dtm_funcionario.getValueAt(i, 8));
            String estCivil = String.valueOf(dtm_funcionario.getValueAt(i, 9));
            String endereco = String.valueOf(dtm_funcionario.getValueAt(i, 10));
            

            // Chama o método que retira acentos do nome extraído da tabela
            String nomeSemAcento = retiraAcentos(nome).toLowerCase();

            //Verifica correspondência
            if (nomeSemAcento.contains(nomePesquisa)) {
                relatorio   .append("   - Código: ").append(codigo).append(" - ")
                            .append(nome).append("\n")
                            .append("   - CPF: ").append(CPF).append("\n")
                            .append("   - Data Nascimento: ").append(nascimento).append("\n")
                            .append("   - Idioma: ").append(idioma).append("\n\n")
                            .append("   - Sexo: ").append(sexo).append("\n")
                            .append("   - Telefone: ").append(telefone).append("\n")
                            .append("   - Função: ") .append(funcao) .append("\n")
                            .append("   - Carteira de Trabalho: ").append(carteiraTrab).append("\n")
                            .append("   - Estado Civil: ").append(estCivil).append("\n")
                            .append("   - Endereço: ").append(endereco).append("\n");
                            
                encontrou = true;
            }
        }

        // Verifica se o nome foi encontrado na tabela
        if (!encontrou) {
            relatorio.append("Nenhum registro encontrado.");
        }

        // Exibe o resultado no componente textArea
        resultArea.setText(relatorio.toString());
    }
    
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void ckbFrancesFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbFrancesFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbFrancesFunActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        habilitarBotoes(false); 
        limparCampos(); //Limpar os Campos 
        txtCodigoFun.requestFocus();//Colocar o foto de volta no campo Codigo.
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        if (validarDados()){
            inserirRegistroTabela(); //Inserir Registro Tabela.
            if(operacao.equals("cadastrar")){
                try {
                    salvarFuncionarioArqTexto();
                    JOptionPane.showMessageDialog(null, "Funcionário Cadastrado com Sucesso!.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema: " + ex.getMessage());
                }
            }
            if (operacao.equals("atualizar")){
                try {
                    salvarFuncionarioArqTexto();
                    JOptionPane.showMessageDialog(null, "Funcionário Atualizado com Sucesso!.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema: " + ex.getMessage());
                }
                    }
            limparCampos(); //Chama o método limpar os campos.
            habilitarBotoes(false);
            txtCodigoFun.requestFocus(); //Coloca o foco de volta no campo Codigo.
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tabFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabFuncionarioKeyReleased
        // TODO add your handling code here:
        carregarDados();
    }//GEN-LAST:event_tabFuncionarioKeyReleased

    private void tabFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabFuncionarioMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){ //duplo click
        excluir();
        limparCampos();
        }
        carregarDados();
    }//GEN-LAST:event_tabFuncionarioMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new telaCadFuncionarios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupSexo;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultarFun;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox ckbEspanhol;
    private javax.swing.JCheckBox ckbEspanholFun;
    private javax.swing.JCheckBox ckbFrances;
    private javax.swing.JCheckBox ckbFrancesFun;
    private javax.swing.JCheckBox ckbIngles;
    private javax.swing.JCheckBox ckbInglesFun;
    private javax.swing.JCheckBox ckbItaliano;
    private javax.swing.JCheckBox ckbItalianoFun;
    private javax.swing.JComboBox<String> cmbEstCivilFun;
    private javax.swing.JComboBox<String> jComboEstCivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JRadioButton radFeminino;
    private javax.swing.JRadioButton radFemininoFun;
    private javax.swing.JRadioButton radMasculino;
    private javax.swing.JRadioButton radMasculinoFun;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JTable tabFuncionario;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JFormattedTextField txtCPFFun;
    private javax.swing.JTextField txtCarteiraTrab;
    private javax.swing.JFormattedTextField txtCarteiraTrabFun;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoFun;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JFormattedTextField txtDataNascimentoFun;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEnderecoFun;
    private javax.swing.JTextField txtFuncao;
    private javax.swing.JTextField txtFuncaoFun;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeFun;
    private javax.swing.JTextField txtPesquisaFun;
    private javax.swing.JTextField txtPisPasep;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JFormattedTextField txtTelefoneFun;
    // End of variables declaration//GEN-END:variables
}
