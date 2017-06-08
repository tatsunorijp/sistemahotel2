package sistemahotel.design.gerenciamento_reservas;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.reservapass;
//Programado por Marcelo
public class AlterarReserva implements Initializable{
    Cliente clienteobj;
    Habitacao habitacaoobj;
    @FXML
    TextField tfNomeCliente;
    @FXML
    TextField tfLocal;
    @FXML
    TextField tfStatus;
    @FXML
    DatePicker dpData;

    public void btAlterarActionHandler(ActionEvent e){
        ReservaDAO gr = new ReservaDAO();
        String nome = tfNomeCliente.getText();
        String local = tfLocal.getText();
        String status = tfStatus.getText();
        LocalDate date = dpData.getValue();
        gr.alterarReserva(nome, local, status, date);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operação realizada com sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Reserva Alterada");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tfNomeCliente.setText(reservapass.getCliente().getNome());
        tfLocal.setText(reservapass.getLocal().getNumero());
        tfStatus.setText(reservapass.getStatus());
    }
}
