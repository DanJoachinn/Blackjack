import java.util.ArrayList;
import java.util.Random;

public class Baraja{
	private ArrayList<Naipe> cartas;	

	public Baraja(){
		this.cartas = new ArrayList<Naipe>();
		for(int j = 0; j < 4; j++){
			for(int i = 0; i < 13; i++){
				this.cartas.add(new Naipe(i,j));
			}
		}	
	}

	
	public Naipe getCard(int i) {
		Naipe temp=this.cartas.get(i);
		this.cartas.remove(i);
		return temp;
	}
	
	public void resetBaraja() {
		for(int j = 0; j < 4; j++){
			for(int i = 0; i < 13; i++){
				this.cartas.add(new Naipe(i,j));
			}
		}	
	}
}	