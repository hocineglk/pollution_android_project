package fr.jnvui.couresme.data;

import java.util.Random;

import fr.jnvui.couresme.interfaces.ICapteur;

/**
 * Created by magaliegirard on 14/11/2016.
 */

public class Capteur implements ICapteur{

    public Capteur(){

    }

    @Override
    public int getCapteur() {

        Random rand = new Random();
        return rand.nextInt(6);
    }

    public static int convertACToColor(int ACvalue){

        int color = 0xAAFFFFFF;

        if (ACvalue==0) {
            color = 0xAA008000;
        }
        else if (ACvalue==1){
            color = 0xAA99FF99;
        }
        else if (ACvalue==2){
            color = 0xAAFFFF00;
        }
        else if (ACvalue==3){
            color = 0xAAFF9933;
        }
        else if (ACvalue==4){
            color = 0xAAFF6600;
        }
        else if (ACvalue==5){
            color = 0xAAFF0000;
        }

        return color;
    }
}
