package TallerPoo3_FelipeGonzalez_JuanAraya;

public class HombreLobo extends Monstruo implements Mordedor, Furioso{

	private int ferocidad;
	private int faseLunar;
	
	public HombreLobo(int vida, int velocidad, int fuerza, int resistencia, int ferocidad, int faseLunar) {
		super(vida, velocidad, fuerza, resistencia);
		this.ferocidad= ferocidad;
		this.faseLunar= faseLunar;
		
		// TODO Auto-generated constructor stub
	}

	public int getFerocidad() {
		return ferocidad;
	}

	public int getFaseLunar() {
		return faseLunar;
	}

	@Override
	public String enfurecerse() {
		// TODO Auto-generated method stub
		return "el hombre lobo aulla furioso";
	}

	@Override
	public String morder() {
		// TODO Auto-generated method stub
		return "el hombre lobo muerde con sus colmillos";
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Hombre lobo";
	}

	@Override
	public String getAtributosExtra() {
		// TODO Auto-generated method stub
		return "-Ferocidad: "+ferocidad+" -Fase Luna: "+faseLunar;
	}

	@Override
	public double potencialCarrera() {
		// TODO Auto-generated method stub
		return (velocidad+ferocidad/5.0)*faseLunar/4.0;
	}

	@Override
	public double potencialCaza() {
		// TODO Auto-generated method stub
		return ferocidad*faseLunar/4.0+velocidad/4.0;
	}

	@Override
	public double potencialLapidas() {
		// TODO Auto-generated method stub
		return fuerza+ferocidad*(double)faseLunar/8.0;
	}

	@Override
	public double potencialAmanecer() {
		// TODO Auto-generated method stub
		return (resistencia+vida)/2.0*(5-faseLunar)/4.0;
	}

}
