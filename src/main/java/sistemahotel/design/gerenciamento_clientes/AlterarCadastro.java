package sistemahotel.design.gerenciamento_clientes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_clientes.ClienteDAO;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.clientepass;

//Programado por Marcelo

public class AlterarCadastro implements Initializable{
    @FXML
    TextField tfNomeCliente;
    @FXML
    TextField tfEnderecoCliente;
    @FXML
    TextField tfCpfCliente;
    @FXML
    TextField tfTelefoneCliente;
    @FXML
    TextField tfRG;
    public void btAlterarActionHandler(ActionEvent e) {
        ClienteDAO gc = new ClienteDAO();
        String nome = tfNomeCliente.getText();
        String endereco = tfEnderecoCliente.getText();
        String cpf = tfCpfCliente.getText();
        String telefone = tfTelefoneCliente.getText();
        String rg = tfRG.getText();
        gc.alterarCadastro(nome, endereco, cpf, telefone,rg);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro Alterado");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfNomeCliente.setText(clientepass.getNome());
        tfEnderecoCliente.setText(clientepass.getEndereco());
        tfCpfCliente.setText(clientepass.getCPF());
        tfTelefoneCliente.setText(clientepass.getTelefone());
        tfRG.setText(clientepass.getRG());
    }
}
