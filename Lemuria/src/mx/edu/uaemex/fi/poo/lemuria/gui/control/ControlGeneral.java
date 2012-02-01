package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaRegistro;

// ESCA-JAVA0137:
/**
 * Control general de la Aplicaci&oacute;n.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class ControlGeneral {
	/**
	 * Ventana de registro.
	 */
	private VentanaRegistro registroVent;
	
	/**
	 * Establce la ventana de registro.
	 * @param regVent Ventana de registro.
	 */
	public void setRegistroVent(VentanaRegistro regVent) {
		this.registroVent = regVent;
	}
	/**
	 * Muestra la ventana de registro.
	 */
	public void muestraVentanaRegistro() {
		this.registroVent.setVisible(true);
	}

}
