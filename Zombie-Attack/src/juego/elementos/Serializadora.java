package juego.elementos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serializadora {
	private ObjectInputStream lectorDeObjectos;
	private ObjectOutputStream escritorDeObjectos;

	//crear
	public void escribirObjecto(Object objecto) {
		try {
			escritorDeObjectos = new ObjectOutputStream(new FileOutputStream(
					"puntajeFinal.txt"));
			escritorDeObjectos.writeObject(objecto);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//leer
	public Object leerObjecto(String nombreDelArchivo){
		Object retorno = null;
		
		try {
			lectorDeObjectos = new ObjectInputStream(new 
					FileInputStream(nombreDelArchivo));
			
			retorno = lectorDeObjectos.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno;
	}
	

}//fin de la clase serializadora