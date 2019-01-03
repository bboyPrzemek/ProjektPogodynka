package sample;

import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
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
import java.util.ResourceBundle;
import javafx.scene.image.Image ;
import javafx.scene.text.FontWeight;

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
        //przerwy miedzy kolumnami i wierszami
        gp.setHgap(3);
        gp.setVgap(3);
        //widoczne linie dzielące pola
        gp.setGridLinesVisible(true);
        //wyśrodkowanie kolumn i nadanie odpowiedniej szerokości i dodanie do gp
        ColumnConstraints column0 = new ColumnConstraints(110);
        column0.setHalignment(HPos.CENTER);
        gp.getColumnConstraints().add(column0);
        ColumnConstraints column1 = new ColumnConstraints(100);
        column1.setHalignment(HPos.CENTER);
        gp.getColumnConstraints().add(column1);
        ColumnConstraints column2 = new ColumnConstraints(110);
        column2.setHalignment(HPos.CENTER);
        gp.getColumnConstraints().add(column2);

        Label lblDate = new Label("Data");
        lblDate.setFont(javafx.scene.text.Font.font("Verdana", FontWeight.BOLD, 10));
        lblDate.setPrefHeight(40);
        Label lblTemp = new Label("Temperatura[°C]");
        lblTemp.setFont(javafx.scene.text.Font.font("Verdana", FontWeight.BOLD, 10));
        lblTemp.setPrefHeight(40);

        gp.add(lblDate, 0, 0);
        gp.add(lblTemp, 1, 0);

        for(int i = 1; i <= range+1; i++) {
            Label lblNewDate = new Label(weatherWrapper.getData().get(i).getDatetime());
            lblNewDate.setFont(javafx.scene.text.Font.font("Verdana", FontWeight.BOLD, 12));

            Label lblNewTemp = new Label(weatherWrapper.getData().get(i).getTemp().toString());
            lblNewTemp.setFont(javafx.scene.text.Font.font("Verdana", FontWeight.BOLD, 20));

            gp.add(lblNewDate, 0, i);
            gp.add(lblNewTemp, 1, i);

            /*OD TEGO SIE ZACINA */
            Image image = new Image("https://www.weatherbit.io/static/img/icons/"+weatherWrapper.getData().get(i).getWeather().getIcon()+".png");
            gp.add(new ImageView(image),2,i);
        }
        weatherPane.setContent(gp);
    }
    public void slRange() {
        slRange.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (slRange.getValue() == 0) range = 0;
            if (slRange.getValue() == 1) range = 1;
            if (slRange.getValue() == 2) range = 38;
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