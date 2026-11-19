package TallerPoo3_FelipeGonzalez_JuanAraya;

public class HistorialJugado {
	private String nombreMinijuegoString;
	private String monsterUseString;
	private String habilidadUsadaString;
	private int puntaje;

	public String getNombreMinijuegoString() {
		return nombreMinijuegoString;
	}

	public String getMonsterUseString() {
		return monsterUseString;
	}

	public String getHabilidadUsadaString() {
		return habilidadUsadaString;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public HistorialJugado(String nombreMinijuegoString, String monsterUseString, String habilidadUsadaString,
			int puntaje) {
		this.nombreMinijuegoString = nombreMinijuegoString;
		this.monsterUseString = monsterUseString;
		this.habilidadUsadaString = habilidadUsadaString;
		this.puntaje = puntaje;
	}

}
