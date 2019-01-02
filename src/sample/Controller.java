package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.image.Image ;
public class Controller implements Initializable {

    public TextField txtCity;
    public Label lblCity;
    public Slider slRange;
    public GridPane gpWeather, gpWeatherInfo;
    public ScrollPane weatherPane;
    public int range;
    private WeatherWrapper weatherWrapper;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        weatherWrapper= WeatherService.getData(GeolocationService.getLocation());

        range = 1;
        slRange();

        getData();
    }


    public void getData() {
        GridPane gp = new GridPane();
        gp.add(new Label("Data"), 0, 0);
        gp.add(new Label("Temperatura[C]"), 1, 0);


        for(int i = 1; i <= range+1; i++) {
            gp.add(new Label(weatherWrapper.getData().get(i).getDatetime()), 0, i);
            gp.add(new Label(weatherWrapper.getData().get(i).getTemp().toString()), 1, i);

            /*OD TEGO SIE ZACINA */
//            Image image = new Image("https://www.weatherbit.io/static/img/icons/"+weatherWrapper.getData().get(i).getWeather().getIcon()+".png");
//            gp.add(new ImageView(image),2,i);
        }

        gp.setGridLinesVisible(true);
        gp.getColumnConstraints().add(new ColumnConstraints(80));
        gp.getColumnConstraints().add(new ColumnConstraints(90));
        gp.getColumnConstraints().add(new ColumnConstraints(110));

        weatherPane.setContent(gp);
    }
    public void slRange() {
        slRange.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (slRange.getValue() == 0) range = 0;
            if (slRange.getValue() == 1) range = 1;
            if (slRange.getValue() == 2) range = 6;
            getData();

        });
    }

    public void btnSearch(javafx.event.ActionEvent actionEvent) {

        weatherWrapper=WeatherService.getData(txtCity.getText());

            lblCity.setText(txtCity.getText());
            getData();

    }
    public void lblNow(MouseEvent mouseEvent) { slRange.setValue(0); slRange(); }
    public void lblSixHours(MouseEvent mouseEvent) { slRange.setValue(1); slRange(); }
    public void lblFiveDays(MouseEvent mouseEvent) { slRange.setValue(2); slRange(); }
    public static void closeAction(){
        //zapis do bazy
        System.exit(0);
    }
}