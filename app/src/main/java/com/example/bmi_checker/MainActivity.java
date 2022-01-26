package com.example.bmi_checker;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText Enter_height_Feet, Enter_height_Inch, Enter_Weight;
    TextView Result;
    Button Calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Enter_height_Feet = findViewById(R.id.Enter_Height_Feet);
        Enter_height_Inch = findViewById(R.id.Enter_Height_Inch);
        Enter_Weight = findViewById(R.id.Enter_Weight);
        Calculate = findViewById(R.id.Calculate);
        Result = findViewById(R.id.Result);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hf = Enter_height_Feet.getText().toString();
                String hi = Enter_height_Inch.getText().toString();
                String w = Enter_Weight.getText().toString();

                if (TextUtils.isEmpty(hf) || TextUtils.isEmpty(hi) || TextUtils.isEmpty(w)) {
                    Result.setText("");
                } else {
                    Double height_feet = Double.parseDouble(hf);
                    Double height_inch = Double.parseDouble(hi);
                    Double weight = Double.parseDouble(w);

                    height_inch = (height_inch * 0.8333) / 10;
                    Double height = (height_feet + height_inch);
                    height = (height * 0.3048);
                    Double BMI = (weight / (height * height));

                    if (BMI < 18.5) {
                        Result.setText("BMI is Underweight: " + new DecimalFormat("##.##").format(BMI));
                    }

                    if (BMI >= 18.5 && BMI < 25) {
                        Result.setText("BMI is Normal: " + new DecimalFormat("##.##").format(BMI));
                    }

                    if (BMI >= 25 && BMI < 30) {
                        Result.setText("BMI is Overweight: " + new DecimalFormat("##.##").format(BMI));
                    }

                    if (BMI >= 30 && BMI < 40) {
                        Result.setText("BMI is Obese: " + new DecimalFormat("##.##").format(BMI));
                    }
                    if (BMI > 40) {
                        Result.setText("BMI is Morbidly Obese: " + new DecimalFormat("##.##").format(BMI));
                    }
                }

            }
        });
    }
}