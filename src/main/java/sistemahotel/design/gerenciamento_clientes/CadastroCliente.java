package sistemahotel.design.gerenciamento_clientes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_clientes.ClienteDAO;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;

//Programado por Tatsunori
public class CadastroCliente {
    @FXML
    TextField tfNome;
    @FXML
    TextField tfCpf;
    @FXML
    TextField tfEndereco;
    @FXML
    TextField tfTelefone;
    public void btCadastrarActionHandler(ActionEvent e) {

        DataController controller = new DataController();
        String nome = tfNome.getText();
        String cpf = tfCpf.getText();
        String endereco = tfEndereco.getText();
        String telefone = tfTelefone.getText();
        ClienteDAO gc = new ClienteDAO();
        gc.novoCliente(nome, endereco, cpf,telefone);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro Efetuado");
        alert.showAndWait();
        }

}
