package com.example.flickrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind the layout elements
        Button buttonAuth = findViewById(R.id.buttonGetImage);
        ImageView imageView = findViewById(R.id.image);

        // Used to update the imageView from an other thread
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Define the action to be performed on the button click
                buttonAuth.setOnClickListener(new GetImageOnClickListener(imageView));
            }
        });


    }
}