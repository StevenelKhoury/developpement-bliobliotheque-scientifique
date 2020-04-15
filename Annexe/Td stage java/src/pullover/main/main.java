package pullover.main;

import pullover.modele.Pull;
import pullover.modele.Rayon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pull c1 = new Pull(13,12,true,"vert",false);
        Pull c2 = new Pull(13,12,true,"bleu",true);
        Pull c3 = new Pull(13,14,true,"rouge",true);


        Rayon r = new Rayon(c1);
        r.addpull(c2);
        r.addpull(c3);
        System.out.println(r);
        r.triABulle();
        System.out.println(r);
    }


}
