package pullover.modele;

import java.util.*;

public class Pull implements Comparable<Pull>{

    private final double prix;
    private boolean plie;
    private final String couleur;
    private boolean abime;
    private final double taille;
    private static String modele;
    private static String Marque;


    public Pull(double prix,double taille, boolean plie, String couleur,boolean abime){
        this.prix=prix;
        this.plie=plie;
        this.taille=taille;
        this.couleur=couleur;
        this.abime=abime;
    }

    public boolean getAbime(){
        return this.abime;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("pull \n");

        sb.append(" ").append(this.plie);
        sb.append("\n");
        sb.append("couleur ").append(this.couleur);
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Pull c){
        int result = this.couleur.compareTo(c.couleur);
        return result;
    }







}
//entete des methode, attribut des classe avec leur entetes