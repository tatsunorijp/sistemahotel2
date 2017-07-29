package sistemahotel.design.gerenciamento_reservas;

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
import sistemahotel.dominio.gerenciamento_estoque.Produto;
import sistemahotel.dominio.gerenciamento_reserva.Reserva;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.DataController.ssf;
import static sistemahotel.infraestrutura.Passing.reservapass;

/**
 * Created by marcelo on 27/07/17.
 */
public class GerenciadorReserva implements Initializable{
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
    Button btCheckIn;
    @FXML
    TableView<Reserva> TVReserva;
    @FXML
    TableColumn<Reserva, String> tcCliente;
    @FXML
    TableColumn <Reserva, String> tcLocal;
    @FXML
    TableColumn <Reserva, String> tcStatus;
    @FXML
    TableColumn <Reserva, String> tcData;

    ObservableList<Reserva> list;

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
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
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
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
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

    public void btNovaReservaActionHandler(ActionEvent e){
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
            dl.deletarReserva(reservapass);
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

    public void btCheckInActionHandler(ActionEvent e){
        ReservaDAO dl = new ReservaDAO();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Realizar Check In");
        alert.setHeaderText("Deseja realizar o check in da reserva selecionada?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose CANCEL or closed the dialog
            dl.checkIn();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableList(DataController.listReserva());
        tcCliente.setCellValueFactory( new PropertyValueFactory<>("cliente"));
        tcLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tcData.setCellValueFactory(new PropertyValueFactory<>("data"));
        TVReserva.setItems(FXCollections.observableList(list));

        // TRECHO DO FILTRO
        FilteredList<Reserva> filteredReservaData = new FilteredList<>(list, p -> true);
        tfFiltro.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredReservaData.setPredicate(reserva -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (reserva.getCliente().getNome().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (reserva.getStatus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Reserva> sortedReservaData = new SortedList<>(filteredReservaData);
        sortedReservaData.comparatorProperty().bind(TVReserva.comparatorProperty());
        TVReserva.setItems(sortedReservaData);
        // TRECHO DO FILTRO

        TVReserva.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 1) {
                    reservapass = TVReserva.getSelectionModel().getSelectedItem();

                }
                else if (click.getClickCount() == 2){
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader();
                    Parent root = null;
                    loader.setLocation(getClass().getResource("/fxml/fxml_reservas/mostra_reserva.fxml"));
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
