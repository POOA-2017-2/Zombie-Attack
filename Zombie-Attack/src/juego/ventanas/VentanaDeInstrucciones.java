package juego.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.game.Game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDeInstrucciones extends JFrame {

	private JPanel contentPane;
	private Game juego;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeInstrucciones frame = new VentanaDeInstrucciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaDeInstrucciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 453);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Zombie Attack _ Instrucciones");// coloca el titulo a la
													// ventana
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/Zombie-icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("I N S T R U C C I O N E S ");
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnRegresar.setBackground(new Color(154, 205, 50));
		btnRegresar.setForeground(new Color(0, 0, 0));
		btnRegresar.setBounds(629, 357, 144, 23);
		panel_1.add(btnRegresar);

		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaDeInstrucciones.class.getResource("/imagenes/instrcci2.png")));// IMAGEN
																											// PARA
																											// MOSTRAR
		fondo.setBounds(629, 11, 165, 342);// POSICION DE LA IMAGEN
		panel_1.add(fondo);

		TextArea textInst = new TextArea();
		textInst.setEditable(false);
		textInst.setFont(new Font("Arial", Font.BOLD, 12));// TIPO DE LETRA
		textInst.setForeground(new Color(0, 0, 0));
		textInst.setBackground(new Color(255, 255, 255));
		textInst.setText(
				"Este es un mundo lleno de atacantes zombies, tu misi\u00F3n es sobrevivir y obtener el mejor  puntaje de todas las partidas.\r\n\r\n[  D e s p l a z a m i e n t o  ]\r\n\r\nPara poder desplazarte libremente por el escenario debes utilizar tu mouse  manteniendo el cursor dentro de los botones mostrados en la ventana.\r\n\r\n [  D e f e n s a ] \r\n\r\nPara poder disparar debes de dar clic en el bot\u00F3n  [D] que se te mostrar con la letra D, al ser presionada podr\u00E1s utilizar la tecla D de tu teclado, podr\u00E1s disparar en todo momento al enemigo.\r\n\r\n [ P u n t u a c i \u00F3 n ]\r\n\r\nTu puntuaci\u00F3n final ser\u00E1 aquel en el cual hayas terminado el juego , recuerda que siempre se mostrara tu puntuaci\u00F3n en la parte superior izquierda. cada vez que dispares aun enemigo se aumentara +1 a tu puntuaci\u00F3n.\r\n\r\n [  E n e m i g o s ]\r\n\r\n Habr\u00E1  3 tipos de enemigos\r\n [1]-fijos = tendr\u00E1 una direcci\u00F3n fija en el escenario.\r\n [2]-Con movimiento= tendr\u00E1n movimiento propio, te persiguiran alo largo del escenario.\r\n [3]-Boss= Es el superior con ataques poderosos  y una gran defensa.\r\n");
		textInst.setBounds(10, 11, 613, 347);
		panel_1.add(textInst);

	}

}
