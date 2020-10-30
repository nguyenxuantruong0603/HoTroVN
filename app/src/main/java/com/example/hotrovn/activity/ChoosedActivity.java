package com.example.hotrovn.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hotrovn.R;

public class ChoosedActivity extends AppCompatActivity {
    private Button btnNeedRelief;
    private Button btnHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosed);


        btnNeedRelief = findViewById(R.id.btnNeedRelief);
        btnHelper = findViewById(R.id.btnHelper);

        btnHelper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoosedActivity.this,LoginActivity.class);
                intent.putExtra("KEY","Helper");
                startActivity(intent);
            }
        });
        btnNeedRelief.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChoosedActivity.this,LoginActivity.class);
                intent.putExtra("KEY","NeedRelief");
                startActivity(intent);
            }
        });

    }
}