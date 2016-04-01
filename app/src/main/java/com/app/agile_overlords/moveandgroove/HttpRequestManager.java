package com.app.agile_overlords.moveandgroove;


import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Scott Williams on 3/31/2016.
 */
public class HttpRequestManager {
    private final String GET = "GET";

    public String getNutrition(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection httpClient = (HttpURLConnection) url.openConnection();
        httpClient.setRequestMethod(GET);

        InputStream stream = new BufferedInputStream(httpClient.getInputStream());
        String response = IOUtils.toString(stream);

        return response;
    }




}
