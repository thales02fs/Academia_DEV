package academia_dev;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class agendamento extends javax.swing.JFrame {
    String operacao;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(agendamento.class.getName());

    public agendamento() {
        initComponents();
        setLocationRelativeTo(null);
        tableAgendamento.getColumnModel().getColumn(0).setPreferredWidth(30); // Coluna 'Código'
        tableAgendamento.getColumnModel().getColumn(2).setPreferredWidth(55); // Coluna 'CPF'
        tableAgendamento.getColumnModel().getColumn(3).setPreferredWidth(50); // Coluna 'Data'
        tableAgendamento.getColumnModel().getColumn(4).setPreferredWidth(40); // Coluna 'Horário'
        operacaoBotao(false); // Desabilita todos os botões listados
        carregarArquivoAgendamentos();
        carregarArquivoCadastrados();
    }
    
    private void carregarArquivoAgendamentos() { // Integração com o arquivo texto para a tabela de agendamento
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(
                new java.io.FileReader("arquivos/agendamento.txt")
            );

            String linha;
            DefaultTableModel dtm = (DefaultTableModel) tableAgendamento.getModel();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                dtm.addRow(dados);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado. Será criado ao salvar.");
        }
    }
    
    
    
    private void salvarArquivoAgendamentos() {
        try {
            java.io.BufferedWriter bw = new java.io.BufferedWriter(
                new java.io.FileWriter("arquivos/agendamento.txt")
            );

            DefaultTableModel dtm = (DefaultTableModel) tableAgendamento.getModel();

            for (int i = 0; i < dtm.getRowCount(); i++) {
                bw.write(
                    dtm.getValueAt(i, 0) + ";" +
                    dtm.getValueAt(i, 1) + ";" +
                    dtm.getValueAt(i, 2) + ";" +
                    dtm.getValueAt(i, 3) + ";" +
                    dtm.getValueAt(i, 4)
                );
                bw.newLine();
            }

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void carregarArquivoCadastrados() { // Integração com o arquivo texto para a tabela de cadastrados
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(
                new java.io.FileReader("arquivos/dados_clientes.txt")
            );

            String linha;
            DefaultTableModel dtm = (DefaultTableModel) tableCadastrado.getModel();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                dtm.addRow(dados);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado. Será criado ao salvar.");
        }
    }
    
    private void operacaoBotao(boolean status){ // Função para habilitar/desablitar os botões listados
        btnAgendar.setEnabled(status);
        btnCancelar.setEnabled(status);
        btnFechar.setEnabled(!status);
        btnNovo.setEnabled(!status);
        btnEditar.setEnabled(!status);
        btnExcluir.setEnabled(!status);
        txtFieldCodigo.setEnabled(status);
        txtFieldNome.setEnabled(status);
        frmtdTxtFieldCPF.setEnabled(status);
        frmtdTxtFieldData.setEnabled(status);
        frmtdTxtFieldHorario.setEnabled(status);
    }
    
    private void limparCampos(){ // Limpa os campos de texto
        txtFieldCodigo.setText("");
        txtFieldNome.setText("");
        frmtdTxtFieldCPF.setText("");
        frmtdTxtFieldData.setText("");
        frmtdTxtFieldHorario.setText("");
    }
    
    public boolean validarDados(){
        boolean valido = true;
        String codigo = txtFieldCodigo.getText();
        String nome = txtFieldNome.getText();
        String cpf = frmtdTxtFieldCPF.getText();
        String data = frmtdTxtFieldData.getText();
        String horario = frmtdTxtFieldHorario.getText();
         
        if (!codigo.trim().isEmpty() && !nome.trim().isEmpty() && !cpf.trim().isEmpty() && !data.trim().isEmpty() && !horario.trim().isEmpty()){  // Se todos os campos estão preenchids
            valido=true;
            try {
                Integer.valueOf(txtFieldCodigo.getText()); // Transforma de Object para número inteiro
            } catch (Exception e) {
                valido = false;
                JOptionPane.showMessageDialog(
                    null,
                    "O campo 'Código' deve ser numérico inteiro",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        }else{
            valido=false;
            JOptionPane.showMessageDialog(
                    null,
                    "Preencha os campos todos os camppos",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );
        }
        return valido;
    }
    
    private void inserirRegistroTabela(){ // Função para registrar dados na tabela
        String codigo = txtFieldCodigo.getText();
        String nome = txtFieldNome.getText();
        String cpf = frmtdTxtFieldCPF.getText();
        String data = frmtdTxtFieldData.getText();
        String horario = frmtdTxtFieldHorario.getText();
        
        DefaultTableModel dtm_agendamento = (DefaultTableModel) tableAgendamento.getModel();
        Object[] dados = {codigo, nome, cpf, data, horario}; // Cria um array para receber qualquer tipo
        
        if(operacao.equals("novo")){
            dtm_agendamento.addRow(dados); // Insere uma nova linha na tabela
            salvarArquivoAgendamentos();
            
        }
        else if(operacao.equals("editar")){
            int linha = tableAgendamento.getSelectedRow(); // Linha selecionada pelo usuário
            
            for(int i = 0; i < dados.length; i++){ // Atualiza a coluna usando array
                dtm_agendamento.setValueAt(dados[i], linha, i);
                salvarArquivoAgendamentos();
            }
        }
    }

    private void carregarDados(){
        int lin = tableAgendamento.getSelectedRow(); // Pega o número da linha
        
        if(lin != -1){ // 'Se' uma linha estiver selecionada
            txtFieldCodigo.setText((String) tableAgendamento.getValueAt(lin, 0));
            txtFieldNome.setText((String) tableAgendamento.getValueAt(lin, 1));
            frmtdTxtFieldCPF.setText((String) tableAgendamento.getValueAt(lin, 2));
            frmtdTxtFieldData.setText((String) tableAgendamento.getValueAt(lin, 3));
            frmtdTxtFieldHorario.setText((String) tableAgendamento.getValueAt(lin, 4));
        }
    }
    
    private void excluir(){ // Método para excluir uma linha
        int linhaSelecionada = tableAgendamento.getSelectedRow(); // Pega a linha selecionada
        
        if(linhaSelecionada == -1){ // "Se" nenhuma linha for selecionada
            JOptionPane.showMessageDialog(
                null,
                "Selecione uma linha para excluir.",
                "Aviso",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
        else{
            int confirma = JOptionPane.showConfirmDialog(
                    null,
                    "Confirma exclusão de agendamento?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );
            
            if(confirma == JOptionPane.YES_OPTION){ // "Se" o usuário tiver clicado no botão "Yes"
                DefaultTableModel dtm_agendamento = (DefaultTableModel) tableAgendamento.getModel();
                dtm_agendamento.removeRow(linhaSelecionada);
                salvarArquivoAgendamentos();
                
                JOptionPane.showMessageDialog(
                        null,
                        "Agendamento excluído com sucesso",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            else if(confirma == JOptionPane.NO_OPTION){ // "Se" o usuário tiver clicado no botão "No"
                JOptionPane.showMessageDialog(
                        null,
                        "Exclusão cancelada",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
    
    private String retiraAcentos(String texto){
        return java.text.Normalizer
                .normalize(texto, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{M}", ""); // Remove os acentos
    }
    
    private void buscarAgendado(String nomePesquisa){
        if(nomePesquisa == null || nomePesquisa.trim().isEmpty()){ // Verifica se o usuário digitou algum nome para pesquisar
            areaTextoAgendado.setText("Digite um nome para pesquisar.");
            return;
        }
        nomePesquisa = retiraAcentos(nomePesquisa).toLowerCase();
        
        StringBuilder relatorio = new StringBuilder();
        
        relatorio.append("-----Resultado da Pesquisa-----\n\n");
        
        DefaultTableModel dtm = (DefaultTableModel) tableAgendamento.getModel();
        boolean encontrou = false;
        
        for(int i = 0; i < dtm.getRowCount(); i++){
            String codigo = String.valueOf(dtm.getValueAt(i, 0));
            String nome   = String.valueOf(dtm.getValueAt(i, 1));
            String cpf   = String.valueOf(dtm.getValueAt(i, 2));
            String data = String.valueOf(dtm.getValueAt(i, 3));
            String horario = String.valueOf(dtm.getValueAt(i, 4));
            
            String nomeSemAcento = retiraAcentos(nome).toLowerCase();
            
            if(nomeSemAcento.contains(nomePesquisa)){
                relatorio.append("Código: ").append(codigo).append(" - ").append(nome).append("\n")
                    .append("  - CPF: ").append(cpf).append("\n")
                    .append("  - Data: ").append(data).append("\n")
                    .append("  - Horário: ").append(horario).append("\n\n");
                
                encontrou = true;
            }
        }
        if(!encontrou){
            relatorio.append("Nenhum agendamento encontrado");
        }
        areaTextoAgendado.setText(relatorio.toString());
    }
    
    private void buscarCadastrado(String nomePesquisa){
        if(nomePesquisa == null || nomePesquisa.trim().isEmpty()){ // Verifica se o usuário digitou algum nome para pesquisar
            areaTextoCadastrado.setText("Digite um nome para pesquisar.");
            return;
        }
        nomePesquisa = retiraAcentos(nomePesquisa).toLowerCase();
        
        StringBuilder relatorio = new StringBuilder();
        
        relatorio.append("-----Resultado da Pesquisa-----\n\n");
        
        DefaultTableModel dtm = (DefaultTableModel) tableCadastrado.getModel();
        boolean encontrou = false;
        
        for(int i = 0; i < dtm.getRowCount(); i++){
            String codigo = String.valueOf(dtm.getValueAt(i, 0));
            String nome   = String.valueOf(dtm.getValueAt(i, 1));
            String cpf   = String.valueOf(dtm.getValueAt(i, 2));
            
            String nomeSemAcento = retiraAcentos(nome).toLowerCase();
            
            if(nomeSemAcento.contains(nomePesquisa)){
                relatorio.append("Código: ").append(codigo).append(" - ").append(nome).append("\n")
                    .append("  - CPF: ").append(cpf).append("\n");
                
                encontrou = true;
            }
        }
        if(!encontrou){
            relatorio.append("Nenhum cadastro encontrado");
        }
        areaTextoCadastrado.setText(relatorio.toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHead = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtFieldCodigo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtFieldNome = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFieldProcurarCadastrado = new javax.swing.JTextField();
        txtFieldProcurarAgendado = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCadastrado = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAgendamento = new javax.swing.JTable();
        lblData = new javax.swing.JLabel();
        frmtdTxtFieldData = new javax.swing.JFormattedTextField();
        lblHorario = new javax.swing.JLabel();
        frmtdTxtFieldHorario = new javax.swing.JFormattedTextField();
        btnAgendar = new javax.swing.JButton();
        btnConsultarClientes = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnConsultarAgendamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoAgendado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaTextoCadastrado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        frmtdTxtFieldCPF = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(524, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHead.setBackground(new java.awt.Color(54, 70, 78));
        pnlHead.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Agendamento de Avaliação");
        pnlHead.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, -1));

        getContentPane().add(pnlHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 70));

        lblCodigo.setText("Código");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));
        getContentPane().add(txtFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 75, -1));

        lblNome.setText("Nome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));
        getContentPane().add(txtFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 245, -1));

        lblCPF.setText("CPF");
        getContentPane().add(lblCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        btnNovo.setBackground(new java.awt.Color(54, 70, 78));
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 80, -1));

        btnEditar.setBackground(new java.awt.Color(54, 70, 78));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 80, -1));

        btnExcluir.setBackground(new java.awt.Color(54, 70, 78));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 80, -1));

        btnCancelar.setBackground(new java.awt.Color(54, 70, 78));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 80, -1));
        getContentPane().add(txtFieldProcurarCadastrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 240, -1));
        getContentPane().add(txtFieldProcurarAgendado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 620, 240, -1));

        jScrollPane3.setPreferredSize(new java.awt.Dimension(456, 200));

        tableCadastrado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCadastrado.setColumnSelectionAllowed(true);
        tableCadastrado.setMaximumSize(new java.awt.Dimension(60, 100));
        tableCadastrado.setMinimumSize(new java.awt.Dimension(60, 100));
        tableCadastrado.setPreferredSize(new java.awt.Dimension(60, 100));
        jScrollPane3.setViewportView(tableCadastrado);
        tableCadastrado.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 400, -1));

        jScrollPane4.setPreferredSize(new java.awt.Dimension(456, 200));

        tableAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Data", "Horário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAgendamento.setMaximumSize(new java.awt.Dimension(60, 100));
        tableAgendamento.setMinimumSize(new java.awt.Dimension(60, 100));
        tableAgendamento.setPreferredSize(new java.awt.Dimension(60, 100));
        tableAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAgendamentoMouseClicked(evt);
            }
        });
        tableAgendamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableAgendamentoKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tableAgendamento);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 400, -1));

        lblData.setText("Data");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        try {
            frmtdTxtFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        frmtdTxtFieldData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        frmtdTxtFieldData.setMinimumSize(new java.awt.Dimension(100, 26));
        frmtdTxtFieldData.setPreferredSize(new java.awt.Dimension(100, 26));
        getContentPane().add(frmtdTxtFieldData, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 100, 80, -1));

        lblHorario.setText("Horario");
        getContentPane().add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        try {
            frmtdTxtFieldHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        frmtdTxtFieldHorario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        frmtdTxtFieldHorario.setPreferredSize(new java.awt.Dimension(60, 26));
        getContentPane().add(frmtdTxtFieldHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 50, -1));

        btnAgendar.setBackground(new java.awt.Color(54, 70, 78));
        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgendar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 80, -1));

        btnConsultarClientes.setBackground(new java.awt.Color(54, 70, 78));
        btnConsultarClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultarClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarClientes.setText("Consultar");
        btnConsultarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, -1, -1));

        btnFechar.setBackground(new java.awt.Color(54, 70, 78));
        btnFechar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFechar.setForeground(new java.awt.Color(255, 255, 255));
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 730, -1, -1));

        btnConsultarAgendamento.setBackground(new java.awt.Color(54, 70, 78));
        btnConsultarAgendamento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultarAgendamento.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarAgendamento.setText("Consultar");
        btnConsultarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarAgendamentoActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultarAgendamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, -1, -1));

        areaTextoAgendado.setColumns(20);
        areaTextoAgendado.setRows(5);
        jScrollPane1.setViewportView(areaTextoAgendado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 400, 180));

        areaTextoCadastrado.setColumns(20);
        areaTextoCadastrado.setRows(5);
        jScrollPane2.setViewportView(areaTextoCadastrado);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 400, 180));

        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("<<Clique DUAS vezes no registro da tabela que deseja excluir>>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 350, -1));

        try {
            frmtdTxtFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(frmtdTxtFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 140, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Fundo.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 800, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        operacaoBotao(true); // habilita os botões listados da função 'operacao'
        operacao = "novo";
        limparCampos();
        txtFieldCodigo.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        if(validarDados()){
            inserirRegistroTabela(); // Chama o método 'inserirRegistroTabela'
            salvarArquivoAgendamentos();
            limparCampos(); // Chama o método 'limparCampos'
            operacaoBotao(false);
        }
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(txtFieldCodigo.getText().trim().isEmpty()){ // "Se" o texto depois de ter tirado os espaços e verificado se o campo está vazio
            JOptionPane.showMessageDialog(
                    null,
                    "Selecione o agendamento que deseja editar"
            );
        }
        else{
            operacao = "editar";
            operacaoBotao(true);
            txtFieldNome.requestFocus(); // Põe o foco no campo de texto de 'Nome'
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir(); // Chama o método 'excluir'
        limparCampos(); // Chama o método 'limparCampos'
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        operacaoBotao(false); // Desabilita os botões listados na função 'operacao'
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConsultarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClientesActionPerformed
        buscarCadastrado(txtFieldProcurarCadastrado.getText());
        txtFieldProcurarCadastrado.setText("");
    }//GEN-LAST:event_btnConsultarClientesActionPerformed

    private void tableAgendamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableAgendamentoKeyReleased
        carregarDados(); // Chama o método 'carregarDados'
    }//GEN-LAST:event_tableAgendamentoKeyReleased

    private void tableAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAgendamentoMouseClicked
        if(evt.getClickCount() == 2){
            excluir();
            limparCampos();
        }
        carregarDados();
    }//GEN-LAST:event_tableAgendamentoMouseClicked

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnConsultarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarAgendamentoActionPerformed
        buscarAgendado(txtFieldProcurarAgendado.getText());
        txtFieldProcurarAgendado.setText("");
    }//GEN-LAST:event_btnConsultarAgendamentoActionPerformed

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(() -> new agendamento().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTextoAgendado;
    private javax.swing.JTextArea areaTextoCadastrado;
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultarAgendamento;
    private javax.swing.JButton btnConsultarClientes;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JFormattedTextField frmtdTxtFieldCPF;
    private javax.swing.JFormattedTextField frmtdTxtFieldData;
    private javax.swing.JFormattedTextField frmtdTxtFieldHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JTable tableAgendamento;
    private javax.swing.JTable tableCadastrado;
    private javax.swing.JTextField txtFieldCodigo;
    private javax.swing.JTextField txtFieldNome;
    private javax.swing.JTextField txtFieldProcurarAgendado;
    private javax.swing.JTextField txtFieldProcurarCadastrado;
    // End of variables declaration//GEN-END:variables
}