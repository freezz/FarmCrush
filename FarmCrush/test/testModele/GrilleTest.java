package testModele;

import static org.junit.Assert.*;
import modele.Coordonnee;
import modele.FarmCrush;

import org.junit.Before;
import org.junit.Test;

public class GrilleTest {

   //Attributs
	private FarmCrush modele;
	 
	@Before
	public void setUp() throws Exception {
		modele = new FarmCrush("annexes/lvltest.txt");
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
	
	public void testEffectuerGravite() {
		assertTrue(modele.grille.BonbonNull(new Coordonnee(0, 0)));
		modele.grille.effectuerGraviter();
		assertFalse(modele.grille.BonbonNull(new Coordonnee(0, 0)));
	}

}
