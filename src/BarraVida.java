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
	
	public BarraVida(int salud, Jugador jugador){
		this.salud =salud;
		this.jugador = jugador;
		alto = 10;
		x = jugador.getX();
		y = jugador.getY() - 10;
		
	}
	public BarraVida(int salud, EnemigoPrueba enemigo) {
		this.salud = salud;
		this.enemigo = enemigo;
		x = enemigo.getX();
		y = enemigo.getY() - 20;
		alto = 20;
	}

	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(x, y, salud, alto);
	}
	
	public void update(){
		if (enemigo == null) {
			x = jugador.getX();
			y = jugador.getY() - 20;
		}
		if (jugador == null) {
			x = enemigo.getX();
			y = enemigo.getY() - 20;
		}
	}

}
