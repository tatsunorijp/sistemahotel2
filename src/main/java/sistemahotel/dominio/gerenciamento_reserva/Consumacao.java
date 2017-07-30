package sistemahotel.dominio.gerenciamento_reserva;

import sistemahotel.dominio.gerenciamento_estoque.Produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tatsunori on 30/07/17.
 */
@Entity
public class Consumacao{
    @Id
    @GeneratedValue
    private long id;
    private List<Produto> produto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}