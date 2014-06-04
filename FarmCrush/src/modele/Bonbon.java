package modele;




public abstract class Bonbon {

    private int conditionNbLigne;


    private int conditionNbColonne;

    private Couleur couleur;


    public Historique historique;


    public void getCouleur() {
    }

    public abstract static int getValeur();


    public abstract void destruction(final Grille g);


    public abstract void interagir(final Grille g);


    private Couleur choisirCouleurRandom() {
        // TODO Auto-generated return
        return null;
    }


    public int getConditionLigne() {
        // TODO Auto-generated return
        return 0;
    }


    public int getConditionColonne() {
        // TODO Auto-generated return
        return 0;
    }

}
