package com.example.slip.mainFunction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.slip.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] regionArray = getResources().getStringArray(R.array.select_place_region);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, regionArray);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.drop_down_for_place);
        autoCompleteTextView.setAdapter(arrayAdapter);

        Button manageContact = findViewById(R.id.contact_btn);
        manageContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(intent);
            }
        });
    }
}