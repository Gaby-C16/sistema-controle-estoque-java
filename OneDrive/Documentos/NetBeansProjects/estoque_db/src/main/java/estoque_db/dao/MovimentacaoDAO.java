
package estoque_db.dao;

import estoque_db.estoque_db.MovimentacaoEstoque;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoDAO {
  private String url = "jdbc:mysql://localhost:3306/estoque_db";
    private String user = "root";
    private String password = "16082006";

    public void inserir(MovimentacaoEstoque m) {
        String sql = "INSERT INTO movimentacao_estoque (produto_id, tipo_movimentacao, quantidade, data) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, m.getProdutoId());
            stmt.setString(2, m.getTipoMovimentacao());
            stmt.setInt(3, m.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
    public void entradaProduto(int produtoId, int quantidade, String lote, String validadeStr) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date validadeUtil = sdf.parse(validadeStr);
    java.sql.Date validadeSql = new java.sql.Date(validadeUtil.getTime());

    String sql = "INSERT INTO lotes (produtoId, lote, quantidade, validade) VALUES (?, ?, ?, ?)";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, produtoId);
        stmt.setString(2, lote);
        stmt.setInt(3, quantidade);
        stmt.setDate(4, validadeSql);
        stmt.executeUpdate();
    }
    }
    
    public MovimentacaoEstoque buscarPorId(int idMov) {
    String sql = "SELECT * FROM movimentacoes WHERE id = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idMov);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            MovimentacaoEstoque m = new MovimentacaoEstoque();
         
            m.setProdutoId(rs.getInt("produtoId"));
            m.setQuantidade(rs.getInt("quantidade"));
            m.setTipoMovimentacao(rs.getString("tipo"));
            return m;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

public void excluir(int idMov) {
    try {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
            "DELETE FROM movimentacao_estoque WHERE idMovimentacao = ?"
        );
        ps.setInt(1, idMov);

        int linhasAfetadas = ps.executeUpdate();
        System.out.println("Linhas deletadas: " + linhasAfetadas); 

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public List<MovimentacaoEstoque> listarTodos() {
    List<MovimentacaoEstoque> lista = new ArrayList<>();
    String sql = "SELECT * FROM movimentacao_estoque ORDER BY data DESC";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            MovimentacaoEstoque m = new MovimentacaoEstoque();
            m.setIdMovimentacao(rs.getInt("idMovimentacao_estoque")); // 👈 importante
            m.setProdutoId(rs.getInt("produto_id"));
            m.setQuantidade(rs.getInt("quantidade"));
            m.setTipoMovimentacao(rs.getString("tipo_movimentacao"));
            Timestamp ts = rs.getTimestamp("data");
            if (ts != null) m.setData(ts.toLocalDateTime());
            lista.add(m);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;

}
}
