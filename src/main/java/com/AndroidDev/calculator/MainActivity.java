package com.AndroidDev.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        Button addBtn = (Button) findViewById(R.id.addBtn);
        Button minusBtn = (Button) findViewById(R.id.minusBtn);
        Button timesBtn = (Button) findViewById(R.id.timesBtn);
        Button divideBtn = (Button) findViewById(R.id.divideBtn);
        Button clearBtn = (Button) findViewById(R.id.clearBtn);
        TextView answer = (TextView) findViewById(R.id.answer);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = ReturnValue(num1) + ReturnValue(num2);
                answer.setText(Integer.toString(sum));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int prod = ReturnValue(num1) - ReturnValue(num2);
                answer.setText(Integer.toString(prod));
            }
        });
        timesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int prod = ReturnValue(num1) * ReturnValue(num2);
                answer.setText(Integer.toString(prod));
            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double quo = ReturnValue(num1) / ReturnValue(num2);
                answer.setText(Double.toString(quo));

                if (quo == 0 || quo != 0) {
                    answer.setText("You entered " + ReturnValue(num1) + " / " + ReturnValue(num2) + ". " + "Try again!");
                } else {
                    return;
                }
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1.setText("");
                num2.setText("");
                answer.setText("");
            }
        });
    }

    int ReturnValue ( EditText et){
        String etStr = et.getText().toString();
        if (!etStr.isEmpty()){
            return Integer.parseInt(etStr);
        } else {
            return 0;
        }
    }
}