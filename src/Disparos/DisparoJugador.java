package Disparos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Collider.ColisionadorDisparoJugador;



public class DisparoJugador extends Disparo {
	
	public DisparoJugador(Point pos, int dano) {
		super(pos,dano);
		grafico = new JLabel(new ImageIcon(getClass().getResource("/Disparos/TestDisparo.png")));
		this.colisionador = new ColisionadorDisparoJugador(this);
	}

}
