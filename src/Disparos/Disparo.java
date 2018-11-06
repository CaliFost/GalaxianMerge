package Disparos;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.Entidad;
import Mapa.Mapa;

public abstract class Disparo extends Entidad {
	protected int dano;
	
	public Disparo(Point pos, int dano) {
		super(pos);
		this.dano=dano;
	}

	public int getDano() {
		return dano;
	}
	public void actualizar() {
		if(getPos().y < 0 || getPos().y > 600) {
			morir();
		}
	}
	
}
