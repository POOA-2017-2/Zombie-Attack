import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Jugador implements Runnable {

	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int HEIGHT = 53;//ancho de la Imagen del Jugador
	private int WIDTH = 78;//largo de la Imagen del Jugador
	private SpriteManager sm;
	private BufferedImage image;
	public BarraVida barraVida;
	private volatile boolean moveLeft;
	private volatile boolean moveRight;
	private volatile boolean moveUp;
	private volatile boolean moveDown;
	private boolean noMovement;
	private Animacion animacion;
	private Bala balas;// objecto bala
	//ArrayList<Bala> balas ;//array de objecto tipo bal
	private Game game;


	public Jugador(int x, int y) {

		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		moveLeft = false;
		moveRight = false;
		moveUp = false;
		moveDown = false;
		sm = new SpriteManager("/imagenes/soldierSpray.png");
		image = sm.subImage(1, 1, 79, 53);
		barraVida = new BarraVida(79, this);
		//balas = new ArrayList<Bala>();
		balas = new Bala(false, this);
		animacion = new Animacion(this);
		
		Thread t = new Thread(this);
		t.start();
	}

	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
		barraVida.render(g);
			if (balas.disparo== true) {
				balas.render(g);
			}
	}

	public void update() {

		if (moveUp ) {
			y -= dy;
		}
		if (moveDown) {
			y += dy;
		}
		if (moveRight) {
			x += dx;
		}
		if (moveLeft) {
			x -= dx;
		}
		
		barraVida.update();

		if(balas.disparo == true){
			 balas.update();
		}

	}


	public void run() {

		while (true) {

			while (moveUp ) {
				animacion.playerUp();
			}

			while (moveDown) {
				animacion.playerDown();
			}

			while (moveRight) {
				animacion.playerRight();
			}

			while (moveLeft) {
				animacion.playerLeft();
			}
		}
	}

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public boolean isMoveUp() {
		return moveUp;
	}

	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public SpriteManager getSm() {
		return sm;
	}

	public void setSm(SpriteManager sm) {
		this.sm = sm;
	}

	/*metodo disparar  solo se  activara cuando es presionado el boton D(disparar), mandara un true para
	 * las condiciones en render,update , solo se pintara cuando este sea true la variable disparo.
	 * */
	
	public void Disparar() {
		balas.disparo=true;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
}//FIN DE LA CLASE jUGADOR

