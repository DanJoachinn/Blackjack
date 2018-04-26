import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class hitMe extends JPanel {
	
	private JButton btRepartir,
					btQuedarse;

	public hitMe() {
		super();
		Color verde=new Color(18,155,48);
		this.setPreferredSize(new Dimension(800,50));
		this.setBackground(verde);
		this.btRepartir=new JButton("Dame una carta");
		this.btQuedarse=new JButton("Me Quedo");
		
		this.add(this.btRepartir);
		this.add(this.btQuedarse);	
	}
	
	
	
}
