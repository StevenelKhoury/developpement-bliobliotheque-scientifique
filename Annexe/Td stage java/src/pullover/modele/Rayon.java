package pullover.modele;


public class Rayon {
    private static int capacite = 30;
    private Pull tabpull[];


    public Rayon(Pull a) {
        this.tabpull = new Pull[1];
        this.tabpull[0] = a;
    }

    public boolean addpull(Pull a) { //argument à mettre (type)
        if (this.tabpull.length > this.capacite) {
            System.out.println("pas possible");
            return false;
        } else {
            Pull tmppull[] = new Pull[tabpull.length + 1]; //type nom = new type[taille du tableau]
            System.arraycopy(tabpull, 0, tmppull, 0, tabpull.length + 0);
            tmppull[tmppull.length - 1] = a;
            this.tabpull = tmppull;
            return true;
        }
    }

    /*   public boolean enleveAbime(Pull c) { //faire un equals
           for (int p = 0; p < tabpull.length; p++) {
               if (tabpull[p].getabime() == true) {
                   tabpull[p] = null; // recupérer à le prix et en faire la somme des prix

               }
           }
           return true;
       }


       public boolean enleveAbime(String couleur){
         //  equals . equal
       }
   */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rayon \n");
        for (Pull p : this.tabpull) {
            sb.append(p);
        }
        return sb.toString();
    }


    public void triABulle() {
        int taille = this.tabpull.length;
        Pull tmp;
        int i, j;
        for (i = 0; i < taille; i++) {
            for (j = 0; j < taille - 1; j++) {
                if (tabpull[j].compareTo(tabpull[j + 1]) > 0) {
                    tmp = tabpull[j + 1];
                    tabpull[j + 1] = tabpull[j];
                    tabpull[j] = tmp;
                }
            }
        }
    }


    public void triSelect() {
        Pull tmp;
        int taille = this.tabpull.length-1;
        for (int i = 1; i <= taille-1; i++) {
            int m=i;
            for (int j = i + 1; j <= taille; j++)
                if (tabpull[j].compareTo(tabpull[m]) > 0) {
                    m = j;
                    tmp = tabpull[m];
                    tabpull[m] = tabpull[i];
                    tabpull[i] = tmp;
                }
        }
    }

    public int nbcasevide(Pull b){              //deuxieme variable or boucle
        int nbcasevid=0;
        int taille =this.tabpull.length;
        for (int i=0;i<=taille;i++) {
            if (tabpull[i]==null){
                nbcasevid=nbcasevid+1;
            }
        }
        return nbcasevid;
    }

   public void nouveautableau() {
        int i;
        int taille = tabpull.length;
        Pull newtab[] = new Pull[tabpull.length - nbcasevide(tabpull)];
        for (i = 0; i < tabpull.length; i++) {
            for (int j = 0; j < tabpull.length; j++) {
                if (tabpull[i] != null) {
                    newtab[i] = tabpull[i];
                }
            }
        }
    }
}
