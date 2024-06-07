package com.example.monosonic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText email, password, confirmPassword;
    Button signUp;
    TextView signinH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        signUp = findViewById(R.id.signup_button);
        signinH = findViewById(R.id.signin);

        SharedPreferences sp = this.getSharedPreferences("fields_filled", MODE_PRIVATE);

        SharedPreferences.Editor e = sp.edit();

        signUp.setOnClickListener(view -> {

            if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                if (email.getText().toString().isEmpty()) {
                    email.setError("Enter name");
                }
                if (password.getText().toString().isEmpty()) {
                    password.setError("Enter email address");
                }
            } else {
                e.putString("user_email", email.getText().toString());

                String pass = password.getText().toString();
                String rePass = confirmPassword.getText().toString();

                if (pass.equals(rePass)) {

                    e.putString("user_pass", pass);
                    e.apply();

                    Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(intent);

                } else {
                    confirmPassword.setError("Password not matched");
                }
            }
        });

        signinH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);

            }
        });

    }
}
