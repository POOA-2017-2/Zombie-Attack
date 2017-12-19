package juego.botones;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.ButtonModel;
import javax.swing.JButton;

import juego.game.Game;

import java.awt.Font;

public class MiBoton extends JButton {

	private static final long serialVersionUID = 1L;
	String text; // TEXTO DEL BOTON

	public MiBoton(Game juego, String text) {
		super(text);
		setForeground(new Color(139, 69, 19));
		setFont(new Font("Vani", Font.BOLD, 14));
		setContentAreaFilled(false); // SE PONE EN FALSE PARA QUE AREA DEL BOTON
										// NO SE DIBUJE
		setOpaque(false); // SE PONE EN FALSE PARA QUE EL BOTON SEA TRANSPARENTE
		setBorderPainted(false); // BORDE DEL BOTON
		setRolloverEnabled(true); // SE PONE EN TRUE PARA ACTIVAR LA ACCION
									// ROLLOVER DEL BOTON(SABER SI EL MOUSE ESTA
									// ENCIMA DE EL O NO)
		this.text = text;
	}

	// SOBRE ESCRIBIMOS ESTE METODO, PARA QUE NOS PERMITA DIBUJAR NUESTROS
	// BOTONES

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ButtonModel modelo = getModel(); // NOS PERMITIRA SABER SI EL BOTON ESTA
											// SIENDO CLIQUEADO
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D r2d = fm.getStringBounds(text, g);
		int x = (int) (getWidth() / 2 - r2d.getWidth() / 2);
		int y = (int) (getHeight() / 2 + r2d.getHeight() / 2);
		g.setColor(Color.BLACK); // PONEMOS EL PINCEL EN COLOR NEGRO

		// SI EL BOTON ESTA PRESIONADO ENTONCES...
		if (modelo.isArmed() && modelo.isPressed()) {
			g.setColor(Color.BLACK); // NEGRO OBSCURO EL OVALADO
			g.fillRoundRect(20, 1, (int) ((x + r2d.getWidth())), (int) (5 + r2d.getHeight()), 15, 20);// SE
																										// DIBUJA
																										// UN
																										// OVALO
			g.setColor(Color.green); // COLOR DEL TEXTO CAMBIA A NARANJA
			g.drawString(text, x, y); // PINTAMOS EL TEXTO

		}

	}

}// FIN class MiBoton
