package com.example.flickrapp;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

public class GetImageOnClickListener implements View.OnClickListener {

    // The ImageView from the main layout
    private ImageView imageView;

    /**
     * The constructeur with the ImageView
     * @param imageView
     */
    public GetImageOnClickListener(ImageView imageView) {
        this.imageView = imageView;
    }


    @Override
    public void onClick(View view) {
        try {
            // Fetch flickr to get an image
            AsyncFlickrJSONData asyncTask = new AsyncFlickrJSONData();
            //JSONObject json = asyncTask.execute("https://api.flickr.com/services/rest/?method=flickr.photos.search&license=4&has_geo=1&lat=48.856613&lon=2.352222&per_page=1&format=json").get();
            JSONObject json = asyncTask.execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json").get();

            // Convert the image from the json to a String
            String imageUrl = json.getJSONArray("items").getJSONObject(1).getJSONObject("media").getString("m");

            // Download the image and show it
            AsyncBitmapDownloader asyncBitmapDownloader = new AsyncBitmapDownloader();
            imageView.setImageBitmap(asyncBitmapDownloader.execute(imageUrl).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
