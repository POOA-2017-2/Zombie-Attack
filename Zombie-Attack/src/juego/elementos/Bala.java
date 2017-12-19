package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.swing.ImageIcon;

import juego.paneles.MenuPanel;

public class Bala implements Runnable, Serializable{
	
	private int x;
	private int y;
	private int dx;
	private ImageIcon icon;
	private boolean eliminarBala;

	public Bala(int x, int y) {
		dx = 1;
		this.x = x + 25;// posicion jugador centro en eje X
		this.y = y + 25;// posicion jugador centro en eje Y
		eliminarBala = false;
		icon = new ImageIcon(Bala.class.getResource("/imagenes/bala3.png"));
		Thread t = new Thread(this);
		t.start();
	}

	public void render(Graphics g) {
		if(eliminarBala == false)
			g.drawImage(icon.getImage(), x, y, null);
	}

	public void update() {
		x += dx;
	}
	
	public boolean getEliminarBala(){
		return eliminarBala;
	}
	
	public void setEliminarBala(boolean eliminarBalas){
		this.eliminarBala = eliminarBalas;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,5,5);
	}
	
	public void run(){
		while(x < 780 && x > 0 && y > 0 && y < 780){
			update();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x < 1 || x > 780 || y > 780 || y < 1)
				eliminarBala = true;
		}
	}
}