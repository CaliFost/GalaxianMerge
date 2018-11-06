package Powerups;

import Entidades.*;

//Clase abstracta despues hay distintos tipos que la extienden . 
//Tambien podemos usar patron visitor y que cada pwrup se encargue de su funcion especifica

public abstract class  Powerup extends Entidad  {
	protected Jugador j;
	public Powerup(Jugador j) {
		this.j=j;
	}
}
