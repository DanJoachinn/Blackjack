import java.awt.Image;

public class Jugador {

	private int montoInicio;
	
	private static Image[][] barajas;
	
	public Jugador() {
		this.montoInicio=5000;
	}
	
	public int getMonto() {
		return this.montoInicio;
	}
	
	public void setMonto(int perdida) {
		this.montoInicio+=perdida;
	}
	
}
