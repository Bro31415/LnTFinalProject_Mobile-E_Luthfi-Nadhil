package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText log_name, log_pass;
    Button login, register;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.loginBtn);
        log_name = findViewById(R.id.logUname);
        log_pass = findViewById(R.id.password);
        register = findViewById(R.id.regBtn);
        sp = getSharedPreferences("account", MODE_PRIVATE);

        login.setOnClickListener(v -> {
            if (!log_name.getText().toString().equals(sp.getString("account_name", ""))) {
                Toast.makeText(MainActivity.this, "Username Invalid", Toast.LENGTH_SHORT).show();
            } else if(!log_pass.getText().toString().equals(sp.getString("account_password", ""))) {
                Toast.makeText(MainActivity.this, "Password Invalid", Toast.LENGTH_SHORT).show();
            } else if(log_name.getText().toString().equals(sp.getString("account_name", ""))
                    && log_pass.getText().toString().equals(sp.getString("account_password", ""))) {
                Intent loginIntent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(loginIntent);
//            } else if(log_name.getText().toString().equals("") || log_pass.getText().toString().equals("")){
//                Toast.makeText(MainActivity.this, "Please fill in your username and password", Toast.LENGTH_SHORT).show();
          }
        });

        register.setOnClickListener(v -> {
            Intent regIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(regIntent);
        });
    }

    
}