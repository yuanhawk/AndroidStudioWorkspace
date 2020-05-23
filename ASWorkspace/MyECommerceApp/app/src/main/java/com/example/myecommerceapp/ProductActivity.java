package com.example.myecommerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private static final String TAG = "ProductActivity";
    private TextView productName, sellerName, description, price;
    private ImageView productImage;

    private Product incomingProduct;
    private Util utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initWidgets();
        Intent intent = getIntent();
        int id = intent.getIntExtra("productId", 0);
        utils = new Util();
        ArrayList<Product> products = utils.getAllProducts();

        for(Product p: products) {
            if(p.getId() == id) {
                incomingProduct = p;
                productName.setText(p.getName());
                sellerName.setText(p.getSeller());
                description.setText(p.getDescription());
                price.setText("Price: " + p.getPrice());
                Glide.with(this)
                        .asBitmap()
                        .load(p.getImageUrl())
                        .into(productImage);
            }
        }
    }

    private void initWidgets() {
        productName = (TextView) findViewById(R.id.productName);
        sellerName = (TextView) findViewById(R.id.sellerName);
        description = (TextView) findViewById(R.id.productDesc);
        price = (TextView) findViewById(R.id.price);

        productImage = (ImageView) findViewById(R.id.productImage);
    }
}
