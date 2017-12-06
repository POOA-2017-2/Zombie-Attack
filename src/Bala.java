import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bala implements Runnable{
	private int x;
	private int y;
	private int dx;
	private boolean eliminarBala;
	//private BufferedImage image;
	private Entidad entidad;

	// constructor
	public Bala(Entidad entidad) {
		this.entidad = entidad;
		dx = 1;
		x = entidad.getX() + 25;// posicion jugador centro en eje X
		y = entidad.getY() + 25;// posicion jugador centro en eje Y
		eliminarBala = false;
		Thread t = new Thread(this);
		t.start();
		//image = ImageManager.cargarImagen("/imagenes/bala11.png");
	}

	// pinta
	public void render(Graphics g) {
		g.setColor(Color.RED);
		if(eliminarBala == false)
			g.fillRect(x, y, 5, 5);
	}

	public void update() {
		x += dx;
	}
	
	public boolean getEliminarBala(){
		return eliminarBala;
	}
	
	public void setEliminarBala(boolean eliminarBalas){
		this.eliminarBala = eliminarBalas;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,5,5);
	}
	
	public void run(){
		while(x < 480 && x > 0 && y > 0 && y < 480){
			update();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x < 1 || x > 478 || y > 478 || y < 1)
				eliminarBala = true;
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}// fin de la clase bala

/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bala {
	private static final int HEIGHT = 17;
	private static final int WIDTH = 26;
	private int x;// eje x -horizontal
	private int y;// eje y- vertical
	private int dx = 1;
	public boolean disparo = false;
	private BufferedImage image;
	private Jugador jugador;
	private EnemigoPrueba enemigo;

	public Bala(boolean disparo, Jugador jugador) {
		this.disparo=(disparo);
		this.jugador = jugador;
		x = jugador.getX();// posicion jugador en eje X
		y = jugador.getY();// posicion jugador  en eje Y
		image = ImageManager.cargarImagen("/imagenes/bala11.png");

	}

	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
		g.fillRect(x, y,  WIDTH, HEIGHT);
	}

	public void update() {
		x = jugador.getX()+25;
		y = jugador.getY()+25;
			if (x < 480)
				x += dx;
			if (x== 480)
				disparo= (false);
			
			if (collision()){
				System.out.println("herir zombie");//comprobacion de colision con el jugador
				//enemigo.barraVida.vidaEnemigo();//se manda a llamar el metodo vidaEnemigo que restara -30puntos a Salud Enemigo
			}
			
	}
	
	public Rectangle getBounds() {
	
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	private boolean collision() {
		return false;
		//return enemigo.getBounds().intersects(getBounds());
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
	
	
}// fin de la clase bala*/
