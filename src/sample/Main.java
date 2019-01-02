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
        primaryStage.setOnHidden(e -> sample.Controller.closeAction());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        //WeatherService.getData(GeolocationService.getLocation(), 1);
        //GeolocationService.getLocation();
        //Location location = new Location("12,12","Koszalin");
        //DatabaseConnection.updateDatabase(location);
        //DatabaseConnection.getLocationFromDatabase();

        //Location location1 = DatabaseConnection.getLocationFromDatabase();
        //System.out.println(location1.getName());
    }
}
