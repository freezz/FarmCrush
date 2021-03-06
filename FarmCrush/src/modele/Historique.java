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
    private ArrayList<Coordonnee> listeCoordonnees;	//Liste constituant un historique de coordonnées

   //Constructeur
    /**
     * Construit un historique vide
     */
    public Historique() {
    	listeCoordonnees = new ArrayList<Coordonnee>();    	
    }
    
   //Accesseurs
    /**
     * Renvoie l'historique complet des différentes coordonnées de la poignée
     * @return ArrayList<Coordonnee>
     */
    public final ArrayList<Coordonnee> getCoordonnees() {
        return this.listeCoordonnees;
    }
    
   //Méthodes
    /**
     * Ajoute C à l'historique et retourne vrai si ajout réussi
     * @param C
     * @return boolean
     */
    public final boolean histAdd(Coordonnee c) {
    	return (listeCoordonnees.add(c));
    }

}
