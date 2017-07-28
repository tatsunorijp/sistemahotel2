package sistemahotel.design.gerenciamento_reservas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_reserva.Reserva;
import sistemahotel.dominio.pessoa.Pessoa;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by marcelo on 21/07/17.
 */
public class AlterarReservaList implements Initializable {
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
        tcCliente.setCellValueFactory( new PropertyValueFactory<>("cliente"));
        tcLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tcData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tvReserva.setItems(FXCollections.observableList(list));

        tvReserva.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {

                    Passing.reservapass = tvReserva.getSelectionModel().getSelectedItem();

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
                    stage.show();
                }
            }
        });


    }
}
