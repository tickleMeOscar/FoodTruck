package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;


public class signup extends AppCompatActivity {
//    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "MainActivity";
    private EditText firstname;
    private EditText password;
    private EditText lastname;
    private EditText email;
    private EditText number;
    private EditText username;

    public Firebase mRef;
    public Firebase mRefInstance;
    public Firebase mRefInstanceUser;
    public Firebase mRefInstancePass;
    public Firebase mRefInstanceFirst;
    public Firebase mRefInstanceLast;
    public Firebase mRefInstancemail;
    public Firebase mRefInstancenumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://practice-9b598.firebaseio.com/Users");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        username = (EditText) findViewById(R.id.input_username);
        firstname = (EditText) findViewById(R.id.input_firstname);
        password = (EditText) findViewById(R.id.input_password);
        lastname= (EditText) findViewById(R.id.input_lastname);
        email = (EditText) findViewById(R.id.input_email);
        number = (EditText) findViewById(R.id.input_number);


    }

    public void onsignup(View v )

    {
        String userid  = username.getText().toString();
        String first = firstname.getText().toString();
        String last = lastname.getText().toString();
        String pass = password.getText().toString();
        String mail = email.getText().toString();
        String num = number.getText().toString();



        mRefInstance = mRef.child(userid);
        mRefInstanceUser = mRefInstance.child("Username");
        mRefInstanceUser.setValue(userid);

        mRefInstancePass = mRefInstance.child("Password");
        mRefInstancePass.setValue(pass);

        mRefInstanceFirst = mRefInstance.child("FirstName");
        mRefInstanceFirst.setValue(first);


        mRefInstanceLast = mRefInstance.child("LastName");
        mRefInstanceLast.setValue(last);

        mRefInstancemail = mRefInstance.child("Email");
        mRefInstancemail.setValue(mail);

        mRefInstancenumber = mRefInstance.child("Phone");
        mRefInstancenumber.setValue(num);


        //Clearing the filled values from the screen

        username.setText("");
        password.setText("");
        firstname.setText("");
        lastname.setText("");
        password.setText("");
        email.setText("");
        number.setText("");

        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);

    }

}
