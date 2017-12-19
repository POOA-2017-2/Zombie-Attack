package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;



public class Enemigo extends Entidad implements Serializable {
	
	
	public void render(Graphics g){
		//g.drawImage(image, x, y, null);
		//barraVida.render(g);
	}
	
	public void update(){
		System.out.println("Enemigo");
		/*if(x > jugador.getX())
			x -= dx;
		if(x < jugador.getX())
			x += dx;
		if(y < jugador.getY())
			y += dy;
		if(y > jugador.getY())
			y -= dy;
		
		barraVida.update();*/
		
	}
}
