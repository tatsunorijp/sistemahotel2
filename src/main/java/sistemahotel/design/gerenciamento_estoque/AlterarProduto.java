
package sistemahotel.design.gerenciamento_estoque;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.produtopass;
//Programado por Marcelo
public class AlterarProduto implements Initializable{
    @FXML
    TextField tfNome;
    @FXML
    TextField tfQuantidade;
    @FXML
    TextField tfPreco;
    @FXML
    TextField tfAlertaEstoque;

    public void btAlterarActionHandler(ActionEvent e){
        EstoqueDAO estoque = new EstoqueDAO();
        String preco = tfPreco.getText();
        String quantidade = tfQuantidade.getText();
        String alertaEstoque = tfAlertaEstoque.getText();
        Long id = produtopass.getId();
        estoque.alterarProduto(id, preco, quantidade,alertaEstoque);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Alteração efetuada");
        alert.showAndWait();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfNome.setText(produtopass.getNome());
        tfPreco.setText(String.valueOf(produtopass.getPreco()));
        tfQuantidade.setText(String.valueOf(produtopass.getQuantidade()));
        tfAlertaEstoque.setText(String.valueOf(produtopass.getAlertaEstoque()));
        tfAlertaEstoque.setText(String.valueOf(produtopass.getAlertaEstoque()));
    }
}
