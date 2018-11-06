package Juego;

import Entidades.Entidad;
import GUI.*;

public class ContadorTiempo extends Thread {
	private Logica juego;
	private GUI gui;
	
	public ContadorTiempo(Logica l, GUI g) {
		juego = l;
		gui = g;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {}
			//elJuego.morir();
			juego.mover();
			juego.morir();
			//elJuego.atacar();
			gui.repaint();
		}
	}
}