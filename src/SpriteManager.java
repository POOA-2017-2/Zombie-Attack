import java.awt.image.BufferedImage;


public class SpriteManager {
	
	private BufferedImage sprite;
	
	public SpriteManager(String path){
		sprite = ImageManager.cargarImagen(path);
	}
	
	public BufferedImage subImage(int x, int y, int w, int h){
		return sprite.getSubimage(x, y, w, h);
	}

}
