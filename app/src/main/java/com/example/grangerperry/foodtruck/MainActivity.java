package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onOwner(View v)
    {
        Intent i = new Intent(getApplicationContext(),ownerlogin.class);
        startActivity(i);
    }
    public void onUser(View v)
    {
        Intent i = new Intent(getApplicationContext(),login.class);
        startActivity(i);
    }
}
