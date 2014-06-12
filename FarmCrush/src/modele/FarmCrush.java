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

        return scoreActuel;
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

        return nbCoupJouer;
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
			recupereLigneColonne(f);
			
			//on remet le curseur au debut du fichier
			
			f.close();
			f = new BufferedReader(new FileReader(chemin));
					
			//Initialisation de la grille	
			grille.initialiser();
					
			// On recupere tous les parametres		
			this.recupereParam(f);

			
			f.close();
		} catch (FileNotFoundException e) {
			// Impossible d'ouvrir le fichier
			e.printStackTrace();
		} catch (IOException e) {
			// Impossible de fermer le fichier
			e.printStackTrace();
		}
    	
    }

	
    
    
    //Méthodes nécessaires à l'initialisation du niveau

    
	/**
	 *  Sauvegarde le nombre de ligne et colonne dans la grille
	 *   
	 * @param f : Buffer contenant le contenu du fichier
	 */
    private void recupereLigneColonne(BufferedReader f){
    	int param = 0;      /** Variable contenant le nombre associé a un parametre */
		String ligneLue;	/** Variable contenant 1 ligne du fichier */
		String [] contenuLigne;	/** tableau de tous les mots de la ligne */
    	
		try {
			while((ligneLue = f.readLine()) != null){
			
				//Récupération de la ligne
				contenuLigne = ligneLue.split(" ");
				
				//Vérification si elle contient "ligne" ou "colonne"
				if(contenuLigne[0].equals("ligne")){

					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					grille.setLigne(param);
		
				}
				else if(contenuLigne[0].equals("colonne")){
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					grille.setColonne(param);
			
				}				
			}
			
		} catch (IOException e) {
			// Impossible de lire la ligne du fichier
			e.printStackTrace();
		}	
			
    }
    
    
	/**
	 *  Sauvegarde les nombres associé aux parametres du fichier
	 *   
	 * @param f : Buffer contenant le contenu du fichier
	 */
    private void recupereParam(BufferedReader f){
    	int param = 0; /** Variable contenant le nombre associé a un parametre */
		String ligneLue;	/** Variable contenant 1 ligne du fichier */
		String [] contenuLigne;	/** tableau de tous les mots de la ligne */
		Case[][] tableauRepere = grille.getTableau();
		
		
		try {
			int nbCouche = 0;
			while((ligneLue = f.readLine()) != null){
			
				//Récupération de la ligne
				contenuLigne = ligneLue.split(" ");
				
				if(contenuLigne[0].equals("gelatine")){
					

					for(int i = 0; i < grille.getLigne(); i++){
						
						//Récupération de la ligne
						ligneLue = f.readLine();					
						
						for(int j =0; j < grille.getColonne(); j++){
							
							nbCouche = Character.getNumericValue(ligneLue.charAt(j));
							
							tableauRepere[i][j].setGelatine(nbCouche);
							
						}//fin parcours colonne
						
					}// fin parcours ligne
					
				}
				else if(contenuLigne[0].equals("init")){
					
;
			
				}	
				else { 
				
				//Vérification des varables aux debuts de ligne
				switch (contenuLigne[0]) {
				case "score":
					
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setTargetScore(param);
					break;
					
				case "coups":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbCoupMax(param);			
					break;
					
				case "vert":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbVertRestant(param);
					break;
					
				case "rouge":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbRougeRestant(param);
					break;
					
				case "bleu":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbBleuRestant(param);	
					break;
					
				case "jaune":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbJauneRestant(param);	
					break;
					
				case "Orange":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbOrangeRestant(param);	
					break;
					
				case "violet":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbVioletRestant(param);	
					break;
					
				case "raye":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbRayeRestant(param);
					break;
					
				case "emballe":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbEmballeRestant(param);	
					break;
					
				case "multi":
					
					param = Integer.parseInt(contenuLigne[indiceParam(contenuLigne)]);
					objectif.setNbMultiRestant(param);
					break;

				default:
					break;
				}
				
				}//fin si
				
			}//fin boucle while
			
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
    
    private Couleur traduitCouleur(String c){
    	Couleur color;
    	
    	switch (c) {
		case "v":
			color = Couleur.VERT;
			break;
			
		case "r":
			color = Couleur.ROUGE;			
			break;
			
		case "b":
			color = Couleur.BLEU;			
			break;
			
		case "j":
			color = Couleur.JAUNE;		
			break;
			
		case "o":
			color = Couleur.ORANGE;		
			break;

		case "p":
			color = Couleur.VIOLET;	
			break;
			
		default:
			break;
		}
    	
    	return color;
    }
    
}
