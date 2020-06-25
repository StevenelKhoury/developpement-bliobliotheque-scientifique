package Habitation.modele;

import java.util.ArrayList;

public class listechaine {

    public Maillon premier;

    public listechaine(Habitation a){
        this.premier=new Maillon(a);
    }


    public void parcoursliste() {
        Maillon inter=premier;
        while (inter != null) {
            System.out.println(inter.a);
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

    public void addMaillon(Habitation a){
        Maillon Inter = new Maillon(a);
        Maillon desole=premier;
        while (desole.next!=null){
            desole=desole.next;
        }
        desole.next=Inter;
    }

    public void addMaillondeb(Habitation a){
        Maillon Inter = new Maillon(a);
        Inter.next=premier;
        premier=Inter;
    }



    private class Maillon {
        Habitation a;
        public Maillon next;


        public Maillon(Habitation a){
            this.a=a;
            this.next=null;
        }

    }
}

// a.next.valeur