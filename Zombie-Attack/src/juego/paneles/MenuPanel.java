package juego.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import juego.game.Game;
import juego.ventanas.VentanaDeInstrucciones;
import juego.ventanas.VentanaDeRangos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import juego.botones.MiBoton;


public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MiBoton btnPlay; // Boton singlePlayer
	private MiBoton btnPlayMulti;//boton multiPlayer
	private MiBoton btnAbout; // boton acerca de
	private MiBoton btnHigtCore; // boton alto puntuaje
	private VentanaDeInstrucciones ventanaInstrucciones;
	private VentanaDeRangos ventanaRango;
	private boolean cliente;
	
	public MenuPanel(Game juego,boolean cliente) {
		this.cliente = cliente;
		setLayout(null);
	 
		
		btnPlay = new MiBoton(juego,"SinglePlayer"); // CREAMOS EL BOTON NEW
		// AGREGAMOS LA ACCION QUE REALIZARA EL BOTON NEW
		btnPlay.addActionListener(
			// CLASE ANONIMA PARA CONTROLAR LA ACCION DEL BOTON
			new ActionListener() {
				// METODO QUE SE EJECUTARA CUANDO REALIZAMOS CLICK EN EL BOTON.
				public void actionPerformed(ActionEvent e) {
					if(cliente)
						juego.getJuegoC().show(false);
					else
						juego.getJuego().show(false);
				}
			}
		);
		btnPlay.setBounds(350, 100, 117, 35);// ESTABLECEMOS LA COORDENADA Y DIMENSIONES DEL BOTON.
		add(btnPlay); // AGREGAMOS EL BOTON AL PANEL

		btnPlayMulti = new MiBoton(juego,"MultiPlayer");
		btnPlayMulti.addActionListener(		
			new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					if(cliente)
						juego.getJuegoC().show(true);
					else
						juego.getJuego().show(true);
				
				}
			}
		);
		btnPlayMulti.setBounds(350, 140, 117, 35);// ESTABLECEMOS LA COORDENADA Y DIMENSIONES DEL BOTON.
		add(btnPlayMulti); // AGREGAMOS EL BOTON AL PANEL
		
		
		btnAbout = new MiBoton(juego,"About"); 
		btnAbout.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventanaInstrucciones = new VentanaDeInstrucciones();
						ventanaInstrucciones.setVisible(true);
						
					}
				}
			);
		btnAbout.setBounds(350, 180, 117, 29); 
		add(btnAbout);
	
		btnHigtCore = new MiBoton(juego,"HigtCore"); 
		btnHigtCore.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventanaRango = new VentanaDeRangos();
						ventanaRango.setVisible(true);
					}
				}
			);
		btnHigtCore.setBounds(350, 220, 117, 29); 
		add(btnHigtCore);
		

	}
	
	//Para crear el fondo en la ventana Del menu
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Image imagen = new ImageIcon(MenuPanel.class.getResource("/imagenes/portada12.png")).getImage();
		int x = getWidth() / 2 - imagen.getWidth(this) / 2;
		int y = getHeight() / 2 - imagen.getHeight(this) / 2;
		g.drawImage(imagen, x, y, this);
	}
	
}
