package ac.cr.cenfotec.kata.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ac.cr.cenfotec.logica.Carta;

public class CartaTest {

	static Carta carta;
	static Carta uno;
	static Carta dos;
	static Carta tres;

	@Before
	public void init() throws Exception {
		carta = new Carta();
		uno = new Carta("Diez", "Escudos", 10);
		dos = new Carta("Diez", "Flores", 10);
		tres = new Carta("Ocho", "Flores", 8);
	}

	@Test(expected = Exception.class)
	public void menorQueCero() throws Exception {
		Carta prueba = new Carta("Tres", "Estrellas", -80);
		assertFalse(uno.equals(prueba));
	}

	@Test(expected = Exception.class)
	public void mayorQueDoce() throws Exception {
		Carta prueba = new Carta("Tres", "Estrellas", 80);
		assertFalse(dos.equals(prueba));
	}

	@Test
	public void entreCeroYDoce() throws Exception {
		Carta prueba = new Carta("Tres", "Estrellas", 3);
		assertFalse(tres.equals(prueba));
	}

	@Test
	public void cartasIguales() throws Exception {

		assertTrue(uno.equals(dos));
		assertFalse(dos.equals(tres));
	}

}