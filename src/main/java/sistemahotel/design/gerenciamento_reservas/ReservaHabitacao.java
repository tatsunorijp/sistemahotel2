package sistemahotel.design.gerenciamento_reservas;

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
import org.hibernate.Session;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.dominio.gerenciamento_local.Habitacao;
import sistemahotel.infraestrutura.DataController;

import java.io.IOException;
import java.time.LocalDate;

import static sistemahotel.infraestrutura.DataController.ssf;

//Programado por Tatsunori

public class ReservaHabitacao {
    Cliente clienteobj;
    Habitacao habitacaoobj;
    @FXML
    TextField tfCliente;
    @FXML
    TextField tfQuarto;
    @FXML
    DatePicker dpCheckIn;
    @FXML
    DatePicker dpCheckOut;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void btReservaActionHandler(ActionEvent e) {

        Session session = ssf.openSession();
        DataController controller = new DataController();
        String cliente = tfCliente.getText();
        String quarto = tfQuarto.getText();
        LocalDate dateIn = dpCheckIn.getValue();
        LocalDate dateOut = dpCheckOut.getValue();
        for (Cliente c : DataController.listCliente()) {
            if (c.getNome().equals(cliente))
                clienteobj = c;
        }
        for (Habitacao h : DataController.listHabitacoes()) {
            if (h.getNumero().equals(quarto))
                habitacaoobj = h;
        }
            ReservaDAO gr = new ReservaDAO();
            gr.novaReservaHab(clienteobj, habitacaoobj, dateIn, dateOut);
            alert.setTitle("Operação realizada com sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Reserva Efetuada");
            ((Node)e.getSource()).getParent().getScene().getWindow().hide();
            alert.showAndWait();


        if (clienteobj == null) {
            alert.setTitle("Falha");
            alert.setHeaderText(null);
            alert.setContentText("Cliente Invalido");
            alert.showAndWait();

        }
    }
}
