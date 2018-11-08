package Juego;

import java.util.LinkedList;

import Entidades.Entidad;
import GUI.GUI;

public class HiloMapa extends Thread {
	private GUI grafica;
	private Mapa nivel;
	private LinkedList<Entidad> aInsertar;
	private LinkedList<Entidad> aRecorrer;
	private LinkedList<Entidad> aEliminar;

	private volatile boolean ejecutar;

	public HiloMapa(Mapa nivel, GUI grafica) {
		this.grafica = grafica;
		this.nivel=nivel;
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
				grafica.getJuego().getJugador().setPuntaje(e.getPuntaje());
				//grafica.cambiarPuntaje();
			}
		}
		grafica.repaint();
	}

	public void insertarEnLista(Entidad e) {
		aInsertar.add(e);
	}

	/**
	 * Inserta logica y graficamente la entidad
	 */
	private void insertarARecorrer() {


		System.out.println("Agregue entidad");
		for (Entidad e: aInsertar) {
			if (e != null) {
				grafica.agregarEntidad(e);
				aRecorrer.add(e);
			}
		}
		aInsertar.clear();
	}


	private void removerEliminados() {
		for (Entidad entidadRemovida: aEliminar) {
			if(entidadRemovida != null) {
				grafica.removerEntidad(entidadRemovida);
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
		if ((Math.abs(a.getPos().x - b.getPos().x) < 60) && (Math.abs(a.getPos().y - b.getPos().y) < 60))
			return true;
		else
			return false;
	}

	public void run() {
		double delta = 1;
		this.ejecutar = true;
		while (ejecutar) {
			while (delta >= 1) {
				insertarARecorrer();
				actualizar();
				controlarColisiones();
				removerEliminados();
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