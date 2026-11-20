package TallerPoo3_FelipeGonzalez_JuanAraya;

import java.util.ArrayList;

public class SistemaImpl {
	private static ArrayList<Monstruo> monstruos = new ArrayList<>();
	private static ArrayList<Jugador> jugadores = new ArrayList<>();
	private static ArrayList<Monstruo> monstruosUsados = new ArrayList<>();
	private static ArrayList<HistorialJugado> historial = new ArrayList<>();
	private static ArrayList<Minijuego> minijuegos = new ArrayList<>();
	private static ArrayList<String> minijuegosJugados = new ArrayList<>();
	private static Jugador jugadorActual;
	private static int puntajeSesion = 0;

	public static void crearJugador(String[] partes) {
		// TODO Auto-generated method stub
		if (partes == null || partes.length != 2) {
			return;
		}
		String jugadorString = partes[0];
		if (jugadorString.equalsIgnoreCase("")) {
			return;
		}

		try {
			int puntajesMax = Integer.parseInt(partes[1]);
			if (puntajesMax < 0) {
				return;

			}
			jugadores.add(new Jugador(jugadorString, puntajesMax));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return;
		}
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

	public static void iniciarSesion(String nombre) {
		String limpio = nombre.trim();
		Jugador encontrado = null;
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getNombreString().equalsIgnoreCase(limpio)) {
				encontrado = jugadores.get(i);
				break;
			}
		}
		if (encontrado != null) {
			jugadorActual = encontrado;
		} else {
			jugadorActual = new Jugador(limpio, 0);
			jugadores.add(jugadorActual);
		}
		puntajeSesion = 0;
		monstruosUsados.clear();
		historial.clear();
	}

	public static void inicializarMinijuegos() {
		minijuegos.clear();
		minijuegos.add(new CarreraCementerio());
		minijuegos.add(new Cazacalabazas());
		minijuegos.add(new LanzamientoLapidas());
		minijuegos.add(new SobrevivirAmanecer());
		minijuegosJugados.clear();
	}

	private static ArrayList<Monstruo> mostrarMonsterLibres() {
		ArrayList<Monstruo> mDisponible = new ArrayList<>();
		for (Monstruo monstruo : monstruos) {
			if (!monstruosUsados.contains(monstruo)) {
				mDisponible.add(monstruo);

			}
		}
		return mDisponible;
	}

	private static void registrarJugada(Minijuego game, Monstruo m, String habilidadEnUso, int puntaje) {
		minijuegosJugados.add(game.getNombre());
		monstruosUsados.add(m);
		puntajeSesion += puntaje;
		if (habilidadEnUso == null || habilidadEnUso.trim().equals("")) {
			habilidadEnUso = "Ninguna";
		}
		historial.add(new HistorialJugado(game.getNombre(), m.toString(), habilidadEnUso, puntaje));
	}

	public static double calcularPotencial(Minijuego game, Monstruo m) {
		return game.calcularPotencial(m);
	}

	public static boolean minijuegoYaJugado(String nombreMinijuego) {
		return minijuegosJugados.contains(nombreMinijuego);
	}

	public static ArrayList<Monstruo> getMonstruos() {
		return monstruos;
	}

	public static ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public static Jugador getJugadorActual() {
		return jugadorActual;
	}

	public static int getPuntajeSesion() {
		return puntajeSesion;
	}

	public static ArrayList<Monstruo> getMonstruosUsados() {
		return monstruosUsados;
	}

	public static ArrayList<HistorialJugado> getHistorial() {
		return historial;
	}

	public static ArrayList<Minijuego> getMinijuegos() {
		return minijuegos;
	}

	public static ArrayList<String> getMinijuegosJugados() {
		return minijuegosJugados;
	}

}
