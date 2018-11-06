package Entidades;

import Collider.Colisionador;
import Disparos.Disparo;

public abstract class Nave extends Entidad {
	
	protected int dano;
	protected int velDisparo;
	protected State estado;
	
	
	public Colisionador getColisionador() {
		return colisionador;
	}
	
	public int getDano(){
		return dano;
	}
	
	public void setDano(int d) {
		dano = d;
	}
	
	public void setEstado(State e) {
		estado = e;
	}
	
	
	//No hay clase State
	public State getEstado() {
		return estado;
	}
	
	public void disparar() {
		
	}
	
	
}
