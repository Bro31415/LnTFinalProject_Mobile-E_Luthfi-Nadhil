package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText log_name, log_pass;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.loginBtn);
        register = findViewById(R.id.regBtn);


        register.setOnClickListener(v -> {
            Intent regIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(regIntent);
        });
    }

    
}