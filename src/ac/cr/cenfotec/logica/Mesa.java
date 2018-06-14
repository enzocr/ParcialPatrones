package ac.cr.cenfotec.logica;

import java.util.ArrayList;

public class Mesa {

	private Repartidor repartidor;
	private ArrayList<Jugador> jugadores;
	private Naipe deck;

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

	public Naipe getDeck() {
		return deck;
	}

	public void setDeck(Naipe deck) {
		this.deck = deck;
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
		if (!repartir(2)) {
			return null;
		} else {
			for (Jugador jugador : getJugadores()) {
				if (verificarCambio(jugador.getMano())) {
					getRepartidor().cambiarMano(jugador);
				}
			}
			return "El ganador es: " + elGanador(getJugadores()).getNombre();
		}
	}

	public boolean empezarPartidaDeRon() throws Exception {
		if (!repartir(7)) {
			return false;
		} else {
			if (deckIsNull()) {

				for (Jugador jugador : getJugadores()) {
					jugadorCogeCartaDelDeck(jugador);
					this.getDeck().getNaipe().add(jugador.botarCarta());
				}
				return true;
			}

		}
		return false;
	}

	public boolean jugadorCogeCartaDelDeck(Jugador jugador) throws Exception {
		ArrayList<Carta> cartasRepartidas = new ArrayList<>();
		int contador = 0;
		Carta cartaRepartida = null;

		String nombre = this.getDeck().getNaipe().get(contador + 1).getNombre();
		String palo = this.getDeck().getNaipe().get(contador + 1).getPalo();
		Carta carta = new Carta(nombre, palo, this.getDeck().getNaipe().get(contador + 1).getValor());
		cartaRepartida = carta;

		jugador.getMano().add(cartaRepartida);
		cartasRepartidas.add(cartaRepartida);
		this.getDeck().getNaipe().remove(cartaRepartida);
		return true;
	}

	public boolean deckIsNull() throws Exception {
		if (this.deck == null) {
			this.deck = new Naipe();
			return true;
		}
		return true;
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

	@SuppressWarnings("unused")
	public boolean repartir(int x) throws Exception {
		for (int i = 0; i < x; i++) {
			for (Jugador j : getJugadores()) {
				getRepartidor().darCarta(j);
			}
			return true;

		}
		return false;
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

	public boolean reset() throws Exception {
		//this.repartidor = null;
		getRepartidor().getNaipe().inicializar();
		this.jugadores = new ArrayList<>();
		this.deck = null;
		return true;

	}

}