package TallerPoo3_FelipeGonzalez_JuanAraya;

public class SobrevivirAmanecer implements Minijuego{

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Sobrevivir al amanecer";
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "Aguanta cuando salga el sol";
	}

	@Override
	public String getHabilidadPremiada() {
		// TODO Auto-generated method stub
		return "Regenerable";
	}

	@Override
	public double calcularPotencial(Monstruo m) {
		// TODO Auto-generated method stub
		return m.potencialAmanecer();
	}

}
