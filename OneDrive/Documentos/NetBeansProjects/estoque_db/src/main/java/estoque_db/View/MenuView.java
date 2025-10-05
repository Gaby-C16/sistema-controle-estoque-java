
package estoque_db.View;

import estoque_db.estoque_db.Usuario;

public class MenuView extends javax.swing.JFrame {
  
    private Usuario usuario;
    
 public MenuView(Usuario usuario) {
    this.usuario = usuario;
    initComponents();
    configurarPermissoes();
    }


    private void configurarPermissoes() {
     if (usuario == null) return;
    String cargo = usuario.getCargo();

    if (cargo.equalsIgnoreCase("Funcionario")) {
        btnCadastroProduto.setEnabled(false);
        btnCadastroUsuario.setEnabled(false);
    } else if (cargo.equalsIgnoreCase("Gestor")) {
        btnCadastroProduto.setEnabled(false);
        btnCadastroUsuario.setEnabled(false);
        btnMovimentacao.setEnabled(false);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnConsultaEstoque = new javax.swing.JButton();
        btnCadastroProduto = new javax.swing.JButton();
        btnMovimentacao = new javax.swing.JButton();
        btnCadastroUsuario = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Selecione oque desejar fazer :");

        btnConsultaEstoque.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnConsultaEstoque.setText("Listagem/ Consulta de Produto");
        btnConsultaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaEstoqueActionPerformed(evt);
            }
        });

        btnCadastroProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCadastroProduto.setText("        Cadastro de Produto        ");
        btnCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroProdutoActionPerformed(evt);
            }
        });

        btnMovimentacao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnMovimentacao.setText("   Movimentação de Estoque    ");
        btnMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimentacaoActionPerformed(evt);
            }
        });

        btnCadastroUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCadastroUsuario.setText("        Cadastro de Usuário        ");
        btnCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroUsuarioActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadastroUsuario)
                            .addComponent(btnMovimentacao)
                            .addComponent(btnConsultaEstoque)
                            .addComponent(btnCadastroProduto))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnConsultaEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadastroProduto)
                .addGap(18, 18, 18)
                .addComponent(btnMovimentacao)
                .addGap(18, 18, 18)
                .addComponent(btnCadastroUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaEstoqueActionPerformed
    ConsultaView pv = new ConsultaView(usuario);
    pv.setVisible(true);
    this.dispose();   
    }//GEN-LAST:event_btnConsultaEstoqueActionPerformed

    private void btnMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimentacaoActionPerformed
    MovimentacaoView pv = new MovimentacaoView(usuario);
    pv.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnMovimentacaoActionPerformed

    private void btnCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroProdutoActionPerformed
    ProdutoView pv = new ProdutoView(usuario);
    pv.setVisible(true);
    this.dispose();

    }//GEN-LAST:event_btnCadastroProdutoActionPerformed

    private void btnCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroUsuarioActionPerformed
            UsuarioView pv = new UsuarioView(usuario);
    pv.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnCadastroUsuarioActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
            LoginView lv = new LoginView();
    lv.setVisible(true);
    this.dispose();

    }//GEN-LAST:event_btnVoltarActionPerformed


    public static void main(String args[]) {
        
            java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Usuario usuario = new Usuario();
            usuario.setCargo(""); 
            new MenuView(usuario).setVisible(true);
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroProduto;
    private javax.swing.JButton btnCadastroUsuario;
    private javax.swing.JButton btnConsultaEstoque;
    private javax.swing.JButton btnMovimentacao;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
