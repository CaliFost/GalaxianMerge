package Juego;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import Disparos.DisparoJugador;
import Disparos.Disparo;
import Entidades.*;
import GUI.GUI;
import Mapa.Mapa;

public class Logica {

	//ALTO Y ANCHO DEL MAPA, Y DE CADA CELDA DE LA GRILLA
	public static final int ANCHO = 1360;
	public static final int ALTO = 720;
	public static final int ANCHOC = 136;
	public static final int ALTOC = 90; //VALORES TEMPORALES, o no / TODO

	protected Jugador j;
	protected Mapa mapa;
	protected LinkedList<Entidad> entidades;
	protected GUI gui;
	protected int puntaje;

	public Logica (GUI gui) {
		this.gui = gui;
		entidades = new LinkedList<Entidad>();
		puntaje = 0;
	}	

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

	public void crearMapa() {
		//TODO REMOVER TEMPORAL CREAR JUGADORBIEN
		mapa = new Mapa(7,10, this);
		gui.crearMapa(mapa);
	}			
	
	public Jugador crearJugador(Mapa m) {
		j = new Jugador(300, 40, m, this);
		return j;
	}
		
	public Jugador getJugador() {
		return j;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public LinkedList<Entidad> getEntidades(){
		return entidades;
	}

	//TODO Movimiento de los enemigos
	public void mover() {
		for (Entidad e : entidades) {
			int y = e.getGrafico().getY();
			int x = e.getGrafico().getX();
			//TODO
			//Si llego abajo del todo, mandarlo de nuevo para arriba. Hay que implementarlo en la estrategia.
			//Los disparos van a tener que "morir"
			if (y>=610) 
				e.getGrafico().setLocation(x, 0);
			else {
				e.mover();
				//e.setCelda(mapa.getCelda(e.getGrafico().getY(), e.getGrafico().getX()));
				//System.out.println(e.getCelda().getColumna()+"  "+e.getCelda().getFila());
			}
		}
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
	}
	
	public void perder() {
		//Game over, mostrar puntaje, reboot
		gui.removerGrafico(j.getGrafico());
		j.getCelda().setEntidad(null);
		j.setCelda(null);
		System.out.println("Perdiste pelotudo");
		System.out.println("Puntaje: "+puntaje);
	}
	
	public void ganar() {
		//if (puntaje>90000)
			System.out.println("Ganaste");
	}

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
	
	public void crearDisparoJugador(int x, int y) {
		Disparo d = new DisparoJugador(mapa, x, y, j);
		
		gui.crearDisparo(d.getGrafico(), x, y);
		entidades.addLast(d);
		if (d.getCelda().getEntidad() != null) {
			d.getCelda().getEntidad().serChocado(d);
		} else {
			d.getCelda().setEntidad(d);
		}
	}


}
