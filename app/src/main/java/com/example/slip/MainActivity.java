package com.example.slip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] regionArray = getResources().getStringArray(R.array.select_place_region);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, regionArray);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.drop_down_for_place);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}