package pullover.modele;

import java.util.*;

public class Pull {

    private final double prix;
    private boolean plie;
    private final String couleur;
    private boolean abime;
    private static String modele;
    private static String Marque;


    public Pull(double prix, boolean misenrayon, boolean vendus, boolean plie, String couleur,boolean abime){
        this.prix=prix;
        this.plie=plie;
        this.couleur=couleur;
        this.abime=abime;
    }

    public boolean getabime(){
        return this.abime;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("pull \n");
        sb.append("Pull ").append(this.pull).append('\'');
        sb.append("\n");
        sb.append("mis en rayon ").append(this.misenrayon);
        sb.append("\n");
        sb.append(" ").append(this.plie);
        sb.append("\n");
        sb.append("couleur ").append(this.couleur);
        sb.append("\n");
        return sb.toString();
    }

        compareto //compare to de pullover uniquement la couleur chien de caractère de la couleur (tri à bulle, selection) attribut finale question 7 pas 8


if
}
//entete des methode, attribut des classe avec leur entetes