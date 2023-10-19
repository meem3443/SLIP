package com.example.slip.mainFunction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.slip.R;

public class InputContactInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_contact_info);

        TextView inputName = findViewById(R.id.editTextName);
        TextView inputPhone = findViewById(R.id.editTextPhone);
        Button cancelBtn = findViewById(R.id.cancel_btn);
        Button saveBtn = findViewById(R.id.save_btn);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        inputName.setText(bundle.get("name").toString());
        inputPhone.setText(bundle.get("phone").toString());

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK);
                finish();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", inputName.getText());
                intent.putExtra("phone", inputPhone.getText());
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}