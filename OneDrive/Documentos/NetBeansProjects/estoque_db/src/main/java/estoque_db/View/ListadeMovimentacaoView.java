
package estoque_db.View;

import estoque_db.dao.MovimentacaoDAO;
import estoque_db.dao.ProdutoDAO;
import estoque_db.estoque_db.MovimentacaoEstoque;
import estoque_db.estoque_db.Produto;
import estoque_db.estoque_db.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListadeMovimentacaoView extends javax.swing.JFrame {

    private Usuario usuario;
    private MovimentacaoDAO movDao = new MovimentacaoDAO();
    private ProdutoDAO prodDao = new ProdutoDAO();

    public ListadeMovimentacaoView(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setLocationRelativeTo(null);
        carregarTabela();
    }


    private void carregarTabela() {
        List<MovimentacaoEstoque> lista = movDao.listarTodos();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (MovimentacaoEstoque m : lista) {
            Produto p = prodDao.buscarPorId(m.getProdutoId());
            String nomeProd = p != null ? p.getNome() : "—";
            String lote = p != null ? (p.getLote() == null ? "" : p.getLote()) : "";
            String dataStr = m.getData() != null ? m.getData().toString().replace('T',' ') : "";
            model.addRow(new Object[]{
                m.getIdMovimentacao(), 
                dataStr,
                m.getTipoMovimentacao(),
                nomeProd,
                m.getQuantidade(),
                lote
            });
            
        }
    }
        
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bntVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Movimentações:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Data ", "Movimentação", "ID", "Produto", "Quantidade", "Lote"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        bntVoltar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bntVoltar.setText("Voltar");
        bntVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(bntVoltar)))
                        .addGap(0, 191, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntVoltar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltarActionPerformed
        new MovimentacaoView(usuario).setVisible(true);
        this.dispose();
    
        
    }//GEN-LAST:event_bntVoltarActionPerformed

  public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario u = new Usuario(); u.setCargo("Administrador");
                new ListadeMovimentacaoView(u).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
