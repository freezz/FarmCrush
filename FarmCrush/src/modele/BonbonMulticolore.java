package modele;

import modele.BonbonRaye.Axe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Définition du Bonbon Multicolore
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class BonbonMulticolore extends Bonbon {
	

	private static final Logger loggerBonbonMulticolore = LogManager.getLogger("modèle.bonbonMulticolore");
	
	//Attributs
	
   //Constructeurs
	/**
	 * Construit un bobon multicolore et son historique associé
	 * @param c - Couleur
	 */
	public BonbonMulticolore() {
		this.couleur = Couleur.MULTI;
		this.historique = new Historique();
	}
	
	/**
	 * Desctruction du bonbon
	 * @param g Grille
	 */
	@Override
	public void destruction(Grille g) {
		/*detruire le bonbon ayant une couleur au hasard*/
		Coordonnee c1 = g.getPositionBonbon(this);
		
		g.supprimerBonbonCase(c1);
		//detruire tout les bonbons d'une certaine couleur
		delAllBonbonCouleur(g, this.choisirCouleurRandom());
		
		//On notifie les observers quil faut mettre a jour les objectifs
		this.setChanged();
		this.notifyObservers(this.getValeur());
    }
	
	/**
	 * Supprime tout les bonbon de couleur c de la grille
	 * @param g
	 * @param c
	 */
	private void delAllBonbonCouleur(Grille g, Couleur c){
		
		// parcourir toute la grille et supprimer chaque bonbon de couleur c
		for(int i = 0 ; i < g.getColonne() ; i++){
			for(int j = 0 ; j < g.getLigne() ; j++){
				if(!g.BonbonNull(new Coordonnee(i,j)) && g.getCase(i, j).getBonbon().getCouleur() == c){
					//il sagit d'un bonbon de la couleur a supprimer
					g.getCase(i, j).retirerContenu(g);
				}
				else{
					//ce n'est pas la bonne couleur
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
		boolean res = false;
		loggerBonbonMulticolore.trace("On entre dans interaction");
		if(b instanceof BonbonNormal){
			// b est un bonbon normal
			BonbonNormal b1 = (BonbonNormal) b;
			res = this.interagir(b1, g);
		}
		else if(b instanceof BonbonRaye){
			// b est un bonbon rayé
			BonbonRaye b2 = (BonbonRaye) b;
			res = this.interagir(b2, g);
		}
		else if (b instanceof BonbonEmballe){
			// b est un bonbon emballé
			BonbonEmballe b3  = (BonbonEmballe) b;
			res = this.interagir(b3, g);
		}
		else if (b instanceof BonbonMulticolore){
			// b est un bonbon multicolore
			BonbonMulticolore b4  = (BonbonMulticolore) b;
			res = this.interagir(b4, g);
		}
		else {
			// b est un bonbon inconnu
			res = false;
		}
        return res;
    }
    
    public boolean interagir(BonbonNormal b, Grille g) {
		loggerBonbonMulticolore.trace("Avec bonbon normal");
		Coordonnee c1 = g.getPositionBonbon(this);
		
		g.supprimerBonbonCase(c1);
		
    	delAllBonbonCouleur(g, b.getCouleur());
    	loggerBonbonMulticolore.trace("passe par la");
        return true;
    }
    
    public boolean interagir(BonbonRaye b, Grille g) {
		loggerBonbonMulticolore.trace("Avec bonbon Raye");
		Coordonnee c1 = g.getPositionBonbon(this);
		
		g.supprimerBonbonCase(c1);
		
		for(int i = 0 ; i < g.getLigne() ; i++){
			for(int j = 0 ; j < g.getColonne() ; j++){
				if(!g.BonbonNull(new Coordonnee(i,j)) && g.getCase(i, j).getBonbon().getCouleur() == b.getCouleur()){
					//il sagit d'un bonbon de la couleur a transformer en bonbon 
					g.getCase(i, j).setBonbon(new BonbonRaye(b.getCouleur(), Axe.VERTICALE));
				}
				else{
					//ce n'est pas la bonne couleur
				}
			}
		}
		
    	delAllBonbonCouleur(g, b.getCouleur());
    	
        return true;
    }
    
    public boolean interagir(BonbonEmballe b, Grille g) {
    	
		loggerBonbonMulticolore.trace("Avec bonbon Emballe");
    		Coordonnee c1 = g.getPositionBonbon(this);
    		
    		g.supprimerBonbonCase(c1);
    		

        	delAllBonbonCouleur(g, b.getCouleur());
        	
        	Couleur aleat = b.choisirCouleurRandom();
        	while(aleat != b.getCouleur()){
        		aleat = b.choisirCouleurRandom();
        	}
        	
        	delAllBonbonCouleur(g, aleat);
        	
            return true;

    }
    
    public boolean interagir(BonbonMulticolore b, Grille g) {
		loggerBonbonMulticolore.trace("Entre multi");
		Coordonnee c1 = g.getPositionBonbon(this);
		
		g.supprimerBonbonCase(c1);
		
    	for(int i = 0 ; i < g.getLigne() ; i++){
			for(int j = 0 ; j < g.getColonne() ; j++){
				if(!g.BonbonNull(new Coordonnee(i,j)) ){
					//il sagit d'un bonbon de la couleur a transformer en bonbon 
					g.getCase(i, j).retirerContenu(g);
				}
				else{
					//ce n'est pas la bonne couleur
				}
			}
		}
    	
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
		return 5;
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
