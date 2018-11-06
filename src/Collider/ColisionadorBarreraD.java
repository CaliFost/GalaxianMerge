package Collider;

import Entidades.BarreraDestructible;
import Entidades.Entidad;

public class ColisionadorBarreraD implements Colisionador{
	private BarreraDestructible b;
	public ColisionadorBarreraD(BarreraDestructible b) {
		this.b=b;
	}
	public void serChocadoPor(Entidad e) {
		
	}

}
