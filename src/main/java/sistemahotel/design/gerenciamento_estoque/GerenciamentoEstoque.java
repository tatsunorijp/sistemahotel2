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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_estoque.EstoqueDAO;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by marcelo on 27/07/17.
 */
public class GerenciamentoEstoque implements Initializable{
    @FXML
    Button btClientes;
    @FXML
    Button btReservas;
    @FXML
    Button btLocal;
    @FXML
    Button btEstoque;
    @FXML
    Button btNovo;
    @FXML
    Button btAlterar;
    @FXML
    Button btExcluir;
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

    public void btClientesActionHandler(ActionEvent e) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_clientes/gerenciador_cliente.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        ((Node) e.getSource()).getParent().getScene().getWindow().hide();
        stage.show();
    }

    public void btReservasActionHandler(ActionEvent e) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/gerenciador_reserva.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        ((Node) e.getSource()).getParent().getScene().getWindow().hide();
        stage.show();
    }

    public void btLocalActionHandler(ActionEvent e){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_locais/gerenciador_locais.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
        stage.show();
    }

    public void btEstoqueActionHandler(ActionEvent e){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_estoque/gerenciador_estoque.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
        stage.show();
    }

    public void btNovoActionHandler(ActionEvent e){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_estoque/adicionar_produto.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void btAlterarActionHandler(ActionEvent e){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_estoque/selecionar_alterar_produto.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void btExcluirActionHandler(ActionEvent e){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_estoque/remover_produto.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EstoqueDAO ap = new EstoqueDAO();
        ObservableList<Produto> list = FXCollections.observableList(DataController.listProduto());
        tcNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        tcPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tvAlterarProduto.setItems(FXCollections.observableList(list));

    }
}
