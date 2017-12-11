import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Misil implements Runnable {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int dx;
	private boolean eliminarMisil;
	private BufferedImage image;
	
	public Misil(Entidad entidad){
		x = entidad.getX();
		y = (int) (Math.random() * 500);
		ancho = 50;
		alto = 25;
		eliminarMisil = false;
		dx = 1;
		image = ImageManager.cargarImagen("/imagenes/missile.png");
		Thread t = new Thread(this);
		t.start();
	}
	
	public void render(Graphics g){
		if(eliminarMisil == false)
			g.drawImage(image, x, y, null);
	}
	
	public void update(){
		x -= dx;
		if(x < 0)
			eliminarMisil = true;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,ancho,alto);
	}

	public boolean isEliminarMisil() {
		return eliminarMisil;
	}

	public void setEliminarMisil(boolean eliminarMisil) {
		this.eliminarMisil = eliminarMisil;
	}

	@Override
	public void run() {
		while(true){
			update();
			try{
				Thread.sleep(10);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
