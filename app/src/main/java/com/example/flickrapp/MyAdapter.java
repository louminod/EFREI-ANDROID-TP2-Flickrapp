package com.example.flickrapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;

import java.util.Vector;

public class MyAdapter extends BaseAdapter {
    private Vector<String> vector;
    private Context context;

    // Constructor
    public MyAdapter(Context context) {
        this.vector = new Vector<>();
        this.context = context;
    }

    @Override
    public int getCount() {
        return vector.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        String url = vector.elementAt(position);

        /*
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.textviewlayout, parent, false);
        }
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(url);*/

        // Get the view from the layouts
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.bitmaplayout, parent, false);
        }

        // Get the imageview
        ImageView imageView = view.findViewById(R.id.imageView3);

        // Create the download queue
        RequestQueue queue = MySingleton.getInstance(this.context).getRequestQueue();
        Response.Listener<Bitmap> repListener = response -> {
            imageView.setImageBitmap(response);
        };
        ImageRequest request = new ImageRequest(url, repListener, view.getWidth(), 400, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565, null);

        queue.add(request);

        return view;
    }

    public void add(String url) {
        this.vector.add(url);
    }
}
