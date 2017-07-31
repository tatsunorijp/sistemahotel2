package sistemahotel.dominio.gerenciamento_estoque;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Programado por Leonardo
@Entity
public class Produto {
    @Id
    @GeneratedValue
    protected Long id;
    private String nome;
    private String quantidade;
    private String preco;
    private String alertaEstoque;


    public String toString(){return this.nome;}
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlertaEstoque() {
        return alertaEstoque;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }


    public void setAlertaEstoque(String alertaEstoque) {
        this.alertaEstoque = alertaEstoque;
    }
}
