package com.example.ytw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Add_time_Table extends AppCompatActivity {

    EditText Module_name,venue,time, day;
    Button submit_btn;
    FirebaseAuth auth;
    FirebaseDatabase database;
    String names, times, venues, day_;
    int days = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time_table);
        Module_name = findViewById(R.id.ModuleName);
        venue = findViewById(R.id.Venue);
        time = findViewById(R.id.txt_time);
        submit_btn = findViewById(R.id.submitBtn);
        day = findViewById(R.id.DayOfWeek);


        names = Module_name.getText().toString();
        times = time.getText().toString();
        venues = venue.getText().toString();
        day_ = day.getText().toString();

        getday();

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> put_into = new HashMap<>();
                put_into.put("Module Name",names);
                put_into.put("Venue",venues);
                put_into.put("Time Name",names);

                String uid= auth.getCurrentUser().getUid();
                FirebaseDatabase.getInstance().getReference().child(uid).push().setValue(put_into)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                             Module_name.setText("");
                             venue.setText("");
                             day.setText("");
                             time.setText("");
                                Toast.makeText(Add_time_Table.this, "Module Added", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Module_name.setText("");
                                venue.setText("");
                                day.setText("");
                                time.setText("");
                                Toast.makeText(Add_time_Table.this, "Module Added", Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });


    }

    private void getday() {
        if(day_.toLowerCase().equals("monday"))
        {
           days =1;
        }
        else
        if(day_.toLowerCase().equals("tuesday"))
        {
            days =2;

        }
        else
        if(day_.toLowerCase().equals("wednesday"))
        {
            days =3;

        }
        else
        if(day_.toLowerCase().equals("thursday"))
        {
            days =4;

        }
        else
        if(day_.toLowerCase().equals("friday"))
        {
            days =5;
        }
    }
}