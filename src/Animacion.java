import java.awt.image.BufferedImage;


public class Animacion {
	
	public static void moveUp(SpriteManager sm, BufferedImage imagen, int cont, int i){
		
		System.out.println("Runing"+i);
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
}
