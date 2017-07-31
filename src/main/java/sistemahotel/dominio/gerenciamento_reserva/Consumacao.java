package sistemahotel.dominio.gerenciamento_reserva;

import javax.persistence.*;

/**
 * Created by tatsunori on 31/07/17.
 */
@Entity
public class Consumacao {
    @Id
    @GeneratedValue
    private Long id;
    private String produto; //apenas atributo nome
    private String preco;
    private String quantidade;
    @ManyToOne
    private Reserva reserva; //chave
    private String cliente; //Apenas atributo nome, nao é uma chave

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String nome) {
        this.produto = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
