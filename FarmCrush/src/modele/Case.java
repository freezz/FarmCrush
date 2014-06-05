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
    public Case() {
    }
  
    
    //Methodes
    public void retirerContenu() {
    }

    
    public Bonbon getBonbon() {
    	return null;
    }

    public int getCoordonee() {
        return 0;
    }

    public Gelatine getGelatine() {
        return null;
    }

}
