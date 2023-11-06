package com.example.slip;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlaceSetActivity extends AppCompatActivity {
    int num = 1;

ActivityResultLauncher<Intent> startPlaceDetailSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeset);
        ImageButton addButton = findViewById(R.id.Place_Plus);
        final LinearLayout linearLayout = findViewById(R.id.linearLayout);

        startPlaceDetailSetting = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result ->{
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                    }


                });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 항목을 생성
                /*
                TextView newItem = new TextView(getApplicationContext());
                newItem.setText("새로운 항목" + num); // 내용을 원하는 텍스트로 설정
                newItem.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16); // 텍스트 크기 설정
                // 생성된 항목을 LinearLayout에 추가
                linearLayout.addView(newItem);
                num++;*/
                Intent PlaceDetailSettingActivity = new Intent(PlaceSetActivity.this, PlaceDetailSettingActivity.class);
                startPlaceDetailSetting.launch(PlaceDetailSettingActivity);
            }

        });

    }
}