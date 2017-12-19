package juego.elementos;
import java.io.Serializable;
import java.util.ArrayList;


public class Paquete implements Serializable{
	
	private int x;
	private int y;
	private int ancho;
	private int puntuacion;
	
	public Paquete(Jugador jugador, Marcador marcador){
		x = jugador.getX();
		y = jugador.getY();
		ancho = jugador.getBarraVida().getAncho();
		puntuacion = marcador.getC();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAncho() {
		return ancho;
	}
	
	public int getPuntuacion(){
		return puntuacion;
	}
	
}
