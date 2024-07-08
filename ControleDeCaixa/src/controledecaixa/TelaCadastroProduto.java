package controledecaixa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import javax.swing.SwingUtilities;

public class TelaCadastroProduto extends javax.swing.JFrame {
    
    private TelaInicio telaPrincipal;
    
    //construtor, recebe a referncia da tela principal para fazer a comunicação
    public TelaCadastroProduto(TelaInicio telaPrincipal) {
        initComponents();
        this.telaPrincipal = telaPrincipal;
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/img.png")).getImage());
        
        Estoque estoque = telaPrincipal.getEstoque();
        DefaultTableModel dtmEstoque = (DefaultTableModel) estoqueAtual.getModel();
        
//array list usado para auxiliar a inserção de produtos na tabela
        ArrayList<Produto> produtos = estoque.resgatarEstoque();
        Iterator iterator = produtos.iterator();
        
        //os produtos são inseridos na tabela
        while (iterator.hasNext()){
            Produto p = (Produto) iterator.next();
            dtmEstoque.addRow(new Object[]{p.getNome(), p.getValor(), p.getEstoque()});
        }      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cadastroNomeProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cadastroPrecoProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cadastroEstoqueProduto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        estoqueAtual = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        botaoCancelarSelecao = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar estoque");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar um produto ao estoque", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Nome do produto");

        cadastroNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroNomeProdutoActionPerformed(evt);
            }
        });

        jLabel2.setText("Preço (apenas numeros)");

        jLabel3.setText("Quantidade (apenas numeros)");

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cadastroPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastroEstoqueProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(cadastroNomeProduto))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastroNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastroPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastroEstoqueProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estoque atual", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        estoqueAtual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor", "Estoque"
            }
        ));
        estoqueAtual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estoqueAtualMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(estoqueAtual);

        jButton3.setText("Remover produto selecionado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Você pode editar os preços e quantidade de um produto já existente na tabela");

        botaoCancelarSelecao.setText("Cancelar seleção");
        botaoCancelarSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarSelecaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(botaoCancelarSelecao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(botaoCancelarSelecao)))
        );

        botaoCancelarSelecao.setVisible(false);

        jButton2.setText("Confirmar mudanças");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastroNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastroNomeProdutoActionPerformed

    //botao de confirmação
    //ao ser pressionado, verifica os dados digitados para poder adicionar o produto ao estoque
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try{
            //resgata os dados digitados
            //se um dos numeros int ou double estiver errado, uma mensagem de erro é mostrada
            String nome = cadastroNomeProduto.getText();
            
            //é necessário verificar se o nome digitado é identico a algum noma ja existente
            //assim, em vez de inserir um novo, o valor sera atualizado
            DefaultTableModel model = (DefaultTableModel) estoqueAtual.getModel();
            int rowCount = model.getRowCount();
            boolean existe = false;
            
            for (int i = 0; i < rowCount; i++) {
                String nomeNaTabela = model.getValueAt(i, 0).toString(); // 0 é o índice da primeira coluna

                if (nomeNaTabela.equals(nome)) {
                    existe = true;
                }
            }
            
            if (existe){
               int linhaSelecionada = estoqueAtual.getSelectedRow();
               String novoNome = cadastroNomeProduto.getText();
               String novoValor = cadastroPrecoProduto.getText();
               String novaQuantidade = cadastroEstoqueProduto.getText();
               
               model.setValueAt(novoNome, linhaSelecionada, 0);
               model.setValueAt(novoValor, linhaSelecionada, 1);
               model.setValueAt(novaQuantidade, linhaSelecionada, 2);
                
            } else {
                nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);

                double valor = Double.parseDouble(cadastroPrecoProduto.getText());
                int estoque = Integer.parseInt(cadastroEstoqueProduto.getText());

                //cria um novo produto e envia como parametro para a tela inicial
                //lá possui uma função que adiciona o produto no estoque e na tabela
                Produto p = new Produto(nome, valor, estoque);

                DefaultTableModel dtmEstoque = (DefaultTableModel) estoqueAtual.getModel();
                dtmEstoque.setRowCount(0);
                Estoque estoqueTelaPrincipal = telaPrincipal.getEstoque();
                ArrayList<Produto> produtos = estoqueTelaPrincipal.resgatarEstoque();

                produtos.add(p);
                Collections.sort(produtos);

                Iterator iterator = produtos.iterator();

                while (iterator.hasNext()){
                    Produto produtoIterator = (Produto) iterator.next();
                    dtmEstoque.addRow(new Object[]{produtoIterator.getNome(), produtoIterator.getValor(), produtoIterator.getEstoque()});
                }
                //this.dispose();
            }  
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Algo deu errado, verifique o que você digitou!", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    //ação do botão de confirmar mudanças
    //ao pressionar, a edição do estoque seria confirmada
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) estoqueAtual.getModel();
        int rowCount = model.getRowCount();
        ArrayList<Produto> produtos = new ArrayList<>();
        
        for (int i = 0; i < rowCount; i++) {
            String nome = (String) model.getValueAt(i, 0); // Coluna 0 para o nome
            double valor = (double) model.getValueAt(i, 1); // Coluna 1 para o valor
            int estoque = (int) model.getValueAt(i, 2); // Coluna 2 para o estoque

            Produto produto = new Produto(nome, valor, estoque);
            produtos.add(produto);
        }
        
        Collections.sort(produtos);
        
        telaPrincipal.atualizarEstoque(produtos);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    //ação do botão de remover produtos da tabela
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       try{
        DefaultTableModel dtmEstoque = (DefaultTableModel) estoqueAtual.getModel();
        int selectedRow = estoqueAtual.getSelectedRow(); // Obtém a linha selecionada
        
        if (selectedRow >= 0) {
        // Remove a linha selecionada do modelo de dados da tabela
            dtmEstoque.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item para remover!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
           
       } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Algo deu errado!", "Atenção!",JOptionPane.WARNING_MESSAGE);
        } 
        
    }//GEN-LAST:event_jButton3ActionPerformed

    //ação caso o mouse clique na tabela
    private void estoqueAtualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estoqueAtualMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) estoqueAtual.getModel();
        int rowIndex = estoqueAtual.getSelectedRow();
        
        cadastroNomeProduto.setText(model.getValueAt(rowIndex, 0).toString());
        cadastroPrecoProduto.setText(model.getValueAt(rowIndex, 1).toString());
        cadastroEstoqueProduto.setText(model.getValueAt(rowIndex, 2).toString());
        
        botaoCancelarSelecao.setVisible(true);
        
    }//GEN-LAST:event_estoqueAtualMouseClicked

    private void botaoCancelarSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarSelecaoActionPerformed
        DefaultTableModel model = (DefaultTableModel) estoqueAtual.getModel();
        int selectedRow = estoqueAtual.getSelectedRow();
        
        if (selectedRow != -1) {
            estoqueAtual.removeRowSelectionInterval(selectedRow, selectedRow);
        }
        
        botaoCancelarSelecao.setVisible(false);
        
        cadastroNomeProduto.setText(null);
        cadastroEstoqueProduto.setText(null);
        cadastroPrecoProduto.setText(null);
        
        
    }//GEN-LAST:event_botaoCancelarSelecaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            TelaInicio telaInicio = new TelaInicio();
            
            public void run() {
                new TelaCadastroProduto(telaInicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelarSelecao;
    private javax.swing.JTextField cadastroEstoqueProduto;
    private javax.swing.JTextField cadastroNomeProduto;
    private javax.swing.JTextField cadastroPrecoProduto;
    private javax.swing.JTable estoqueAtual;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
