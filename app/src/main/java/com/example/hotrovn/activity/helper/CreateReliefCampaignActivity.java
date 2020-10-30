package com.example.hotrovn.activity.helper;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.hotrovn.R;

import java.util.Calendar;

public class CreateReliefCampaignActivity extends AppCompatActivity {
    private Toolbar toolbarCreateBulletin;
    private EditText edtPeopleCall;
    private EditText edtRole;
    private EditText edtNumberPhone;
    private EditText edt;
    private EditText edtNeedSupport;
    private ImageView rimgItem;
    private Button btnAddImageSituation;
    private Button btnSave;
    private TextView tvDateCreate;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    private DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_relief_campaign);

        initview();
    }

    private void initview() {
        rimgItem = findViewById(R.id.rimgItem);
        toolbarCreateBulletin = findViewById(R.id.toolbar_CreateBulletin);
        edtPeopleCall = findViewById(R.id.edtPeople_Call);
        edtRole = findViewById(R.id.edtRole);
        edtNumberPhone = findViewById(R.id.edtNumberPhone);
        edt = findViewById(R.id.edt);
        edtNeedSupport = findViewById(R.id.edtNeed_support);
        btnAddImageSituation = findViewById(R.id.btnAdd_Image_Situation);
        btnSave = findViewById(R.id.btnSave);
        tvDateCreate = findViewById(R.id.tvDateCreate);
        tvDateCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(CreateReliefCampaignActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tvDateCreate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


        toolbarCreateBulletin.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(CreateReliefCampaignActivity.this, R.style.custom_dialog);
                View aler = LayoutInflater.from(CreateReliefCampaignActivity.this).inflate(R.layout.dialog_successfully, null);
                builder.setView(aler);
                final AlertDialog alertDialog = builder.create();

                Button btnxong;
                TextView tvResult, tvNotifi;
                btnxong = aler.findViewById(R.id.btnXong);
                tvResult = aler.findViewById(R.id.tvResult);
                tvNotifi = aler.findViewById(R.id.tvNoti);
                tvResult.setText("Thông tin sẽ được gửi đến người kêu gọi");
                tvNotifi.setVisibility(View.GONE);

                btnxong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });

        btnAddImageSituation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED) {

                        // khi bạn đéo đồng ý cấp quyền cho nó
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        // khi bạn đã cấp quyền cho nó
                        pickImageFromGallery();
                    }
                } else {
                    pickImageFromGallery();
                }
            }
        });

    }




    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }


    // xử lý kết quả trong thời gian cấp quyền
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    // khi bạn đã cấp quyền cho nó
                    pickImageFromGallery();
                } else {
                    // còn đây là khi bạn không cấp quyền cho nó
                    Toast.makeText(this, "Bạn đéo cấp quyền cho chúng tôi", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            //set image to IMAGEVIEW
            rimgItem.setImageURI(data.getData());
        }
    }
}