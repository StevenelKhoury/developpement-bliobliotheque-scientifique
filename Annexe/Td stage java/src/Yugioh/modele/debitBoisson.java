package Yugioh.modele;

public class debitBoisson {
    private String NomSociete;
    private double CA;
    private int Licence;



    public debitBoisson(String NomSociete,double CA, int Licence){
        this.NomSociete=NomSociete;
        this.CA=CA;
        this.Licence=Licence;
        System.out.println("noob");
    }

    public debitBoisson(double CA,int Licence){
        this.NomSociete="bougnatInternational";
        this.CA=CA;
        this.Licence=Licence;
        System.out.println("noob2");
    }

    public debitBoisson(String NomSociete,double CA){
        this.NomSociete=NomSociete;
        this.CA=CA;
        this.Licence=4;
        System.out.println("noob3");
    }

    public int getLicence(){
        return this.Licence;
    }
    public double getCA(){
        return this.CA;
    }


    public void tropStyle(){
        System.out.println(CA/Licence);
    }

    public String toString(){
        final StringBuilder a = new StringBuilder();
        a.append("Nom de la Societe : ").append(this.NomSociete);
        a.append("\n");
        a.append("Chiffre d'Affaire : ").append(this.CA);
        a.append("\n");
        a.append("Licence : ").append(this.Licence);
        return a.toString();
    }

}
