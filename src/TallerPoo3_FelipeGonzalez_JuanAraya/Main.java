package TallerPoo3_FelipeGonzalez_JuanAraya;
//Felipe Gonzalez - 21.776.516-1 - ITI

//Juan Araya - 21.566.260-8 - ITI

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Probando");
		SistemaImpl sistemaImpl = new SistemaImpl();
		cargarMonster(sistemaImpl, "Monstruos.txt");
		cargarRegistros(sistemaImpl, "Registros.txt");

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
				if (!SistemaImpl.crearMonstruo(partes)) {
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
				SistemaImpl.crearJugador(partes);
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("No se encontro el archivo: " + txt);

		}
	}

	private static void guardarRegistros(String txt) {
		try {
			FileWriter fw = new FileWriter(txt);
			ArrayList<Jugador> lista = SistemaImpl.getJugadores();
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
