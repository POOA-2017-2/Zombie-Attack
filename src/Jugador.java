import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Jugador extends Entidad implements Runnable{
	
	private int dx;
	private int dy;
	private volatile boolean moveLeft;
	private volatile boolean moveRight;
	private volatile boolean moveUp;
	private volatile boolean moveDown;
	private boolean noMovement;
	private Animacion animacion;

	public Jugador(int x, int y){
		
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
		this.barraVida = new BarraVida(79,this);
		animacion =new Animacion(this);
		Thread t = new Thread(this);
		t.start();
		//imagen = ImageManager.cargarImagen("/imagenes/soldier.jpg");
		
	}
	
	public void render(Graphics g){
		
		g.drawImage(image, x, y, null);
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
		    	animacion.playerUp();
		    }
		
		    while(moveDown){
		    	animacion.playerDown();
		    }
		
		    while(moveRight){
		    	animacion.playerRight();
		    }
		
		    while(moveLeft){
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
	
	

}

