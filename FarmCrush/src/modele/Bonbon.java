package modele;


/**
 * Classe abstraite spécifiant les Bonbons
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public abstract class Bonbon {

    protected Couleur couleur;
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
     * @return boolean
     */
    public abstract boolean interagir(Bonbon b, Grille g);


    /** Genère aléatoirement une couleur de bonbon
	 * @return Couleur
	 * @exception RuntimeException
	 */
    protected Couleur choisirCouleurRandom() throws RuntimeException {
    	int code = (int) (Math.random() * 6);
		Couleur color = Couleur.VERT;
		
		switch (code) {
		case 0 :
			color = Couleur.VERT;
			break;
		case 1 :
			color = Couleur.ROUGE;
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
			throw new RuntimeException("Couleur Inexistante");
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
    
    
    /**
     *Ajoute de nouvelle coordonnées a l historique d'un bonbon
     *
     *@param c : nouvel coordonne a ajouter
     */
    public void ajoutCoordonneHistorique(Coordonnee c){
    	if(historique.histAdd(c)){
    		//
    	}
    	else{
    		//ajouter log comme quoi il y a une erreur au niveau de l ajout dans l historique
    	}
    }

    
    
    /**
     *Ajoute de nouvelle coordonnées a l historique d'un bonbon
     *
     *@param i : abscisse a ajouter
     *@param j : ordonne a ajouter
     */
    public void ajoutCoordonneHistorique(int i, int j){
    	Coordonnee c = new Coordonnee(i, j);
    	if(historique.histAdd(c)){
    		//
    	}
    	else{
    		//ajouter log comme quoi il y a une erreur au niveau de l ajout dans l historique
    	}
    }
}
