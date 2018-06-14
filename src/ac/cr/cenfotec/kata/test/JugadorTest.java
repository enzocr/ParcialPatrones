package ac.cr.cenfotec.kata.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ac.cr.cenfotec.logica.Carta;
import ac.cr.cenfotec.logica.Jugador;

public class JugadorTest {

	static Jugador j = new Jugador();

	@Test
	public void cartasJugadoresNoSonIguales() throws Exception {

		Carta c1 = new Carta("As", "Flores", 1);
		Carta c2 = new Carta("Dos", "Estrellas", 2);
		Carta c3 = new Carta("Tres", "Escudos", 3);
		Carta c4 = new Carta("Cuatro", "Gotas", 4);

		Jugador j1 = new Jugador();
		j1.getMano().add(c1);
		j1.getMano().add(c2);

		Jugador j2 = new Jugador();
		j2.getMano().add(c3);
		j2.getMano().add(c4);

		assertFalse(j1.equals(j2));
	}

	@Test(expected = Exception.class)
	public void pruebasJugadores() throws Exception {
		ArrayList<Carta> mano = new ArrayList<>();

		Carta c1 = new Carta("As", "Flores", 1);
		Carta c2 = new Carta("Dos", "Estrellas", 2);
		mano.add(c1);
		mano.add(c2);

		Jugador j3 = new Jugador(null);
		j3.getMano().add(c1);
		Jugador j4 = new Jugador("");
		j4.getMano().add(c2);
		assertFalse(j3.equals(j4));
	}
}
