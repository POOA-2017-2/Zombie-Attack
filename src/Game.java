import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
//import java.util.Iterator;

//import javax.swing.Timer;


public class Game implements Runnable {
	
	private Display ventana;
	private int ancho;
	private int alto;
	private String titulo;
	private boolean activo;
	//private Timer te;
	private Thread t;
	private BufferStrategy bs;
	private Graphics g;
	private Escenario escenario;
	private Jugador jugador;
	private ArrayList <EnemigoPrueba> enemigos;
	//private Iterator<EnemigoPrueba> it;
	//private EnemigoPrueba enemy;
	//private boolean update = true;

	
	public Game(int ancho, int alto, String titulo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
	}
	
	public void init(){
		
		//it = enemigos.iterator();
		escenario = new Escenario();
		jugador = new Jugador(0,160);
		enemigos = new ArrayList<EnemigoPrueba>();
		enemigos.add(new EnemigoPrueba(250, 160, jugador));
	//	enemigos.add(new EnemigoPrueba(300, 160, jugador));
	//	enemigos.add(new EnemigoPrueba(350, 160, jugador));
	//	te=new Timer(10000, new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
	//			enemigos.add(new EnemigoPrueba(300, 160, jugador));
	//		}
	//	});
		
	//	te.start();
	//	enemy = new EnemigoPrueba(400,100, jugador);
		ventana = new Display(ancho, alto, titulo, jugador);
		ventana.getCanvas().setFocusable(true);
	}

	public synchronized void start(){
		if(activo)
			return;
		
		activo = true;
		t = new Thread(this);
		t.start();
	}
	
	public synchronized void stop(){
		if(!activo)
			return;
		
		activo = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(){
		escenario.update();
		jugador.update();
	  //enemy.update();
	  //colision();
		for(int i=0; i<enemigos.size();i++){
			EnemigoPrueba e=enemigos.get(i);
			e.update();
			if(jugador.getBounds().intersects(e.getBounds())){
				enemigos.remove(i);
				jugador.getBarraVida().setAncho(jugador.getBarraVida().getAncho() - 10);
		    }
		}
		
		comprobarEnemigos();
		
		for(int i=0;i<jugador.getBalas().size();i++){
			Bala item=jugador.getBalas().get(i);
			item.update(); 
			if(jugador.isaddBala()){//if(item.getX()<0 || item.getX()>500){
				jugador.getBalas().remove(item);
			}
			
            for(int j=0;j<getEnemigos().size();j++){
				EnemigoPrueba enemigo=getEnemigos().get(j); 
				if (item.getBounds().intersects(enemigo.getBounds())){  
					enemigo.getBarraVida().setAncho(enemigo.getBarraVida().getAncho() - 10);
					if(enemigo.getBarraVida().getAncho()<=0){
					   getEnemigos().remove(enemigo); 
					}
					jugador.getBalas().remove(item);
				}
				
			}
		}
		//it = enemigos.iterator();
		//while(it.hasNext() && update)
			//it.next().update();	
	}
	
	public void colision(){
		/*it = enemigos.iterator();
		while(it.hasNext()){
			if(jugador.getBounds().intersects(it.next().getBounds()))
				//System.out.println("Hubo colision");
				enemigos.remove(it.next());
		}*/
		
	    //if(jugador.getBounds().intersects(enemy.getBounds())){
		//	enemy = null;
		//	System.out.println("Colision");
		//	jugador.getBarraVida().setAncho(jugador.getBarraVida().getAncho() - 10);
		//}
			
	}
	
	public void comprobarEnemigos(){
		/*System.out.println(enemigos.size());
		if(enemigos.size() < 3){
			enemigos.add(new EnemigoPrueba(400,100,jugador));
			System.out.println("Enemigo anadido");
		}*/
		
			if(enemigos.size() < 3){
				enemigos.add(new EnemigoPrueba(400,100,jugador));
				System.out.println("Enemigo anadido");
			}
			
		//}
		
		//if (enemy == null)
		//	enemy = new EnemigoPrueba(400,100,jugador);
	}
	
	public void render(){
		bs = ventana.getCanvas().getBufferStrategy();
		if(bs == null){
			ventana.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, ancho, alto);
		// PINTAR ELEMENTOS
		
		escenario.render(g);
		jugador.render(g);
		//enemy.render(g);
		for(int i=0; i<enemigos.size();i++){
			enemigos.get(i).render(g);
		}
		//it = enemigos.iterator();
		//while(it.hasNext() && update)
			//it.next().render(g);
		
		
		
		//FIN DEL PINTADO
		
		bs.show();
		//g.dispose();
	}
	
	

	public void run(){
		
		init();//INICIALIZAR JUEGO
		int fps = 60;
		double nanoPerFrame = 1000000000/fps;
		long nuevo;
		long pasado = System.nanoTime();
		double delta = 0;
		long time=0;
		int ticks=0;
		
		
		while(activo){
			
			nuevo = System.nanoTime();
			time+= nuevo - pasado;
			delta += (nuevo - pasado) / nanoPerFrame;
			pasado = nuevo;
			if(delta >= 1){
				update();//actualizacion de las variables
				render();//repintado
				delta--;
				ticks++;
			}
			
			if(time >= 1000000000){
				
				System.out.println("Frames por segundo " + ticks);
				ticks =0;
				time  = 0;
				
			}
		}
	}
	
	public ArrayList<EnemigoPrueba> getEnemigos() {
		return enemigos;
	}

}
/*import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;


public class Game implements Runnable {
	
	private Display ventana;
	public int ancho;
	public int alto;
	private String titulo;
	private boolean activo;
	private Thread t;
	private BufferStrategy bs;
	private Graphics g;
	private Escenario escenario;
	private Jugador jugador;
	private Enemigo enemigo;
	private EnemigoPrueba enemy;
	
	public Game(int ancho, int alto, String titulo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
	}
	
	public void init(){
		escenario = new Escenario();
		jugador = new Jugador(0,160);
		enemigo=new Enemigo(jugador);
		enemy = new EnemigoPrueba(400,100, jugador);
		ventana = new Display(ancho, alto, titulo, jugador);
		ventana.getCanvas().setFocusable(true);
	}

	public synchronized void start(){
		if(activo)
			return;
		
		activo = true;
		t = new Thread(this);
		t.start();
	}
	
	public synchronized void stop(){
		if(!activo)
			return;
		
		activo = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(){
		escenario.update();
		jugador.update();
		enemigo.update();
		enemy.update();
		
	}
	
	public void render(){
		bs = ventana.getCanvas().getBufferStrategy();
		if(bs == null){
			ventana.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, ancho, alto);
		// PINTAR ELEMENTOS
		
		escenario.render(g);
		jugador.render(g);
		enemigo.render(g);
		enemy.render(g);
		
		
		//FIN DEL PINTADO
		
		bs.show();
		//g.dispose();
	}
	
	

	public void run(){
		
		init();//INICIALIZAR JUEGO
		int fps = 60;
		double nanoPerFrame = 1000000000/fps;
		long nuevo;
		long pasado = System.nanoTime();
		double delta = 0;
		long time=0;
		int ticks=0;
		
		
		while(activo){
			
			nuevo = System.nanoTime();
			time+= nuevo - pasado;
			delta += (nuevo - pasado) / nanoPerFrame;
			pasado = nuevo;
			if(delta >= 1){
				update();//actualizacion de las variables
				render();//repintado
				delta--;
				ticks++;
			}
			
			if(time >= 1000000000){
				
				System.out.println("Frames por segundo " + ticks);
				ticks =0;
				time  = 0;	
			}
		}
	}

	public void gameOver() {
		//falta codigo
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
	
	
}*/
