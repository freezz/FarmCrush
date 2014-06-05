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
    
    //Méthodes
	/**
	 *   Verifi les differents attributs et retourne si les conditions
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
