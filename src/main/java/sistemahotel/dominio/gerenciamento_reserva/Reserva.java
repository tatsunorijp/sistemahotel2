package sistemahotel.dominio.gerenciamento_reserva;

import javafx.fxml.Initializable;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_local.Local;
import sistemahotel.infraestrutura.DataController;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


//Programado por Tatsunori
@Entity
public class Reserva implements Initializable {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn (name = "fk_cliente", nullable=false)
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "fk_local", nullable=false)
    private Local local;
    private String status;
    private LocalDate data;
    public Reserva(){

    }
    public String toString(){
        return cliente.getNome();
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for(Cliente c: DataController.listCliente()){
            if(cliente.getNome().equals(c.getNome())){

            }
        }
    }
}
