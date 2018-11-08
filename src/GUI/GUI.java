package GUI;

import java.awt.*;
import javax.swing.*;
import Juego.*;
import Entidades.*;

public class GUI {
	 

	private static JFrame frame;
	private static Logica juego;
	private static JLabel puntaje;
	private static JFrame ventana;
	private static JPanel panelJuego;
	//private JPanel panelEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana = new JFrame();
					GUI grafico = new GUI();
					ventana.setLayout(new FlowLayout());
					panelJuego = new JPanel();
					juego = new Logica(grafico);
					panelJuego.setPreferredSize(new Dimension(1024, 768));
					panelJuego.setLayout(null);
					//panelJuego.set(new ImageIcon(this.getClass().getResource("/juego/mapa.png")));
					panelJuego.add(new ImageIcon(this.getClass().getResource("/juego/mapa.png")));
					//Habria que poner nuestro background aca
					ventana.add(panelJuego);
					ventana.setTitle("Galaxian");
					ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					initialize();
			        panelJuego.add(puntaje);
					ventana.pack();
					ventana.setVisible(true);
				} catch (Exception e) {	e.printStackTrace();}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1330, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panelPuntos = new JPanel();
		panelPuntos.setBounds(0, 720, 1360, 48);
		frame.getContentPane().add(panelPuntos);
		puntaje = new JLabel("0");
		puntaje.setFont(new Font("Serif", Font.PLAIN, 24));
		puntaje.setText("0");
        puntaje.setBounds(720,0,200,60);
        puntaje.setForeground(Color.YELLOW);	
        panelPuntos.add(puntaje);
	}
	
	
	public void repaint() {
		panelJuego.repaint();
		frame.revalidate();
		frame.repaint();
	}
	
	public void removerEntidad(Entidad e) {
		panelJuego.remove(e.getGrafico());
	}
	
	public void removerGrafico(JLabel l) {
		frame.getContentPane().remove(l);
		Integer i = juego.getPuntaje();
		puntaje.setText(i.toString());
	}
	
	public void agregarEntidad(Entidad e) {
		panelJuego.add(e.getGrafico());
	}
	
	public void cambiarPuntaje() {
		puntaje.setText(juego.getJugador().getPuntaje() + "");
	}
	
	public Logica getJuego() {
		return juego;
	}
	public void perder() {
		//Icon imagenFinal = new ImageIcon(this.getClass().getResource("/img/gameover.jpg"));
		System.out.println("Perdiste");
		JLabel contentPane = new JLabel();
		//contentPane.setIcon( imagenFinal );
		contentPane.setLayout( new BorderLayout() );
		
		ventana.remove(panelJuego);
		ventana.setContentPane( contentPane );
		ventana.pack();
		ventana.repaint();
	}

	public void ganar() {
		//Icon imagenFinal = new ImageIcon(this.getClass().getResource("/img/gamewin.jpg"));
		System.out.println("Ganaste");
		JLabel contentPane = new JLabel();
		//contentPane.setIcon( imagenFinal );
		contentPane.setLayout( new BorderLayout() );
		
		ventana.remove(panelJuego);
		ventana.setContentPane( contentPane );
		ventana.pack();
		ventana.repaint();
	}
	
/*	public void crearEnemigo(JLabel l, int x, int y) {
		l.setBounds(x, y, Logica.a, Logica.ALTOC);
		frame.getContentPane().add(l);
	}
	
	public void crearDisparo(JLabel l, int x, int y) {
		
		l.setBounds(x,y,Logica.ANCHOC,Logica.ALTOC);
		frame.getContentPane().add(l);
	}*/
	
}
