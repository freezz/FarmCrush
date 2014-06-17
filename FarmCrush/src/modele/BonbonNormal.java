package modele;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Définition du Bonbon normal, bonbon standard
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class BonbonNormal extends Bonbon {
	
   //Attributs
	private static final Logger loggerBonbonNormal = LogManager.getLogger("modèle.bonbonNormal");

   //Constructeurs
	/**
	 * Construit un bonbon normal et son historique
	 * @param c - Couleur
	 */
	public BonbonNormal(Couleur c) {
		this.couleur = c;
		//historique
		this.historique = new Historique();
		// nb ligne et colonne condition ?
		
	}
	
	/**
     * Desctruction du bonbon
     * @param g Grille
     */
	@Override
	public void destruction(Grille g) {
		//trouver le bonbon dans la grille (recuperer coordonnées)
		Coordonnee c = g.getPositionBonbon(this);
		
		//retirer le bonbon de la grille
		g.supprimerBonbonCase(c);
		
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
		loggerBonbonNormal.trace("On entre dans interaction");
		if(b instanceof BonbonNormal){
			// b est un bonbon normal
			BonbonNormal b1 = (BonbonNormal) b;
			res = this.interagir(b1, g);
		}
		else {
			// b est un bonbon inconnu
			res = false;
		}
        return res;
    }
    
    public boolean interagir(BonbonNormal b, Grille g) {
		loggerBonbonNormal.trace("Avec bonbon normal");
    	boolean action = false;

    	
    	Coordonnee c1 = g.getPositionBonbon(this);
    	Coordonnee c2 = g.getPositionBonbon(b);
    	loggerBonbonNormal.trace("pb a la source {}{}",c1.getX(),c1.getY());
    	loggerBonbonNormal.trace("pb a la source {}{}",c2.getX(),c2.getY());
    	
    	Bonbon stock = b;
    	
    	//changement de position entre les deux bonbons
    	g.getCase(c2.getX(), c2.getY()).setBonbon(this);
    	g.getCase(c1.getX(), c1.getY()).setBonbon(stock);
    	
    	if(g.checkInteraction(c1)){
    		action = true;
    	}
    	else if(g.checkInteraction(c2)){
    		action = true;
    	}
    	else{
    		//si aucune interection marche, on revient a la normale
        	g.getCase(c2.getX(), c2.getY()).setBonbon(stock);
        	g.getCase(c1.getX(), c1.getY()).setBonbon(this);
    	}
    	

		return action;
        
        
        
        
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
		return 3;
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
