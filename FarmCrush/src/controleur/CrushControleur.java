package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vue.CrushGUI;
import modele.Coordonnee;
import modele.FarmCrush;

public class CrushControleur implements ActionListener{
	
	private static final Logger loggerControleur = LogManager.getLogger("controleur.CrushControleur");
	
	private enum Etat {PREMIER_CLICK, DEUXIEME_CLICK, FIN};
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
			
			Coordonnee coordBoutonCourant = trouverCoordonneeBouton(this.vue.getCases(), b);
			int xCourant = coordBoutonCourant.getX();
			int yCourant = coordBoutonCourant.getY();

			loggerControleur.trace("Coordonnée deuxieme click : ({},{})", xCourant, yCourant);
			loggerControleur.trace("Couleur associé : {}", modele.grille.getCase(coordBoutonCourant.getX(), coordBoutonCourant.getY()).getBonbon().getCouleur());
			
			//on verifie que la deuxieme case cliquée est bien cliquable
			if((xCourant == xPrecedent + 1 || xCourant == xPrecedent - 1 || xCourant == xPrecedent) && (yCourant == yPrecedent + 1 || yCourant == yPrecedent - 1 || yCourant == yPrecedent)){
				loggerControleur.trace("Effectuer jouer");
				//this.modele.jouer(coordBoutonPrecedent, coordBoutonCourant);
				etat = Etat.PREMIER_CLICK;
			}
			else{
				//impossible
				loggerControleur.trace("Impossible de jouer a cet endroit");
			}
			
			break;

		default:
			//Cas inconnu
			break;
		}
		
	}
	
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
