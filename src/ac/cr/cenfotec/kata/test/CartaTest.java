package ac.cr.cenfotec.kata.test;

import org.junit.Test;

import ac.cr.cenfotec.logica.Carta;

public class CartaTest {

	static Carta carta = new Carta();

	@Test(expected = Exception.class)
	public void menorQueCero() throws Exception {
		new Carta("Tres", "Estrellas", -80);
	}

	@Test(expected = Exception.class)
	public void mayorQueDoce() throws Exception {
		new Carta("Tres", "Estrellas", 80);
	}

	@Test
	public void entreCeroYDoce() throws Exception {
		new Carta("Tres", "Estrellas", 3);
	}

}