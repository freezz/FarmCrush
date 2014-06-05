package modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//@


public class FarmCrush {

    private int scoreaActuel;
    private int nbCoupJouer;

    public Objectif objectif;
    public Grille grille;

    
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
    public void jouer(final Coordonnee c1, final Coordonnee c2) {
    }

	/**
	 *  Effectue toutes les actions necessaires a l'initialisation
	 *  de FarmCrush, Objectif et de la grille 
	 *   
	 * @param chemin : Chemin du fichier d'import du niveau
	 *   
	 */
    public void initialisationNiveau(String chemin) {
    	
    	
		String ligneLue;	/** Variable contenant 1 ligne du fichier */
		String [] contenuLigne;	/** tableau de tous les mots de la ligne */
		
		
		try {
			BufferedReader f = new BufferedReader(new FileReader(chemin));
			
			try {
				while((ligneLue = f.readLine()) != null){
					
					
					contenuLigne = ligneLue.split(" ");
					System.out.println(contenuLigne[0]); 
					
										
					}
					f.close();
				
			} catch (IOException e) {
				// Impossible de lire la ligne du fichier
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// Impossible d'ouvrir le fichier
			e.printStackTrace();
		}
    	
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
    public int getScoreActuel() {

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
    public int getNbCoupJouer() {

        return 0;
    }

}
