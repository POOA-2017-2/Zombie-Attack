import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class EnemigoBoss extends Enemigo{
	
	private Jugador jugador;
	private ArrayList<Misil> misiles;
	
	public EnemigoBoss(Jugador jugador){
		this.jugador = jugador;
		x = 400;
		y = 50;
		dx = 5;
		dy = 5;
		alto = 300;
		ancho = 166;
		salud = ancho;
		defensa = 8;
		color = Color.BLACK;
		misiles = new ArrayList<Misil>();
		image = ImageManager.cargarImagen("/imagenes/nemesis.png");
		barraVida = new BarraVida(this);
	}
	
	public void render(Graphics g){
		g.drawImage(image, x, y, null);
		barraVida.render(g);
		for(int i =0 ; i < misiles.size(); i++){
			Misil item = misiles.get(i);
			if(item.isEliminarMisil() == false)
				item.render(g);
		}
		
	}
	
	public void update(){
		
		if(misiles.size() < 1)
			misiles.add(new Misil(this));
		
		for(int i =0 ; i < misiles.size(); i++){
			Misil item = misiles.get(i);
			if(item.isEliminarMisil())
				misiles.remove(i);
		}
	}
	
	
	
	public ArrayList<Misil> getMisiles() {
		return misiles;
	}

	public void setMisiles(ArrayList<Misil> misiles) {
		this.misiles = misiles;
	}

}
