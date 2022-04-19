package com.musfikuroli.bda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class SelectRegistrationActivity extends AppCompatActivity {

    private Button donorButton, recipientButton;
    private TextView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Full Screens The App, Below 2 Lines
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_select_registration);

        donorButton = findViewById(R.id.donorButton);
        recipientButton = findViewById(R.id.recipientButton);
        backButton = findViewById(R.id.backButton);

        donorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(
                        SelectRegistrationActivity.this, DonorRegistrationActivity.class);
                startActivity(intent);
            }
        });

        recipientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(
                        SelectRegistrationActivity.this, RecipientRegistrationActivity.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(
                        SelectRegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}