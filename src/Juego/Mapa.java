package Juego;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;

import Entidades.Entidad;
import Juego.Logica;
import src.Nivel.Bomba;
import src.Nivel.Debil;
import src.Nivel.Distraido;
import src.Nivel.FabricaDisparoEnemigo;
import src.Nivel.Kamikaze;
import src.Nivel.Perdedor;
import src.Nivel.PrototipoEnemigo;
import src.Nivel.ThreadNivel;


public class Mapa {
	public static final int ANCHO = 1360;
	public static final int ALTO = 720;
	public static final int ANCHOC = 136;
	public static final int ALTOC = 90;
	protected static final int ENEMIGOSXFILA = 6;
	private Logica juego;
	protected int filas;
	//private int ancho, alto;
	//private LinkedList<String> niveles;
	//private String nivelActual;
	protected LinkedList<Entidad> entidades;
	protected HiloMapa mapThread;
	protected HiloJugador playerThread;
	
	public Mapa(Logica juego){
		entidades = new LinkedList<Entidad>();
		this.juego = juego;
	}
	/*	public JLabel getFondoNivel() {
		JLabel fondo = new JLabel(FONDO);
		fondo.setBounds(0, 0, ANCHURA_JUEGO, ALTURA_JUEGO);
		return fondo;
	}*/
	
	protected void generarPrototiposEnemigos() {
		Point inicial = new Point(0, 0);
		PrototipoEnemigo bomba = new Bomba(inicial, new FabricaDisparoEnemigo(juego),juego);
		prototiposEnemigos.add(bomba);
		PrototipoEnemigo perdedor = new Perdedor(inicial, new FabricaDisparoEnemigo(juego), juego);
		prototiposEnemigos.add(perdedor);
		PrototipoEnemigo debil = new Debil(inicial, new FabricaDisparoEnemigo(juego), juego);
		prototiposEnemigos.add(debil);
		PrototipoEnemigo distraido = new Distraido(inicial, new FabricaDisparoEnemigo(juego), juego);
		prototiposEnemigos.add(distraido);
		PrototipoEnemigo kamikaze = new Kamikaze(inicial, new FabricaDisparoEnemigo(juego), juego);
		prototiposEnemigos.add(kamikaze);
	}
		
	public void agregarEntidadEnLista(Entidad e) {
		mapThread.insertarEnLista(e);
	}
	
	public HiloMapa getThread() {
		return mapThread;
	}
}
