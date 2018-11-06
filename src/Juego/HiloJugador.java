package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

import Entidades.Jugador;

public class HiloJugador extends Thread {

	private final float TIEMPO_ENTRE_DISPAROS = 400;//Milesimas de segundo
	private int movimiento; // FLAG del movimiento
	private int tiempoPausa;
	private boolean ejecutar;
	private Jugador jugador;
	private long ultTiempoDisparo;

	public HiloJugador(Jugador j) {
		this.tiempoPausa = 20;
		this.jugador = j;
		ejecutar = true;
		ultTiempoDisparo = System.currentTimeMillis();
		movimiento = Jugador.STPR;
		setListener();
	}

	public void run() {
		while (ejecutar) {

			jugador.mover(movimiento);

			try {
				Thread.sleep(tiempoPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void pausar() {
		ejecutar = false;
	}

	public void reiniciar() {
		ejecutar = true;
	}

	private class PlayerMovementAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private int d;

		public PlayerMovementAction(int d) {
			this.d = d;
		}

		public void actionPerformed(ActionEvent e) {
			if (!(movimiento == Jugador.RIGHT && d == Jugador.STPL)
					&& !(movimiento == Jugador.LEFT && d == Jugador.STPR)) {
				movimiento = d;
			}
		}
	}

	private class DisparoAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
			if(System.currentTimeMillis() - ultTiempoDisparo >= TIEMPO_ENTRE_DISPAROS) {
				jugador.disparar();
				ultTiempoDisparo = System.currentTimeMillis();
			}
		}

	}

	private void setListener() {
		InputMap inputMap = jugador.getGrafico().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = jugador.getGrafico().getActionMap();

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "mover derecha");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "mover parar derecha"); 
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "mover izquierda");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "mover parar izquierda"); 
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "disparo");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "disparo");

		actionMap.put("mover derecha", new PlayerMovementAction(Jugador.RIGHT));
		actionMap.put("mover parar derecha", new PlayerMovementAction(Jugador.STPR));
		actionMap.put("mover parar izquierda", new PlayerMovementAction(Jugador.STPL));
		actionMap.put("mover izquierda", new PlayerMovementAction(Jugador.LEFT));
		actionMap.put("disparo", new DisparoAction());
	}
}
