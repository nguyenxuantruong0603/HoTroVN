package com.example.hotrovn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.hotrovn.R;
import com.example.hotrovn.activity.helper.StrongmanBulletinActivity;
import com.example.hotrovn.activity.needrelief.BulletinOfReliefActivity;
import com.example.hotrovn.utilities.adapter.spinner.AdapterSpinnerCountry;
import com.example.hotrovn.utilities.model.country.Country;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private EditText edtPhoneNumber;
    private TextView tvWhenLogin;
    private TextView tvTermOfService;
    private Button btnNext;
    private Toolbar toolbar;
    private String Chooesd = "";
    public static String PhoneNumber;
    private ArrayList<Country> mCountryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Chooesd = getIntent().getStringExtra("KEY");

        initList();

        initView();

        Spinner spinner = findViewById(R.id.spnCountry);
        AdapterSpinnerCountry adapterSpinnerCountry = new AdapterSpinnerCountry(this, mCountryList);

        spinner.setAdapter(adapterSpinnerCountry);

        Log.e("ABV", mCountryList.size() + "");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Country country = (Country) adapterView.getItemAtPosition(i);
                String Name = country.getName();
                Toast.makeText(LoginActivity.this, Name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initList() {
        mCountryList = new ArrayList<>();
        mCountryList.add(new Country(0, "Việt Nam (+84)", "VN", R.drawable.vietnam));
        mCountryList.add(new Country(1, "India (+91)", "INDIA", R.drawable.india));
        mCountryList.add(new Country(2, "USA (+1)", "USA", R.drawable.usa));
        mCountryList.add(new Country(3, "Portugal (+351) ", "BDN", R.drawable.portugal));
    }

    private void initView() {
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        tvWhenLogin = findViewById(R.id.tvWhenLogin);
        tvTermOfService = findViewById(R.id.tvTermOfService);
        btnNext = findViewById(R.id.btnNext);
        toolbar = findViewById(R.id.toolbarLogin);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (Chooesd.equals("Helper")) {
            tvTermOfService.setVisibility(View.VISIBLE);
            tvWhenLogin.setVisibility(View.VISIBLE);
        } else {
            tvWhenLogin.setVisibility(View.INVISIBLE);
            tvTermOfService.setVisibility(View.INVISIBLE);
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Chooesd.equals("Helper")) {
                    Intent intent = new Intent(LoginActivity.this, StrongmanBulletinActivity.class);
                    startActivity(intent);
                    PhoneNumber = edtPhoneNumber.getText().toString();
                } else {
                    Intent intent = new Intent(LoginActivity.this, BulletinOfReliefActivity.class);
                    startActivity(intent);
                    PhoneNumber = edtPhoneNumber.getText().toString();
                }
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "xin chào các bạn", Toast.LENGTH_SHORT).show();
            }
        });
    }
}