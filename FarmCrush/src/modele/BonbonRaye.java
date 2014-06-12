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
	
	/**
	 * Sens de destruction du bonbon rayé (verticale/horizontale)
	 */
	private enum Axe{VERTICALE, HORIZONTALE};
	private Axe sensDestruction;

   //Attributs
	private static final Logger loggerBonbonRaye = LogManager.getLogger("modèle.bonbonRayé");


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
		
		/*detruire la ligne/colonne ou il y a le bonbon*/
		//trouver le bonbon dans la grille (recuperer coordonnées)
		Coordonnee c = g.getPositionBonbon(this);
		
		// ON supprime la ligne ou la colonne ou se trouve le bonbon rayé
		supLigneColonneGrille(g, this.sensDestruction, c);
		
		//effectuer la gravité
		g.effectuerGraviter();
		
		//check la grille pour voir s'il n'y a pas d'autre interaction entre bonbon
		g.checkGrille();
    }
	
	/**
	 * Supprime une ligne ou une colonne de la ligne
	 * @param g
	 */
	private void supLigneColonneGrille(Grille g, Axe a, Coordonnee coordBonbon){
		Case[][] cases = g.getTableau();
		int i;
		int ligne = coordBonbon.getY();
		int colonne = coordBonbon.getY();
		switch (a) {
		case VERTICALE :
			//supprimer colonne
			for(i = 0 ; i <= g.getLigne() ; i++) {
				cases[i][coordBonbon.getX()].getBonbon().destruction(g);// g ou null ?
			}
			break;
			
		case HORIZONTALE :
			//supprimer ligne
			for(i = 0 ; i <= g.getColonne() ; i++) {
				cases[coordBonbon.getY()][i].getBonbon().destruction(g);// g ou null ?
			}
			break;

		default:
			//logger erreur
			break;
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
		return 4;
	}

	/**
     * Condition de creation d'un bonbon (superbonbon) en examinant 
     * le nombre de bonbon de meme couleur sur la colonne
     * @return nombre de bonbon necessaire a la creation du bonbon
     */
	@Override
	public int getConditionColonne() {
		return 4;
	}

}
