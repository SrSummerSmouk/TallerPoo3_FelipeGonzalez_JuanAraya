package TallerPoo3_FelipeGonzalez_JuanAraya;

import java.util.ArrayList;

public class SistemaImpl {
	private static ArrayList<Monstruo> monstruos = new ArrayList<>();
	private static ArrayList<Jugador> jugadores = new ArrayList<>();

	public static void crearJugador(String[] partes) {
		// TODO Auto-generated method stub

	}

	private static boolean enRango(int valor, int min, int max) {
		return valor >= min && valor <= max;
	}

	// basicamente crea el objeto y retorna true, si no se pudo crear, retorna false
	public static boolean crearMonstruo(String[] partes) {
		// TODO Auto-generated method stub
		String tipo = partes[0].trim();
		try {
			if (tipo.equals("Zombi") && partes.length == 6) {
				int vida = Integer.parseInt(partes[1].trim());
				int velocidad = Integer.parseInt(partes[2].trim());
				int fuerza = Integer.parseInt(partes[3].trim());
				int resistencia = Integer.parseInt(partes[4].trim());
				int mordida = Integer.parseInt(partes[5].trim());

				if (!enRango(vida, 1, 200) || !enRango(velocidad, 1, 100) || !enRango(fuerza, 1, 100)
						|| !enRango(resistencia, 1, 100) || !enRango(mordida, 1, 100)) {
					return false;
				}
				monstruos.add(new Zombie(vida, velocidad, fuerza, resistencia, mordida));
				return true;
			}
			if (tipo.equals("Vampiro") && partes.length == 7) {
				int vida = Integer.parseInt(partes[1].trim());
				int velocidad = Integer.parseInt(partes[2].trim());
				int fuerza = Integer.parseInt(partes[3].trim());
				int resistencia = Integer.parseInt(partes[4].trim());
				int vuelo = Integer.parseInt(partes[5].trim());
				int sol = Integer.parseInt(partes[6].trim());

				if (!enRango(vida, 1, 200) || !enRango(velocidad, 1, 100) || !enRango(fuerza, 1, 100)
						|| !enRango(resistencia, 1, 100) || !enRango(vuelo, 1, 100) || !enRango(sol, 1, 100)) {
					return false;
				}
				monstruos.add(new Vampiro(vida, velocidad, fuerza, resistencia, vuelo, sol));
				return true;
			}
			if (tipo.equals("Momia") && partes.length == 6) {
				int vida = Integer.parseInt(partes[1].trim());
				int velocidad = Integer.parseInt(partes[2].trim());
				int fuerza = Integer.parseInt(partes[3].trim());
				int resistencia = Integer.parseInt(partes[4].trim());
				int vendajes = Integer.parseInt(partes[5].trim());

				if (!enRango(vida, 1, 200) || !enRango(velocidad, 1, 100) || !enRango(fuerza, 1, 100)
						|| !enRango(resistencia, 1, 100) || !enRango(vendajes, 1, 300)) {
					return false;
				}
				monstruos.add(new Momia(vida, velocidad, fuerza, resistencia, vendajes));
				return true;
			}
			if (tipo.equals("HombreLobo") && partes.length == 7) {
				int vida = Integer.parseInt(partes[1].trim());
				int velocidad = Integer.parseInt(partes[2].trim());
				int fuerza = Integer.parseInt(partes[3].trim());
				int resistencia = Integer.parseInt(partes[4].trim());
				int ferocidad = Integer.parseInt(partes[5].trim());
				int faseLunar = Integer.parseInt(partes[6].trim());

				if (!enRango(vida, 1, 200) || !enRango(velocidad, 1, 100) || !enRango(fuerza, 1, 100)
						|| !enRango(resistencia, 1, 100) || !enRango(ferocidad, 1, 100) || !enRango(faseLunar, 1, 4)) {
					return false;
				}
				monstruos.add(new HombreLobo(vida, velocidad, fuerza, resistencia, ferocidad, faseLunar));
				return true;
			}
			return false;

		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false;
		}

	}

	public static ArrayList<Monstruo> getMonstruos() {
		return monstruos;
	}

	public static ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

}
