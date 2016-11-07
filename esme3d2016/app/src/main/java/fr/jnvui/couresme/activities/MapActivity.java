package fr.jnvui.couresme.activities;

import android.app.Activity;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

import fr.jnvui.couresme.R;
import fr.jnvui.couresme.data.GPSData;
import fr.jnvui.couresme.data.ListPOIs;
import fr.jnvui.couresme.data.POI;
import fr.jnvui.couresme.interfaces.IGPSData;
import fr.jnvui.couresme.interfaces.IListPOIs;

import static fr.jnvui.couresme.SearchPOI.findNearestPOI;


/**
 * Created by jips on 10/24/16.
 */

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    Handler mHandler;

    //------DATA
    IGPSData myPositionGPSData;
    //------POI
    IListPOIs mIListPOIs;

    Marker mPosition;
    Marker mNearestPOI;
    MarkerOptions mPositionMarker = new MarkerOptions().title("MyPosition");
    POI poiNearest;

    Runnable mUIRunnable = new Runnable() {
        @Override
        public void run() {

            Location location = myPositionGPSData.getPosition();

            LatLng myPosition = new LatLng(location.getLatitude(), location.getLongitude());

            if(mMap != null){



                if(mPosition != null){
                    mPosition.remove();
                }

                mPositionMarker.position(myPosition);
                mPositionMarker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

                // Add a marker in Sydney and move the camera
                mPosition = mMap.addMarker(mPositionMarker);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(myPosition));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myPosition, 14f));


                //Show nearest POI
                POI poi = null;//findNearestPOI(location,mIListPOIs.getPOIs());

                if(poi == poiNearest){

                }else {
                    if(mNearestPOI != null){
                        mNearestPOI.remove();
                    }

                    Location locationNearest = poi.getmLocation();

                    mPositionMarker.position(new LatLng(locationNearest.getLatitude(),
                            locationNearest.getLongitude()));
                    mPositionMarker.icon(BitmapDescriptorFactory.fromResource(R.mipmap.cercles));
                    mNearestPOI = mMap.addMarker(mPositionMarker);

                    poiNearest = poi;
                }
            }
            mHandler.postDelayed(this,1000);
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
        mHandler.postDelayed(mUIRunnable,100);
    }

    void setListPOIOnMap(HashMap<String, POI> poiHashMap){

        HashMap<String,POI> stringPOIHashMap = poiHashMap;

        for (Map.Entry<String, POI> entry : stringPOIHashMap.entrySet())
        {
            LatLng latLng =  new LatLng(entry.getValue().getmLocation().getLatitude(),
                    entry.getValue().getmLocation().getLongitude());

            //fill map
            mMap.addMarker(new MarkerOptions().position(latLng).title(entry.getKey()));
        }
    }

}
