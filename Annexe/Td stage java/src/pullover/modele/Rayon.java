package pullover.modele;

import java.util.Arrays;
import java.util.Collections;
public class Rayon {
    private static int capacite = 30;
    private Pull tabpull[] = new Pull[1];


    public Rayon(Pull a) {
        this.tabpull[0] = a;
    }

    public boolean addpull(Pull a) { //argument à mettre (type)
        if (this.tabpull.length > this.capacite) {
            System.out.println("pas possible");
            return false;
        } else {
            Pull tmppull[] = new Pull[tabpull.length + 1]; //type nom = new type[taille du tableau]
            System.arraycopy(tabpull, 0, tmppull, 0, tabpull.length + 0);
            tmppull[tmppull.length] = a;
            this.tabpull = tmppull;
            return true;
        }
    }

    public boolean enleveAbime() {
        for (int p = 0; p < tabpull.length; p++) {
            if (tabpull[p].getabime() == true) {
                tabpull[p] = null;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rayon \n");
        for (Pull p: this.tabpull) {
            sb.append(p);
        }
        return sb.toString();
    }
}

