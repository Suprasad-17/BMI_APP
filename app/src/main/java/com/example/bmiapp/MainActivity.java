package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("You Are Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                }else if(bmi<18){
                    txtResult.setText("You Are Underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
                }else{
                    txtResult.setText("You Are Healthy!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }
            }

        });

    }
}