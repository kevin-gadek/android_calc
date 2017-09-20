package com.example.kevin.lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnClear, btnAdd, btnSubtract, btnMultiply, btnDivide, btn0, btn1, btn2, btn3, btn4,
                   btn5, btn6, btn7, btn8, btn9;
    private EditText editTextNumDisplay;
    private double num1, num2, result;
    private int opcode;
    private boolean opLast = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        //operator/function buttons defined
        btnClear = (Button) findViewById(R.id.btnClear);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);

        //operands defined
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        //display screen
        editTextNumDisplay = (EditText) findViewById(R.id.editTextNumDisplay);

        btnClear.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

    }
//max of 7 numbers on display
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btnClear:
                editTextNumDisplay.setText("");
                num1 = 0;
                num2 = 0;
                opLast = true;
                break;
            case R.id.btnAdd:
                num1 = Double.parseDouble(editTextNumDisplay.getText().toString());
                opcode = 1; //add
                opLast = true;
                break;
            case R.id.btnSubtract:
                num1 = Double.parseDouble(editTextNumDisplay.getText().toString());
                opcode = 2; //subtract
                opLast = true;
                break;
            case R.id.btnMultiply:
                num1 = Double.parseDouble(editTextNumDisplay.getText().toString());
                opcode = 3; //multiply
                opLast = true;
                break;
            case R.id.btnDivide:
                num1 = Double.parseDouble(editTextNumDisplay.getText().toString());
                opcode = 4; //divide
                opLast = true;
                break;
            //need to get rid of excess zeros
            case R.id.btn0:
                editTextNumDisplay.setText(editTextNumDisplay.getText() + "0");
                break;
            case R.id.btn1:
                editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + "1");
                break;
            case R.id.btn2:
                editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + "2");
                break;
            case R.id.btn3:
                editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + "3");
                break;
            case R.id.btn4:
                editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + "4");
                break;
            case R.id.btn5:
                editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + "5");
                break;
            case R.id.btn6:
                editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + "6");
                break;
            case R.id.btn7:
                editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + "7");
                break;
            case R.id.btn8:
                editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + "8");
                break;
            case R.id.btn9:
                editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + "9");
                break;
        }

    }
}
