package ac.cr.cenfotec.logica;

public class Carta {

	private String nombre;
	private String palo;
	private int valor;

	public Carta() {
		this.nombre = "";
		this.palo = "";
		this.valor = 0;
	}

	public Carta(String pNombre, String pPalo, int pValor) throws Exception {
		if (!valorNoPermitido(pValor)) {
			throw new Exception("Valor no permitido");
		} else {
			this.nombre = pNombre;
			this.palo = pPalo;
			this.valor = pValor;
		}
	}

	public boolean valorNoPermitido(int pValor) throws Exception {

		if (pValor < 0 || pValor > 12) {
			return false;
		} else {
			return true;
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Carta [nombre=" + nombre + ", palo=" + palo + ", valor=" + valor + "]\n";
	}
}
