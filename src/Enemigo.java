import java.awt.Graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Enemigo extends JPanel implements Runnable {

	int x = 480;
	int y = 240;
	int x1 = 480;
	int y1 = 240;
	Thread hilo;
	private int dx=0;
	//private int dy=0;
	private int vel=1;
	private int moverX;
	private int moverY;
	private int diffX;
	private int diffY;
	
	public Enemigo() {
		hilo = new Thread(this);
		hilo.start();
	}

	public void render(Graphics g) {
		//g.fillRect(0, 0, getWidth(), getHeight());
		Image imagen = new ImageIcon(Enemigo.class.getResource("/imagenes/enemigo12.png")).getImage();
		g.drawImage(imagen, x,210,this);
		
		Image imagen2 = new ImageIcon(Enemigo.class.getResource("/imagenes/enemigo12.png")).getImage();
		g.drawImage(imagen2, x1, y1,this );//210); //,this);

	}

	public void run() {
	
		try {
			while (true) {
				/*
				 * MOVIMIENTO DE ENEMIGO X es una constante fija: Es el valor
				 * del tamano dela ventana, las condiciones siguientes, se
				 * ejecutaran hasta que el valor de x cambie consecutivamente y
				 * cumpla la condicion; Es decir al llegar al marco contrario
				 * cambiara de direccion (izquierda derecha).
				 * 
				 */
				while (x > 10) {
					Thread.sleep(250);
					x -= 10;
					repaint();
					// System.out.print("izq" + x);
				}
				while (x < 480) {
					Thread.sleep(250);
					x += 10;
					repaint();
					// System.out.print("derecha\n" + x);
				}

			}
		} catch (Exception e) {
			System.out.println("Sucedio un error" + e.getMessage());
		}

	}

	public void update() {
		
		moverX = Game.jugador.getX(); // Guarda la posicion en X del jugador
		moverY = Game.jugador.getY(); // Guarda la posicion en Y del jugador
		
		diffX = moverX - x1; //Calcula la distancia entre la posicion X del enemigo respecto a la del jugador
		diffY = moverY - y1; //Calcula la distancia entre la posicion Y del enemigo respecto a la del jugador
		
		float angulo = (float)Math.atan2(diffY, diffX); //Calcula el angulo opuesto que exite entre los dos puntos 
       
		if(angulo<=0){
		  
			x1 += vel * Math.cos(angulo); //obtiene la posicion en x del jugador pero negada y la aumenta en uno hasta que llegue a 0
			y1 += vel * Math.sin(angulo); //obtiene la posicion en y del jugador pero negada y la aumenta en uno hasta que llegue a 0
			                              //todo esto se hace con el proposito obtener un angulo de 180 entre los dos vectores que forman
			                              //el jugador y el enemigo de esta manera se intersectarian en "y" y posteriormente el angulo se
			                              //reduciria a 0 lo que ocacionaria que se intersectaran nuevamente pero ahora en "x"
        }
		
		else if (angulo>=0){
			 x1-= -vel * Math.cos(angulo); //"x" solo puede ir hacia la izquierda esto es debido a que depende de una "y" positiva lo cual 
			                               //trigonometricamente ocaciona que su valor siempre sea positivo es por eso que negamos el resultado  
			 y1=Game.jugador.getY()-vel;   //Si el enemigo esta en la misma posicion que el jugador en "y" pero no en "X" copia sus movimientos  
		 }
		//System.out.println(angulo);
		x+=dx ;
		//System.out.println("valor"+dx+x);
		
	}

}// FIN DE LA CLASE ENEMIGO