package Habitation.modele;

public class HabitationIndividuelle extends Habitation {
    private int nbpiece;
    private boolean piscine;

    public HabitationIndividuelle(String Proprietaire, String Adresse, double Surface,int nbpiece, boolean piscine){
        super(Proprietaire,Adresse,Surface);
        this.nbpiece=nbpiece;
        this.piscine=piscine;
    }

    @Override
    public double Impot(){
        if(piscine==true){
            return 15*this.nbpiece+80+getSurface()*2;
        }
        else {
            return 15*this.nbpiece+getSurface()*2;
        }
    }

}
