package fr.jnvui.couresme.data;

import android.location.Location;

import fr.jnvui.couresme.interfaces.IGPSData;

/**
 * Created by jips on 10/17/16.
 */

public class GPSData implements IGPSData {

    String mMyPosition = "myPosition";
    Location mLocation = new Location(mMyPosition);

    //---Thread
    boolean isThreadStart = false;

    public void startThread(){
        isThreadStart = true;
        mThread.start();
    }
    public void stopThread(){
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
            double i=1;
            int maxStep = 200*60;
            int step = 0;

            while (isThreadStart){
                i += 0.15/60;
                step++;
                if(step > maxStep){
                    i=1;
                    step= 0;
                }
                mLocation.setLatitude(i);
                mLocation.setLongitude(i);

                try {
                    Thread.sleep(1000/60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };



    public GPSData(){
        mLocation.setLatitude(12);
        mLocation.setLongitude(18);

        mThread = new Thread(mRunnable);
        startThread();
    }

    @Override
    public Location getPosition() {
        return mLocation;
    }

}
