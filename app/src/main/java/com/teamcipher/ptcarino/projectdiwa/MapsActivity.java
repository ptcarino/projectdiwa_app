package com.teamcipher.ptcarino.projectdiwa;

import android.content.Intent;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.teamcipher.ptcarino.trial.R;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setTrafficEnabled(true);

        //SET SHELTER MARKERS
        mMap.addMarker(new MarkerOptions().position(new LatLng(14.5932425, 121.020323)).title("Magistrado Imperial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))); //Marker 1
        mMap.addMarker(new MarkerOptions().position(new LatLng(14.559218, 121.005653)).title("4339 Filmore Ave").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_shelter))); //Marker 2
        mMap.addMarker(new MarkerOptions().position(new LatLng(14.532008, 121.022551)).title("Whitespace Manila, 2314 Makati")); //Marker 3
        mMap.addMarker(new MarkerOptions().position(new LatLng(14.533285, 121.022369)).title("DHL House, 2306 Chino Roces Avenue")); //Marker 4
        mMap.addMarker(new MarkerOptions().position(new LatLng(14.533961, 121.021307)).title("2300 Makati")); //Marker 5
        mMap.addMarker(new MarkerOptions().position(new LatLng(14.53257, 121.018174)).title("Encarnacion Makati")); //Marker 6

    }

    public void onBackPressed() {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }
}
