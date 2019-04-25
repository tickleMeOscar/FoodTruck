package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class test extends AppCompatActivity {


    public Firebase mRef;
    public static ArrayList<ArrayList> nest = new ArrayList<ArrayList>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);



    }

    public void onFind(View v) {
        mRef = new Firebase("https://practice-9b598.firebaseio.com/Trucks");
        mRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //To fetch the data form backend

                for (DataSnapshot snap : dataSnapshot.getChildren()) {

                    ArrayList<String> list = new ArrayList<String>();

                    String truck = snap.child("TruckName").getValue().toString();
                    String lat = snap.child("Latitude").getValue().toString();
                    String lng = snap.child("Longitude").getValue().toString();
                    String open = snap.child("OpenTime").getValue().toString();
                    String close = snap.child("closeTime").getValue().toString();
                    String cus = snap.child("Cuisine").getValue().toString();

                    //adding data of one snap to array list

                    list.add(truck);
                    list.add(lat);
                    list.add(lng);
                    list.add(open);
                    list.add(close);
                    list.add(cus);

                    //adding each ArrayList to nested ArrayList

                    nest.add(list);

                }

                Intent intent = new Intent(getApplicationContext(), map.class);
                String userName = getIntent().getStringExtra("userName");
                intent.putExtra("userName", userName);
                Log.d("Username5: ", userName);
                startActivity(intent);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });
        this.finish();
    }

    public void onTruckReview(View v) {
        Intent intent = new Intent(getApplicationContext(), readreview.class);
        startActivity(intent);
    }

    public void onSignOut(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}

