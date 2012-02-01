package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JOptionPane;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaInicial;

public class ControladorLogin {

	private VentanaInicial ventana;
	private Jugador jugador;

	public void Hacele(){
		if(Validar.CampoVacio(this.ventana.getLoginTxtFld().getText(),"campo Usuario")==true){
			try{
				FileInputStream fis = null;
				ObjectInputStream in = null;
				String filename = "salida.txt";

				fis= new FileInputStream(filename);
				in = new ObjectInputStream(fis);
				List<Jugador> listaJugador = (List<Jugador>)in.readObject();

				in.close();

				Jugador player;
				int i;
				for(i=0; i<listaJugador.size(); i++){
					player = listaJugador.get(i);
					if(this.ventana.getLoginTxtFld().getText().compareTo(player.getLogin())==0){
						if(this.ventana.getPasswdTxtFld().compareTo(player.getPassword())==0){
							this.jugador.setLogueado(true);
							i=listaJugador.size()+1;
						}
					}
				}

				if(i==listaJugador.size()){
					JOptionPane.showMessageDialog(null, "Usuario no encontrado: ", "Usuario o password incorrecto", JOptionPane.ERROR_MESSAGE);
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

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public VentanaInicial getVentana() {
		return ventana;
	}

	public void setVentana(VentanaInicial ventana) {
		this.ventana = ventana;
	}
	
	
	
}
