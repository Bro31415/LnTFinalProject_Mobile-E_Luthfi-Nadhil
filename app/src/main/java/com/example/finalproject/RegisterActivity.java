package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText reg_id, reg_email, reg_name, reg_password, reg_conpas;
    Button confirmReg;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_id = findViewById(R.id.id_bimbel);
        reg_email = findViewById(R.id.email);
        reg_name = findViewById(R.id.name);
        reg_password = findViewById(R.id.reg_password);
        reg_conpas = findViewById(R.id.reg_conpas);
        confirmReg = findViewById(R.id.reg_confirm);
        sp = getSharedPreferences("account", MODE_PRIVATE);

        confirmReg.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("account_id", reg_id.getText().toString());
            editor.putString("account_email", reg_email.getText().toString());
            editor.putString("account_name", reg_name.getText().toString());
            editor.putString("account_password", reg_password.getText().toString());
            editor.putString("account_conpas", reg_conpas.getText().toString());
            editor.apply();
            Toast.makeText(RegisterActivity.this, "Anda telah terdaftar di sistem!", Toast.LENGTH_SHORT).show();

        });
        confirmReg.setOnClickListener(v -> {
            Intent confirmRegIntent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(confirmRegIntent);
        });

    }
}