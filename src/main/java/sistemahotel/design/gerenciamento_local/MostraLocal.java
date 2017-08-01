package sistemahotel.design.gerenciamento_local;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.localpass;


public class MostraLocal implements Initializable{
    @FXML
    TextField tfNumero;
    @FXML
    TextField tfTipo;
    @FXML
    TextField tfPreco;
    @FXML
    TextField tfStatus;
    @FXML
    TextArea taInformacoes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfNumero.setText(localpass.getNumero());
        tfTipo.setText(localpass.getTipo());
        tfPreco.setText(localpass.getPreco());
        tfStatus.setText(localpass.getStatus());
        taInformacoes.setText(localpass.getInformacoesAdicionais());
    }
}
