package sistemahotel.design.gerenciamento_estoque;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;
import sistemahotel.dominio.gerenciamento_reserva.Reserva;
import sistemahotel.infraestrutura.DataController;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.habitacaopass;
import static sistemahotel.infraestrutura.Passing.produtopass;

//Programado por Leonardo
public class RemoverProduto implements Initializable{
    @FXML
    ComboBox cbProduto;
    public void btRemoverProdutoActionHandler(ActionEvent e){
        EstoqueDAO dao = new EstoqueDAO();
        produtopass = (Produto) cbProduto.getValue();
        dao.removerProduto(produtopass.getId());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Produto deletado");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Produto> list = FXCollections.observableList(DataController.listProduto());
        cbProduto.setItems(list);

    }
}
