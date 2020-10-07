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

public class SignUPActivity extends AppCompatActivity {
    private Button sign;
    private EditText email, password;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_u_p);
        sign = findViewById(R.id.addAccount);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        auth = FirebaseAuth.getInstance();


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailSign = email.getText().toString();
                String passwordSign = password.getText().toString();
                if ((email.getText().toString()).isEmpty() && (password.getText().toString()).isEmpty()) {
                    Toast.makeText(SignUPActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                } else {
                    auth.createUserWithEmailAndPassword(emailSign, passwordSign).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(SignUPActivity.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUPActivity.this, MainActivity.class));
                        }
                    });
                }
            }
        });
    }
}