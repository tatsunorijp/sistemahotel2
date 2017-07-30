package sistemahotel.dominio.gerenciamento_reserva;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tatsunori on 30/07/17.
 */
@Entity
public class Consumacao {
    @Id
    @GeneratedValue
    private long id;
    private List<String> produto;
    private List<String> preco;
    private Reserva reserva;

    public List<String> getProduto() {
        return produto;
    }

    public void setProduto(List<String> produto) {
        this.produto = produto;
    }

    public List<String> getPreco() {
        return preco;
    }

    public void setPreco(List<String> preco) {
        this.preco = preco;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}