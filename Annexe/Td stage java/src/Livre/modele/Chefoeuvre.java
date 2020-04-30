package Livre.modele;
import java.util.Random;

public class Chefoeuvre extends Oeuvre {

    private float popularity;


    public Chefoeuvre(String titre, String auteur, int nbpage, int critique, boolean recommandation, float popularity, String editeur) {
        super(titre, auteur, nbpage, critique, recommandation, editeur);
        this.popularity = popularity;
    }

    public Chefoeuvre(String titre, String auteur, int nbpage, boolean recommandation) {
        super(titre, auteur, nbpage, 3, recommandation);
        this.popularity = 50;
    }

    public Chefoeuvre(String titre, boolean recommandation, String editeur) {
        super(titre, 2, recommandation, editeur);
        this.popularity = 60;
    }


    @Override
    public int Lecture(){
        int p;
        p=super.Lecture();
        return p*3/4;
    }


    @Override
    public void oh(){
        System.out.println("Ah que c'est beau");
    }

    @Override
    public String toString() {
        final StringBuilder b = new StringBuilder("Chef d'oeuvre \n");
        b.append(super.toString());
        b.append("\n");
        b.append("popularité : ").append(this.popularity);
        return b.toString();
    }

    @Override
    public boolean like(){
        boolean like;
        int random = 0;
        random = (int)(Math.random()*100);
        System.out.println(random);
        if(random<70){
            like=true;
            return like;
        }
        else {
            like=false;
            return like;
        }
    }
}

