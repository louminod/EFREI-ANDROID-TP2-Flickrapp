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

        Button buttonAuth = findViewById(R.id.buttonGetImage);
        ImageView imageView = findViewById(R.id.image);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                buttonAuth.setOnClickListener(new GetImageOnClickListener(imageView));
            }
        });


    }
}