package sistemahotel.design.gerenciamento_estoque;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;
import java.io.IOException;

//Programado por Tatsunori
public class AdicionarProduto {
    @FXML
    TextField tfNome;
    @FXML
    TextField tfQuantidade;
    @FXML
    TextField tfPreco;
    @FXML
    TextField tfAlertaEstoque;

    public void btNovoProdutoActionHandler(ActionEvent e) {
        EstoqueDAO estoque = EstoqueDAO.getInstance();
        String nome = tfNome.getText();
        String quantidade =tfQuantidade.getText();
        String preco = tfPreco.getText();
        String alertaEstoque = tfAlertaEstoque.getText();
        estoque.adicionarProduto(nome, quantidade, preco, alertaEstoque);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro Efetuado");
        alert.showAndWait();
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();

    }
}
