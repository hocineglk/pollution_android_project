package fr.jnvui.couresme.data;

import android.location.Location;

import java.util.HashMap;

import fr.jnvui.couresme.interfaces.IListPOIs;

/**
 * Created by jips on 10/17/16.
 */

public class ListPOIs implements IListPOIs {

    HashMap<String, POI> mPoiHashMap;

    public ListPOIs(){

        mPoiHashMap = new HashMap<>();
        fillPOIList();
    }

    private void fillPOIList() {

        double j = 1.159;

        for (int i = 1; i < 200; i++) {
            Location l = new Location("POI"+i);
            j += 0.159;

            if(i%2 == 0){
                l.setLongitude(j-0.30);
            }else {
                l.setLongitude(j+0.30);

            }

            l.setLatitude(j);

            POI p = new POI(l.getProvider(),"",l);

            mPoiHashMap.put(l.getProvider(),p);
        }



    }

    @Override
    public HashMap<String, POI> getPOIs() {
        return mPoiHashMap;
    }
}
