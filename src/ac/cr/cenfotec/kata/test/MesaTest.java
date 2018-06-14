package ac.cr.cenfotec.kata.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ac.cr.cenfotec.logica.Carta;
import ac.cr.cenfotec.logica.Jugador;
import ac.cr.cenfotec.logica.Mesa;
import ac.cr.cenfotec.logica.Naipe;
import ac.cr.cenfotec.logica.Repartidor;

public class MesaTest {

	static Naipe naipe;
	static Repartidor repartidor;
	static Mesa mesa;
	static ArrayList<Jugador> listaJugadores;
	static Jugador jugador1;
	static Jugador jugador2;
	static Jugador jugador3;

	@Before
	public void init() throws Exception {
		naipe = new Naipe();
		repartidor = new Repartidor(naipe);
		listaJugadores = new ArrayList<>();
		mesa = new Mesa(repartidor);

		Jugador jugador1 = new Jugador("Enzo");
		Jugador jugador2 = new Jugador("Alonso");
		Jugador jugador3 = new Jugador("Eduardo");

		mesa.addJugador(jugador1);
		mesa.addJugador(jugador2);
		mesa.addJugador(jugador3);

	}

	@Test(expected = Exception.class)
	public void mesaLlena() throws Exception {

		Jugador jugadorAgregado = new Jugador();
		assertTrue(mesa.addJugador(jugadorAgregado));

		Jugador jugadorNoAgregado = new Jugador();
		assertTrue(mesa.addJugador(jugadorNoAgregado));
	}

	@Test(expected = NullPointerException.class)
	public void empezar21() throws Exception {
		mesa.empezarAJugar21();
		Carta c1 = new Carta("As", "Flores", 1);
		Carta c2 = new Carta("Dos", "Estrellas", 2);
		ArrayList<Carta> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		assertEquals(lista.size(), jugador1.getMano().size());

	}
}