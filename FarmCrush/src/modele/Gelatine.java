package modele;

/**
 * Gestion de la gélatine d'une case
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class Gelatine {
    private int coucheCase;
    
    
   //Constructeurs
    /**
     * Construit le niveau de Gélatine de la case
     * @param g
     */
    public Gelatine(int g) {
    	this.coucheCase = g;
    }
    
   //Accesseurs
    /**
     * Retourne le niveau de gélatine courant de la poignée
     * @return this.coucheCase
     */
    public int getCoucheGelatine() {
        return (this.coucheCase);
    }
    
   //Méthodes
   /**
    * Retire une couche de gélatine
    */
    public void retirerCouche() {
    	this.coucheCase -= 1;
    }
}
