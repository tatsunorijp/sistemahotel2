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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_reserva.Reserva;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.reservapass;
//Programado por Marcelo
public class AlterarReservaSelecao implements Initializable {
    @FXML
    ComboBox cbAlterarReserva;
    public void btAlterarReservaActionHandler(ActionEvent e){

        reservapass = (Reserva) cbAlterarReserva.getValue();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/reserva_selecionada.fxml"));
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        ((Node) e.getSource()).getParent().getScene().getWindow();
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Reserva> list = FXCollections.observableList(DataController.listReserva());
        cbAlterarReserva.setItems(list);
    }
}
