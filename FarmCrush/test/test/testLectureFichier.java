package test;

import modele.*;

public class testLectureFichier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		FarmCrush boulangere = new FarmCrush("annexes/niveau.txt");
		boulangere.jouer(new Coordonnee(0, 0), new Coordonnee(0, 1));
		boulangere.jouer(new Coordonnee(3, 3), new Coordonnee(4, 3));
	}

}
