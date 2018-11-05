package com.example.user.lovecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText mMale, mFemale;
    private Button mClct;
    private TextView mShow;
    private String mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);
        mClct = findViewById(R.id.calculate);

        mShow = findViewById(R.id.result);

        mClct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });

    }

    public void showResult(){
        String male = mMale.getText().toString();
        String female = mFemale.getText().toString();
        String sum = male+female;
        sum = sum.toLowerCase();
        int value = sum.hashCode();

        Random random = new Random(value);

        mResult = (random.nextInt(100)+1) + "%";

        if(male.equals("")||female.equals("")){


            Toast.makeText(this, "Please fill empty name field", Toast.LENGTH_SHORT).show();
            mShow.setText("0");
        }else {
            mShow.setText(mResult + "%");
        }
    }
}
