package Entidades;

import java.awt.Point;

public abstract class Obstaculo extends Entidad {

	public Obstaculo(Point pos) {
		super(pos);
		setGraficos();
		this.comportamiento = new Estados.Obstaculo(this);
	}

	public void aniquilado(){
		estaVivo = false;
	}
	
	protected void setGraficos() {
		//this.libreriaImagenes[0] = new ImageIcon(this.getClass().getResource("/img/rompebolas.png"));
		//this.libreriaImagenes[1] = new ImageIcon(this.getClass().getResource("/img/Explosion.png"));
	}

	public void actualizar(){
		if(vida>0)
			moverme();
		else
			aniquilado();
	}
	
}
