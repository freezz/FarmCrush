package testModele;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modele.Coordonnee;
import modele.Historique;

import org.junit.Before;
import org.junit.Test;

public class HistoriqueTest {

   //Attributs
	private Historique hist;
	private Coordonnee coord, coord1;
	
	@Before
	public void setUp() throws Exception {
		hist = new Historique();
		coord = new Coordonnee(3, 4);
		coord1 = new Coordonnee(4, 5);
		hist.histAdd(coord);
	}


	@Test
	public void testGetCoordonnees() {
		assertTrue(hist.getCoordonnees().size() == 1);
		assertTrue(hist.getCoordonnees() instanceof ArrayList<?>);
	}

	@Test
	public void testHistAdd() {
		assertTrue(hist.histAdd(coord1));
	}
}
