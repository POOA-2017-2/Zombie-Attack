import java.awt.image.BufferedImage;


public class Animacion {
	
	private Jugador jugador;
	private SpriteManager sm;
	public BufferedImage imagen;
	private int cont;
	private int i;
	
	Animacion(Jugador jugador){
		this.jugador = jugador;
		sm = jugador.getSm();
		imagen = jugador.getImage();
		cont = 79;
		i = 0;
	}
	
	public void playerUp(){
		
		System.out.println("Runing");
		imagen = sm.subImage(0 + cont * i, 159, 79, 53);
		jugador.setImage(imagen);
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
	
    public void playerDown(){
    	
    	System.out.println("Runing");
		imagen = sm.subImage(0 + cont * i, 0, 79, 53);
		jugador.setImage(imagen);
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
    
    public void playerLeft(){
    	
    	System.out.println("Runing");
		imagen = sm.subImage(0 + cont * i, 53, 79, 53);
		jugador.setImage(imagen);
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
    
    public void playerRight(){
    	
    	System.out.println("Runing");
		imagen = sm.subImage(0 + cont * i, 106, 79, 53);
		jugador.setImage(imagen);
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
