//classe inutilizada
package sistemahotel.design.gerenciamento_local;

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
import sistemahotel.dominio.gerenciamento_local.Local;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;
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
public class DeletarLocal implements Initializable {

    @FXML
    TableView <Local> tvDeletarLocal;
    @FXML
    TableColumn <Local, String> tcNumeroLocal;
    @FXML
    TableColumn <Local, String> tcTipoLocal;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LocalDAO dl = new LocalDAO();
        ObservableList<Local> list = FXCollections.observableList(DataController.listLocal());
        tcNumeroLocal.setCellValueFactory( new PropertyValueFactory<>("Numero"));
        tcTipoLocal.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        tvDeletarLocal.setItems(FXCollections.observableList(list));

        tvDeletarLocal.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {

                    Passing.localpass = tvDeletarLocal.getSelectionModel().getSelectedItem();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Deletar Local");
                    alert.setHeaderText("Deseja deletar o local selecionado?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        dl.deletarLocal(Passing.localpass);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }
                }
            }
        });


    }
}
