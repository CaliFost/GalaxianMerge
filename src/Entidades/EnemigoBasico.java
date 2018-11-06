package Entidades;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Collider.ColisionadorEnemigo;
import Mapa.Mapa;

public class EnemigoBasico extends Enemigo {
	public EnemigoBasico(int vida, int dano, Mapa m) {
		mapa = m;
		this.vida = vida;
		this.dano = dano;
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/juego/Egreenship2.png")));
		estrategia = new SAleatorio();
		velocidad = 43;
		puntaje = 100;
		colisionador = new ColisionadorEnemigo(this);
	}
}
