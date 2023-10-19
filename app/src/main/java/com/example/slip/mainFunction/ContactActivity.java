package com.example.slip.mainFunction;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.slip.R;

public class ContactActivity extends AppCompatActivity {
    TextView name;
    TextView phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phonenumber);
        Button changeNumberBtn = findViewById(R.id.change_number_btn);
        ImageButton addNewContact = findViewById(R.id.add_contact_btn);

        changeNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InputContactInfoActivity.class);
                intent.putExtra("name", name.getText());
                intent.putExtra("phone", phoneNumber.getText());
                startActivityForResult(intent, 101);
            }
        });

        addNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InputContactInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                String modifiedName = data.getStringExtra("name");
                String modifiedPhone = data.getStringExtra("phone");
                name.setText(modifiedName);
                phoneNumber.setText(modifiedPhone);
            }
        }
    }
}