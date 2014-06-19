package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vue.CrushGUI;
import modele.Bonbon;
import modele.Coordonnee;
import modele.FarmCrush;

public class CrushControleur implements ActionListener{
	
	private static final Logger loggerControleur = LogManager.getLogger("controleur.CrushControleur");
	
	private enum Etat {PREMIER_CLICK, DEUXIEME_CLICK};
	private Etat etat;
	private JToggleButton boutonPrecedent;
	private FarmCrush modele;
	private CrushGUI vue;
	
	public CrushControleur(FarmCrush m, CrushGUI v){
		this.modele = m;
		this.vue = v;
		this.etat = Etat.PREMIER_CLICK;
	}
	
	@Override
	public void actionPerformed(ActionEvent boutonEvent) {
		// TODO Auto-generated method stub
		JToggleButton b = (JToggleButton) boutonEvent.getSource();
		
		switch (etat) {
		case PREMIER_CLICK:
			loggerControleur.trace("Entrée dans etat PREMIER_CLICK");
			//on enregistre le bouton sur lequelle on vient d'appuyer
			boutonPrecedent = b;
			
			//on change d'etat
			etat = Etat.DEUXIEME_CLICK;
			break;
			
		case DEUXIEME_CLICK:
			loggerControleur.trace("Entrée dans etat DEUXIEME_CLICK");
			
			Coordonnee coordBoutonPrecedent = trouverCoordonneeBouton(this.vue.getCases(), boutonPrecedent);
			int xPrecedent = coordBoutonPrecedent.getX();
			int yPrecedent = coordBoutonPrecedent.getY();
			
			loggerControleur.trace("Coordonnée premier click : ({},{})", xPrecedent, yPrecedent);
			loggerControleur.trace("Couleur associé : {}", modele.grille.getCase(coordBoutonPrecedent.getX(), coordBoutonPrecedent.getY()).getBonbon().getCouleur());
			loggerControleur.trace("Couleur associé : {}", modele.grille.getCase(coordBoutonPrecedent.getX(), coordBoutonPrecedent.getY()).getBonbon().getClass());
			
			Coordonnee coordBoutonCourant = trouverCoordonneeBouton(this.vue.getCases(), b);
			int xCourant = coordBoutonCourant.getX();
			int yCourant = coordBoutonCourant.getY();

			loggerControleur.trace("Coordonnée deuxieme click : ({},{})", xCourant, yCourant);
			loggerControleur.trace("Couleur associé : {}", modele.grille.getCase(coordBoutonCourant.getX(), coordBoutonCourant.getY()).getBonbon().getCouleur());
			loggerControleur.trace("Couleur associé : {}", modele.grille.getCase(coordBoutonCourant.getX(), coordBoutonCourant.getY()).getBonbon().getClass());
			
			//on verifie que la deuxieme case cliquée est bien cliquable
			if(peutJouer(xCourant, yCourant, xPrecedent, yPrecedent)){
				loggerControleur.trace("Effectuer jouer");
				this.modele.jouer(coordBoutonPrecedent, coordBoutonCourant);
				etat = Etat.PREMIER_CLICK;
			}
			else{
				loggerControleur.warn("La combinaiseon de ces deux cases est impossible");
				loggerControleur.trace("affichage de l'historique");
				//impossible de jouer le coup
				
				//on nettoie la vue
				this.vue.selectionerCase(xCourant, yCourant, false);
				this.vue.selectionerCase(xPrecedent, yPrecedent, false);
				
				//affichage de la boite de dialogue historique
				this.vue.afficherHistorique(xCourant, yCourant);
				
				etat = Etat.PREMIER_CLICK;
			}
			
			if(this.modele.getNbCoupJouer() < this.modele.objectif.getNbCoupMax() && !this.modele.objectif.estVerifier(this.modele.getScoreActuel())){
	    		//on continu
				etat = Etat.PREMIER_CLICK;
				
	    	}//fin condition victoire
	    	else{
	    		
	    		loggerControleur.trace("Fin de de la Partie");
	    		if(this.modele.objectif.estVerifier(this.modele.getScoreActuel())){
	    			
	    			loggerControleur.trace("Partie Gagné");
	    			this.vue.afficherGagne();
	    		}
	    		else{
	    			loggerControleur.trace("Partie Perdu");
	    			this.vue.afficherPerdu();
	    		}
	    		
	    	}
			
			break;

		default:
			//Cas inconnu
			
			break;
		}
		
	}
	
	/**
	 * Retourne vrai si le coup peut etre jouer et faux sinon
	 * @param xCourant
	 * @param yCourant
	 * @param xPrecedent
	 * @param yPrecedent
	 * @return
	 */
	private boolean peutJouer(int xCourant, int yCourant, int xPrecedent, int yPrecedent){
		return (xCourant == xPrecedent + 1 && yCourant == yPrecedent) || 
				(xCourant == xPrecedent -1 && yCourant == yPrecedent) ||
				(xCourant == xPrecedent && yCourant == yPrecedent + 1) ||
				(xCourant == xPrecedent && yCourant == yPrecedent - 1);
	}
	
	/**
	 * 
	 * @param grilleBouton
	 * @param boutonAChercher
	 * @return
	 */
	private Coordonnee trouverCoordonneeBouton(JToggleButton[][] grilleBouton, JToggleButton boutonAChercher) {
		Coordonnee cTrouve = null;
		for (int j = modele.grille.getLigne() -1 ; j >= 0 ; j--) {
		    for (int i = 0 ; i < modele.grille.getColonne() ; i++) {
				if(grilleBouton[i][j] == boutonAChercher){
					loggerControleur.trace("Bouton trouvé dans la grille");
					cTrouve = new Coordonnee(i, j);
				}
			}
		}
		return cTrouve;
		
	}

}
