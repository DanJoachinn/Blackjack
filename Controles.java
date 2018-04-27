import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Controles extends JPanel{

	private JButton btPot,
					btApostar,
					btHitMe,
					btQuedarse;
	
	private JComboBox cbApuesta;
	
	private int pot,
				valuePlayer,
				valueDealer;
	
	private Mesa mano;
	
	private hitMe repartirCartas;
	
	private JFrame frame;
	
	private Jugador player1;
	
	
	public Controles(Mesa mesa, Frame frame, Jugador player1) {
		super();
		this.frame=frame;
		this.mano=mesa;
		this.mano.resetPot();
		this.mano.resetContador();
		this.valueDealer=0;
		this.valuePlayer=0;
		this.player1=player1;
		Color verde=new Color(18,155,48);
		String[] apuesta= {"$1","$5","$10","$25","$100"};
		this.cbApuesta=new JComboBox(apuesta);
		this.btPot=new JButton("Añadir a la apuesta");
		this.btApostar=new JButton("¡Apostar!");
		this.btHitMe=new JButton("Dame una carta");
		this.btQuedarse=new JButton("Me Quedo");
		
		
		this.setPreferredSize(new Dimension(800,50));
		this.setBackground(verde);
		
		this.add(cbApuesta);
		this.add(btPot);
		this.add(btApostar);
		
		this.mano.resetCard();
		this.mano.getJugador().getBaraja().resetBaraja();
		this.repaint();
		
		this.btPot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				String potTemporal=(String) cbApuesta.getSelectedItem();
				potTemporal=potTemporal.replace("$", "");
				int numPot= Integer.parseInt(potTemporal);
				pot+=numPot;
				mano.setPot(pot);
			}
		});
		
		this.btApostar.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				if(pot!=0) {
					
					mano.setMonto();
					
					Controles.this.removeAll();
					Controles.this.repartirCartas=new hitMe(mano, player1, Controles.this, frame);
					Controles.this.frame.add(Controles.this.repartirCartas, BorderLayout.SOUTH);
					Controles.this.setVisible(false);
					Controles.this.repartirCartas.setVisible(true);
					Controles.this.repaint();
					
					mano.setCard(new ImageIcon("Cards\\"+Controles.this.player1.getCard()+".png").getImage(), 0);
					valuePlayer+=player1.getValue();
					mano.setCard(new ImageIcon("Cards\\"+Controles.this.player1.getCard()+".png").getImage(),1);
					valueDealer+=player1.getValue();
					mano.setCard(new ImageIcon("Cards\\"+Controles.this.player1.getCard()+".png").getImage(),2);
					valuePlayer+=player1.getValue();
					mano.setCard(new ImageIcon("Cards\\back.png").getImage(),3);
					
				}
				else {
					JOptionPane.showMessageDialog(Controles.this.mano, "Debe apostar para comenzar");
				}
			}
		});
	}
	
	public void setValuesPlayer(int i) {
		this.valuePlayer+=i;
	}
	
	public void setValuesDealer(int i) {
		this.valueDealer+=i;
	}
	
	public boolean validarValor() {
		if(this.valuePlayer<=21) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(this.mano, "Has perdido :( tienes "+this.valuePlayer);
			return false;
		}
	}
	
	public int getValueDealer() {
		return this.valueDealer;
	}
	
	public int getValuePlayer() {
		return this.valuePlayer;
	}

}
