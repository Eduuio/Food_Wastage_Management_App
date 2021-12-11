package com.example.mfoodwastemanagement;

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

public class MainActivity extends AppCompatActivity {
    EditText lemailid,lpassword;
    Button signin,signup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lemailid=findViewById(R.id.textView);
        lpassword=findViewById(R.id.textView2);
        signin=findViewById(R.id.button);
        signup=findViewById(R.id.button2);

    }

    public void signup(View view) {
        Intent intent = new Intent(MainActivity.this,Signup.class);
        startActivity(intent);
    }

    public void signin(View view) {
        mAuth=FirebaseAuth.getInstance();
        String emaill=lemailid.getText().toString();
        String passwordl =lpassword.getText().toString();
        mAuth.signInWithEmailAndPassword(emaill,passwordl).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Successfully loged in",Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(MainActivity.this,Project.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(MainActivity.this,"Not successfully loged in",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}