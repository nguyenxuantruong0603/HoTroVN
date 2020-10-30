package com.example.hotrovn.activity.helper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotrovn.R;
import com.example.hotrovn.activity.needrelief.CreateBulletinOfReliefActivity;

public class StrongmanBulletinInformationActivity extends AppCompatActivity {
    private Toolbar ToolbarReliefInformation;
    private LinearLayout linearLayout2;
    private TextView tvLocationBulletinInfo;
    private LinearLayout linearLayout3;
    private TextView tvItemNeedHelpedInfo;
    private LinearLayout linearLayout4;
    private TextView tvTimeInfo;
    private LinearLayout linearLayout5;
    private TextView tvInforUserInfo;
    private RecyclerView rcInformationHelper;
    private Button btnCreateCampaign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strongman_bulletin_information);


        initview();

    }

    private void initview() {

        ToolbarReliefInformation = findViewById(R.id.Toolbar_Relief_Information);
        linearLayout2 = findViewById(R.id.linearLayout2);
        tvLocationBulletinInfo = findViewById(R.id.tvLocation_bulletin_info);
        linearLayout3 = findViewById(R.id.linearLayout3);
        tvItemNeedHelpedInfo = findViewById(R.id.tvItem_Need_Helped_info);
        linearLayout4 = findViewById(R.id.linearLayout4);
        tvTimeInfo = findViewById(R.id.tvTime_info);
        linearLayout5 = findViewById(R.id.linearLayout5);
        tvInforUserInfo = findViewById(R.id.tvInfor_User_info);
        rcInformationHelper = findViewById(R.id.rcInformation_Helper);
        btnCreateCampaign = findViewById(R.id.btnCreateCampaign);

        btnCreateCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(StrongmanBulletinInformationActivity.this,CreateReliefCampaignActivity.class);
                startActivity(intent);
            }
        });

    }
}