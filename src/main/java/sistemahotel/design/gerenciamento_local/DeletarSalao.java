package sistemahotel.design.gerenciamento_local;

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
import sistemahotel.dominio.gerenciamento_local.LocalDAO;
import sistemahotel.dominio.gerenciamento_local.SalaoFestas;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.salaopass;

//Programado por Leonardo
public class DeletarSalao implements Initializable {

    @FXML
    ComboBox cbDeleteSalao;

    public void btDeletarSalaoActionHandler(ActionEvent e){
    LocalDAO gl = new LocalDAO();
    salaopass = (SalaoFestas) cbDeleteSalao.getValue();
    gl.deletarLocal(salaopass);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Operação realizada com sucesso");
    alert.setHeaderText(null);
    alert.setContentText("Habitação Cadastrada");
    alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<SalaoFestas> list = FXCollections.observableList(DataController.listSalao());
        cbDeleteSalao.setItems(list);
    }
}
