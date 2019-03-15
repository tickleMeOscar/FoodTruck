package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import android.view.View;
import android.widget.Toast;


public class ownerdisplay extends AppCompatActivity {

    public Firebase mRef;
    public Firebase mRefInstance;
    public Firebase mRefInstanceOwner;

    public Firebase mRefInstancemail;
    public Firebase mRefInstancenumber;

    public Firebase mRefInstanceLang;
    public Firebase mRefInstanceLat;
    public Firebase mRefInstanceOpentime;
    public Firebase mRefInstanceClosetime;
    public Firebase mRefInstancetruckname;
    public Firebase mRefInstancecusine;

    private EditText truck;
    private EditText number;
    private EditText latitude;
    private EditText longitude;
    private EditText openTime;
    private EditText closeTime;
    private EditText mail;
    private EditText cusine;


    //To get user name from login page
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://practice-9b598.firebaseio.com/Trucks");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownerdisplay);

        truck = (EditText) findViewById(R.id.truck_name);
        number = (EditText) findViewById(R.id.number);
        latitude = (EditText) findViewById(R.id.latitude);
        longitude = (EditText) findViewById(R.id.longitude);
        openTime = (EditText) findViewById(R.id.time_from);
        closeTime = (EditText) findViewById(R.id.time_to);
        mail = (EditText) findViewById(R.id.input_email);
        cusine = (EditText) findViewById(R.id.cuisine);

        mRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                String rText = getIntent().getStringExtra(ownerlogin.new_string);




                //To fetch the data form backend

                String truckname = dataSnapshot.child(rText).child("TruckName").getValue().toString();
                String email = dataSnapshot.child(rText).child("Email").getValue().toString();
                String phone = dataSnapshot.child(rText).child("Phone").getValue().toString();
                String open = dataSnapshot.child(rText).child("OpenTime").getValue().toString();
                String close = dataSnapshot.child(rText).child("closeTime").getValue().toString();
                String lang = dataSnapshot.child(rText).child("Longitude").getValue().toString();
                String lat = dataSnapshot.child(rText).child("Latitude").getValue().toString();
                String cus = dataSnapshot.child(rText).child("Cuisine").getValue().toString();


                //To display the retrieved data
                truck.setText(truckname);
                number.setText(phone);
                mail.setText(email);
                longitude.setText(lang);
                latitude.setText(lat);
                openTime.setText(open);
                closeTime.setText(close);
                cusine.setText(cus);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError)
            {

            }


        });
    }

    public void onChange(View v)
    {


        String mail1 = mail.getText().toString();
        String num = number.getText().toString();
        String truck1 = truck.getText().toString();
        String open = openTime.getText().toString();
        String close = closeTime.getText().toString();
        String lat = latitude.getText().toString();
        String lang = longitude.getText().toString();
        String cus = cusine.getText().toString();


        mRefInstance = mRef.child(getIntent().getStringExtra(ownerlogin.new_string));
        mRefInstanceOwner = mRefInstance.child("Username");
        mRefInstanceOwner.setValue(getIntent().getStringExtra(ownerlogin.new_string));

        mRefInstancemail = mRefInstance.child("Email");
        mRefInstancemail.setValue(mail1);

        mRefInstancenumber = mRefInstance.child("Phone");
        mRefInstancenumber.setValue(num);

        mRefInstanceOpentime = mRefInstance.child("OpenTime");
        mRefInstanceOpentime.setValue(open);

        mRefInstanceClosetime = mRefInstance.child("closeTime");
        mRefInstanceClosetime.setValue(close);

        mRefInstanceLang = mRefInstance.child("Longitude");
        mRefInstanceLang.setValue(lang);

        mRefInstanceLat = mRefInstance.child("Latitude");
        mRefInstanceLat.setValue(lat);

        mRefInstancetruckname = mRefInstance.child("TruckName");
        mRefInstancetruckname.setValue(truck1);

        mRefInstancecusine = mRefInstance.child("Cuisine");
        mRefInstancecusine.setValue(cus);


        Toast.makeText(getApplicationContext(),"Details Updated ",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), TruckDashboard.class);
        intent.putExtras(getIntent().getExtras());
        startActivity(intent);
        this.finish();

    }

    public void onLogout(View v)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
