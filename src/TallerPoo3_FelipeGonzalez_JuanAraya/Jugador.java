package TallerPoo3_FelipeGonzalez_JuanAraya;

public class Jugador {
	private String nombreString;
	private int puntajeMaximo;

	public String getNombreString() {
		return nombreString;
	}

	public void setNombreString(String nombreString) {
		this.nombreString = nombreString;
	}

	public int getPuntajeMaximo() {
		return puntajeMaximo;
	}

	public void setPuntajeMaximo(int puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
	}

	public Jugador(String nombreString, int puntajeMaximo) {
		this.nombreString = nombreString;
		this.puntajeMaximo = puntajeMaximo;
	}

}
