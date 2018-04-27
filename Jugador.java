import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Jugador {

	private int montoInicio,
				seleccionador,
				value;
	
	private Baraja baraja;
	
	private String nombreCarta;
	
	public Jugador() {
		this.montoInicio=500;
		this.baraja=new Baraja();
		this.seleccionador=52;
	}
	
	public int getMonto() {
		return this.montoInicio;
	}
	
	public void setMonto(int perdida) {
		this.montoInicio+=perdida;
	}
	
	public String getCard() {
		this.nombreCarta="";
		Random ran = new Random();
		int aleatorio;
		aleatorio = ran.nextInt(this.seleccionador);
		this.nombreCarta=this.baraja.getCard(aleatorio).getCardName();
		this.seleccionador-=1;
		
		return nombreCarta;
	}
	
	public int getValue() {
		this.value = 0;
		String[] valueStr=this.nombreCarta.split("_");
		if(valueStr[0].equals("jack")||valueStr[0].equals("queen")||valueStr[0].equals("king")) {
			this.value = 10;
		}
		else if(valueStr[0].equals("1")){
			this.value= 11;
			
		}
		else {
			this.value=Integer.parseInt(valueStr[0]);
		}
		
		return this.value;
	}
	
	public Baraja getBaraja() {
		return this.baraja;
	}
}
