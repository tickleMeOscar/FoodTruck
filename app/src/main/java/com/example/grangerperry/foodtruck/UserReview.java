package com.example.grangerperry.foodtruck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;

public class UserReview extends AppCompatActivity {

    public Button Submit;
    public TextView message;
    public Connection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_review);

//
//        Submit = (Button) findViewById(R.id.button12);
//        Submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CheckSubmit checkSubmit = new CheckSubmit();
//                checkSubmit.execute("");
//            }
//
//
//        });
//
//
//    }
//
//    // class to delete the name from database
//    public class CheckSubmit extends AsyncTask<String, String, String> {
//        String z = "";
//        Boolean isSuccess = false;
//        String name1 = "";
//
//
//        @Override
//        protected void onPostExecute(String r) {
//            Toast.makeText(UserReview.this, r, Toast.LENGTH_LONG).show();
//            if (isSuccess) {
//                message = (TextView) findViewById(R.id.review);
//                message.setText(name1);
//
//            }
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            try {
//                con = connectionclass();        // Connect to database
//                if (con == null) {
//                    z = "Check Your Internet Access!";
//                } else {
//                    // Change below query according to your own database.
//                    String query = "select * from review";
//                    Statement stmt = con.createStatement();
//                    ResultSet rs = stmt.executeQuery(query);
//                    if (rs.next()) {
//                        name1 = rs.getString("comment"); //Name is the string label of a column in database, read through the select query
//                        z = "Review Submitted";
//                        isSuccess = true;
//                        con.close();
//
//                    } else {
//                        z = "Invalid Query!";
//                        isSuccess = false;
//                    }
//                }
//            } catch (Exception ex) {
//                isSuccess = false;
//                z = ex.getMessage();
//
//                Log.d("sql error", z);
//            }
//
//            return z;
//        }
//
//    }
//
//    // connect to server
//    @SuppressLint("NewApi")
////    public Connection connectionclass() {
////        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
////        StrictMode.setThreadPolicy(policy);
////        Connection connection = null;
////        String ConnectionURL = null;
////        try {
////            Class.forName("net.sourceforge.jtds.jdbc.Driver");
////            //your database connection string goes below
////            ConnectionURL = "jdbc:jtds:sqlserver://stillwaterfood.database.windows.net:1433;DatabaseName=FoodTruckDB;user=mobilefoodtruck@stillwaterfood;password=Password1;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
////            connection = DriverManager.getConnection(ConnectionURL);
////        }
////        //create exception if its not connected
////        catch (SQLException se) {
////            Log.e("error here 1 : ", se.getMessage());
////        } catch (ClassNotFoundException e) {
////            Log.e("error here 2 : ", e.getMessage());
////        } catch (Exception e) {
////            Log.e("error here 3 : ", e.getMessage());
////        }
////        return connection;
////    }


    }
}
