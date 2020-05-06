package PasdeNom.modele;

public class Tour {
    private int NumSerie;
    private String Clavier;
    private String ModuleConnexion;



    public Tour(int NumSerie,String Clavier, String ModuleConnexion,boolean mobile) {
        this.NumSerie = NumSerie;
        this.Clavier = Clavier;
        this.ModuleConnexion= ModuleConnexion;
    }

    public void identite(){
        System.out.println("je suis une tour");
    }

    public void NumSerie(){
        System.out.println(this.NumSerie);
    }


}
