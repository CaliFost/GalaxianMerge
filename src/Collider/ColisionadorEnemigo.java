package Collider;
import Disparos.DisparoEnemigo;
import Disparos.DisparoJugador;
import Entidades.Enemigo;
import Entidades.Entidad;
import Entidades.Jugador;
import Powerups.Powerup;

import Disparos.DisparoEnemigo;
import Disparos.DisparoJugador;
import Entidades.Enemigo;
import Entidades.Jugador;
import Powerups.Powerup;

public class ColisionadorEnemigo implements Colisionador{

	private Enemigo e;
	public ColisionadorEnemigo (Enemigo e) {
		this.e=e;
	}
	public void serChocadoPor(Jugador j) {
		if (e.getVida()>j.getVida()) {
			e.recibirDano(j.getVida());
			//destruir jugador
		}
		else {
			j.recibirDano(e.getVida());
			//destruir enemigo
		}
	}
	public void serChocadoPor(Enemigo e) {
		//Metodologia sin colision
	}
	public void serChocadoPor(DisparoJugador d) {
		System.out.println("Antes de pegar, vida enemigo: " + e.getVida() + " /// vida disparo: " + d.getVida());
		e.recibirDano(d.getDano());
		d.recibirDano(10);
		System.out.println("Despues de pegar, vida enemigo: " + e.getVida() + " /// vida disparo: " + d.getVida());
	}
	public void serChocadoPor(DisparoEnemigo e) {
		//Metodologia sin colision
	}
	public void serChocadoPor(Powerup p) {
		//Decorator
	}
	public void serChocadoPor(Entidad e) {
		
	}
}
