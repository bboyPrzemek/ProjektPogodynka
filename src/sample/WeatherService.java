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

    private static String WEATHER_URL = "https://api.weatherbit.io/v2.0/forecast/daily?city=";
    private static String WEATHER_API_KEY = "&key=e68ec873619a4394bc1efdc85f4a2839";

    //	e68ec873619a4394bc1efdc85f4a2839
    //private static String WEATHER_CITY = "Świdwin";

    public static void getData(String location) {
        try {
            URL url = new URL(WEATHER_URL+location+WEATHER_API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);

            conn.setRequestProperty("Accept", "application/json");
            //System.out.println(conn.getResponseCode() + conn.getResponseMessage());
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
            for (Integer i = 0; i<weatherWrapper.getData().size();i++) {
                System.out.println(weatherWrapper.getData().get(0).getTs());
            }


//            JSONObject json = new JSONObject(sb.toString());
//            JSONArray json_list = json.getJSONArray("list");
//            JSONObject json_id, json_temp, json_wind;
//            List<String> temp = new ArrayList<>();
//            List<String> dt_txt = new ArrayList<>();
//            List<String> wind = new ArrayList<>();
//
//            //dla 3h i<=0, dla 6h i<=1, dla 5dni i<=39 json_list.length()
//            for (int i = 0; i <= daysRange; i++) {
//                json_id = json_list.getJSONObject(i);
//                dt_txt.add(json_id.get("dt_txt").toString());
//                json_temp = json_id.getJSONObject("main");
//                temp.add(json_temp.get("temp").toString());
//                json_wind = json_id.getJSONObject("wind");
//                wind.add(json_wind.get("speed").toString());
//
//                System.out.println(json_id.getJSONObject("weather").getJSONArray("icon"));
//            }
//
//            System.out.println(temp);
//            System.out.println(dt_txt);
//            System.out.println(wind);
//            System.out.println(location);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
