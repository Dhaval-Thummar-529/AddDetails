package com.dtmania.adddetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {
    private Button button,next;
    private EditText name, email, profession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name = findViewById(R.id.editName);
        email = findViewById(R.id.editEmailAddDetails);
        profession = findViewById(R.id.editProfession);
        button = findViewById(R.id.addDetails);
        next = findViewById(R.id.next);
        next.setEnabled(false);
        Intent intent = getIntent();
        email.setText(intent.getStringExtra("email"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || profession.getText().toString().isEmpty()) {
                    Toast.makeText(HomeActivity.this, "Please fill all the details!", Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("Name", name.getText().toString());
                    map.put("Profession", profession.getText().toString());
                    map.put("Email", email.getText().toString());
                    FirebaseDatabase.getInstance().getReference().push().updateChildren(map);
                    next.setEnabled(true);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,FetchDataActivity.class));
            }
        });
    }
}