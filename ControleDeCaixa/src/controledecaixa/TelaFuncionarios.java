package controledecaixa;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaFuncionarios extends javax.swing.JFrame {

    private TelaInicio telaPrincipal; //referencia da tela de inicio
    LinkedHashMap <String, Funcionario> funcionarios;
    
    public TelaFuncionarios(TelaInicio telaPrincipal) {
        initComponents();
         this.telaPrincipal = telaPrincipal; //referencia da tela de inicio
         this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/img.png")).getImage());
         
         funcionarios = new LinkedHashMap<>();
         funcionarios = telaPrincipal.getFuncionarios(); //resgata a lista de funcionarios da tela inicial
         //essa lista ja contem alguns funcionarios
         //ao editar, ela retorna para lá e é substituida
         
         //System.out.println(funcionarios.get("Williams David Duarte"));
         
        DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
         
        //percorremos o hashMap de funcionarios resgatando as chaves e os objetos
        for (Map.Entry<String, Funcionario> entry : funcionarios.entrySet()) {
            String funcionarioNome = entry.getKey();
            Funcionario f = entry.getValue();
            
            String nome = f.getNome();
            String permissoes;
            
            if (f.isPermissoes()){
                permissoes = "sim";
            } else {
                permissoes = "nao";
            }
            DecimalFormat df = new DecimalFormat("0.00");
            String arrecadado = df.format(f.getArrecadado());
            
            Object [] objeto = {nome, permissoes, f.getArrecadado()};
            model.addRow(objeto);
        }
        
        tabelaFuncionarios.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        botaoCancelarSelecao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cadastroNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        permissaoParaEditarDados = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        cadastroSenha = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionarios cadastrados");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcionários cadastrados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tabelaFuncionarios.setAutoCreateRowSorter(true);
        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Permissões", "Arrecadado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionarios);
        if (tabelaFuncionarios.getColumnModel().getColumnCount() > 0) {
            tabelaFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(5);
            tabelaFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        jToggleButton1.setText("Remover");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        botaoCancelarSelecao.setText("Cancelar seleção");
        botaoCancelarSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarSelecaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoCancelarSelecao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(botaoCancelarSelecao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoCancelarSelecao.setVisible(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar um funcionário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Nome");

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        permissaoParaEditarDados.setText("Permissão para editar dados");
        permissaoParaEditarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissaoParaEditarDadosActionPerformed(evt);
            }
        });

        jLabel2.setText("Senha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadastroNome)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cadastroSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(permissaoParaEditarDados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastroSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permissaoParaEditarDados)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Salvar modificações");
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //ação ao selecionar o checkBottom
    private void permissaoParaEditarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissaoParaEditarDadosActionPerformed

    }//GEN-LAST:event_permissaoParaEditarDadosActionPerformed

    //ação do botão confirmar ao cadastrar um funcionario
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            
            //resgata os dados do funcionario as ser inserido na lista de funcionarios
            String nome = cadastroNome.getText(); //guarda o nome do funcionario a ser cadastrado
            boolean permitido; //para indicar se ele pode editar dados importantes do sistema
            String permissao; //string usada para fazer a inserção na tabela
            String senha = cadastroSenha.getText(); //a senha digitada pelo usuario
            
            if (permissaoParaEditarDados.isSelected()){
                permitido  = true;
                permissao = "sim";
            } else {
                permitido = false;
                permissao = "nao";
            }
            
            DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
            int selectedRow = tabelaFuncionarios.getSelectedRow();
            
            if (selectedRow == -1){ //se uma linha não estiver pressionada é usada a logica de inserir um novo
                Funcionario f = new Funcionario (nome, permitido, senha);
                funcionarios.put(nome, f);
                
                Object [] objeto = {nome, permissao, Double.toString(f.getArrecadado())};
                model.addRow(objeto);
    
                
            } else { //se uma linha estiver pressionada é usada a logica de atualizar um funcionario existente
                
                Object cellValue = model.getValueAt(selectedRow, 0); //recuperou a celula selecionada da tabela
                Funcionario f = funcionarios.get(cellValue.toString()); //resgata o funcionario a ser editado
                funcionarios.remove(cellValue.toString()); //remove apos resgatar
                model.removeRow(selectedRow); //remove ele ta tabela 

                //altera os dados dele baseado nos dados digitados pelo usuario
                f.setNome(nome);
                f.setSenha(senha);
                f.setPermissoes(permitido);

                funcionarios.put(nome, f); //insere no hashMap, isso seria atualizar ele

                //agora insere ele na tabela
                Object [] objeto = {nome, permissao, Double.toString(f.getArrecadado())};
                model.addRow(objeto);  
            }
            
            tabelaFuncionarios.setModel(model);
            
            cadastroNome.setText(null);
            cadastroSenha.setText(null);
            permissaoParaEditarDados.setSelected(false);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Algo deu errado, verifique o que você digitou!", "Atenção!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //ação caso eu clique em algum lugar na tabela
    private void tabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosMouseClicked
        
        if (botaoCancelarSelecao.isVisible() == false){
            botaoCancelarSelecao.setVisible(true);
        }
        
        DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
        int rowIndex = tabelaFuncionarios.getSelectedRow(); //resgata a linha selecionada
        
        String nome = model.getValueAt(rowIndex, 0).toString(); //resgata o nome da linha selecionada
        Funcionario f = funcionarios.get(nome); //resgata o funcionario referente a esse nome
        
        cadastroNome.setText(f.getNome());
        cadastroSenha.setText(f.getSenha());

        if (f.isPermissoes()){
            permissaoParaEditarDados.setSelected(true); 
        } else {
            permissaoParaEditarDados.setSelected(true);
        }
        
    }//GEN-LAST:event_tabelaFuncionariosMouseClicked

    //botão para dessselecionar uma linha
    private void botaoCancelarSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarSelecaoActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
        int selectedRow = tabelaFuncionarios.getSelectedRow();
        
        if (selectedRow != -1) {
            tabelaFuncionarios.removeRowSelectionInterval(selectedRow, selectedRow);
        }
        
        botaoCancelarSelecao.setVisible(false);
        
        cadastroNome.setText(null);
        cadastroSenha.setText(null);
        permissaoParaEditarDados.setSelected(false);
        
    }//GEN-LAST:event_botaoCancelarSelecaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int confirmacao = JOptionPane.showConfirmDialog(null,"Tem certeza que quer alter esses dados?", "Selecione", JOptionPane.YES_NO_OPTION);
        
        if (confirmacao == JOptionPane.YES_OPTION){
            telaPrincipal.atualizarFuncionarios(funcionarios);
            this.dispose();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    //ação do botão de remover
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            cadastroNome.setText(null);
            cadastroSenha.setText(null);
            permissaoParaEditarDados.setSelected(false);
            
            DefaultTableModel model = (DefaultTableModel) tabelaFuncionarios.getModel();
            int selectedRow = tabelaFuncionarios.getSelectedRow();
            
            String nome = model.getValueAt(selectedRow, 0).toString();
            
            model.removeRow(selectedRow);
            funcionarios.remove(nome);
            tabelaFuncionarios.setModel(model);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Selecione um item para remover!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        TelaInicio telaInicio = new TelaInicio();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionarios(telaInicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelarSelecao;
    private javax.swing.JTextField cadastroNome;
    private javax.swing.JTextField cadastroSenha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JCheckBox permissaoParaEditarDados;
    private javax.swing.JTable tabelaFuncionarios;
    // End of variables declaration//GEN-END:variables
}
