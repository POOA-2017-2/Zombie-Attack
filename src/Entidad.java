import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;



public class Entidad {
	
	protected int x;
	protected int y;
	protected int salud;
	protected int dx;
	protected int dy;
	protected int ancho;
	protected int alto;
	protected BufferedImage image;
	protected SpriteManager sm;
	protected BarraVida barraVida;
	
	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public SpriteManager getSm() {
		return sm;
	}

	public void setSm(SpriteManager sm) {
		this.sm = sm;
	}

	public BarraVida getBarraVida() {
		return barraVida;
	}

	public void setBarraVida(BarraVida barraVida) {
		this.barraVida = barraVida;
	}

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
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,ancho,alto);
	}
	
	

}
