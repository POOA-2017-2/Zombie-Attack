import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Jugador implements Runnable{
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int ancho;
	private int alto;
	private BarraVida barraVida;
	private SpriteManager sm;
	private BufferedImage imagen;
	private volatile boolean moveLeft;
	private volatile boolean moveRight;
	private volatile boolean moveUp;
	private volatile boolean moveDown;
	private boolean noMovement;
	private int cont;
	private int i;
	
	public Jugador(int x, int y){
		
		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		moveLeft = false;
		moveRight = false;
		moveUp = false;
		moveDown = false;
		sm = new SpriteManager("/imagenes/soldierSpriteSheet.png");
		imagen = sm.subImage(1, 1, 79, 53);
		barraVida = new BarraVida(79,this);
		cont = 79;
		i = 0;
		Thread t = new Thread(this);
		t.start();
		//imagen = ImageManager.cargarImagen("/imagenes/soldier.jpg");
		
	}
	
	public void render(Graphics g){
		
		g.drawImage(imagen, x, y, null);
		barraVida.render(g);
		
	}
	
	public void update(){
		
		if(moveUp){
			y -= dy;
		}
		if(moveDown){
			y += dy;
		}
		if(moveRight){
			x += dx;
		}
		if(moveLeft){
			x -= dx;
		}
		
		barraVida.update();
		
	}
	
	public void run(){
		while(true){
		while(moveUp){
			//Animacion.moveUp(sm, imagen, cont, i);
			System.out.println("Runing");
			imagen = sm.subImage(0 + cont * i, 159, 79, 53);
			i++;
			if(i == 3)
				i = 0;
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		while(moveDown){
			
			System.out.println("Runing");
			imagen = sm.subImage(0 + cont * i, 0, 79, 53);
			i++;
			if(i == 3)
				i = 0;
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		while(moveRight){
			System.out.println("Runing");
			imagen = sm.subImage(0 + cont * i, 106, 79, 53);
			i++;
			if(i == 3)
				i = 0;
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		while(moveLeft){
			System.out.println("Runing");
			imagen = sm.subImage(0 + cont * i, 53, 79, 53);
			i++;
			if(i == 3)
				i = 0;
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	

}
