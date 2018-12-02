package sample;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GeolocationService {
    private static String LOCATION_URL = "http://api.ipstack.com/check?access_key=";
    private static String LOCATION_API_KEY = "f6615b8da04b3c16a49a895974104e67";

        public static String getLocation() {
            try {
                URL url = new URL(LOCATION_URL+LOCATION_API_KEY);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    conn.setRequestProperty("Accept", "application/json");
                    //System.out.println(conn.getResponseCode() + conn.getResponseMessage());
                    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    String output;
                    //System.out.println("Output from Server .... \n");
                    StringBuilder sb = new StringBuilder();
                    while ((output = br.readLine()) != null) {
                        System.out.println(output);
                        sb.append(output);
                    }
                    JSONObject json = new JSONObject(sb.toString());
                    //System.out.println(json.getString("city"));
                    conn.disconnect();
                    return json.getString("city");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }