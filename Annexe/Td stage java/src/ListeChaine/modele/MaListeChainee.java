package ListeChaine.modele;

import java.util.ArrayList;

public class MaListeChainee {

    public Maillon premier;

    public MaListeChainee(int valeur){
        this.premier=new Maillon(valeur);
    }


    public void parcoursliste() {
        Maillon inter=premier;
        while (inter != null) {
            System.out.println(inter.valeur);
            inter=inter.next;
        }
    }

    public void deleteMaillon(int i){
        Maillon inter=premier;
        int j=1;
        while (j<i){
            j++;
            inter=inter.next;
        }
        inter= null;
    }

    public void addMaillon(int valeur){
         Maillon Inter = new Maillon(valeur);
         Maillon desole=premier;
         while (desole.next!=null){
             desole=desole.next;
         }
         desole.next=Inter;
    }

    public void addMaillondeb(int valeur){
        Maillon Inter = new Maillon(valeur);
        Inter.next=premier;
        premier=Inter;
    }



    private class Maillon {
        int valeur;
        public Maillon next;


        public Maillon(int valeur){
            this.valeur=valeur;
            this.next=null;
        }


        public void insertdeb(Maillon b,String inseree){


        }


    }
}

// a.next.valeur