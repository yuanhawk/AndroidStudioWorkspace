package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView calculatorScreen;
    private Button n9, n8, n7, n6, n5, n4, n3, n2, n1, n0, dotBtn, equalBtn, addBtn, subBtn, mulBtn, divBtn, delBtn, clearBtn;
    private boolean isOnPressed = false;
    private float firstNumber = 0;
    private int secondNumberIndex = 0;
    private char currentOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorScreen = findViewById(R.id.calculatorScreen);

        n9 = findViewById(R.id.n9);
        n8 = findViewById(R.id.n8);
        n7 = findViewById(R.id.n7);
        n6 = findViewById(R.id.n6);
        n5 = findViewById(R.id.n5);
        n4 = findViewById(R.id.n4);
        n3 = findViewById(R.id.n3);
        n2 = findViewById(R.id.n2);
        n1 = findViewById(R.id.n1);
        n0 = findViewById(R.id.n0);

        dotBtn = findViewById(R.id.dotBtn);
        equalBtn = findViewById(R.id.equalBtn);
        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);

        View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();

                switch(id) {
                    case R.id.n0:
                        //setText will be overridden if you press another button
                        calculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");
                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");
                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");
                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");
                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");
                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");
                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");
                        break;
                    case R.id.dotBtn:
                        calculatorScreen.append(".");
                        break;
                    case R.id.equalBtn:
                        if (isOnPressed) {
                            String screenContent = "";
                            String secondNumberString;
                            float secondNumber;
                            if(currentOp == '+') {
                                screenContent = calculatorScreen.getText().toString();
                                secondNumberString = screenContent
                                        .substring(secondNumberIndex, screenContent.length());
                                secondNumber = Float.parseFloat(secondNumberString);
                                firstNumber += secondNumber;
                                calculatorScreen.setText(String.valueOf(firstNumber));
                            } else if(currentOp == '-') {
                                screenContent = calculatorScreen.getText().toString();
                                secondNumberString = screenContent
                                        .substring(secondNumberIndex, screenContent.length());
                                secondNumber = Float.parseFloat(secondNumberString);
                                firstNumber -= secondNumber;
                                calculatorScreen.setText(String.valueOf(firstNumber));
                            } else if(currentOp == '*') {
                                screenContent = calculatorScreen.getText().toString();
                                secondNumberString = screenContent
                                        .substring(secondNumberIndex, screenContent.length());
                                secondNumber = Float.parseFloat(secondNumberString);
                                firstNumber *= secondNumber;
                                calculatorScreen.setText(String.valueOf(firstNumber));
                            } else if(currentOp == '/') {
                                screenContent = calculatorScreen.getText().toString();
                                secondNumberString = screenContent
                                        .substring(secondNumberIndex, screenContent.length());
                                secondNumber = Float.parseFloat(secondNumberString);
                                firstNumber /= secondNumber;
                                calculatorScreen.setText(String.valueOf(firstNumber));
                            }
                        }

                        break;
                    case R.id.addBtn:
                        String screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        //Conversion of (double) firstNum to string
                        firstNumber = Float.parseFloat(screenContent);
                        calculatorScreen.append("+");
                        isOnPressed = true;
                        currentOp = '+';
                        break;
                    case R.id.subBtn:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        //Conversion of (double) firstNum to string
                        firstNumber = Float.parseFloat(screenContent);
                        calculatorScreen.append("-");
                        isOnPressed = true;
                        currentOp = '-';
                        break;
                    case R.id.mulBtn:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        //Conversion of (double) firstNum to string
                        firstNumber = Float.parseFloat(screenContent);
                        calculatorScreen.append("×");
                        isOnPressed = true;
                        currentOp = '*';
                        break;
                    case R.id.divBtn:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        //Conversion of (double) firstNum to string
                        firstNumber = Float.parseFloat(screenContent);
                        calculatorScreen.append("÷");
                        isOnPressed = true;
                        currentOp = '/';
                        break;
                }
            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        dotBtn.setOnClickListener(calculatorListener);
        equalBtn.setOnClickListener(calculatorListener);
        addBtn.setOnClickListener(calculatorListener);
        subBtn.setOnClickListener(calculatorListener);
        mulBtn.setOnClickListener(calculatorListener);
        divBtn.setOnClickListener(calculatorListener);

        delBtn = (Button) findViewById(R.id.delBtn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayedElements = calculatorScreen.getText().toString();
                int length = displayedElements.length();
                //remove if only there are no.
                if(length > 0) {
                    //substring to cut
                    displayedElements = displayedElements.substring(0,length - 1);
                    calculatorScreen.setText(displayedElements);
                }
            }
        });

        clearBtn = (Button) findViewById(R.id.clBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorScreen.setText("");
            }
        });
    }
}
