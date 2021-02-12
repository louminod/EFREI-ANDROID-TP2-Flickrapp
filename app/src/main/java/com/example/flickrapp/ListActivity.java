package com.example.flickrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MyAdapter myAdapter = new MyAdapter(this);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(myAdapter);

        try {
            AsyncFlickrJSONDataForList asyncTask = new AsyncFlickrJSONDataForList(myAdapter);
            JSONObject json = asyncTask.execute("https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json").get();
        } catch (Exception exception) {

            Log.e("ERROR", exception.getMessage());
        }
    }
}