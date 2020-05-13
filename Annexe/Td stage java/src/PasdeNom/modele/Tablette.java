package PasdeNom.modele;

public class Tablette extends Portable{

    boolean _3g;

    public Tablette(int NumSerie, ModuleConnexion moduleConnexion, boolean suppclavier) {
        super(NumSerie, moduleConnexion,suppclavier);
    }





    @Override
    public void identite(){
        System.out.println("je suis une tablette");
    }

    @Override
    public void saisie() {
        if (getSuppClavier() == true) {
            System.out.println("tactile");
        }
        else{
            System.out.println("clavier connectée");
        }
    }
}
