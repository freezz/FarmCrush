package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vue.CrushGUI;
import modele.FarmCrush;

public class ActionNouvellePartie implements ActionListener {
	
	private FarmCrush modele;
	
	public ActionNouvellePartie(FarmCrush m){
		this.modele = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.modele.initialisationNiveau("annexes/niveauTestGrilleVide.txt");

		this.modele.setNbCoupJouer(0);
		this.modele.setScoreActuel(this.modele.objectif.getTargetScore());
	}

}
