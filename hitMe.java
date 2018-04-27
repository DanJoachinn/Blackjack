import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class hitMe extends JPanel {
	
	private JButton btRepartir,
					btQuedarse;
	
	private Mesa mano; 
	
	private Jugador player1;
	
	private Controles cntroles;
	
	private Frame frame;
	
	private int posicionCarta;

	public hitMe(Mesa mano, Jugador player, Controles cntrl, Frame frame) {
		super();
		this.cntroles=cntrl;
		this.frame=frame;
		this.posicionCarta=4;
		Color verde=new Color(18,155,48);
		this.setPreferredSize(new Dimension(800,50));
		this.setBackground(verde);
		this.mano=mano;
		this.player1=player;
		this.btRepartir=new JButton("Dame una carta");
		this.btQuedarse=new JButton("Me Quedo");
		
		this.add(this.btRepartir);
		this.add(this.btQuedarse);	
		
		this.btRepartir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 
				hitMe.this.mano.setCard(new ImageIcon("Cards\\"+hitMe.this.player1.getCard()+".png").getImage(),posicionCarta);
				hitMe.this.cntroles.setValuesPlayer(player1.getValue());
				hitMe.this.mano.repaint();
				posicionCarta+=1;
				
			
				if(!hitMe.this.cntroles.validarValor()) {
					hitMe.this.resetCntr();
				}
			}
		});
		
		this.btQuedarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				posicionCarta=3;
				hitMe.this.removeAll();
				hitMe.this.repaint();
				hitMe.this.mano.setCard(new ImageIcon("Cards\\"+hitMe.this.player1.getCard()+".png").getImage(),posicionCarta);
				hitMe.this.cntroles.setValuesDealer(player1.getValue());
				hitMe.this.mano.repaint();
				posicionCarta=6;
				while(hitMe.this.cntroles.getValueDealer()<=16) {
					posicionCarta+=1;
					hitMe.this.mano.setCard(new ImageIcon("Cards\\"+hitMe.this.player1.getCard()+".png").getImage(),posicionCarta);
					hitMe.this.cntroles.setValuesDealer(player1.getValue());
					hitMe.this.mano.repaint();
				}
				
				if(hitMe.this.cntroles.getValuePlayer()>hitMe.this.cntroles.getValueDealer()||hitMe.this.cntroles.getValueDealer()>21) {
					hitMe.this.player1.setMonto(2*hitMe.this.mano.getPot());
					JOptionPane.showMessageDialog(hitMe.this.mano, "Ganaste :)\nDealer tiene "+hitMe.this.cntroles.getValueDealer());
					hitMe.this.resetCntr();
				}
				else if(hitMe.this.cntroles.getValuePlayer()<hitMe.this.cntroles.getValueDealer()) {
						
					JOptionPane.showMessageDialog(hitMe.this.mano, "Perdiste :(\nDealer tiene "+hitMe.this.cntroles.getValueDealer());
					hitMe.this.resetCntr();
				}
				else {
					hitMe.this.player1.setMonto(hitMe.this.mano.getPot());
					JOptionPane.showMessageDialog(hitMe.this.mano, "Empataron :l");
					hitMe.this.resetCntr();
				}
					
				
			}
		});
	}
	
	public void resetCntr() {
		hitMe.this.removeAll();
		hitMe.this.cntroles=new Controles(hitMe.this.mano, frame,player1);
		hitMe.this.frame.add(hitMe.this.cntroles, BorderLayout.SOUTH);
		hitMe.this.cntroles.setVisible(true);
		hitMe.this.setVisible(false);
		hitMe.this.mano.repaint();
		hitMe.this.repaint();
	}
}
