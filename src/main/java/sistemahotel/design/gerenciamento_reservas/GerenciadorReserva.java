package sistemahotel.design.gerenciamento_reservas;

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
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_reserva.Reserva;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by marcelo on 27/07/17.
 */
public class GerenciadorReserva implements Initializable{
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
    TableView<Reserva> tvReserva;
    @FXML
    TableColumn<Reserva, String> tcCliente;
    @FXML
    TableColumn <Reserva, String> tcLocal;
    @FXML
    TableColumn <Reserva, String> tcStatus;
    @FXML
    TableColumn <Reserva, String> tcData;

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
        stage.show();
    }

    public void btNovaReservaHabActionHandler(ActionEvent e){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/reserva_habitacao.fxml"));
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

    public void btNovaReservaSalaoActionHandler(ActionEvent e){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/reserva_salao.fxml"));
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
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/reserva_selecionada.fxml"));
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        stage.show();

        /*Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/alterar_reserva_list.fxml"));
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

    public void btExcluirActionHandler(ActionEvent e){
        ReservaDAO dl = new ReservaDAO();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deletar Reserva");
        alert.setHeaderText("Deseja deletar a reserva selecionada?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            dl.deletarReserva(Passing.reservapass);
        } else {
            // ... user chose CANCEL or closed the dialog
        }


        /*Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/deletar_reserva.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Sistema Hotel");
        stage.setScene(new Scene(root));
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
        stage.show();*/
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Reserva> list = FXCollections.observableList(DataController.listReserva());
        tcCliente.setCellValueFactory( new PropertyValueFactory<>("cliente"));
        tcLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tcData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tvReserva.setItems(FXCollections.observableList(list));

        tvReserva.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    Passing.reservapass = tvReserva.getSelectionModel().getSelectedItem();

                }
            }
        });
    }
}
