package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller   {

    @FXML
    private Label lblCity;
    @FXML
    private TextField txtCity;
    @FXML
    private Button btnSearch;
    @FXML
    private Slider slRange;
    @FXML
    private Label lblNow;
    @FXML
    private Label lblSixHours;
    @FXML
    private Label lblFiveDays;
    @FXML
    private ScrollPane weatherPane;
    @FXML
    private GridPane gpWeather;

    @FXML
    public void initialize() {

            lblCity.setText(GeolocationService.getLocation());


            }
    @FXML
    public void searchButtonAction() {
        lblCity.setText(txtCity.getText());

    }






}
