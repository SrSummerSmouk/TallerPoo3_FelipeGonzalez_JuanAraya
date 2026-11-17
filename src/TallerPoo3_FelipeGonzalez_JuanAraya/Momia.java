package TallerPoo3_FelipeGonzalez_JuanAraya;

public class Momia extends Monstruo implements Regenerable, Furioso{

	private int longitudVendajes;
	
	public Momia(int vida, int velocidad, int fuerza, int resistencia, int longitudVendajes) {
		super(vida, velocidad, fuerza, resistencia);
		this.longitudVendajes= longitudVendajes;
		// TODO Auto-generated constructor stub
	}
	
	public int getLongitudVendajes() {
		return longitudVendajes;
	}


	@Override
	public String enfurecerse() {
		// TODO Auto-generated method stub
		return "la momia se enfada";
	}

	
	@Override
	public String regenerarse() {
		// TODO Auto-generated method stub
		return "la momia acomoda su vendaje";
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Momia";
	}

	@Override
	public String getAtributosExtra() {
		// TODO Auto-generated method stub
		return "-Vendajes: "+longitudVendajes;
	}

	@Override
	public double potencialCarrera() {
		// TODO Auto-generated method stub
		return velocidad*100.0/(100+longitudVendajes);
	}

	@Override
	public double potencialCaza() {
		// TODO Auto-generated method stub
		return longitudVendajes*(double)fuerza/200.0; //el double ahi es para hacer el int Double y no caer en Error
	}

	@Override
	public double potencialLapidas() {
		// TODO Auto-generated method stub
		return fuerza+longitudVendajes/10.0;
	}

	@Override
	public double potencialAmanecer() {
		// TODO Auto-generated method stub
		return (resistencia+vida)/2.0*(1+longitudVendajes/300.0);
	}

}
