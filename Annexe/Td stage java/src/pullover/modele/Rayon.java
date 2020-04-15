package pullover.modele;


public class Rayon {
    private static int capacite = 30;
    private Pull tabpull[];


    public Rayon(Pull a) {
        this.tabpull= new Pull[1];
        this.tabpull[0] = a;
    }

    public boolean addpull(Pull a) { //argument à mettre (type)
        if (this.tabpull.length > this.capacite) {
            System.out.println("pas possible");
            return false;
        } else {
            Pull tmppull[] = new Pull[tabpull.length + 1]; //type nom = new type[taille du tableau]
            System.arraycopy(tabpull, 0, tmppull, 0, tabpull.length + 0);
            tmppull[tmppull.length-1] = a;
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
        for (Pull p: this.tabpull) {
            sb.append(p);
        }
        return sb.toString();
    }


    public void triABulle(){
        int taille= this.tabpull.length;
        Pull tmp;
        int i,j;
        for(i=0;i<taille;i++) {
            for(j=0;j<taille-1;j++) {
                if(tabpull[j].compareTo(tabpull[j+1])>0) {
                    tmp=tabpull[j+1];
                    tabpull[j+1]=tabpull[j];
                    tabpull[j]=tmp;
                }
            }
        }
    }
    
}

