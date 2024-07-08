package controledecaixa;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaRegistroPorFuncionario extends javax.swing.JFrame {

    private TelaInicio telaPrincipal;
    private LinkedHashMap <String, Funcionario> funcionariosCadastrados; //a lisra com todos os funcionarios
    
    public TelaRegistroPorFuncionario(TelaInicio telaPrincipal) {
        initComponents();
        
        this.telaPrincipal = telaPrincipal;
        
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/img.png")).getImage());
        
        try {
            funcionariosCadastrados = telaPrincipal.getFuncionarios(); //resgata os funcionarios que estão armazenados na tela inicial
            ArrayList<String> nomesChaves = new ArrayList(); //lista de chaves (nomes no caso) do hashmap de funcionarios
            
            //resgata as chaves para inserir na comboBox
            for (Map.Entry<String, Funcionario> entry : funcionariosCadastrados.entrySet()) {
                String chave = entry.getKey();
                //nomesChaves.add(chave);
                
                comboFuncionarios.addItem(chave); //os nomes são inseridos na comboBox
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Algo deu errado!!!!", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }
    }

    //metodo exclusivo para preencher a jTable de acordo com o item da comboBox selecionado
    private void escolherFuncionario(Funcionario funcionario) {
        try {
            comboDiasRegistro.removeAllItems();
            ArrayList<String> dataChaves = new ArrayList<>();

            LinkedHashMap<String, Registro> registro = funcionario.getRegistroDeVendas();
            for (Map.Entry<String, Registro> entry : registro.entrySet()) {
                String chave = entry.getKey();
                dataChaves.add(chave);
            }

            Collections.reverse(dataChaves);
            Iterator iterator = dataChaves.iterator();
            while (iterator.hasNext()) {
                String a = (String) iterator.next();
                comboDiasRegistro.addItem(a);
            }

            preencherTabela((String) comboDiasRegistro.getSelectedItem(), registro);
        } catch (Exception e) {
            // Handle exceptions if necessary
        }
    }

    
    private void preencherTabela(String dataAtual, LinkedHashMap <String, Registro> registro){
        DefaultTableModel dtmEstoque = (DefaultTableModel) tabelaRegistro.getModel();
        dtmEstoque.setRowCount(0);
        
        Registro registroAtual = registro.get(dataAtual);
        LinkedHashMap<String, ArrayList<Produto>> produtosDoDia = registroAtual.getRegistrodavenda();
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<String> horarios = new ArrayList<>(produtosDoDia.keySet());
        
        Collections.reverse(horarios);
        
        Iterator iterator = horarios.iterator();
        while (iterator.hasNext()){
            String horario = (String) iterator.next();
            produtos = produtosDoDia.get(horario);
            Collections.reverse(produtos);
            
            Iterator iterator2 = produtos.iterator();
            while (iterator2.hasNext()){
                Produto p = (Produto) iterator2.next();
                //Object o = new Object(horario);
                dtmEstoque.addRow(new Object[]{horario, p.getNome(), Integer.toString(p.getEstoque()), Double.toString(p.getValor())}); 
            }
        }
        tabelaRegistro.setModel(dtmEstoque);
        this.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboFuncionarios = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboDiasRegistro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRegistro = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro por funcionário");
        setResizable(false);

        jLabel1.setText("Funcionario");

        comboFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboFuncionariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboFuncionariosMouseEntered(evt);
            }
        });
        comboFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFuncionariosActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Registro do dia");

        comboDiasRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDiasRegistroActionPerformed(evt);
            }
        });

        tabelaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horário da venda", "Produto", "Quantidade", "Arrecadado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaRegistro);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboDiasRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDiasRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Arrecadado pelo funcionário: R$");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFuncionariosActionPerformed
        Object itemSelecionado = comboFuncionarios.getSelectedItem();
        Funcionario f = funcionariosCadastrados.get(itemSelecionado.toString());

        // Verificar se o funcionário possui registros antes de tentar preencher a tabela
        if (f.getRegistroDeVendas() != null && !f.getRegistroDeVendas().isEmpty()) {
            // Atualize a tabela e o valor arrecadado antes de selecionar o dia de registro
            DecimalFormat df = new DecimalFormat("0.00");
            jLabel4.setText(df.format(f.getArrecadado()));
            /*
            try {
                Thread.sleep(1000); // Aguarda por 1 segundo (1000 milissegundos)
            } catch (InterruptedException e) {
                // Lidar com exceções, se necessário
            }  
            */
            escolherFuncionario(f);
        } else {
            // Caso o funcionário não tenha registros, você pode exibir uma mensagem ou limpar a tabela.
            // Aqui, vou limpar a tabela:
            DefaultTableModel dtmEstoque = (DefaultTableModel) tabelaRegistro.getModel();
            dtmEstoque.setRowCount(0);
        }
        
    }//GEN-LAST:event_comboFuncionariosActionPerformed

    private void comboDiasRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDiasRegistroActionPerformed
        Object itemSelecionado = comboDiasRegistro.getSelectedItem();
        Funcionario f = funcionariosCadastrados.get(comboFuncionarios.getSelectedItem().toString());
        preencherTabela(itemSelecionado.toString(), f.getRegistroDeVendas()); 
    }//GEN-LAST:event_comboDiasRegistroActionPerformed

    private void comboFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboFuncionariosMouseClicked
   
    }//GEN-LAST:event_comboFuncionariosMouseClicked

    private void comboFuncionariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboFuncionariosMouseEntered
        /*
        Object itemSelecionado = comboFuncionarios.getSelectedItem();
        Funcionario f = funcionariosCadastrados.get(itemSelecionado.toString());

        // Verificar se o funcionário possui registros antes de tentar preencher a tabela
        if (f.getRegistroDeVendas() != null && !f.getRegistroDeVendas().isEmpty()) {
            // Atualize a tabela e o valor arrecadado antes de selecionar o dia de registro
            DecimalFormat df = new DecimalFormat("0.00");
            jLabel4.setText(df.format(f.getArrecadado()));

            escolherFuncionario(f);
        } else {
            // Caso o funcionário não tenha registros, você pode exibir uma mensagem ou limpar a tabela.
            // Aqui, vou limpar a tabela:
            DefaultTableModel dtmEstoque = (DefaultTableModel) tabelaRegistro.getModel();
            dtmEstoque.setRowCount(0);
        }
        */
    }//GEN-LAST:event_comboFuncionariosMouseEntered

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
            java.util.logging.Logger.getLogger(TelaRegistroPorFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroPorFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroPorFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroPorFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        TelaInicio telaInicio = new TelaInicio();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistroPorFuncionario(telaInicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDiasRegistro;
    private javax.swing.JComboBox<String> comboFuncionarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaRegistro;
    // End of variables declaration//GEN-END:variables
}
