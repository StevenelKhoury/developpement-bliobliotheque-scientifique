package Livre.modele;

public class Livre_simple {
    private String titre;
    private String auteur;
    private int nbpage;
    private String editeur;


    public Livre_simple(String titre,String auteur,int nbpage,String editeur){
        this.titre=titre;
        this.auteur=auteur;
        this.nbpage=nbpage;
        this.editeur=editeur;
    }

    public Livre_simple(String titre,String auteur,int nbpage){
        this.titre=titre;
        this.auteur=auteur;
        this.nbpage=nbpage;
        this.editeur="pressUni";
    }

    public Livre_simple(String titre,String editeur){
        this.titre=titre;
        this.auteur="Melanie";
        this.nbpage=501;
        this.editeur=editeur;
    }

    public int Lecture(){
        int p;
        p=this.nbpage;
        return p;
    }

    public String getTitre(){
        return this.titre;
    }

    public String getAuteur(){
        return this.auteur;
    }

    public String getEditeur(){
        return this.editeur;
    }

    public int getNbPage(){
        return this.nbpage;
    }



    public void oh(){
        System.out.println("oh un livre");
    }

    @Override
    public String toString(){
        final StringBuilder a = new StringBuilder();
        a.append(" titre : ").append(this.titre);
        a.append("\n");
        a.append("auteur : ").append(this.auteur);
        a.append("\n");
        a.append("nombre de pages : ").append(this.nbpage);
        a.append("\n");
        a.append("editeur : ").append(this.editeur);
        a.append("\n");
        a.append("wesh :").append(this.Lecture());

        return a.toString();
    }



}
