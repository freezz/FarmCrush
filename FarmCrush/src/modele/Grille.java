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
    	//On doit parcourir colonne par colonne en remontant ligne par ligne
    	
    	for(int j = 0; j < this.getColonne(); j++){
    		
    		for(int i = 0; i < this.getLigne(); i++){
		
			    if(this.getCase(i,j).getBonbon() == null){
			    	//il faut faire descendre le bonbon du dessus
			    	faireDescendreBonbon(i,j);
			    }
			    else{
			    	//rien
			    }
			}//ligne
			
		}//colonne
    	
    	
    	
    	
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

    	Coordonnee result = new Coordonnee(0, 0);
    	boolean action = false;
    	
    	for(int j = 0; j < this.getColonne(); j++){
    		
    		for(int i = 0; i < this.getLigne(); i++){
		
			    if(this.getCase(i,j).getBonbon() != null){
			    	//il faut faire descendre le bonbon du dessus
			    	result = checkBonbon(new Coordonnee(i, j));
			    	
			    	CreationBonbon(new Coordonnee(i, j), result.getX(), result.getY());
			    	
			    	if(result.getX() > 2 || result.getY() > 2){
			    		action = true;
			    	}
			    	
			    }
			    		
			    	
			}//ligne
			
		}//colonne
    	
		return action;
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
    	while(i < this.getLigne() && tableauGrille[i][j].getBonbon() != b){
			while(j < this.getColonne() && tableauGrille[i][j].getBonbon() != b){
				j++;
			}
			i++;
		}
    	
    	if(tableauGrille[i][j].getBonbon() == b){
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
    
    public void faireDescendreBonbon(int i, int j){
    	int compteur = 0;
    	
    	while(this.getCase(i,j).getBonbon() == null && compteur < nbLigne-i){
    		
    		for(int i1 = i;i1 < nbLigne-1; i1++){
    			this.getCase(i1,j).setBonbon(this.getCase(i1+1,j).getBonbon());
    			
    			//Dans le cas ou ce n'est pas un bonbon null, il faut lui mettre a jour son historique
    			if(this.getCase(i1,j).getBonbon() != null){
    				this.getCase(i1,j).getBonbon().ajoutCoordonneHistorique(i1, j); 
    			}
    			
    			compteur++;
    			
    		}//fin for
    	}
    	
    	if(this.getCase(i,j).getBonbon() == null){
    		
    		for(int i1 = i;i1 < nbLigne; i1++){
    		this.getCase(i1, j).setBonbonAleatoire();
		    this.getCase(i1, j).getBonbon().ajoutCoordonneHistorique(i1, j);
    		}
    	}
    	
    }//fin methode
    
    
	/**
	 *   
	 *   Fonction permettant de retourner le nombre de bonbon de la meme couleur 
	 *   en ligne et en colonne
	 *   
	 * 
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * X nb de bonbon identique sur la meme ligne
	 * et Y sur la meme colonne
	 * 	 
	 */
    private Coordonnee checkBonbon(Coordonnee pos) {

    	Coordonnee nbBonbonLigneColonne = new Coordonnee(0, 0);// Création des coordonnee de retour
    	Couleur color = tableauGrille[pos.getX()][pos.getY()].getBonbon().getCouleur();// couleur du bonbon recherché
    	
    	//on regarde a droite en recursif

    	Coordonnee resultaDroite = new Coordonnee(0, 0);
    	Coordonnee coorDroite = new Coordonnee(pos.getX()+1, pos.getY());
    	
		if(coorDroite.getX()<nbColonne){
			if(!BonbonNull(coorDroite)){
				resultaDroite = checkBonbonAdroite(coorDroite, new Coordonnee(0, 0), color);
				}
		}
		
    	//on regarde a gauche recursif

    	Coordonnee resultaGauche = new Coordonnee(0, 0);
    	Coordonnee coorGauche = new Coordonnee(pos.getX()-1, pos.getY());
    	
		if(coorGauche.getX()>0){
			if(!BonbonNull(coorGauche)){
				resultaDroite = checkBonbonAgauche(coorGauche, new Coordonnee(0, 0), color);
				}
		}
    	
    	
    	//on rejoute le resultat ligne
    	
    	if((resultaDroite.getX()+resultaGauche.getX())>1){
    		nbBonbonLigneColonne.setX(resultaDroite.getX()+resultaGauche.getX()+1);
    	}
    	
    	nbBonbonLigneColonne.setY(nbBonbonLigneColonne.getY()+resultaDroite.getY()+resultaGauche.getY());
    	
    	//on regarde en haut
    	Coordonnee coorEnHaut = new Coordonnee(pos.getX(), pos.getY()+1);
    	Coordonnee resultEnHaut = new Coordonnee(0, 0);
    	
		if(coorEnHaut.getY()<nbLigne){
			if(!BonbonNull(coorEnHaut)){
				resultEnHaut = checkBonbonEnHaut(coorEnHaut, new Coordonnee(0, 0), color);}
		}
    	
    	//on regarde en bas
    	
    	Coordonnee coorEnBas = new Coordonnee(pos.getX(), pos.getY()-1);
    	Coordonnee resultEnBas = new Coordonnee(0, 0);
		if(coorEnBas.getY()>0){
			if(!BonbonNull(coorEnBas)){
				resultEnBas = checkBonbonEnBas(coorEnBas, new Coordonnee(0, 0), color);}
		}
    	
    	//on rejoute le resultat colonne
    	
    	if((resultEnHaut.getY()+resultEnBas.getY())>1){
    		nbBonbonLigneColonne.setY(resultEnHaut.getY()+resultEnBas.getY()+1);
    	}
    	
    	nbBonbonLigneColonne.setX(nbBonbonLigneColonne.getX()+resultEnHaut.getX()+resultEnBas.getX());
		
		
        return nbBonbonLigneColonne;
    }//fin methode
    
    
	/**
	 *   
	 *   Fonction permettant de retourner le nombre de bonbon de la meme couleur 
	 *   en ligne 
	 *   
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * 	 
	 */
    private Coordonnee checkBonbonAdroite(Coordonnee c, Coordonnee result, Couleur color) {

    	
if(tableauGrille[c.getX()][c.getY()].getBonbon().getCouleur() == color){
    		
        	//on regarde a droite en recursif

        	Coordonnee resulthaut = checkBonbonEnHautSimple(c, new Coordonnee(0, 0), color);
        	resulthaut.setY(resulthaut.getY());
        	
        	//on regarde a droite en recursif

        	Coordonnee resultBas = checkBonbonEnBasSimple(c, new Coordonnee(0, 0), color);
        	resultBas.setY(resultBas.getY()-1);
        	
        	//on rejoute le resultat
        	
        	if((resulthaut.getY()+resultBas.getY())>2){
        		result.setX(result.getX()+resulthaut.getX()+resultBas.getX());
        	}
    		
    		
    		c.setX(c.getX()+1);
    		if(c.getX()<nbColonne){
    			if(!BonbonNull(c)){
    			Coordonnee aDroite = checkBonbonAdroite(c, result, color);
				result.setY(result.getY()+aDroite.getY());
				result.setX(result.getX()+aDroite.getX());
    			}
    		}
    		result.setX(result.getX()+1);
    	}
    	
    	return result;
    }//fin methode
    
    /**
	 *   
	 *   Sous fonction de checkBonbonAdroite
	 *   
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * 	 
	 */
    private Coordonnee checkBonbonAdroiteSimple(Coordonnee c, Coordonnee result, Couleur color) {

    	
    	if(tableauGrille[c.getX()][c.getY()].getBonbon().getCouleur() == color){
    		
    		
    		c.setX(c.getX()+1);
    		if(c.getX()<nbColonne){
    			if(!BonbonNull(c)){
    			result.setX(result.getX()+checkBonbonAdroiteSimple(c, result, color).getX());}
    		}
    		result.setX(result.getX()+1);
    	}
    	
    	return result;
    }//fin methode
    
	/**
	 *   
	 *   Fonction permettant de retourner le nombre de bonbon de la meme couleur 
	 *   en ligne 
	 *   
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * 	 
	 */
    private Coordonnee checkBonbonAgauche(Coordonnee c, Coordonnee result, Couleur color) {

    	
    	if(tableauGrille[c.getX()][c.getY()].getBonbon().getCouleur() == color){
    		
        	//on regarde en haut

        	Coordonnee resulthaut = checkBonbonEnHautSimple(c, new Coordonnee(0, 0), color);
        	resulthaut.setY(resulthaut.getY());
        	
        	//on regarde en bas

        	Coordonnee resultBas = checkBonbonEnBasSimple(c, new Coordonnee(0, 0), color);
        	resultBas.setY(resultBas.getY()-1);
        	
        	//on rejoute le resultat
        	
        	if((resulthaut.getY()+resultBas.getY())>2){
        		result.setX(result.getX()+resulthaut.getX()+resultBas.getX());
        	}
    		
    		
    		c.setX(c.getX()-1);
    		if(c.getX()>0){
    			if(!BonbonNull(c)){
    			Coordonnee aGauche = checkBonbonAgauche(c, result, color);
				result.setY(result.getY()+aGauche.getY());
				result.setX(result.getX()+aGauche.getX());
    			}
    		}
    		result.setX(result.getX()+1);
    	}
    	
    	
    	
    	return result;
    }//fin methode
    
	/**
	 *   
	 *   Sous fonction de checkBonbonAgauche
	 *   
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * 	 
	 */
    private Coordonnee checkBonbonAgaucheSimple(Coordonnee c, Coordonnee result, Couleur color) {

    	
    	if(tableauGrille[c.getX()][c.getY()].getBonbon().getCouleur() == color){
    		
    		
    		c.setX(c.getX()-1);
    		if(c.getX()>0){
    			if(!BonbonNull(c)){
    			result.setX(result.getX()+checkBonbonAgaucheSimple(c, result, color).getX());}
    		}
    		result.setX(result.getX()+1);
    	}
    	
    	return result;
    }//fin methode
    
    
	/**
	 *   
	 *   Fonction permettant de retourner le nombre de bonbon de la meme couleur 
	 *   en colonne et en ligne en montant
	 *   
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * 	 
	 */
    private Coordonnee checkBonbonEnHaut(Coordonnee c, Coordonnee result, Couleur color) {

    	
    	if(tableauGrille[c.getX()][c.getY()].getBonbon().getCouleur() == color){
    		
        	//on regarde a droite en recursif

        	Coordonnee resultaDroite = checkBonbonAdroiteSimple(c, new Coordonnee(0, 0), color);
        	resultaDroite.setX(resultaDroite.getX());
        	
        	//on regarde a droite en recursif

        	Coordonnee resultaGauche = checkBonbonAgaucheSimple(c, new Coordonnee(0, 0), color);
        	resultaGauche.setX(resultaGauche.getX()-1);
        	
        	//on rejoute le resultat
        	
        	if((resultaDroite.getX()+resultaGauche.getX())>2){
        		result.setX(result.getX()+resultaDroite.getX()+resultaGauche.getX());
        	}
    		
        	// et on regarde de nouveau en haut
    		c.setY(c.getY()+1);
    		if(c.getY()<nbLigne){
    			if(!BonbonNull(c)){
    				Coordonnee enhaut = checkBonbonEnHaut(c, result, color);
    				result.setY(result.getY()+enhaut.getY());
    				result.setX(result.getX()+enhaut.getX());
    				
    			}
    		}
    		
    		result.setY(result.getY()+1);
    	}
    	
    	return result;
    }//fin methode
    
    /**
	 *   
	 *   Sous fonction de checkBonbonEnHaut 
	 *   
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * 	 
	 */
    private Coordonnee checkBonbonEnHautSimple(Coordonnee c, Coordonnee result, Couleur color) {

    	
    	if(tableauGrille[c.getX()][c.getY()].getBonbon().getCouleur() == color){
    		
    		c.setY(c.getY()+1);
    		if(c.getY()<nbLigne){
    			if(!BonbonNull(c)){
    				Coordonnee enhaut = checkBonbonEnHautSimple(c, result, color);
    				result.setY(result.getY()+enhaut.getY());
    				
    			}
    		}
    		
    		result.setY(result.getY()+1);
    	}
    	
    	return result;
    }//fin methode
    
    
	/**
	 *   
	 *   Fonction permettant de retourner le nombre de bonbon de la meme couleur 
	 *   en colonne et en ligne en regardant en bas
	 *   
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * 	 
	 */
    private Coordonnee checkBonbonEnBas(Coordonnee c, Coordonnee result, Couleur color) {

    	
    	if(tableauGrille[c.getX()][c.getY()].getBonbon().getCouleur() == color){
    		
        	//on regarde a droite en recursif

        	Coordonnee resultaDroite = checkBonbonAdroiteSimple(c, new Coordonnee(0, 0), color);
        	resultaDroite.setX(resultaDroite.getX());
        	
        	//on regarde a droite en recursif

        	Coordonnee resultaGauche = checkBonbonAgaucheSimple(c, new Coordonnee(0, 0), color);
        	resultaGauche.setX(resultaGauche.getX()-1);
        	
        	//on rajoute le resultat ligne
        	
        	if((resultaDroite.getX()+resultaGauche.getX())>2){
        		result.setX(result.getX()+resultaDroite.getX()+resultaGauche.getX());
        	}
    		
        	// et on regarde de nouveau en haut
    		c.setY(c.getY()-1);
    		if(c.getY()>0){
    			if(!BonbonNull(c)){
    				Coordonnee enhaut = checkBonbonEnBas(c, result, color);
    				result.setY(result.getY()+enhaut.getY());
    				result.setX(result.getX()+enhaut.getX());
    				
    			
    			}
    		}
    		
    		result.setY(result.getY()+1);
    		
    		
    	}
    	
    	return result;
    }//fin methode
    
	/**
	 *   
	 *   Fonction permettant de retourner le nombre de bonbon de la meme couleur 
	 *   en colonne sur la meme colonne en regardant vers le bas
	 *   
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * 	 
	 */
    private Coordonnee checkBonbonEnBasSimple(Coordonnee c, Coordonnee result, Couleur color) {

    	
    	if(tableauGrille[c.getX()][c.getY()].getBonbon().getCouleur() == color){
    		
    		
    		c.setY(c.getY()-1);
    		if(c.getY()>0){
    			if(!BonbonNull(c)){
    				Coordonnee enhaut = checkBonbonEnBasSimple(c, result, color);
    				result.setY(result.getY()+enhaut.getY());
		
    			}
    		}
    		
    		result.setY(result.getY()+1);
    		
    		
    	}
    	
    	return result;
    }//fin methode
    
    
    /**
	 *   
	 *   Fonction informant si le bonbon a la coordonnée donnée n'existe pas
	 *   
	 * @return boolean true si bonbon n existe pas
	 * 	 
	 */
    public boolean BonbonNull(Coordonnee c){
    	return(tableauGrille[c.getX()][c.getY()].getBonbon() == null);
    }

    
    /**
	 *   
	 *   Méthodes détruisant les cases constituant un forme 
	 *   et crée un nouveau bonbon si besoin
	 *   
	 * @param pos : coordonné ou le nouveau bonbon sera créé
	 * @param i : indice sur le nb de bonbon identique sur une ligne
	 * @param j : inidice sur le nb de bonbon identique sur une colonne
	 * 	 
	 */
    private void CreationBonbon(Coordonnee pos, int i, int j){
    	
    	// si ajout nouveau type de bonbon, ajouter le la
    	
    	BonbonNormal bonbon = new BonbonNormal(Couleur.JAUNE);
    	BonbonRaye bonbonRaye = new BonbonRaye(Couleur.JAUNE);
    	BonbonEmballe bonbonEmballe = new BonbonEmballe(Couleur.JAUNE);
    	BonbonMulticolore bonbonmulti = new BonbonMulticolore();
    	
    	// en fonction du bonbon dectecté, on effectu differentes actions
    	if(i == bonbonmulti.getConditionLigne()){
    		//destruction 
    		this.detruireBonbonExistant(pos);
    		//creation nouveau
    		
    	}
    	else if(j == bonbonmulti.getConditionLigne()){
    		
    		
    	}
    	else if(i == bonbonRaye.getConditionLigne()){
    		
    		
    	}
    	else if(j == bonbonRaye.getConditionLigne()){
    		
    		
    	}
    	else if(i == bonbonEmballe.getConditionLigne() && j == bonbonEmballe.getConditionLigne()){
    		
    		
    	}
    	else if(i == bonbon.getConditionLigne()){
    		
    		
    	}
    	else if(j == bonbon.getConditionLigne()){
    		
    		
    	}
    	
    	
    }//fin methode
    
    /**
	 *   
	 *   Méthodes détruisant les cases constituant un forme 
	 *   et crée un nouveau bonbon si besoin
	 *   
	 * @param pos : coordonné ou le nouveau bonbon sera créé
	 * @param i : indice sur le nb de bonbon identique sur une ligne
	 * @param j : inidice sur le nb de bonbon identique sur une colonne
	 * 	 
	 */
    public boolean detruireBonbonExistant(Coordonnee pos){
		
    	Couleur color = tableauGrille[pos.getX()][pos.getY()].getBonbon().getCouleur();// couleur du bonbon recherché
    	
    	//
    	
    	return false;
    	
    }
    
}
