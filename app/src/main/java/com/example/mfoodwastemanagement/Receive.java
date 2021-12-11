package com.example.mfoodwastemanagement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Receive extends AppCompatActivity {
    ListView ListView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    FirebaseDatabase database;

    DatabaseReference ref;
    User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        user= new User();
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(Receive.this, R.layout.user_info, R.id.userInfo,list);

        ListView = (ListView) findViewById(R.id.Listview);
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
                final String selectedFromList = (String) ListView.getItemAtPosition(p);


                ref.orderByChild(selectedFromList).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String retrievedValue=snapshot.child(selectedFromList).child("food").getValue().toString();
                        String retrievedValue2=snapshot.child(selectedFromList).child("prize").getValue().toString();
                        String retrievedValue3=snapshot.child(selectedFromList).child("phno").getValue().toString();

                        Intent intentx = new Intent(Receive.this,DetaiActivity.class);


                        intentx.putExtra("Food",retrievedValue);
                        intentx.putExtra("Prize",retrievedValue2);
                        intentx.putExtra("Phno",retrievedValue3);


                        startActivity(intentx);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        database=FirebaseDatabase.getInstance();
        ref = database.getReference("User");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    user=ds.getValue(User.class);
                    list.add(user.getFood().toString());
                }
                ListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







    }


}