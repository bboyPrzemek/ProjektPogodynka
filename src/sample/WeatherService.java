package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherService {

    private static String WEATHER_URL = "https://api.weatherbit.io/v2.0/forecast/3hourly?city=";
    private static String WEATHER_API_KEY = "&key=e68ec873619a4394bc1efdc85f4a2839";

    //e68ec873619a4394bc1efdc85f4a2839
    //private static String WEATHER_CITY = "Świdwin";

    public static WeatherWrapper getData(String location) {
        try {
            URL url = new URL(WEATHER_URL+location+WEATHER_API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);

            conn.setRequestProperty("Accept", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;

            StringBuilder sb = new StringBuilder();

            while ((output = br.readLine()) != null) {

                sb.append(output);
            }
            conn.disconnect();
            ObjectMapper objectMapper = new ObjectMapper();

            WeatherWrapper weatherWrapper = objectMapper.readValue(sb.toString(), WeatherWrapper.class);
            conn.disconnect();
//            for (Integer i = 0; i<weatherWrapper.getData().size();i++) {
//                System.out.println("temp: "+weatherWrapper.getData().get(i).getTemp()+" day "+weatherWrapper.getData().get(i).getDatetime()+" icon "+weatherWrapper.getData().get(i).getWeather().getIcon());
//
//            }
            return weatherWrapper;



        } catch (MalformedURLException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return null;
    }
}