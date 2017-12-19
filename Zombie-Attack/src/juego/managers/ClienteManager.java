package juego.managers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import juego.elementos.Jugador;
import juego.elementos.Paquete;
import juego.game.Juego;
import juego.game.JuegoCliente;

public class ClienteManager implements Runnable{
	
	private JuegoCliente juego;
	
	public ClienteManager(JuegoCliente juego){
		this.juego = juego;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run(){
		try {
			juego.setCliente(new Socket("127.0.0.1",8000));
			juego.setJugador2(new Jugador(10,200));
			juego.setOutput(new ObjectOutputStream(juego.getCliente().getOutputStream()));
			juego.setInput(new ObjectInputStream(juego.getCliente().getInputStream()));
			juego.setClienteActivo(true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		while(true){
			Paquete p;
			try {
				p = (Paquete) juego.getInput().readObject();
				juego.getJugador2().setX(p.getX());
				juego.getJugador2().setY(p.getY());
				juego.getJugador2().getBarraVida().setAncho(p.getAncho());
				juego.getMarcador().setC(p.getPuntuacion());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
