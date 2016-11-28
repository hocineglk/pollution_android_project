package fr.jnvui.couresme.data;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import fr.jnvui.couresme.interfaces.IGPSData;

/**
 * Created by jips on 10/17/16.
 */

public class GPSData implements IGPSData {

    String mMyPosition = "myPosition";

    Location mLocation = new Location(mMyPosition);

    ArrayList<LatLng> listCoordonnees = new ArrayList<>();

    //---Thread
    boolean isThreadStart = false;

    public void startThread() {
        isThreadStart = true;
        mThread.start();
    }

    public void stopThread() {
        isThreadStart = false;
        try {
            mThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Thread mThread;

    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

            while (isThreadStart) {

                    for (LatLng latLng:listCoordonnees) {

                        mLocation.setLatitude(latLng.latitude);
                        mLocation.setLongitude(latLng.longitude);

                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
    };

    public GPSData() {
        mLocation.setLatitude(48.842015);
        mLocation.setLongitude(2.31291);
        getLatlngs();

        mThread = new Thread(mRunnable);
    }

    @Override
    public Location getPosition() {
        return mLocation;
    }

    public ArrayList<LatLng> getLatlngs() {

        listCoordonnees.add(new LatLng(48.842015, 2.31291));
        listCoordonnees.add(new LatLng(48.839472, 2.309526));
        listCoordonnees.add(new LatLng(48.837696, 2.307827));
        listCoordonnees.add(new LatLng(48.836472, 2.306739));
        listCoordonnees.add(new LatLng(48.83515, 2.30779));
        listCoordonnees.add(new LatLng(48.833773, 2.309122));
        listCoordonnees.add(new LatLng(48.833633, 2.308986));
        listCoordonnees.add(new LatLng(48.833401, 2.309799));
        listCoordonnees.add(new LatLng(48.833308, 2.310026));
        listCoordonnees.add(new LatLng(48.832968, 2.310887));
        listCoordonnees.add(new LatLng(48.832751, 2.311512));
        listCoordonnees.add(new LatLng(48.831969, 2.313554));
        listCoordonnees.add(new LatLng(48.831816, 2.314145));
        listCoordonnees.add(new LatLng(48.831316, 2.316361));
        listCoordonnees.add(new LatLng(48.831125, 2.31714));
        listCoordonnees.add(new LatLng(48.830626, 2.318931));
        listCoordonnees.add(new LatLng(48.830524, 2.319251));
        listCoordonnees.add(new LatLng(48.829524, 2.321251));
        listCoordonnees.add(new LatLng(48.828524, 2.323251));
        listCoordonnees.add(new LatLng(48.827948, 2.32639));
        listCoordonnees.add(new LatLng(48.827834, 2.327023));
        listCoordonnees.add(new LatLng(48.827812, 2.332533));
        listCoordonnees.add(new LatLng(48.826793, 2.339473));
        listCoordonnees.add(new LatLng(48.826544, 2.341208));
        listCoordonnees.add(new LatLng(48.826478, 2.341434));
        listCoordonnees.add(new LatLng(48.826383, 2.342));
        listCoordonnees.add(new LatLng(48.826268, 2.343018));
        listCoordonnees.add(new LatLng(48.825939, 2.345199));
        listCoordonnees.add(new LatLng(48.825755, 2.346586));
        listCoordonnees.add(new LatLng(48.825664, 2.3471));
        listCoordonnees.add(new LatLng(48.825647, 2.347294));
        listCoordonnees.add(new LatLng(48.826179, 2.357066));
        listCoordonnees.add(new LatLng(48.818981, 2.359508));
        listCoordonnees.add(new LatLng(48.819072, 2.360958));
        listCoordonnees.add(new LatLng(48.819163, 2.36179));
        listCoordonnees.add(new LatLng(48.819209, 2.362048));
        listCoordonnees.add(new LatLng(48.820057, 2.364506));
        listCoordonnees.add(new LatLng(48.81901, 2.365464));
        listCoordonnees.add(new LatLng(48.818904, 2.365625));
        listCoordonnees.add(new LatLng(48.817327, 2.366863));
        listCoordonnees.add(new LatLng(48.816118, 2.367781));
        listCoordonnees.add(new LatLng(48.815661, 2.368105));
        listCoordonnees.add(new LatLng(48.811793, 2.371202));
        listCoordonnees.add(new LatLng(48.807776, 2.374291));
        listCoordonnees.add(new LatLng(48.808495, 2.376332));
        listCoordonnees.add(new LatLng(48.809015, 2.377401));
        listCoordonnees.add(new LatLng(48.809618, 2.378364));
        listCoordonnees.add(new LatLng(48.810482, 2.379857));
        listCoordonnees.add(new LatLng(48.810583, 2.380031));
        listCoordonnees.add(new LatLng(48.809624, 2.380396));
        listCoordonnees.add(new LatLng(48.810139, 2.381765));
        listCoordonnees.add(new LatLng(48.810705, 2.382745));
        listCoordonnees.add(new LatLng(48.81087, 2.383314));
        listCoordonnees.add(new LatLng(48.811046, 2.383593));
        listCoordonnees.add(new LatLng(48.811425, 2.384396));
        listCoordonnees.add(new LatLng(48.812116, 2.385873));
        listCoordonnees.add(new LatLng(48.813262, 2.388296));
        listCoordonnees.add(new LatLng(48.811753, 2.39004));
        listCoordonnees.add(new LatLng(48.812212, 2.391782));
        listCoordonnees.add(new LatLng(48.812702, 2.392662));
        listCoordonnees.add(new LatLng(48.812914, 2.393183));
        listCoordonnees.add(new LatLng(48.813024, 2.393556));
        listCoordonnees.add(new LatLng(48.813708, 2.395365));
        listCoordonnees.add(new LatLng(48.814013, 2.395104));

        return listCoordonnees;
    }
}