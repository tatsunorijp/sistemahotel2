package sistemahotel.design.telainicial;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import sistemahotel.infraestrutura.DataController;
import sistemahotel.dominio.gerenciamento_acesso.Usuario;

import java.io.IOException;

import static sistemahotel.infraestrutura.DataController.ssf;

public class SelectScreen {
    Session session = ssf.openSession();
    Usuario usuario = (Usuario) session.get(Usuario.class, 1L);
    DataController controller = new DataController();


    public void btReservasActionHandler(ActionEvent e){
        DataController controller = new DataController();
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

    public void btClientesActionHandler(ActionEvent e){
        DataController controller = new DataController();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_clientes/gerenciador_clientes.fxml"));
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

    public void btLocaisActionHandler(ActionEvent e){

        DataController controller = new DataController();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_locais/gerenciador_locais.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setTitle("Gerenciado Locais");
        stage.setScene(new Scene(root));
        ((Node)e.getSource()).getParent().getScene().getWindow().hide();
        stage.show();
    }

    public void btEstoqueActionHandler(ActionEvent e){
        DataController controller = new DataController();
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

    public void btExitActionHandler(ActionEvent e){
        DataController.ssf.close();
        System.exit(0);
    }
}
