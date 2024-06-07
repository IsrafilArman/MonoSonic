package com.example.monosonic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    EditText email, password;
    Button signIn;
    CheckBox checkBox;
    TextView signUp;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        email = findViewById(R.id.email);
        signUp = findViewById(R.id.signUph);
        password = findViewById(R.id.password);

        signIn = findViewById(R.id.signin_button);

        checkBox = findViewById(R.id.checkbox);

        SharedPreferences sp = this.getSharedPreferences("fields_filled", MODE_PRIVATE);

        SharedPreferences.Editor e = sp.edit();

        String check = sp.getString("remember", "");


        if (check.equals("YES")) {
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
        }


        signIn.setOnClickListener(view -> {

            if (checkBox.isChecked()) {
                e.putString("remember", "YES");
            }

            String mail =  email.getText().toString();
            String pass =  password.getText().toString();

            String mail2 = sp.getString("user_email","");
            String pass2 = sp.getString("user_pass","");



            if(mail.equals(mail2) && pass.equals(pass2))
            {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });

    }
}
