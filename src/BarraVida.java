import java.awt.Color;
import java.awt.Graphics;


public class BarraVida {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int salud;
	private Jugador jugador;
	private EnemigoPrueba enemigo;
	private Entidad entidad;
	
	public BarraVida(int salud, Entidad entidad){
		this.salud =salud;
		this.entidad = entidad;
		alto = 10;
		x = entidad.getX();
		y = entidad.getY() - 10;
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, salud, alto);
	}
	
	public void update(){
		x = entidad.getX();
		y = entidad.getY() - 20;
	}

}
