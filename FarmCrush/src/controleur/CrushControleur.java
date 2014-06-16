package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

import vue.CrushGUI;
import modele.Coordonnee;
import modele.FarmCrush;

public class CrushControleur implements ActionListener{
	
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
			//on enregistre le bouton sur lequelle on vient d'appuyer
			boutonPrecedent = b;
			
			//on change d'etat
			etat = Etat.DEUXIEME_CLICK;
			break;
			
		case DEUXIEME_CLICK:
			Coordonnee coordBoutonCourant = trouverCoordonneeBouton(this.vue.getCases(), b);
			Coordonnee coordBoutonPrecedent = trouverCoordonneeBouton(this.vue.getCases(), boutonPrecedent);
			this.modele.jouer(coordBoutonCourant, coordBoutonPrecedent);
			etat = Etat.PREMIER_CLICK;
			break;

		default:
			//Cas inconnu
			break;
		}
		
	}
	
	private Coordonnee trouverCoordonneeBouton(JToggleButton[][] grilleBouton, JToggleButton boutonAChercher) {
		return null;
		
	}

}
