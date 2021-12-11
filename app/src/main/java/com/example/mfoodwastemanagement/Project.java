package com.example.mfoodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Project extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
    }

    public void donate(View view) {
        Intent intent2 = new Intent(this,Donate.class);
        startActivity(intent2);
    }

    public void receive(View view) {
        Intent intent3 = new Intent(this,Receive.class);
        startActivity(intent3);
    }
}