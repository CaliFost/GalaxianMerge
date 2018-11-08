package Juego;

import java.awt.Point;
import java.util.LinkedList;


import GUI.GUI;
import Juego.Logica;
import Entidades.*;


public class Mapa {
	public static final int ANCHO = 1360;
	public static final int ALTO = 720;
	public static final int ANCHOC = 136;
	public static final int ALTOC = 90;
	//protected static final int ENEMIGOSXFILA = 6;
	private Logica juego;
	protected int filas;
	//private int ancho, alto;
	//private LinkedList<String> niveles;
	//private String nivelActual;
	protected LinkedList<Entidad> enemigos;
	protected HiloMapa mapThread;
	protected HiloJugador playerThread;
	
	public Mapa(Logica juego){
		enemigos = new LinkedList<Entidad>();
		this.juego = juego;
		generarEnemigos();
	}
	
	/*	public JLabel getFondoNivel() {
		JLabel fondo = new JLabel(FONDO);
		fondo.setBounds(0, 0, ANCHURA_JUEGO, ALTURA_JUEGO);
		return fondo;
	}*/
	
	protected void generarEnemigos() {
		Point inicial = new Point(0, 0);
		//Enemigo en = new EnemigoBasico(inicial);
		//enemigos.add(en);
	}
		
	public void agregarEntidadEnLista(Entidad e) {
		mapThread.insertarEnLista(e);
	}
	
	public HiloMapa getThread() {
		return mapThread;
	}
	
	public void iniciarNivel(GUI g) {
		playerThread = new HiloJugador(juego.getJugador());
		mapThread = new HiloMapa(this, g);
		agregarEntidadEnLista(juego.getJugador());
		generarEnemigos();
		generarObstaculos();
		mapThread.start();
		playerThread.start();
	}
	
	public void generarObstaculos() {
		Obstaculo o = new Barrera(new Point(200, 200));
		mapThread.insertarEnLista(o);
	}

}
