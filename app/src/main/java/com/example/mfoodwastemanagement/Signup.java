package com.example.mfoodwastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText rusername,rage,remailid,rpass;
    Button register;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        rusername=findViewById(R.id.textView4);
        rage=findViewById(R.id.textView7);
        remailid=findViewById(R.id.textView5);
        rpass=findViewById(R.id.textView6);
        register=findViewById(R.id.button3);


    }

    public void register(View view) {
        mAuth=FirebaseAuth.getInstance();
        String email=remailid.getText().toString();
        String password =rpass.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Signup.this,"Successfully registered",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Signup.this,"Not successfully registered",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}