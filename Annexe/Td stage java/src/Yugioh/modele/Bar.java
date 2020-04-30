package Yugioh.modele;

public class Bar extends debitBoisson{
    private double Surface;
    private String NomDuBar;


    public Bar(String NomSociete,double CA){
        super(NomSociete,CA,4);
        this.Surface=400;
        this.NomDuBar=NomDuBar;
    }

    public Bar(String NomSociete,double CA, int Licence,double Surface,String NomDuBar){
        super(NomSociete,CA,Licence);
        this.Surface=Surface;
        this.NomDuBar=NomDuBar;
    }

    public Bar(double CA, int Licence){
        super("bougnatInter",CA,Licence);
        this.Surface=1000;
        this.NomDuBar=NomDuBar;
    }



    public Bar(String NomSociete,double CA, int Licence){
        Bar("");
    }

    @Override
    public String toString(){

    }




}
