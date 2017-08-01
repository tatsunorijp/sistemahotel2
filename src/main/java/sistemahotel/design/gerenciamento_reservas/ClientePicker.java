package sistemahotel.design.gerenciamento_reservas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_clientes.ClienteDAO;
import sistemahotel.dominio.pessoa.Pessoa;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by tatsunori on 28/07/17.
 */
public class ClientePicker implements Initializable {
    @FXML
    TableView<Cliente> TVCliente;
    @FXML
    TableColumn<Pessoa, String> TCNome;
    @FXML
    TableColumn <Pessoa, String> TCRG;
    @FXML
    TextField tfFiltro;
    ObservableList<Cliente> list;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableList(DataController.listCliente());
        TCNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        TCRG.setCellValueFactory(new PropertyValueFactory<>("RG"));
        TVCliente.setItems(FXCollections.observableList(list));

        // TRECHO DO FILTRO
        FilteredList<Cliente> filteredClienteData = new FilteredList<>(list, p -> true);
        tfFiltro.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredClienteData.setPredicate(cliente -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (cliente.getNome().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (cliente.getRG().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Cliente> sortedClienteData = new SortedList<>(filteredClienteData);
        sortedClienteData.comparatorProperty().bind(TVCliente.comparatorProperty());
        TVCliente.setItems(sortedClienteData);
        // TRECHO DO FILTRO

        TVCliente.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    Passing.clientepass = TVCliente.getSelectionModel().getSelectedItem();
                    ((Node)click.getSource()).getParent().getScene().getWindow().hide();
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/fxml_reservas/reserva_habitacao.fxml"));
                    Parent root = null;
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
