package Entidades;
import Mapa.*;
public abstract class Enemigo extends Nave {
	protected Strategy estrategia;
	public Strategy getStrategy() {
		return estrategia;
	}
	public void setEstrategia(Strategy s) {
		estrategia = s;
	}
	public void mover(Mapa mm) {
		estrategia.mover(this, mm);	
	}
}
