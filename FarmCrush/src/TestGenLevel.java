import modele.Couleur;

public class TestGenLevel {

	public static void main(String[] args) {
		
		for (int i = 0; i < 15; i++) {
			System.out.print(genColor() + " ");
		}
		System.out.println();
		for (int i = 0; i < 15; i++) {
			System.out.print(genColor() + " ");
		}
		System.out.println();
		for (int i = 0; i < 15; i++) {
			System.out.print(genColor() + " ");
		}
		

	}
	
	/** Genère un caractère codant une couleur de bonbon
	 * @author Grégoire
	 * @return Couleur
	 */
	public static Couleur genColor() {
		int code = (int) (Math.random() * 6);
		Couleur color = Couleur.VERT;
		
		switch (code) {
		case 0 :
			color = Couleur.VERT; //Vert
			break;
		case 1 :
			color = Couleur.ROUGE; //Rouge
			break;
		case 2 :
			color = Couleur.BLEU;
			break;
		case 3 :
			color = Couleur.JAUNE;
			break;
		case 4 :
			color = Couleur.ORANGE;
			break;
		case 5	:
			color = Couleur.VIOLET;
			break;
		default:
			//ideal raise une exception mais on ne devrait jamais arriver ici
			System.out.println("La valeur ne correspond à aucune couleur");
			System.out.println(code);
			break;
		}
		
		return color;
	}

}
