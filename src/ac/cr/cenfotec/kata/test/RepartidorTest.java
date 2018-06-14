package ac.cr.cenfotec.kata.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ac.cr.cenfotec.logica.Jugador;
import ac.cr.cenfotec.logica.Naipe;
import ac.cr.cenfotec.logica.Repartidor;

public class RepartidorTest {

	static Naipe naipe;
	static Repartidor repartidor;
	static Jugador jugador;

	@Before
	public void init() throws Exception {
		naipe = new Naipe();
		repartidor = new Repartidor(naipe);
		jugador = new Jugador("Enzo");
		System.out.println(naipe.toString());
	}

	@Test
	public void repartidorDioCarta() throws Exception {
		assertTrue(repartidor.darCarta(jugador));
	}

}
