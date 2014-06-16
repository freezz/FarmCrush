import vue.CrushGUI;
import modele.FarmCrush;


public class JeuCandyCrush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FarmCrush modele = new FarmCrush("annexes/niveau.txt");
		
		CrushGUI vue = new CrushGUI(modele);
       	modele.addObserver(vue);
       	
       	
	}

}
