package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class readreview extends AppCompatActivity {

    private TextView companyNameString;
    private TextView companyReviewString;
    private TextView userNameString;
    private RatingBar mRatingbar;
    public Firebase mRef;


    //To get user name from login page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://practice-9b598.firebaseio.com/Reviews");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readreview);


        companyNameString = findViewById(R.id.reviewOne);
        userNameString = findViewById(R.id.reviewTwo);
        companyReviewString = findViewById(R.id.reviewThree);
        mRatingbar = findViewById(R.id.ratingBar2);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                //To fetch the data form backend

                String companyName = dataSnapshot.child("Purdy Q").child("Company").getValue(String.class);
                String companyReview = dataSnapshot.child("Purdy Q").child("Review").getValue(String.class);
                String reviewUserName = dataSnapshot.child("Purdy Q").child("UserName").getValue(String.class);
                int ratingReview =  dataSnapshot.child("Purdy Q").child("Rating").getValue(Integer.class);


                //To display the retrieved data
                companyNameString.setText(companyName);
                companyReviewString.setText(companyReview);
                userNameString.setText(reviewUserName);
                mRatingbar.setRating(ratingReview);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });
    }
}