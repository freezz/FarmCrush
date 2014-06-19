
import vue.CrushGUI;
import modele.FarmCrush;


public class JeuCandyCrush {

	public static void main(String[] args) {


		FarmCrush modele = new FarmCrush("/home/Freez/Documents/CandyDossierTest/annexes/niveauTestGrilleVide.txt");
		
		CrushGUI vue = new CrushGUI(modele);
       	modele.addObserver(vue);
       	
       	
	}

}
