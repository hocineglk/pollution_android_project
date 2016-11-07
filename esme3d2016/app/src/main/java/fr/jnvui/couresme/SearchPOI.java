package fr.jnvui.couresme;

import android.location.Location;

import java.util.HashMap;
import java.util.Map;

import fr.jnvui.couresme.data.POI;

/**
 * Created by jips on 10/17/16.
 */

public class SearchPOI {


    static public POI findNearestPOI(Location myPosition, HashMap<String,POI> poiHashMap){

        POI resultPOI = null;
        float[] distanceBetween = new float[3];
        float nearestDistance = -1;

        for (Map.Entry<String, POI> entry : poiHashMap.entrySet())
        {
            double startLg = myPosition.getLongitude();
            double startLa = myPosition.getLatitude();

            double endLg = entry.getValue().getmLocation().getLongitude();
            double endLa = entry.getValue().getmLocation().getLatitude();

             Location.distanceBetween(startLa,
                    startLg,
                    endLa,
                    endLg,distanceBetween);

            if(nearestDistance > distanceBetween[0] || nearestDistance < 0){
                nearestDistance = distanceBetween[0];
                resultPOI = entry.getValue();
            }


        }

        return resultPOI;
    }
}
