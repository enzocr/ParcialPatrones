package ac.cr.cenfotec.logica;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<Carta> mano;

	public Jugador() {
		this.nombre = null;
		this.mano = new ArrayList<>();
	}

	public Jugador(String nombre) throws Exception {
		if (nombre == null) {
			throw new Exception("Nombre nulo");
		} else if (nombre == "") {
			throw new Exception("Nombre vacio");
		} else {
			this.nombre = nombre;
			this.mano = new ArrayList<>();

		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Carta> getMano() {
		return mano;
	}

	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mano == null) ? 0 : mano.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (mano == null) {
			if (other.mano != null)
				return false;
		} else if (!mano.equals(other.mano))
			return false;
		return true;
	}

	public Carta cogerCarta(Carta carta) throws Exception {

		if (getMano().add(carta)) {
			return carta;
		}
		return null;
	}

	public Carta botarCarta() {
		int numeroRandom = (int) (Math.random() * 2) + 1;
		Carta carta = getMano().get(numeroRandom);
		return carta;
	}

}
