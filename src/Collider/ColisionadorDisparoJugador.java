package Collider;

import Disparos.DisparoEnemigo;
import Disparos.DisparoJugador;
import Entidades.*;

public class ColisionadorDisparoJugador implements Colisionador {
	
	private DisparoJugador disparo;
	
	public ColisionadorDisparoJugador (DisparoJugador d) {
		disparo = d;
	}
	
	public void serChocadoPor(Jugador j) {
		
	}
	
	public void serChocadoPor (Enemigo e) {
		e.recibirDano(disparo.getDano());
	}

	public void serChocadoPor(Entidad e) {
		// TODO Auto-generated method stub
		
	}

	public void serChocadoPor(DisparoJugador d) {
		System.out.println("Choque con disparo");
	}

	public void serChocadoPor(DisparoEnemigo d) {
		// TODO Auto-generated method stub
		
	}

}
