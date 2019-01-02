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

    private static String WEATHER_URL = "https://api.openweathermap.org/data/2.5/forecast?q=";
    private static String WEATHER_API_KEY = "&units=metric&APPID=9d4c25932db02a8f8a6ed63351c7431d";

    public static String[] time;
    public static String[] temp;
    public static String[] wind;

    public static void getData(String location, int daysRange) {
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

            time = new String[50];
            temp = new String[50];
            wind = new String[50];

            JSONObject json = new JSONObject(sb.toString());
            JSONArray json_list = json.getJSONArray("list");
            JSONObject json_id, json_temp, json_wind;

            //dla 3h i<=0, dla 6h i<=1, dla 5dni i<=39 json_list.length()
            for (int i = 0; i <= daysRange; i++) {
                json_id = json_list.getJSONObject(i);
                time[i] = json_id.get("dt_txt").toString();
                json_temp = json_id.getJSONObject("main");
                temp[i] = json_temp.get("temp").toString();
                json_wind = json_id.getJSONObject("wind");
                wind[i] = json_wind.get("speed").toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
