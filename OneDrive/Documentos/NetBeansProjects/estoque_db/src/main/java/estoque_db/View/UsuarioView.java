
package estoque_db.View;

import estoque_db.estoque_db.Usuario;
import estoque_db.dao.UsuarioDAO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UsuarioView extends javax.swing.JFrame {

    private Usuario usuario;

    public UsuarioView(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        
    }
        
            private void limparCampos() {
        txtNome.setText("");
        jTextField2.setText("");
        pdwSenha.setText("");
        pdwConfirmar.setText("");
        txtCPF.setText("");
        txtDatadeNascimento.setText("");
        txtCargo.setText("");
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bntcadastrar = new javax.swing.JButton();
        bntVoltar = new javax.swing.JButton();
        bntLimpar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        pdwSenha = new javax.swing.JPasswordField();
        pdwConfirmar = new javax.swing.JPasswordField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtDatadeNascimento = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Cadastro de Usuário");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Data de nascimento:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Senha:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Confimar senha:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("E-MAIL:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setText("CPF:");

        bntcadastrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bntcadastrar.setText("Cadastrar");
        bntcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcadastrarActionPerformed(evt);
            }
        });

        bntVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bntVoltar.setText("Voltar");
        bntVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVoltarActionPerformed(evt);
            }
        });

        bntLimpar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bntLimpar.setText("Limpar tudo");
        bntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimparActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        pdwSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdwSenhaActionPerformed(evt);
            }
        });

        txtDatadeNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel8.setText("Cargo:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel9.setText("Usuário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(bntcadastrar)
                            .addGap(88, 88, 88)
                            .addComponent(bntVoltar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntLimpar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtLogin))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDatadeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(pdwSenha))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pdwConfirmar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDatadeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pdwSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pdwConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntcadastrar)
                    .addComponent(bntVoltar)
                    .addComponent(bntLimpar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcadastrarActionPerformed
String nome = txtNome.getText().trim();
        String login = txtLogin.getText().trim();
        String senha = new String(pdwSenha.getPassword());
        String confirmar = new String(pdwConfirmar.getPassword());
        String cpf = txtCPF.getText().replaceAll("[^0-9]", "");
        String cargo = txtCargo.getText().trim();

        if (!senha.equals(confirmar)) {
            JOptionPane.showMessageDialog(this, "Senhas não conferem!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nome.isEmpty() || login.isEmpty() || senha.isEmpty() || cpf.isEmpty() || txtDatadeNascimento.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cpf.length() != 11) {
            JOptionPane.showMessageDialog(this, "CPF inválido! Deve conter 11 números.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate dataNasc = null;
        if (txtDatadeNascimento.getValue() instanceof Date) {
            Date data = (Date) txtDatadeNascimento.getValue();
            dataNasc = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            JOptionPane.showMessageDialog(this, "Data de nascimento inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario u = new Usuario();
        u.setNome(nome);
        u.setLogin(login); 
        u.setSenha(senha);
        u.setCpf(cpf);
        u.setDataNascimento(dataNasc);
        u.setCargo(cargo);

        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.inserir(u);
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            limparCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
   
    }//GEN-LAST:event_bntcadastrarActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void pdwSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdwSenhaActionPerformed
      
    }//GEN-LAST:event_pdwSenhaActionPerformed

    private void bntVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltarActionPerformed
    new MenuView(usuario).setVisible(true);
    this.dispose();
    }//GEN-LAST:event_bntVoltarActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        txtNome.setText("");
    jTextField2.setText("");
    pdwSenha.setText("");
    pdwConfirmar.setText("");
    txtCPF.setText("");
    txtDatadeNascimento.setText("");
    txtCargo.setText("");
    }//GEN-LAST:event_bntLimparActionPerformed



    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Usuario usuarioTeste = new Usuario();
            usuarioTeste.setCargo("");
            new UsuarioView(usuarioTeste).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton bntVoltar;
    private javax.swing.JButton bntcadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPasswordField pdwConfirmar;
    private javax.swing.JPasswordField pdwSenha;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JFormattedTextField txtDatadeNascimento;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
