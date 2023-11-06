package com.example.slip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.slip.databinding.ActivityPlaceDetailSettingBinding;
import com.example.slip.databinding.ActivityPlacesetBinding;

public class PlaceDetailSettingActivity extends AppCompatActivity {


    private ActivityPlaceDetailSettingBinding binding;
    private TextView PlaceName;
    private EditText Address;
    private EditText DetailAddress;
    private Button Confirm;
    private Button Cancel;

    private Intent resultIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlaceDetailSettingBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_place_detail_setting);
        PlaceName = binding.placeName;
        Address = binding.address;
        DetailAddress = binding.detailAdd;
        Confirm = binding.confirm;
        Cancel = binding.cancel;
        resultIntent = new Intent();
        boolean isPlaceNameOK = false;
        boolean isAddressOK = false;




        Confirm.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}