
package estoque_db.dao;

import estoque_db.estoque_db.Usuario;
import java.sql.*;
import java.time.ZoneId;

public class UsuarioDAO {
   private String url = "jdbc:mysql://localhost:3306/estoque_db";
    private String user = "root";
    private String password = "16082006";

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, login, senha, cpf, dataNascimento, cargo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin()); 
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCpf());
            stmt.setDate(5, java.sql.Date.valueOf(usuario.getDataNascimento()));
            stmt.setString(6, usuario.getCargo());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Usuario validar(String login, String senha) {
            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, login);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("idUsuario"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            u.setCpf(rs.getString("cpf"));
            u.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
            u.setCargo(rs.getString("cargo"));
            return u;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
public Usuario buscarPorLogin(String login) {
    Usuario usuario = null;
    String sql = "SELECT * FROM usuario WHERE login = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, login);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setCpf(rs.getString("cpf"));
            usuario.setCargo(rs.getString("cargo"));

            Date data = rs.getDate("dataNascimento");
            if (data != null) {
                usuario.setDataNascimento(data.toLocalDate()); // ✅ corrigido
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return usuario;
}
}
