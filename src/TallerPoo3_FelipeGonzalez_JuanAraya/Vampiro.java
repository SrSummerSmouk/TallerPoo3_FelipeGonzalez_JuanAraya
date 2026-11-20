package TallerPoo3_FelipeGonzalez_JuanAraya;

public class Vampiro extends Monstruo implements Mordedor, Volador{
	
	private int velocidadDeVuelo;
	private int resistenciaAlSol;
	
	public Vampiro(int vida, int velocidad, int fuerza, int resistencia, int velocidadDeVuelo, int resistenciaAlSol) {
		super(vida, velocidad, fuerza, resistencia);
		this.velocidadDeVuelo= velocidadDeVuelo;
		this.resistenciaAlSol= resistenciaAlSol;
		
	}

	public int getVelocidadDeVuelo() {
		return velocidadDeVuelo;
	}

	public int getResistenciaAlSol() {
		return resistenciaAlSol;
	}

	@Override
	public String volar() {

		return "el vampiro vuela";
	}
	@Override
	public String morder() {

		return "el vampiro clava sus colmillos";
	}
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub ya dio pereza estar borrando esto del comentario default
		return "Vampiro";
	}
	@Override
	public String getAtributosExtra() {
		// TODO Auto-generated method stub
		return "-Vuelo: "+velocidadDeVuelo+" -Sol: "+resistenciaAlSol;
	}
	@Override
	public double potencialCarrera() {
		// TODO Auto-generated method stub
		return (velocidad+2.0*velocidadDeVuelo)/2.0;
	}
	@Override
	public double potencialCaza() {
		// TODO Auto-generated method stub
		return (fuerza+velocidad)/3.0;
	}
	@Override
	public double potencialLapidas() {
		// TODO Auto-generated method stub
		return fuerza+velocidadDeVuelo/4.0;
	}
	@Override
	public double potencialAmanecer() {
		// TODO Auto-generated method stub
		return resistencia*resistenciaAlSol/100.0;
	}

}
