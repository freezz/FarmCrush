package modele;

import modele.BonbonRaye.Axe;

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
		supBloc(g, false, c,1);
		
		//effectuer la gravité
		g.effectuerGraviter();
		
		while(g.checkGrille()){
			g.effectuerGraviter();
		}
		
		//on resupprime le bloc entier (autour + le bonbon) 
		c = g.getPositionBonbon(this);
		supBloc(g, true, c,1);
		
    }
	
	/**
	 * Supprime les bonbons autour de coordBonbon (cases adjacentes)
	 * si delBonbonMilieu == true, on supprime egalement le bonbon situé sur coordBonbon
	 * @param coordBonbon
	 * @param k : taille du rayon de l'explsion du bloc
	 */
	private void supBloc(Grille g, boolean delBonbonMilieu, Coordonnee coordBonbon, int k){
		
				
		// (-1 +1) ( 0 +1) (+1 +1)
		// (-1  0) ( 0  0) (+1  0)
		// (-1 -1) ( 0 -1) (+1 -1)
		//to do : verifier qu'on est pas sur un bord...
		
		for( int i = -k ; i <= k ; i++ ) {
			for( int j = -k ;  j <= k ; j++){
				if(i != 0 && j != 0){ 
					if((coordBonbon.getX() + i) > 0 || (coordBonbon.getX() + i) < g.getColonne() || (coordBonbon.getY() + j) < g.getLigne() || (coordBonbon.getY() + j) > 0){
					//on detruit le bonbon situé sur case[coordBonbon.getX() + i][coordBonbon.getX() + j]
					g.getCase(coordBonbon.getX() + i,coordBonbon.getY() + j).retirerContenu(g);
					}
				}
				else{
					// i == 0 && j == 0
					if(delBonbonMilieu){
						g.getCase(coordBonbon.getX(),coordBonbon.getX()).retirerContenu(g);
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
		loggerBonbonEmballe.trace("On entre dans interaction");
		if(b instanceof BonbonNormal){
			//b est un bonbon normal
			BonbonNormal b1 = (BonbonNormal) b;
			res = this.interagir(b1, g);
		}
		else if(b instanceof BonbonRaye){
			//b est un bonbon rayé
			BonbonRaye b2 = (BonbonRaye) b;
			res = this.interagir(b2, g);
		}
		else if (b instanceof BonbonEmballe){
			// b est un bonbon emballé
			BonbonEmballe b3  = (BonbonEmballe) b;
			res = this.interagir(b3, g);
		}
		else {
			//b est un bonbon inconnu
			res = false;
		}
        return res;
    }
    
    public boolean interagir(BonbonNormal b, Grille g) {
		loggerBonbonEmballe.trace("Avec bonbon normal");
    	boolean action = false;
    	
    	Coordonnee c1 = g.getPositionBonbon(this);
    	Coordonnee c2 = g.getPositionBonbon(b);
    	
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
    
    public boolean interagir(BonbonRaye b, Grille g) {
		loggerBonbonEmballe.trace("Avec bonbon Raye");
		Coordonnee c1 = g.getPositionBonbon(this);
		Coordonnee c2 = g.getPositionBonbon(b);
		
		Bonbon b1 = new BonbonNormal(this.getCouleur());
		Bonbon b2 = new BonbonNormal(b.getCouleur());
		
		g.getCase(c1.getX(), c1.getY()).setBonbon(b1);
		g.getCase(c2.getX(), c2.getY()).setBonbon(b2);
		
		int k1 = 0, k2 = 0;
		
		if(b.getAxe() == Axe.VERTICALE){
			k1 = 1;
			k2 = g.getLigne();
		}
		else if(b.getAxe() == Axe.VERTICALE){
			k1 = g.getColonne();
			k2 = 1;
		}
		else{
			//on ne doit jamais rentrer dedans
			
		}
		
		
		for( int i = -k1 ; i <= k1 ; i++ ) {
			for( int j = -k2 ;  j <= k2 ; j++){
				if(i != 0 && j != 0){ 
					
					if((c1.getX() + i) < g.getColonne() || (c1.getX() + j) > g.getLigne()){
					//on detruit le bonbon situé sur case[coordBonbon.getX() + i][coordBonbon.getX() + j]
					g.getCase(c1.getX() + i,c1.getX() + j).retirerContenu(g);
					}
				}

			}
		}
    	
        return true;
    }
    
    public boolean interagir(BonbonEmballe b, Grille g) {
		loggerBonbonEmballe.trace("Avec bonbon Emballe");
    	Coordonnee c1 = g.getPositionBonbon(this);
		Coordonnee c2 = g.getPositionBonbon(b);
		
		Bonbon b1 = new BonbonNormal(this.getCouleur());
		Bonbon b2 = new BonbonNormal(b.getCouleur());
		
		g.getCase(c1.getX(), c1.getY()).setBonbon(b1);
		g.getCase(c2.getX(), c2.getY()).setBonbon(b2);
		
		// on supprime les bonbons autour du bonbon emballé
		supBloc(g, false, c1,2);
		
		//effectuer la gravité
		g.effectuerGraviter();
		
		while(g.checkGrille()){
			g.effectuerGraviter();
		}
		
		//on resupprime le bloc entier (autour + le bonbon) 
		c1 = g.getPositionBonbon(b1);
		supBloc(g, true, c1,2);
    	
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
