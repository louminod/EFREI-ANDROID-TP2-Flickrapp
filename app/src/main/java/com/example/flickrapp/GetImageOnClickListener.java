package com.example.flickrapp;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

public class GetImageOnClickListener implements View.OnClickListener {

    private ImageView imageView;

    public GetImageOnClickListener(ImageView imageView) {
        this.imageView = imageView;
    }


    @Override
    public void onClick(View view) {
        try {
            AsyncFlickrJSONData asyncTask = new AsyncFlickrJSONData();
            JSONObject json = asyncTask.execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json").get();
            String imageUrl = json.getJSONArray("items").getJSONObject(1).getJSONObject("media").getString("m");
            AsyncBitmapDownloader asyncBitmapDownloader = new AsyncBitmapDownloader();
            imageView.setImageBitmap(asyncBitmapDownloader.execute(imageUrl).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
