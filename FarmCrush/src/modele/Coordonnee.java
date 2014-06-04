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

}
