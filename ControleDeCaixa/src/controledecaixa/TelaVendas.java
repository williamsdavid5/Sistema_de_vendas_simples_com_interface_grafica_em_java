package controledecaixa;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaVendas extends javax.swing.JFrame {
    
    //atributos da classe
    private TelaInicio telaPrincipal;
    private DefaultTableModel dtmEstoque;
    private double valorArrecadado;
    
    //construtor
    //ele recebe uma referencia da tela principal (a tela do qual ele foi inicializado
    //isso permite a comunucação entre as duas)
    public TelaVendas(TelaInicio telaPrincipal) {
        initComponents();
        valorArrecadado = 0.0;
        this.telaPrincipal = telaPrincipal;
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/img.png")).getImage());
        
        //resgata o estoque da tela principal e insere na combobox
        //assim o usuario vai poder selecionar apenas o produto que está disponivel
        Estoque estoque = telaPrincipal.getEstoque();
        ArrayList<Produto> produtosDisponiveis = estoque.resgatarEstoque();
        Iterator iterator = produtosDisponiveis.iterator();

        while (iterator.hasNext()){
            Produto atual = (Produto) iterator.next();
            if (atual.getEstoque() > 0){
                comboProdutos.addItem(atual.getNome());
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboProdutos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        vendaQuantidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botaoInserir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        carrinhoTabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vender");
        setResizable(false);

        comboProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProdutosActionPerformed(evt);
            }
        });

        jLabel1.setText("Produto");

        jLabel2.setText("Quantidade");

        jLabel3.setText("Valor atual");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("0.0");

        botaoInserir.setText("Inserir item");
        botaoInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInserirActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho de compras"));

        carrinhoTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor", "Quantidade", "Arrecadado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(carrinhoTabela);

        jButton1.setText("Confirmar Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remover item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vendaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoInserir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vendaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(botaoInserir)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProdutosActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_comboProdutosActionPerformed

    //ação do botão de inserir na tabela (carrinho de compras)
    private void botaoInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInserirActionPerformed

        try{
            DefaultTableModel dtmEstoque = (DefaultTableModel) carrinhoTabela.getModel();
            
            //resgata o item selecionado para ser usado futuramemte
            Object itemSelecionado = comboProdutos.getSelectedItem();
            String nomeProduto = itemSelecionado.toString();
            
            int quantidade = Integer.parseInt(vendaQuantidade.getText()); //recebe a quantidade digitada pelo usuario
            //se o usuario digitar algo que não seja um numero inteiro, uma mensagem de erro é mostrada, por isso o try
            
            
            
            //resgata o estoque em busca do valor e da quantidade disponivel do produto que o usuario escolheu
            Estoque estoque = telaPrincipal.getEstoque();
            ArrayList<Produto> produtos = estoque.resgatarEstoque();
            Iterator iterator = produtos.iterator();
            
            double valor;
            
            while (iterator.hasNext()){
                Produto p = (Produto) iterator.next();
                if (p.getNome().equals(nomeProduto)){
                    
                    //so adiciona no carrinho se a quantidade for valida
                    if (p.getEstoque() < quantidade){
                        JOptionPane.showMessageDialog(null, "Você está tentando comprar mais do que há no estoque!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    } else {
                        valor = p.getValor();
                        double arrecadado = quantidade*valor;
                        Object[] objeto = {nomeProduto, valor, quantidade, arrecadado};
                        dtmEstoque.addRow(objeto);
                        comboProdutos.removeItem(itemSelecionado);
                        valorArrecadado += valor*quantidade;
                        
                        DecimalFormat df = new DecimalFormat("0.00");
                        jLabel4.setText(df.format(valorArrecadado));
                        break;
                    }
                }
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Algo deu errado! verifique o que você digitou", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_botaoInserirActionPerformed
 
//ação do botão de remover produto da tebla
    //se o usuario digitar a quantidade errada, ele pode remover o produto e inserir novamente 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try{
        DefaultTableModel dtmEstoque = (DefaultTableModel) carrinhoTabela.getModel();
        int selectedRow = carrinhoTabela.getSelectedRow(); // Obtém a linha selecionada

        Object nomeNaTabela = dtmEstoque.getValueAt(selectedRow, 0);
        Object valorNaTabela = dtmEstoque.getValueAt(selectedRow, 1);
        Object quantidadeNaTablea = dtmEstoque.getValueAt(selectedRow, 2);
        
        if (selectedRow >= 0) {
        // Remove a linha selecionada do modelo de dados da tabela
            dtmEstoque.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item para remover.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

        //toda essa logica abaixo é para poder adicionar novamente o produto na combobox em ordem alfabetica
        //ordem alfabetica facilita a visualização do usuário
        ArrayList<String> elementosComboBox = new ArrayList<>();
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboProdutos.getModel();

        for (int i = 0; i < model.getSize(); i++) {
            String item = model.getElementAt(i);
            elementosComboBox.add(item);
        }
        
        elementosComboBox.add(nomeNaTabela.toString());
        Collections.sort(elementosComboBox);
        
        comboProdutos.removeAllItems();
        
        for (String item : elementosComboBox) {
            comboProdutos.addItem(item);
        }

        //depois de inserir o elemento no0 comboBox, também é necessário subtrair o valor da variavel que mostra o total da compra
       Double paraSubtrair = Double.parseDouble(valorNaTabela.toString());
       Double quantidade = Double.parseDouble (quantidadeNaTablea.toString());
       
       valorArrecadado -= (paraSubtrair*quantidade);
       
       jLabel4.setText(Double.toString(valorArrecadado));

        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Você está tentando comprar mais do que há no estoque!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //ação do botão de confirmar a venda dos produtos no carrinho
    //é ele quem faz a subtração do estoque, ele apenas envia um novo estoque a tela inicial e ela usa
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        try{
            dtmEstoque = (DefaultTableModel) carrinhoTabela.getModel();

            //a logica abaixo recupera os produtos na tabela do carrinho e armazena em um arryList"
            int numRows = dtmEstoque.getRowCount();

            ArrayList<Produto> carrinho = new ArrayList<>(); //arrysList que ira guardar apenas os produtos comprados
            
            //esse laço de repetição percorre a jtable e recupera os dados dela
            //um objeto produto é criado e armazenado na collection do carrinho
            for (int row = 0; row < numRows; row++) {
                String nomeProduto;
                double arrecadado;
                int quantidadeProduto;
                
                //referente ao nome do produto na tabela
                Object objeto = dtmEstoque.getValueAt(row, 0);
                nomeProduto = objeto.toString();
                
                //referente ao valor adquirido do produto
                objeto = dtmEstoque.getValueAt(row, 3);
                arrecadado = Double.parseDouble(objeto.toString());

                //referente a quantidade adquirida do produto
                objeto = dtmEstoque.getValueAt(row, 2);
                quantidadeProduto = Integer.parseInt(objeto.toString());

                //normalmente um objeto do tipo produto iria guardar seu nome, seu valor e sua quantidae no estoque
                //nesse caso, ele ira guardar o quanto foi arrecadado nesta compra e a quantidade dele que foi comprada
                Produto p = new Produto (nomeProduto, arrecadado, quantidadeProduto);
                
                carrinho.add(p);

            }
            
            ArrayList<Produto> estoque = telaPrincipal.getEstoque().resgatarEstoque(); //estoque recuperado da tela principal
            //com esse estoque, sera feito o calculo de quantos produtos foram subtraidos
            
            Iterator iteratorEstoque = estoque.iterator();
       
            while (iteratorEstoque.hasNext()){
                Produto produtoNoEstoque = (Produto) iteratorEstoque.next();

                Iterator iteratorCarrinho = carrinho.iterator();
                while (iteratorCarrinho.hasNext()){
                    Produto produtoNoCarrinho = (Produto) iteratorCarrinho.next();

                    if (produtoNoCarrinho.getNome().equals(produtoNoEstoque.getNome())){
                        int quantidade = produtoNoCarrinho.getEstoque();
                        produtoNoEstoque.setEstoque(produtoNoEstoque.getEstoque() - quantidade);
                    }
                }
            }
            
            telaPrincipal.atualizarEstoque(estoque);
            telaPrincipal.definirCaixa(valorArrecadado);
            telaPrincipal.registrarVenda(carrinho, valorArrecadado);
            telaPrincipal.registrarVendaFuncionario(carrinho, valorArrecadado);
            
            this.dispose();
        } catch (Exception e){
            //System.out.println(e);
            JOptionPane.showMessageDialog(null, "Algo deu errado! nada foi alterado", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    //metodo main dessa janela
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
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            
            TelaInicio telaInicio = new TelaInicio();
            
            public void run() {
                new TelaVendas(telaInicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoInserir;
    private javax.swing.JTable carrinhoTabela;
    private javax.swing.JComboBox<String> comboProdutos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField vendaQuantidade;
    // End of variables declaration//GEN-END:variables
}
