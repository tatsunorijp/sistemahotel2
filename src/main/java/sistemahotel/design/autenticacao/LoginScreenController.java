package sistemahotel.design.autenticacao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemahotel.dominio.gerenciamento_acesso.Usuario;

import java.io.IOException;
import java.util.Scanner;

public class LoginScreenController{
    private long idgerente;
    Usuario user;
    Scanner s = new Scanner(System.in);
    @FXML
    TextField tfLogin;

    @FXML
    PasswordField tfPassword;

    public void btLoginActionHandler(ActionEvent e){
        /*DataController controller = new DataController();
        String login = tfLogin.getText();
        String password = tfPassword.getText();
        Autenticacao autenticacao = new Autenticacao();
        user = autenticacao.Autenticar(login, password);

        if (user == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");   // comentado por motivos
            alert.setContentText("Usuario invalido");     // facilitar a autenticação
            alert.showAndWait();                    // do professor, sem gerente já registrado no
        }                                       // banco de dados
        else {*/
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/fxml_start/telainicial.fxml"));
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

        //}
    }

}
