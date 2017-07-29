package sistemahotel.design.gerenciamento_reservas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sistemahotel.infraestrutura.Passing;

import java.net.URL;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.Passing.reservapass;

/**
 * Created by marcelo on 29/07/17.
 */
public class MostraReserva implements Initializable{

    @FXML
    TextField tfCliente;
    @FXML
    TextField tfTipo;
    @FXML
    TextField tfNumero;
    @FXML
    TextField tfStatus;
    @FXML
    TextField tfCheckIn;
    @FXML
    TextField tfCheckOut;
    @FXML
    TextField tfQuantidadeHospede;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfCliente.setText(reservapass.getCliente().getNome());
        tfTipo.setText(reservapass.getLocal().getTipo());
        tfNumero.setText(reservapass.getLocal().getNumero());
        tfStatus.setText(reservapass.getStatus());
        tfCheckIn.setText(String.valueOf(reservapass.getCheckIn()));
        tfCheckOut.setText(String.valueOf(reservapass.getCheckOut()));
        tfQuantidadeHospede.setText(reservapass.getQtdhospede());
    }
}
