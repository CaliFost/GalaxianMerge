package Juego;

import java.util.LinkedList;

import Entidades.Entidad;
import GUI.GUI;

public class HiloMapa extends Thread {
	private GUI grafica;
	private LinkedList<Entidad> aInsertar;
	private LinkedList<Entidad> aRecorrer;
	private LinkedList<Entidad> aEliminar;

	private volatile boolean ejecutar;

	public HiloMapa(GUI grafica) {
		this.grafica = grafica;
		aInsertar = new LinkedList<Entidad>();
		aRecorrer = new LinkedList<Entidad>();
		aEliminar = new LinkedList<Entidad>();
	}
	
	public void detenerThread() {
		ejecutar = false;
	}
	
	private void actualizar() {
		for (Entidad e : aRecorrer) {
			e.actualizar();
			if (!e.estaVivo()) {
				aEliminar.add(e);
				grafica.getJuego().getJugador().sumarPuntaje(e.getPuntaje());
				grafica.cambiarPuntaje();
			}
		}
		grafica.actualizarGraficamente();
	}

	public void insertarEnLista(Entidad e) {
		aInsertar.add(e);
	}

	/**
	 * Inserta logica y graficamente la entidad
	 */
	private void insertarARecorrer() {
		for (Entidad e: aInsertar) {
			if (e != null) {
				grafica.agregarGraficamente(e);
				aRecorrer.add(e);
			}
		}
		aInsertar.clear();
	}


	private void removerEliminados() {
		for (Entidad entidadRemovida: aEliminar) {
			if(entidadRemovida != null) {
				grafica.eliminarGraficamente(entidadRemovida);
				aRecorrer.remove(entidadRemovida);
			}
		}
		aEliminar.clear();
	}

	private void controlarColisiones() {
		for (Entidad entidad1 : aRecorrer)
			for (Entidad entidad2 : aRecorrer) {
				if (entidad1 != entidad2) {
					if (hayColision(entidad1, entidad2) || hayColision(entidad2, entidad1))
						entidad1.chocar(entidad2);
				}
			}
	}

	private boolean hayColision(Entidad a, Entidad b) {
		boolean retorno;
		if ((Math.abs(a.getPos().x - b.getPos().x) < 60) && (Math.abs(a.getPos().y - b.getPos().y) < 60))
			retorno = true;
		else
			retorno = false;
		return retorno;
	}

	/**
	 * Lo puse para controlar el nivel
	 */
	private void controlarNivel() {
		if (aRecorrer.size() == 1) {
			detenerThread();
			grafica.gameWin();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double fps = 30.0; ////////////////// FPS
		double ns = 1000000000 / fps;
		double delta = 0;
		
		this.ejecutar = true;
	
		while (ejecutar) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				insertarARecorrer();
				actualizar();
				controlarColisiones();
				removerEliminados();
				controlarNivel();
				delta--;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}