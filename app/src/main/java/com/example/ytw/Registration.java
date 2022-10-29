package com.example.ytw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {


    private FirebaseAuth auth =FirebaseAuth.getInstance();
    private FirebaseUser user ;
    Button submit;
    EditText email , password ,conpass , login;
    String Pass , Email, ConPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = findViewById(R.id.StudentEmail);
        password = findViewById(R.id.password);
        conpass = findViewById(R.id.studentPassword);
        login = findViewById(R.id.Login);
        submit = findViewById(findViewById(R.id.submitbtn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, MainActivity.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email != null && password != null && conpass != null) {
                    Pass = password.getText().toString();
                    Email = email.getText().toString();
                    ConPass = conpass.getText().toString();
                    if (Pass.equals(ConPass)) {
                        auth.createUserWithEmailAndPassword(Email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Registration.this, "Registration complete", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Registration.this, MainActivity.class));
                                } else {
                                    Toast.makeText(Registration.this, "Registration failed " + task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    } else {
                        Toast.makeText(Registration.this, "Passwords are not the same", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Registration.this, "Fill in all the fields ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}