package Habitation.modele;

public class HabitationPro extends Habitation {
    private int nbemploye;

    public HabitationPro(String Proprietaire, String Adresse, double Surface,int nbpiece,double surface_h, boolean piscine){
        super(Proprietaire,Adresse,Surface);
        this.nbemploye=nbemploye;
    }

    @Override
    public double Impot(){
        int a;
        a=nbemploye/10;
        return getSurface()*2+150*a;
    }

}
