package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Juego.*;
import Entidades.*;
import Mapa.*;

public class GUI {
	 

	private JFrame frame;
	private Logica logica;
	private JLabel puntaje;
	private ContadorTiempo tiempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public GUI() {
		logica = new Logica(this);	
		initialize();
		tiempo = new ContadorTiempo(logica,this);
		tiempo.start();
		
		
		//TODO ESTA BIEN? // AL PARECER SI CLARK
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				mover(arg0);
			}
		});
		frame.getContentPane().setLayout(null);
	}
	
	protected void mover(KeyEvent key){
		logica.mover(key.getKeyCode());
		
		this.repaint();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1330, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		logica.crearMapa();
		JPanel panelPuntos = new JPanel();
		panelPuntos.setBounds(0, 720, 1360, 48);
		frame.getContentPane().add(panelPuntos);
		puntaje = new JLabel("0");
		puntaje.setFont(new Font("Serif", Font.PLAIN, 24));
		panelPuntos.add(puntaje);
	}
	
	public void crearMapa(Mapa m){
		JLabel mapa = new JLabel(new ImageIcon(this.getClass().getResource("/juego/mapa.png")));
		mapa.setBounds(0, 0, 1366, 768);
		frame.setContentPane(mapa);
		frame.setResizable(false);
		Jugador j = logica.crearJugador(m);
		JLabel l = j.getGrafico();
		l.setBounds(680, 600, Logica.ALTOC, Logica.ANCHOC);
		frame.getContentPane().add(l);
		j.setCelda(m.getCelda(l.getY(), l.getX()));
		j.getCelda().setEntidad(j);
		m.cargarNivel();
		
		
		//TODO AGREGAR ENEMIGO BASICO TEMPORAL
		/*for (int i=0;i<=9;i++) {
			Enemigo e = new EnemigoBasico(300, 40);
			logica.getEntidades().add(e);
			JLabel l2 = e.getGrafico();
			l2.setBounds(0,0,Logica.ALTOC,Logica.ANCHOC);
			e.setCelda(m.getCelda(0, 0));
			m.getCelda(0, 0).setEntidad(e);
			frame.getContentPane().add(l2);
		*/
	}
	
	public void repaint() {
		frame.revalidate();
		frame.repaint();
	}
	
	//DUDOSO TODO
	public void removerGrafico(JLabel l) {
		frame.getContentPane().remove(l);
		Integer i = logica.getPuntaje();
		puntaje.setText(i.toString());
		
	}
	
	public void crearEnemigo(JLabel l, int x, int y) {
		l.setBounds(x, y, Logica.ANCHOC, Logica.ALTOC);
		frame.getContentPane().add(l);
	}
	
	public void crearDisparo(JLabel l, int x, int y) {
		
		l.setBounds(x,y,Logica.ANCHOC,Logica.ALTOC);
		frame.getContentPane().add(l);
	}
	
}
