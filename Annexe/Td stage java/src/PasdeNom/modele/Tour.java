package PasdeNom.modele;

import java.sql.SQLOutput;

public class Tour {
    private int NumSerie;
    // private  3G
    private ModuleConnexion moduleConnexion;
    private boolean ActivateWifi;
    private boolean _3gactivate;


    public Tour(int NumSerie,ModuleConnexion moduleConnexion,boolean ActivateWifi, boolean _3gactivate) {
        this.NumSerie = NumSerie;
        this.moduleConnexion=moduleConnexion;
        this.ActivateWifi=ActivateWifi;
        this._3gactivate=_3gactivate;
    }

    public Tour(int NumSerie){
        this.NumSerie=NumSerie;
        this.moduleConnexion=ModuleConnexion.Ethernet;
        this.ActivateWifi=false;
        this._3gactivate=false;
    }

    public boolean getActivateWifi(){
        return this.ActivateWifi;
    }

    public boolean get_3gactivate(){
        return this._3gactivate;
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