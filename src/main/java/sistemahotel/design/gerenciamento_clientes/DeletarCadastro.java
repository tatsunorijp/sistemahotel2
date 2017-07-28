//classe inutilizada
package sistemahotel.design.gerenciamento_clientes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import sistemahotel.dominio.gerenciamento_clientes.ClienteDAO;
import sistemahotel.dominio.pessoa.Pessoa;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.clientepass;

/**
 * Created by tatsunori on 19/07/17.
 */
public class DeletarCadastro implements Initializable {

    @FXML
    TableView <Cliente> TVCliente;
    @FXML
    TableColumn <Pessoa, String> TCNome;
    @FXML
    TableColumn <Pessoa, String> TCRG;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ClienteDAO dc = new ClienteDAO();
        ObservableList<Cliente> list = FXCollections.observableList(DataController.listCliente());
        TCNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        TCRG.setCellValueFactory(new PropertyValueFactory<>("RG"));
        TVCliente.setItems(FXCollections.observableList(list));

        TVCliente.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {

                    Passing.clientepass = TVCliente.getSelectionModel().getSelectedItem();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Deletar Reserva");
                    alert.setHeaderText("Deseja deletar o cliente selecionado?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        dc.deletarCadastro(Passing.clientepass);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }
                }
            }
        });


    }
}
