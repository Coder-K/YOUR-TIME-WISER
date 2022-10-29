package com.example.ytw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Daily extends AppCompatActivity {

    FloatingActionButton fltBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        fltBtn = findViewById(R.id.addbtn);

        fltBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Daily.this, Add_time_Table.class);
               startActivity(i);
            }
        });

    }
}