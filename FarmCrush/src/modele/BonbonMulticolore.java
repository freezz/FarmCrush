package modele;

/**
 * Définition du Bonbon Multicolore
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class BonbonMulticolore extends Bonbon {
	
   //Constructeurs
	/**
	 * Construit un bobon multicolore et son historique associé
	 * @param c - Couleur
	 */
	public BonbonMulticolore(Couleur c) {
		this.couleur = c;
		this.historique = new Historique();
	}
	
	/**
	 * Desctruction du bonbon
	 * @param g Grille
	 */
	@Override
	public void destruction(Grille g) {
    }

	/**
     * Interagit avec le bonbon passé en parametre pour determiner son comportement
     * @param b Bonbon
     * @param g Grille
     * @return
     */
	@Override
    public boolean interagir(Bonbon b, Grille g) {
		boolean res;
		if(b instanceof BonbonNormal){
			// b est un bonbon normal
			res = b.interagir((BonbonNormal) b, g);
		}
		else if(b instanceof BonbonRaye){
			// b est un bonbon rayé
			res = b.interagir((BonbonRaye) b, g);
		}
		else if (b instanceof BonbonEmballe){
			// b est un bonbon emballé
			res = b.interagir((BonbonEmballe) b, g);
		}
		else if (b instanceof BonbonMulticolore){
			// b est un bonbon multicolore
			res = b.interagir((BonbonMulticolore) b, g);
		}
		else {
			// b est un bonbon inconnu
			res = false;
		}
        return false;
    }
    
    public boolean interagir(BonbonNormal b, Grille g) {
        return true;
    }
    
    public boolean interagir(BonbonRaye b, Grille g) {
        return true;
    }
    
    public boolean interagir(BonbonEmballe b, Grille g) {
        return true;
    }
    
    public boolean interagir(BonbonMulticolore b, Grille g) {
        return true;
    }

	@Override
	public int getValeur() {
		return 0;
	}

	/**
     * Condition de creation d'un bonbon (superbonbon) en examinant 
     * le nombre de bonbon de meme couleur sur la ligne
     * @return nombre de bonbon necessaire a la creation du bonbon
     */
	@Override
	public int getConditionLigne() {
		return 0;
	}

	/**
     * Condition de creation d'un bonbon (superbonbon) en examinant 
     * le nombre de bonbon de meme couleur sur la colonne
     * @return nombre de bonbon necessaire a la creation du bonbon
     */
	@Override
	public int getConditionColonne() {
		return 0;
	}

}
