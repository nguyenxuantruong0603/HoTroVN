package com.example.hotrovn.activity.needrelief;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotrovn.R;
import com.example.hotrovn.activity.LoginActivity;
import com.makeramen.roundedimageview.RoundedImageView;

public class BulletinOfReliefActivity extends AppCompatActivity {
    private Toolbar ToolbarNeededRelief;
    private RecyclerView rcBulletinNeedRelief;
    private LinearLayout linearLayout;
    private ImageView ImgClickCreateBulletin;
    private RoundedImageView imgNotifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletin_of_relief);

        InitView();

    }

    private void InitView() {

        ToolbarNeededRelief = findViewById(R.id.Toolbar_Needed_Relief);
        rcBulletinNeedRelief = findViewById(R.id.rcBulletin_NeedRelief);
        linearLayout = findViewById(R.id.linearLayout);
        ImgClickCreateBulletin = findViewById(R.id.ImgClick_CreateBulletin);
        imgNotifi = findViewById(R.id.imgNotifi);

        imgNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Toast.makeText(BulletinOfReliefActivity.this, "NOTIFICATION", Toast.LENGTH_SHORT).show();

            }
        });
        ImgClickCreateBulletin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BulletinOfReliefActivity.this, CreateBulletinOfReliefActivity.class);
                startActivity(intent);
                Toast.makeText(BulletinOfReliefActivity.this, LoginActivity.PhoneNumber + "", Toast.LENGTH_SHORT).show();
            }
        });

    }
}