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
			System.out.println("PREMIER_CLICK");
			//on enregistre le bouton sur lequelle on vient d'appuyer
			boutonPrecedent = b;
			
			//on change d'etat
			etat = Etat.DEUXIEME_CLICK;
			break;
			
		case DEUXIEME_CLICK:
			System.out.println("DEUXIEME_CLICK");
			Coordonnee coordBoutonCourant = trouverCoordonneeBouton(this.vue.getCases(), b);
			//System.out.println(coordBoutonCourant.getX() + "," + coordBoutonCourant.getY());
			Coordonnee coordBoutonPrecedent = trouverCoordonneeBouton(this.vue.getCases(), boutonPrecedent);
			//System.out.println(coordBoutonPrecedent.getX() + "," + coordBoutonPrecedent.getY());
			this.modele.jouer(new Coordonnee(0, 0), new Coordonnee(1, 0));
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
