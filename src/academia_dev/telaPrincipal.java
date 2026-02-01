package academia_dev;

public class telaPrincipal extends javax.swing.JFrame {

    public telaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplBarraMenu = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        btnCadastroCliente = new javax.swing.JButton();
        btnAgenda = new javax.swing.JButton();
        btnTreino = new javax.swing.JButton();
        btnSobre = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCadastroFuncionario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 625));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplBarraMenu.setBackground(new java.awt.Color(54, 70, 78));
        jplBarraMenu.setPreferredSize(new java.awt.Dimension(210, 625));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/logoHorizontal.png"))); // NOI18N

        btnCadastroCliente.setBackground(new java.awt.Color(54, 70, 78));
        btnCadastroCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastroCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/Cadastro2.png"))); // NOI18N
        btnCadastroCliente.setText("Cadastro cliente");
        btnCadastroCliente.setBorder(null);
        btnCadastroCliente.setBorderPainted(false);
        btnCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroClienteActionPerformed(evt);
            }
        });

        btnAgenda.setBackground(new java.awt.Color(54, 70, 78));
        btnAgenda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgenda.setForeground(new java.awt.Color(255, 255, 255));
        btnAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/Agendamento.png"))); // NOI18N
        btnAgenda.setText("Agenda");
        btnAgenda.setBorder(null);
        btnAgenda.setBorderPainted(false);
        btnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaActionPerformed(evt);
            }
        });

        btnTreino.setBackground(new java.awt.Color(54, 70, 78));
        btnTreino.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTreino.setForeground(new java.awt.Color(255, 255, 255));
        btnTreino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/treino.png"))); // NOI18N
        btnTreino.setText("Treino");
        btnTreino.setBorder(null);
        btnTreino.setBorderPainted(false);
        btnTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTreinoActionPerformed(evt);
            }
        });

        btnSobre.setBackground(new java.awt.Color(54, 70, 78));
        btnSobre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSobre.setForeground(new java.awt.Color(255, 255, 255));
        btnSobre.setText("Sobre");
        btnSobre.setBorder(null);
        btnSobre.setBorderPainted(false);
        btnSobre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobreActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(54, 70, 78));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setBorder(null);
        btnSair.setBorderPainted(false);
        btnSair.setLabel("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(72, 94, 104));
        jSeparator1.setForeground(new java.awt.Color(72, 94, 104));

        btnCadastroFuncionario.setBackground(new java.awt.Color(54, 70, 78));
        btnCadastroFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastroFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/Cadastro2.png"))); // NOI18N
        btnCadastroFuncionario.setText("Cadastro funcionário");
        btnCadastroFuncionario.setBorder(null);
        btnCadastroFuncionario.setBorderPainted(false);
        btnCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplBarraMenuLayout = new javax.swing.GroupLayout(jplBarraMenu);
        jplBarraMenu.setLayout(jplBarraMenuLayout);
        jplBarraMenuLayout.setHorizontalGroup(
            jplBarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplBarraMenuLayout.createSequentialGroup()
                .addGroup(jplBarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplBarraMenuLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jplBarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTreino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSobre, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(btnAgenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jplBarraMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jplBarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadastroCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastroFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jplBarraMenuLayout.setVerticalGroup(
            jplBarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplBarraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCadastroFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTreino, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jplBarraMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/frenteAdacdemiaDEV.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 760, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 790, 625));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroClienteActionPerformed
        telaCadCliente cadastro = new telaCadCliente();
        cadastro.setVisible(true);
 
    }//GEN-LAST:event_btnCadastroClienteActionPerformed

    private void btnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaActionPerformed
        agendamento agenda = new agendamento();
        agenda.setVisible(true);
    }//GEN-LAST:event_btnAgendaActionPerformed

    private void btnTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTreinoActionPerformed
        telaTreino treino = new telaTreino();
        treino.setVisible(true);
    }//GEN-LAST:event_btnTreinoActionPerformed

    private void btnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobreActionPerformed
        telaSobre sobre = new telaSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_btnSobreActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroFuncionarioActionPerformed
        telaCadFuncionarios funcionario = new telaCadFuncionarios();
        funcionario.setVisible(true);
    }//GEN-LAST:event_btnCadastroFuncionarioActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgenda;
    private javax.swing.JButton btnCadastroCliente;
    private javax.swing.JButton btnCadastroFuncionario;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSobre;
    private javax.swing.JButton btnTreino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jplBarraMenu;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
