package com.example.ytw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText StudentNum,password_;
    TextView fgPassword;
    Button subBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentNum = findViewById(R.id.StudentEmail);
        password_ = findViewById(R.id.studentPassword);
        fgPassword= findViewById(R.id.forgotPassword);

        subBtn = findViewById(R.id.submitbtn);

        String stNum = StudentNum.getText().toString();
        String password = password_.getText().toString();



        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth.signInWithEmailAndPassword(stNum,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent i = new Intent(MainActivity.this, Add_time_Table.class);
                        startActivity(i);
                        Toast.makeText(MainActivity.this, "Logging In....", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    fgPassword.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity.this, Registration.class);
            Toast.makeText(MainActivity.this, "Open Registration....", Toast.LENGTH_SHORT).show();
            startActivity(i);
        }
    });

    }
}