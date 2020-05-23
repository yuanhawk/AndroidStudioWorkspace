package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView backArrow, settings, recorder, cart, timer;
    private EditText nameEditText, emailEditText, descriptionEditText, websiteEditText;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private Button finishBtn;

    private String country = "";
    private ArrayList<String> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        countries = new ArrayList<>();
        countries.add("United States of America");
        countries.add("United Kingdom");
        countries.add("Switzerland");
        countries.add("Germany");
        countries.add("Austria");
        countries.add("France");

        //Initiate ArrayAdapter: context(this, layout, arraylist)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                countries);
        spinner.setAdapter(adapter);

        initOnClickListeners();

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishRegistering();
            }
        });
    }

    //Initiate all widgets
    private void initWidgets(){
        backArrow = (ImageView) findViewById(R.id.backArrow);
        settings = (ImageView) findViewById(R.id.settings);
        recorder = (ImageView) findViewById(R.id.voiceRecorder);
        cart = (ImageView) findViewById(R.id.cart);
        timer = (ImageView) findViewById(R.id.timer);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);
        websiteEditText = (EditText) findViewById(R.id.websiteEditText);

        spinner = (Spinner) findViewById(R.id.countrySpinner);
        radioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        finishBtn = (Button) findViewById(R.id.finishBtn);
    }

    private void finishRegistering() {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        String website = websiteEditText.getText().toString();

        String gender = "";
        int checkedRb = radioGroup.getCheckedRadioButtonId();
        switch (checkedRb) {
            case R.id.rbMale:
                gender = "Male";
                break;
            case R.id.rbFemale:
                gender = "Female";
                break;
            case R.id.rbOther:
                gender = "Other";
                break;
        }

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                country = countries.get(position);
            }

            public void onNothingSelected(AdapterView<?> parent) {
                country = "No Country Selected";
            }
        });
        String finalMessage = "Name: " + name + "\nEmail: " + email + "\nDescription: " + description + "\nWebsite" + website;
        Toast.makeText(MainActivity.this, finalMessage, Toast.LENGTH_SHORT).show();
    }

    private void initOnClickListeners() {
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast msg(obj of MainActivity, text,
                Toast.makeText(MainActivity.this, "Back Arrow tapped", Toast.LENGTH_SHORT).show();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Settings tapped", Toast.LENGTH_SHORT).show();
            }
        });

        recorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Voice Recorder Tapped", Toast.LENGTH_SHORT).show();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Shopping Cart Tapped", Toast.LENGTH_SHORT).show();
            }
        });

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Timer Tapped", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
