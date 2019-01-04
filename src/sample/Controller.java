package sample;

import javafx.fxml.Initializable;
import javafx.geometry.HPos;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;


import java.net.URL;

import java.text.Normalizer;


 
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

        getData();
        slRange();

    }
    public void getData() {

        GridPane gp = new GridPane();
        gp.setStyle("-fx-background-color: SKYBLUE");


        //przerwy miedzy kolumnami i wierszami
        gp.setHgap(3);
        gp.setVgap(3);
        //widoczne linie dzielące pola
        gp.setGridLinesVisible(false);
        //wyśrodkowanie kolumn i nadanie odpowiedniej szerokości i dodanie do gp
        ColumnConstraints column0 = new ColumnConstraints(125);
        column0.setHalignment(HPos.CENTER);
        gp.getColumnConstraints().add(column0);
        ColumnConstraints column1 = new ColumnConstraints(100);
        column1.setHalignment(HPos.CENTER);
        gp.getColumnConstraints().add(column1);
        ColumnConstraints column2 = new ColumnConstraints(105);
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

        for(int i = 0; i < range+1; i++) {
            System.out.println("petla"+i);
            Label lblNewDate = new Label(UnixToTimeConverter.convert(Long.valueOf(weatherWrapper.getData().get(i).getTs())));
            System.out.println(lblNewDate);
            lblNewDate.setFont(javafx.scene.text.Font.font("Verdana", FontWeight.BOLD, 12));

            Label lblNewTemp = new Label(weatherWrapper.getData().get(i).getTemp().toString());
            lblNewTemp.setFont(javafx.scene.text.Font.font("Verdana", FontWeight.BOLD, 20));

            gp.add(lblNewDate, 0, i+1);
            gp.add(lblNewTemp, 1, i+1);

            /*OD TEGO SIE ZACINA */
            Image image = new Image("https://www.weatherbit.io/static/img/icons/"+weatherWrapper.getData().get(i).getWeather().getIcon()+".png");
            System.out.println(image);
            gp.add(new ImageView(image),2,i+1);
        }
        weatherPane.setContent(gp);
    }
    public void slRange() {

        slRange.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(slRange.valueProperty());
            if (slRange.getValue() == 0) range = 0;
            if (slRange.getValue() == 1) range = 1;
            if (slRange.getValue() == 2) range = 4;

        });
        getData();
    }
    public void btnSearch(javafx.event.ActionEvent actionEvent) {
        String town =Normalizer.normalize(txtCity.getText(), Normalizer.Form.NFD);
        town = town.replaceAll("[^\\p{ASCII}]", "");
        weatherWrapper=WeatherService.getData(town);
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