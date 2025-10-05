package estoque_db.estoque_db;

import java.sql.Date;


public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private String lote;
    private Date validade;
    

    public Produto() { }

    public Produto(int idProduto, String nome, String descricao, int quantidade, double preco,
                   int estoqueMinimo, int estoqueMaximo) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.validade = validade;
    }


    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }
    public void setEstoqueMaximo(int estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }
    
    public String getLote() { return lote; }
public void setLote(String lote) { this.lote = lote; }
    
        public Date getValidade() { return validade; }
    public void setValidade(Date validade) { this.validade = validade; }

   
    public boolean verificarEstoqueBaixo() {
        return this.quantidade < this.estoqueMinimo;
    }
}
