package sistemahotel.design.gerenciamento_local;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//Programado por Tatsunori
public class CadastroHabitacao implements Initializable {

    @FXML
    TextField tfNmroHab;
    @FXML
    TextArea taInformacoesAdicionais;
    @FXML
    ComboBox cbCamasDeSolteiro;
    @FXML
    ComboBox cbCamasDeCasal;

    ArrayList<Integer> lista = new ArrayList<Integer>();
    lista.add(1);


    public void btNovaHabActionHandler(ActionEvent e){
    LocalDAO hab = new LocalDAO();
    hab.novaHabitacao(tfNmroHab.getText());
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Operação realizada com sucesso");
    alert.setHeaderText(null);
    alert.setContentText("Habitação Cadastrada");
    alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbCamasDeSolteiro.setItems();
    }
}
