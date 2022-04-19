package com.musfikuroli.bda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    ImageView appLogo;
    EditText emailForgotPassword;
    Button sendResetPasswordLinkButton;
    TextView backButton;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Full Screens The App, Below 2 Lines
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_forgot_password);


        appLogo = findViewById(R.id.app_logo_forget_password);
        emailForgotPassword = findViewById(R.id.email_forget_password);
        sendResetPasswordLinkButton = findViewById(R.id.send_password_reset_link_button);
        progressBar = findViewById(R.id.reset_password_progressbar);
        backButton = findViewById(R.id.backButton);
        mAuth = FirebaseAuth.getInstance();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        sendResetPasswordLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailForgotPassword.getText().toString().trim();

                if(email.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this, "Enter your E-mail first...", Toast.LENGTH_SHORT).show();
                }
                else {

                    progressBar.setVisibility(View.VISIBLE);

                    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()) {

                                Toast.makeText(ForgotPasswordActivity.this, "Password Reset Link has been sent to your E-mail", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(ForgotPasswordActivity.this, "Account doesn't exit. Please Enter correct E-mail", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
            }
        });

    }
}
