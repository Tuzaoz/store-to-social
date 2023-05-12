package org.example.service;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CuttlyShortlink {
    private static final String apiKey = "4339cf71cc46d30698c682fc83ff1059862c8";

    public static String gerarLink(String longurl) throws IOException {
        String novoUrl = null;

        String shortLink = null;
        try {

            URL url = new URL("https://cutt.ly/api/api.php?key=" + apiKey + "&short=" + longurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {
                novoUrl = output;
                System.out.println(output);
            }
            JSONObject jsonObject = new JSONObject(novoUrl);
            shortLink = jsonObject.getJSONObject("url").getString("shortLink");


            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return shortLink;

    }


    }




