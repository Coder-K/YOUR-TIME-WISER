package com.example.ytw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    EditText studenemai, passsword_ , confrirmapassword ;
    Button subBtn;
    TextView toLogin;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        studenemai = findViewById(R.id.StudentEmail);
        passsword_ = findViewById(R.id.studentPassword);
        confrirmapassword= findViewById(R.id.forgotPassword);

        toLogin = findViewById(R.id.forgotPassword);

        subBtn = findViewById(R.id.submitbtn);

        String email = studenemai.getText().toString(), password = passsword_.getText().toString(), confirmpassword = confrirmapassword.getText().toString();


        auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent i = new Intent(Registration.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(Registration.this, "Registered....", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Registration.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registration.this, MainActivity.class);
                Toast.makeText(Registration.this, "Open Login....", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}