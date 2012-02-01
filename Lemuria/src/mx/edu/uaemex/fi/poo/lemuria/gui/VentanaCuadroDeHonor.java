package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;

public class VentanaCuadroDeHonor extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JTextField listaNombres[];
	Jugador jugador;
	public VentanaCuadroDeHonor(){
		this.setSize(500,500);
		this.setLayout(new GridLayout(10,1));
		List <Jugador> listaJugador = null;

		try{
			FileInputStream fis = null;
			ObjectInputStream in = null;
			String archivo = "records.txt";

			fis= new FileInputStream(archivo);
			in = new ObjectInputStream(fis);
			listaJugador = (List<Jugador>)in.readObject();
			int i;
			int limite = listaJugador.size();
			listaNombres = new JTextField[limite];
			for(i=0; i<limite; i++){
				jugador = listaJugador.get(i);
				listaNombres[i] = new JTextField(jugador.getNombre().getNombreDePila() + " "+ jugador.getNombre().getApellidoPaterno());
				this.add(listaNombres[i]);
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}

		catch(ClassNotFoundException ex){
			ex.printStackTrace();			
		}
		
	}
}
