package Entidades;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Collider.ColisionadorJugador;
import Juego.Logica;
public class Jugador extends Nave {
	private Logica l;	
	public static final int RIGHT = 1, LEFT = -1, STPR = 2, STPL = -2;

	public Jugador(Point pos, Logica l) {
		super(pos);
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/Juego/nave_azul.PNG")));
		this.l = l;
		vida=300;
		dano=10;
		velocidad = 15;
		colisionador = new ColisionadorJugador(this);
	}
	
	public void recuperarVida() {
		vida=300;
	}
	
	public void mover(int d) {
		switch (d) {
		case RIGHT:
			if (getPos().x < 720) {
				getPos().setLocation(getPos().x + velocidad, getPos().y);
				getGrafico().setBounds(getPos().x, getPos().y, ANCHO_SPRITE, ALTO_SPRITE);
			}
			break;
		case LEFT:
			if (getPos().x > 0) {
				setPos(getPos().x - velocidad, getPos().y);
				getGrafico().setBounds(getPos().x, getPos().y, ANCHO_SPRITE, ALTO_SPRITE);
			}
			break;
		}
		getGrafico().repaint();
	}
	
	public void disparar() {
		l.crearDisparoJugador(grafico.getX(), grafico.getY()); //ESTO TIENE QUE SER STATE.ATACAR()
	}	

	public void morir() {
		l.perder();
	}
}
