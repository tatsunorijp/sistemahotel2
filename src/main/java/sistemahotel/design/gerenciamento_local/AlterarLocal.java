package sistemahotel.design.gerenciamento_local;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.habitacaopass;
import static sistemahotel.infraestrutura.Passing.localpass;
import static sistemahotel.infraestrutura.Passing.salaopass;

/**
 * Created by marcelo on 30/07/17.
 */
public class AlterarLocal implements Initializable{
    @FXML
    TextField tfPreco;
    @FXML
    TextArea taInformacoes;
    @FXML
    ComboBox cbCamasDeSolteiro;
    @FXML
    ComboBox cbCamasDeCasal;

    public void btAlterarActionHandler(ActionEvent e){
        LocalDAO gr = LocalDAO.getInstance();
        String preco = tfPreco.getText();
        String informacoes = taInformacoes.getText();
        String camasSolteiro = cbCamasDeSolteiro.getSelectionModel().getSelectedItem().toString();
        String camasCasal = cbCamasDeCasal.getSelectionModel().getSelectedItem().toString();
        gr.alterarLocal(preco, informacoes, camasSolteiro, camasCasal);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Local alterado");
        alert.showAndWait();
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();

    }

    ObservableList<String> list= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");

        cbCamasDeSolteiro.setItems(list);
        cbCamasDeCasal.setItems(list);
        tfPreco.setText(localpass.getPreco());
        taInformacoes.setText(localpass.getInformacoesAdicionais());
    }
}
