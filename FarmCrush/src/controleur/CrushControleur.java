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
			Coordonnee coordBoutonCourant = trouverCoordonneeBouton(this.vue.getCases(), b);
			
			Coordonnee coordBoutonPrecedent = trouverCoordonneeBouton(this.vue.getCases(), boutonPrecedent);
			System.out.println(coordBoutonPrecedent.getX() + "," + coordBoutonPrecedent.getY());
			System.out.println(coordBoutonCourant.getX() + "," + coordBoutonCourant.getY());
			loggerControleur.trace("Couleur associé : {}", modele.grille.getCase(coordBoutonCourant.getX(), coordBoutonCourant.getY()).getBonbon().getCouleur());
			loggerControleur.trace("Couleur associé : {}", modele.grille.getCase(coordBoutonPrecedent.getX(), coordBoutonPrecedent.getY()).getBonbon().getCouleur());
			this.modele.jouer(coordBoutonPrecedent, coordBoutonCourant);
			etat = Etat.PREMIER_CLICK;
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
