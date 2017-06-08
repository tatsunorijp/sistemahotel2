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
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.infraestrutura.DataController;
import static sistemahotel.infraestrutura.Passing.habitacaopass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
//Programado por Leonardo
public class DeletarHabitacao implements Initializable{
    @FXML ComboBox cbDeleteHab;

    public void btDeletarHabActionHandler (ActionEvent e){
        LocalDAO gl = new LocalDAO();
        habitacaopass = (Habitacao) cbDeleteHab.getValue();
        gl.deletarLocal(habitacaopass);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Habitacao Deletada");
        alert.showAndWait();
        Stage stage = new Stage();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Habitacao> list = FXCollections.observableList(DataController.listHabitacoes());
        cbDeleteHab.setItems(list);
    }
}
