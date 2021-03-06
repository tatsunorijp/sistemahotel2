package sistemahotel.design.gerenciamento_reservas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_reserva.Consumacao;
import sistemahotel.infraestrutura.DataController;

import java.net.URL;
import java.util.ResourceBundle;


public class ListaConsumacao implements Initializable {
    @FXML
    TableView TVListaConsumo;
    @FXML
    TableColumn tcCliente;
    @FXML
    TableColumn tcProduto;
    @FXML
    TableColumn tcQuantidade;
    @FXML
    TableColumn tcPreco;
    ObservableList<Consumacao> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableList(DataController.listConsumacao());
        tcCliente.setCellValueFactory( new PropertyValueFactory<>("cliente"));
        tcProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tcPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        TVListaConsumo.setItems(FXCollections.observableList(list));

        /*// TRECHO DO FILTRO
        FilteredList<Consumacao> filteredProdutoData = new FilteredList<>(list, p -> true);
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
        sortedProdutoData.comparatorProperty().bind(TVProduto.comparatorProperty());
        TVProduto.setItems(sortedProdutoData);
        // TRECHO DO FILTRO*/
    }
}
