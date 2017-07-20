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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Session;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_clientes.ClienteDAO;
import sistemahotel.dominio.pessoa.Pessoa;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static sistemahotel.infraestrutura.DataController.ssf;
import static sistemahotel.infraestrutura.Passing.clientepass;

//Programado por Leonardo
public class DeletarCadastro implements Initializable {
    @FXML
    TableView<Cliente> TVCliente;
    @FXML
    TableColumn<Pessoa, String> TCNome;
    @FXML
    TableColumn <Pessoa, String> TCRG;

    Session session = ssf.openSession();
    public void btDeletarActionHandler(ActionEvent e){
        ClienteDAO gc = new ClienteDAO();
        gc.deletarCadastro(clientepass.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro Deletado");
        alert.showAndWait();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Cliente> list = FXCollections.observableList(DataController.listCliente());
        TCNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        TCRG.setCellValueFactory(new PropertyValueFactory<>("RG"));
        TVCliente.setItems(FXCollections.observableList(list));

        TVCliente.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 1) {
                    Passing.clientepass = TVCliente.getSelectionModel().getSelectedItem();
                }
            }
        });
    }
}
