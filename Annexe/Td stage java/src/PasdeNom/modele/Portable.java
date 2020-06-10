package PasdeNom.modele;

import java.sql.SQLOutput;

public class Portable extends Tour {
    private boolean SuppClavier;
    private boolean wifi;

    public Portable(int NumSerie, boolean SuppClavier, boolean wifi) {
        super(NumSerie);
        this.SuppClavier = SuppClavier;
        this.wifi = wifi;
    }

    public boolean getSuppClavier() {
        return this.SuppClavier;
    }

    @Override
    public void identite() {
        System.out.println("je suis un portable");
    }

    @Override
    public void saisie() {
        if (this.SuppClavier == false) {
            System.out.println("clavier interne");
        } else {
            super.saisie();
        }
    }

    public boolean Wifi_AdHoc(Portable p) {
        if (p instanceof Portable){ //
            Portable a = (Portable) p;
            return true;
        }
        return false;
    }

    public boolean wifiAdHoc(Tour a) {
        if (a instanceof Portable) {
            Portable p = (Portable) a;
            if (p.wifi && this.wifi) {
                System.out.println("tu es dans la bonne grace de la wifi");
                return true;
            }
        } System.out.println("pas admissible \n");
        return false;
    }


        public void adHoc (Tour a){
            if (a instanceof Portable) {
                Portable p = (Portable) a;
                if (p.wifi && this.wifi) {
                    System.out.println("Je crois que c'est ça");
                }
            } else super.adHoc(a);
        }

        public void mobile () {
            System.out.println("je suis mobile");
        }

        public void PuissanceSignal (Portable a,float x){
            System.out.println("La force du signal est de "+ x +" pour ce portable qui est du type" +getClass());
        }

        public void ports ( int x, int y){
            System.out.println(x + y);
        }



    }

