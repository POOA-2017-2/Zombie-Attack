import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Enemigo extends JPanel implements Runnable {

	int x = 480;
	Thread hilo;
	private int dx=0;

	public Enemigo() {
		hilo = new Thread(this);
		hilo.start();
	}

	public void render(Graphics g) {
		//g.fillRect(0, 0, getWidth(), getHeight());
		Image imagen = new ImageIcon(Enemigo.class.getResource("/imagenes/enemigo12.png")).getImage();
		g.drawImage(imagen, x, 210, this);

	}

	public void run() {

		try {
			while (true) {
				/*
				 * MOVIMIENTO DE ENEMIGO X es una constante fija: Es el valor
				 * del tamano dela ventana, las condiciones siguientes, se
				 * ejecutaran hasta que el valor de x cambie consecutivamente y
				 * cumpla la condicion; Es decir al llegar al marco contrario
				 * cambiara de direccion (izquierda derecha).
				 * 
				 */
				while (x > 10) {
					Thread.sleep(250);
					x -= 10;
					repaint();
					// System.out.print("izq" + x);
				}
				while (x < 480) {
					Thread.sleep(250);
					x += 10;
					repaint();
					// System.out.print("derecha\n" + x);
				}

			}
		} catch (Exception e) {
			System.out.println("Sucedio un error" + e.getMessage());
		}

	}

	public void update() {
		x+=dx ;
		//System.out.println("valor"+dx+x);
		
	}

}// FIN DE LA CLASE ENEMIGO