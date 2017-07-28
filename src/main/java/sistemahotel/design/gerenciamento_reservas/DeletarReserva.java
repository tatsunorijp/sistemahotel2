//classe inutilizada
package sistemahotel.design.gerenciamento_reservas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_reserva.Reserva;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;
import sistemahotel.dominio.pessoa.Pessoa;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by marcelo on 21/07/17.
 */
public class DeletarReserva implements Initializable {
    Cliente current;
    @FXML
    TableView<Reserva> tvReserva;
    @FXML
    TableColumn<Reserva, String> tcCliente;
    @FXML
    TableColumn <Reserva, String> tcLocal;
    @FXML
    TableColumn <Reserva, String> tcStatus;
    @FXML
    TableColumn <Reserva, String> tcData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Reserva> list = FXCollections.observableList(DataController.listReserva());
        tcCliente.setCellValueFactory( new PropertyValueFactory<>("Cliente"));
        tcLocal.setCellValueFactory(new PropertyValueFactory<>("Local"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        tcData.setCellValueFactory(new PropertyValueFactory<>("Data"));
        tvReserva.setItems(FXCollections.observableList(list));
        ReservaDAO dl = new ReservaDAO();
        tvReserva.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {

                    Passing.reservapass = tvReserva.getSelectionModel().getSelectedItem();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Deletar Reserva");
                    alert.setHeaderText("Deseja deletar a reserva selecionada?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        dl.deletarReserva(Passing.reservapass);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }
                }
            }
        });


    }
}
