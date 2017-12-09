import java.awt.Color;
import java.awt.Graphics;


public class EnemigoPrueba extends Entidad {
	
	
	private Jugador jugador;
	protected Color color;
	
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
		g.setColor(color.RED);
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
