import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Entidad {
	
	protected int x;
	protected int y;
	protected BufferedImage image;
	protected SpriteManager sm;
	protected BarraVida barraVida;
	
	public Entidad(){
		
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

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g){
		
	}
	
	

}
