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
                            Thread.sleep(1000);
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

        listCoordonnees.add(new LatLng(48.842015,2.31291));//POI
        listCoordonnees.add(new LatLng(48.839472,2.309526));
        listCoordonnees.add(new LatLng(48.837696,2.307827));
        listCoordonnees.add(new LatLng(48.836472,2.306739));
        listCoordonnees.add(new LatLng(48.83642,2.306693));
        listCoordonnees.add(new LatLng(48.836442,2.306655));
        listCoordonnees.add(new LatLng(48.836454,2.306557));
        listCoordonnees.add(new LatLng(48.836427,2.306479));
        listCoordonnees.add(new LatLng(48.836401,2.306453));
        listCoordonnees.add(new LatLng(48.836318,2.306457));
        listCoordonnees.add(new LatLng(48.836294,2.306485));
        listCoordonnees.add(new LatLng(48.836276,2.306527));
        listCoordonnees.add(new LatLng(48.836272,2.306617));
        listCoordonnees.add(new LatLng(48.836282,2.306653));
        listCoordonnees.add(new LatLng(48.83515,2.30779));
        listCoordonnees.add(new LatLng(48.833773,2.309122));
        listCoordonnees.add(new LatLng(48.833633,2.308986));
        listCoordonnees.add(new LatLng(48.833401,2.309799));
        listCoordonnees.add(new LatLng(48.833308,2.310026));
        listCoordonnees.add(new LatLng(48.832968,2.310887));
        listCoordonnees.add(new LatLng(48.832751,2.311512));//POI1
        listCoordonnees.add(new LatLng(48.831969,2.313554));
        listCoordonnees.add(new LatLng(48.831816,2.314145));
        listCoordonnees.add(new LatLng(48.831316,2.316361));
        listCoordonnees.add(new LatLng(48.831125,2.31714));
        listCoordonnees.add(new LatLng(48.830626,2.318931));
        listCoordonnees.add(new LatLng(48.830524,2.319251));
        listCoordonnees.add(new LatLng(48.827948,2.32639));
        listCoordonnees.add(new LatLng(48.82794,2.326451));
        listCoordonnees.add(new LatLng(48.827952,2.326643));
        listCoordonnees.add(new LatLng(48.827872,2.326639));
        listCoordonnees.add(new LatLng(48.827834,2.326663));
        listCoordonnees.add(new LatLng(48.827786,2.326738));
        listCoordonnees.add(new LatLng(48.827771,2.326798));
        listCoordonnees.add(new LatLng(48.827779,2.326926));
        listCoordonnees.add(new LatLng(48.827802,2.326981));
        listCoordonnees.add(new LatLng(48.827834,2.327023));
        listCoordonnees.add(new LatLng(48.827812,2.332533));
        listCoordonnees.add(new LatLng(48.826793,2.339473));//POI2
        listCoordonnees.add(new LatLng(48.826544,2.341208));
        listCoordonnees.add(new LatLng(48.826478,2.341434));
        listCoordonnees.add(new LatLng(48.826383,2.342));
        listCoordonnees.add(new LatLng(48.826381,2.342181));
        listCoordonnees.add(new LatLng(48.826268,2.343018));
        listCoordonnees.add(new LatLng(48.825939,2.345199));
        listCoordonnees.add(new LatLng(48.82593,2.345347));
        listCoordonnees.add(new LatLng(48.825755,2.346586));
        listCoordonnees.add(new LatLng(48.825664,2.3471));
        listCoordonnees.add(new LatLng(48.825647,2.347294));
        listCoordonnees.add(new LatLng(48.826179,2.357066));
        listCoordonnees.add(new LatLng(48.82619,2.357265));
        listCoordonnees.add(new LatLng(48.818981,2.359508));
        listCoordonnees.add(new LatLng(48.818877,2.359537));
        listCoordonnees.add(new LatLng(48.818896,2.359753));
        listCoordonnees.add(new LatLng(48.819072,2.360958));
        listCoordonnees.add(new LatLng(48.819163,2.36179));
        listCoordonnees.add(new LatLng(48.819209,2.362048));
        listCoordonnees.add(new LatLng(48.819349,2.362339));
        listCoordonnees.add(new LatLng(48.820057,2.364506));//POI3
        listCoordonnees.add(new LatLng(48.820101,2.364636));
        listCoordonnees.add(new LatLng(48.81901,2.365464));
        listCoordonnees.add(new LatLng(48.818904,2.365625));
        listCoordonnees.add(new LatLng(48.817327,2.366863));
        listCoordonnees.add(new LatLng(48.817238,2.366938));
        listCoordonnees.add(new LatLng(48.817114,2.366977));
        listCoordonnees.add(new LatLng(48.816118,2.367781));
        listCoordonnees.add(new LatLng(48.815661,2.368105));
        listCoordonnees.add(new LatLng(48.811793,2.371202));
        listCoordonnees.add(new LatLng(48.807776,2.374291));
        listCoordonnees.add(new LatLng(48.807674,2.374369));
        listCoordonnees.add(new LatLng(48.808495,2.376332));
        listCoordonnees.add(new LatLng(48.809015,2.377401));
        listCoordonnees.add(new LatLng(48.809618,2.378364));
        listCoordonnees.add(new LatLng(48.810482,2.379857));
        listCoordonnees.add(new LatLng(48.810583,2.380031));
        listCoordonnees.add(new LatLng(48.809624,2.380396));
        listCoordonnees.add(new LatLng(48.809544,2.380427));
        listCoordonnees.add(new LatLng(48.810139,2.381765));
        listCoordonnees.add(new LatLng(48.810705,2.382745));//POI4
        listCoordonnees.add(new LatLng(48.81087,2.383314));
        listCoordonnees.add(new LatLng(48.810969,2.38349));
        listCoordonnees.add(new LatLng(48.811046,2.383593));
        listCoordonnees.add(new LatLng(48.811253,2.38398));
        listCoordonnees.add(new LatLng(48.811425,2.384396));
        listCoordonnees.add(new LatLng(48.81169,2.384918));
        listCoordonnees.add(new LatLng(48.812116,2.385873));
        listCoordonnees.add(new LatLng(48.813262,2.388296));
        listCoordonnees.add(new LatLng(48.813322,2.388421));
        listCoordonnees.add(new LatLng(48.811753,2.39004));
        listCoordonnees.add(new LatLng(48.811461,2.39034));
        listCoordonnees.add(new LatLng(48.811737,2.390844));
        listCoordonnees.add(new LatLng(48.812212,2.391782));
        listCoordonnees.add(new LatLng(48.812702,2.392662));
        listCoordonnees.add(new LatLng(48.812914,2.393183));
        listCoordonnees.add(new LatLng(48.81297,2.393319));
        listCoordonnees.add(new LatLng(48.813024,2.393556));
        listCoordonnees.add(new LatLng(48.813708,2.395365));
        listCoordonnees.add(new LatLng(48.813732,2.395429));
        listCoordonnees.add(new LatLng(48.813787,2.395366));
        listCoordonnees.add(new LatLng(48.814013,2.395104));//POI5

        return listCoordonnees;
    }
}