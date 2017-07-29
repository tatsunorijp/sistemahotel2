package sistemahotel.design.gerenciamento_local;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.localpass;

/**
 * Created by marcelo on 29/07/17.
 */
public class MostraLocal implements Initializable{
    @FXML
    TextField tfNumero;
    @FXML
    TextField tfTipo;
    @FXML
    TextField tfStatus;
    @FXML
    TextField tfInformacoes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfNumero.setText(localpass.getNumero());
        tfTipo.setText(localpass.getTipo());
        tfStatus.setText(localpass.getStatus());
        tfInformacoes.setText(localpass.getInformacoesAdicionais());
    }
}
