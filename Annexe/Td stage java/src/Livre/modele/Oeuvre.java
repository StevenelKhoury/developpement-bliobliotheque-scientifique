package Livre.modele;

public class Oeuvre extends Livre_simple  {

     public int critique;
     public boolean recommandation;

     public Oeuvre(String titre,String auteur, int nbpage,int critique,boolean recommandation, String editeur){
         super(titre,auteur,nbpage,editeur);
         this.critique=critique;
         this.recommandation=recommandation;
     }

    public Oeuvre(String titre,String auteur, int nbpage,int critique,boolean recommandation){
        super(titre,auteur,nbpage);
        this.critique=critique;
        this.recommandation=recommandation;
    }
    public Oeuvre(String titre,int critique,boolean recommandation, String editeur){
        super(titre,editeur);
        this.critique=critique;
        this.recommandation=recommandation;
    }

    public int getCritique(){
        return this.critique;
    }

    public boolean getRecommandation(){
        return this.recommandation;
    }


    @Override
    public int Lecture(){
         int p;
         p=super.Lecture();
         return p*2;
    }

    @Override
    public void oh(){
        System.out.println("J'aime les classiques");
    }

    @Override
    public String toString(){

        final StringBuilder c = new StringBuilder("Oeuvre \n");
        c.append(super.toString());
        c.append("\n");
        c.append("critique : ").append(this.critique);
        c.append("\n");
        c.append("recommandation : ").append(this.recommandation);
        return c.toString();
    }

    public boolean like(){
         boolean like;
         int random = 0;
         while (random !=100)
         {
             random = (int)(Math.random()*100);
         }
         if(random>50){
             like=true;
             return like;
         }
         else {
             like=false;
             return like;
         }
    }
}

// specialisation rajouter des fonctionnalités a la methode de la classe mère, super.toString

//faire avec toString