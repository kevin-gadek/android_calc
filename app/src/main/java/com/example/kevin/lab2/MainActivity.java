package com.example.kevin.lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnClear, btnAdd, btnSubtract, btnMultiply, btnDivide, btn0, btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8, btn9, btnEquals;
    private EditText editTextNumDisplay;
    private int result, opcode;
    private double divResult;
    private boolean opLast = false;
    private boolean errFlag = false;
    private boolean firstZeroFlag = false;
    private boolean negFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //operator/function buttons defined
        btnClear = (Button) findViewById(R.id.btnClear);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEquals = (Button) findViewById(R.id.btnEquals);

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
        btnEquals.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClear:
                clear();
                break;
            case R.id.btnAdd:
                if(errFlag){
                    editTextNumDisplay.setText("Press CLR");
                    return;
                }else if(opLast){
                    opcode = 1;
                    return;
                }
                calc();
                opcode = 1;
                opLast = true;
                break;
            case R.id.btnSubtract:
                //negative integer
                if (editTextNumDisplay.getText().toString().length() == 0 || firstZeroFlag == true) {
                    editTextNumDisplay.setText("-");
                    negFlag = true;
                    opLast = false;
                    firstZeroFlag = false;
                    errFlag = false;
                    return;
                }else if(opLast){
                    opcode = 2;
                    return;
                }
                calc();
                opcode = 2;
                opLast = true;
                break;
            case R.id.btnMultiply:
                if(errFlag){
                    editTextNumDisplay.setText("Press CLR");
                    return;
                }else if(opLast){
                    opcode = 3;
                    return;
                }
                calc();
                opcode = 3;
                opLast = true;
                break;
            case R.id.btnDivide:
                if(errFlag){
                    editTextNumDisplay.setText("Press CLR");
                    return;
                }else if(opLast){
                    opcode = 4;
                    return;
                }
                calc();
                opcode = 4;
                opLast = true;
                break;
            case R.id.btnEquals:
                if (opcode == 1) {
                    result += Integer.parseInt(editTextNumDisplay.getText().toString());
                    editTextNumDisplay.setText(Integer.toString(result));
                    opLast = true;
                    opcode = 0;
                } else if (opcode == 2) {
                    result -= Integer.parseInt(editTextNumDisplay.getText().toString());
                    editTextNumDisplay.setText(Integer.toString(result));
                    opLast = true;
                    opcode = 0;
                } else if (opcode == 3) {
                    result *= Integer.parseInt(editTextNumDisplay.getText().toString());
                    editTextNumDisplay.setText(Integer.toString(result));
                    opLast = true;
                    opcode = 0;
                } else if (opcode == 4) {
                    if(Integer.parseInt(editTextNumDisplay.getText().toString()) == 0){
                        editTextNumDisplay.setText("Error");
                        errFlag = true;
                        return;
                    }
                    //should round up
                    result = (int) Math.ceil((double)result / Double.parseDouble(editTextNumDisplay.getText().toString()));
                    editTextNumDisplay.setText(Integer.toString(result));
                    opLast = true;
                    opcode = 0;
                }
                break;

            //no leading zeros
            case R.id.btn0:
                if (editTextNumDisplay.getText().toString().length() == 7) {
                    editTextNumDisplay.setText("Error: More than 7 chars");
                    errFlag = true;
                } else {
                    //if length of num on display is 0, meaning initial startup or an operator has just been pressed
                    if (editTextNumDisplay.getText().length() == 0 || opLast) {
                        editTextNumDisplay.setText("0");
                        firstZeroFlag = true;
                        opLast = false;
                    } else if (editTextNumDisplay.getText().length() > 0 && Integer.parseInt(editTextNumDisplay.getText().toString()) != 0 && opLast == false) {
                        editTextNumDisplay.setText(editTextNumDisplay.getText() + "0");
                        firstZeroFlag = false;
                    }

                }
                break;
            case R.id.btn1:
                operandPress(1);
                break;
            case R.id.btn2:
                operandPress(2);
                break;
            case R.id.btn3:
                operandPress(3);
                break;
            case R.id.btn4:
                operandPress(4);
                break;
            case R.id.btn5:
                operandPress(5);
                break;
            case R.id.btn6:
                operandPress(6);
                break;
            case R.id.btn7:
                operandPress(7);
                break;
            case R.id.btn8:
                operandPress(8);
                break;
            case R.id.btn9:
                operandPress(9);
                break;
        }
    }

    public void clear() {
        editTextNumDisplay.setText("");
        result = 0;
        divResult = 0;
        opLast = true;
        errFlag = false;
    }

    public void operandPress(int operand) {
        if (errFlag) {
            clear();
            editTextNumDisplay.setText(Integer.toString(operand));
            opLast = false;
        } else if (editTextNumDisplay.getText().toString().length() == 7) {
            editTextNumDisplay.setText("Error: More than 7 chars");
            errFlag = true;
        } else if (opLast) {
            editTextNumDisplay.setText(Integer.toString(operand));
            opLast = false;
        } else if (firstZeroFlag) {
            editTextNumDisplay.setText(Integer.toString(operand));
            firstZeroFlag = false;
            opLast = false;
        } else {
            editTextNumDisplay.setText(editTextNumDisplay.getText().toString() + Integer.toString(operand));
        }
        negFlag = false;
    }


    public void calc() {
        //if this is first operation in sequence
        if (result == 0 && negFlag == false) {
            result = Integer.parseInt(editTextNumDisplay.getText().toString());
        } else if (negFlag) { //need to delete that negative sign then
            editTextNumDisplay.setText("");
            negFlag = false;
        }else { //support for multiple operator sequences like 1 + 2 + 3 + 4
            //prev operator was add
            if (opcode == 1) {
                result += Integer.parseInt(editTextNumDisplay.getText().toString());
                //overflow check
                if (Integer.toString(result).length() > 7) {
                    editTextNumDisplay.setText("Err: Overflow");
                    errFlag = true;
                } else {
                    editTextNumDisplay.setText(Integer.toString(result));
                }
                editTextNumDisplay.setText(Integer.toString(result));
            } else if (opcode == 2) { // subtract
                result -= Integer.parseInt(editTextNumDisplay.getText().toString());
                //check if overflow
                if (Integer.toString(result).length() > 7) {
                    editTextNumDisplay.setText("Err: Overflow");
                    errFlag = true;
                } else {
                    editTextNumDisplay.setText(Integer.toString(result));
                }

            } else if (opcode == 3) { //multiply
                result *= Integer.parseInt(editTextNumDisplay.getText().toString());
                if (Integer.toString(result).length() > 7) {
                    editTextNumDisplay.setText("Err: Overflow");
                    errFlag = true;
                } else {
                    editTextNumDisplay.setText(Integer.toString(result));
                }
            } else if (opcode == 4) { //divide
                //should round up
                result = (int) Math.ceil((double)result / Double.parseDouble(editTextNumDisplay.getText().toString()));
                editTextNumDisplay.setText(Integer.toString(result));
            }
        }
    }
}