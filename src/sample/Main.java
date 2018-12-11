package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pogodynka");
        primaryStage.setScene(new Scene(root, 290, 590));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);


//        WeatherService.getData(GeolocationService.getLocation(), 1);
        GeolocationService.getLocation();
        WeatherService.getData("Warszawa", 1);
        DatabaseConnection.connect();
    }
}
