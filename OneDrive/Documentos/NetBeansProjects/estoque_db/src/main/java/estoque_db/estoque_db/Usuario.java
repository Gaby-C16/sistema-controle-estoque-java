
package estoque_db.estoque_db;

import java.time.LocalDate;

public class Usuario {
     private int id;
    private String nome;
    private String login;
    private String senha;
    private String cpf;
    private LocalDate dataNascimento;
     private String cargo;

    // getters / setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
     public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}

