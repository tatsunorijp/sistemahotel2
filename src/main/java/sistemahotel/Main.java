package sistemahotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sistemahotel.infraestrutura.DataController;

public class Main extends Application {
    public static void main(String[] args) {
        DataController.startSessionFactory();
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/fxml_start/login.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Sistema Hotel");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}

