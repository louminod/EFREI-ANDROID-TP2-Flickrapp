package com.example.flickrapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Vector;

public class MyAdapter extends BaseAdapter {
    private Vector<String> vector;
    private Context context;

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

        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.textviewlayout, parent, false);
        }
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(url);
        return view;
    }

    public void add(String url) {
        this.vector.add(url);
    }
}
