package sistemahotel.dominio.gerenciamento_reserva;

import javafx.fxml.Initializable;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_local.Local;
import sistemahotel.infraestrutura.DataController;

import java.sql.Array;
import java.sql.Date;
import javax.persistence.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String qtdhospede;
    private ArrayList<Produto> consumo = new ArrayList<>();

    public ArrayList<Produto> getConsumo() {
        return consumo;
    }

    public void addConsumacao(Produto produto){
        consumo.add(produto);

    }

    public String toString(){
        return cliente.getNome();
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
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

    public String getQtdhospede() {
        return qtdhospede;
    }

    public void setQtdhospede(String qtdhospede) {
        this.qtdhospede = qtdhospede;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for(Cliente c: DataController.listCliente()){
            if(cliente.getNome().equals(c.getNome())){

            }
        }
    }
}
