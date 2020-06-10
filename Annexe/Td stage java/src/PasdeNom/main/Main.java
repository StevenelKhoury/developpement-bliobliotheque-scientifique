package PasdeNom.main;

import PasdeNom.modele.Portable;
import PasdeNom.modele.Tablette;
import PasdeNom.modele.Tour;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tour c1 = new Tour(5);
          Portable a1 = new Portable(51,true,true);
           Tablette d1 = new Tablette(514,true,true,true);

        Tour c []={};
        Portable a []={a1};
        Tablette d []={d1};
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(d));
        Tour b = (Tablette) d1;
        System.out.println(b.getClass());
        Tour.ConnectionsListe(d1);



    }

    }

