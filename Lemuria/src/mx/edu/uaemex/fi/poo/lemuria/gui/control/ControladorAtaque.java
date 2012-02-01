package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import javax.swing.JOptionPane;

import mx.edu.uaemex.fi.poo.lemuria.modelo.Guerrero;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Troll;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.ItemNoEncontradoException;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.TuEstasMuertoException;

public class ControladorAtaque {
	private static Guerrero GUERRERO;
	private static Troll TROLL;
	public static long DANO;
	
	public void setTroll(Troll troll) {
		this.TROLL = troll;
	}

	public Guerrero getGUERRERO() {
		return GUERRERO;
	}

	public void setGuerrero(Guerrero GUERRERO) {
		this.GUERRERO = GUERRERO;
	}

	public static boolean Hacele() throws TuEstasMuertoException {
		int ataque = (int)(Math.random()*GUERRERO.ataca());
		if(GUERRERO.isDopado()){
			try{
			if(GUERRERO.getItemEnMano().getNombre().equals("esteroides")){
				GUERRERO.setDopado(false, 2);
			}
			}
			catch(Exception e){
				System.out.println("No tienes item en mano, usaste un código konami para doparte");
			}
		}
		
		if(ataque > TROLL.getNivelDePoder()){
			JOptionPane.showMessageDialog(null, "Ganaste el ataque!", "Ataque ganado", JOptionPane.INFORMATION_MESSAGE);
			GUERRERO.IncrementaStatusPoints(GUERRERO.AUMENTA_STATUS_POINTS);
			return true;
		}
		
		else{
			System.out.println("Bajó tu salud");
			GUERRERO.decrementaSalud(DANO);
			JOptionPane.showMessageDialog(null, "Perdiste el ataque, tu salud bajó en: " + DANO, "Ataque perdido", JOptionPane.INFORMATION_MESSAGE);

			try {
				GUERRERO.getArmeria().dropItem(GUERRERO.getItemEnMano());
			} catch (ItemNoEncontradoException e) {
				System.out.println("No tienes item en mano");
				return false;
			}
			GUERRERO.setItemEnMano(null);
			return false;
		}
	}
}