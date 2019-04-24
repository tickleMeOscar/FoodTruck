package com.example.grangerperry.foodtruck;


import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.firebase.client.Firebase;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.view.View;
import java.util.ArrayList;

public class map extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {

        Firebase.setAndroidContext(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        ArrayList<ArrayList> newArray = test.nest;
        mMap = googleMap;
        ArrayList<LatLng> latlngs = new ArrayList<>();

        //To loop over the lat and lang values of all food trucks in database
        for (int i = 0; i < newArray.size(); i++) {
            float temp = Float.parseFloat((newArray.get(i)).get(1).toString());
            float temp2 = Float.parseFloat((newArray.get(i)).get(2).toString());

            //Adding lat and lang values of all the food trucks
            latlngs.add(i, new LatLng(temp, temp2));
            mMap.addMarker(new MarkerOptions().position(latlngs.get(i))
                    .title((newArray.get(i)).get(0).toString())
                    .snippet((newArray.get(i)).get(3).toString() + "-" + (newArray.get(i)).get(4).toString() + " " + (newArray.get(i)).get(5).toString()));

            mMap.moveCamera(CameraUpdateFactory.newLatLng(latlngs.get(i)));
            mMap.setMinZoomPreference(14.0f);
            mMap.setMaxZoomPreference(22.0f);

            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Intent intent1 = new Intent(getApplicationContext(), reviewlandingpage.class);
                    startActivity(intent1);
                }

            });
        }
    }
     public void onSignout(View v)
     {
         Intent intent = new Intent(getApplicationContext(), MainActivity.class);
         startActivity(intent);
         this.finish();
     }

    public void onBack(View v)
    {
        Intent intent = new Intent(getApplicationContext(), test.class);
        startActivity(intent);
        this.finish();
    }
}
