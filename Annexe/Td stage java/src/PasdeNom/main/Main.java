package PasdeNom.main;

import PasdeNom.modele.ModuleConnexion;
import PasdeNom.modele.Portable;
import PasdeNom.modele.Tablette;
import PasdeNom.modele.Tour;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tour c1 = new Tour(5);
        Portable a1 = new Portable(51, ModuleConnexion.WIfi,true,true,false);
        Tablette d1 = new Tablette(56,ModuleConnexion._3G,true,true,true);

        Tour c []={};
        Portable a []={a1};
        Tablette d []={d1};
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(d));
    }
}
