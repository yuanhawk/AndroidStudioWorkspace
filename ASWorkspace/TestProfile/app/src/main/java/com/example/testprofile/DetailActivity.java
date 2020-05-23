package com.example.testprofile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.testprofile.ITEM_INDEX", -1);

        if (index > -1) {
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }

    private int getImg(int index) {
        switch(index) {
            case 0: return R.drawable.profile_pic;
            case 1: return R.drawable.sutd;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {

        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }
}
