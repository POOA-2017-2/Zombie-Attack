package juego.game;

import juego.elementos.Display;

public class Game {
	
	private Display ventana; // VENTANA PRINCIPAL DE LA APLICACION OBJETO JFRAME.
	private int ancho; // ANCHO DE LA VENTANA PRINCIPAL
	private int alto; // ALTO DE LA VENTANA PRINCIPAL
	private String titulo; // TITULO DE LA VENTANA PRINCIPAL.
	
	// ESTADOS DEL JUEGO.
	Menu menu; // OBJETO QUE CONTROLA EL MENU DE LA APLICACION.
	Juego juego; // OBJETO QUE CONTROLA EL JUEGO DE LA APLICACION.
	JuegoCliente juegoC;
	

	public Game(int ancho, int alto, String titulo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
		init();
	}
	
	public Game(int ancho, int alto, String titulo, int cliente){
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
		init2();
	}
	
	//  INICIALIZAMOS LA APLICACION.
	public void init(){
		ventana=new Display(ancho, alto, titulo);  // DECLARA LA VENTANA DEL JUEGO OBJETO JFRAME.
		//Recursos.init(); // INICIALIZAMOS LOS RECURSOS DE LA APLICACION. CARGAMOS TODAS LAS IMAGENES, SONIDOS QUE UTILIZAREMOS.
		menu=new Menu(this,false); // DECLARA EL OBJETO QUE CONTROLA EL MENU. ESTADO MENU.
		juego=new Juego(this); // DECLARA EL OBJETO QUE CONTROLA EL JUEGO. ESTADO JUEGO.
		menu.show(); // MUESTRA EL MENU EN PANTALLA. DEFAULT SIEMPRE SE MUESTRA EL MENU PRIMERO.
	}
	
	public void init2(){
		ventana=new Display(ancho, alto, titulo);  // DECLARA LA VENTANA DEL JUEGO OBJETO JFRAME.
		//Recursos.init(); // INICIALIZAMOS LOS RECURSOS DE LA APLICACION. CARGAMOS TODAS LAS IMAGENES, SONIDOS QUE UTILIZAREMOS.
		menu=new Menu(this,true); // DECLARA EL OBJETO QUE CONTROLA EL MENU. ESTADO MENU.
		juegoC=new JuegoCliente(this); // DECLARA EL OBJETO QUE CONTROLA EL JUEGO. ESTADO JUEGO.
		menu.show(); // MUESTRA EL MENU EN PANTALLA. DEFAULT SIEMPRE SE MUESTRA EL MENU PRIMERO.
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
	
	public Display getVentana() {
		return ventana;
	}

	// RETORNA EL MENU DEL JUEGO, POR SI OCUPAMOS VOLVER AL MENU
	public Menu getMenu() {
		return menu;
	}

	// RETORNA EL OBJETO DEL JUEGO, PARA INICIAR NUEVO JUEGO.
	public Juego getJuego() {
		return juego;
	}
	
	public JuegoCliente getJuegoC(){
		return juegoC;
	}

}
