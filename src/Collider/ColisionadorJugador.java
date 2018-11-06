package Collider;
import Disparos.DisparoEnemigo;
import Disparos.DisparoJugador;
import Entidades.Enemigo;
import Entidades.Entidad;
import Entidades.Jugador;
import Powerups.*;

import Disparos.DisparoEnemigo;
import Disparos.DisparoJugador;
import Entidades.Enemigo;
import Entidades.Jugador;
import Powerups.Powerup;

public class ColisionadorJugador implements Colisionador{
	

	private Jugador j;
	public ColisionadorJugador (Jugador j) {
		this.j=j;
	}
	public void serChocadoPor(Jugador j) {}
	public void serChocadoPor(Enemigo e) {
		if (e.getVida()>j.getVida()) 
			e.recibirDano(j.getVida());
		else		 
			j.recibirDano(e.getVida());
	}
	public void serChocadoPor(DisparoJugador d) {}
	public void serChocadoPor(DisparoEnemigo d) {
		j.recibirDano(d.getDano());
	}
	public void serChocadoPor(aumentarDano p) {
		//Temporal, a contador
		j.setDano(j.getDano()+10);	
	}
	public void serChocadoPor(Entidad e) {
		// TODO Auto-generated method stub
	}
}
