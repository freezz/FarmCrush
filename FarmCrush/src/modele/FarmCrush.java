package modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FarmCrush extends Observable implements Observer{

	//Looger
	private static final Logger loggerFarmCrush = LogManager.getLogger("modèle.FarmCrush");
		
	//attributs

    private int scoreActuel;
    private int nbCoupJouer;

    public Objectif objectif;
    public Grille grille;

    //Constructeurs
    
    public FarmCrush(String chemin){
    	
    	scoreActuel = 0;
    	nbCoupJouer = 0;
    	objectif = new Objectif();
    	grille = new Grille();
    	
    	
    	//initialisation du modele
    	this.initialisationNiveau(chemin);
    }
    //accesseurs
    
    /**
	 *   
	 *   Retourne la valeur du score actuel
	 * 
	 * @return scoreActuel
	 * 	 
	 */
    public int getScoreActuel() {

        return scoreActuel;
    }
    
	/**
	 *   Retourne la valeur du nb de coup deja joué
	 *   
	 * @return nbCoupJouer
	 * 	 
	 */
    public int getNbCoupJouer() {

        return nbCoupJouer;
    }
    
    //Méthodes
    
	/**
	 *   Méthode codant l'interaction entre 2 bonbons ainsi que toutes les actions qui en découle
	 *   
	 * @param c1 : premiere Coordonnee 
	 *   
	 * @param c1 : deuxieme Coordonnee 
	 */
    public void jouer(final Coordonnee c1, final Coordonnee c2) {

    	
    	//Vérification que les conditions de victoires ou defaites ne sont pas atteintes
    	if(nbCoupJouer <= objectif.getNbCoupMax() && !objectif.estVerifier(scoreActuel)){
    		
    		//recupere les bonbon correspondant au coordonnées
    		Bonbon bonbon1 = grille.getCase(c1.getX(),c1.getY()).getBonbon();
    		Bonbon bonbon2 = grille.getCase(c2.getX(),c2.getY()).getBonbon();
    		
    		loggerFarmCrush.trace("est pret a jouer");
    		
    		if(bonbon1.interagir(bonbon2, grille)){
    			loggerFarmCrush.trace("bonbon1 a interagit correctement avec bonbon2");

    			//on incrémente le nombre de coups joués
        		this.nbCoupJouer++;
        		loggerFarmCrush.trace("Nombre de coup joué : {}", this.nbCoupJouer);
        		
        		grille.effectuerGraviter();
        		this.addObserversBonbons();
    			
    			while(grille.checkGrille()){
    				grille.effectuerGraviter();
    				this.addObserversBonbons();
    			}
    		}
    		else if(bonbon2.interagir(bonbon1, grille)){
    			loggerFarmCrush.trace("bonbon2 a interagit correctement avec bonbon1");
    			
    			//on incrémente le nombre de coups joués
        		this.nbCoupJouer++;
        		loggerFarmCrush.trace("Nombre de coup joué : {}", this.nbCoupJouer);
        		
        		grille.effectuerGraviter();
        		this.addObserversBonbons();
    			
    			while(grille.checkGrille()){
    				grille.effectuerGraviter();
    				this.addObserversBonbons();
    			}
    		}
    		else{
    			loggerFarmCrush.trace("L'interaction entre les deux bonbon a échoué");
    			
    		}
    		
			
    		this.setChanged();
    		this.notifyObservers();
    		
			loggerFarmCrush.trace("Fin de joué");
    		
    		
    	}//fin condition victoire
    	
    	
    }
    
    /**
     * Ajout d'observateur sur chaque bonbon de la grille
     */
    private void addObserversBonbons(){
    	for(int i = 0 ; i < this.grille.getLigne() ; i++){
    		for(int j = 0 ; j < this.grille.getColonne() ; j++){
    			this.grille.getCase(i, j).getBonbon().addObserver(this);
    		}
    	}
    }

	/**
	 *  Effectue toutes les actions necessaires a l'initialisation
	 *  de FarmCrush, Objectif et de la grille 
	 *   
	 * @param chemin : Chemin du fichier d'import du niveau
	 * @param obj : objectif associé au niveau
	 */
    public void initialisationNiveau(String chemin) {
 	
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
		
		loggerFarmCrush.trace("Initialisation Ok - début gravité");
		
		//dans le cas ou dans le fichier niveau il manque des bonbon, on effectue la gravité
		grille.effectuerGraviter();
		this.addObserversBonbons();
		
		loggerFarmCrush.trace("Gravité Ok - début checkGrille");
		
		while(grille.checkGrille()){
			grille.effectuerGraviter();
			this.addObserversBonbons();
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
	 *  Sauvegarde les nombres associé aux parametres du fichier :
	 *  Parcours le fichier a la recherche de parametres puis les initialise
	 *   
	 * @param f : Buffer contenant le contenu du fichier
	 */
    private void recupereParam(BufferedReader f){
    	int param = 0; /** Variable contenant le nombre associé a un parametre */
		String ligneLue;	/** Variable contenant 1 ligne du fichier */
		String [] contenuLigne;	/** tableau de tous les mots de la ligne */

		
		
		try {
			int nbCouche = 0;
			while((ligneLue = f.readLine()) != null){
			
				//Récupération de la ligne
				contenuLigne = ligneLue.split(" ");
				
				if(contenuLigne[0].equals("gelatine")){
					

					for(int j = grille.getLigne()-1; j >= 0; j--){
						
						//Récupération de la ligne
						ligneLue = f.readLine();					
						
						for(int i =0; i < grille.getColonne(); i++){
							
							nbCouche = Character.getNumericValue(ligneLue.charAt(i));
							
							grille.getCase(i, j).setGelatine(nbCouche);
							
						}//fin parcours colonne
						
					}// fin parcours ligne
					loggerFarmCrush.trace("Gelatine complete");
				}
				else if(contenuLigne[0].equals("init")){
					
					char c;
					for(int j = grille.getLigne()-1; j >= 0; j--){
						
						//Récupération de la ligne
						ligneLue = f.readLine();					
						
						for(int i =0; i < grille.getColonne(); i++){
							
							c = ligneLue.charAt(i);
							
							grille.getCase(i, j).setBonbon(traduitCouleur(c));
							grille.getCase(i, j).getBonbon().ajoutCoordonneHistorique(i, j);
							
						}//fin parcours colonne
						
					}// fin parcours ligne
					loggerFarmCrush.trace("Grille remplit");
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
    
	/**
	 *  detecte les espaces entre le premier element de la ligne et le premier parametre
	 *  et renvoi l'indice du tableau de string correspondant au premier parametre
	 *   
	 * @param contenuLigne : Contenu de la ligne
	 * @return indice correspondant au parametre recherché
	 */
    private int indiceParam(String [] contenuLigne){
    	int i = 1;
		while(contenuLigne[i].equals(" ")||contenuLigne[i].equals("")){
			i++;
		}
		return i;
    	
    }
    
    
    /**
	 *  Fonction renvoyant une couleur en fonction du caractere en parametre
	 *   
	 * @param c : caractere representant une couleur
	 * @return couleur correspondant au caractere entré
	 */
    private Couleur traduitCouleur(char c){
    	Couleur color;
    	
    	switch (c) {
		case 'v':
			color = Couleur.VERT;
			break;
			
		case 'r':
			color = Couleur.ROUGE;			
			break;
			
		case 'b':
			color = Couleur.BLEU;			
			break;
			
		case 'j':
			color = Couleur.JAUNE;		
			break;
			
		case 'o':
			color = Couleur.ORANGE;		
			break;

		case 'p':
			color = Couleur.VIOLET;	
			break;
			
		default:
			color = Couleur.JAUNE;
			break;
		}
    	return color;
    }
    
	@Override
	public void update(Observable bonbon, Object arg1) {

		System.out.println("ENTREE UPDATE !!!!!!!!!!!");
		if(bonbon instanceof BonbonNormal){
			this.decrementerObjectifsCouleurs((BonbonNormal) bonbon);
		}
		else if(bonbon instanceof BonbonRaye){
			this.decrementerObjectifsCouleurs((BonbonRaye) bonbon);
			this.objectif.setNbRayeRestant(this.objectif.getNbRayeRestant() - 1);
		}
		else if(bonbon instanceof BonbonEmballe){
			this.decrementerObjectifsCouleurs((BonbonEmballe) bonbon);
			this.objectif.setNbEmballeRestant(this.objectif.getNbEmballeRestant() - 1);
		}
		else if(bonbon instanceof BonbonMulticolore){
			this.objectif.setNbMultiRestant(this.objectif.getNbMultiRestant() - 1);
		}
		else{
			//autre
		}
	}
	
	private void decrementerObjectifsCouleurs(Bonbon b){
		if(b.getCouleur() == Couleur.BLEU && this.objectif.getNbBleuRestant() > 0){
			this.objectif.setNbBleuRestant(this.objectif.getNbBleuRestant() - 1);
		}
		else if(b.getCouleur() == Couleur.VERT && this.objectif.getNbVertRestant() > 0){
			this.objectif.setNbVertRestant(this.objectif.getNbVertRestant() - 1);
		}
		else if(b.getCouleur() == Couleur.ROUGE && this.objectif.getNbRougeRestant() > 0){
			this.objectif.setNbRougeRestant(this.objectif.getNbRougeRestant() - 1);
		}
		else if(b.getCouleur() == Couleur.ORANGE && this.objectif.getNbOrangeRestant() > 0){
			this.objectif.setNbOrangeRestant(this.objectif.getNbOrangeRestant() - 1);
		}
		else if(b.getCouleur() == Couleur.VIOLET && this.objectif.getNbVioletRestant() > 0){
			this.objectif.setNbVioletRestant(this.objectif.getNbVioletRestant() - 1);
		}
		else if(b.getCouleur() == Couleur.JAUNE && this.objectif.getNbJauneRestant() > 0){
			this.objectif.setNbJauneRestant(this.objectif.getNbJauneRestant() - 1);
		}
		else{
			//Null
		}
	}
    
}
