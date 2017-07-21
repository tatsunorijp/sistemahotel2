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
public class AlterarCadastroList implements Initializable {

    @FXML
    TableView <Cliente> TVCliente;
    @FXML
    TableColumn <Pessoa, String> TCNome;
    @FXML
    TableColumn <Pessoa, String> TCRG;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Cliente> list = FXCollections.observableList(DataController.listCliente());
        TCNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        TCRG.setCellValueFactory(new PropertyValueFactory<>("RG"));
        TVCliente.setItems(FXCollections.observableList(list));
        ClienteDAO dc = new ClienteDAO();

        TVCliente.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {

                    Passing.clientepass = TVCliente.getSelectionModel().getSelectedItem();

                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = null;
                    loader.setLocation(getClass().getResource("/fxml/fxml_reservas/cadastrocliente_selecionada.fxml"));
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
