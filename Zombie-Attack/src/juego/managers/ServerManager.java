package juego.managers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import juego.elementos.Jugador;
import juego.elementos.Paquete;
import juego.game.Juego;

public class ServerManager implements Runnable{
	
	private Juego juego;
	
	public ServerManager(Juego juego){
		this.juego = juego;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run(){
		try {
			juego.setServer(new ServerSocket(8000));
			System.out.println("Esperando cliente");
			juego.setCliente(juego.getServer().accept());
			System.out.println("Cliente conectado");
			juego.setJugador2(new Jugador(10,200));
			juego.setInput(new ObjectInputStream(juego.getCliente().getInputStream()));
			juego.setOutput(new ObjectOutputStream(juego.getCliente().getOutputStream()));
			juego.setClienteActivo(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){
			
			try {
				Paquete p = (Paquete) juego.getInput().readObject();
				juego.getJugador2().setX(p.getX());
				juego.getJugador2().setY(p.getY());
				juego.getJugador2().getBarraVida().setAncho(p.getAncho());
				juego.getMarcador().setC(p.getPuntuacion());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
