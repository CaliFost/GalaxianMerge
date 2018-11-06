package Entidades;

import java.awt.Point;
import Collider.ColisionadorBarreraD;

public class BarreraDestructible extends Obstaculo {
	public BarreraDestructible(Point pos) {
		super(pos);
		colisionador = new ColisionadorBarreraD(this);
	}
}
