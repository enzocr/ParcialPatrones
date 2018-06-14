package ac.cr.cenfotec.logica;

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
}
