package juego.managers;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageManager {
	
	public static BufferedImage cargarImagen(String path){
		try {
			return ImageIO.read(ImageManager.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;	
	}

}
