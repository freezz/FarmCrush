package modele;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Modelise une case de la grille de jeu
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.2
 */

public class Case {
	
  //Attributs
    public Gelatine gelatine;		
    public Bonbon bonbon;			
    public Coordonnee coordonnee;	
    
  //Looger
  	private static final Logger loggerCase = LogManager.getLogger("modèle.Case");
    
    //Constructeurs
  	
    /**
     * Construit une case avec ses coordonnées et le bonbon
     * @param x
     * @param y
     * @param b
     */
    public Case(int x, int y, Bonbon b) {
    	this.coordonnee = new Coordonnee(x, y);
    	this.gelatine = new Gelatine(0);
    	this.bonbon = b;
    }
    
    /**
     * Construit une case vide
     * @param x
     * @param y
     */
    public Case(int x, int y) {
    	this.coordonnee = new Coordonnee(x, y);
    	this.gelatine = new Gelatine(0);
    	this.bonbon = null;
    }
    
  //Accesseurs
    /**
     * Retourne le bonbon présent dans la poignée
     * @return bonbon
     */
    public Bonbon getBonbon() {
    	return bonbon;
    }

    
    /**
     * Crée une nouveau bonbon avec une nouvelle couleur
     */
    public void setBonbon(Couleur c) {
    	bonbon = new BonbonNormal(c);
    }
    
    /**
     * Modifie la couleur du bonbon présent dans la poignée
     */
    public void setBonbon(Bonbon b) {
    	bonbon = b;
    }
    
    /**
     * Créer un nouveau bonbon aléatoirement
     */
    public void setBonbonAleatoire() {
    	
    	int code = (int) (Math.random() * 6);
		Couleur color = Couleur.VERT;
		
		switch (code) {
		case 0 :
			color = Couleur.VERT;
			break;
		case 1 :
			color = Couleur.ROUGE;
			break;
		case 2 :
			color = Couleur.BLEU;
			break;
		case 3 :
			color = Couleur.JAUNE;
			break;
		case 4 :
			color = Couleur.ORANGE;
			break;
		case 5	:
			color = Couleur.VIOLET;
			break;
		default:
			throw new RuntimeException("Couleur Inexistante");
		}
		
    	bonbon = new BonbonNormal(color);
    }
    
    /**
     * Supprime un bonbon
     */
    public void supBonbon() {
    	bonbon = null;
    }
    
    /**
     * Retourne les coordonnées de la poignnée
     * @return Coordonnee
     */
    public Coordonnee getCoordonee() {
        return this.coordonnee;
    }

    /**
     * Retourne la gélatine de la poignée
     * @return Gelatine
     */
    public Gelatine getGelatine() {
        return gelatine;
    }
    
    /**
     * Modifie la gélatine de la poignée
     *
     */
    public void setGelatine(int nbCouche) {
        gelatine = new Gelatine(nbCouche);
    }

  //Methodes
    /**
     * Supprime le contenu d'une case, bonbon et gélatine
     * @param g - Grille
     */
    public void retirerContenu(Grille g) {
    	this.gelatine.retirerCouche();
    	this.bonbon.destruction(g);
    	loggerCase.trace(" Un bonbon est enlevé dans la case : {} {}", coordonnee.getX(), coordonnee.getY());
    }
}
