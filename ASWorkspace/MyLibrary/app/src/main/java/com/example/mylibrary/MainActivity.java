package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button seeAllBooksBtn, currentlyReadingBooksBtn, whatToReadBooksBtn, alreadyReadBooksBtn, aboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.in, R.anim.out);
        initWidgets();
        setOnClickListeners();
    }

    private void initWidgets() {
        seeAllBooksBtn = (Button) findViewById(R.id.seeAllBookBtn);
        currentlyReadingBooksBtn = (Button) findViewById(R.id.currentlyReadingBooksBtn);
        whatToReadBooksBtn = (Button) findViewById(R.id.whatToReadBooksBtn);
        alreadyReadBooksBtn = (Button) findViewById(R.id.alreadyReadBooksBtn);
        aboutBtn = (Button) findViewById(R.id.aboutBtn);
    }

    private void setOnClickListeners() {
        seeAllBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Makes connection btw different activities possible from location(obj, inside method of another class) to destination(class)
                //Pass Data within intent, Set Softlax within Intent, listen for results of intent
                Intent intent = new Intent(MainActivity.this, SeeAllBooksActivity.class);
                startActivity(intent);
            }
        });

        currentlyReadingBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        whatToReadBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WantToActivity.class);
                startActivity(intent);
            }
        });

        alreadyReadBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
                startActivity(intent);
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutTapped();
            }
        });
    }

    public void aboutTapped() {
        Log.d(TAG, "aboutTapped: started");

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("About My Library")
                .setMessage("Build and Adapted By Yuanhawk\n"
                + "If you want to hire me or if you want to check my other works \n"
                + "take a look at: test.net")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, MyWebViewActivity.class);
                        intent.putExtra("url","https://www.google.com");
                        startActivity(intent);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}
