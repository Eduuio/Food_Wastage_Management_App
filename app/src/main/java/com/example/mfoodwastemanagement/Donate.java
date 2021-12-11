package com.example.mfoodwastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Donate extends AppCompatActivity {
    EditText f,p,ph;
    Button b;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        f=(EditText) findViewById(R.id.textView8);
        p=(EditText) findViewById(R.id.textView9);
        ph=(EditText) findViewById(R.id.textView10);
        b= (Button)findViewById(R.id.button4);
    }

    public void submit(View view) {
        rootNode=FirebaseDatabase.getInstance();
        reference= rootNode.getReference("User");
        String food = f.getText().toString();
        String prize = p.getText().toString();
        String phno = ph.getText().toString();
        UserHelperClass helperClass= new UserHelperClass(food,prize,phno);

        reference.child(food).setValue(helperClass);
    }
}