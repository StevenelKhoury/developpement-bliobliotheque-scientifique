package Monde.modele;

public class Nom {
    private  String nom;
    private int i=1;

    public Nom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
            sb.append(this.nom);
            return sb.toString();
        }
        }
