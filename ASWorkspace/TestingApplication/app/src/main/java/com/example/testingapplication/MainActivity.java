package com.example.testingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference the controls, create obj, search by id
        Button addBtn = (Button) findViewById(R.id.addbutton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView totalValue = (TextView) findViewById(R.id.totalValue);

                double a = 0;
                double b = 0;

                String error = "";
                try {
                    a = Double.parseDouble(firstNumEditText.getText().toString());
                } catch (IllegalArgumentException e) {
                    totalValue.setText(error);
                }
                try {
                    b = Double.parseDouble(secondNumEditText.getText().toString());
                } catch (IllegalArgumentException e) {
                    totalValue.setText(error);
                }

                double total = a + b;
                totalValue.setText(total + "");
            }
        });

        //Reference the controls, create obj, search by id
        Button subtractBtn = (Button) findViewById(R.id.subtractBtn);
        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView totalValue = (TextView) findViewById(R.id.totalValue);

                double a = 0;
                double b = 0;

                String error = "";
                try {
                    a = Double.parseDouble(firstNumEditText.getText().toString());
                } catch (IllegalArgumentException e) {
                    totalValue.setText(error);
                }
                try {
                    b = Double.parseDouble(secondNumEditText.getText().toString());
                } catch (IllegalArgumentException e) {
                    totalValue.setText(error);
                }

                double total = a - b;
                totalValue.setText(total + "");
            }
        });

        //Reference the controls, create obj, search by id
        Button multiplyBtn = (Button) findViewById(R.id.multiplyBtn);
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView totalValue = (TextView) findViewById(R.id.totalValue);

                double a = 0;
                double b = 0;

                String error = "";
                try {
                    a = Double.parseDouble(firstNumEditText.getText().toString());
                } catch (IllegalArgumentException e) {
                    totalValue.setText(error);
                }
                try {
                    b = Double.parseDouble(secondNumEditText.getText().toString());
                } catch (IllegalArgumentException e) {
                    totalValue.setText(error);
                }

                double total = a * b;
                totalValue.setText(total + "");
            }
        });

        Button divideBtn = (Button) findViewById(R.id.divideBtn);
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView totalValue = (TextView) findViewById(R.id.totalValue);

                double a = 0;
                double b = 0;

                String error = "";
                try {
                    a = Double.parseDouble(firstNumEditText.getText().toString());
                } catch (IllegalArgumentException e) {
                    totalValue.setText(error);
                }
                try {
                    b = Double.parseDouble(secondNumEditText.getText().toString());
                } catch (IllegalArgumentException e) {
                    totalValue.setText(error);
                }

                double total = a / b;
                totalValue.setText(total + "");
            }
        });

    }
}
