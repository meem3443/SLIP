package com.example.slip.mainFunction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.slip.R;
import com.example.slip.databinding.ActivityInputContactInfoBinding;

public class InputContactInfoActivity extends AppCompatActivity {

    private ActivityInputContactInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInputContactInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        EditText inputName = binding.editTextName;
        EditText inputPhone = binding.editTextPhone;
        Button cancelBtn = binding.cancelBtn;
        Button saveBtn = binding.saveBtn;

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            inputName.setText(bundle.get("name").toString());
            inputPhone.setText(bundle.get("phone").toString());
        }

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
                intent.putExtra("name", inputName.getText().toString());
                intent.putExtra("phone", inputPhone.getText().toString());
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}