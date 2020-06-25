package Habitation.modele;

public class Habitation {
    private String Proprietaire;
    private String Adresse;
    private double Surface;

    public Habitation(String Proprietaire, String Adresse, double Surface){
        this.Proprietaire=Proprietaire;
        this.Adresse=Adresse;
        this.Surface=Surface;
    }

    public double Impot(){
        return this.Surface*2;
    }

    public void affiche(){
        System.out.println("Proprietaire : "+this.Proprietaire+"\nAdresse : " +this.Adresse + "\nSurface : "+this.Surface);
    }

    public double getSurface() {
        return Surface;
    }



}
