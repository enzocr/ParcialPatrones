package ac.cr.cenfotec.logica;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Carta> cartas;

	public Naipe() throws Exception {
		this.cartas = new ArrayList<>();
		inicializar();
	}

	public ArrayList<Carta> getNaipe() {
		return cartas;
	}

	public void setNaipe(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public void inicializar() throws Exception {
		inicializarFlores();
		inicializarEscudos();
		inicializarEstrellas();
		inicializarGotas();

	}

	public void inicializarEscudos() throws Exception {
		for (int i = 0; i < 10; i++) {
			Carta carta = new Carta(transformarNombre(i + 1), "Escudos", i + 1);
			cartas.add(carta);
		}
		Carta jota = new Carta("Jota", "Escudos", 10);
		cartas.add(jota);
		Carta quina = new Carta("Quina", "Escudos", 10);
		cartas.add(quina);
		Carta ka = new Carta("Ka", "Escudos", 10);
		cartas.add(ka);
	}

	public void inicializarFlores() throws Exception {
		for (int i = 0; i < 10; i++) {
			Carta carta = new Carta(transformarNombre(i + 1), "Flores", i + 1);
			cartas.add(carta);
		}
		Carta jota = new Carta("Jota", "Flores", 10);
		cartas.add(jota);
		Carta quina = new Carta("Quina", "Flores", 10);
		cartas.add(quina);
		Carta ka = new Carta("Ka", "Flores", 10);
		cartas.add(ka);
	}

	public void inicializarEstrellas() throws Exception {
		for (int i = 0; i < 10; i++) {
			Carta carta = new Carta(transformarNombre(i + 1), "Estrellas", i + 1);
			cartas.add(carta);
		}
		Carta jota = new Carta("Jota", "Estrellas", 10);
		cartas.add(jota);
		Carta quina = new Carta("Quina", "Estrellas", 10);
		cartas.add(quina);
		Carta ka = new Carta("Ka", "Estrellas", 10);
		cartas.add(ka);
	}

	public void inicializarGotas() throws Exception {
		for (int i = 0; i < 10; i++) {
			Carta carta = new Carta(transformarNombre(i + 1), "Gotas", i + 1);
			cartas.add(carta);
		}
		Carta jota = new Carta("Jota", "Gotas", 10);
		cartas.add(jota);
		Carta quina = new Carta("Quina", "Gotas", 10);
		cartas.add(quina);
		Carta ka = new Carta("Ka", "Gotas", 10);
		cartas.add(ka);
	}

	public String transformarNombre(int i) {
		if (i == 1) {
			return "As";
		}
		if (i == 2) {
			return "Dos";
		}
		if (i == 3) {
			return "Tres";
		}
		if (i == 4) {
			return "Cuatro";
		}
		if (i == 5) {
			return "Cinco";
		}
		if (i == 6) {
			return "Seis";
		}
		if (i == 7) {
			return "Siete";
		}
		if (i == 8) {
			return "Ocho";
		}
		if (i == 9) {
			return "Nueve";
		}
		if (i == 10) {
			return "Diez";
		}

		return "N/N";
	}

	@Override
	public String toString() {
		String s = "";

		for (Carta c : cartas) {
			s += c.toString();
		}

		return s;
	}

}
