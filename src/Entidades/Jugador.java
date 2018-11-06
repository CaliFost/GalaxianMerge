package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Collider.ColisionadorEnemigo;
import Collider.ColisionadorJugador;
import Disparos.*;
import Mapa.*;
import Juego.Logica;
public class Jugador extends Nave {
	private Logica l;	
	public Jugador(int vida, int dano, Mapa m, Logica l) {
		this.vida = vida;
		this.dano = dano;
		velocidad = 15; //TODO Definir velocidad
		mapa = m;
		this.velDisparo=40;
		grafico = new JLabel(new ImageIcon(this.getClass().getResource("/Juego/nave_azul.PNG")));
		this.l = l;
		colisionador = new ColisionadorJugador(this);
	}
	
	//Mueve el jugador a lo largo del eje X. Si la celda a la que intenta moverse ya esta ocupada por otra entidad, se produce una colision.
	//Al moverse, si la celda correspondiente a las nuevas coordenadas es distinta a la celda correspondiente a las coordenadas anteriores, se cambia la celda del jugador
	// y se actualiza la informacion de las celdas del mapa.
	public void mover(int dir){	
		//Creo que se podria modularizar un poco mas, abstrayendo
		int nx = grafico.getX();
		int ny = grafico.getY();
		int fila = celda.getFila();			//TODO ESTO TIENE QUE SER STATE.MOVER()
		int columna = celda.getColumna();
		Celda nuevaCelda;
		switch (dir) {
		// EL JUGADOR SOLO PUEDE MOVERSE DE IZQUIERDA A DERECHA
		
			case 0 : //Arriba
				/*
				ny = ny-velocidad;
				if(ny<=0) {
					break;
					
				}
				
				nuevaCelda = mapa.getCelda(ny, nx);
				if (nuevaCelda != celda) {
					if (nuevaCelda.getEntidad() != null) {
						//COLISIONAR TODO
						break;
					}
					
					celda.setEntidad(null);
					celda = nuevaCelda;
					celda.setEntidad(this);
				}
				
				grafico.setLocation(nx, ny);	//Se le resta velocidad a pos.y
				*/
				break;
				
				
			case 1 : //Abajo
				/*
				ny = ny+velocidad;
				if (ny>610) {
					break;
					
				}
				
				nuevaCelda = mapa.getCelda(ny, nx);
				if (nuevaCelda != celda) {
					if (nuevaCelda.getEntidad() != null) {
						//COLISIONAR TODO
						break;
					}
					
					celda.setEntidad(null);
					celda = nuevaCelda;
					celda.setEntidad(this);
				}
				
				grafico.setLocation(nx, ny);	//Se le suma velocidad a pos.y
				*/
				break;
				
		//SOLO VALE DE ACA PARA ABAJO, LO ANTERIOR ES SOLO PARA PRUEBA.		
		
			case 2 : //Izquierda
				nx = nx-velocidad;
				if (nx<=0) {
					break;
				}
				
				nuevaCelda = mapa.getCelda(ny, nx);
				if (nuevaCelda != celda) {
					if (nuevaCelda.getEntidad() != null) {
						//COLISIONAR TODO
						break;
					}
					
					celda.setEntidad(null);
					celda = nuevaCelda;
					celda.setEntidad(this);
				}
				
				grafico.setLocation(nx, ny);	//Se le resta velocidad a pos.x
				break;
				
				
			case 3 : //Derecha
				nx = nx+velocidad;
				if (nx>=1224) {
					break;
				}
				
				nuevaCelda = mapa.getCelda(ny, nx);
				if (nuevaCelda != celda) {
					if (nuevaCelda.getEntidad() != null) {
						//COLISIONAR TODO
						break;
					}
					
					celda.setEntidad(null);
					celda = nuevaCelda;
					celda.setEntidad(this);
				}
				
				grafico.setLocation(nx, ny);	//Se le suma velocidad a pos.x
				break;
		}
	}
	
	public void disparar() {
		
		l.crearDisparoJugador(grafico.getX(), grafico.getY()); //ESTO TIENE QUE SER STATE.ATACAR()
		
	}
	
	public void setCollider(ColisionadorEnemigo CJ) {
		colisionador=CJ;
	}
	
	public void recibirDano(int d) {
		vida-=d;
		if (vida<0)
			morir();
	}
	
	public int getVelDisparo() {
		return velDisparo;
	}
	
	public void morir() {
		l.perder();
	}
}
