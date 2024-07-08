package controledecaixa;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class TelaInicio extends javax.swing.JFrame { 
    private Serializar serializar; //objeto para fazer a serialização
    //nele contem os metodos usados para serializar os objetos dessa classe
    private Dados dados; //objeto que armazena todos os objetos usados para armazenar dados
    //todos eles ficam armazenado assim, pois fica mais facil serialziar um objeto apenas do que vários

    //variaveis usadas para guardar os dados apenas aqui
    //elas guardam enquanto o programam estiver sendo executado
    //mas em momento da logica, esses dados são transferidos para o objeto "Dados" e serializados
    //assim todos são serialziados de uma so vez
    private double caixa; //guarda o valor no caixa, todo o dinheiro arrecadado com as vendas
    private Estoque estoque; //guarda a lista de produtos disponiveis para a compra
    private LinkedHashMap <String, Funcionario> funcionariosCadastrados; //guarda os funcionarios cadastrados no sistema
    private LinkedHashMap <String, Registro> registroDeVendas; //guarda o registro geral de vendas
    private Funcionario funcionarioLogado; //guarada o funcionario logado no sistema atualmente
    private LinkedHashMap <String, Registro> registroPorFuncionario; //guarda os registros especificos de cada funcionario
    //esse registro por funcionario é atualizado em cada compra feita com o funcionario logado atualmente
    //ao final, esse registro é associado ao funcionario logado
    //assim cada funcionario terá o seu proprio registro de vendas

    //construtor
    public TelaInicio() {
        
        //define o icone da janela
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/img.png")).getImage());
        
        //logica para receber os dados serialziados
        //se o retorno for null, significa que nap ha dados serializados ainda
        serializar  = new Serializar();
        dados  = (Dados) serializar.desserializarObjeto();
        
        //não ha dados serializados ainda
        if (dados == null){
            //as variaveis são inicializadas normalmente
            caixa = 0.0;
            estoque = new Estoque();
            registroDeVendas = new LinkedHashMap<>();
            funcionariosCadastrados = new LinkedHashMap<>();
            registroPorFuncionario = new LinkedHashMap<>();
            
            dados =  new Dados ();
            dados.guardarArquivos(caixa, estoque, funcionariosCadastrados, registroDeVendas, registroPorFuncionario);
            serializar.serializar(dados); //e depois serializadas
            //essa logica é executada apenas uma vez, quando o programam em iniciado pela primeira vez em um computador
            //ou quando os dados forem perdidos
        } else {
            //caso o retorno são seja null, significa que ja existem dados guardados no sistema
            //então, as variaveis são inicializadas com o retorno desses dados
            caixa = dados.getCaixa();
            estoque = dados.getEstoque();
            registroDeVendas = dados.getRegistroDeVendas();
            funcionariosCadastrados = dados.getFuncionariosCadastrados();
            registroPorFuncionario = dados.getRegistroPorFuncionario();
        }
        
        //verifica se o registro de funcionários está vazio
        //se estiver, um funcionario padrão é criado para que o sistema possa ser acessado
        //é recomendados excluir esse funcionario padrão para que o acesso aos dados seja privado
        if (funcionariosCadastrados.isEmpty()){
            funcionariosCadastrados.put("a", new Funcionario("a", true, "123"));
            funcionarioLogado = funcionariosCadastrados.get("a");
        }
        
        initComponents(); //os componentes da interface grafica são inicializados
        
        preencherTabela(estoque.resgatarEstoque()); //metodo que preenche a tabela de estoque mostrada na tela inicial
        resgatarHora(); //metodo que resgata a hora do sistema e coloca na label
        
        //antes dessa tela ser mostrada, o login precisa ser feito
        //então esta tela (a tela inicial) não é visivel inicialmente, apesar de ja existir
        //em vez dela, uma tela de login é criada para reber o usuario
        //a lista de funcionarios é enviada daqui para ela
        //assim ela verifica se o funcionario logado existe, e se a senha esta correta
        new TelaLogin(funcionariosCadastrados, this).setVisible(true);
    }
    
    //metodo que resgata a hora do sistema
    public void resgatarHora(){
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");

                String horaAtual = horaFormat.format(new Date());
                String dataAtual = dataFormat.format(new Date());
                
                //as horas foram resgatadas, agora são atribuidas às labels
                labelRelogio.setText(horaAtual);
                labelData.setText(dataAtual);
            }
        });

        timer.start(); 
    }
    
    //metodo para preencher a tabela de estoque
    public void preencherTabela(ArrayList<Produto> produtos){
        //resgata o estoque guardado 
        DefaultTableModel dtmEstoque = (DefaultTableModel) estoqueProdutos.getModel(); //modelo da tabela
        dtmEstoque.setRowCount(0);
        //percorre o estoque e insere na tabela
        Iterator iterator = produtos.iterator();
        while (iterator.hasNext()){
            Produto p = (Produto) iterator.next();
            dtmEstoque.addRow(new Object[]{p.getNome(), p.getValor(), p.getEstoque()}); //adicionando uma linha na tabela 
        }
        
    }

    //esse metodo recebe da tela de login o funcionario que foi logado
    //ele so é chamado se o login for bem sucedido
    //o funcionario logado é passado por parametro
    //assim, as vendas que ele fez são inseridas no registro dele
    //ao final, o funcionario logado é procurado na tabela, e seus registros são guardados
    public void funcionarioLogado(Funcionario funcionarioLogado){
        this.funcionarioLogado = funcionarioLogado; //o funcionario logado é recebido
        registroPorFuncionario = funcionarioLogado.getRegistroDeVendas(); //o registro dele também é guardado
        this.setVisible(true); //por fim, a tela atual (que é a tela inicial) é mostrada ao usuario
    }
    
    //metodo usado para testes, quando necessario
    /*
    public void imprimirChavesDoLinkedHashMap(LinkedHashMap<String, Registro> map) {
        System.out.println(map.size());
        
        for (Object chave : map.keySet()) {
            System.out.println("Chave: " + chave.toString());
        }
    }
    */
    
    //a cada venda, o caixa é incrementado
    //esse metodo trata de fazer isso
    public void definirCaixa(double novoValor){
        DecimalFormat df = new DecimalFormat("0.00");
        caixa += novoValor;
        jLabel2.setText(df.format(caixa));
    }

    //esse metodo trata a atualização do estoque sempre que uma compra é feita (ou o estoque é editado)
    //
    public void atualizarEstoque(ArrayList<Produto> novoEstoque){
        //antiga logica de atualizar a tabela
        //talvez eu precise retornar ao original, então fica comentada
        //DefaultTableModel dtmEstoque = (DefaultTableModel) estoqueProdutos.getModel();
        //dtmEstoque.setRowCount(0);
        /*
        Iterator iterator = novoEstoque.iterator();
        while (iterator.hasNext()){
            Produto p = (Produto) iterator.next();
            dtmEstoque.addRow(new Object[]{p.getNome(), p.getValor(), p.getEstoque()});
        }
        */
        
        //recebe o estoque atualziado de uma outra tela
        estoque.setEstoque(novoEstoque); //o estoque antigo é substituido pelo novo
        //seja apos uma compra, ou apos a edição do estoque pelo ADM
        
        preencherTabela(novoEstoque); //o metodo de preencher a tabela é chamado
        
        //perceba que os dados novos são augrdados no objeto "Dados"
        //isso é feito para reunir os dados em um objeto só e facilitar a serialização
        dados.guardarArquivos(caixa, estoque, funcionariosCadastrados, registroDeVendas, registroPorFuncionario);
        serializar.serializar(dados); //todos os dados são serialziados de uma vez, pois todos eles estão em um objeto só
    }
    
    //metodo usado quando a lista de funcionarios for editada
    //edição de dados existentes, remoção ou adição
    public void atualizarFuncionarios (LinkedHashMap <String, Funcionario> funcionarios){
        this.funcionariosCadastrados = funcionarios; //recebe a nova lista de funcionarios de uma outra tela
        
        for (Map.Entry<String, Funcionario> entry : funcionariosCadastrados.entrySet()) {
            String key = entry.getKey();
            Funcionario value = entry.getValue();
        }
        //os dados são guardados de novo
        dados.guardarArquivos(caixa, estoque, funcionariosCadastrados, registroDeVendas, registroPorFuncionario);
        serializar.serializar(dados);
    }

    //metodo para registrar uma venda no registro geral
    //é relativamente complexo, necessita da data e hora do momento em que ela foi concluida
    public void registrarVenda(ArrayList<Produto> vendidos, Double valorArrecadado){
        //resgata a data e hora
        LocalDateTime horaAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = horaAtual.format(formatter);
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = horaAtual.format(dataFormatter);
        
        //vefica se a data resgatada ja existe no registro
        //se sim, significa que uma venda já foi feita hoje e basta acrescentar mais uma
        //se não, significa que não há registros para hoje, e é necessários criar um
        if (registroDeVendas.containsKey(dataFormatada)){
            //caso a data já exista
            Registro registro = registroDeVendas.get(dataFormatada);
            registro.adicionarRegistro(horaFormatada, vendidos);
            registroDeVendas.put(dataFormatada, registro);
            
        } else {
            //caso a data não exista ainda
            Registro registro = new Registro();
            registro.adicionarRegistro(horaFormatada, vendidos);
            registroDeVendas.put(dataFormatada, registro);
        }
        
        dados.guardarArquivos(caixa, estoque, funcionariosCadastrados, registroDeVendas, registroPorFuncionario);
        serializar.serializar(dados);
    }

    //o metodo de registrar venda por funcionario é muito parecido com registrar uma venda no registro geral
    //o registro por funcionario nada mais é do que um registro geral que fica armazenado dentro do objeto Funcionario
    //então a logica é a mesma, a diferença é que o código atribui esse registro ao funcionario logado
    public void registrarVendaFuncionario(ArrayList<Produto> vendidos, Double valorArrecadado){
        LocalDateTime horaAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = horaAtual.format(formatter);
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = horaAtual.format(dataFormatter);

        if (registroPorFuncionario.containsKey(dataFormatada)){
            Registro registro = registroPorFuncionario.get(dataFormatada);
            registro.adicionarRegistro(horaFormatada, vendidos);
            registroPorFuncionario.put(dataFormatada, registro);
            
        } else {
            Registro registro = new Registro();
            registro.adicionarRegistro(horaFormatada, vendidos);
            registroPorFuncionario.put(dataFormatada, registro);
        }
        
        //logica de atribuição do registro no funcionario logado
        funcionarioLogado.setRegistroDeVendas(registroPorFuncionario);
        funcionariosCadastrados.put(funcionarioLogado.getNome(), funcionarioLogado);
        //guarda os dados, serializa
        dados.guardarArquivos(caixa, estoque, funcionariosCadastrados, registroDeVendas, registroPorFuncionario);
        serializar.serializar(dados);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoNovaVenda = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        estoqueProdutos = new javax.swing.JTable();
        labelRelogio = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastrar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        opcaoRelatorioDeVendas = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Controle de vendas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        botaoNovaVenda.setText("Nova Venda");
        botaoNovaVenda.setToolTipText("");
        botaoNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovaVendaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Caixa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        DecimalFormat df = new DecimalFormat("0.00");
        jLabel2.setText(df.format(caixa));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("R$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estoque"));

        estoqueProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(estoqueProdutos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        labelRelogio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelRelogio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        labelData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        menuCadastrar.setText("Configurações");

        jMenuItem1.setText("Editar estoque");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuCadastrar.add(jMenuItem1);

        jMenuItem2.setText("Editar funcionarios cadastrados");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuCadastrar.add(jMenuItem2);

        jMenuItem4.setText("Editar caixa");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuCadastrar.add(jMenuItem4);

        jMenuBar1.add(menuCadastrar);

        jMenu1.setText("Relatório");

        opcaoRelatorioDeVendas.setText("Relatório de vendas geral");
        opcaoRelatorioDeVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoRelatorioDeVendasActionPerformed(evt);
            }
        });
        jMenu1.add(opcaoRelatorioDeVendas);

        jMenuItem3.setText("Relatório por funcionário");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Mais");

        jMenuItem5.setText("Logout");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Sair do programa");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Sobre...");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRelogio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 188, 188)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRelogio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelData)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //logica do botão de iniciar uma nova venda
    private void botaoNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaVendaActionPerformed
        new TelaVendas(this).setVisible(true); //uma nova tela é criada
    }//GEN-LAST:event_botaoNovaVendaActionPerformed
  
    //logica da opção de editar registro do produto
    //perceba que ela faz uma verificação
    //o que ela faz é verificar se o funcionario logado atualmente possui permissão para acessar essa tela
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (funcionarioLogado.isPermissoes()){
            TelaCadastroProduto tCadastro = new TelaCadastroProduto(this);
            tCadastro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar esta área!", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    //logca da opção de vero relatorio
    private void opcaoRelatorioDeVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoRelatorioDeVendasActionPerformed
        new TelaRegistroDeVendas(this).setVisible(true);

    }//GEN-LAST:event_opcaoRelatorioDeVendasActionPerformed

    //caso a tela seja fechada, é pergundao ao usuário se ele realemnte quer
    //se sim, os dados são serialziados e a tela é fechada
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirmacao = JOptionPane.showConfirmDialog(null,"Tem certeza que você quer encerrar o programa?", "Selecione", JOptionPane.YES_NO_OPTION);
        
        if (confirmacao == JOptionPane.YES_OPTION){
            funcionarioLogado.setRegistroDeVendas(registroPorFuncionario);
            dados.guardarArquivos(caixa, estoque, funcionariosCadastrados, registroDeVendas, registroPorFuncionario);
            serializar.serializar(dados);
            this.dispose();
        }  
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (funcionarioLogado.isPermissoes()){
            new TelaFuncionarios(this).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar esta área!", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    //logica da opção de ver registro por funcionarios
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new TelaRegistroPorFuncionario(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    //logica da opção de editar o caixa
    //apenas funcionarios permitidos podem editar 
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        if (funcionarioLogado.isPermissoes()){
            new TelaEditarCaixa(this).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Você não tem permissão para acessar esta área!", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    //logica da opção de deslogar (louout)
    //uma nova tela inicial é criada
    //essa tela é apagada
    //o programa começa de novo
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.setVisible(false);
        new TelaInicio().setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    //a segunda opção de sair
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(null,"Tem certeza que você quer encerrar o programa?", "Selecione", JOptionPane.YES_NO_OPTION);
        
        if (confirmacao == JOptionPane.YES_OPTION){
            funcionarioLogado.setRegistroDeVendas(registroPorFuncionario);
            dados.guardarArquivos(caixa, estoque, funcionariosCadastrados, registroDeVendas, registroPorFuncionario);
            serializar.serializar(dados);
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    //opção da tela "sobre..."
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new TelaSobre().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    //os gets e sets utlizados
    public Estoque getEstoque(){
        return estoque;
    }
    
    public double getCaixa(){
        return caixa;
    }
    
    public void setCaixa (double caixa){
        this.caixa = caixa;
    }
    
    public LinkedHashMap getRegistro(){
        return registroDeVendas;
    }
    
    public LinkedHashMap getFuncionarios(){
        return funcionariosCadastrados;
    }
    
    public void setFuncionarios(LinkedHashMap<String, Funcionario> funcionarios){
        funcionariosCadastrados = funcionarios;
    }

    //o main dessa tela
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaInicio().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoNovaVenda;
    private javax.swing.JTable estoqueProdutos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelRelogio;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenuItem opcaoRelatorioDeVendas;
    // End of variables declaration//GEN-END:variables
}
