package juego.elementos;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import juego.managers.ImageManager;


public class Escenario {
	
	private BufferedImage fondo;
	
	public Escenario(){
		fondo = ImageManager.cargarImagen("/imagenes/escenario2.png");
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(fondo,0,0,null);
	}

	public BufferedImage getFondo() {
		return fondo;
	}

	public void setFondo(BufferedImage fondo) {
		this.fondo = fondo;
	}

}
