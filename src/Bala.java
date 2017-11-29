import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bala {
	private int x;// eje x -horizontal
	private int dx = 1;
	public boolean disparar = false;
	private int y;// eje y- vertical
	private BufferedImage image;
	private Jugador jugador;

	// constructor
	public Bala(boolean disparar, Jugador jugador) {
		this.disparar = disparar;
		this.jugador = jugador;
		x = jugador.getX() + 25;// posicion jugador centro en eje X
		y = jugador.getY() + 25;// posicion jugador centro en eje Y
		image = ImageManager.cargarImagen("/imagenes/bala11.png");

	}

	// pinta
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);

	}

	public void update() {

		if (disparar == true) {
			if (x < 480)
				x += dx;
			if (x == 480)
				disparar = false;

		}
	}

}// fin de la clase bala
