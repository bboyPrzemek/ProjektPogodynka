package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pogodynka");
        primaryStage.setScene(new Scene(root, 360, 690, Color.DEEPSKYBLUE));
        primaryStage.setResizable(false);
        primaryStage.setOnHidden(e -> sample.Controller.closeAction());
        primaryStage.show();

    }

    public static void main(String[] args) {

       launch(args);

//System.out.println(GeolocationService.getLocation().getName());

    }
}
