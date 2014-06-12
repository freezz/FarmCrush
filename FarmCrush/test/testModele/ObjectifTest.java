package testModele;

import static org.junit.Assert.*;

import java.lang.annotation.Target;

import modele.Objectif;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class ObjectifTest {

   //Attributs
	protected Objectif obj;
	protected Objectif objEstVerif;

   //Action avant et après l'execution des test
	@Before
	public void setUp() throws Exception {
		//Objectif de test pour getteurs
		obj = new Objectif();
		obj.setTargetScore(1250);
		obj.setNbCoupMax(5);
		obj.setGelatineRestante(32);
		obj.setNbRougeRestant(5);
		obj.setNbVioletRestant(6);
		obj.setNbVertRestant(7);
		obj.setNbJauneRestant(8);
		obj.setNbOrangeRestant(9);
		obj.setNbBleuRestant(10);
		obj.setNbRayeRestant(11);
		obj.setNbEmballeRestant(12);
		obj.setNbMultiRestant(13);
		
		//Objectifs de test pour estVerifier
		objEstVerif = new Objectif();
		objEstVerif.setTargetScore(1350);
	}

	@Test
	public void getTargetScore() {
		assertTrue(obj.getTargetScore() == 1250);
	}
	
	@Test
	public void getNbCoupMax() {
		assertTrue(obj.getNbCoupMax() == 5);
	}
	
	@Test
	public void getGelatineRestante() {
		assertTrue(obj.getGelatineRestante() == 32);
	}
	
	@Test
	public void getNbRougeRestant() {
		assertTrue(obj.getNbRougeRestant() == 5);
	}
	
	@Test
	public void getNbVioletRestant() {
		assertTrue(obj.getNbVioletRestant() == 6);
	}
	
	@Test
	public void getNbVertRestant() {
		assertTrue(obj.getNbVertRestant() == 7);
	}
	
	@Test
	public void getNbJauneRestant() {
		assertTrue(obj.getNbJauneRestant() == 8);
	}
	
	@Test
	public void getNbOrangeRestant() {
		assertTrue(obj.getNbOrangeRestant() == 9);
	}
	
	@Test
	public void getNbBleuRestant() {
		assertTrue(obj.getNbBleuRestant() == 10);
	}
	
	@Test
	public void getNbRayeRestant() {
		assertTrue(obj.getNbRayeRestant() == 11);
	}
	
	@Test
	public void getNbEmballeRestant() {
		assertTrue(obj.getNbEmballeRestant() == 12);
	}
	
	@Test
	public void getNbMultiRestant() {
		assertTrue(obj.getNbMultiRestant() == 13);
	}
	
	@Test
	public void partieGagnee() {
		assertTrue(objEstVerif.estVerifier(2000));
	}
	
	@Test
	public void partiePerduScoreOnly() {
		assertFalse(objEstVerif.estVerifier(10));
	}
	
	@Test
	public void partiePerduBobonOnly() {
		assertFalse(obj.estVerifier(4500));
	}
	
	public void partiePerduScoreBonbon() {
		assertFalse(obj.estVerifier(20));
	}
}
