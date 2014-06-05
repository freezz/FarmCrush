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
    
    public void affiche(){
    	System.out.println(nbColonne);
    	System.out.println(nbLigne);
    }
    
    //Accesseurs
    
    public int getColonne(){
    	return nbColonne;
    }
    
    public int getLigne(){
    	return nbLigne;
    }
    
    public Case[][] getTableau(){
    	return tableauGrille;
    }
    
    //setteurs
    
    public void setColonne(int x){
    	nbColonne = x;
    }
    
    public void setLigne(int y){
    	nbLigne = y;
    }
    
    //Méthodes
	/**
	 *   
	 *   
	 * @param 
	 *   
	 * @required
	 *  
	 * @ensure
	 *  
	 * @throws 
	 * 
	 * @return 
	 * 	 
	 */
    public void effectuerGraviter() {
    }

	/**
	 *   
	 *   
	 * @param 
	 *   
	 * @required
	 *  
	 * @ensure
	 *  
	 * @throws 
	 * 
	 * @return 
	 * 	 
	 */
    public boolean checkGrille() {

        return false;
    }

	/**
	 *   
	 *   
	 * @param 
	 *   
	 * @required
	 *  
	 * @ensure
	 *  
	 * @throws 
	 * 
	 * @return 
	 * 	 
	 */
    public int getNbLigne() {

        return 0;
    }

	/**
	 *   
	 *   
	 * @param 
	 *   
	 * @required
	 *  
	 * @ensure
	 *  
	 * @throws 
	 * 
	 * @return 
	 * 	 
	 */
    public int getNbColonne() {

        return 0;
    }

}
