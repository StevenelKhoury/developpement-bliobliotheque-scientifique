package PasdeNom.modele;

import java.sql.SQLOutput;

public class Tour {
    private int NumSerie;




    public Tour(int NumSerie) {
        this.NumSerie = NumSerie;
    }




    public static void ConnectionsListe(Tour a) {
       if(a instanceof Tablette){
            Tour t = (Tablette) a;
            System.out.println("Ethernet,3G, wifi");
            return;
        }

        if(a instanceof Portable) {
            Tour t = (Portable) a;
            System.out.println("Ethernet,wifi");
            return;
        }
        if(a instanceof Tour){
        System.out.println("Ethernet");
    }

    }
    public void identite(){
        System.out.println("je suis une tour");
    }

    public void NumSerie(){
        System.out.println(this.NumSerie);
    }

    public void saisie() {
        System.out.println("clavier externe");
    }

    public void ports(int x){
        System.out.println(x);
    }

    public void adHoc(Tour a) {
        System.out.println("cablé branché");
    }
}


//make file sous codeblock a mettre