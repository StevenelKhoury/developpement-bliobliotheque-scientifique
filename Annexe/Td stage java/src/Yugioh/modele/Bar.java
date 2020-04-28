package Yugioh.modele;

public class Bar extends debitBoisson{
    private double Surface;
    private String NomDuBar;

    public Bar(String NomSociete,double CA, int Licence,double Surface,String NomDuBar){
        super(NomSociete,CA,Licence);
        this.Surface=Surface;
        this.NomDuBar=NomDuBar;
        System.out.println("noob4");
    }

    public Bar(String NomSociete,double CA){
        super(NomSociete,CA);
        this.Licence=4;
        this.Surface=Surface;
        this.NomDuBar=NomDuBar;
        System.out.println("noob5");
    }

    public Bar(String NomSociete,double CA, int Licence){
        super(NomSociete,CA,Licence);
        this.Surface=Surface;
        this.NomDuBar=NomDuBar;
        System.out.println("noob5");
    }

}
