package modele;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Définition du Bonbon rayé
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class BonbonRaye extends Bonbon {
	
	private static final Logger loggerBonbonRaye = LogManager.getLogger("modèle.bonbonRayé");
   //Attributs

   //Constructeurs
	/**
	 * Construit un bonbon rayé et son historique associé
	 * @param c - Couleur
	 */
	public BonbonRaye(Couleur c) {
		this.couleur = c;
		this.historique = new Historique();
	}

	/**
     * Desctruction du bonbon
     * @param g Grille
     */
	@Override
    public void destruction(Grille g) {
		int i = 0;
		int j = 0;
		
		/*detruire la ligne ou il y a le bonbon*/
		Case[][] cases = g.getTableau();
		//trouver le bonbon dans la grille (recuperer coordonnées)
		
		
		
		//effectuer la gravité
		
		//check la grille pour voir s'il n'y a pas d'autre interaction entre bonbon
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
			// b est un bonbon raye
			res = b.interagir((BonbonRaye) b, g);
		}
		else {
			// b est un bonbon inconnu
			res = false;
		}
        return res;
    }
    
    public boolean interagir(BonbonNormal b, Grille g) {
        return true;
    }
    
    public boolean interagir(BonbonRaye b, Grille g) {
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
