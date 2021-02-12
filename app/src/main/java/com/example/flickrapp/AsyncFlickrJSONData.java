package com.example.flickrapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Used to get JSON data from an url
 */
public class AsyncFlickrJSONData extends AsyncTask<String, Void, JSONObject> {
    private JSONObject result;

    @Override
    protected JSONObject doInBackground(String... params) {
        URL url = null;
        try {
            // Make the connection and open the stream
            url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            // Perform a request and format the result to be a correct json format
            String httpResult = readStream(in).replace("jsonFlickrFeed","").replaceFirst("\\(","");
            httpResult = httpResult.substring(0, httpResult.length() - 1);

            // Convert the String result to a JSON
            result = new JSONObject(httpResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        //Log.i("onPostExecute", result.toString());
    }

    /**
     * Used to convert an InputStream to a String
     * @param is
     * @return A String
     * @throws IOException
     */
    private String readStream(InputStream is) throws IOException {
        // Create the String
        StringBuilder sb = new StringBuilder();

        // Read and convert each line
        BufferedReader r = new BufferedReader(new InputStreamReader(is), 1000);
        for (String line = r.readLine(); line != null; line = r.readLine()) {
            sb.append(line);
        }

        // Close the buffer and return the String
        is.close();
        return sb.toString();
    }
}
