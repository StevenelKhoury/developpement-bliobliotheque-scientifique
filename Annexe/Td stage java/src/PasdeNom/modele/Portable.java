package PasdeNom.modele;

import java.sql.SQLOutput;

public class Portable extends Tour {
    private boolean SuppClavier;

    public Portable(int NumSerie, boolean SuppClavier,boolean ActivateWifi, boolean _3gactivate) {
        super(NumSerie, moduleConnexion,ActivateWifi,_3gactivate);
        this.SuppClavier = SuppClavier;
    }

    public boolean getSuppClavier(){
        return this.SuppClavier;
    }

    @Override
    public void identite(){
        System.out.println("je suis un portable");
    }

    @Override
    public void saisie() {
        if (this.SuppClavier == false) {
            System.out.println("clavier interne");
        }
        else {
            super.saisie();
        }
    }

    public boolean Wifi_AdHoc(Tour a){
        if(getActivateWifi()){ //
            System.out.println("tu peux etre dans les bonnes grâce du wifi");
            return true;
        }
        return false;
    }


    public void AdHoc(Tour a){
        if(Wifi_AdHoc(a)==true)
            System.out.println("admissible");
        else System.out.println("pas admissible");
    }

    public void mobile(){
        System.out.println("je suis mobile");
    }

    public void PuissanceSignal(Portable a, float b){
        System.out.println("La force du signal est de X pour ce portable qui est du type ");
    }

    public void ports(int x,int y){
        System.out.println(x+y);
    }

}
