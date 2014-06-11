package modele;




public class Objectif {

	//attributs
	
    private int score;
    private int nbCoupMax;
    
    private int gelatineRestante;

    private int nbRougeRestant;
    private int nbVioletRestant;
    private int nbVertRestant;
    private int nbJauneRestant;
    private int nbOrangeRestant;
    private int nbBleuRestant;
    
    public int nbRayeRestant;
    public int nbEmballeRestant;
    public int nbMultiRestant;

    
    //Constructeur
	/**
	 * Construit un objectif en mettant tous ces attributs a 0
	 * 	 
	 */   
    public Objectif(){
        score = 0;
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
    }
    
    // Accesseurs
    
	/**
	 * Retourne la valeur du score
	 * @return int 
	 */
    public int getScore() {
        return score;
    }
    
	/**
	 * Modifie la valeur du score
	 * @param s - int 
	 */
    public void setScore(int s) {
        score = s;
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
	 *   Verifie les differents attributs et retourne si les conditions
	 *   pour gagner, sont remplis
	 *   
	 * @param scoreActuel
	 * 				: score actuel de la partie
	 *   
	 * 
	 * @return boolean : retourne vrai si les conditions de victoires sont remplis
	 * sinon retourne faux
	 * 	 
	 */
    public boolean estVerifier() {

        return false;
    }

}
