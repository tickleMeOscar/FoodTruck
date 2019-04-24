package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class reviewlandingpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewlandingpage);
    }

    public void leaveReview(View v)
    {
        Intent intent = new Intent(getApplicationContext(), makereview.class);
        startActivity(intent);
    }

    public void readReview(View v)
    {
        Intent intent = new Intent(getApplicationContext(), readreview.class);
        startActivity(intent);
    }

    public void home(View v)
    {
        Intent intent = new Intent(getApplicationContext(), test.class);
        startActivity(intent);
    }
}
