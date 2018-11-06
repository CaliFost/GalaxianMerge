package Entidades;

import java.awt.Point;


import Collider.ColisionadorBarrera;

public class Barrera extends Obstaculo {
	public Barrera(Point pos) {
		super(pos);
		colisionador = new ColisionadorBarrera(this);
	}
}
