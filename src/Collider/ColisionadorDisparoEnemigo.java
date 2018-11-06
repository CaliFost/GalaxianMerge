package Collider;

import Disparos.*;
import Entidades.*;

public class ColisionadorDisparoEnemigo implements Colisionador {
	private Disparo d;
	public ColisionadorDisparoEnemigo(Disparo d) {
		this.d=d;
	}
	public void serChocadopor(Jugador j) {
		j.recibirDano(d.getDano());
		d.recibirDano(999);
	}
	public void serChocadoPor(BarreraDestructible b) {	
		b.recibirDano(d.getDano());
		d.recibirDano(d.getDano());
	}
	public void serChocadoPor(Entidad e) {	}
}
