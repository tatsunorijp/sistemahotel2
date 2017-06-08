package sistemahotel.design.gerenciamento_clientes;

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
import org.hibernate.Session;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_clientes.ClienteDAO;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static sistemahotel.infraestrutura.DataController.ssf;
import static sistemahotel.infraestrutura.Passing.clientepass;

//Programado por Leonardo
public class DeletarCadastro implements Initializable {
    @FXML
    ComboBox cbSelecionar;
    Session session = ssf.openSession();
    public void btDeletarActionHandler(ActionEvent e){
        ClienteDAO gc = new ClienteDAO();
        clientepass = (Cliente) cbSelecionar.getValue();
        gc.deletarCadastro(clientepass.getId());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro Deletado");
        alert.showAndWait();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Cliente> list = FXCollections.observableList(DataController.listCliente());
        cbSelecionar.setItems(list);
    }
}
