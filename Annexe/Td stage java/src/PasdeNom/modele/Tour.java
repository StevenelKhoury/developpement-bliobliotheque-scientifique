package PasdeNom.modele;

import java.sql.SQLOutput;

public class Tour {
    private int NumSerie;
    // private  3G

    private boolean ActivateWifi;
    private boolean _3gactivate;


    public Tour(int NumSerie,,boolean ActivateWifi, boolean _3gactivate) {
        this.NumSerie = NumSerie;
        this.ActivateWifi=ActivateWifi;
        this._3gactivate=_3gactivate;
    }

    public Tour(int NumSerie){
        this.NumSerie=NumSerie;

        this.ActivateWifi=false;
        this._3gactivate=false;
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

}


//make file sous codeblock a mettre