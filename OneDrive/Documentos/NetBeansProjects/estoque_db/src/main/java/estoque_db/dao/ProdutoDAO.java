
package estoque_db.dao;

import estoque_db.estoque_db.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoDAO {
    private String url = "jdbc:mysql://localhost:3306/estoque_db";
    private String user = "root";
    private String password = "16082006";

    public void inserir(Produto p) {
String sql = "INSERT INTO produtos (nome, descricao, quantidade, preco, estoqueMinimo, estoqueMaximo, lote, validade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
try (Connection conn = DriverManager.getConnection(url, user, password);
     PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, p.getNome());
    stmt.setString(2, p.getDescricao());
    stmt.setInt(3, p.getQuantidade());
    stmt.setDouble(4, p.getPreco());
    stmt.setInt(5, p.getEstoqueMinimo());
    stmt.setInt(6, p.getEstoqueMaximo());
    stmt.setString(7, p.getLote());
            if (p.getValidade() != null) {
                stmt.setDate(8, p.getValidade());
            } else {
                stmt.setNull(8, java.sql.Types.DATE);
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(int idProduto) {
    String sql = "DELETE FROM produtos WHERE idProduto = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idProduto);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
while (rs.next()) {
    Produto p = new Produto();
    p.setIdProduto(rs.getInt("idProduto"));
    p.setNome(rs.getString("nome"));
    p.setDescricao(rs.getString("descricao")); 
    p.setQuantidade(rs.getInt("quantidade"));
    p.setPreco(rs.getDouble("preco"));
    p.setEstoqueMinimo(rs.getInt("estoqueMinimo"));
    p.setEstoqueMaximo(rs.getInt("estoqueMaximo"));
    p.setLote(rs.getString("lote"));
    p.setValidade(rs.getDate("validade"));
    lista.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Produto buscarPorId(int idProduto) {
    String sql = "SELECT * FROM produtos WHERE idProduto = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idProduto);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Produto p = new Produto();
            p.setIdProduto(rs.getInt("idProduto"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setQuantidade(rs.getInt("quantidade"));
            p.setPreco(rs.getDouble("preco"));
            p.setEstoqueMinimo(rs.getInt("estoqueMinimo"));
            p.setEstoqueMaximo(rs.getInt("estoqueMaximo"));
            p.setLote(rs.getString("lote"));
            p.setValidade(rs.getDate("validade"));
            return p;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
public boolean existeProdutoPorNome(String nome) {
    String sql = "SELECT COUNT(*) FROM produtos WHERE nome = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

public Produto buscarPorId2(int idProduto) {
    String sql = "SELECT * FROM produtos WHERE idProduto = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idProduto);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Produto p = new Produto();
            p.setIdProduto(rs.getInt("idProduto"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setPreco(rs.getDouble("preco"));
            p.setEstoqueMinimo(rs.getInt("estoqueMinimo"));
            p.setEstoqueMaximo(rs.getInt("estoqueMaximo"));
            p.setLote(rs.getString("lote"));
            p.setValidade(rs.getDate("validade"));
            return p;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    public List<Produto> listarLotesPorValidade(int produtoId) throws Exception {
        List<Produto> lotes = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE idProduto = ? ORDER BY validade ASC";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPreco(rs.getDouble("preco"));
                p.setEstoqueMinimo(rs.getInt("estoqueMinimo"));
                p.setEstoqueMaximo(rs.getInt("estoqueMaximo"));
                p.setLote(rs.getString("lote"));
                p.setValidade(rs.getDate("validade"));
                lotes.add(p);
            }
        }
        return lotes;
    }

public void entradaProduto(int produtoId, int quantidade, String lote, String validadeStr) throws Exception {
    Produto p = buscarPorId(produtoId);
    if (p != null) {
        int novaQuantidade = p.getQuantidade() + quantidade;
        p.setQuantidade(novaQuantidade);
        p.setLote(lote);

        if (validadeStr != null && !validadeStr.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date validadeUtil = sdf.parse(validadeStr);
            java.sql.Date validadeSql = new java.sql.Date(validadeUtil.getTime());
            p.setValidade(validadeSql);
        }

        atualizar(p);
    } else {
        throw new Exception("Produto não encontrado!");
    }
}

     public void saidaProduto(int produtoId, int quantidade) throws Exception {
        List<Produto> lotes = listarLotesPorValidade(produtoId);
        int restante = quantidade;

        for (Produto lote : lotes) {
            if (lote.getQuantidade() >= restante) {
                lote.setQuantidade(lote.getQuantidade() - restante);
                atualizar(lote);
                restante = 0;
                break;
            } else {
                restante -= lote.getQuantidade();
                lote.setQuantidade(0);
                atualizar(lote);
            }
        }
        if (restante > 0) {
            throw new Exception("Estoque insuficiente!");
        }
    }
     
  public void atualizarQuantidade(int idProduto, int novaQtd) {
    try {
        Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(
            "UPDATE produto SET quantidade = ? WHERE idProduto = ?"
        );
        ps.setInt(1, novaQtd);
        ps.setInt(2, idProduto);

        int linhasAfetadas = ps.executeUpdate();
        System.out.println("Linhas atualizadas no produto: " + linhasAfetadas); // TESTE

        ps.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    private void atualizar(Produto p) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.getConnection();
            ps = con.prepareStatement("UPDATE produtos SET quantidade = ?, lote = ?, validade = ? WHERE idProduto = ?");
            ps.setInt(1, p.getQuantidade());
            ps.setString(2, p.getLote());
            ps.setDate(3, new java.sql.Date(p.getValidade().getTime()));
            ps.setInt(4, p.getIdProduto());
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }
}