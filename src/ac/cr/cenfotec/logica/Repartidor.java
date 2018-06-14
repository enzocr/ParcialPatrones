package ac.cr.cenfotec.logica;

import java.util.ArrayList;

public class Repartidor {
	private Naipe naipe;

	public Repartidor() {
		this.naipe = null;
	}

	public Repartidor(Naipe naipe) {
		this.setNaipe(naipe);
	}

	public Naipe getNaipe() {
		return naipe;
	}

	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}

	public boolean darCarta(Jugador jugador) throws Exception {
		ArrayList<Carta> cartasRepartidas = new ArrayList<>();
		int contador = 0;
		Carta cartaRepartida = null;
		do {

			String nombre = this.getNaipe().getNaipe().get(contador + 1).getNombre();
			String palo = this.getNaipe().getNaipe().get(contador + 1).getPalo();
			Carta carta = new Carta(nombre, palo, this.getNaipe().getNaipe().get(contador + 1).getValor());
			cartaRepartida = carta;

		} while (cartaRepartida == null);

		jugador.getMano().add(cartaRepartida);
		cartasRepartidas.add(cartaRepartida);
		this.getNaipe().getNaipe().remove(cartaRepartida);
		return true;
	}
}
