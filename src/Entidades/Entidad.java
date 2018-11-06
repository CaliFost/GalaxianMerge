package Entidades;
import java.awt.Point;
import Estados.*;
import Juego.Logica;

import javax.swing.Icon;
import javax.swing.JLabel;

import Collider.*;
import Mapa.*;

public abstract class Entidad {
	protected final int ANCHO_SPRITE = 80;
	protected final int ALTO_SPRITE = 80;
	protected Point pos;
	protected State comportamiento;
	protected boolean estaVivo;
	protected JLabel grafico;
	protected int vida, puntaje, velocidad;
	protected Colisionador colisionador;
	protected Logica juego;
	
	public Entidad(Point pos) {
		this.pos = pos;
		vida = 100;
		puntaje = 0;
	}

	public Point getPos() {
		return pos;
	}
	
	public boolean estaVivo() {
		return estaVivo;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int p) {
		puntaje = p;
	}
	
	public void setPos(int x, int y) {
		pos.setLocation(x, y);
		getGrafico().setBounds(x,y,ANCHO_SPRITE, ALTO_SPRITE);
	}
	
	public void recibirDano(int d) {
		vida-=d;
		if (vida<0)
			morir();
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad=velocidad;
	}
	
	public int getVida(){
		return vida;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public Colisionador getCollider() {
		return colisionador;
	}
	
	public void setCollider(ColisionadorEnemigo colisionador) {
		this.colisionador=colisionador;
	}
	
	public JLabel getGrafico() {
		if (grafico == null) {
			//grafico = new JLabel();
			grafico.setBounds(this.pos.x, this.pos.y, ANCHO_SPRITE, ALTO_SPRITE);
		}
		return grafico;
	}
	
	public void setGrafico(JLabel l) {
		grafico = l;
	}
	
	public void setComportamiento(State c) {
		comportamiento = c;
	}

	public void mover() {}
	
	public void serChocadoPor(Entidad e) {
		//System.out.println("Entro al ser chocado " + e.getClass().getName().toString());
		colisionador.serChocadoPor(e);
		//System.out.println("Salio del ser chocado");
	}
	
	public void chocar(Entidad e) {
		e.getCollider().serChocadoPor(this);
	}
	
	public void moverme() {
		comportamiento.activar();
	}
	
	public void morir() {}
}
