package Mapa;

import Entidades.Entidad;

public class Celda {
	
	protected Entidad entidad;
	protected Mapa mapa;
	protected int fila;
	protected int columna;
	
	public Celda(Mapa mapa, int fila, int columna){
		this.entidad = null;
		this.mapa = mapa;
		this.fila = fila;
		this.columna = columna;
	}
	
	public void setEntidad(Entidad e){
		entidad = e;
	}
	
	//Retorna el personaje de la celda
	public Entidad getEntidad(){
		return entidad;
	}
	
	//Retorna la fila del mapa en la que se encuentra la celda
	public int getFila() {
		return fila;
	}
		
	//Retorna la columna del mapa en la que se encuentra la celda
	public int getColumna() {
		return columna;
	}

}
