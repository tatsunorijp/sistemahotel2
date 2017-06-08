package sistemahotel.design.gerenciamento_reservas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import org.hibernate.Session;
import sistemahotel.dominio.gerenciamento_reserva.*;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.DataController.ssf;
import static sistemahotel.infraestrutura.Passing.reservapass;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;

//Programado por Leonardo
public class DeletarReserva implements Initializable {
    @FXML
    ComboBox cbSelecionar;
    Session session = ssf.openSession();

    public void btDeletarActionHandler(ActionEvent e){
        ReservaDAO gr = new ReservaDAO();
        reservapass = (Reserva) cbSelecionar.getValue();
        gr.deletarReserva(reservapass.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Reserva Deletada");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Reserva> list = FXCollections.observableList(DataController.listReserva());
        cbSelecionar.setItems(list);
    }
}
