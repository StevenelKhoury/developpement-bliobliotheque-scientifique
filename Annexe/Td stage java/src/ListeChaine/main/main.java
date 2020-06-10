package ListeChaine.main;

import ListeChaine.modele.MaListeChainee;

public class main {

    public static void main(String[] args) {
        MaListeChainee ac = new MaListeChainee(4);
        ac.parcoursliste();
        ac.addMaillon(5);
        ac.parcoursliste();
        ac.addMaillondeb(8);
        ac.parcoursliste();
        ac.deleteMaillon(2);
        ac.parcoursliste();
    }

}
