package modele;

/**
 * Modelise une case de la grille de jeu
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class Case {
	
  //Attributs
    public Gelatine gelatine;		
    public Bonbon bonbon;			
    public Coordonnee coordonnee;	

  //Constructeurs
    /**
     * Construit une case avec ses coordonnées, le niveau de gélatine et le bonbon
     * @param x
     * @param y
     * @param b
     */
    public Case(int x, int y, Bonbon b) {
    	this.coordonnee = new Coordonnee(x, y);
    	this.gelatine = new Gelatine(0);
    	this.bonbon = b;
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

  //Methodes
    /**
     * Supprime le contenu d'une case, bonbon et gélatine
     * @param g - Grille
     */
    public void retirerContenu(Grille g) {
    	this.gelatine.retirerCouche();
    	this.bonbon.destruction(g);
    }
}
