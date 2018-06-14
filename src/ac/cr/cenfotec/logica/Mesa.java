package ac.cr.cenfotec.logica;

import java.util.ArrayList;

public class Mesa {

	private Repartidor repartidor;
	private ArrayList<Jugador> jugadores;

	public Mesa() {
		this.repartidor = null;
		this.jugadores = new ArrayList<>();
	}

	public Mesa(Repartidor repartidor) {
		this.repartidor = repartidor;

	}

	public Repartidor getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public boolean addJugador(Jugador jugador) throws Exception {
		if (jugadoresIsNull()) {

			if (getJugadores().size() == 4) {
				throw new Exception("Mesa llena");
			} else {
				getJugadores().add(jugador);
				return true;
			}
		}
		return false;

	}

	public boolean jugadoresIsNull() {
		if (this.jugadores == null) {
			this.jugadores = new ArrayList<>();
			return true;
		}
		return true;
	}

	public String empezarAJugar21() throws Exception {
		repartir();
		for (Jugador jugador : getJugadores()) {
			if (verificarCambio(jugador.getMano())) {
				getRepartidor().cambiarMano(jugador);
			}
		}
		return "El ganador es: " + elGanador(getJugadores()).getNombre();
	}

	public Jugador elGanador(ArrayList<Jugador> listaJugadores) throws Exception {
		Jugador ganador = null;
		int valor = 0;
		int mayor = 0;

		for (Jugador jugador : listaJugadores) {
			if (verificarComodin(jugador.getMano())) {
				ganador = jugador;
				return ganador;
			}

			else if (verificar21YMedio(jugador.getMano())) {
				ganador = jugador;
				return ganador;
			} else {

				for (Carta carta : jugador.getMano()) {
					valor += carta.getValor();
				}
				if (valor == mayor) {
					ganador = new Jugador("EMPATE");
				}
				if (valor > mayor) {
					ganador = jugador;
				}
			}
		}
		return ganador;
	}

	public void repartir() throws Exception {
		for (int i = 0; i < 2; i++) {
			for (Jugador j : getJugadores()) {
				getRepartidor().darCarta(j);
			}
			for (Jugador j : getJugadores()) {
				getRepartidor().darCarta(j);
			}

		}
	}

	public boolean verificarComodin(ArrayList<Carta> mano) {

		for (Carta carta : mano) {
			if (carta.getNombre().equals("Jota") && carta.getPalo().equals("Escudos")) {
				return true;
			}
		}
		return false;

	}

	public boolean verificarCambio(ArrayList<Carta> mano) {
		int valido = 0;
		for (Carta carta : mano) {
			if (carta.getNombre().equals("Jota") || carta.getNombre().equals("Quina")
					|| carta.getNombre().equals("Ka")) {
				valido++;
			}
			if (carta.getNombre().equals("Tres")) {
				valido++;
			}
		}
		if (valido == 2) {
			return true;

		} else {
			return false;
		}
	}

	public boolean verificar21YMedio(ArrayList<Carta> mano) {
		int valido = 0;
		for (Carta carta : mano) {
			if (carta.getNombre().equals("Jota") || carta.getNombre().equals("Quina")
					|| carta.getNombre().equals("Ka")) {
				valido++;
			}
			if (carta.getNombre().equals("Dos")) {
				valido++;
			}
		}
		if (valido == 2) {
			return true;

		} else {
			return false;
		}
	}
}