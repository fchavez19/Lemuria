package mx.edu.uaemex.fi.poo.lemuria.gui.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;

public class GuardarJugador {

	public static void Guardar(Jugador jugador){
		String filename = "salida.txt";
		List <Jugador> listaJugador = null;
		
		try{
			FileInputStream fis = null;
			ObjectInputStream in = null;
			String archivo = "salida.txt";

			fis= new FileInputStream(archivo);
			in = new ObjectInputStream(fis);
			
			listaJugador = (List<Jugador>)in.readObject();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}

		catch(ClassNotFoundException ex){
			ex.printStackTrace();			
		}
		
		if(listaJugador == null){
			listaJugador = new Vector<Jugador>();
		}
		
		try{
			FileOutputStream fos = null;
			ObjectOutputStream out = null;
			fos= new FileOutputStream(filename);
	
			out = new ObjectOutputStream(fos);

			listaJugador.add(jugador);
			out.writeObject(listaJugador);
			out.close();
			System.out.println("FIN sin problemas");
		}

		catch(IOException ex){
			System.out.println("Falló: " + ex.getClass());
			ex.printStackTrace();
		}
		
	}
	
}
