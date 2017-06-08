package sistemahotel.design.gerenciamento_estoque;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.produtopass;
//Programado por Marcelo
public class AlterarProdutoSelecao implements Initializable {
    @FXML
    ComboBox cbProduto;

    public void btSelecionarProdutoActionHandler(ActionEvent e){
        produtopass = (Produto) cbProduto.getValue();
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
        ((Node) e.getSource()).getParent().getScene().getWindow();
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Produto> list = FXCollections.observableList(DataController.listProduto());
        cbProduto.setItems(list);
    }
}
