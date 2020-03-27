package Monde.main;

import java.util.ArrayList;
import Monde.modele.Nom;
import java.util.List;


public class MondeMain {
    public static void main(String[] args) {
        int i=0;
        List<Nom> listeNom = new ArrayList<>();
        Nom C1 = new Nom("Emmanuel");
        Nom C2 = new Nom("Cecile");
        Nom C3 = new Nom("Pierre");
        Nom C4 = new Nom("Laurent");

        listeNom.add(C1);
        listeNom.add(C2);
        listeNom.add(C3);
        listeNom.add(C4);
        for (Nom e : listeNom) {
            i=i+1;
            System.out.println(i+" hello "+ e.toString());
        }
    }
}

