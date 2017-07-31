package sistemahotel.design.gerenciamento_reservas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
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
    @FXML
    Button btMostraConsumacao;

    public void btMostraConsumacaoActionHandler(){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/lista_consumacao.fxml"));
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
