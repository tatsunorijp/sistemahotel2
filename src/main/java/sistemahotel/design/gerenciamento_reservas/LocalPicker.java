package sistemahotel.design.gerenciamento_reservas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.dominio.gerenciamento_local.Local;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by tatsunori on 28/07/17.
 */
public class LocalPicker implements Initializable {
    @FXML
    TableView<Local> TVLocal;
    @FXML
    TableColumn<Local, String> tcNumeroLocal;
    @FXML
    TableColumn <Local, String> tcTipoLocal; //TROCAR PARA STATUS
    @FXML
    TableColumn <Local, String> tcCamasCasal;
    @FXML
    TableColumn <Local, String> tcCamasSolteiro;
    @FXML
    TextField tfFiltro;
    ObservableList<Local> list;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableList(DataController.listLocal());
        tcNumeroLocal.setCellValueFactory( new PropertyValueFactory<>("Numero"));
        tcTipoLocal.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        tcCamasSolteiro.setCellValueFactory(new PropertyValueFactory<>("camasDeSolteiro"));
        tcCamasCasal.setCellValueFactory(new PropertyValueFactory<>("camasDeCasal"));
        TVLocal.setItems(FXCollections.observableList(list));

        // TRECHO DO FILTRO
        FilteredList<Local> filteredLocalData = new FilteredList<>(list, p -> true);
        tfFiltro.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredLocalData.setPredicate(local -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                /*if (local.getStatus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else */if (local.getNumero().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Local> sortedLocalData = new SortedList<>(filteredLocalData);
        sortedLocalData.comparatorProperty().bind(TVLocal.comparatorProperty());
        TVLocal.setItems(sortedLocalData);
        // TRECHO DO FILTRO

        TVLocal.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                    Passing.localpass = TVLocal.getSelectionModel().getSelectedItem();
                    ((Node)click.getSource()).getParent().getScene().getWindow().hide();
                    ((Node)click.getSource()).getParent().getScene().getWindow().hide();
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
            }
        });

    }
}
