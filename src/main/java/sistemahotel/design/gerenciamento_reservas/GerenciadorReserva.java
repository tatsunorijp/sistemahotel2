package sistemahotel.design.gerenciamento_reservas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by marcelo on 27/07/17.
 */
public class GerenciadorReserva {
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
        loader.setLocation(getClass().getResource("/fxml/fxml_reservas/alterar_reserva_list.fxml"));
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

    public void btExcluirActionHandler(ActionEvent e){
        Stage stage = new Stage();
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
        stage.show();
    }

}