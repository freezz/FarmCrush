package modele;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bonbon b = new BonbonNormal();
		Bonbon b1 = new BonbonRaye();
		
		boolean var = b1.interagir(b);
		System.out.println(var);
		
	}

}
