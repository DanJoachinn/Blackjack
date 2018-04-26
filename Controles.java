import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

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
	
	private int pot;
	
	private Mesa mano;
	
	private hitMe repartirCartas;
	
	private JFrame frame;
	
	
	public Controles(Mesa mesa, Frame frame) {
		super();
		this.pot=0;
		this.frame=frame;
		Color verde=new Color(18,155,48);
		String[] apuesta= {"$1","$5","$10","$25","$100"};
		this.cbApuesta=new JComboBox(apuesta);
		this.btPot=new JButton("Añadir a la apuesta");
		this.btApostar=new JButton("¡Apostar!");
		this.btHitMe=new JButton("Dame una carta");
		this.btQuedarse=new JButton("Me Quedo");
		this.mano=mesa;
		
		this.setPreferredSize(new Dimension(800,50));
		this.setBackground(verde);
		
		this.add(cbApuesta);
		this.add(btPot);
		this.add(btApostar);
		
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
					Controles.this.repartirCartas=new hitMe();
					Controles.this.frame.add(Controles.this.repartirCartas, BorderLayout.SOUTH);
					Controles.this.setVisible(false);
					Controles.this.repartirCartas.setVisible(true);
					Controles.this.repaint();
					
					
				}
				else {
					JOptionPane.showMessageDialog(Controles.this.mano, "Debe apostar para comenzar");
				}
			}
		});
		
		
		
		
	}

}
