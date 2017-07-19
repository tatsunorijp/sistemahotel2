package sistemahotel.design.gerenciamento_clientes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_clientes.ClienteDAO;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

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
    TextField tfInformacoesAdicionais;
    @FXML
    DatePicker tfDataDeNascimento;

    public void btCadastrarActionHandler(ActionEvent e) {

        DataController controller = new DataController();
        String nome = tfNome.getText();
        String cpf = tfCpf.getText();
        String rg = tfRG.getText();
        String endereco = tfEndereco.getText();
        String telefone = tfTelefone.getText();
        String email = tfEmail.getText();
        String cidade = tfCidade.getText();
        String nacionalidade = tfNacionalidade.getText();
        String placaDoCarro = tfPlacaDoCarro.getText();
        String informacoesAdicionais = tfInformacoesAdicionais.getText();
        LocalDate dataDeNascimento = tfDataDeNascimento.getValue();

        ClienteDAO gc = new ClienteDAO();
        gc.novoCliente(nome, endereco, cpf,telefone,rg);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro Efetuado");
        alert.showAndWait();
        }

}
