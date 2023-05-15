package Pharmagest;

import Pharmagest.login.Controlelog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent fenetre = FXMLLoader.load(Controlelog.class.getResource("login.fxml"));
        Scene scene = new Scene(fenetre);

        stage.setTitle("pharmagest");

        stage.setResizable(false);

        Image icon = new Image("file:assets/images/logo.png");
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();

    }

}
