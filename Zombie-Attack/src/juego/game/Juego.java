package juego.game;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.Timer;

import juego.elementos.Bala;
import juego.elementos.Enemigo;
import juego.elementos.EnemigoBoss;
import juego.elementos.EnemigoLvl1;
import juego.elementos.EnemigoLvl2;
import juego.elementos.Escenario;
import juego.elementos.Jugador;
import juego.elementos.Marcador;
import juego.elementos.Misil;
import juego.elementos.Paquete;
import juego.managers.ServerManager;
import juego.paneles.GamePanel;


public class Juego implements Runnable{
	
	private boolean activo; // VARIABLE PARA VER SI EL JUEGO ESTA ACTIVO.
	private Thread gameLoop; // HILO PARA CONTROLAR EL CICLO DEL JUEGO.
	private Graphics g; // OBJETO PARA CONTROLAR EL DIBUJADO DE LA PANTALLA.

	private GamePanel pnlJuego; // PANEL QUE CONTIENE LA INTERFAZ GRAFICA DEL JUEGO.
	private Escenario escenario; // ESCENARIO DEL JUEGO
	private Jugador jugador; // OBJETO QUE CONTROLA EL JUGADOR
	private Jugador jugador2;
	private Marcador marcador;
	private EnemigoBoss boss;
	private boolean addBoss;
	private ArrayList<Enemigo> enemigos; // TODOS LOS ENEMIGOS DEL JUEGO.
	private Game juego; // OBJETO QUE CONTINE LA VENTANA PRINCIPAL DE LA APLICACION.
	private BufferStrategy bs; // OBJETO PARA CONTROLAR LOS FRAMES QUE VEMOS EN PANTALLA.
	private int puntuacion;//
	
	private ServerSocket server;
	private Socket cliente;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Boolean clienteActivo;
	private Boolean multiplayer;
	private ServerManager sm;
	
	public Juego(Game juego) {
		this.juego=juego;
		init();
		pnlJuego=new GamePanel(jugador); //  INICIALIZAMOS LA INTERFAZ DEL JUEGO
		juego.getVentana().getPnlVista().add(pnlJuego,"Juego"); //// AGREGAMOS EL PANEL DEL JUEGO AL CARDLAYOUT DE LA VENTANA PRINCIPAL.
	}

	// METODO PARA INICIALIZAR EL JUEGO.
	public void init() {
			
		escenario=new Escenario(); // INICIALIZAMOS EL ESCENARIO DEL JUEGO.
		jugador=new Jugador(10,160); // INICIALIZAMOS EL JUGADOR DEL JUEGO.
		enemigos=new ArrayList<Enemigo>(); // INICIALIZAMOS LA LISTA DE ENEMIGOS.
		marcador = new Marcador(0," Puntuacion: ");
		clienteActivo = false;
		addBoss = false;
		
		// AGREGAMOS 3 ENEMIGOS COMO PRUEBA.
		
		// INICIALIZAMOS EL TIMER QUE CONTROLA LA APARICION DE ENEMIGOS. 
		// PRIMER PARAMETRO DEL CONSTRUCTOR ES EL TIEMPO EN MILISEGUNDOS QUE EL TIMER TARDA EN EJECUTARSE.
		// SEGUNDO PARAMETRO DEL CONSTRUCTOR ES LA ACCION QUE REALIZARA EL TIMER
		
		//Recursos.audioMenu.stop();// PARAMOS EL SONIDO DEL MENU
		//Recursos.audioJuego.loop(); // INICAMOS EL SONIDO DEL JUEGO.
		
	}
	
	
	// METODO PARA DIBUJAR LOS COMPONENTES DEL JUEGO.
	public void render(Graphics g) {
		
		bs=pnlJuego.getCanvas().getBufferStrategy(); // INICIALIZAMOS EL BUFFER QUE CONTIENE LOS FRAMES DEL JUEGO.
		
		if(bs==null){ // SI ES NULO
		
			pnlJuego.getCanvas().createBufferStrategy(3); // CREAMOS UN NUEVO BUFFER CON 3 FRAMES.
			return;
		}
		
		g=bs.getDrawGraphics(); // INICIALIZAMOS EL OBJETO GRAPHICS PARA PODER DIBUJAR.
		g.clearRect(0, 0,juego.getAncho(), juego.getAlto()); // LIMPIAMOS LA PANTALLA DEL JUEGO.
		// PINTAR ELEMENTOS
		escenario.render(g); // PINTAMOS EL ESCENARIO.
		jugador.render(g); // PINTAMOS AL JUGADOR.
		if(jugador2 != null)
			jugador2.render(g);
		
		// RECORREMOS LA LISTA DE ENEMIGOS.
		for(int i=0; i<enemigos.size();i++){
			enemigos.get(i).render(g); // DIBUJAMOS ENEMIGO POR ENEMIGO
		}
		marcador.render(g);
		// FIN DEL PINTADO
		bs.show(); // MOSTRAMOS EL FRAME DIBUJADO.
		g.dispose(); // LIBERAMOS AL OBJETO GRAPHICS. LIBERACION DE MEMORIA.
		
	}

	
	// METODO PARA ACTUALIZAR TODAS LAS VARIABLES DEL JUEGO. LOGICA DEL JUEGO.
	public void update() {
		escenario.update();
		jugador.update();
		if(jugador2 != null)
			jugador2.update();

		if(marcador.getC() == 10 && addBoss == false){
			addBoss = true;
			System.out.println("Boss true");
			marcador.setC(11);
		}
		
		if(addBoss){
			boss = new EnemigoBoss(jugador);
			enemigos.add(boss);
			addBoss = false;
			System.out.println("boss added");
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
		
		// comprobacion del estado del jugador, si es cero , Game over y  se guarda su puntuacion. 
		if (jugador.getBarraVida().getAncho()<=0){
			System.out.print("Game Over > Servidor ");
			puntuacion=marcador.c;
			System.out.println("Puntuacion: "+puntuacion);
		}		
		
		if(clienteActivo){
			Paquete p = new Paquete(jugador, marcador);
			try {
				output.writeObject(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
	}
	
	public void comprobarEnemigos(){
		if(enemigos.size() < 3 && enemigos.contains(boss) == false){
				int enemyType = (int) (Math.random() * 10); //enemyType es un numero aleatorio del 0 al 10
				if(enemyType < 9) 							//Si enemyType es un numero entre 1 y 8 se añade un enemigoLvl1 
					enemigos.add(new EnemigoLvl1());
				if(enemyType > 8)							//Si enemyType es 9 o 10 se añade un enemigoLvl2 que persigue
					enemigos.add(new EnemigoLvl2(jugador));
		}
	}

	
	// METODO PARA MOSTRAR EL PANEL DEL JUEGO.
	public void show(boolean state) {
		CardLayout c=(CardLayout)juego.getVentana().getPnlVista().getLayout(); // OBTENEMOS EL LAYOUT DE LA VENTANA.
		c.show(juego.getVentana().getPnlVista(), "Juego"); // MOSTRAMOS EN PANTALLA EL PANEL QUE CONTIENE LA INTERFAZ DEL JUEGO.
		juego.getVentana().setVisible(true); // HACEMOS VISIBLE LA VENTANA.
		start(state);// LLAMAMOS AL METODO START, PARA EJECUTAR EL CICLO DEL JUEGO.
	}

	public GamePanel getPnlJuego() {
		return pnlJuego;
	}
	
	public Escenario getEscenario() {
		return escenario;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Game getJuego() {
		return juego;
	}

	public ArrayList<Enemigo> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(ArrayList<Enemigo> listaEnemigos) {
		this.enemigos = listaEnemigos;
	}

	
	// INICIAMOS EL CICLO DEL JUEGO
	public synchronized void start(boolean state){
		if(activo)
			return;
		if(state)
			multiplayer = true;
		else
			multiplayer = false;
		activo=true;
		if(multiplayer)
			sm = new ServerManager(this);
		
		gameLoop=new Thread(this); // INICIALIZAMOS HILO.
		gameLoop.start();// EJECUTAMOS HILO, MANDA LLAMAR AL METODO RUN.
	}
	
	// PARA EL CICLO DEL JUEGO.
	public  synchronized void stop(){
		if(!activo)
			return;
		activo=false;
		try {
			gameLoop.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public Marcador getMarcador() {
		return marcador;
	}

	public void setMarcador(Marcador marcador) {
		this.marcador = marcador;
	}

	public Boolean getClienteActivo() {
		return clienteActivo;
	}

	public void setClienteActivo(Boolean clienteActivo) {
		this.clienteActivo = clienteActivo;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public Socket getCliente() {
		return cliente;
	}

	public void setCliente(Socket cliente) {
		this.cliente = cliente;
	}

	public ObjectOutputStream getOutput() {
		return output;
	}

	public void setOutput(ObjectOutputStream output) {
		this.output = output;
	}

	public ObjectInputStream getInput() {
		return input;
	}

	public void setInput(ObjectInputStream input) {
		this.input = input;
	}

	// ACCION DEL HILO.
	public void run() {
		// TODO Auto-generated method stub
		//init();//<--- INICIALIZAR JUEGO
		int fps=60;
		double nanoPorFrame=1000000000/fps;
		long nuevo;
		long pasado=System.nanoTime();
		double delta=0;
		// variables auxiliares o de testeo
		long time=0;
		int ticks=0;
		
		while(activo){
			
			nuevo=System.nanoTime();
			time+=nuevo-pasado; //<--- testeo  
			delta+=(nuevo-pasado)/nanoPorFrame;
			pasado=nuevo;
			
			if(delta>=1){
				update();//ACTUALIZACION DE VARIABLES Y LOGICA.
				render(g);//REPINTADO.
				delta--;
				ticks++;
			}
			
			// testeo
			if(time>=1000000000){
				System.out.println("Frames por segundo: "+ticks);
				ticks=0;
				time=0;
			}

		}
		
	}

}
