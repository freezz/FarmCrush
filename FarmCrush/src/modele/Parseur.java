package modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parseur {

	int nbLigne;
	int nbColonne;
	
	int scoreMax;
	int nbCoupsMax;
	
	int nbVert;
	int nbRouge;	
	int nbBleu;
	int nbJaune;
	int nbOrange;
	int nbViolet;
	
	int nbRaye;
	int nbEmballe;
	int nbMulticolor;
	
	String[] gelatine = new String[9];
	String[] init = new String[9];
	
	public Parseur (){
		nbLigne = 0;
		nbColonne = 0;
	}
	
	public void initialise(){
		String ligneLue;
		String [] contenuLigne;
		
		
		try {
			BufferedReader f = new BufferedReader(new FileReader("niveau.txt"));
			
			try {
				while((ligneLue = f.readLine()) != null){
					
					
					contenuLigne = ligneLue.split(" ");
					System.out.println(contenuLigne[0]); 
					
										
					}
					f.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public void majObjectif(String[] ligne){ //passer obj en param
	
		switch (ligne[0]) {
		case "ligne":
			
			break;
			
		case "colonne":
			
			break;
			
		case "score":
			
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
			
		case "orange":
			
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
		
	}
	
}
