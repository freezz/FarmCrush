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
	 * @return char
	 */
	public static char genColor() {
		int code = (int) (Math.random() * 6);
		char color = 'z';
		
		switch (code) {
		case 0 :
			color = 'v'; //Vert
			break;
		case 1 :
			color = 'r'; //Rouge
			break;
		case 2 :
			color = 'b';
			break;
		case 3 :
			color = 'j';
			break;
		case 4 :
			color = 'o';
			break;
		case 5	:
			color = 'p';
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
