package sistemahotel.design.gerenciamento_reservas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.hibernate.Session;
import sistemahotel.dominio.gerenciamento_local.Local;
import sistemahotel.dominio.gerenciamento_reserva.ReservaDAO;
import sistemahotel.dominio.gerenciamento_clientes.Cliente;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.infraestrutura.Passing;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sistemahotel.infraestrutura.DataController.ssf;

public class ReservaLocal implements Initializable{

    Cliente clienteobj;
    Local localobj;

    @FXML
    TextField tfCliente;
    @FXML
    TextField tfQuarto;
    @FXML
    TextField tfHospedes;
    @FXML
    DatePicker dpCheckIn;
    @FXML
    DatePicker dpCheckOut;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    Button btClientePicker;
    @FXML
    Button btLocalPicker;


    public void btClientePickerActionHandler(ActionEvent e){
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
        Passing.resetClientepass();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/cliente_picker.fxml"));
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

    public void btLocalPickerActionHandler(ActionEvent e){
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/local_picker.fxml"));
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



    public void btReservaActionHandler(ActionEvent e) {


        Session session = ssf.openSession();
        DataController controller = new DataController();
        String cliente= tfCliente.getText();
        String quarto = tfQuarto.getText();
        String qtdhospedes = tfHospedes.getText();
        LocalDate dateIn = dpCheckIn.getValue();
        LocalDate dateOut = dpCheckOut.getValue();
        for (Cliente c : DataController.listCliente()) {
            if (c.getNome().equals(cliente))
                clienteobj = c;
        }
        for (Local h : DataController.listLocal()) {
            if (h.getNumero().equals(quarto))
                localobj = h;
        }
            ReservaDAO gr = ReservaDAO.getInstance();
            gr.novaReservaHab(clienteobj, localobj, dateIn, dateOut, qtdhospedes);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfCliente.setText(Passing.clientepass.getNome());
        tfQuarto.setText(Passing.localpass.getNumero());
    }
}
