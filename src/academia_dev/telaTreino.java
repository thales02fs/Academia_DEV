package academia_dev;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.Normalizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class telaTreino extends javax.swing.JFrame {
    String operacao;
    final String nomeArquivo = "arquivos/chckin.txt";
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(telaTreino.class.getName());

    public telaTreino() {
        initComponents();
        setLocationRelativeTo(null); // Centralizar a tabela
        configurarTabela();
        carregarTabela();
        habilitarBotoes(false);
          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoModalidade = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        cmbHorario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        radMusculacao = new javax.swing.JRadioButton();
        radCrossFit = new javax.swing.JRadioButton();
        radNatacao = new javax.swing.JRadioButton();
        radSpinning = new javax.swing.JRadioButton();
        radFuncional = new javax.swing.JRadioButton();
        radJump = new javax.swing.JRadioButton();
        radZumba = new javax.swing.JRadioButton();
        radHidro = new javax.swing.JRadioButton();
        radBoxe = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        chkSegunda = new javax.swing.JCheckBox();
        chkTerca = new javax.swing.JCheckBox();
        chkQuarta = new javax.swing.JCheckBox();
        chkQuinta = new javax.swing.JCheckBox();
        chkSexta = new javax.swing.JCheckBox();
        chkSabado = new javax.swing.JCheckBox();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNovoC = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabCheckin = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtNomePesquisa = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Código");

        jLabel3.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------", "07:15 - 08:15", "08:15 - 09:15", "09:15 - 10:15", "10:15 - 11:15", "11:15 - 12:15", "14:15 - 15:15", "15:15 - 16:15", "16:15 - 17:15", "17:15 - 18:15", "18:15 - 19:15", "19:15 - 20:15", "20:15 - 21:15", "21:15 - 22:15" }));
        cmbHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHorarioActionPerformed(evt);
            }
        });

        jLabel4.setText("Horário");

        jLabel5.setText("Dia da Semana");

        jPanel1.setBackground(new java.awt.Color(54, 70, 78));

        jSeparator1.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODALIDADES");

        radMusculacao.setBackground(new java.awt.Color(54, 70, 78));
        grupoModalidade.add(radMusculacao);
        radMusculacao.setForeground(new java.awt.Color(255, 255, 255));
        radMusculacao.setSelected(true);
        radMusculacao.setText("Musculação");
        radMusculacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMusculacaoActionPerformed(evt);
            }
        });

        radCrossFit.setBackground(new java.awt.Color(50, 70, 78));
        grupoModalidade.add(radCrossFit);
        radCrossFit.setForeground(new java.awt.Color(255, 255, 255));
        radCrossFit.setText("CrossFit");

        radNatacao.setBackground(new java.awt.Color(50, 70, 78));
        grupoModalidade.add(radNatacao);
        radNatacao.setForeground(new java.awt.Color(255, 255, 255));
        radNatacao.setText("Natação");
        radNatacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNatacaoActionPerformed(evt);
            }
        });

        radSpinning.setBackground(new java.awt.Color(50, 70, 78));
        grupoModalidade.add(radSpinning);
        radSpinning.setForeground(new java.awt.Color(255, 255, 255));
        radSpinning.setText("Spinning");

        radFuncional.setBackground(new java.awt.Color(50, 70, 78));
        grupoModalidade.add(radFuncional);
        radFuncional.setForeground(new java.awt.Color(255, 255, 255));
        radFuncional.setText("Funcional");

        radJump.setBackground(new java.awt.Color(50, 70, 78));
        grupoModalidade.add(radJump);
        radJump.setForeground(new java.awt.Color(255, 255, 255));
        radJump.setText("Jump");

        radZumba.setBackground(new java.awt.Color(50, 70, 78));
        grupoModalidade.add(radZumba);
        radZumba.setForeground(new java.awt.Color(255, 255, 255));
        radZumba.setText("Zumba");

        radHidro.setBackground(new java.awt.Color(50, 70, 78));
        grupoModalidade.add(radHidro);
        radHidro.setForeground(new java.awt.Color(255, 255, 255));
        radHidro.setText("Hidroginástica");

        radBoxe.setBackground(new java.awt.Color(50, 70, 78));
        grupoModalidade.add(radBoxe);
        radBoxe.setForeground(new java.awt.Color(255, 255, 255));
        radBoxe.setText("Boxe");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radMusculacao)
                                    .addComponent(radCrossFit)
                                    .addComponent(radNatacao))
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radFuncional)
                                            .addComponent(radJump))
                                        .addGap(92, 92, 92)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radHidro)
                                            .addComponent(radBoxe)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radSpinning)
                                        .addGap(97, 97, 97)
                                        .addComponent(radZumba))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(jLabel1)))
                        .addGap(0, 57, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radMusculacao)
                    .addComponent(radSpinning)
                    .addComponent(radZumba))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radCrossFit)
                    .addComponent(radFuncional)
                    .addComponent(radHidro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radNatacao)
                    .addComponent(radJump)
                    .addComponent(radBoxe))
                .addGap(75, 75, 75))
        );

        jPanel2.setBackground(new java.awt.Color(54, 70, 78));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Check-in");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(562, 562, 562)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chkSegunda.setText("Segunda-Feira");

        chkTerca.setText("Terça-Feira");

        chkQuarta.setText("Quarta-Feira");

        chkQuinta.setText("Quinta_feira");

        chkSexta.setText("Sexta-Feira");

        chkSabado.setText("Sábado");
        chkSabado.setToolTipText("");
        chkSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSabadoActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(54, 70, 78));
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(54, 70, 78));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(54, 70, 78));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(54, 70, 78));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNovoC.setText("Novo Ckeck-in");
        btnNovoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(54, 70, 78));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        tabCheckin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Dia ", "Horario", "Modalidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabCheckin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabCheckinMouseClicked(evt);
            }
        });
        tabCheckin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabCheckinKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabCheckin);

        jLabel7.setText("Pesquise pelo nome do aluno:");

        txtNomePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePesquisaActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        resultArea.setColumns(20);
        resultArea.setRows(5);
        jScrollPane1.setViewportView(resultArea);

        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("DÊ DUPLO CLICK PARA EXCLUSÃO DE REGISTRO");

        jSeparator2.setBackground(new java.awt.Color(255, 153, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovoC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkSegunda)
                            .addComponent(chkTerca)
                            .addComponent(chkQuarta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkSabado)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkSexta)
                                    .addComponent(chkQuinta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8))
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnConsultar)))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkSegunda)
                                    .addComponent(chkQuinta))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkTerca)
                                    .addComponent(chkSexta)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkQuarta)
                            .addComponent(chkSabado))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoC)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar)
                    .addComponent(btnSair)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSabadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSabadoActionPerformed

    private void radMusculacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMusculacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radMusculacaoActionPerformed

    private void cmbHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHorarioActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        String codigo = txtCodigo.getText();
        String nome = txtNome.getText();
        
       
        
        // Sempre que um campo não for preenchido, ele retornara com uma mensagem"
        
        if (codigo.isEmpty()){
        
            JOptionPane.showMessageDialog(null, "Informe o Código ", "Atenção", JOptionPane.WARNING_MESSAGE);
             return;
        }
        
         if (nome.isEmpty()){
        
            JOptionPane.showMessageDialog(null, "Informe o Nome  ", "Atenção", JOptionPane.WARNING_MESSAGE);
             return;
        }
             
        if (cmbHorario.getSelectedIndex()==0) {  // Se no combo Box estiver marcado o indice "0", retornarar 
          JOptionPane.showMessageDialog(null, "Selecione o horario", "Atenção", JOptionPane.WARNING_MESSAGE);
             return;
        }
        // Se nenhuma opção dos dias da semana estiver marcado, retornar com mensagem
        if (!chkSegunda.isSelected() &&
            !chkTerca.isSelected() &&
            !chkQuarta.isSelected() &&
            !chkQuinta.isSelected() &&
            !chkSexta.isSelected() &&
            !chkSabado.isSelected()) {
            JOptionPane.showMessageDialog(null, "Selecione o dia", "Atenção", JOptionPane.WARNING_MESSAGE);
             return;
             
        }
       try {
        // Tenta converter o código para número
        Integer.parseInt(txtCodigo.getText().trim());

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
            null,
            "O campo Código deve conter apenas números!",
            "Valor inválido",
            JOptionPane.WARNING_MESSAGE
        );
        txtCodigo.requestFocus();
        return; // Interrompe o salvar
    }
         inserirRegistroTabela();

        
        limparCampos();

        
        habilitarBotoes(false);
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // O trim verifica se existem espaços no campo e tira os / se os campos esta vazio, o usuário não selecionou nada, e retorna com a mensagem
        if(txtCodigo.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione o Aluno que deseja editar.");
        } else { //ele selecionou e preencheo os campos, e leva ao botão editar true, e fica visivel
            operacao="editar";
            habilitarBotoes(true);
            txtNome.requestFocus();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNovoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCActionPerformed
        limparCampos();
        operacao = "novo";
        habilitarBotoes(true);
        txtCodigo.setText("");
        txtNome.setText("");
        limparCampos();
        txtCodigo.requestFocus(); //foco volta para o campo Codigo
    }//GEN-LAST:event_btnNovoCActionPerformed

    private void tabCheckinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabCheckinKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tabCheckinKeyReleased

    private void tabCheckinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabCheckinMouseClicked
        if (evt.getClickCount() == 2 ) { //Verifica se deu duplo clique na linha, e chama o método excluir.
            excluir();
            limparCampos();
            carregarDados();
        }     
    }//GEN-LAST:event_tabCheckinMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Quando clico no botão, vai ficar desabilitado e os outros habilitados
        
        habilitarBotoes(false);
        limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        excluir();
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtNomePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePesquisaActionPerformed

    private void radNatacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNatacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNatacaoActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        String nomePesquisa = txtNomePesquisa.getText();
        buscarCliente(nomePesquisa);
    }//GEN-LAST:event_btnConsultarActionPerformed
    
    
    private void configurarTabela(){ // Permite redimensionar as colunas do tamanho que desejar
        tabCheckin.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabCheckin.getColumnModel().getColumn(2).setPreferredWidth(400);
    }
    
    private void limparCampos () { //Limpar o conteudo dos componentes
        
        chkSegunda.setSelected(false);
        chkTerca.setSelected(false);
        chkQuarta.setSelected(false);
        chkQuinta.setSelected(false);
        chkSexta.setSelected(false);
        chkSabado.setSelected(false);
        cmbHorario.setSelectedIndex(0);
        grupoModalidade.clearSelection();
    }
    
    private void inserirRegistroTabela() {
        String codigo = txtCodigo.getText();
        String nome = txtNome.getText();
        String horario = cmbHorario.getSelectedItem().toString(); // Quando tem o método String na propriedade, utilizar o toString
        String DiaSemana= "";
        String modalidade= "";
        
        //----
        if(chkSegunda.isSelected())
            DiaSemana +="- Segunda ";
        if(chkTerca.isSelected())
            DiaSemana +="- Terça ";
        if(chkQuarta.isSelected())
            DiaSemana +="- Quarta ";
        if (chkQuinta.isSelected())
            DiaSemana +="- Quinta ";
        if(chkSexta.isSelected())
            DiaSemana +="- Sexta ";
        if(chkSabado.isSelected())
            DiaSemana +="- Sábado ";
        //----
        if(radMusculacao.isSelected()) {
            modalidade = "Musculção";
        } else if(radCrossFit.isSelected()){
            modalidade = "CrossFit";
        } else if(radNatacao.isSelected()){
            modalidade = "Natação";
        }    else if(radSpinning.isSelected()){
            modalidade = "Spinning";
        }    else if(radFuncional.isSelected()){
            modalidade = "Funcional";
        }    else if(radJump.isSelected()){
            modalidade = "Jump";
        }    else if(radZumba.isSelected()){
            modalidade = "Zumba";
        }    else if(radHidro.isSelected()){
            modalidade = "Hidroginástica";
        }    else if(radBoxe.isSelected()){
            modalidade = "Boxe";
        } 
        
        
        DefaultTableModel dtm_checkin = (DefaultTableModel) tabCheckin.getModel(); //Instanciando a tabela
        // Object[] Vetor que guarda qualquer tipo (String, Float, Integer...)
        Object[] dados = {codigo,nome,DiaSemana,horario, modalidade}; //cria array
        
        
        
        if (operacao.equals("novo")){ //Se a variavel "operacao" for igual a novo, o usuario clicou no botão novo, adiciona uma nova linha na tabela e gravar os dados
            dtm_checkin.addRow(dados); //adiciona uma linha na tabela
        
            if (inserirCheckinArqTexto(codigo, nome, DiaSemana, horario, modalidade)) {
                JOptionPane.showMessageDialog(this,
                                        "Aluno inserido com sucesso!",
                                        "Aviso",
                                        JOptionPane.INFORMATION_MESSAGE);
            } else {
            JOptionPane.showConfirmDialog(this,
                    "Erro ao escrever no arquivo",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            }
        
        } else if (operacao.equals("editar")) { // caso o usuário clica em editar
            int linhaSelecionada = tabCheckin.getSelectedRow(); // linha selecionada]
            //atualizando coluna a coluna usando array
            for (int i=0; i<dados.length; i++) {
                dtm_checkin.setValueAt(dados[i], linhaSelecionada, i);
                
            }
            tranferirTabelaParaArqTexto ();
        }
    }
      
    private void carregarDados (){ //Vai pegar a linha da tabela  e vai colocar em nos campos 
        int linha = tabCheckin.getSelectedRow();// seleciona o numero da linha 
        if (linha != -1) { //Linha diferente de indice -1
            txtCodigo.setText((String)tabCheckin.getValueAt(linha, 0));
            txtNome.setText((String)tabCheckin.getValueAt(linha, 1));
            
        }
        
    }

    private void excluir(){
        int linhaSelecionada = tabCheckin.getSelectedRow(); //Pega a linha selecionada
        
        if (linhaSelecionada == -1) { // Nenhuma linha selecionada "-1"
            JOptionPane.showInputDialog(null,"Selecione uma linha para excluir","aviso", JOptionPane.INFORMATION_MESSAGE);
       
        } else{
            int confirma = JOptionPane.showConfirmDialog( null, "Deseja excluir o Check-in?", "aviso", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) { //Se o usuário clicou no "YES"
            //Excluir linha da tabela
            DefaultTableModel dtm_checkin = (DefaultTableModel) tabCheckin.getModel(); 
                dtm_checkin.removeRow(linhaSelecionada);
                tranferirTabelaParaArqTexto ();
                JOptionPane.showMessageDialog(null,"Check-in excluído com sucesso!","Aviso", JOptionPane.INFORMATION_MESSAGE);
         
        } else{
            JOptionPane.showMessageDialog(null,"Exclusão cancelada!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
         }
            
       }    
             
      }            
      
    private void habilitarBotoes(boolean valor) { //Método para habilitar (true) e desabilitar (false) botões
        btnSalvar.setEnabled(valor);
        btnCancelar.setEnabled(valor);
        btnSair.setEnabled(!valor);
        btnNovoC.setEnabled(!valor);
        btnEditar.setEnabled(!valor);
        btnExcluir.setEnabled(!valor);
        
        txtCodigo.setEnabled(valor);
        txtNome.setEnabled(valor);
    }
    private void buscarCliente (String nomePesquisa) {
        // verifica se o usuário digitou nome para pesquisa
        if (nomePesquisa == null || nomePesquisa.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Digite um nome para pesquisar", "aviso", JOptionPane.INFORMATION_MESSAGE );
        return;
        }
        //Chama o método que retira acentos do nome pelo usuário
        nomePesquisa = retirarAcentos(nomePesquisa).toLowerCase();
        
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("R E S U L T A DO  D A  P E S Q U I S A:\n");
        relatorio.append("=========================================\n");
        
        DefaultTableModel dtm_Checkin = (DefaultTableModel) tabCheckin.getModel();
        boolean encontrou = false;
        
        //Percorre as linhas tabCheckin
        for (int i=0; i<dtm_Checkin.getRowCount(); i++) { //pegar o total de linhas
            String nome = String.valueOf(dtm_Checkin.getValueAt(i, 1));
            
            //Chama o método que retira acentos do nome extraído da tabela
            String nomeSemAcento = retirarAcentos(nome).toLowerCase();
           //Verifica correspondecia
            if (nomeSemAcento.contains(nomePesquisa)) {
            String codigo = String.valueOf(dtm_Checkin.getValueAt(i, 0));
            String dia = String.valueOf(dtm_Checkin.getValueAt(i, 2));
            String horario = String.valueOf(dtm_Checkin.getValueAt(i, 3));
            String modalidade = String.valueOf(dtm_Checkin.getValueAt(i, 4));
            
            relatorio.append("Código: ").append(codigo).append(" - ").append(nome).append("\n")
                    .append("   - Dia: ").append(dia).append("\n")
                    .append("   - Horario: ").append(horario).append("\n")
                    .append("   - Modalidade: ").append(modalidade).append("\n\n");
            encontrou = true;
            
        }
            
    }
    //Verifica se o nome foi encontrado na tabela
    if (!encontrou) {
        relatorio.append("Nenhum registro encontrado.");
        
    }
    // Exibe o resultadono componente textArea
    resultArea.setText(relatorio.toString());
        
        
                
                
                
    
    }
    private String retirarAcentos (String texto) { //Método que separa as letras dos acentos.
        return java.text.Normalizer
                .normalize(texto, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        
        
    }
            
    public boolean inserirCheckinArqTexto 
            (String codigo,
            String nome, 
            String DiaSemana,
            String horario, 
            String modalidade) {
        String linha = codigo + ";" + nome + ";" + DiaSemana + ";" + horario + ";" + modalidade;
        
        try (BufferedWriter w_Checkin = Files.newBufferedWriter (
                    Paths.get(nomeArquivo),
                    StandardOpenOption.CREATE, // se não existir o arquivo crie
                    StandardOpenOption.APPEND // permite adicionar, um registro no final do arquivo
        )) {
           w_Checkin.write(linha); //Grava a linha la no arquivo text
           w_Checkin.newLine(); // Adiciona uma nova linha em branco
           return true;
           
        } catch (IOException e) {
                return false;
        }
    }
    
    public void carregarTabela (){ //carrega as linhas do arquivo para a tabela
        DefaultTableModel dtm_Checkin = (DefaultTableModel) tabCheckin.getModel();
        dtm_Checkin.setRowCount(0); //limpa a tabela
                
       // Path caminho = Paths.get(nomeArquivo);
        try (BufferedReader r_Checkin = Files.newBufferedReader( Paths.get(nomeArquivo))) {
            String linha;
            while ((linha = r_Checkin.readLine()) != null) {
                String [] campos = linha.split(";");// separa apenas em 2 partes
                dtm_Checkin.addRow(campos);
                    }
                } catch (IOException e) {
                    JOptionPane.showConfirmDialog(null, "Erro ao ler arquivo:" + e.getMessage());
                }
            }
    
    public void tranferirTabelaParaArqTexto () {
        Path caminho = Paths.get(nomeArquivo);
        
        try (BufferedWriter w_Checkin = Files.newBufferedWriter(
                caminho,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        )) {
            DefaultTableModel dtm_Checkin = (DefaultTableModel) tabCheckin.getModel();
            int totalLinhas = dtm_Checkin.getRowCount(); 
            
            for (int i=0; i<totalLinhas; i++) {
                String codigo = String.valueOf(dtm_Checkin.getValueAt(i, 0));
                String nome = String.valueOf(dtm_Checkin.getValueAt(i, 1));
                String DiaSemana = String.valueOf(dtm_Checkin.getValueAt(i, 2));
                String horario = String.valueOf(dtm_Checkin.getValueAt(i, 3));
                String modalidade = String.valueOf(dtm_Checkin.getValueAt(i, 4));
                 
                w_Checkin.write(codigo + ";" + nome + ";" + DiaSemana + ";" + horario + ";" + modalidade);
                w_Checkin.newLine();
            }
    }   catch (IOException e) {
        JOptionPane.showConfirmDialog(null, "Erro ao gravar no arquivo: "+ e.getMessage(), "Aviso",
                                        JOptionPane.WARNING_MESSAGE);
    }
    }
    public static void main(String args[]) { //Método Principal, por onde a aplicação se inicia
        
        java.awt.EventQueue.invokeLater(() -> new telaTreino().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovoC;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkQuarta;
    private javax.swing.JCheckBox chkQuinta;
    private javax.swing.JCheckBox chkSabado;
    private javax.swing.JCheckBox chkSegunda;
    private javax.swing.JCheckBox chkSexta;
    private javax.swing.JCheckBox chkTerca;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.ButtonGroup grupoModalidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton radBoxe;
    private javax.swing.JRadioButton radCrossFit;
    private javax.swing.JRadioButton radFuncional;
    private javax.swing.JRadioButton radHidro;
    private javax.swing.JRadioButton radJump;
    private javax.swing.JRadioButton radMusculacao;
    private javax.swing.JRadioButton radNatacao;
    private javax.swing.JRadioButton radSpinning;
    private javax.swing.JRadioButton radZumba;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JTable tabCheckin;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomePesquisa;
    // End of variables declaration//GEN-END:variables
 
}


 // 

