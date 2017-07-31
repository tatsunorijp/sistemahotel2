package sistemahotel.design.gerenciamento_reservas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by tatsunori on 30/07/17.
 */
public class SelecionarConsumo implements Initializable {
    @FXML
    TableView TVConsumo;
    @FXML
    TableColumn tcNome;
    @FXML
    TableColumn tcPreco;
    @FXML
    TableColumn tcQuantidade;
    @FXML
    TextField tfFiltro;
    @FXML
    TextField tfQuantidade;
    @FXML
    Button btAdicionarConsumo;

    ObservableList<Produto> list;

    public void btAdicionarConsumoActionHandler(ActionEvent e){
        ReservaDAO add = new ReservaDAO();
        String nome = Passing.produtopass.getNome();
        String preco = Passing.produtopass.getPreco();
        String estoque = Passing.produtopass.getQuantidade();
        Long id = Passing.produtopass.getId();
        String cliente = Passing.reservapass.getCliente().getNome();
        String quantidadeConsumir = tfQuantidade.getText();


        if (add.addConsumo(nome, preco, quantidadeConsumir, estoque, id, cliente)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Consumo Registrado");
            alert.showAndWait();
            ((Node) e.getSource()).getParent().getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Operação não realizada");
            alert.setHeaderText(null);
            alert.setContentText("Estoque insuficiente");
            alert.showAndWait();
            ((Node) e.getSource()).getParent().getScene().getWindow().hide();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableList(DataController.listProduto());
        tcNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        tcPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        TVConsumo.setItems(FXCollections.observableList(list));

        // TRECHO DO FILTRO
        FilteredList<Produto> filteredProdutoData = new FilteredList<>(list, p -> true);
        tfFiltro.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredProdutoData.setPredicate(produto -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (produto.getNome().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Produto> sortedProdutoData = new SortedList<>(filteredProdutoData);
        sortedProdutoData.comparatorProperty().bind(TVConsumo.comparatorProperty());
        TVConsumo.setItems(sortedProdutoData);
        // TRECHO DO FILTRO

        TVConsumo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    Passing.produtopass = (Produto) TVConsumo.getSelectionModel().getSelectedItem();
                }
            }
        });
    }
}
