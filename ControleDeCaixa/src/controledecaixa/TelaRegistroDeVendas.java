package controledecaixa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaRegistroDeVendas extends javax.swing.JFrame {

    private TelaInicio telaPrincipal;
    private LinkedHashMap <String, Registro> registro; //essa tela já guarda o registro das vendas como atributo
    
    public TelaRegistroDeVendas(TelaInicio telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/img.png")).getImage());
        
        try {
            initComponents();
            //recupera o hashMap do registro da tela inicial
            registro = telaPrincipal.getRegistro();
            ArrayList<String> dataChaves = new ArrayList(); //arrayList que guarda as datas
            //elas serão guardadadas em um arrayLits pq preciso inverter elas antes de inserir na comboBox

            //recupera valores do hashmap de registro
            //cada valor do hashmap são dados de um dia de vendas
            //ou seja, inicialmente ele recupera dia por dia
            for (Map.Entry<String, Registro> entry : registro.entrySet()) {
                String chave = entry.getKey(); //a chave do hashmap (nesse caso, as datas)
                dataChaves.add(chave); //insere das datas no arrayList de datas

            }
            Collections.reverse(dataChaves);
            Iterator iterator = dataChaves.iterator();
            while (iterator.hasNext()){
                comboDiasRegistro.addItem((String)iterator.next());
            }
            preencherTabela((String) comboDiasRegistro.getSelectedItem());

        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Não Há nada no registro!", "Atenção!",JOptionPane.WARNING_MESSAGE);
            this.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRegistro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboDiasRegistro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro das vendas");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de vendas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Registro do dia");

        jLabel3.setText("compras realizadas no exato mesmo horário são compras de um único cliente.");

        comboDiasRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDiasRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboDiasRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDiasRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboDiasRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDiasRegistroActionPerformed
        preencherTabela((String) comboDiasRegistro.getSelectedItem());
    }//GEN-LAST:event_comboDiasRegistroActionPerformed
    
    //metodo que preenche a tabela se baseando no objeto selecionado na comboBox
    private void preencherTabela(String dataAtual){
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
    }
    
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
            java.util.logging.Logger.getLogger(TelaRegistroDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroDeVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        TelaInicio telaInicio = new TelaInicio();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistroDeVendas(telaInicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboDiasRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaRegistro;
    // End of variables declaration//GEN-END:variables
}
