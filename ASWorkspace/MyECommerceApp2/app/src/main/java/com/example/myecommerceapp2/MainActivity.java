package com.example.myecommerceapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private CardView topPdtCard, flashDealCard, promoCard, trendingCard;
    private TextView categoriesTxt, extensionTxt, topProductTxt, flashDealsTxt, promoTxt, trendingTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

    }

    private void initWidgets() {
        topPdtCard = findViewById(R.id.topPdtCard);
        flashDealCard = findViewById(R.id.flashDealCard);
        promoCard = findViewById(R.id.promoCard);
        trendingCard = findViewById(R.id.trendingCard);
    }

    private void setOnClickListeners() {

    }
}
