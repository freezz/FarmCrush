package vue;
import modele.FarmCrush;


public class JeuCandyCrush {

	public static void main(String[] args) {

<<<<<<< HEAD
		FarmCrush modele = new FarmCrush("annexes/niveauTestGrilleVide.txt");
=======
		FarmCrush modele = new FarmCrush("annexes/DemoRayeNormal.txt");
>>>>>>> branch 'master' of https://github.com/freezz/FarmCrush
		
		CrushGUI vue = new CrushGUI(modele);
       	modele.addObserver(vue);
       	
       	
	}

}
