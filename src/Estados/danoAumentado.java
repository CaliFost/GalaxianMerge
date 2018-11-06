package Estados;

import Entidades.Jugador;

public class danoAumentado extends State {
	private Jugador j;
	public danoAumentado(Jugador j) {
		this.j=j;
		j.setDano(j.getDano()+10);
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
