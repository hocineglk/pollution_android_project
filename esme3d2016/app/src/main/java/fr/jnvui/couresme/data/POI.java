package fr.jnvui.couresme.data;

import android.location.Location;

/**
 * Created by jips on 10/17/16.
 */

public class POI {

    private String mName;
    private String mAddress;
    private Location mLocation;

    public POI(){

    }

    public POI(String name, String address, Location location){
        this.mName = name;                //Nom du POI
        this.mAddress = address;          //Adresse du POI
        this.mLocation = location;        //Notre localisation par rapport au point d'intérêt
    }

    //getteur = accès aux variables de notre objet en lecture

    public String getmName() {
        return mName;
    }

    //setteur = accès aux variables de notre objet en écriture

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAdress() {
        return mAddress;
    }

    public void setmAdress(String mAdress) {
        this.mAddress = mAdress;
    }

    public Location getmLocation() {
        return mLocation;
    }

    public void setmLocation(Location mLocation) {
        this.mLocation = mLocation;
    }
}
