package Disparos;

import java.awt.Point;
import Collider.*;

public class DisparoEnemigo extends Disparo {
	
	public DisparoEnemigo(Point pos, int dano) {
		super(pos, dano);
		this.colisionador = new ColisionadorDisparoEnemigo(this);
	}
}
