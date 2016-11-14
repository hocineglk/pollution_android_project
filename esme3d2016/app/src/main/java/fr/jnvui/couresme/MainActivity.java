package fr.jnvui.couresme;

import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
<<<<<<< HEAD
=======
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
>>>>>>> 0d7444706e33566bd2a3206981e2484eae9c1373
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
<<<<<<< HEAD
=======
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
>>>>>>> 0d7444706e33566bd2a3206981e2484eae9c1373

import fr.jnvui.couresme.activities.MapActivity;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity {

    Button mMapActivityButton;

=======
public class MainActivity extends AppCompatActivity implements OnClickListener {
    //------HANDLER
    Handler mHandler;

    //-------TEXTVIEW
    TextView mPositionGPSTextView;
    TextView mListPOITextView;
    TextView mNearestPOITextView;
    TextView status;

    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;

    //--------BOUTONS
    Button b2,b3;

    //-------ListView
    ListView lv;

    //-------BOUTONS
    Button mMapActivityButton;
    Button changeStatus;

    //------BLUETOOTH
    BluetoothAdapter mBluetoothAdapter;

    //------DATA
    IGPSData myPositionGPSData;

    //------POI
    IListPOIs mIListPOIs;

    Runnable mUIRunnable = new Runnable() {
        @Override
        public void run() {

            Location location = myPositionGPSData.getPosition();
            mPositionGPSTextView.setText("Longitude="+location.getLongitude()+"\nLatitude ="+location.getLatitude());

            //mListPOITextView.setText(getListPOI(mIListPOIs.getPOIs()));

            //mNearestPOITextView.setText(findNearestPOI(location,mIListPOIs.getPOIs()).getmName());

            mHandler.postDelayed(this,1000);
        }
    };


>>>>>>> 0d7444706e33566bd2a3206981e2484eae9c1373
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapActivityButton = (Button) findViewById(R.id.map_activity_button);
<<<<<<< HEAD
=======
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);

        BA = BluetoothAdapter.getDefaultAdapter();
        lv = (ListView)findViewById(R.id.listView);


        //reference to the button BLE
        changeStatus = (Button) findViewById(R.id.changeStatus);
        changeStatus.setOnClickListener(this);
        //reference to the text view BLE
        status = (TextView) findViewById(R.id.status);

//reference to the bluetooth adapter
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //check if adatpter is available, please note if you running
        //this application in emulator currently there is no support for bluetooth
        if(mBluetoothAdapter == null){
            status.setText("BlueTooth adapter not found");
            changeStatus.setText("BlueTooth Disabled");
            changeStatus.setEnabled(false);
            new AlertDialog.Builder(this)
                    .setTitle("Not compatible")
                    .setMessage("Your phone does not support Bluetooth")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        //check the status and set the button text accordingly
        else {
            if (mBluetoothAdapter.isEnabled()) {
                status.setText("BlueTooth is currently switched ON");
                changeStatus.setText("Switch OFF Bluetooth");
            }else{
                status.setText("BlueTooth is currently switched OFF");
                changeStatus.setText("Switch ON Bluetooth");
            }
        }
>>>>>>> 0d7444706e33566bd2a3206981e2484eae9c1373

        mMapActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent mapActivityIntent = new Intent(getApplicationContext(), MapActivity.class);
            startActivity(mapActivityIntent);
            }
        });
    }


    public  void visible(View v){
        if (mBluetoothAdapter.isEnabled()) {
            Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            getVisible.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivityForResult(getVisible, 0);
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle("Warning")
                    .setMessage("Your have to enable Bluetooth !")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }


    public void list(View v){
        pairedDevices = BA.getBondedDevices();

        ArrayList list = new ArrayList();

        if  (mBluetoothAdapter.isEnabled()) {
            for (BluetoothDevice bt : pairedDevices) list.add(bt.getName());
            Toast.makeText(getApplicationContext(), "Showing Paired Devices", Toast.LENGTH_SHORT).show();
            final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle("Warning")
                    .setMessage("Your have to enable Bluetooth !")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
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

<<<<<<< HEAD
}
=======
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
    @Override
    public void onClick(View v) {

       /*     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
                return true;
        }*/


        switch (v.getId()) {

            case R.id.changeStatus:
                //disable the bluetooth adapter
                if (mBluetoothAdapter.isEnabled()) {
                    new AlertDialog.Builder(this)
                            .setTitle("Bluetooth Disconnection")
                            .setMessage("Are you sure to want to stop Bluetooth Connection ?")
                            .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    mBluetoothAdapter.disable();
                                    status.setText("BlueTooth is currently switched OFF");
                                    changeStatus.setText("Switch ON Bluetooth");                                    }
                            })
                            .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
                //enable the bluetooth adapter
                else{
                    new AlertDialog.Builder(this)
                            .setTitle("Bluetooth Autorization")
                            .setMessage("Your App want to use Bluetooth connection. Do you want to activate it ?")
                            .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    mBluetoothAdapter.enable();
                                    status.setText("BlueTooth is currently switched ON");
                                    changeStatus.setText("Switch OFF Bluetooth");
                                }
                            })
                            .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
                break;
            // More buttons go here (if any) ...
        }

    }

}
>>>>>>> 0d7444706e33566bd2a3206981e2484eae9c1373
