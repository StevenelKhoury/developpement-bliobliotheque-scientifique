package pullover.modele;

import java.util.*;

public class Pull {
    private String pull;
    private boolean misenrayon;
    private boolean vendus;
    private boolean plie;
    private String couleur;
    private boolean abime;

    public Pull(String pull, boolean misenrayon, boolean vendus, boolean plie, String couleur,boolean abime){
        this.pull=pull;
        this.misenrayon= misenrayon;
        this.vendus=vendus;
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



}
