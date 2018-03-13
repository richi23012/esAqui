package com.example.ricardo.esaqui;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class General extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ScrollView tutorial;
    Button cat;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_general);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        cat = findViewById(R.id.button2);
        tutorial =  findViewById(R.id.tutorial);

        Boolean isFirstRun2 =
                getSharedPreferences("PREFERENCES", MODE_PRIVATE)
                        .getBoolean("isFirstRun2", true);


        if (isFirstRun2) {

                        tutorial.setVisibility(View.VISIBLE);

        }

        getSharedPreferences("PREFERENCES", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun2", false).commit();



        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ho = new Intent(General.this, MainActivity.class);
                startActivity(ho);
            }
        });
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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-33.351457, -70.744659);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Casa Ale"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
