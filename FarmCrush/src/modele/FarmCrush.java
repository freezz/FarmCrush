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
    	
		String ligneLue;	/** Variable contenant 1 ligne du fichier */
		String [] contenuLigne;	/** tableau de tous les mots de la ligne */
		
		
		try {
			BufferedReader f = new BufferedReader(new FileReader(chemin));
			
			
			// récupération de ligne et colonne dans le fichier niveau
			recupereLigneColonne(grille,f);
			
			//on remet le curseur au debut du fichier
			f.close();
			f = new BufferedReader(new FileReader(chemin));
					
			//Initialisation de la grille	
			grille.initialiser();
					
			// On recupere tous les parametres		
			this.recupereParam(grille,f);

			
		} catch (FileNotFoundException e) {
			// Impossible d'ouvrir le fichier
			e.printStackTrace();
		}
    	
    }

	
    
    
    //Méthodes nécessaires à l'initialisation du niveau

    private void recupereLigneColonne(Grille grille,BufferedReader f){
    	int param = 0;
    	int i = 0;
		String ligneLue;	/** Variable contenant 1 ligne du fichier */
		String [] contenuLigne;	/** tableau de tous les mots de la ligne */
    	
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
					
					param = Integer.parseInt(contenuLigne[i]);
					grille.setLigne(param);
		
				}
				else if(contenuLigne[0].equals("colonne")){
					
					//enleve les espaces entre colonne et le nombre associé
					i = 1;
					while(contenuLigne[i].equals(" ")||contenuLigne[i].equals("")){
						i++;
					}
					
					param = Integer.parseInt(contenuLigne[i]);
					grille.setColonne(param);
			
				}				
			}
			
		} catch (IOException e) {
			// Impossible de lire la ligne du fichier
			e.printStackTrace();
		}	
			
    }
    
    private void recupereParam(Grille grille,BufferedReader f){
    	int param = 0; /** Variable contenant le nombre associé a un parametre */
		String ligneLue;	/** Variable contenant 1 ligne du fichier */
		String [] contenuLigne;	/** tableau de tous les mots de la ligne */
    	
		try {
			while((ligneLue = f.readLine()) != null){
			
				//Récupération de la ligne
				contenuLigne = ligneLue.split(" ");
				
				//Vérification des varables aux debuts de ligne
				switch (contenuLigne[0]) {
				case "score":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					grille.setLigne(param);
					break;
					
				case "coups":
					
					break;
					
				case "vert":
					
					break;
					
				case "rouge":
					
					break;
					
				case "bleu":
					
					break;
					
				case "jaune":
					
					break;
					
				case "Orange":
					
					break;
					
				case "violet":
					
					break;
					
				case "raye":
					
					break;
					
				case "emballe":
					
					break;
					
				case "multi":
					
					break;

				default:
					break;
				}
				if(contenuLigne[0].equals("ligne")){

					
		
				}
				else if(contenuLigne[0].equals("colonne")){
					
					//enleve les espaces entre colonne et le nombre associé
					i = 1;
					while(contenuLigne[i].equals(" ")||contenuLigne[i].equals("")){
						i++;
					}
					
					param = Integer.parseInt(contenuLigne[i]);
					grille.setColonne(param);
			
				}				
			}
			
		} catch (IOException e) {
			// Impossible de lire la ligne du fichier
			e.printStackTrace();
		}	
			
    }
    
    
    private int indiceParam(String [] contenuLigne){
    	int i = 1;
		while(contenuLigne[i].equals(" ")||contenuLigne[i].equals("")){
			i++;
		}
		return i;
    	
    }
    
    
    
}
