package Entidades;
import java.awt.Point;

import Collider.ColisionadorEnemigo;

public abstract class Enemigo extends Nave {

	public Enemigo(Point pos) {
		super(pos);
		colisionador = new ColisionadorEnemigo(this);
	}
	
}
