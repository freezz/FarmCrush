package modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class FarmCrush {

	//attributs

    private int scoreActuel;
    private int nbCoupJouer;

    public Objectif objectif;
    public Grille grille;

    //Constructeurs
    
    public FarmCrush(){
    	
    	scoreActuel = 0;
    	nbCoupJouer = 0;
    	objectif = new Objectif();
    	grille = new Grille();
    	
    }
    //accesseurs
    

    
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
    public void jouer(final Coordonnee c1, final Coordonnee c2) {
    }

	/**
	 *  Effectue toutes les actions necessaires a l'initialisation
	 *  de FarmCrush, Objectif et de la grille 
	 *   
	 * @param chemin : Chemin du fichier d'import du niveau
	 * @param obj : objectif associé au niveau
	 */
    public void initialisationNiveau(String chemin) {
    	
    	int param = 0;
    	int i = 0;
		String ligneLue;	/** Variable contenant 1 ligne du fichier */
		String [] contenuLigne;	/** tableau de tous les mots de la ligne */
		
		
		try {
			BufferedReader f = new BufferedReader(new FileReader(chemin));
			

			
			try {
					while((ligneLue = f.readLine()) != null){
					
						//Récupération de la ligne
						contenuLigne = ligneLue.split(" ");
						
						//Vérification si elle contient "ligne" ou "colonne"
						if(contenuLigne[0].equals("ligne")){

							//enleve les espaces entre ligne et le nombre associé
							i = 1;
							while(contenuLigne[i].equals(" ")||contenuLigne[i].equals("")){
								i++;
							}
							
							param = Integer.parseInt(contenuLigne[1]);
							grille.setLigne(param);
				
						
	
							
						}
						else if(contenuLigne[0].equals("colonne")){
							
							i = 1;
							while(contenuLigne[i].equals(" ")||contenuLigne[i].equals("")){
								i++;
								//param = Integer.parseInt(contenuLigne[1]);
								//grille.setLigne(param);
							}
							System.out.println(contenuLigne[i]);
						
						}
						else{
							
						}
					
										
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
    	
		//grille.affiche();
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
    
    
    //Méthodes nécessaires à l'initialisation du niveau

}
