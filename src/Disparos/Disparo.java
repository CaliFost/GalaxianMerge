package Disparos;

import java.awt.Point;
import Entidades.Entidad;
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
