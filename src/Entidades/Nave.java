package Entidades;

import java.awt.Point;
import Estados.*;

public abstract class Nave extends Entidad {
	
	public Nave(Point pos) {
		super(pos);
	}

	protected int dano;
	protected State estado;
	
	public int getDano(){
		return dano;
	}
	public void setDano(int d) {
		dano = d;
	}
	
	public void setEstado(State e) {
		estado = e;
	}
	
	public State getEstado() {
		return estado;
	}
	
	public void disparar() {
	}
	
}
