package com.weapplinse.googlemap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  OnMapReadyCallback {
    protected GoogleMap map;
    Marker mCarMarker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        initilizeMap();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        map.getUiSettings().setZoomControlsEnabled(false);

        // ************ Enable Disable Compass icon ************
        map.getUiSettings().setCompassEnabled(true);
        map.getUiSettings().setMapToolbarEnabled(false);
        //**************  Enable / Disable Rotate gesture ***********
        map.getUiSettings().setRotateGesturesEnabled(false);

        // *************** Enable Disable zooming functionality ******************
        map.getUiSettings().setZoomGesturesEnabled(true);

        LatLng latlng = new LatLng(21.222044, 72.880720);

        MarkerOptions options = new MarkerOptions();
        options.position(latlng);
        options.icon(BitmapDescriptorFactory.fromResource(R.drawable.car));
        mCarMarker = map.addMarker(options);

        final CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latlng)      // Sets the center of the map to Mountain View
                .zoom(16)                   // Sets the zoom
                .bearing(360)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    private void initilizeMap() {
        if (map == null) {
            //************* GoogleMap initialization***********************
            SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFrag.getMapAsync(this);

        }
    }


}
