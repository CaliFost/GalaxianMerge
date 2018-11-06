package Entidades;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Collider.ColisionadorEnemigo;
import Mapa.Mapa;

public class EnemigoBasico extends Enemigo {
	public EnemigoBasico(Point pos) {
		super(pos);
		vida=50;
		dano=10;
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/juego/Egreenship2.png")));
		velocidad = 43;
		puntaje = 100;
		colisionador = new ColisionadorEnemigo(this);
	}
}
