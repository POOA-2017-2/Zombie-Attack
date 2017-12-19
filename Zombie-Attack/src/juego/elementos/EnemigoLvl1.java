package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;


public class EnemigoLvl1 extends Enemigo{

	
	public EnemigoLvl1() {
		x = 770;//800
		y = (int) (Math.random() * 500);
		dx = 1;
		defensa = 0;
		color = Color.RED;
		ancho = 23;
		alto = 45;
		salud = ancho;
		barraVida = new BarraVida(this);
		icon = new ImageIcon(EnemigoLvl1.class.getResource("/imagenes/zombiLvl1.png"));
		
	}
	
	public void update(){
		x -= dx;
		barraVida.update();
	}
	
	public void render(Graphics g){
		g.drawImage(icon.getImage(), x, y, null);
		barraVida.render(g);
	}

}
