package TallerPoo3_FelipeGonzalez_JuanAraya;

public class Zombie extends Monstruo implements Mordedor, Regenerable{

	private int fuerzaDeMordida;
	
	public Zombie(int vida, int velocidad, int fuerza, int resistencia, int fuerzaDeMordida) {
		super(vida, velocidad, fuerza, resistencia);
		this.fuerzaDeMordida= fuerzaDeMordida;
	}

	public int getFuerzaDeMordida() {
		return fuerzaDeMordida;
	}

	@Override
	public String regenerarse() {

		return "el zombie se regenera";
	}

	@Override
	public String morder() {

		return "el zombie muerde";
	}

	@Override
	public String getTipo() {

		return "Zombie";
	}

	@Override
	public String getAtributosExtra() {

		return "-Mordida: "+fuerzaDeMordida;
	}

	@Override
	public double potencialCarrera() {

		return velocidad*resistencia/100.0;
	}

	@Override
	public double potencialCaza() {

		return fuerzaDeMordida*vida/100.0+resistencia/2.0;
	}

	@Override
	public double potencialLapidas() {

		return fuerza*resistencia/100.0;
	}

	@Override
	public double potencialAmanecer() {

		return resistencia*vida/100.0;
	}
	
	

}
