package mx.edu.uaemex.fi.poo.lemuria.modelo;

import javax.swing.JOptionPane;

// ESCA-JAVA0137:
/**
 * El que tiene toda la acci&oacute;n en el juego.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */

public class Guerrero extends PersonajeDeAccion {
	/**
	 * Rango del guerrero. Provisionalmente un feo entero.
	 */
	public static int AUMENTA_STATUS_POINTS =1;
	
	private int rango;
	private boolean dopado;
	private int statusPoints=0;
	private boolean usoStats=false;
	private int vitalidad=0;
	
	/**
	 * Consulta el rango del guerrero.
	 * @return Rango del guerrero.
	 */
	public int getRango() {
		return rango;
	}
	/**
	 * Establece el rango del guerrero.
	 * @param rango Rango del guerrero.
	 */
	
	public Guerrero(){
	}
	
	public void setRango(final int rango) {
		this.rango = rango;
	}
	
	public boolean isDopado() {
		return dopado;
	}
	
	public void setDopado(boolean dopado, long multiplicador) {
		if(dopado == true){
			this.setNivelDePoder(this.getNivelDePoder()*multiplicador);
			JOptionPane.showMessageDialog(null, "Tu nuevo nivel de poder es: " + this.getNivelDePoder(), "Nivel de poder (usando esteroides)", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			this.setNivelDePoder(this.getNivelDePoder()/multiplicador);
			JOptionPane.showMessageDialog(null, "Tu nivel de poder regresó a: " + this.getNivelDePoder(), "Nivel de poder (termina efecto de esteroides)", JOptionPane.INFORMATION_MESSAGE);
		}
		this.dopado = dopado;
	}
	
	public void setItemEnMano(Item itemEnMano) {
		this.itemEnMano = itemEnMano;
		this.setChanged();
		this.notifyObservers();
}

	public int getStatusPoints() {
		return statusPoints;
	}
	
	public void IncrementaStatusPoints(int statusPoints) {
		this.statusPoints += statusPoints;
		this.usoStats=false;
		this.setChanged();
		this.notifyObservers();
	}
	
	public void DecrementaStatusPoints(int statusPoints) {
		this.statusPoints --;
		this.usoStats=true;
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getVitalidad() {
		return vitalidad;
	}
	public void setVitalidad(int vitalidad) {
		this.vitalidad = vitalidad;
	}
	
	public void IncrementaVitalidad(int statusPoints) {
		this.vitalidad++;	
	}
}
