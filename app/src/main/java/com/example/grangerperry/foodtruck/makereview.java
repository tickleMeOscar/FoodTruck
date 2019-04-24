package com.example.grangerperry.foodtruck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class makereview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makereview);
    }

    public void onReviewSubmit(View v)
    {
        RatingBar mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        EditText editText = (EditText) findViewById(R.id.editText);
        TextView debug = findViewById(R.id.debug);
        /*Insert Review and star rating into the database
        * Then return to reviewlandingpage*/

        //debug.setText(mRatingBar.toString());
        Intent intent = new Intent(getApplicationContext(), reviewlandingpage.class);
        startActivity(intent);
    }
}
