package com.example.flickrapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Used to get a bitmap from an url
 */
public class AsyncBitmapDownloader extends AsyncTask<String, Void, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bm = null;
        try {
            // Make the connection and open the stream
            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            // Get the bitmap image
            bm = BitmapFactory.decodeStream(in);

            // Close the connections
            in.close();
            urlConnection.disconnect();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return bm;
    }
}
