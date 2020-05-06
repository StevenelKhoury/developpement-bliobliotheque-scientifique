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
        this("fzeuih",4.5);
    }

    @Override
    public void tropStyle(){
        System.out.println(getCA()/Surface);
    }

    @Override
    public String toString(){
        final StringBuilder a = new StringBuilder();
        a.append(super.toString());
        a.append("\n");
        a.append("Surface : ").append(this.Surface);
        a.append("\n");
        a.append("NomDuBar : ").append(this.NomDuBar);
        a.append("\n");
        return a.toString();
    }

}
