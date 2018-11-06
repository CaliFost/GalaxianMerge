package Juego;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import Disparos.Disparo;
import Disparos.DisparoJugador;
import Entidades.*;
import GUI.GUI;

public class Logica {

	private Jugador j;
	protected GUI gui;
	protected Mapa nivel;

	public Logica (GUI gui) {
		this.gui = gui;
		j = new Jugador(new Point(1024 / 2, 768 - 80), this);
	}	

	public Jugador getJugador() {
		return j;
	}
	
	public int getPuntaje() {
		return j.getPuntaje();
	}

	
	public void perder() {
		nivel.getThread().detenerThread();
		gui.perder();
	}

	public void ganar() {
		gui.ganar();
	}
	
	public void crearDisparoJugador(int x, int y) {
		Disparo d = new DisparoJugador(new Point(x,y), j.getDano());
		gui.agregarEntidad(d);
	}
	
/*
	public void crearEnemigo(char c, int x, int y) {
		switch (c) {
		case '0':
			Entidad e = new EnemigoBasico(100, 40, mapa);
			entidades.addLast(e);
			e.setCelda(mapa.getCelda(y, x));
			e.getCelda().setEntidad(e);
			gui.crearEnemigo(e.getGrafico(), x, y);
		}
	}

	//Genera el objeto disparo, lo inserta en la gui y en la lista de entidades. Si resulta que el disparo va a aparecer donde ya hay una entidad, entonces 
	//colisiona y desaparece 


	public void mover(int dir){		
		int direccion = -1;
		switch (dir){
		case KeyEvent.VK_UP : //Arriba
			direccion = 0;
			break;
		case KeyEvent.VK_DOWN : //Abajo
			direccion = 1;
			break;
		case KeyEvent.VK_LEFT : //Izquierda
			direccion = 2;
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			direccion = 3;
			break;
		case KeyEvent.VK_PERIOD : 
			if (!entidades.isEmpty())
				entidades.getFirst().recibirDano(1000);
			break;
		case KeyEvent.VK_SPACE :
			j.disparar();
			//TEMPORAL REMOVER TODO
		}
		j.mover(direccion);
	}


	public void morir() {
		LinkedList<Entidad> muertos = new LinkedList<>();
		for (Entidad e : entidades)
			if (e.getVida() <= 0 )
				muertos.add(e);
		for (Entidad e : muertos) {
			entidades.remove(e);
			puntaje += e.getPuntaje();
			gui.removerGrafico(e.getGrafico());
			if (e.getCelda() != null) {
				e.getCelda().setEntidad(null);
			}
			e.setCelda(null);
		}
		if (j.getCelda() != null) 
			if (j.getVida() <= 0 ) 
				perder();
	}*/



}
