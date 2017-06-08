package sistemahotel.design.gerenciamento_reservas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;
import sistemahotel.dominio.gerenciamento_local.SalaoFestas;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.time.LocalDate;

import static sistemahotel.infraestrutura.DataController.ssf;

//Programado por Tatsunori
public class ReservaSalao {
    Cliente clienteobj;
    SalaoFestas salaofestas;

    @FXML
    TextField tfCliente;
    @FXML
    TextField tfSalao;
    @FXML
    DatePicker dpData;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void btReservaActionHandler(ActionEvent e) {
        Session session = ssf.openSession();
        DataController controller = new DataController();
        String cliente = tfCliente.getText();
        String salao = tfSalao.getText();
        LocalDate date = dpData.getValue();

        for (Cliente c : DataController.listCliente()) {
            if (c.getNome().equals(cliente))
                clienteobj = c;
        }
        for (SalaoFestas h : DataController.listSalao()) {
            if (h.getNumero().equals(salao))
                salaofestas = h;
        }

            ReservaDAO gr = new ReservaDAO();
            gr.novaReservaSalao(clienteobj, salaofestas, date);

        if (clienteobj == null) {
            alert.setTitle("Operação Falhou");
            alert.setHeaderText(null);
            alert.setContentText("Cliente Invalido");
            alert.showAndWait();
        } else {
            alert.setTitle("Operação Concluída");
            alert.setHeaderText(null);
            alert.setContentText("Reserva Efetuada");
            alert.showAndWait();
        }
    }

}