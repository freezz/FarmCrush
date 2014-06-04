package modele;

import java.util.ArrayList;

/**
 * Historique des position dans la grille de jeu
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class Historique {
    public ArrayList<Coordonnee> coordonnees;	//Liste constituant un historique de coordonnées

   //Constructeur
    /**
     * Construit un historique vide
     */
    public Historique () {
    	coordonnees = new ArrayList<Coordonnee>();    	
    }
    
   //Accesseurs
    public Coordonnee getCoordonnee() {
        return null;
    }
    
   //Méthodes
    
    /**
     * Ajoute C à l'historique et retourne vrai si ajout réussi
     * @param C
     * @return boolean
     */
    public boolean histAdd(Coordonnee C) {
    	return (coordonnees.add(C));
    }

}
