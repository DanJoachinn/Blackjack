	public class Naipe{
	private int valor, // 0 -> As, 1-> 2, 2->3 ... 11->Q, 12->k
		    palo; // 0-> picas, 1->corazones, 2-> treboles, 3->diamantes

	public static final String[] strValor = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	public static final String[] strPalo = {"spades", "hearts", "clubs", "diamonds"};

	public Naipe(int valor, int palo){
		this.valor = valor;
		this.palo = palo;
	}
	
	public String getCard(){
		return Naipe.strValor[this.valor] + "_of_ " + Naipe.strPalo[this.palo];
	}

}