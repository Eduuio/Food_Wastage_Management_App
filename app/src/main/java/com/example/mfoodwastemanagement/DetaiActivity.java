package com.example.mfoodwastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DetaiActivity extends AppCompatActivity {
    EditText ufood,uprize,uphno;
    DatabaseReference ref;

    Button c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai);
        ufood = (EditText) findViewById(R.id.a);
        uprize = (EditText) findViewById(R.id.b);
        uphno= (EditText) findViewById(R.id.c);
        c=findViewById(R.id.buttonc);

        Intent i = getIntent();
        String rfood = i.getStringExtra("Food");
        String rprize = i.getStringExtra("Prize");
        String rphno = i.getStringExtra("Phno");







        ufood.setText("Food- "+rfood);
        uprize.setText("Prize- "+rprize);
        uphno.setText("Contact no- "+rphno);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = FirebaseDatabase.getInstance().getReference();
                Query applesQuery = ref.child("User").orderByChild("food").equalTo(rfood);
                applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot appleSnapshot: snapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                Toast.makeText(DetaiActivity.this,"Thankyou for buying",Toast.LENGTH_LONG).show();

            }
        });
    }
}