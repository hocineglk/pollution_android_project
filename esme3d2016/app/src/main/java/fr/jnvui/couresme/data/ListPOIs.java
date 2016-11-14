package fr.jnvui.couresme.data;

import java.util.HashMap;

import fr.jnvui.couresme.interfaces.IListPOIs;
import android.location.Location;

/**
 * Created by jips on 10/17/16.
 */

public class ListPOIs implements IListPOIs {

    HashMap<String, POI> mPoiHashMap;

    public ListPOIs() {
        mPoiHashMap = new HashMap<>();
        //getListPOI();
        //fillPOIList();
    }


    //public ArrayList<LatLng> getListPOI(){
    //    ArrayList<LatLng> listPOI = new ArrayList<>();

    //public HashMap<String, POI> getListPOI(){
       // HashMap<String, POI> listPOI = new HashMap<>();

    /*private void fillPOIList() {

        Location l = new Location("POI");
        l.setLatitude(48.842015);
        l.setLongitude(2.31291);
        POI p = new POI(l.getProvider(),"",l);
        mPoiHashMap.put(l.getProvider(),p);

        Location l1 = new Location("POI1");
        l1.setLatitude(48.832751);
        l1.setLongitude(2.311512);
        POI p1 = new POI(l1.getProvider(),"",l1);
        mPoiHashMap.put(l1.getProvider(),p1);

        Location l2 = new Location("POI2");
        l2.setLatitude(48.826793);
        l2.setLongitude(2.339473);
        POI p2 = new POI(l2.getProvider(),"",l2);
        mPoiHashMap.put(l2.getProvider(),p2);

        Location l3 = new Location("POI3");
        l3.setLatitude(48.820057);
        l3.setLongitude(2.364506);
        POI p3 = new POI(l3.getProvider(),"",l3);
        mPoiHashMap.put(l3.getProvider(),p3);

        Location l4 = new Location("POI4");
        l4.setLatitude(48.810705);
        l4.setLongitude(2.382745);
        POI p4 = new POI(l4.getProvider(),"",l4);
        mPoiHashMap.put(l4.getProvider(),p4);

        Location l5 = new Location("POI5");
        l5.setLatitude(48.814013);
        l5.setLongitude(2.395104);
        POI p5 = new POI(l5.getProvider(),"",l5);
        mPoiHashMap.put(l5.getProvider(),p5);


       //mPoiHashMap.put("1",new POI("fr","fr", new Location((48.839728, 2.309856)));POI
       //mPoiHashMap.put("2",new POI("fr","fr", (48.839459, 2.309535));
       //mPoiHashMap.put("3",new POI("fr","fr", (48.838504, 2.311497));
       //mPoiHashMap.put("4",new POI("fr","fr", (48.836351, 2.310213));
       //mPoiHashMap.put("5",new POI("fr","fr", (48.833703, 2.314966));
       //mPoiHashMap.put("6",new POI("fr","fr", (48.830569, 2.319270));
       //mPoiHashMap.put("7",new POI("fr","fr", (48.827779, 2.326695));POI1
       //mPoiHashMap.put("8",new POI("fr","fr", (48.827812, 2.332534));
       //mPoiHashMap.put("9",new POI("fr","fr", (48.826512, 2.341721));
       //mPoiHashMap.put("10",new POI("fr","fr",(48.825669, 2.347134));
       //mPoiHashMap.put("11",new POI("fr","fr",(48.826193, 2.357316));
       //mPoiHashMap.put("12",new POI("fr","fr",(48.826169, 2.360008));
       //mPoiHashMap.put("13",new POI("fr","fr",(48.821598, 2.369152));
       //mPoiHashMap.put("14",new POI("fr","fr",(48.819458, 2.373383));POI2
       //mPoiHashMap.put("15",new POI("fr","fr",(48.818545, 2.374223));
       //mPoiHashMap.put("16",new POI("fr","fr",(48.818277, 2.374938));
       //mPoiHashMap.put("17",new POI("fr","fr",(48.817739, 2.375525));
       //mPoiHashMap.put("18",new POI("fr","fr",(48.818100, 2.376759));
       //mPoiHashMap.put("19",new POI("fr","fr",(48.816771, 2.378160));POI3
       //mPoiHashMap.put("20",new POI("fr","fr",(48.818579, 2.383903));
       //mPoiHashMap.put("21",new POI("fr","fr",(48.815472, 2.386972));
       //mPoiHashMap.put("22",new POI("fr","fr",(48.815444, 2.387771));
       //mPoiHashMap.put("23",new POI("fr","fr",(48.815211, 2.388052));
       //mPoiHashMap.put("24",new POI("fr","fr",(48.815134, 2.388976));
       //mPoiHashMap.put("25",new POI("fr","fr",(48.814541, 2.389557));POI4
       //mPoiHashMap.put("26",new POI("fr","fr",(48.814751, 2.390111));
       //mPoiHashMap.put("27",new POI("fr","fr",(48.814376, 2.390537));
       //mPoiHashMap.put("28",new POI("fr","fr",(48.814729, 2.391599));
       //mPoiHashMap.put("29",new POI("fr","fr",(48.814553, 2.391846));
       //mPoiHashMap.put("30",new POI("fr","fr",(48.814578, 2.394471));
       //mPoiHashMap.put("31",new POI("fr","fr",(48.814246, 2.394868));POI5

       //return listPOI;
    }*/

    @Override
    public HashMap<String, POI> getPOIs() {
        return mPoiHashMap;
    }

}


