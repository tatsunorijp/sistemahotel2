//classe inutilizada
package sistemahotel.design.gerenciamento_estoque;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_clientes.ClienteDAO;
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.dominio.gerenciamento_local.LocalDAO;
import sistemahotel.dominio.gerenciamento_reserva.Reserva;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.habitacaopass;
import static sistemahotel.infraestrutura.Passing.produtopass;

//Programado por Leonardo
public class RemoverProduto implements Initializable{
    @FXML
    TableView tvDeletarProduto;
    @FXML
    TableColumn tcNome;
    @FXML
    TableColumn tcPreco;
    @FXML
    TableColumn tcQuantidade;
    @FXML
    TableColumn tcId;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EstoqueDAO dp = new EstoqueDAO();
        ObservableList<Produto> list = FXCollections.observableList(DataController.listProduto());
        tcNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        tcPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tvDeletarProduto.setItems(FXCollections.observableList(list));

        tvDeletarProduto.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {

                    Passing.produtopass = (Produto) tvDeletarProduto.getSelectionModel().getSelectedItem();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Deletar Produto");
                    alert.setHeaderText("Deseja deletar o produto selecionado?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        dp.removerProduto(Passing.produtopass);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                    }
                }
            }
        });


    }
}
