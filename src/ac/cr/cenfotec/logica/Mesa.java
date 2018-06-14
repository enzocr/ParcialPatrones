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
}