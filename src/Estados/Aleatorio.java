package Estados;
import java.util.Random;
import Entidades.*;

public class Aleatorio extends State {

	private Entidad e;

	public Aleatorio(Entidad e) {
		this.e = e;
		velocidad = 2;
	}

	public void activar() {
		Random r = new Random();
		int dir = r.nextInt(3) + 1;
		moverEntidad(dir);
	}

	private void moverEntidad(int dir) {
		switch (dir) {
		case 0: // Arriba
			break;
		case 1: // Abajo
			e.setPos(e.getPos().x, e.getPos().y + velocidad);
			if ((e.getPos().y) > 500) {
				e.setPos(e.getPos().x, 0);
			}
			break;
		case 2: // Izquierda
			if (e.getPos().getX() > 0) {
				e.setPos(e.getPos().x - velocidad, e.getPos().y);
			}
			break;
		case 3: // Derecha
			if (e.getPos().getX() < 600) {
				e.getPos().setLocation(e.getPos().x + velocidad, e.getPos().y);
			}
			break;
		}
	}

}
