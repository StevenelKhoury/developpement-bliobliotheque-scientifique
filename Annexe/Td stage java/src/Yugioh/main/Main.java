package Yugioh.main;

import Yugioh.modele.debitBoisson;
import Yugioh.modele.Bar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bar c1 = new Bar("little flower",62000,4,110.0,"Travail");
        debitBoisson c2 = new debitBoisson(12000.0,15);

        Bar b []={c1};
        debitBoisson d []={c2};
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(d));
    }


}