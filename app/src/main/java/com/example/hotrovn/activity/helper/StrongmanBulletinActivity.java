package com.example.hotrovn.activity.helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotrovn.R;
import com.example.hotrovn.activity.MapActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.makeramen.roundedimageview.RoundedImageView;

public class StrongmanBulletinActivity extends AppCompatActivity {
    private RoundedImageView imgNotifi;
    private RecyclerView rcBulletinNeedRelief;
    private FloatingActionButton fabSearch;
    private LinearLayout linearLayout;
    private BottomSheetDialog bottomSheetDialog;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strongman_bulletin);
        initview();

    }

    private void initview() {

        imgNotifi = findViewById(R.id.imgNotifi);
        rcBulletinNeedRelief = findViewById(R.id.rcBulletin_NeedRelief);
        fabSearch = findViewById(R.id.fabSearch);
        linearLayout = findViewById(R.id.linearLayout);



        imgNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StrongmanBulletinActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            View bottomSheetView= LayoutInflater.from(StrongmanBulletinActivity.this).inflate(R.layout.dialog_search,null);
                bottomSheetDialog = new BottomSheetDialog(StrongmanBulletinActivity.this);
                bottomSheetDialog.setContentView(bottomSheetView);
                 RoundedImageView imgClose;
                 Spinner spnSelectProvince;
                 Spinner spnSelectCity;
                 Spinner spnSelectTown;
                 Button btnFilter;
                imgClose = bottomSheetView.findViewById(R.id.imgClose);
                spnSelectProvince = bottomSheetView.findViewById(R.id.spnSelectProvince);
                spnSelectCity = bottomSheetView.findViewById(R.id.spnSelectCity);
                spnSelectTown = bottomSheetView.findViewById(R.id.spnSelectTown);
                btnFilter=bottomSheetView.findViewById(R.id.btnFilter);

                btnFilter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(StrongmanBulletinActivity.this, "Filter", Toast.LENGTH_SHORT).show();
                    }
                });

                imgClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(StrongmanBulletinActivity.this, "Close", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.show();
            }
        });

    }

    public void ShowInfor(View view) {
        Intent intent=new Intent(StrongmanBulletinActivity.this,StrongmanBulletinActivity.class);
        startActivity(intent);
    }

    public void ShowMap(View view) {
        Intent intent=new Intent(StrongmanBulletinActivity.this, MapActivity.class);
        startActivity(intent);
    }
}