package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;


public class ownersignup extends AppCompatActivity {



    private EditText email;
    private EditText truckname;
    private EditText ownername;
    private EditText number;
    private EditText opentime;
    private EditText closetime;
    private EditText longitude;
    private EditText latitude;
    private EditText cusine;


    private EditText password;


    public Firebase mRef;
    public Firebase mRefInstance;
    public Firebase mRefInstanceOwner;
    public Firebase mRefInstancePass;
    public Firebase mRefInstancemail;
    public Firebase mRefInstancenumber;
    public Firebase mRefInstanceLongitude;
    public Firebase mRefInstanceLatitude;

    public Firebase mRefInstanceOpentime;
    public Firebase mRefInstanceClosetime;
    public Firebase mRefInstancetruckname;
    public Firebase mRefInstancecuisine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://practice-9b598.firebaseio.com/Trucks");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownersignup);



        truckname = (EditText) findViewById(R.id.truck_name);
        ownername = (EditText) findViewById(R.id.owner_name);
        number = (EditText) findViewById(R.id.input_number);
        password = (EditText) findViewById(R.id.input_password);
        opentime = (EditText) findViewById(R.id.time_from);
        closetime = (EditText) findViewById(R.id.time_to);
        email = (EditText) findViewById(R.id.input_email);
        latitude = (EditText) findViewById(R.id.latitude);
        longitude = (EditText) findViewById(R.id.longitude);
        cusine = (EditText) findViewById(R.id.cuisine);



    }
    public void onSubmit(View v)
    {
        String owner  = ownername.getText().toString();
        String pass = password.getText().toString();
        String mail = email.getText().toString();
        String num = number.getText().toString();
        String truck = truckname.getText().toString();
        String open = opentime.getText().toString();
        String close = closetime.getText().toString();
        String lang = longitude.getText().toString();
        String lat = latitude.getText().toString();
        String cus = cusine.getText().toString();



        mRefInstance = mRef.child(owner);
        mRefInstanceOwner = mRefInstance.child("Username");
        mRefInstanceOwner.setValue(owner);

        mRefInstancePass = mRefInstance.child("Password");
        mRefInstancePass.setValue(pass);

        mRefInstancemail = mRefInstance.child("Email");
        mRefInstancemail.setValue(mail);

        mRefInstancenumber = mRefInstance.child("Phone");
        mRefInstancenumber.setValue(num);

        mRefInstanceOpentime = mRefInstance.child("OpenTime");
        mRefInstanceOpentime.setValue(open);

        mRefInstanceClosetime = mRefInstance.child("closeTime");
        mRefInstanceClosetime.setValue(close);

        mRefInstanceLongitude = mRefInstance.child("Longitude");
        mRefInstanceLongitude.setValue(lang);

        mRefInstanceLatitude = mRefInstance.child("Latitude");
        mRefInstanceLatitude.setValue(lat);


        mRefInstancetruckname = mRefInstance.child("TruckName");
        mRefInstancetruckname.setValue(truck);

        mRefInstancecuisine = mRefInstance.child("Cuisine");
        mRefInstancecuisine.setValue(cus);

        //Clearing the filled values from the screen

        ownername.setText("");
        password.setText("");
        email.setText("");
        number.setText("");
        truckname.setText("");
        opentime.setText("");
        closetime.setText("");
        latitude.setText("");
        longitude.setText("");
        cusine.setText("");

       Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), ownerlogin.class);
        startActivity(intent);

    }
    public void onSuccess(View v)
    {
        Intent intent = new Intent(getApplicationContext(), ownerlogin.class);
        startActivity(intent);
    }
}

