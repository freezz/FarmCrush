package testModele;

import static org.junit.Assert.*;
import modele.Bonbon;
import modele.Coordonnee;
import modele.FarmCrush;

import org.junit.Before;
import org.junit.Test;

public class GrilleTest {

   //Attributs
	private FarmCrush modele, modele1, modele2;
	 
	@Before
	public void setUp() throws Exception {
		modele = new FarmCrush("annexes/lvltest.txt");
		modele1 = new FarmCrush("annexes/lvltest.txt");
		modele2 = new FarmCrush("annexes/lvltest.txt");
	}
	
	@Test
	public void testGetColonne () {
		assertTrue(modele.grille.getColonne() == 9);
	}
	
	@Test
	public void testGetLigne() {
		assertTrue(modele.grille.getLigne() == 9);
	}
	
	@Test
	public void testBonbonNull() {
		assertFalse(modele.grille.BonbonNull(new Coordonnee(0, 0)));
	}
	
	@Test
	public void testSupprimerBonbon() {
		modele.grille.supprimerBonbonCase(new Coordonnee(0, 0));
		assertTrue(modele.grille.BonbonNull(new Coordonnee(0, 0)));
	}
		
	@Test
	public void testEffectuerGraviter() {
		modele1.grille.supprimerBonbonCase(new Coordonnee(0, 0));
		modele1.grille.supprimerBonbonCase(new Coordonnee(4, 6));
		assertTrue(modele1.grille.BonbonNull(new Coordonnee(4, 6)));
		assertTrue(modele1.grille.BonbonNull(new Coordonnee(0, 0)));
		modele1.grille.effectuerGraviter();
		assertFalse(modele1.grille.BonbonNull(new Coordonnee(0, 0)));
		assertFalse(modele1.grille.BonbonNull(new Coordonnee(4, 6)));
		
	}

}
