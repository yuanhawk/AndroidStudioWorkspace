package com.example.basicui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public void onClick (View v) {
        switch(v.getId()) {
            case R.id.btnStart:

                break;
        }
    }

    private EditText editText;
    private CheckBox checkBox;
    private Button btnStart;

    private RadioGroup radioGroup;

    private ProgressBar progressBar;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        String text = editText.getText().toString();

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        btnStart = (Button) findViewById(R.id.btnStart);

        progressBar (ProgressBar) findViewById(R.id.progressBar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                progressBar.incrementProgressBy(10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setVisibility(View.GONE);
        });
    }




    public void start(View view) {
        if (checkBox.isChecked()) {
            System.out.println("It is checked");
        }else {
            System.out.println("It's not checked");
        }

        int id = radioGroup.getCheckedRadioButtonId();
        switch(id) {
            case R.id.rbMale:
                editText.setText("Male");
                break;
            case R.id.rbFemale:
                editText.setText("Female");
                break;
            case R.id.rbOthers:
                editText.setText("Others");
                break;
        }
    }

}
