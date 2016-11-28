package fr.jnvui.couresme.activities;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import fr.jnvui.couresme.R;
import fr.jnvui.couresme.data.GPSData;
import fr.jnvui.couresme.interfaces.IGPSData;

import fr.jnvui.couresme.interfaces.ICapteur;
import fr.jnvui.couresme.data.Capteur;

/**
 * Created by jips on 10/24/16.
 */

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    Handler mHandler;

    ICapteur myValueCapteur;
    //------DATA
    IGPSData myPositionGPSData;

    Marker mPosition;
    MarkerOptions mPositionMarker = new MarkerOptions().title("MyPosition");

    Runnable mUIRunnable = new Runnable() {
        @Override
        public void run() {

            Location location = myPositionGPSData.getPosition();

            int value = myValueCapteur.getCapteur();

            LatLng myPosition = new LatLng(location.getLatitude(), location.getLongitude());

            if (mMap != null) {

                if (mPosition != null) {
                    mPosition.remove();
                }

                mPositionMarker.position(myPosition);
                mPositionMarker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

                // Add a marker on our position
                mPosition = mMap.addMarker(mPositionMarker);
                // Move camera
                mMap.moveCamera(CameraUpdateFactory.newLatLng(myPosition));
                // Zoom
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition, 13f));

                CircleOptions circleOptions = new CircleOptions()
                        .center(myPosition)
                        .strokeColor(Capteur.convertACToColor(value))
                        .fillColor(Capteur.convertACToColor(value))
                        .radius(500); // In meters

                Circle circle = mMap.addCircle(circleOptions);
            }
            mHandler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.mMap = googleMap;

        myPositionGPSData = new GPSData();

        myValueCapteur = new Capteur();

        myPositionGPSData.startThread();

        mHandler.postDelayed(mUIRunnable,100);
    }
}
