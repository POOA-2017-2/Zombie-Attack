package juego.elementos;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;


public class EnemigoLvl2 extends Enemigo{
	
	private Jugador jugador;
	
	public EnemigoLvl2(Jugador jugador){
		this.jugador = jugador;
		x = 770;//800
		y = (int) (Math.random() * 500);
		dx = 1;
		dy = 1;
		defensa = 4;
		color = Color.orange;
		ancho = 36;
		alto = 58;
		salud = ancho;
		barraVida = new BarraVida(this);
		icon = new ImageIcon(EnemigoLvl2.class.getResource("/imagenes/zombiLvl2.png"));
	}
	
	public void render(Graphics g){
		g.drawImage(icon.getImage(), x, y, null);
		barraVida.render(g);
	}
	
	public void update(){
		x -= dx;
		
		barraVida.update();
		
		if(jugador.getY() > y)
			y += dy;
		else
			y -= dy;
			
	}

}
