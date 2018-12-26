package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField txtCity;
    public Label lblCity;
    public Slider slRange;
    public GridPane gpWeather, gpWeatherInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Label temp = new Label("Temp:");
        Label wind = new Label("Wiatr:");
        Label rain = new Label("Opady:");

        Label ico = new Label("Ico");

        gpWeather.add(ico,0,0);
        gpWeatherInfo.add(temp, 0, 0);
        gpWeatherInfo.add(wind, 0, 1);
        gpWeatherInfo.add(rain, 0, 2);
    }

    public void btnSearch(javafx.event.ActionEvent actionEvent) {
        lblCity.setText(txtCity.getText());
    }

    public void lblNow(MouseEvent mouseEvent) { slRange.setValue(0); }
    public void lblSixHours(MouseEvent mouseEvent) { slRange.setValue(1); }
    public void lblFiveDays(MouseEvent mouseEvent) { slRange.setValue(2); }
}
