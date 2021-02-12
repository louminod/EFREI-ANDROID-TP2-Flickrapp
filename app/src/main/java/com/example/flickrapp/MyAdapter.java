package com.example.flickrapp;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Vector;

public class MyAdapter extends BaseAdapter {
    private Vector<String> vector;

    public MyAdapter() {
        this.vector = new Vector<>();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.i("JFL", "TODO");
        return null;
    }

    public void add(String url) {
        this.vector.add(url);
    }
}
