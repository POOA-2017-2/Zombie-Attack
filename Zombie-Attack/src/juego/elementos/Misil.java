package juego.elementos;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class Misil implements Runnable {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int dx;
	private boolean eliminarMisil;
	private ImageIcon icon;
	
	public Misil(Entidad entidad){
		x = entidad.getX();
		y = entidad.getY();
		ancho = 50;
		alto = 25;
		eliminarMisil = false;
		dx = 2;
		icon = new ImageIcon(Misil.class.getResource("/imagenes/boladeFuego.png"));
		Thread t = new Thread(this);
		t.start();
	}
	
	public void render(Graphics g){
		if(eliminarMisil == false)
			g.drawImage(icon.getImage(), x, y, null);
	}
	
	public void update(){
		x -= dx;
		if(x < 0)
			eliminarMisil = true;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,ancho,alto);
	}

	public boolean isEliminarMisil() {
		return eliminarMisil;
	}

	public void setEliminarMisil(boolean eliminarMisil) {
		this.eliminarMisil = eliminarMisil;
	}

	@Override
	public void run() {
		while(true){
			update();
			try{
				Thread.sleep(10);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
