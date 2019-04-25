package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class makereview extends AppCompatActivity {


    private TextView debug;
    private EditText review;
    private RatingBar mRatingbar;
    public Firebase mRef;
    public Firebase mRefInstance;
    public Firebase mRefInstanceOwner;
    public Firebase mRefInstancePass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makereview);

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://practice-9b598.firebaseio.com/Reviews");

        Bundle b = getIntent().getExtras();
        mRatingbar = (RatingBar) findViewById(R.id.ratingBar);


        debug = findViewById(R.id.debug);
        review = findViewById(R.id.leaveReview);

        if (null != b) {
            ArrayList<ArrayList> arr = (ArrayList<ArrayList>) b.getSerializable("array_list");

            Log.i("List", "Passed Array List :: " + arr.get(0).indexOf(1));
            debug.setText(arr.get(0).get(0).toString());

        }



    }

    public void onReviewSubmit(View v)
    {

        String userName = getIntent().getStringExtra("userName");
        float reviewRating = mRatingbar.getRating();
        String reviewComment  = review.getText().toString();
        String companyName = debug.getText().toString();
        //debug.setText(mRatingBar.toString());



        mRefInstance = mRef.child(companyName);
        mRefInstanceOwner = mRefInstance.child("Company");
        mRefInstanceOwner.setValue(companyName);

        mRefInstancePass = mRefInstance.child("Review");
        mRefInstancePass.setValue(reviewComment);

        mRefInstancePass = mRefInstance.child("UserName");
        mRefInstancePass.setValue(userName);

        mRefInstancePass = mRefInstance.child("Rating");
        mRefInstancePass.setValue(reviewRating);

        Intent intent = new Intent(getApplicationContext(), reviewlandingpage.class);
        startActivity(intent);
    }
}
