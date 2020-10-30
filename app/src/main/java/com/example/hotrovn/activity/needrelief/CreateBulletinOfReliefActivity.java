package com.example.hotrovn.activity.needrelief;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.hotrovn.R;
import com.example.hotrovn.activity.MapActivity;
import com.example.hotrovn.utilities.ReadJsonFile;
import com.example.hotrovn.utilities.adapter.spinner.AdapterSpinnerProvince;
import com.example.hotrovn.utilities.model.country.Country;
import com.example.hotrovn.utilities.model.country.District;
import com.example.hotrovn.utilities.model.country.Province;
import com.example.hotrovn.utilities.model.country.Village;

import java.util.ArrayList;
import java.util.List;

public class CreateBulletinOfReliefActivity extends AppCompatActivity {
    private Toolbar toolbarCreateBulletin;
    private Spinner spnSelectProvince, spnSelectTown, spnSelectCity;
    private TextView tvLocation;
    private EditText edtPeopleCall, edtRole, edtNumberPhone, edtDescribeSituation, edtNeedSupport;
    private Button btnAddImageSituation, btnSave;
    private ReadJsonFile readJsonFile;
    List<Province> provinceList;
    List<Country> countryList;
    ArrayList<District> districtList;
    ArrayList<Village> villageList;
    Country country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bulletin_of_relief_activity);

        initview();
        setupSpinner();

    }

    private void setupSpinner() {
        countryList = readJsonFile.parseFileLocation();

        provinceList = country.getProvince();

        Log.e("SIZE", countryList.size()+ provinceList.size() +"");

        AdapterSpinnerProvince adapterSpinnerCountry = new AdapterSpinnerProvince(this, provinceList);

        spnSelectProvince.setAdapter(adapterSpinnerCountry);
    }

    private void initview() {
        toolbarCreateBulletin = findViewById(R.id.toolbar_CreateBulletin);
        spnSelectProvince = findViewById(R.id.spnSelectProvince);
        spnSelectCity = findViewById(R.id.spnSelectCity);
        spnSelectTown = findViewById(R.id.spnSelectTown);
        tvLocation = findViewById(R.id.tvLocation);
        edtPeopleCall = findViewById(R.id.edtPeople_Call);
        edtRole = findViewById(R.id.edtRole);
        edtNumberPhone = findViewById(R.id.edtNumberPhone);
        edtDescribeSituation = findViewById(R.id.edtDescribe_Situation);
        edtNeedSupport = findViewById(R.id.edtNeed_support);
        btnAddImageSituation = findViewById(R.id.btnAdd_Image_Situation);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(CreateBulletinOfReliefActivity.this, R.style.custom_dialog);
                View aler = LayoutInflater.from(CreateBulletinOfReliefActivity.this).inflate(R.layout.dialog_successfully, null);
                builder.setView(aler);
                final AlertDialog alertDialog = builder.create();

                Button btnxong;

                btnxong = aler.findViewById(R.id.btnXong);

                btnxong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                        Toast.makeText(CreateBulletinOfReliefActivity.this, "thành công", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.show();
            }
        });

        toolbarCreateBulletin.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tvLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateBulletinOfReliefActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }
}