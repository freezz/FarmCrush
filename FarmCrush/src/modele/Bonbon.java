package modele;


/**
 * Classe abstraite spécifiant les Bonbons
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public abstract class Bonbon {

    private int conditionNbLigne;
    private int conditionNbColonne;
    private Couleur couleur;
    public Historique historique;


    public Couleur getCouleur() {
    	return this.couleur;
    }

    public abstract int getValeur();


    public abstract void destruction(final Grille g);


    public abstract void interagir(final Grille g);


    private Couleur choisirCouleurRandom() {
        return null;
    }

    public int getConditionLigne() {
        return 0;
    }


    public int getConditionColonne() {
        return 0;
    }

}
