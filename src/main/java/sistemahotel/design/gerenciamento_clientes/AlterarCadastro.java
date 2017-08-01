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
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.clientepass;


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
    @FXML
    TextField tfEmail;
    @FXML
    TextField tfCidade;
    @FXML
    TextField tfNacionalidade;
    @FXML
    TextField tfPlacaDoCarro;
    @FXML
    TextArea tfInformacoesAdicionais;
    @FXML
    DatePicker tfDataDeNascimento;

    public void btAlterarActionHandler(ActionEvent e) {
        ClienteDAO gc = ClienteDAO.getInstance();
        String nome = tfNomeCliente.getText();
        String cpf = tfCpfCliente.getText();
        String rg = tfRG.getText();
        String endereco = tfEnderecoCliente.getText();
        String telefone = tfTelefoneCliente.getText();
        String email = tfEmail.getText();
        String cidade = tfCidade.getText();
        String nacionalidade = tfNacionalidade.getText();
        String placaDoCarro = tfPlacaDoCarro.getText();
        String informacoesAdicionais = tfInformacoesAdicionais.getText();
        LocalDate dataDeNascimento = tfDataDeNascimento.getValue();

        gc.alterarCadastro(nome, endereco, cpf, telefone,rg,email,cidade,nacionalidade,placaDoCarro,informacoesAdicionais,dataDeNascimento);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro Alterado");
        alert.showAndWait();
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfNomeCliente.setText(clientepass.getNome());
        tfEnderecoCliente.setText(clientepass.getEndereco());
        tfCpfCliente.setText(clientepass.getCPF());
        tfTelefoneCliente.setText(clientepass.getTelefone());
        tfRG.setText(clientepass.getRG());
        tfEmail.setText(clientepass.getEmail());
        tfCidade.setText(clientepass.getCidade());
        tfNacionalidade.setText(clientepass.getNacionalidade());
        tfPlacaDoCarro.setText(clientepass.getPlacaDoCarro());
        tfInformacoesAdicionais.setText(clientepass.getInformacoesAdicionais());
        //tfDataDeNascimento.setValue(clientepass.getDataDeNascimento());
    }
}
