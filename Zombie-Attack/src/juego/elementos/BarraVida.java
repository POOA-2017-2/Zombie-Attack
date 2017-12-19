package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;



public class BarraVida implements Serializable{
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private Entidad entidad;
	protected Color color;
	
	public BarraVida(Entidad entidad){
		ancho = entidad.getSalud();
		alto = 10;
		this.entidad = entidad;
		color = entidad.getColor();
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