package sistemahotel.design.gerenciamento_local;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;

import java.io.IOException;
//Programado por Tatsunori
public class CadastroSalao {

    @FXML
    TextField tfNmroSalao;



    public void btCadastrarSalaoActionHandler(ActionEvent e){
        LocalDAO salao = new LocalDAO();
        salao.novoSalao(tfNmroSalao.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Salão Cadastrado");
        alert.showAndWait();

    }
}
