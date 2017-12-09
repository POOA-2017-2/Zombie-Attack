import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

public class Display extends JFrame {

	private int alto;
	private int ancho;
	private String titulo;
	private Canvas canvas;
	private JButton up, down, left, right, disparar;
	private Jugador jugador;

	public Display(int ancho, int alto, String titulo, Jugador jugador) {

		this.alto = alto;
		this.ancho = ancho;
		this.titulo = titulo;
		this.jugador = jugador;
		init();

	}

	public void init() {

		setSize(ancho, alto);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(titulo);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		up = new JButton("");
		up.setBounds(50, 400, 50, 50);
		getContentPane().add(up);
		up.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				jugador.setMoveUp(true);
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveUp(false);
			}

		});

		down = new JButton("");
		down.setBounds(50, 450, 50, 50);
		down.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveDown(true);
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveDown(false);
			}
		});
		getContentPane().add(down);

		left = new JButton("");
		left.setBounds(0, 430, 50, 50);
		left.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveLeft(true);
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveLeft(false);
			}
		});
		getContentPane().add(left);

		right = new JButton("");
		right.setBounds(100, 430, 50, 50);
		right.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				jugador.setMoveRight(true);
			}

			public void mouseExited(MouseEvent e) {
				jugador.setMoveRight(false);
			}
		});
		getContentPane().add(right);

		disparar = new JButton(" D");// boton para disparar
		disparar.setFont(new Font("Tahoma", Font.BOLD, 12));
		disparar.setBackground(Color.ORANGE);
		disparar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int tecla = e.getKeyCode();
				if (tecla == KeyEvent.VK_D) {
					System.out.println("tecla activada");
					jugador.addBala();
				}
			}
		});
		disparar.setBounds(200, 430, 50, 50);
		getContentPane().add(disparar);

		canvas = new Canvas();
		canvas.setSize(ancho, alto);
		getContentPane().add(canvas, BorderLayout.CENTER);
		pack();

		
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
