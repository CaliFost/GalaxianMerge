package Estados;

import Entidades.*;

public class Obstaculo extends State {

	private Entidad e;
	boolean derecha;

	public Obstaculo(Entidad e) {
		this.e = e;
		velocidad = 2;
		derecha = true;
	}

	public void activar() {
		moverEntidad();
	}

	private void moverEntidad() {
		int cordXEntidad = e.getPos().x;

		if (derecha) {
			e.setPos(cordXEntidad + 5, e.getPos().y);
			if (cordXEntidad > 700)
				derecha = false;
		} else {
			e.setPos(cordXEntidad - 5, e.getPos().y);
			if (cordXEntidad < 100)
				derecha = true;
		}

	}
}
