package TallerPoo3_FelipeGonzalez_JuanAraya;

public class CarreraCementerio implements Minijuego{

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Carrera del cementerio";
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "recorre el cementerio antes que el sepultero te vea";
	}

	@Override
	public String getHabilidadPremiada() {
		// TODO Auto-generated method stub
		return "Volador";
	}

	@Override
	public double calcularPotencial(Monstruo m) {
		// TODO Auto-generated method stub
		return m.potencialCarrera();
	}

}
