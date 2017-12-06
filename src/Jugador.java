import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;

public class Jugador extends Entidad implements Runnable {

	private volatile boolean moveLeft;
	private volatile boolean moveRight;
	private volatile boolean moveUp;
	private volatile boolean moveDown;
	private boolean noMovement;
	private Animacion animacion;
	private ArrayList <Bala> balas;
	//private Iterator<Bala> it;
	private boolean addBala;
	Game game;
	//private Bala bala;// objecto bala

	public Jugador(int x, int y) {
		super();
		this.game=game;
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
		sm = new SpriteManager("/imagenes/soldierSpray.png");
		image = sm.subImage(1, 1, ancho, alto);
		barraVida = new BarraVida(this);
		//bala = new Bala(this);//
		animacion = new Animacion(this);
		balas = new ArrayList<Bala>();
		//it = balas.iterator();
		addBala = false;
		Thread t = new Thread(this);
		t.start();
		// imagen = ImageManager.cargarImagen("/imagenes/soldier.jpg");

	}

	public void render(Graphics g) {

		g.drawImage(image, x, y, null);
		barraVida.render(g);
		for(int i=0;i<balas.size();i++){
			Bala item= balas.get(i);
			item.render(g); 
			if(item.getX()<0 || item.getX()>500){
				balas.remove(item);
			}
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

		for(int i=0;i<balas.size();i++){
			Bala item= balas.get(i);
			item.update(); 
			if(item.getX()<0 || item.getX()>500){
				balas.remove(item);
			}
			
            for(int j=0;j<Game.getEnemigos().size();j++){
				EnemigoPrueba enemigo=game.getEnemigos().get(j); 
				if (item.getBounds().intersects(enemigo.getBounds())){  
					enemigo.getBarraVida().setAncho(enemigo.getBarraVida().getAncho() - 10);
					if(enemigo.getBarraVida().getAncho()<=0){
					   Game.getEnemigos().remove(enemigo); 
					}
					 balas.remove(item);
				}
				
			}
		}
		/*while(it.hasNext() && addBala == false){
			if(it.next().getEliminarBala()){
				balas.remove(it.next());
				System.out.println("Bala eliminada");
				System.out.println(balas.size());
			}
	    }
		it = balas.iterator();*/
	}

	public void run() {

		while (true) {

			while (moveUp) {
				animacion.playerUp();
			}

			while (moveDown) {
				animacion.playerDown();
			}

			while (moveRight) {
				animacion.playerRight();
			}

			while (moveLeft) {
				animacion.playerLeft();
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
		addBala = true;
		balas.add(new Bala(this));
		addBala = false;
		//it = balas.iterator();
	}

}
/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Jugador implements Runnable {

	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int HEIGHT = 53;//ancho de la Imagen del Jugador
	private int WIDTH = 78;//largo de la Imagen del Jugador
	private SpriteManager sm;
	private BufferedImage image;
	public BarraVida barraVida;
	private volatile boolean moveLeft;
	private volatile boolean moveRight;
	private volatile boolean moveUp;
	private volatile boolean moveDown;
	private boolean noMovement;
	private Animacion animacion;
	private Bala balas;// objecto bala
	//ArrayList<Bala> balas ;//array de objecto tipo bal
	private Game game;


	public Jugador(int x, int y) {

		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		moveLeft = false;
		moveRight = false;
		moveUp = false;
		moveDown = false;
		sm = new SpriteManager("/imagenes/soldierSpray.png");
		image = sm.subImage(1, 1, 79, 53);
		barraVida = new BarraVida(79, this);
		//balas = new ArrayList<Bala>();
		balas = new Bala(false, this);
		animacion = new Animacion(this);
		
		Thread t = new Thread(this);
		t.start();
	}

	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
		barraVida.render(g);
			if (balas.disparo== true) {
				balas.render(g);
			}
	}

	public void update() {

		if (moveUp ) {
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

		if(balas.disparo == true){
			 balas.update();
		}

	}


	public void run() {

		while (true) {

			while (moveUp ) {
				animacion.playerUp();
			}

			while (moveDown) {
				animacion.playerDown();
			}

			while (moveRight) {
				animacion.playerRight();
			}

			while (moveLeft) {
				animacion.playerLeft();
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public SpriteManager getSm() {
		return sm;
	}

	public void setSm(SpriteManager sm) {
		this.sm = sm;
	}

	/*metodo disparar  solo se  activara cuando es presionado el boton D(disparar), mandara un true para
	 * las condiciones en render,update , solo se pintara cuando este sea true la variable disparo.
	 * */
	
	//public void Disparar() {
	//	balas.disparo=true;
	//}

	//public Rectangle getBounds() {
	//	return new Rectangle(x, y, WIDTH, HEIGHT);
	//}
	
//}//FIN DE LA CLASE jUGADOR*/

