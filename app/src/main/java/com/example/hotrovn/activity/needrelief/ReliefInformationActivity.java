package com.example.hotrovn.activity.needrelief;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hotrovn.R;

public class ReliefInformationActivity extends AppCompatActivity {
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
    private LinearLayout linearLayout;
    private ImageView ImgClickCreateBulletinInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relief_information);

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
        linearLayout = findViewById(R.id.linearLayout);
        ImgClickCreateBulletinInfo = findViewById(R.id.ImgClick_CreateBulletin_info);

    }
}