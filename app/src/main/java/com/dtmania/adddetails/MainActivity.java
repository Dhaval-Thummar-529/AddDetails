package com.dtmania.adddetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button signup, login;
    private EditText email, password;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.loginmain);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        auth = FirebaseAuth.getInstance();
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUPActivity.class));
            }
        });
        if (isFirstRun) {

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String emailMain = email.getText().toString();
                    String passwordMain = password.getText().toString();
                    if ((email.getText().toString()).isEmpty() && (password.getText().toString()).isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                    } else {


                        auth.signInWithEmailAndPassword(emailMain, passwordMain).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(MainActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                intent.putExtra("email", email.getText().toString());
                                startActivity(intent);
                            }

                        });
                    }
                }

            });
        }
        else {
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String emailMain = email.getText().toString();
                    String passwordMain = password.getText().toString();
                    if ((email.getText().toString()).isEmpty() && (password.getText().toString()).isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                    } else {


                        auth.signInWithEmailAndPassword(emailMain, passwordMain).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(MainActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, FetchDataActivity.class);
                                startActivity(intent);
                            }

                        });
                    }
                }

            });
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
    }
}