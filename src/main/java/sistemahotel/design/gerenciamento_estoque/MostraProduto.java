package sistemahotel.design.gerenciamento_estoque;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.produtopass;


public class MostraProduto implements Initializable{
    @FXML
    TextField tfNome;
    @FXML
    TextField tfQuantidade;
    @FXML
    TextField tfPreco;
    @FXML
    TextField tfAlerta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfNome.setText(produtopass.getNome());
        tfQuantidade.setText(produtopass.getQuantidade());
        tfPreco.setText(produtopass.getPreco());
        tfAlerta.setText(produtopass.getAlertaEstoque());
    }
}
