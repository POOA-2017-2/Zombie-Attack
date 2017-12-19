package juego.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;

import juego.managers.Animacion;
import juego.managers.SpriteManager;


public class Jugador extends Entidad implements Runnable, Serializable {

	private volatile boolean moveLeft;
	private volatile boolean moveRight;
	private volatile boolean moveUp;
	private volatile boolean moveDown;
	private boolean noMovement;
	private BufferedImage image;
	protected SpriteManager sm;
	private Animacion animacion;
	private ArrayList <Bala> balas;
	private boolean addBala;


	public Jugador(int x, int y) {
		super();
		//this.game=game;
		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		ancho = 79;
		alto = 53;
		salud = ancho;
		moveLeft = false;
		moveRight = false;
		moveUp = false;
		moveDown = false;
		color = Color.blue;
		sm = new SpriteManager("/imagenes/soldierSpray.png");
		image = sm.subImage(1, 1, ancho, alto);
		barraVida = new BarraVida(this);//this
		animacion = new Animacion(this);
		balas = new ArrayList<Bala>();
		//it = balas.iterator();
		addBala = false;
		Thread t = new Thread(this);
		t.start();

	}

	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
		barraVida.render(g);
		for(int i=0;i<balas.size();i++){
			Bala item= balas.get(i);
			item.render(g); 
			//if(addBala){//if(item.getX()<0 || item.getX()>500){
				//balas.remove(item);
			//}
		}
		/*while(it.hasNext() && addBala == false){
			it.next().render(g);
        }*/

	}

	public void update() {

		if (moveUp) {
			y -= dy;
		}
		if (moveDown) {
			y += dy;
		}
		if (moveRight) {
			x += dx;
		}
		if (moveLeft) {
			x -= dx;
		}

		barraVida.update();
		
		for(int i = 0; i < balas.size(); i++){
			Bala item = balas.get(i);
			if(item.getEliminarBala())
				balas.remove(i);
		}
	}

	public void run() {

		while (true) {

			while (moveUp) {
				animacion.playerUp();
				System.out.println("Moving up");
			}

			while (moveDown) {
				animacion.playerDown();
				System.out.println("Moving down");
			}

			while (moveRight) {
				animacion.playerRight();
				System.out.println("Moving right");
			}

			while (moveLeft) {
				animacion.playerLeft();
				System.out.println("Moving left");
			}
			
		}
	}

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public boolean isMoveUp() {
		return moveUp;
	}

	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}
	
	public void addBala(){
		//addBala = true;
		balas.add(new Bala(getX(),getY()));
		//addBala = false;
		//it = balas.iterator();
	}
	
	public void setBalas(ArrayList<Bala> balas) {
		this.balas = balas;
	}

	public  ArrayList<Bala> getBalas() {
		return balas;
	}
	
	public boolean  isaddBala(){
		return addBala;
		//it = balas.iterator();
	}
	
	public SpriteManager getSm() {
		return sm;
	}

	public void setSm(SpriteManager sm) {
		this.sm = sm;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}


