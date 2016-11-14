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
        return rand.nextInt(3);
    }

    public static int convertACToColor(int ACvalue){

        int color = 0x90FFFFFF;

        if (ACvalue==0) {
            color = 0x90FF0000;
        }
        else if (ACvalue==1){
            color = 0x90008000;
        }
        else if (ACvalue==2){
            color = 0x90FFFF00;
        }

        return color;
    }
}
