package com.example.registrationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.regBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNameEditText = (EditText) findViewById(R.id.firstNameEditText);
                EditText secondNameEditText = (EditText) findViewById(R.id.secondNameEditText);
                EditText emailEditText = (EditText) findViewById(R.id.emailEditText);

                TextView firstNameTextView = (TextView) findViewById(R.id.firstNameTextView);
                TextView secondNameTextView = (TextView) findViewById(R.id.secondNameTextView);
                TextView emailTextView = (TextView) findViewById(R.id.emailTextView);

                firstNameTextView.setText("First Name: " + firstNameEditText.getText().toString());
                secondNameTextView.setText("Second Name: " + secondNameEditText.getText().toString());
                emailTextView.setText("Email: " + emailEditText.getText().toString());
            }
        });
    }
}
