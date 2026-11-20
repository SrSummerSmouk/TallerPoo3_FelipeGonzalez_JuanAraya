package TallerPoo3_FelipeGonzalez_JuanAraya;
//Felipe Gonzalez - 21.776.516-1 - ITI

//Juan Araya - 21.566.260-8 - ITI

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SistemaImpl sistema = new SistemaImpl();
		sistema.inicializarMinijuegos();

		cargarMonster(sistema, "Monstruos.txt");
		cargarRegistros(sistema, "Registros.txt");

		System.out.println(sistema.getMonstruos().size() + " monstruos cargados");
		System.out.println(sistema.getJugadores().size() + " jugadores cargados");

		if (sistema.getMonstruos().isEmpty()) {
			System.out.println("No hay monstruos validos. Apagando");
			return;
		}

		boolean salir = false;
		while (!salir) {
			String nombre = pedirNombre();
			sistema.iniciarSesion(nombre);
			if (sistema.esJugadorNuevo()) {
				System.out.println("¡Bienvenido, " + nombre + "! Es tu primera vez jugando.");
			} else {
				System.out.println("¡Bienvenido de vuelta, " + nombre + "! Récord: "
						+ sistema.getJugadorActual().getPuntajeMaximo() + " pts.");
			}

			boolean sesion = true;
			while (sesion) {
				System.out.println("--- MENÚ PRINCIPAL (" + nombre + ") ---");
				System.out.println("1) Jugar un minijuego");
				System.out.println("2) Ver catálogo de monstruos");
				System.out.println("3) Ver historial de la sesión");
				System.out.println("4) Ver ranking de jugadores");
				System.out.println("5) Terminar sesión");
				System.out.println("6) Salir");
				int op = leerEntero(1, 6);
				if (op == -1)
					continue;

				switch (op) {
				case 1:
					jugarMinijuego(sistema);
					break;
				case 2:
					verCatalogo(sistema);
					break;
				case 3:
					verHistorial(sistema);
					break;
				case 4:
					verRanking(sistema);
					break;
				case 5:
					System.out.println("Sesión terminada. Puntaje total: " + sistema.getPuntajeSesion() + " puntos.");
					System.out.println(sistema.finalizarSesion());
					guardarRegistros(sistema, "Registros.txt");
					System.out.println("Registros guardados.");
					sesion = false;
					break;
				case 6:
					System.out.println(sistema.finalizarSesion());
					guardarRegistros(sistema, "Registros.txt");
					sesion = false;
					salir = true;
					break;
				}
			}
		}
		System.out.println("adios");
	}

	private static void verCatalogo(SistemaImpl sistema) {
		// TODO Auto-generated method stub
		ArrayList<Monstruo> catalogo = sistema.getMonstruos();
		System.out.println("---- Catalogo de monstruos ----\n");
		for (int i = 0; i < catalogo.size(); i++) {
			Monstruo monstruo = catalogo.get(i);
			System.out.println((i + 1) + ". " + monstruo.toString());
		}
	}

	private static void jugarMinijuego(SistemaImpl sistema) {
		// TODO Auto-generated method stub
		ArrayList<Minijuego> jMinijuegos = sistema.getMinijuegos();
		for (int i = 0; i < jMinijuegos.size(); i++) {
			Minijuego mj = jMinijuegos.get(i);
			String estado = "";
			if (sistema.minijuegoYaJugado(mj.getNombre())) {
				estado = " -YA JUGADO-";
			}
			System.out.println((i + 1) + ". " + mj.getNombre() + " | " + mj.getDescripcion() + estado);
		}
		int opJuego = leerEntero(1, jMinijuegos.size());
		if (opJuego == -1) {
			return;
		}
		Minijuego juegoElegido = jMinijuegos.get(opJuego - 1);
		if (sistema.minijuegoYaJugado(juegoElegido.getNombre())) {
			System.out.println("Ya jugaste este minijuego en esta sesion.\n");
			return;
		}
		ArrayList<Monstruo> libresArrayList = sistema.mostrarMonsterLibres();
		if (libresArrayList.isEmpty()) {
			System.out.println("no hay monstrous disponibles. \n");
			return;
		}
		System.out.println("\n---Monstruos disponibles---");
		for (int i = 0; i < libresArrayList.size(); i++) {
			System.out.println((i + 1) + ". " + libresArrayList.get(i).toString());
		}
		int opMonstruo = leerEntero(1, jMinijuegos.size());
		if (opMonstruo == -1) {
			return;
		}
		Monstruo monstruoElegido = libresArrayList.get(opMonstruo - 1);
		ArrayList<String> habilidades = new ArrayList<>();
		ArrayList<String> mensajesDeAccion = new ArrayList<>();
		if (monstruoElegido instanceof Mordedor) {
			habilidades.add("mordedor");
			mensajesDeAccion.add(((Mordedor) monstruoElegido).morder());
		}
		if (monstruoElegido instanceof Volador) {
			habilidades.add("volador");
			mensajesDeAccion.add(((Volador) monstruoElegido).volar());
		}
		if (monstruoElegido instanceof Regenerable) {
			habilidades.add("regenerable");
			mensajesDeAccion.add(((Regenerable) monstruoElegido).regenerarse());
		}
		if (monstruoElegido instanceof Furioso) {
			habilidades.add("furioso");
			mensajesDeAccion.add(((Furioso) monstruoElegido).enfurecerse());
		}
		String habilidadString = "none";

		boolean efectiva = false;
		if (!habilidades.isEmpty()) {
			System.out.println("Usar habilidad | 0 = cancelar\n");
			for (int i = 0; i < habilidades.size(); i++) {
				System.out.println((i + 1) + ". " + habilidades.get(i));
			}
			int opHabilidad = leerEntero(0, habilidades.size());
			if (opHabilidad == -1) {
				return;

			}
			if (opHabilidad > 0) {
				habilidadString = habilidades.get(opHabilidad - 1);
				System.out.println(mensajesDeAccion.get(opHabilidad - 1));
				if (habilidadString.equalsIgnoreCase(juegoElegido.getHabilidadPremiada())) {
					efectiva = true;
					System.out.println("habilidad efectiva - Bonificacion aplicada.");
				} else {
					System.out.println("la habilidad no coincide con la premiada.");
				}
			}
		}
		double potencial = sistema.calcularPotencial(juegoElegido, monstruoElegido);
		int puntaje = sistema.calcularPuntaje(potencial, efectiva);
		sistema.registrarJugada(juegoElegido, monstruoElegido, habilidadString, puntaje);

		System.out.println("potencial: " + potencial + " | puntaje: " + puntaje);

	}

	private static String pedirNombre() {
		while (true) {
			System.out.print("Ingrese su nombre de usuario: ");
			String s = scanner.nextLine().trim();
			if (s.isEmpty()) {
				System.out.println("No puede estar vacío.");
				continue;
			}
			if (s.contains(";")) {
				System.out.println("No puede contener ';'.");
				continue;
			}
			return s;
		}
	}

	private static int leerEntero(int min, int max) {
		System.out.print("> ");
		String s = scanner.nextLine().trim();
		try {
			int v = Integer.parseInt(s);
			if (v < min || v > max) {
				System.out.println("Opción fuera de rango.");
				return -1;
			}
			return v;
		} catch (NumberFormatException e) {
			System.out.println("Debe ingresar un número.");
			return -1;
		}
	}

	private static void cargarMonster(SistemaImpl sistema, String txt) {
		int txtCargado = 0;
		try {
			Scanner scanner = new Scanner(new File(txt));
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				if (linea.trim().equals("")) {
					System.out.println("Linea vacia descartada");
					continue;
				}
				String[] partes = linea.split(";", -1);
				if (!sistema.crearMonstruo(partes)) {
					System.out.println("Linea descartada: " + linea);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("No se encontro el archivo: " + txt);
		}
	}

	// este esta pendiente.
	private static void cargarRegistros(SistemaImpl sistema, String txt) {
		try {
			Scanner scanner = new Scanner(new File(txt));
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				if (linea.trim().equals("")) {
					System.out.println("Linea vacia descartada");
					continue;
				}
				String[] partes = linea.split(";");
				sistema.crearJugador(partes);
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("No se encontro el archivo: " + txt);

		}
	}

	private static void guardarRegistros(SistemaImpl sistema, String txt) {
		try {
			FileWriter fw = new FileWriter(txt);
			ArrayList<Jugador> lista = sistema.getJugadores();
			for (int i = 0; i < lista.size(); i++) {
				Jugador j = lista.get(i);
				fw.write(j.getNombreString() + ";" + j.getPuntajeMaximo() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("Error al guardar en " + txt);
		}
	}

}
