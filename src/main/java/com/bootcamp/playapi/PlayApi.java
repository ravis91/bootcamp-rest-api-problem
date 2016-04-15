package com.bootcamp.playapi;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by raviks on 4/15/16.
 */
public class PlayApi {

    private HttpClient client;

    public PlayApi(HttpClient client) {
        this.client = client;
    }

    public int getDataFromPlayApi(int number) throws IOException
    {

        String url = "http://play-api-1.herokuapp.com/demo/" + number;
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println("result >>>> " + result);

        return Integer.parseInt(result.toString());
    }

}
