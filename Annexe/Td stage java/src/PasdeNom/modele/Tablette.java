package PasdeNom.modele;

public class Tablette extends Portable{

    boolean _3g;


    public Tablette(int NumSerie, boolean suppClavier,boolean wifi, boolean _3g) {
        super(NumSerie,suppClavier,wifi);
        this._3g= _3g;
    }


    @Override
    public void identite(){
        System.out.println("je suis une tablette");
    }

    public boolean _3GAdHoc(Tour a){
        if(a instanceof Tablette){
            System.out.println("tu peux etre dans les mauvaises grâce de la 3G");
           return true;
        }
        return false;
    }


    @Override
    public void saisie() {
        if (getSuppClavier() == true) {
            System.out.println("tactile");
        }
        else{
            System.out.println("clavier connectée");
        }
    }

    public void ports(int x,int y,int z){
        System.out.println(x+y+z);
    }


}


//faire liste chainé

//essayer de faire la classe habitation

