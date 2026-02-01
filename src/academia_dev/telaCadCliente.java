package academia_dev;

import java.io.BufferedReader;
import java.io.BufferedWriter;//Importa a classe BufferedWriter que serve de memória temporária para escrever no arquivo
import java.io.FileReader;
import java.io.FileWriter;//Importa a classe FileWriter para criar um arquivo ou escrever em um existente
import java.io.IOException;//Importa a classe IOException que lança exceção quando ocorre algum erro de Entrada/Saída (I/O = Input/Output) envolvendo o arquivo.
import java.lang.System.Logger;
import java.text.Normalizer;//Importa a classe Normalizer que remove acentos e caracteres especiais do texto
import javax.swing.*;//Importa as classes do subpacote swing
import javax.swing.table.DefaultTableModel;//Importa a classe DefaultTableModel do subpacote Table

public class telaCadCliente extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(telaCadCliente.class.getName());
    
    private String operacao;//Para controlar qual operação está sendo realizada
    private static final String arquivo = "arquivos/dados_clientes.txt";//Arquivo para guardar os dados registrados, meu banco de dados.
    
    public telaCadCliente() {
        initComponents();//Inicia os componentes
        setLocationRelativeTo(null);//Centraliza a janela na tela
        habilitarBotoes(false);//Ao iniciar o programa, ele chama o método habilitarBotoes() e passa false como argumento, mantendo os principais campos inabilitados
        carregarDadosTabela();//Ao inciar o programa, ele já chama o método e carrega os dados do arquivo texto para a tabela
    }
    
    private boolean validarDados() {
        boolean valido = true;//Variável a ser usada para verificar se os dados foram corretamente preechidos
        
        String codigo = txtCodigo.getText();
        String nome = txtCodigo.getText();
        String cpf = txtCodigo.getText();
        String dataNascimento = txtCodigo.getText();
        String numero = txtCodigo.getText();
        String peso = txtCodigo.getText();
        String altura = txtCodigo.getText();
        
        if(!codigo.trim().isEmpty() && !nome.trim().isEmpty() && !cpf.trim().isEmpty() && !dataNascimento.trim().isEmpty() && !numero.trim().isEmpty() && !peso.trim().isEmpty() && !altura.trim().isEmpty()) {
            valido = true;
            try{
                Integer.parseInt(codigo);//Passando o código de Object para inteiro
                
            }catch(Exception e) {
                valido = false;
                JOptionPane.showMessageDialog(null, "Campo código deve ser numérico inteiro", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
            }
            
        }else{
            valido = false;
            JOptionPane.showMessageDialog(null, "Preencha os campos para salvar os dados!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            
        }
                        
        return valido;
        
    }
    
    private void inserirRegistroTabela() throws IOException {
        String codigo = txtCodigo.getText();
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String dataNascimento = txtDataNascimento.getText();
        String numeroTelefone = txtNumero.getText();
        String peso = txtPeso.getText();
        String altura = txtAltura.getText();
        String ativo = combAtivo.getSelectedItem().toString();
        String sexo;
        
        if(radMasculino.isSelected()) {
            sexo = "Masculino";
            
        }else{
            sexo = "Feminino";
            
        }
                
        DefaultTableModel dtmCliente = (DefaultTableModel) tabCliente.getModel();
        
        //Vetor de Object para guardar qualquer tipo
        Object[] dados = {codigo, nome, cpf, dataNascimento, ativo, sexo, peso, altura, numeroTelefone};
     
        if(operacao.equals("novo")) {
            dtmCliente.addRow(dados);//Adiciona uma nova linha com os valores que estão no Vetor dados
            gravarClienteArquivo(codigo, nome, cpf, dataNascimento, ativo, sexo, peso, altura, numeroTelefone);//Grava os dados no arquivo texto
                
        }else if(operacao.equals("editar")) {
            int linha = tabCliente.getSelectedRow();//Pega a linha que o usuário clicou
            
            //Loop para percorrer todas as colunas e alterá-las
            for(int i = 0; i < dados.length; i++) {
                dtmCliente.setValueAt(dados[i], linha, i);
                
            }
            
            //Já tem IOException no método inserirRegistroTabela() com throws
            transferirTabelaArquivo();//Transfere os dados da tabela para o arquivo texto, atualizando-o.
            
        }
        
    }
    
    private void carregarDados() {
        int linha = tabCliente.getSelectedRow();//Pega a linha selecionada
        
        //Se uma linha estiver selecionada
        if(linha != -1) {
            int coluna = tabCliente.getSelectedColumn();
            txtCodigo.setText((String) tabCliente.getValueAt(linha, 0));
            txtNome.setText((String) tabCliente.getValueAt(linha, 1));
            txtCpf.setText((String) tabCliente.getValueAt(linha, 2));
            txtDataNascimento.setText((String) tabCliente.getValueAt(linha, 3));
            txtNumero.setText((String) tabCliente.getValueAt(linha, 8));
            txtPeso.setText((String) tabCliente.getValueAt(linha, 6));
            txtAltura.setText((String) tabCliente.getValueAt(linha, 7));
            
        }
        
    }
    
    //Função para excluir um registro (linha) da tabela
    private void excluir() throws IOException {
        int linha = tabCliente.getSelectedRow();//Pega a linha selecionada pelo usuário
        
        //Verifica numa condição se o usuário clicou num índice (linha) da tabela ou não
        if(linha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha excluir!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
             
        }else{
            int confirma = JOptionPane.showConfirmDialog(null, "Confirma exclusão do registro?", "Confirmação", JOptionPane.YES_NO_OPTION);            
        
            //Se o usuário confirmar
            if(confirma == JOptionPane.YES_OPTION) {
                //Excluir linha da tabela
                DefaultTableModel dtmCliente = (DefaultTableModel) tabCliente.getModel();//Pega o modelo, ou seja, a forma da tabela Cliente
                dtmCliente.removeRow(linha);//Remove a linha selecionada
                JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                
                //Já tem IOException no método com throws
                transferirTabelaArquivo();//Transfere os dados da tabela para o arquivo texto, atualizando-o.
                
            //Se o usuário não confirmar, cancela a exclusão e imprime a mensagem
            }else{
                JOptionPane.showMessageDialog(null, "Exclusão cancelada!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                
            }
            
        }
        
    }
    
    //Função que limpa todos os campos
    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtDataNascimento.setText("");
        txtNumero.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
        radMasculino.setSelected(true);
        radFeminino.setSelected(false);
        combAtivo.setSelectedIndex(0);
    
    }
    
    //Função auxiliar para habilitar e desabilitar botões de forma dinâmica
    private void habilitarBotoes(boolean status) {
        btnSalvar.setEnabled(status);
        btnCancelar.setEnabled(status);
        
        btnNovo.setEnabled(!status);
        btnEditar.setEnabled(!status);        
        btnExcluir.setEnabled(!status);
        btnSair.setEnabled(!status);
        
        txtCodigo.setEnabled(status);
        txtNome.setEnabled(status);
        txtCpf.setEnabled(status);
        txtDataNascimento.setEnabled(status);
        txtNumero.setEnabled(status);
        txtPeso.setEnabled(status);
        txtAltura.setEnabled(status);
        
    }
    
    //Função para remover os acentos e caracteres especiais, isso deixa o texto limpo e facilita fazer comparações e buscas
    private String removerAcentos(String nome) {
        return java.text.Normalizer
            .normalize(nome, java.text.Normalizer.Form.NFD)
            .replaceAll("\\p{M}", "");
    }
    
    private void buscarClientes(String nomeConsulta) {
        //Verifica se o usuário digitou o código para consulta
        if(nomeConsulta == null || nomeConsulta.trim().isEmpty()) {
            areaResultado.setText("Digite um nome para pesquisar...");
            return;
            
        }
        
        //Chama aqui o método que remove os acentos e deixa minúsculo do nome digitado pelo usuário para consulta
        nomeConsulta = removerAcentos(nomeConsulta).toLowerCase();
        
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("========== REULTADO DA CONSULTA ==========\n\n");
        
        DefaultTableModel dtm = (DefaultTableModel) tabCliente.getModel();
        boolean encontrou = false;
        
        for(int i = 0; i < dtm.getRowCount(); i++) {
            String codigo = String.valueOf(dtm.getValueAt(i, 0));
            String nome = String.valueOf(dtm.getValueAt(i, 1));
            String cpf = String.valueOf(dtm.getValueAt(i, 2));
            String dataNascimento = String.valueOf(dtm.getValueAt(i, 3));
            String ativo = String.valueOf(dtm.getValueAt(i, 4));
            String sexo = String.valueOf(dtm.getValueAt(i, 5));
            String peso = String.valueOf(dtm.getValueAt(i, 6));            
            String altura = String.valueOf(dtm.getValueAt(i, 7));
            String numero = String.valueOf(dtm.getValueAt(i, 8));
            
            String nomeSemAcento = removerAcentos(nome).toLowerCase();
            
            if(nomeSemAcento.contains(nomeConsulta)) {
                relatorio.append("Código: ").append(codigo).append(" - ")
                        .append(nome).append("\n")
                        .append("- CPF: ").append(cpf).append("\n")
                        .append("- Data de Nascimento: ").append(dataNascimento).append("\n")
                        .append("- Estado Civil: ").append(ativo).append("\n")
                        .append("- Sexo: ").append(sexo).append("\n")
                        .append("- Peso: ").append(peso).append("\n")
                        .append("- Altura: ").append(altura).append("\n")
                        .append("- Número: ").append(numero).append("\n\n");
                
                encontrou = true;
                
            }
            
        }
        
        if(!encontrou) {
            relatorio.append("Não há registros para esse nome...");
            
        }
        
        areaResultado.setText(relatorio.toString());
                
    }
    
    private void gravarClienteArquivo(Object codigo, Object nome, Object cpf, Object dataNascimento, Object ativo, Object sexo, Object peso, Object altura, Object numero) throws IOException {
        try{
            //Cria a linha concatenada com o valor das variáveis
            String linha = codigo + ";" + nome + ";" + cpf + ";" + dataNascimento + ";" + ativo + ";" + sexo + ";" + peso + ";" + altura + ";" + numero;
            
            //BufferedWriter -> memória temporária | FileWriter -> escrever bytes/caracteres no arquivo (true = append)
            BufferedWriter wCliente = new BufferedWriter(new FileWriter(arquivo, true));
            wCliente.write(linha);//Grava a linha no arquivo
            wCliente.newLine();//Pula uma linha (quebra-de-linha no fim)
            wCliente.close();//Fecha o arquivo e libera o recurso da memória
            
            JOptionPane.showMessageDialog(null, "Dados gravados no arquivo texto com sucesso!", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        
        //Caso ocorra algum erro de abertura e escrita no arquivo
        }catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Erro: não foi possível gravar os dados no arquivo texto!" + e.getMessage());
            
        }
        
    }
    
    private void transferirTabelaArquivo() throws IOException {
        String linha;
        BufferedWriter wCliente = new BufferedWriter(new FileWriter(arquivo));
        DefaultTableModel dtmCliente = (DefaultTableModel) tabCliente.getModel();//Pega o modelo da tabela cliente
        int linhasTabela = dtmCliente.getRowCount();//Pega a quantidade de linhas da tabela cliente
        
        for(int i = 0; i < linhasTabela; i++) {
            Object codigo = dtmCliente.getValueAt(i, 0);           
            Object nome = dtmCliente.getValueAt(i, 1);
            Object cpf = dtmCliente.getValueAt(i, 2);
            Object dataNascimento = dtmCliente.getValueAt(i, 3);
            Object ativo = dtmCliente.getValueAt(i, 4);
            Object sexo = dtmCliente.getValueAt(i, 5);
            Object peso = dtmCliente.getValueAt(i, 6);
            Object altura = dtmCliente.getValueAt(i, 7);            
            Object numero = dtmCliente.getValueAt(i, 8);
            
            linha = codigo + ";" + nome + ";" + cpf + ";" + dataNascimento + ";" + ativo + ";" + sexo + ";" + peso + ";" + altura + ";" + numero;
            wCliente.write(linha);//Grava a linha no arquivo
            wCliente.newLine();//Vai pra linha de baixo
        }
        wCliente.close();//Fecha o arquivo
    }

    //Carregar os dados que estão no arquivo texto para a tabela
    private void carregarDadosTabela() {
        String linha;
        DefaultTableModel dtmCliente = (DefaultTableModel) tabCliente.getModel();
        try{
            BufferedReader rCliente = new BufferedReader(new FileReader(arquivo));
            while((linha = rCliente.readLine()) != null) {
                String[] campos = linha.split(";");
                dtmCliente.addRow(campos);
                
            }
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo texto: " + e.getMessage());
            
        }catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Erro: formato de dados incorretos no arquivo! " + e.getMessage());
            
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        radFeminino = new javax.swing.JRadioButton();
        radMasculino = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        combAtivo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabCliente = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaResultado = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        txtNomeConsulta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setMinimumSize(new java.awt.Dimension(1000, 625));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(54, 70, 78));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cadastro de Clientes");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 70));

        jLabel1.setText("Sexo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 200, -1));

        lblCodigo.setText("Código");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 100, -1));

        jLabel3.setText("CPF");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));
        getContentPane().add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 200, -1));

        jLabel9.setText("Número de Telefone (ddd xxxx-xxxx)");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 200, -1));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 310, -1));

        jLabel4.setText("Data de Nascimento (dd/mm/aaaa)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, -1, -1));
        getContentPane().add(txtDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 200, -1));

        jLabel5.setText("Ativo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        GroupSexo.add(radFeminino);
        radFeminino.setText("Feminino");
        getContentPane().add(radFeminino, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        GroupSexo.add(radMasculino);
        radMasculino.setSelected(true);
        radMasculino.setText("Masculino");
        getContentPane().add(radMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        jLabel6.setText("Nome");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jLabel7.setText("Peso (Kg)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));
        getContentPane().add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 90, -1));

        jLabel8.setText("Altura (m)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, -1, -1));
        getContentPane().add(txtAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 90, -1));

        combAtivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
        getContentPane().add(combAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Nascimento", "Ativo", "Sexo", "Peso (Kg)", "Altura (m)", "Número de Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabCliente.setAutoResizeMode(0);
        tabCliente.setAutoscrolls(false);
        tabCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabCliente);
        if (tabCliente.getColumnModel().getColumnCount() > 0) {
            tabCliente.getColumnModel().getColumn(0).setMinWidth(70);
            tabCliente.getColumnModel().getColumn(0).setMaxWidth(100);
            tabCliente.getColumnModel().getColumn(1).setMinWidth(200);
            tabCliente.getColumnModel().getColumn(2).setMinWidth(100);
            tabCliente.getColumnModel().getColumn(3).setMinWidth(100);
            tabCliente.getColumnModel().getColumn(4).setMinWidth(100);
            tabCliente.getColumnModel().getColumn(5).setMinWidth(100);
            tabCliente.getColumnModel().getColumn(6).setMinWidth(80);
            tabCliente.getColumnModel().getColumn(6).setMaxWidth(100);
            tabCliente.getColumnModel().getColumn(7).setMinWidth(80);
            tabCliente.getColumnModel().getColumn(7).setMaxWidth(100);
            tabCliente.getColumnModel().getColumn(8).setMinWidth(400);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 940, 280));

        btnEditar.setBackground(new java.awt.Color(54, 70, 78));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

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
        jPanel2.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

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
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, -1));

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
        jPanel2.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        btnSair.setBackground(new java.awt.Color(54, 70, 78));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.setBorderPainted(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel2.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        btnNovo.setBackground(new java.awt.Color(54, 70, 78));
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.setBorderPainted(false);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 1000, 340));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Fundo.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1000, 500));

        areaResultado.setColumns(20);
        areaResultado.setRows(5);
        jScrollPane2.setViewportView(areaResultado);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 590, 480, 200));

        jLabel11.setText("Digite o nome abaixo:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));

        btnConsultar.setBackground(new java.awt.Color(54, 70, 78));
        btnConsultar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar");
        btnConsultar.setBorderPainted(false);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, -1, -1));
        getContentPane().add(txtNomeConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 300, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();//Fecha apenas a janela atual, mas não encerra o programa
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        operacao = "novo";//A operação é de novo (cadastrar novo cliente)
        habilitarBotoes(true);
        limparCampos();
        txtCodigo.requestFocus();//Coloca em foco o campo codigo
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(validarDados()) {
            //Aqui tratamento de erro porque o método gravarClienteArquivo é chamado dentro do método inserirRegistroTabela()
            try{
                inserirRegistroTabela();
                //O método gravarClienteArquivo() chamado dentro do método inserirRegistroTabela()

            }catch(IOException ex) {
                System.getLogger(telaCadCliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            limparCampos();
            habilitarBotoes(false);//Retorna ao estado inicial dos botões
            
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(txtCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja editar!");
            
        }else{
            operacao = "editar";
            habilitarBotoes(true);
            txtNome.requestFocus();//Coloca o foco no campo nome
            
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try{
            excluir();
        }catch(IOException ex) {
            System.getLogger(telaCadCliente.class.getName()).log(Logger.Level.ERROR, (String) null, ex);
        }
        limparCampos();
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabClienteMouseClicked
        //Se o usuário clicar duas vezes em alguma linha da tabela
        if(evt.getClickCount() == 2) {
            try{
                excluir();
            }catch(IOException ex) {
                System.getLogger(telaCadCliente.class.getName()).log(Logger.Level.ERROR, (String) null, ex);
            }
            limparCampos();
            
        }
        
        carregarDados();
        
    }//GEN-LAST:event_tabClienteMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitarBotoes(false);
        limparCampos();
    
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        buscarClientes(txtNomeConsulta.getText());
        txtNomeConsulta.setText("");
        
    }//GEN-LAST:event_btnConsultarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new telaCadCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupSexo;
    private javax.swing.JTextArea areaResultado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> combAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JRadioButton radFeminino;
    private javax.swing.JRadioButton radMasculino;
    private javax.swing.JTable tabCliente;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeConsulta;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
}
