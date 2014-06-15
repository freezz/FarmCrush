package modele;

/**
 * Coordonnées dans la grille de jeu
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class Coordonnee {
    
	private int x;	//Abscisse de la case
    private int y;	//Ordonnée de la case

  //Constructeurs
    /**
     * Contruit coordonnées de la case
     * @param abs
     * @param ord
     */
    public Coordonnee(int abs, int ord) {
    	this.x = abs;
    	this.y = ord;
    }
    
    /**
     * Retourne l'abscisse de la case
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Retourne l'ordonnée de la case
     * @return y
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * Modifi l'abscisse de la case
     */
    public void setX(int i) {
        this.x = i;
    }

    /**
     * Modifi l'ordonnée de la case
     */
    public void setY(int i) {
        this.y = i;
    }

}
