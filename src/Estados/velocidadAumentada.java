package Estados;

import Entidades.Jugador;

public class velocidadAumentada extends State {
	private Jugador j;
	public velocidadAumentada(Jugador j) {
		this.j=j;
		j.setVelocidad(j.getVelocidad()+10);
	}
	public void mover() {
		j.mover();
	}
	
	public void disparar() {
		j.disparar();
	}
	
	public void activar() {
		// TODO Auto-generated method stub
		
	}
}