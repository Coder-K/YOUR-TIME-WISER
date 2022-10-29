package com.example.ytw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth =FirebaseAuth.getInstance();
    private FirebaseUser user ;
    Button submit;
    EditText email , password , register;
    String Pass , Email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    submit = findViewById(R.id.submitbtn);
    email =findViewById(R.id.StudentEmail);
    password = findViewById(R.id.studentPassword);
    register = findViewById(R.id.Register);

    user= auth.getCurrentUser();

    register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this,Registration.class));
        }
    });

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (email != null && password != null) {
                Pass = password.getText().toString();
                Email = email.getText().toString();
                auth.signInWithEmailAndPassword(Email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Authentication complete ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, Dialy.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                Toast.makeText(MainActivity.this, "Fill in all the details please", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}