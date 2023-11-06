package com.example.slip.mainFunction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.slip.R;
import com.example.slip.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] regionArray = getResources().getStringArray(R.array.select_place_region);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, regionArray);
        final AutoCompleteTextView autoCompleteTextView = binding.dropDownForPlace;
        autoCompleteTextView.setAdapter(arrayAdapter);

        final Button manageContact = binding.contactBtn;
        final Button watchVideo = binding.checkCctvBtn;

        manageContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(intent);
            }
        });

        watchVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmergencyActivity.class);
                intent.putExtra("place", autoCompleteTextView.getText().toString());
                startActivity(intent);
            }
        });
    }
}