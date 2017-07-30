package sistemahotel.design.gerenciamento_local;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.habitacaopass;
import static sistemahotel.infraestrutura.Passing.salaopass;

/**
 * Created by marcelo on 30/07/17.
 */
public class AlterarLocal implements Initializable{
    @FXML
    TextField tfPreco;
    @FXML
    TextArea taInformacoes;

    public void btAlterarActionHandler(ActionEvent e){
        LocalDAO gr = new LocalDAO();
        String preco = tfPreco.getText();
        String informacoes = taInformacoes.getText();
        gr.alterarLocal(preco, informacoes);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Local alterado");
        alert.showAndWait();
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfPreco.setText(salaopass.getPreco());
        taInformacoes.setText(salaopass.getInformacoesAdicionais());
    }
}
