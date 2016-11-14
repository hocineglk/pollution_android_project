package fr.jnvui.couresme.activities;

import android.graphics.Color;
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

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import fr.jnvui.couresme.R;
import fr.jnvui.couresme.data.GPSData;
import fr.jnvui.couresme.data.ListPOIs;
import fr.jnvui.couresme.data.POI;
import fr.jnvui.couresme.interfaces.IGPSData;
import fr.jnvui.couresme.interfaces.IListPOIs;

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
    //------POI
    IListPOIs mIListPOIs;

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

                // Add a marker in Sydney and move the camera
                mPosition = mMap.addMarker(mPositionMarker);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(myPosition));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition, 13f));

                CircleOptions circleOptions = new CircleOptions()
                        .center(myPosition)
                        .strokeColor(Capteur.convertACToColor(value))
                        .fillColor(Capteur.convertACToColor(value))
                        .radius(500); // In meters

                // Get back the mutable Circle
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

        //Start Walking guy
        myPositionGPSData = new GPSData();
        mIListPOIs = new ListPOIs();

        myValueCapteur = new Capteur();

        setListPOIOnMap(mIListPOIs.getPOIs());

        myPositionGPSData.startThread();

        mHandler.postDelayed(mUIRunnable,100);
    }

    void setListPOIOnMap(HashMap<String, POI> poiHashMap){
        HashMap<String,POI> stringPOIHashMap = poiHashMap;

        for (Map.Entry<String, POI> entry : stringPOIHashMap.entrySet())
        {
            LatLng latLng =  new LatLng(entry.getValue().getmLocation().getLatitude(),
                    entry.getValue().getmLocation().getLongitude());

            mMap.addMarker(new MarkerOptions().position(latLng).title(entry.getKey()));
        }
    }
}
