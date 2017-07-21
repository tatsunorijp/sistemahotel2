package sistemahotel.design.gerenciamento_local;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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

    ObservableList<Integer> list= FXCollections.observableArrayList();

    public void btNovaHabActionHandler(ActionEvent e){
        String nmroHab = tfNmroHab.getText();
        int camasSolteiro = (int) cbCamasDeSolteiro.getValue();
        int camasCasal = (int) cbCamasDeCasal.getValue();
        String informacoesAdicionais = taInformacoesAdicionais.getText();

        LocalDAO hab = new LocalDAO();
        hab.novaHabitacao(nmroHab,camasSolteiro,camasCasal,informacoesAdicionais);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Habitação Cadastrada");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        cbCamasDeSolteiro.setItems(list);
        cbCamasDeCasal.setItems(list);
    }
}
