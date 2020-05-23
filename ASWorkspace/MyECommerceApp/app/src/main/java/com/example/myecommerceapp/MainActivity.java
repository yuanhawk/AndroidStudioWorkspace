package com.example.myecommerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProductRecViewAdapter.ItemClickListener {

    private static final String TAG = "SeeAllProductsActivity";
    private RecyclerView productsRecyclerView;
    private ProductRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");

        String[] data = {"1", "2"};

        productsRecyclerView = (RecyclerView) findViewById(R.id.productsRecyclerView);
        //How we want to order our items in our recyclerView
        productsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new ProductRecViewAdapter(this, data);
        adapter.setClickListener(this);
        productsRecyclerView.setAdapter(adapter);
    }

    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
    }
}
