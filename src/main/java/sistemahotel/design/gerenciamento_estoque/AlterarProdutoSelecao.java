//classe inutilizada
package sistemahotel.design.gerenciamento_estoque;

import com.sun.org.apache.xml.internal.security.Init;
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
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.produtopass;
//Programado por Marcelo
public class AlterarProdutoSelecao implements Initializable {
    @FXML
    TableView tvAlterarProduto;
    @FXML
    TableColumn tcNome;
    @FXML
    TableColumn tcPreco;
    @FXML
    TableColumn tcQuantidade;
    @FXML
    TableColumn tcId;

    /*public void btSelecionarProdutoActionHandler(ActionEvent e){
        produtopass = (Produto) cbProduto.getValue();

    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EstoqueDAO ap = new EstoqueDAO();
        ObservableList<Produto> list = FXCollections.observableList(DataController.listProduto());
        tcNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        tcPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tvAlterarProduto.setItems(FXCollections.observableList(list));

        tvAlterarProduto.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {

                    Passing.produtopass = (Produto) tvAlterarProduto.getSelectionModel().getSelectedItem();
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = null;
                    loader.setLocation(getClass().getResource("/fxml/fxml_estoque/alterar_produto.fxml"));
                    try {
                        root = loader.load();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    stage.setTitle("Sistema Hotel");
                    stage.setScene(new Scene(root));
                    stage.show();

                }
            }
        });
    }
}
