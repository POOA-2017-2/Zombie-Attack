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
	protected Color color;
	
	public BarraVida(Entidad entidad){
		ancho = entidad.getSalud();
		alto = 10;
		this.entidad = entidad;
		x = entidad.getX();
		y = entidad.getY();
		
	}

	public void render(Graphics g){
		g.setColor(color);//Color.RED
		g.fillRect(x, y, ancho, alto);
	}
	
	public void update(){
		x = entidad.getX();
		y = entidad.getY() - 20;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

}

/*import java.awt.Color;
import java.awt.Graphics;


public class BarraVida {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int saludJugador = 100;	//100 puntos de vida
	private int saludEnemigo = 90;
	private Jugador jugador;
	private EnemigoPrueba enemigo;
	private Entidad entidad;
    private Game game;//
	
	public BarraVida(int saludJugador, Jugador jugador){
		this.saludJugador =saludJugador;
		this.jugador = jugador;
		alto = 10;
		x = jugador.getX();
		y = jugador.getY() - 10;
		
	}
	public BarraVida(int saludEnemigo, EnemigoPrueba enemigo) {
		this.saludEnemigo = saludEnemigo;
		this.enemigo = enemigo;
		x = enemigo.getX();
		y = enemigo.getY() - 20;
		alto = 10;
	}

	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, saludJugador, alto);
		g.fillRect(x, y, saludEnemigo, alto);
		
		if(saludJugador <= 50){
			g.setColor(Color.RED);
			g.fillRect(x-1, y, saludJugador, alto);
		}
		if(saludEnemigo <= 50){
			g.setColor(Color.RED);
			g.fillRect(x-30, y, saludJugador, alto);
		}
		
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
	public void vidaJugador(){
		saludJugador--;
		System.out.print(saludJugador);
		if(saludJugador == 0){
			game.gameOver();
		}
	}
	public void vidaEnemigo(){
		saludEnemigo--;
		System.out.println(saludEnemigo);
	}


}*/
