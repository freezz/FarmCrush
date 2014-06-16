package testModele;


import static org.junit.Assert.*;
import modele.Gelatine;

import org.junit.Before;
import org.junit.Test;

public class GelatineTest {

   //Attributs
	private Gelatine gel, gel1, gel2, gelnulle;
	
	@Before
	public void setUp() throws Exception {
		gel = new Gelatine(15);
		gel1 = new Gelatine(0);
		gel2 = new Gelatine(50);
		gelnulle = new Gelatine(0);
	}

	@Test
	public void testGetCoucheGelatine() {
		assertTrue(gel.getCoucheGelatine() == 15);
	}

	@Test
	public void testSetGelatine() {
		assertTrue(gel1.getCoucheGelatine() == 0);
		gel1.setGelatine(8);
		assertTrue(gel1.getCoucheGelatine() == 8);
	}

	@Test
	public void testRetirerCoucheNotNull() {
		gel2.retirerCouche();
		assertTrue(gel2.getCoucheGelatine() == 49 );
	}

	@Test
	public void testRetirerCoucheNull() {
		assertTrue(gelnulle.getCoucheGelatine() == 0);
		gelnulle.retirerCouche();
		assertTrue(gelnulle.getCoucheGelatine() == 0);
	}
}
