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


    /**
     * Retourne la couleur du bonbon
     * @return Couleur
     */
    public Couleur getCouleur() {
    	return this.couleur;
    }

    /**
     * Retourne la valeur du bonbon courant
     * @return int
     */
    public abstract int getValeur();


    /**
     * Desctruction du bonbon
     * @param g Grille
     */
    public abstract void destruction(Grille g);


    /**
     * Interagit avec le bonbon passé en parametre pour determiner son comportement
     * @param b Bonbon
     * @param g Grille
     * @return
     */
    public abstract boolean interagir(Bonbon b, Grille g);


    /** Genère aléatoirement une couleur de bonbon
	 * @return Couleur
	 */
    private Couleur choisirCouleurRandom() {
    	int code = (int) (Math.random() * 6);
		Couleur color = Couleur.VERT;
		
		switch (code) {
		case 0 :
			color = Couleur.VERT; //Vert
			break;
		case 1 :
			color = Couleur.ROUGE; //Rouge
			break;
		case 2 :
			color = Couleur.BLEU;
			break;
		case 3 :
			color = Couleur.JAUNE;
			break;
		case 4 :
			color = Couleur.ORANGE;
			break;
		case 5	:
			color = Couleur.VIOLET;
			break;
		default:
			//ideal raise une exception mais on ne devrait jamais arriver ici
			System.out.println("La valeur ne correspond à aucune couleur");
			System.out.println(code);
			break;
		}
		
		return color;
    }

    /**
     * Condition de creation d'un bonbon (superbonbon) en examinant 
     * le nombre de bonbon de meme couleur sur la ligne
     * @return nombre de bonbon necessaire a la creation du bonbon
     */
    public abstract int getConditionLigne();


    /**
     * Condition de creation d'un bonbon (superbonbon) en examinant 
     * le nombre de bonbon de meme couleur sur la colonne
     * @return nombre de bonbon necessaire a la creation du bonbon
     */
    public abstract int getConditionColonne();

}
