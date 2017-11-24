import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Jugador implements Runnable{
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private volatile boolean moveLeft;
	private volatile boolean moveRight;
	private volatile boolean moveUp;
	private volatile boolean moveDown;
	private boolean noMovement;
	private Animacion anima;

	public Jugador(int x, int y){
		
		this.x = x;
		this.y = y;
		dx = 1;
		dy = 1;
		moveLeft = false;
		moveRight = false;
		moveUp = false;
		moveDown = false;
		anima =new Animacion();
		Thread t = new Thread(this);
		t.start();
		//imagen = ImageManager.cargarImagen("/imagenes/soldier.jpg");
		
	}
	
	public void render(Graphics g){
		
		g.drawImage(anima.imagen, x, y, null);
		
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
		
	}
	
	public void run(){
		
		while(true){
			
		    while(moveUp){
		    	anima.playerUp();
		    }
		
		    while(moveDown){
		    	anima.playerDown();
		    }
		
		    while(moveRight){
		    	anima.playerRight();
		    }
		
		    while(moveLeft){
		    	anima.playerLeft();
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

}

