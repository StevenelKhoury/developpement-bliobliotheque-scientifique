package PasdeNom.modele;

import java.sql.SQLOutput;

public class Portable extends Tour {
    private boolean SuppClavier;

    public Portable(int NumSerie, ModuleConnexion moduleConnexion, boolean SuppClavier,boolean ActivateWifi, boolean _3gactivate) {
        super(NumSerie,moduleConnexion,ActivateWifi,_3gactivate);
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
        if (this.SuppClavier = true) {
            System.out.println("clavier interne");
        }
        else {
            System.out.println("clavier connectée");
        }
    }

    public boolean Wifi_AdHoc(Tour a){
        if(getActivateWifi()==true){
            System.out.println("tu peux etre dans les bonnes grâce du wifi");
            return true;
        }
        return false;
    }

    public boolean _3GAdHoc(Tour a){
        if(get_3gactivate()==true){
            System.out.println("tu peux etre dans les mauvaises grâce de la 3G");
            return true;
        }
        return false;
    }

    public void AdHoc(Tour a){
        if(_3GAdHoc(a)==true||Wifi_AdHoc(a)==true) System.out.println("admissible");
        else System.out.println("pas admissible");
    }

    public void mobile(){
        System.out.println("je suis mobile");
    }







}
