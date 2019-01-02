package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField txtCity;
    public Label lblCity;
    public Slider slRange;
    public GridPane gpWeather, gpWeatherInfo;
    public ScrollPane weatherPane;
    public int range;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        range = 1;
        slRange();
        getLocation();
        getData();
    }

    public void getData() {
        GridPane gp = new GridPane();
        gp.add(new Label("Data"), 0, 0);
        gp.add(new Label("Temperatura[C]"), 1, 0);
        gp.add(new Label("Wiatr[km/h]"), 2, 0);

        for(int i = 1; i <= range+1; i++) {
            gp.add(new Label(WeatherService.time[i-1]), 0, i);
            gp.add(new Label(WeatherService.temp[i-1]), 1, i);
            gp.add(new Label(WeatherService.wind[i-1]), 2, i);
        }

        gp.setGridLinesVisible(true);
        gp.getColumnConstraints().add(new ColumnConstraints(112));
        gp.getColumnConstraints().add(new ColumnConstraints(90));
        gp.getColumnConstraints().add(new ColumnConstraints(70));
        weatherPane.setContent(gp);
    }
    public void slRange() {
        slRange.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (slRange.getValue() == 0) range = 0;
            if (slRange.getValue() == 1) range = 1;
            if (slRange.getValue() == 2) range = 39;
            getData();
        });
    }
    public void getLocation() {
        //jeżeli nie ustalono lokalizacji to ustaw domsślne i nie ma zapisanej
        //odczyt z bazy
        if(GeolocationService.getLocation() == null) {
            WeatherService.getData("Warszawa", 37);
            lblCity.setText("Warszawa");
        }
        else {
            WeatherService.getData(sample.GeolocationService.getLocation(), 37);
            lblCity.setText(sample.GeolocationService.getLocation());
        }
    }
    public void btnSearch(javafx.event.ActionEvent actionEvent) {
        WeatherService.temp = null;
        WeatherService.getData(txtCity.getText(), 37);
        if(WeatherService.temp != null) {
            lblCity.setText(txtCity.getText());
            getData();
        } else  WeatherService.getData(lblCity.getText(), 37);
    }
    public void lblNow(MouseEvent mouseEvent) { slRange.setValue(0); slRange(); }
    public void lblSixHours(MouseEvent mouseEvent) { slRange.setValue(1); slRange(); }
    public void lblFiveDays(MouseEvent mouseEvent) { slRange.setValue(2); slRange(); }
    public static void closeAction(){
        //zapis do bazy
        System.exit(0);
    }
}
