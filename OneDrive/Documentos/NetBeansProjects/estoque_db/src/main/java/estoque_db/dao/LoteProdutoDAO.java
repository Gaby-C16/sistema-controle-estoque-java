package estoque_db.dao;

import estoque_db.estoque_db.LoteProduto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoteProdutoDAO {
    private String url = "jdbc:mysql://localhost:3306/estoque_db";
    private String user = "root";
    private String password = "16082006";

    public void adicionarLote(LoteProduto lote) {
        String sql = "INSERT INTO lotes (produtoId, lote, quantidade, validade) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, lote.getProdutoId());
            stmt.setString(2, lote.getLote());
            stmt.setInt(3, lote.getQuantidade());
            stmt.setDate(4, lote.getValidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LoteProduto> listarLotesPorProduto(int produtoId) {
        List<LoteProduto> lotes = new ArrayList<>();
        String sql = "SELECT * FROM lotes WHERE produtoId = ? ORDER BY validade ASC";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                LoteProduto lote = new LoteProduto();
                lote.setIdLote(rs.getInt("idLote"));
                lote.setProdutoId(rs.getInt("produtoId"));
                lote.setLote(rs.getString("lote"));
                lote.setQuantidade(rs.getInt("quantidade"));
                lote.setValidade(rs.getDate("validade"));
                lotes.add(lote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lotes;
    }

    public void atualizarLote(LoteProduto lote) {
        String sql = "UPDATE lotes SET quantidade = ?, validade = ? WHERE idLote = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, lote.getQuantidade());
            stmt.setDate(2, lote.getValidade());
            stmt.setInt(3, lote.getIdLote());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}