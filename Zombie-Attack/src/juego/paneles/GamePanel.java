package juego.paneles;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import juego.elementos.Jugador;

public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Canvas canvas; // LIENZO PARA PINTAR EL JUEGO.
	private Jugador jugador;
	private JButton up, down, right, left, disparar;
	
	public GamePanel(Jugador jugador) {
		// TODO Auto-generated constructor stub
		this.jugador = jugador;
		init();
	}

	public void init(){
		
		setLayout(null);
		
		
		left = new JButton("<---"); // BOTON IZQUIERDO.
		left.setBounds(0, 430, 50, 50);
		left.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveLeft(true);
				System.out.println("Mouse inside");
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveLeft(false);
				System.out.println("Mouse outside");
			}
		});
		add(left);
		
		
		
		right=new JButton("-->"); // BOTON DERECHO.
		right.setBounds(100, 430, 50, 50);
		right.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveRight(true);
				System.out.println("Mouse inside");
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveRight(false);
				System.out.println("Mouse outside");
			}
		});
		add(right);
		
		up=new JButton(""); // BOTON DERECHO.
		up.setBounds(50, 400, 50, 50);
		up.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveUp(true);
				System.out.println("Mouse inside");
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveUp(false);
				System.out.println("Mouse outside");
			}
		});
		add(up);
		
		down=new JButton(""); // BOTON DERECHO.
		down.setBounds(50, 450, 50, 50);
		down.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveDown(true);
				System.out.println("Mouse inside");
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveDown(false);
				System.out.println("Mouse outside");
			}
		});
		add(down);
		
		disparar = new JButton(" D");// boton para disparar
		disparar.setFont(new Font("Tahoma", Font.BOLD, 12));
		disparar.setBackground(Color.ORANGE);
		disparar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int tecla = e.getKeyCode();
				if (tecla == KeyEvent.VK_D) {
					jugador.addBala();
				}
			}
		});
		disparar.setBounds(200, 430, 50, 50);
		add(disparar);
		
		canvas=new Canvas(); // INICIALIZAMOS EL CANCAS(LIENZO)
		canvas.setSize(800, 500); 
		add(canvas); // <--- AGREGAMOS EL CANVAS AL CENTRO DEL CONTENTPANE

		canvas.setFocusable(true); // PONEMOS EN FOCO AL LIENZO.
		//addKeyListener(km);
		//setFocusable(true);
		

		setVisible(true); // HACEMOS VISIBLE AL PANEL.
		//add(canvas);
	}
	
	// METODO PARA RETORNAR EL LIENZO.
	public Canvas getCanvas() {
		return canvas;
	}

	// METODO PARA RETORNAR EL OBJETO QUE CONTROLA LOS EVENTOS DEL TECLADO.

}
