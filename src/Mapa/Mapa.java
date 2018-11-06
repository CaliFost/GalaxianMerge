package Mapa;

import java.util.Iterator;
import java.util.LinkedList;

import Juego.Logica;

public class Mapa {
	
	private Logica juego;
	private Celda mapa[][];
	private int ancho, alto;
	private LinkedList<String> niveles;
	private String nivelActual;
	
	public Mapa(int ancho, int alto, Logica juego){
		this.ancho = ancho;
		this.alto = alto;
		this.mapa = new Celda[ancho][alto];
		this.juego = juego;
		niveles = new LinkedList<>();
		niveles.addLast(new String("0000000000"));
		nivelActual = null;
		
		for(int i = 0; i < ancho; i++){
			for(int j = 0; j < alto; j++){
				this.mapa[i][j] = new Celda(this, i, j);
				this.mapa[i][j].setEntidad(null);
			}
		}
	}
	
	public void cargarNivel() {
		if (!niveles.isEmpty()) {
			nivelActual = niveles.removeFirst();
		} else {
			juego.ganar();
		}
		char[] c = nivelActual.toCharArray();
		for (int i = 0; i<nivelActual.length(); i++) {
			
			juego.crearEnemigo(c[i], i*Logica.ANCHOC, 0);
			
		}
		
	}
	
	//Retorna el arreglo de celdas
	public Celda[][] getMapa() {
		return mapa;
	}
		
	//Retorna la celda en las coordenadas fila, columna
	//CONSIDERAR QUE EN EL CONTEXTO DEL JUEGO/CLIENTE, LA COORDENADA Y DEFINE LA FILA Y LA COORDENADA X DEFINE LA COLUMNA
	public Celda getCelda(int fila, int columna){
		if (fila > 610 )
			fila=610;
		if (columna > 1224)
			columna = 1224;
		fila = fila/Logica.ALTOC;
		columna = columna/Logica.ANCHOC;
		return mapa[fila][columna];
	}
	
	//Retorna el ancho del mapa TODO NO SE PRECISA?
	public int getWidth() {
		return ancho;
	}
	
	//Retorna el alto del mapa TODO NO SE PRECISA?
	public int getHeight() {
		return alto;
	}
}
