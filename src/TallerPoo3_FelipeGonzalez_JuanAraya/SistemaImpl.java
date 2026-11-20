package TallerPoo3_FelipeGonzalez_JuanAraya;

import java.util.ArrayList;
import java.util.LinkedList;

public class SistemaImpl {
	private ArrayList<Monstruo> monstruos = new ArrayList<>();
	private ArrayList<Jugador> jugadores = new ArrayList<>();
	private ArrayList<Monstruo> monstruosUsados = new ArrayList<>();
	private LinkedList<HistorialJugado> historial = new LinkedList<>();
	private ArrayList<Minijuego> minijuegos = new ArrayList<>();
	private ArrayList<String> minijuegosJugados = new ArrayList<>();
	private Jugador jugadorActual;
	private int puntajeSesion = 0;

	public void crearJugador(String[] partes) {
		// TODO Auto-generated method stub
		if (partes == null || partes.length != 2) {
			return;
		}
		String jugadorString = partes[0].trim();
		if (jugadorString.equalsIgnoreCase("")) {
			return;
		}

		try {
			int puntajesMax = Integer.parseInt(partes[1].trim());
			if (puntajesMax < 0) {
				return;

			}
			jugadores.add(new Jugador(jugadorString, puntajesMax));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return;
		}
	}

	private boolean enRango(int valor, int min, int max) {
		return valor >= min && valor <= max;
	}

	// basicamente crea el objeto y retorna true, si no se pudo crear, retorna false
	public boolean crearMonstruo(String[] partes) {
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
	
	private boolean jugadorEsNuevo;
	//iniciar sesion
	public void iniciarSesion(String nombre) {
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
	        jugadorEsNuevo = false;
	    } else {
	        jugadorActual = new Jugador(limpio, 0);
	        jugadorEsNuevo = true;
	    }
	    puntajeSesion = 0;
	    monstruosUsados.clear();
	    historial.clear();
	    minijuegosJugados.clear();
	}
	//cerrar sesion
	public String finalizarSesion() {
	    if (jugadorActual == null) {
	        return "No hay sesion activa.";
	    }
	    if (puntajeSesion == 0 || historial.isEmpty()) {
	        return "No jugaste ningún minijuego, no se guarda registro.";
	    }
	    if (jugadorEsNuevo) {
	        jugadorActual.setPuntajeMaximo(puntajeSesion);
	        jugadores.add(jugadorActual);
	        jugadorEsNuevo = false;
	        return "¡Nuevo jugador registrado con " + puntajeSesion + " puntos!";
	    }
	    if (puntajeSesion > jugadorActual.getPuntajeMaximo()) {
	        jugadorActual.setPuntajeMaximo(puntajeSesion);
	        return "Superaste tu récord. Nuevo record: " + puntajeSesion + " puntos.";
	    }
	    return "No superaste tu record (" + jugadorActual.getPuntajeMaximo()
	            + ")";
	}

	public void inicializarMinijuegos() {
		minijuegos.clear();
		minijuegos.add(new CarreraCementerio());
		minijuegos.add(new Cazacalabazas());
		minijuegos.add(new LanzamientoLapidas());
		minijuegos.add(new SobrevivirAmanecer());
		minijuegosJugados.clear();
	}

	public ArrayList<Monstruo> mostrarMonsterLibres() {
		ArrayList<Monstruo> mDisponible = new ArrayList<>();
		for (Monstruo monstruo : monstruos) {
			if (!monstruosUsados.contains(monstruo)) {
				mDisponible.add(monstruo);

			}
		}
		return mDisponible;
	}

	public int calcularPuntaje(double ptcial, boolean habilidadEfectiva) {
		if (habilidadEfectiva) {
			return (int) Math.round(ptcial * 10.0 * 1.5);
		}
		return (int) Math.round(ptcial * 10.0);
	}

	public void registrarJugada(Minijuego game, Monstruo m, String habilidadEnUso, int puntaje) {
		minijuegosJugados.add(game.getNombre());
		monstruosUsados.add(m);
		puntajeSesion += puntaje;
		if (habilidadEnUso == null || habilidadEnUso.trim().equals("")) {
			habilidadEnUso = "Ninguna";
		}
		historial.add(new HistorialJugado(game.getNombre(), m.toString(), habilidadEnUso, puntaje));
	}
	//get rank ordenado
	public ArrayList<Jugador> getRank() {
		ArrayList<Jugador> aux = new ArrayList<>();
		for (int i = 0; i < jugadores.size(); i++) {
			aux.add(jugadores.get(i));
		}
		for (int i = 0; i < aux.size()-1; i++) {
			for (int j = 0; j < aux.size()-i-1; j++) {
				Jugador aJugador=aux.get(j);
				Jugador bJugador=aux.get(j+1);
				if (bJugador.getPuntajeMaximo()>aJugador.getPuntajeMaximo()) {
					aux.set(j, bJugador);
					aux.set(j+1, aJugador);
					
				}
				
			}
		}
		return aux;
	}


	public double calcularPotencial(Minijuego game, Monstruo m) {
		return game.calcularPotencial(m);
	}

	public boolean minijuegoYaJugado(String nombreMinijuego) {
		return minijuegosJugados.contains(nombreMinijuego);
	}

	public ArrayList<Monstruo> getMonstruos() {
		return monstruos;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}

	public int getPuntajeSesion() {
		return puntajeSesion;
	}

	public ArrayList<Monstruo> getMonstruosUsados() {
		return monstruosUsados;
	}

	public LinkedList<HistorialJugado> getHistorial() {
		return historial;
	}

	public ArrayList<Minijuego> getMinijuegos() {
		return minijuegos;
	}

	public ArrayList<String> getMinijuegosJugados() {
		return minijuegosJugados;
	}

}
