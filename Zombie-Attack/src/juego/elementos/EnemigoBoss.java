package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class EnemigoBoss extends Enemigo{
	
	private Jugador jugador;
	private ArrayList<Misil> misiles;
	
	public EnemigoBoss(Jugador jugador){
		this.jugador = jugador;
		x = 735;//463
		y = 50;
		dx = 1;
		dy = 1;
		alto = 109;
		ancho = 70;
		salud = ancho;
		defensa = 8;
		color = Color.YELLOW;
		misiles = new ArrayList<Misil>();
		icon = new ImageIcon(Bala.class.getResource("/imagenes/enemiSuper.png"));
		//image = ImageManager.cargarImagen("/imagenes/nemesis.png");
		barraVida = new BarraVida(this);
	}
	
	public void render(Graphics g){
		g.drawImage(icon.getImage(), x, y, null);
		barraVida.render(g);
		for(int i =0 ; i < misiles.size(); i++){
			Misil item = misiles.get(i);
			if(item.isEliminarMisil() == false)
				item.render(g);
		}
		
	}
	
	public void update(){
		
		y += dy;
		barraVida.update();
		if(y > 391)
			dy = -dy;
		if(y < 0)
			dy = -dy;
		
		if(misiles.size() < 1)
			misiles.add(new Misil(this));
		
		for(int i = 0 ; i < misiles.size(); i++){
			Misil item = misiles.get(i);
			if(item.isEliminarMisil())
				misiles.remove(item);
		}
	}
	
	
	
	public ArrayList<Misil> getMisiles() {
		return misiles;
	}

	public void setMisiles(ArrayList<Misil> misiles) {
		this.misiles = misiles;
	}

}
