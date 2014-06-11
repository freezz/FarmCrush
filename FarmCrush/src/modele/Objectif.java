package modele;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Gestion des objectifs à atteindre pour gagner la partie 
 * @author Thibault
 * @author Jean-Baptiste
 * @author Grégoire
 * @version 0.1
 */

public class Objectif {
	
   //Looger
	private static final Logger loggerObjective = LogManager.getLogger("modèle.objectif");

   //attributs
    private int targetScore;		//Score à atteindre
    private int nbCoupMax;			//Nombre de coup jouable maximum
    
    private int gelatineRestante;	//Nombre Gélatine restant à détruire

    private int nbRougeRestant;		//Nombre de bonbon rouge restant à détruire
    private int nbVioletRestant;	//Nombre de bonbon violet restant à détruire
    private int nbVertRestant;		//Nombre de bonbon vert restant à détruire
    private int nbJauneRestant;		//Nombre de bonbon jaune restant à détruire
    private int nbOrangeRestant;	//Nombre de bonbon orange restant à détruire
    private int nbBleuRestant;		//Nombre de bonbon bleu restant à détruire
    
    public int nbRayeRestant;		//Nombre de bonbon rayé restant à détruire
    public int nbEmballeRestant;	//Nombre de bonbon emballé restant à détruire
    public int nbMultiRestant;		//Nombre de bonbon multicolore restant à détruire

    
   //Constructeurs
	/**
	 * Construit un objectif en mettant tous ses attributs a 0
	 */   
    public Objectif(){
        targetScore = 0;
        nbCoupMax = 0;
        
        gelatineRestante = 0;

        nbRougeRestant = 0;
        nbVioletRestant = 0;
        nbVertRestant = 0;
        nbJauneRestant = 0;
        nbOrangeRestant = 0;
        nbBleuRestant = 0;
        
        nbRayeRestant = 0;
        nbEmballeRestant = 0;
        nbMultiRestant = 0;
        
        loggerObjective.debug("Initialisation des objectifs à 0");
    }
    
    // Accesseurs
    
	/**
	 * Retourne la valeur du score
	 * @return int 
	 */
    public int getTargetScore() {
        return targetScore;
    }
    
	/**
	 * Modifie la valeur du score
	 * @param s - int 
	 */
    public void setTargetScore(int s) {
        targetScore = s;
        loggerObjective.debug("Mise à jour du targetScore, nouvelle valeur : {}", s);
    }
    
    /**
     * Retourne le nombre de coup maximum
     * @return int
     */
    public int getNbCoupMax() {
		return nbCoupMax;
	}
    
    /**
     * Modifie le nombre de coup maximum
     * @param nbCoupMax
     */
    public void setNbCoupMax(int nbCoupMax) {
		this.nbCoupMax = nbCoupMax;
		loggerObjective.debug("Mise à jour du nombre de coup maximum jouable, nouvelle valeur : {}", nbCoupMax);
	}
    
    /**
     * Retourne le niveau de gélatine restant
     * @return int
     */
    public int getGelatineRestante() {
		return gelatineRestante;
	}
    
    /**
     * Modifie le niveau de gélatine restant
     * @param gelatineRestante
     */
    public void setGelatineRestante(int gelatineRestante) {
		this.gelatineRestante = gelatineRestante;
	}
    
    /**
     * Retourne le nombre de bonbon rouge restant
     * @return int
     */
    public int getNbRougeRestant() {
		return nbRougeRestant;
	}
    
    /**
     * Modifie le nombre de bonbon rouge restant
     * @param nbRougeRestant
     */
    public void setNbRougeRestant(int nbRougeRestant) {
		this.nbRougeRestant = nbRougeRestant;
	}
    
    /**
     * Retourne le nombre de bonbon violet restant
     * @return int
     */
    public int getNbVioletRestant() {
		return nbVioletRestant;
	}
    
    /**
     * Modifie le nombre de bonbon violet restant
     * @param nbVioletRestant
     */
    public void setNbVioletRestant(int nbVioletRestant) {
		this.nbVioletRestant = nbVioletRestant;
	}
    
    /**
     * Retourne le nombre de bonbon vert restant
     * @return int
     */
    public int getNbVertRestant() {
		return nbVertRestant;
	}
    
    /**
     * Modifie le nombre de bonbon vert restant
     * @param nbVertRestant
     */
    public void setNbVertRestant(int nbVertRestant) {
		this.nbVertRestant = nbVertRestant;
	}
    
    /**
     * Retourne le nombre de bonbon jaune restant
     * @return int
     */
    public int getNbJauneRestant() {
		return nbJauneRestant;
	}
    
    /**
     * Modifie le nombre de bonbon jaune restant
     * @param nbJauneRestant
     */
    public void setNbJauneRestant(int nbJauneRestant) {
		this.nbJauneRestant = nbJauneRestant;
	}
    
    /**
     * Retourne le nombre de bonbon orange restant
     * @return int
     */
    public int getNbOrangeRestant() {
		return nbOrangeRestant;
	}
    
    /**
     * Modifie le nombre de bonbon orange restant
     * @param nbOrangeRestant
     */
    public void setNbOrangeRestant(int nbOrangeRestant) {
		this.nbOrangeRestant = nbOrangeRestant;
	}
    
    /**
     * Retourne le nombre de bonbon bleu restant
     * @return int
     */
    public int getNbBleuRestant() {
		return nbBleuRestant;
	}
    
    /**
     * Modifie le nombre de bonbon bleu restant
     * @param nbBleuRestant
     */
    public void setNbBleuRestant(int nbBleuRestant) {
		this.nbBleuRestant = nbBleuRestant;
	}
    
    /**
     * Retourne le nombre de bonbon rayé restant
     * @return int
     */
    public int getNbRayeRestant() {
		return nbRayeRestant;
	}
    
    /**
     * Modifie le nombre de bonbon rayé restant
     * @param nbRayeRestant
     */
    public void setNbRayeRestant(int nbRayeRestant) {
		this.nbRayeRestant = nbRayeRestant;
	}
    
    /**
     * Retourne le nombre de bonbon emballé restant
     * @return int
     */
    public int getNbEmballeRestant() {
		return nbEmballeRestant;
	}
    
    /**
     * Modifie le nombre de bonbon emballé restant
     * @param nbEmballeRestant
     */
    public void setNbEmballeRestant(int nbEmballeRestant) {
		this.nbEmballeRestant = nbEmballeRestant;
	}
    
    /**
     * Retourne le nombre de bonbon multicolore restant
     * @return int
     */
    public int getNbMultiRestant() {
		return nbMultiRestant;
	}
    
    /**
     * Mmodifie le nombre de bonbon multicolore restant
     * @param nbMultiRestant
     */
    public void setNbMultiRestant(int nbMultiRestant) {
		this.nbMultiRestant = nbMultiRestant;
	}
    
    
   //Méthodes
	/**
	 * Verifie les conditions de victoire, retourne vrai si rempli, faux sinon
	 * @param scoreCourant - int : score courant
	 * @return boolean : estGagnee - boolean
	 */
    public boolean estVerifier(int scoreCourant) {
        return (
        		this.targetScore >= scoreCourant &&
        		this.nbCoupMax == 0 &&
        		this.gelatineRestante == 0 &&
        		this.nbRougeRestant == 0 &&
        		this.nbVioletRestant == 0 &&
        		this.nbVertRestant == 0 &&
        		this.nbJauneRestant == 0 &&
        		this.nbOrangeRestant == 0 &&
        		this.nbBleuRestant == 0 &&
        		this.nbRayeRestant == 0 &&
        		this.nbEmballeRestant == 0 &&
        		this.nbMultiRestant == 0
        		);
    }

}
