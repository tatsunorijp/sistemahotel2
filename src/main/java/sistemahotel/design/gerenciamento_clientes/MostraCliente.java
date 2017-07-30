package sistemahotel.design.gerenciamento_clientes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.clientepass;

/**
 * Created by marcelo on 29/07/17.
 */
public class MostraCliente implements Initializable{
    @FXML
    TextField tfNome;
    @FXML
    TextField tfEndereco;
    @FXML
    TextField tfTelefone;
    @FXML
    TextField tfRG;
    @FXML
    TextField tfCPF;
    @FXML
    TextField tfEmail;
    @FXML
    TextField tfCidade;
    @FXML
    TextField tfNacionalidade;
    @FXML
    TextField tfPlaca;
    @FXML
    TextField tfData;
    @FXML
    TextArea taInformacoes;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfNome.setText(clientepass.getNome());
        tfEndereco.setText(clientepass.getEndereco());
        tfTelefone.setText(clientepass.getTelefone());
        tfRG.setText(clientepass.getRG());
        tfCPF.setText(clientepass.getCPF());
        tfEmail.setText(clientepass.getEmail());
        tfCidade.setText(clientepass.getCidade());
        tfNacionalidade.setText(clientepass.getNacionalidade());
        tfPlaca.setText(clientepass.getPlacaDoCarro());
        tfData.setText(String.valueOf(clientepass.getDataDeNascimento()));
        taInformacoes.setText(clientepass.getInformacoesAdicionais());
    }


}
