package modele;


/**
 * Gestion de la grille
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class Grille {

	//attributs

    private int nbColonne;
    private int nbLigne;

    public Case[][] tableauGrille;

    //Constructeurs
    
    public Grille(){
    	nbColonne = 0;
    	nbLigne = 0;
     }
   
    /**
     * Initialise le tableau en lui donnant une taille
     * et le rempli de cases vide
     */
    public void initialiser(){
    	tableauGrille = new Case[this.nbLigne][this.nbColonne];
    	
    	for(int i=0; i<nbLigne; i++){	
    		
        	for(int j=0; j<nbLigne; j++){	
        		
        		tableauGrille[i][j] = new Case(i,j);
        		
        	}
    		
    	}
    }
    
    
    //Accesseurs
    
    /**
     * Retourne le nombre de colonnes de la grille
     * @return nbColonne
     */
    public int getColonne(){
    	return nbColonne;
    }
    
    /**
     * Retourne le nombre de lignes de la grille
     * @return nbLigne
     */
    public int getLigne(){
    	return nbLigne;
    }
    
    /**
     * Retourne le tableau de cases
     * @return tabCases
     */
    public Case[][] getTableau(){
    	return tableauGrille;
    }
    
    /**
     * Retourne le tableau de cases
     * @return Case
     */
    public Case getCase(int i, int j){
    	return tableauGrille[i][j];
    }
    
    //setteurs
    
    /**
     * Definit le nombre de colonne de la grille
     * @param x
     */
    public void setColonne(int x){
    	nbColonne = x;
    }
    
    /**
     * Definit le nombre de ligne de la grille
     * @param y
     */
    public void setLigne(int y){
    	nbLigne = y;
    }
    
    //Méthodes
	/**
	 *   Méthode permettant de faire descendre les bonbon 
	 *   et remplissant les cases manquantes par de nouveau bonbon Normaux aléatoire 
	 *  
	 * 	 
	 */
    public void effectuerGraviter() {
    	
    	for(int i = 0; i <= this.getLigne(); i++){
			for(int j = 0; j <= this.getColonne(); j++){
			
			}
			
		}
    	
    	
    	
    	
    }

	/**
	 *   
	 *   Fonction permettant de vérifier si aucune combinaison de bonbon est possible dans la grille
	 *   Si oui, ils sont explosés
	 *   
	 * 
	 * @return boolean indiquant si la méthode a effectuer des modifications (true)
	 * 	 
	 */
    public boolean checkGrille() {

        return false;
    }
    
    /**
     * Obtenir la position du bonbon passéen paramettre
     * @param b
     */
    public Coordonnee getPositionBonbon(Bonbon b) {
    	int i = 0;
    	int j = 0;
    	Coordonnee coordonneeBonbon;
    	
    	//recherche du bonbon dans la grille
    	while(i <= this.getLigne() && tableauGrille[i][j].getBonbon() != b){
			while(j <= this.getColonne() && tableauGrille[i][j].getBonbon() != b){
				j++;
			}
			i++;
		}
    	
    	if(tableauGrille[i][j].getBonbon() != b){
    		//bonbon trouvé
    		coordonneeBonbon = new Coordonnee(i, j);
    	}
    	else {
    		//bonbon non trouvé
    		coordonneeBonbon = null;
    	}
    	return coordonneeBonbon;
    }
    
    /**
     * Supprime le bonbon d'une case grace a ces coordonnées
     * retire une couche de gelatine dans cette case
     * @param coordBonbon Coordonnées du bonbon a retirer
     */
    public void supprimerBonbonCase(Coordonnee coordBonbon){
    	tableauGrille[coordBonbon.getX()][coordBonbon.getY()].supBonbon();
    }
}
