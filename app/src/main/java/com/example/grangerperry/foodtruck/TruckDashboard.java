package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TruckDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_dashboard);



    }


    public void onUpdateAddress(View v){

        Intent intent = new Intent(getApplicationContext(), ownerdisplay.class);
        intent.putExtras(getIntent().getExtras());
        startActivity(intent);

    }

    public void onTruckEdit (View v){

        Intent intent = new Intent(getApplicationContext(), ownerdisplay.class);
        startActivity(intent);

    }

   public void onSignOut(View v)
   {

       Intent intent = new Intent(getApplicationContext(), MainActivity.class);
       startActivity(intent);
       this.finish();
   }

}
