import java.awt.Color;
import java.awt.Graphics;


public class EnemigoLvl1 extends Enemigo{

	
	public EnemigoLvl1() {
		x = 450;
		y = (int) (Math.random() * 500);
		dx = 1;
		defensa = 0;
		color = Color.RED;
		ancho = 23;
		alto = 45;
		salud = ancho;
		barraVida = new BarraVida(this);
		image = ImageManager.cargarImagen("/imagenes/enemigo12.png");
		
	}
	
	public void update(){
		x -= dx;
		barraVida.update();
	}
	
	public void render(Graphics g){
		g.drawImage(image, x, y, null);
		barraVida.render(g);
	}

}
