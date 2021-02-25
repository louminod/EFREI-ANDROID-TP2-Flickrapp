package com.example.flickrapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind the layout elements
        Button buttonImage = findViewById(R.id.buttonGetImage);
        Button buttonListActivity = findViewById(R.id.buttonListActivity);
        ImageView imageView = findViewById(R.id.image);

        // Used to update the imageView from an other thread
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Define the action to be performed on the button click
                buttonImage.setOnClickListener(new GetImageOnClickListener(imageView));
            }
        });

        buttonListActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create the new activity for the image list
                Intent listActivity = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(listActivity);
            }
        });

    }
}