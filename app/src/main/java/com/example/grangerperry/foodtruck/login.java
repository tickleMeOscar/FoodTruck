package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.io.Serializable;
import java.util.Map;

public class login extends AppCompatActivity {
    // FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText username;
    private EditText password;
    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);

    }


    public void Login(View v) {
        mRef = new Firebase("https://practice-9b598.firebaseio.com/Users");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Map<String, String>> map = dataSnapshot.getValue(Map.class);

                Log.i("dta", dataSnapshot.getValue().toString());
                Log.i("dta-maps", dataSnapshot.getValue().toString());


                String match = "";
                if (!username.getText().toString().equals("")) {
                    Map<String, String> matchMap = map.get(username.getText().toString());
                    if (matchMap != null) {
                        match = matchMap.get("Password");

                        if (match.equals(password.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                            String userName = username.getText().toString();

                            Intent intent = new Intent(getApplicationContext(), test.class);
                            Log.d("Username3: ", userName);
                            intent.putExtra("userName", userName);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getApplicationContext(), "Password Incorrect", Toast.LENGTH_SHORT).show();
                        }
                    } else if (matchMap == null) {
                        Toast.makeText(getApplicationContext(), "No User Found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Enter login details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        this.finish();
    }

    public void sign(View v) {
        Intent i = new Intent(getApplicationContext(), signup.class);
        startActivity(i);
    }
}
