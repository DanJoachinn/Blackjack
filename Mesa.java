import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Mesa extends JPanel{
	
	private Image fondo;
				  
	private Image[] cartas;
	
	private Jugador player1;
	
	private int xCoord,
				yCoord,
				pot,
				contadorDeCartas;

	
	public Mesa(Jugador player) {
		super();
		this.player1=player;
		this.xCoord=270;
		this.yCoord=300;
		this.setPreferredSize(new Dimension(800, 500));
		this.fondo=new ImageIcon("Cards\\table.png").getImage();
		this.pot=0;
		this.cartas=new Image[10];
		
		this.resetCard();
		
		this.contadorDeCartas=0;
		
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.fondo,0,0,this.getWidth(),this.getHeight(),this);
		g.setFont(new Font("default", Font.BOLD, 20));
		g.drawString("Pot: $"+this.pot,370,470);
		g.drawString("Fondos: $"+this.player1.getMonto(), 150, 450);
	
		g.drawImage(this.cartas[0], this.xCoord, this.yCoord, 80, 100, this);
		g.drawImage(this.cartas[1], this.xCoord, this.yCoord-250, 80, 100, this);//primera dealer carta
		g.drawImage(this.cartas[2], this.xCoord+50, this.yCoord, 80, 100, this);
		g.drawImage(this.cartas[3], this.xCoord+50, this.yCoord-250, 80, 100, this);//Segunda dealer carta
		g.drawImage(this.cartas[4], this.xCoord+100, this.yCoord, 80, 100, this);
		g.drawImage(this.cartas[5], this.xCoord+150, this.yCoord, 80, 100, this);
		g.drawImage(this.cartas[6], this.xCoord+200, this.yCoord, 80, 100, this);
		g.drawImage(this.cartas[7], this.xCoord+100, this.yCoord-250, 80, 100, this);//resto cartas dealer
		g.drawImage(this.cartas[8], this.xCoord+150, this.yCoord-250, 80, 100, this);
		g.drawImage(this.cartas[9], this.xCoord+200, this.yCoord-250, 80, 100, this);
		
	}
	
	public void setPot(int nuevoPot) {
		this.pot=nuevoPot;
		this.repaint();
		
	}
	
	public void setMonto() {
		this.player1.setMonto(-this.pot);
		this.repaint();
	}
	
	public void setCard(Image cartita, int i) {
		this.cartas[i]=cartita;
	}
	
	public void setDealerCard(Image cartita) {
		this.cartas[3]=cartita;
	}
	
	public void resetCard() {
		this.cartas[0]=null;
		this.cartas[1]=null;
		this.cartas[2]=null;
		this.cartas[3]=null;
		this.cartas[4]=null;
		this.cartas[5]=null;
		this.cartas[6]=null;
		this.cartas[7]=null;
		this.cartas[8]=null;
		this.cartas[9]=null;
		this.repaint();
	}
	
	public Jugador getJugador() {
		return this.player1;
	}
	
	public void resetPot() {
		this.pot=0;
	}
	
	public void resetContador() {
		this.contadorDeCartas=0;
	}
	public int getPot() {
		return this.pot;
	}	
}
