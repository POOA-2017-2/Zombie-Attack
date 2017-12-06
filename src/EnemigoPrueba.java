import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EnemigoPrueba extends Entidad {
	
	
	private Jugador jugador;
	
	public EnemigoPrueba(int x, int y, Jugador jugador){
		this.x = (int) (x + (Math.random() * 100));
		this.y = (int) (y + (Math.random() * 100));
		this.jugador = jugador;
		dx = 1;
		dy = 1;
		ancho = 79;
		alto = 53;
		salud = ancho;
		image = ImageManager.cargarImagen("/imagenes/enemigo12.png");
		barraVida = new BarraVida(this);
	}
	
	public void render(Graphics g){
		g.drawImage(image, x, y, null);
		barraVida.render(g);
	}
	
	public void update(){
		
		if(x > jugador.getX())
			x -= dx;
		if(x < jugador.getX())
			x += dx;
		if(y < jugador.getY())
			y += dy;
		if(y > jugador.getY())
			y -= dy;
		
		barraVida.update();
		
	}
}

/*
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class EnemigoPrueba extends Entidad {
	private int x;
	private int y;
	private int WIDTH = 24;//ancho de la imagen de Enemigo
	private int HEIGHT = 45;//alto de la imagen de Enemigo
	private int dx;
	private int dy;
	private BufferedImage image;
	public BarraVida barraVida;
	private Jugador jugador;
	
	public EnemigoPrueba(int x, int y, Jugador jugador){
		this.x = x;
		this.y = y;
		this.jugador = jugador;
		dx = 1;
		dy = 1;
		image = ImageManager.cargarImagen("/imagenes/enemigo12.png");
		barraVida = new BarraVida(79, this);
	}
	
	public void render(Graphics g){
		g.drawImage(image, x, y, null);
		barraVida.render(g);
	}
	
	public void update(){
		
		if(x > jugador.getX())
			x -= dx;
		if(x < jugador.getX())
			x += dx;
		if(y < jugador.getY())
			y += dy;
		if(y > jugador.getY())
			y -= dy;
		if (collision()){
			System.out.println("estoy chocando con jugador.");//comprobacion de colision con el jugador
			jugador.barraVida.vidaJugador();//se manda a llamar el metodo vidaJugador que restara -1 a Salud jugador
		}
		barraVida.update();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	private boolean collision() {

		return jugador.getBounds().intersects(getBounds());
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
}*/
