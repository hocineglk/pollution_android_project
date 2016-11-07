package fr.jnvui.couresme;

import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import fr.jnvui.couresme.activities.MapActivity;
import fr.jnvui.couresme.data.GPSData;
import fr.jnvui.couresme.data.ListPOIs;
import fr.jnvui.couresme.data.POI;
import fr.jnvui.couresme.interfaces.IGPSData;
import fr.jnvui.couresme.interfaces.IListPOIs;

import static fr.jnvui.couresme.SearchPOI.findNearestPOI;

public class MainActivity extends AppCompatActivity {

    Handler mHandler;
    TextView mPositionGPSTextView;
    TextView mListPOITextView;
    TextView mNearestPOITextView;
    Button mMapActivityButton;


    Button mON;
    Button mOFF;
    Button mSCAN;
    Button mLOGIN;
    Button mLOGOFF;

    //------DATA
    IGPSData myPositionGPSData;

    //------POI
    IListPOIs mIListPOIs;

    Runnable mUIRunnable = new Runnable() {
        @Override
        public void run() {

            Location location = myPositionGPSData.getPosition();
            mPositionGPSTextView.setText("Longitude="+location.getLongitude()+"\nLatitude ="+location.getLatitude());

            mListPOITextView.setText(getListPOI(mIListPOIs.getPOIs()));

            mNearestPOITextView.setText(findNearestPOI(location,mIListPOIs.getPOIs()).getmName());

            mHandler.postDelayed(this,1000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPositionGPSTextView = (TextView) findViewById(R.id.gps_position_textview);
        mListPOITextView = (TextView) findViewById(R.id.listPOI_textview);
        mNearestPOITextView = (TextView) findViewById(R.id.nearestPOI_textview);
        mMapActivityButton = (Button) findViewById(R.id.map_activity_button);
        mON = (Button) findViewById(R.id.buttonON);
        mOFF = (Button) findViewById(R.id.buttonOFF);
        mSCAN = (Button) findViewById(R.id.buttonSCAN);
        mLOGIN = (Button) findViewById(R.id.buttonLOGIN);
        mLOGOFF = (Button) findViewById(R.id.buttonLOGOFF);

        mMapActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapActivityIntent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(mapActivityIntent);
            }
        });


        myPositionGPSData = new GPSData();
        mIListPOIs = new ListPOIs();

        mHandler = new Handler(Looper.getMainLooper());

    }

    @Override
    protected void onResume() {
        super.onResume();

        mHandler.post(mUIRunnable);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    String getListPOI(HashMap<String, POI> poiHashMap){

        HashMap<String,POI> stringPOIHashMap = poiHashMap;
        String result = "";

        for (Map.Entry<String, POI> entry : stringPOIHashMap.entrySet())
        {
            result = result + "\n" + entry.getValue().getmName()
                    + "  Lg=" + entry.getValue().getmLocation().getLongitude()
                    + "  La=" + entry.getValue().getmLocation().getLatitude();
        }

        return result;
    }
}
