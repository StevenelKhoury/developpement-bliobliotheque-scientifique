package Livre.main;

import Livre.modele.Livre_simple;
import Livre.modele.Oeuvre;
import Livre.modele.ChefOeuvre;
import Livre.modele.Oeuvre;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        Livre_simple c1 = new Livre_simple("flower power","hyon",1970,"doctorassime");
        Livre_simple c4 = new Livre_simple("flower powers 2000","hyonx",1970,"doctorassime");
        Oeuvre c2 = new Oeuvre("wesh","victor",100,4,true);
        ChefOeuvre c3 = new ChefOeuvre("chef",true,"traou");

        Livre_simple r []={c1,c4};
        Oeuvre a []={c2};
        ChefOeuvre b []={c3};
        System.out.println(Arrays.toString(r));
       // System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
