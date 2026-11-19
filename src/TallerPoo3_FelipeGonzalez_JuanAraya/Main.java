package TallerPoo3_FelipeGonzalez_JuanAraya;
//Felipe Gonzalez - 21.776.516-1 - ITI

//Juan Araya - 21.566.260-8 - ITI

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Probando");
		SistemaImpl sistemaImpl = new SistemaImpl();
		cargarMonster(sistemaImpl, "Monstruos.txt");

	}

	private static void cargarMonster(SistemaImpl sistema, String txt) {
		int txtCargado = 0;
		try {
			Scanner scanner = new Scanner(new File(txt));
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] partes = linea.split(";");
				sistema.crearMonstruo(partes);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("No se encontro el archivo: " + txt);
		}
	}

	private static void cargarRegistros(SistemaImpl sistema, String txt) {
		try {
			Scanner scanner = new Scanner(new File(txt));
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] partes = linea.split(";");
				sistema.crearJugador(partes);
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
	}

}
