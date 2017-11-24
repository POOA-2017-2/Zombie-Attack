import java.awt.Color;
import java.awt.Graphics;


public class BarraVida {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int salud;
	private Jugador jugador;
	
	public BarraVida(int salud, Jugador jugador){
		this.salud = salud;
		this.jugador = jugador;
		x  = jugador.getX();
		y = jugador.getY() - 20;
		salud = 79;
		alto = 20;
	}
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, salud, alto);
	}
	
	public void update(){
		x = jugador.getX();
		y = jugador.getY() - 20;
	}

}
