package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Nombre;
import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.NombreLatino;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.GuardarJugador;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.UsuarioData;

public class ControladorRegistro {
	static Jugador jugador;
	
	public static void Hacele(UsuarioData data){
		Nombre nombre;
		
		if(data.getApellidoMaterno().compareTo("")!=0){
			NombreLatino nombre2 = new NombreLatino();
			nombre2.setApellidoMaterno(data.getApellidoMaterno());
			nombre = nombre2;
		}
		
		else{
			nombre= new Nombre();
		}

		nombre.setNombreDePila(data.getNombreDePila());
		nombre.setApellidoPaterno(data.getApellidoPaterno());

		jugador.setNombre(nombre);
		jugador.setEdad(Integer.parseInt(data.getEdad()));
		jugador.setLogin(data.getLogin());
		jugador.setPassword(data.getPasswd());
		GuardarJugador.Guardar(jugador);
		jugador.setLogueado(true);
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
}
