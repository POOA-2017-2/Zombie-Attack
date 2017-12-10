import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Marcador  {
	
	protected int c;//contador
	protected String mensaje;

	
	public Marcador(int c,String mensaje) {
		this.c=c;
		this.mensaje=mensaje;
	
	}
	//pinta
	public void render(Graphics g){
		g.setColor(Color.DARK_GRAY);//color de Letra
		g.setFont(new Font("Verdana",Font.BOLD,20));//Tipo de Letra
		g.drawString(mensaje+ c, 155,20);	//mensaje + puntuaje +posicion en la ventana
	}
	//actualiza las variables al momento de ejecutarse 
	public void update(){
		c++;
		System.out.println("Puntos: "+c);
	}
	
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
	
}//Fin de la clase Marcador
