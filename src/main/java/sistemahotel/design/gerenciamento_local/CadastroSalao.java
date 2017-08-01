package sistemahotel.design.gerenciamento_local;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;

import java.io.IOException;

public class CadastroSalao {

    @FXML
    TextField tfNmroSalao;
    @FXML
    TextField tfMaximoPessoas;
    @FXML
    TextArea taInformacoesAdicionais;
    @FXML
    TextField tfPrecoH;


    public void btCadastrarSalaoActionHandler(ActionEvent e){
        LocalDAO salao = LocalDAO.getInstance();
        String numeroSalao = tfNmroSalao.getText();
        String maximoPessoas = tfMaximoPessoas.getText();
        String informacoesAdicionais = taInformacoesAdicionais.getText();
        String precoH = tfPrecoH.getText();
        salao.novoSalao(numeroSalao,maximoPessoas,informacoesAdicionais,precoH);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Salão Cadastrado");
        alert.showAndWait();
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();


    }
}
