

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EnemigoPrueba extends Entidad {
	
	private int dx;
	private int dy;
	private Jugador jugador;
	
	
	public EnemigoPrueba(int x, int y, Jugador jugador){
		this.x = x;
		this.y = y;
		this.jugador = jugador;
		dx = 1;
		dy = 1;
		image = ImageManager.cargarImagen("/imagenes/enemigo12.png");
		barraVida = new BarraVida(79,this);
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
	
	

}
