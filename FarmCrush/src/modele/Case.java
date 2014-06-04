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
    public Gelatine gelatine;		//Gelatine présente dans la case
    public Bonbon bonbon;			//Bonbon présent dans la case
    public Coordonnee coordonnee;	//Coordonnées de la case

  //Constructeur
    public Case() {
    }
  
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
