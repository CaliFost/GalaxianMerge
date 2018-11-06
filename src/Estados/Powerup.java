package Estados;

import Premio.*;

public class Powerup extends State {

	private Premio e;

	public Powerup(Premio e) {
		this.e = e;
		velocidad = 5;
	}

	public void activar() {
		moverEntidad();
	}

	private void moverEntidad() {
		e.setPos(e.getPos().x, e.getPos().y + velocidad);
		if ((e.getPos().y) > 550) 
			e.aniquilado();
	}
}
