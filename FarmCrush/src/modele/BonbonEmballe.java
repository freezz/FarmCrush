package modele;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Définition du Bonbon emballé
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class BonbonEmballe extends Bonbon {
	
   //attributs
	private static final Logger loggerBonbonEmballe = LogManager.getLogger("modèle.bonbonEmballé");
   //Constructeurs
	/**
	 * Construit un bonbon emballé et son historique associé
	 * @param c - Couleur
	 */
	public BonbonEmballe(Couleur c){
		this.couleur = c;
		this.historique = new Historique();
	}
	
	/**
     * Desctruction du bonbon
     * @param g Grille
     */
	@Override
	public void destruction(Grille g) {
		/*detruire le bloc (chaque bonbon autour du bonbon a detruire)*/
		//Attention acces bord de tableau...
		//trouver le bonbon dans la grille (recuperer coordonnées)
		Coordonnee c = g.getPositionBonbon(this);
		
		// on supprime les bonbons autour du bonbon emballé
		supBloc(g, false, c);
		
		//effectuer la gravité
		g.effectuerGraviter();
		
		// Check grille ?
		
		//on resupprime le bloc entier (autour + le bonbon) 
		supBloc(g, true, c);
		
		//effectuer la gravité
		g.effectuerGraviter();
		
		//check la grille pour voir s'il n'y a pas d'autre interaction entre bonbon
		g.checkGrille();
    }
	
	/**
	 * Supprime les bonbons autour de coordBonbon (cases adjacentes)
	 * si delBonbonMilieu == true, on supprime egalement le bonbon situé sur coordBonbon
	 * @param coordBonbon
	 */
	private void supBloc(Grille g, boolean delBonbonMilieu, Coordonnee coordBonbon){
		Case[][] cases = g.getTableau();
		int i;
		int j;
		
		// (-1 +1) ( 0 +1) (+1 +1)
		// (-1  0) ( 0  0) (+1  0)
		// (-1 -1) ( 0 -1) (+1 -1)
		//to do : verifier qu'on est pas sur un bord...
		
		for( i = -1 ; i <= 1 ; i++ ) {
			for( j = -1 ;  j <= 1 ; j++){
				if(i != 0 && j != 0){ 
					//on detruit le bonbon situé sur case[coordBonbon.getX() + i][coordBonbon.getX() + j]
					cases[coordBonbon.getX() + i][coordBonbon.getX() + j].getBonbon().destruction(g);
				}
				else{
					// i == 0 && j == 0
					if(delBonbonMilieu){
						cases[coordBonbon.getX() + i][coordBonbon.getX() + j].getBonbon().destruction(g);
					}
					else{
						//on ne detruit pas le bonbon du milieu 
						//donc on ne fait rien
					}
				}
			}
		}
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
			//b est un bonbon normal
			res = b.interagir((BonbonNormal) b, g);
		}
		else if(b instanceof BonbonRaye){
			//b est un bonbon rayé
			res = b.interagir((BonbonRaye) b, g);
		}
		else if (b instanceof BonbonEmballe){
			// b est un bonbon emballé
			res = b.interagir((BonbonEmballe) b, g);
		}
		else {
			//b est un bonbon inconnu
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
    
    public boolean interagir(BonbonEmballe b, Grille g) {
        return true;
    }
    
    /**
     * Condition de creation d'un bonbon (superbonbon) en examinant 
     * le nombre de bonbon de meme couleur sur la ligne
     * @return nombre de bonbon necessaire a la creation du bonbon
     */
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
		return 3;
	}

}
