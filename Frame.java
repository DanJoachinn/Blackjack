/*
 * Autores:
 * Daniel Andres Ortiz Joachin A01634016.
 * Luis Antonio García Miramontes A01540063.
 * Clase: Frame.
 * Fecha: 2 de Mayo de 2018.
 * Comentarios: Ninguno.
 */

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {
	
	public Frame() {
		super("21 Blackjack");
		Jugador player1=new Jugador();
		Mesa panelMesa=new Mesa(player1);
		Controles cntr=new Controles(panelMesa, this, player1);
		this.add(panelMesa);
		this.add(cntr, BorderLayout.SOUTH);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] arg0) {
		Frame blackjack=new Frame();
	}
}
