import java.util.Random;
public class Baraja{
	private Naipe[] cartas;	

	public Baraja(){
		this.cartas = new Naipe[52];
		int k = 0;
		for(int j = 0; j < 4; j++){
			for(int i = 0; i < 13; i++){
				this.cartas[k++] = new Naipe(i,j	);
			}
		}	
	}
	
	public void mezcla(){
		Random ran = new Random();
		int aleatorio;
		Naipe tmp;
		for(int i = 0; i < this.cartas.length; i++){
			aleatorio = ran.nextInt(52);
			tmp = cartas[i];
			cartas[i] = cartas[aleatorio];
			cartas[aleatorio] = tmp;
		}
	}
	
	public String toString(){
		String res = "";
		for(int i = 0; i < this.cartas.length;i++){
			res+= cartas[i] + "\n";
		}
		return res;
	}
}	