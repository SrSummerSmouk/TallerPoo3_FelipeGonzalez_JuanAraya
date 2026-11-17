package TallerPoo3_FelipeGonzalez_JuanAraya;

public abstract class Monstruo {
	
	protected int vida;
	protected int velocidad;
	protected int fuerza;
	protected int resistencia;
	
	public Monstruo(int vida, int velocidad, int fuerza, int resistencia) {
		this.vida = vida;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
	}
	
	public abstract String getTipo();
	public abstract String getAtributosExtra();
	
	//los metodos para calcular el potencial
	public abstract double potencialCarrera();
	public abstract double potencialCaza();
	public abstract double potencialLapidas();
	public abstract double potencialAmanecer();

	public int getVida() {
		return vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getResistencia() {
		return resistencia;
	}

	@Override
	public String toString() {
		return getTipo() +"[vida=" + vida + ", velocidad=" + velocidad + ", fuerza=" + fuerza + ", resistencia="
				+ resistencia + getAtributosExtra() + "]";
	}
	
	
	

}
