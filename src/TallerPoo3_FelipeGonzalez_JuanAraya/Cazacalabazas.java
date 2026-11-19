package TallerPoo3_FelipeGonzalez_JuanAraya;

public class Cazacalabazas implements Minijuego{

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Caza de calabazas";
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "Muerde la mayor cantidad de calabazas en 60 segundos";
	}

	@Override
	public String getHabilidadPremiada() {
		// TODO Auto-generated method stub
		return "Mordedor";
	}

	@Override
	public double calcularPotencial(Monstruo m) {
		// TODO Auto-generated method stub
		return m.potencialCaza();
	}

}
