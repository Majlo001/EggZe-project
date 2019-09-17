package com.example.quizzappproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class account extends AppCompatActivity {

    private TextView name, email;
    private Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        btn_logout = findViewById(R.id.btn_logout);

        Intent intent = getIntent();
        String extraName =  intent.getStringExtra("name");
        String extraEmail =  intent.getStringExtra("email");

        name.setText(extraName);
        email.setText(extraEmail);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember","false");
                editor.apply();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                Toast.makeText(account.this, "Wylogowano", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
