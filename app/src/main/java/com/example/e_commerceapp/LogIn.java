package com.example.e_commerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button logbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        logbtn = findViewById(R.id.logbtn);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LogIn.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}

