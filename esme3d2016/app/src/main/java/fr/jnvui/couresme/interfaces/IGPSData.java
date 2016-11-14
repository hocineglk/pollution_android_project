package fr.jnvui.couresme.interfaces;

import android.location.Location;

import fr.jnvui.couresme.data.GPSData;

/**
 * Created by jips on 10/17/16.
 */

public interface IGPSData {

    Location getPosition();

    void startThread();
}
