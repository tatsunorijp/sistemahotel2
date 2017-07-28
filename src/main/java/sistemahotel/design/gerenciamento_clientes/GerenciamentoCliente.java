package sistemahotel.design.gerenciamento_clientes;

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
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_clientes.ClienteDAO;
import sistemahotel.dominio.pessoa.Pessoa;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by marcelo on 27/07/17.
 */
public class GerenciamentoCliente implements Initializable{
    @FXML
    TextField tfFiltro;
    @FXML
    Button btClientes;
    @FXML
    Button btReservas;
    @FXML
    Button btLocal;
    @FXML
    Button btEstoque;
    @FXML
    Button btNovaReservaHab;
    @FXML
    Button btNovaReservaSalao;
    @FXML
    Button btAlterar;
    @FXML
    Button btExcluir;
    @FXML
    TableView<Cliente> TVCliente;
    @FXML
    TableColumn<Pessoa, String> TCNome;
    @FXML
    TableColumn <Pessoa, String> TCRG;

    ObservableList<Cliente> list;

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
        loader.setLocation(getClass().getResource("/fxml/fxml_clientes/cadastro_cliente.fxml"));
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
        Parent root = null;
        loader.setLocation(getClass().getResource("/fxml/fxml_clientes/cadastrocliente_selecionado.fxml"));
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
        ClienteDAO dc = new ClienteDAO();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deletar Reserva");
        alert.setHeaderText("Deseja deletar o cliente selecionado?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            dc.deletarCadastro(Passing.clientepass);

        } else {
            // ... user chose CANCEL or closed the dialog
        }

        /*Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_clientes/deletar_cadastrocliente.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        stage.show();*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableList(DataController.listCliente());
        TCNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        TCRG.setCellValueFactory(new PropertyValueFactory<>("RG"));
        TVCliente.setItems(FXCollections.observableList(list));
        ClienteDAO dc = new ClienteDAO();

        // TRECHO DO FILTRO
        FilteredList<Cliente> filteredClienteData = new FilteredList<>(list, p -> true);
        tfFiltro.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredClienteData.setPredicate(cliente -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (cliente.getNome().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (cliente.getRG().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Cliente> sortedClienteData = new SortedList<>(filteredClienteData);
        sortedClienteData.comparatorProperty().bind(TVCliente.comparatorProperty());
        TVCliente.setItems(sortedClienteData);
        // TRECHO DO FILTRO

        TVCliente.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    Passing.clientepass = TVCliente.getSelectionModel().getSelectedItem();

                }
            }
        });
    }
}
