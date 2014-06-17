package modele;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modele.BonbonRaye.Axe;


/**
 * Gestion de la grille
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class Grille {

	
	//Looger
	private static final Logger loggerGrille = LogManager.getLogger("modèle.Grille");
	
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
    	if(i>8 || j>8){
    		loggerGrille.trace("Pb d'emploi de getcase : {}{}", i, j);
    	}
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
    
    
    //Utilitaires publiques
    
    
    /**
     * Supprime le bonbon d'une case grace a ces coordonnées
     * retire une couche de gelatine dans cette case
     * @param coordBonbon Coordonnées du bonbon a retirer
     */
    public void retirerBonbonCase(Coordonnee coordBonbon){
    	if(!this.BonbonNull(coordBonbon)){
    	tableauGrille[coordBonbon.getX()][coordBonbon.getY()].retirerContenu(this);
    	}
    }
    
    

    /**
	 *   
	 *   Fonction informant si le bonbon a la coordonnée donnée n'existe pas
	 *   
	 * @return boolean true si bonbon n existe pas
	 * 	 
	 */
    public boolean BonbonNull(Coordonnee c){
    	return(getCase(c.getX(),c.getY()).getBonbon() == null);
    }

    
    /**
     * Obtenir la position du bonbon passéen paramettre
     * @param b
     */
    public Coordonnee getPositionBonbon(Bonbon b) {

    	Coordonnee coordonneeBonbon = null;
    	    	
    	//recherche du bonbon dans la grille
    	
    	for(int i = 0; i < this.getColonne(); i++){
    		
    		for(int j = 0; j <this.getLigne(); j++){
    			
    	    	if(this.getCase(i,j).getBonbon() == b){
    	    		//bonbon trouvé
    	    		coordonneeBonbon = new Coordonnee(i, j);
    	    		break;
    	    	}
    			
    		}
    		
    	}
    	

    	return coordonneeBonbon;
    	
    }
    
    /**
     * Supprime le bonbon d'une case grace a ces coordonnées
     * retire une couche de gelatine dans cette case
     * @param coordBonbon Coordonnées du bonbon a retirer
     */
    public void supprimerBonbonCase(Coordonnee coordBonbon){
    	this.getCase(coordBonbon.getX(),coordBonbon.getY()).supBonbon();
    }
    
    
    

    
    
    
    // Effectuer gravité
    
	/**
	 *   Méthode permettant de faire descendre les bonbon 
	 *   et remplissant les cases manquantes par de nouveau bonbon Normaux aléatoire 
	 *  
	 * 	 
	 */
    public void effectuerGraviter() {
    	//On doit parcourir colonne par colonne en remontant ligne par ligne
		loggerGrille.trace("Le probleme serait dans gravité ?");
		
    	for(int i = 0; i < this.getColonne(); i++){
    		
    		for(int j = 0; j < this.getLigne(); j++){
		
			    if(this.getCase(i,j).getBonbon() == null){
			    	//il faut faire descendre le bonbon du dessus
					loggerGrille.trace("Dans faire descencre ?");
			    	faireDescendreBonbon(i,j);
					loggerGrille.trace("faire descendre hors de cause ?");
			    }
			    else{
			    	//rien
			    }
			}//ligne
			
		}//colonne
    	
		loggerGrille.trace("gravité hors de cause ?");
    	
    	
    }


    /**
     * 
     * 
     * 
     */
    public void faireDescendreBonbon(int i, int j1){
    	
    	while(this.getCase(i,j1).getBonbon() == null){
    		
    		loggerGrille.trace("réiteration de la boucle"); 
    		
    		for(int j = j1; j < nbLigne; j++){
    			
    			loggerGrille.trace("Valeur de l'algo : ({},{}) ", i,j); 
    			
    			if(j == nbLigne-1){
    				
    	    		this.getCase(i, j).setBonbonAleatoire();
    	    		
    			}
    			else{
    				
    				this.getCase(i,j).setBonbon(this.getCase(i,j+1).getBonbon());
        			
        			//Dans le cas ou ce n'est pas un bonbon null, il faut lui mettre a jour son historique
        			if(this.getCase(i,j).getBonbon() != null){
        				this.getCase(i,j).getBonbon().ajoutCoordonneHistorique(i, j); 
        			}
    			}
    			
    		}//fin for
    		
    	}//fin while
    	
    }//fin methode
    
    
    
    
    
    
    
    
    
    // CkeckGrille
    
    
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
    	
		loggerGrille.trace("mais ou est donc la boucle infini ?");
		
    	for(int j = 0; j < this.getLigne(); j++){
    		
    		for(int i = 0; i < this.getColonne(); i++){
		
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
    	
    	loggerGrille.trace("hors de cause ?");
    	
		return action;
    }
    
	/**
	 *   
	 *   Fonction permettant de vérifier si aucune combinaison de bonbon est possible 
	 *   a partir d'une postion
	 * 
	 * @return boolean indiquant si la méthode a effectuer des modifications (true)
	 * 	 
	 */
    public boolean checkInteraction(Coordonnee pos){
    	
    	boolean action = false;
	    if(this.getCase(pos.getX(),pos.getY()).getBonbon() != null){
	    	//il faut faire descendre le bonbon du dessus

	    	loggerGrille.trace("ca rentre la -1 {}{}",pos.getX(),pos.getY());
	    	
	    	Coordonnee result = checkBonbon(new Coordonnee(pos.getX(), pos.getY()));
	    	loggerGrille.trace("Est ce que checkBonbon nous retourne la bonne valeur : ({},{})",result.getX(),result.getY());
	    	
	    	CreationBonbon(new Coordonnee(pos.getX(), pos.getY()), result.getX(), result.getY());
	    	
	    	if(result.getX() > 2 || result.getY() > 2){
	    		action = true;
	    	}
	    	
	    }
	    
	    return action;
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
    	BonbonRaye bonbonRaye = new BonbonRaye(Couleur.JAUNE,Axe.HORIZONTALE);
    	BonbonEmballe bonbonEmballe = new BonbonEmballe(Couleur.JAUNE);
    	BonbonMulticolore bonbonmulti = new BonbonMulticolore();
    	
    	Couleur color = getCase(pos.getX(),pos.getY()).getBonbon().getCouleur();// couleur du bonbon recherché
    	
    	// en fonction du bonbon dectecté, on effectu differentes actions
    	if(i == bonbonmulti.getConditionLigne()){
    		
    		//destruction 
    		this.detruireBonbonExistant(pos,i,0);
    		//creation nouveau
    		getCase(pos.getX(),pos.getY()).setBonbon(new BonbonMulticolore());
    		
    	}
    	else if(j == bonbonmulti.getConditionLigne()){
    		
    		this.detruireBonbonExistant(pos,0,j);
    		//creation nouveau
    		getCase(pos.getX(),pos.getY()).setBonbon(new BonbonMulticolore());
    	}
    	else if(i == bonbonRaye.getConditionLigne()){
    		
    		this.detruireBonbonExistant(pos,i,0);
    		//creation nouveau
    		getCase(pos.getX(),pos.getY()).setBonbon(new BonbonRaye(color,Axe.HORIZONTALE));
    	}
    	else if(j == bonbonRaye.getConditionLigne()){
    		
    		this.detruireBonbonExistant(pos,0,j);
    		//creation nouveau
    		getCase(pos.getX(),pos.getY()).setBonbon(new BonbonRaye(color,Axe.VERTICALE));
    	}
    	else if(i == bonbonEmballe.getConditionLigne() && j == bonbonEmballe.getConditionColonne()){
    		
    		this.detruireBonbonExistant(pos,i,j);
    		//creation nouveau
    		getCase(pos.getX(),pos.getY()).setBonbon(new BonbonEmballe(color));
    	}
    	else if(i == bonbon.getConditionLigne()){
    		
    		this.detruireBonbonExistant(pos,i,0);
    		
    		//il n'y a pas de création de bonbon
    	}
    	else if(j == bonbon.getConditionLigne()){
    		
    		this.detruireBonbonExistant(pos,0,j);

    		//il n'y a pas de création de bonbon
    		
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

    	loggerGrille.trace("ca rentre la 0 {}{}",pos.getX(),pos.getY());
    	
    	Coordonnee nbBonbonLigneColonne = new Coordonnee(0, 0);// Création des coordonnee de retour
    	Couleur color = this.getCase(pos.getX(),pos.getY()).getBonbon().getCouleur();// couleur du bonbon recherché
    	
    	//on regarde a droite en recursif

    	Coordonnee resultaDroite = new Coordonnee(0, 0);
    	Coordonnee coorDroite = new Coordonnee(pos.getX()+1, pos.getY());
    	
		if(coorDroite.getX()<nbColonne){
			if(!BonbonNull(coorDroite)){
	        	loggerGrille.trace("ca rentre la 1 {}{}",coorDroite.getX(),coorDroite.getY());
				resultaDroite = checkBonbonAdroite(coorDroite, color);
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
    
    
    
    
    
    // Méthodes check complete
    
    
	/**
	 *   
	 *   Fonction permettant de retourner le nombre de bonbon de la meme couleur 
	 *   en ligne 
	 *   
	 * @return pair d'entier sous la forme de coordonnées (cheat)
	 * 	 
	 */
    private Coordonnee checkBonbonAdroite(Coordonnee c, Couleur color) {
    	
    	loggerGrille.trace("ca rentre la 2 {}{}",c.getX(),c.getY());
    		Coordonnee result = new Coordonnee(0, 0);
    	
    	if(tableauGrille[c.getX()][c.getY()].getBonbon().getCouleur() == color){
        	loggerGrille.trace("ca rentre la 3");
        	//on regarde en haut en recursif

        	Coordonnee resulthaut = checkBonbonEnHautSimple(new Coordonnee(c.getX(), c.getY()), new Coordonnee(0, 0), color);
        	resulthaut.setY(resulthaut.getY());
        	
        	//on regarde en bas en recursif

        	Coordonnee resultBas = checkBonbonEnBasSimple(new Coordonnee(c.getX(), c.getY()), new Coordonnee(0, 0), color);
        	resultBas.setY(resultBas.getY()-1);
        	
        	//on rejoute le resultat
        	
        	if((resulthaut.getY()+resultBas.getY())>2){
        		result.setY(result.getY()+resulthaut.getY()+resultBas.getY());
        	}
    		
        	loggerGrille.trace("ca rentre la");
    		c.setX(c.getX()+1);
    		if(c.getX()<nbColonne){
    			if(!BonbonNull(c)){
    			Coordonnee resultaDroite = checkBonbonAdroite(new Coordonnee(c.getX(), c.getY()), color);
				result.setY(resultaDroite.getY()+resultaDroite.getY());
				result.setX(resultaDroite.getX()+resultaDroite.getX());
				loggerGrille.trace("Est ce que checkBonbonDroite  : ({},{})",resultaDroite.getX(),resultaDroite.getY());
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

    	
    	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
    		
    		
    		c.setX(c.getX()+1);
    		if(c.getX()<nbColonne){
    			if(!BonbonNull(c)){
    			result.setX(result.getX()+checkBonbonAdroiteSimple(new Coordonnee(c.getX(), c.getY()), result, color).getX());}
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

    	
    	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
    		
        	//on regarde en haut

        	Coordonnee resulthaut = checkBonbonEnHautSimple(new Coordonnee(c.getX(), c.getY()), new Coordonnee(0, 0), color);
        	resulthaut.setY(resulthaut.getY());
        	
        	//on regarde en bas

        	Coordonnee resultBas = checkBonbonEnBasSimple(new Coordonnee(c.getX(), c.getY()), new Coordonnee(0, 0), color);
        	resultBas.setY(resultBas.getY()-1);
        	
        	//on rejoute le resultat
        	
        	if((resulthaut.getY()+resultBas.getY())>2){
        		result.setX(result.getX()+resulthaut.getX()+resultBas.getX());
        	}
    		
    		
    		c.setX(c.getX()-1);
    		if(c.getX()>0){
    			if(!BonbonNull(c)){
    			Coordonnee aGauche = checkBonbonAgauche(new Coordonnee(c.getX(), c.getY()), result, color);
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

    	
    	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
    		
    		
    		c.setX(c.getX()-1);
    		if(c.getX()>0){
    			if(!BonbonNull(c)){
    			result.setX(result.getX()+checkBonbonAgaucheSimple(new Coordonnee(c.getX(), c.getY()), result, color).getX());}
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


    	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
    		
        	//on regarde a droite en recursif

        	Coordonnee resultaDroite = checkBonbonAdroiteSimple(new Coordonnee(c.getX(), c.getY()), new Coordonnee(0, 0), color);
        	resultaDroite.setX(resultaDroite.getX());
        	
        	//on regarde a droite en recursif

        	Coordonnee resultaGauche = checkBonbonAgaucheSimple(new Coordonnee(c.getX(), c.getY()), new Coordonnee(0, 0), color);
        	resultaGauche.setX(resultaGauche.getX()-1);
        	
        	//on rejoute le resultat
        	
        	if((resultaDroite.getX()+resultaGauche.getX())>2){
        		result.setX(result.getX()+resultaDroite.getX()+resultaGauche.getX());
        	}
    		
        	// et on regarde de nouveau en haut
    		c.setY(c.getY()+1);
    		if(c.getY()<nbLigne){
    			if(!BonbonNull(c)){
    				Coordonnee enhaut = checkBonbonEnHaut(new Coordonnee(c.getX(), c.getY()), result, color);
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

    	
    	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
    		
    		c.setY(c.getY()+1);
    		if(c.getY()<nbLigne){
    			if(!BonbonNull(c)){
    				Coordonnee enhaut = checkBonbonEnHautSimple(new Coordonnee(c.getX(), c.getY()), result, color);
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

    	
    	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
    		
        	//on regarde a droite en recursif

        	Coordonnee resultaDroite = checkBonbonAdroiteSimple(new Coordonnee(c.getX(), c.getY()), new Coordonnee(0, 0), color);
        	resultaDroite.setX(resultaDroite.getX());
        	
        	//on regarde a droite en recursif

        	Coordonnee resultaGauche = checkBonbonAgaucheSimple(new Coordonnee(c.getX(), c.getY()), new Coordonnee(0, 0), color);
        	resultaGauche.setX(resultaGauche.getX()-1);
        	
        	//on rajoute le resultat ligne
        	
        	if((resultaDroite.getX()+resultaGauche.getX())>2){
        		result.setX(result.getX()+resultaDroite.getX()+resultaGauche.getX());
        	}
    		
        	// et on regarde de nouveau en haut
    		c.setY(c.getY()-1);
    		if(c.getY()>0){
    			if(!BonbonNull(c)){
    				Coordonnee enhaut = checkBonbonEnBas(new Coordonnee(c.getX(), c.getY()), result, color);
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

    	
    	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
    		
    		
    		c.setY(c.getY()-1);
    		if(c.getY()>0){
    			if(!BonbonNull(c)){
    				Coordonnee enhaut = checkBonbonEnBasSimple(new Coordonnee(c.getX(), c.getY()), result, color);
    				result.setY(result.getY()+enhaut.getY());
		
    			}
    		}
    		
    		result.setY(result.getY()+1);
    		
    		
    	}
    	
    	return result;
    }//fin methode
    
    
    
    
    
    //Detruire
    
    
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
    public void detruireBonbonExistant(Coordonnee pos,int i, int j){
		
    	Couleur color = getCase(pos.getX(),pos.getY()).getBonbon().getCouleur();// couleur du bonbon recherché

    	//on traite le i (les lignes)
    	
    	if(i!=0){

    		Coordonnee coorDroite = new Coordonnee(pos.getX()+1, pos.getY());
    	
			if(coorDroite.getX()<nbColonne){
				if(!BonbonNull(coorDroite)){
					destructBonbonAdroite(coorDroite, color);
				}
			}
		
    		//on regarde a gauche recursif

    		Coordonnee coorGauche = new Coordonnee(pos.getX()-1, pos.getY());
    	
			if(coorGauche.getX()>0){
				if(!BonbonNull(coorGauche)){
					destructBonbonAgauche(coorGauche, color);
				}
			}
    	
    	}
    	
    	if(j!=0){
    	
    		//on regarde en haut
    		Coordonnee coorEnHaut = new Coordonnee(pos.getX(), pos.getY()+1);
    	
    		if(coorEnHaut.getY()<nbLigne){
    			if(!BonbonNull(coorEnHaut)){
    				destructBonbonEnHaut(coorEnHaut, color);}
    		}
    	
    		//on regarde en bas
    	
    		Coordonnee coorEnBas = new Coordonnee(pos.getX(), pos.getY()-1);

    		if(coorEnBas.getY()>0){
    			if(!BonbonNull(coorEnBas)){
    				destructBonbonEnBas(coorEnBas, color);}
    		}
    	
    	}
		
    	

    }
    
    
    
    
    //Méthodes destruction
    
    
    /**
	 *   
	 *   Fonction se déplacant vers le bas en faisant exploser les bonbon sur son passage
	 *
	 * 	 
	 */
    private void destructBonbonEnBas(Coordonnee c, Couleur color) {

    	
    	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
    		
    		getCase(c.getX(),c.getY()).retirerContenu(this);
    		
    		c.setY(c.getY()-1);
    		
    		if(c.getY()>0){
    			if(!BonbonNull(c)){
    				destructBonbonEnBas(new Coordonnee(c.getX(), c.getY()), color);
    				
		
    			}
    		}
    		
    	}
    	
    }//fin methode
    
    
    /**
	 *   
	 *   Fonction se déplacant vers le haut en faisant exploser les bonbon sur son passage
	 *
	 * 	 
	 */
    private void destructBonbonEnHaut(Coordonnee c, Couleur color) {

    	
    	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
    		
    		getCase(c.getX(),c.getY()).retirerContenu(this);
    		
    		c.setY(c.getY()+1);
    		
    		if(c.getY()<nbLigne){
    			if(!BonbonNull(c)){
    				destructBonbonEnHaut(new Coordonnee(c.getX(), c.getY()), color);
    				
		
    			}
    		}
    		
    	}
    	
    }//fin methode
    
    
    /**
 	 *   
 	 *   Fonction se déplacant vers la droite en faisant exploser les bonbon sur son passage
 	 *
 	 * 	 
 	 */
     private void destructBonbonAdroite(Coordonnee c, Couleur color) {

     	
     	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
     		
     		getCase(c.getX(),c.getY()).retirerContenu(this);

     		c.setX(c.getX()+1);

     		if(c.getX()<nbColonne){
     			if(!BonbonNull(c)){
     				destructBonbonAdroite(new Coordonnee(c.getX(), c.getY()), color);
     				
 		
     			}
     		}
     		
     	}
     	
     }//fin methode
     
     
     /**
  	 *   
  	 *   Fonction se déplacant vers la droite en faisant exploser les bonbon sur son passage
  	 *
  	 * 	 
  	 */
      private void destructBonbonAgauche(Coordonnee c, Couleur color) {

      	
      	if(getCase(c.getX(),c.getY()).getBonbon().getCouleur() == color){
      		
      		getCase(c.getX(),c.getY()).retirerContenu(this);
      		
      		c.setX(c.getX()-1);
      		
      		if(c.getX()>0){
      			if(!BonbonNull(c)){
      				destructBonbonAgauche(new Coordonnee(c.getX(), c.getY()), color);
      				
  		
      			}
      		}
      		
      	}
      	
      }//fin methode
    
}
