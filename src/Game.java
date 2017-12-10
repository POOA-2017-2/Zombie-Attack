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
	private Thread t;
	private BufferStrategy bs;
	private Graphics g;
	private Escenario escenario;
	private Jugador jugador;
	private ArrayList <Enemigo> enemigos;
	private Marcador marcador;
	private boolean addBoss;
	private EnemigoBoss boss;


	
	public Game(int ancho, int alto, String titulo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
	}
	
	public void init(){
		escenario = new Escenario();
		marcador = new Marcador(0,"PUNTUAJE: ");
		jugador = new Jugador(0,160);
		addBoss = false;
		enemigos = new ArrayList<Enemigo>();
		enemigos.add(new EnemigoLvl1());
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
		if(marcador.getC() == 10 && addBoss == false){
			addBoss = true;
		}
		
		if(addBoss){
			boss = new EnemigoBoss(jugador);
			enemigos.add(boss);
			addBoss = false;
		}
		
		//Revisa la colision entre el jugador y el enemigo
		for(int i=0; i<enemigos.size();i++){
			Enemigo e=enemigos.get(i);
			e.update();
			if(jugador.getBounds().intersects(e.getBounds())){
				enemigos.remove(i);
				jugador.getBarraVida().setAncho(jugador.getBarraVida().getAncho() - 10);
		    }
		}
		
		if(enemigos.contains(boss)){
			for(int i = 0; i < boss.getMisiles().size(); i++){
				Misil item = boss.getMisiles().get(i);
				if(item.getBounds().intersects(jugador.getBounds())){
					item.setEliminarMisil(true);
					jugador.getBarraVida().setAncho(jugador.getBarraVida().getAncho() - 30);
				}
			}
		}
		
		//Revisa si el enemigo ha salido de la pantalla
		for(int i = 0; i < enemigos.size(); i++){
			Enemigo e = enemigos.get(i);
			if(e.getX() < 0)
				enemigos.remove(i);
		}
		
		//Comprueba si 
		comprobarEnemigos();
		
		for(int i=0;i<jugador.getBalas().size();i++){
			Bala item=jugador.getBalas().get(i);
			item.update(); 
			if(jugador.isaddBala()){//if(item.getX()<0 || item.getX()>500){
				jugador.getBalas().remove(item);
			}
			
            for(int j=0;j<getEnemigos().size();j++){
				Enemigo enemigo=getEnemigos().get(j); 
				if (item.getBounds().intersects(enemigo.getBounds())){  
					marcador.update();// puntuaje
					enemigo.getBarraVida().setAncho(enemigo.getBarraVida().getAncho() - (10-enemigo.getDefensa()));
					if(enemigo.getBarraVida().getAncho()<=0){
					   getEnemigos().remove(enemigo); 
					}
					jugador.getBalas().remove(item);
				}
				
			}
		}
	}
	
	public void comprobarEnemigos(){
		if(enemigos.size() < 3 && enemigos.contains(boss) == false){
				enemigos.add(new EnemigoLvl1());
				System.out.println("Enemigo lvl 1 anadido");
		}
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
		marcador.render(g);
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
	
	public ArrayList<Enemigo> getEnemigos() {
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
