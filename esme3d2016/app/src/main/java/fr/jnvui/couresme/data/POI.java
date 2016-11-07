package fr.jnvui.couresme.data;

import android.location.Location;

import fr.jnvui.couresme.interfaces.IPOI;

/**
 * Created by jips on 10/17/16.
 */

public class POI {

    private String mName;
    private String mAdress;
    private Location mLocation;


    public POI(){

    }

    public POI(String name, String adress, Location location){
        this.mName = name;
        this.mAdress = adress;
        this.mLocation = location;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAdress() {
        return mAdress;
    }

    public void setmAdress(String mAdress) {
        this.mAdress = mAdress;
    }

    public Location getmLocation() {
        return mLocation;
    }

    public void setmLocation(Location mLocation) {
        this.mLocation = mLocation;
    }
}
