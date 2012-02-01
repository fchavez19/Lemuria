package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Ventana del juego.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class VentanaJuego extends VentanaLemuria {
	/**
	 * Ancho de la ventana.
	 */
	public static final int ANCHO = 576;
	/**
	 * Alto de la ventana.
	 */
	public static final int ALTO = 432;
	/**
	 * Default Serial version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel de fondo de la ventana.
	 */
	private JPanel panelSelva; 

	/**
	 * Constructora sin par&aacute;metros.
	 */
	public VentanaJuego(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(VentanaJuego.ANCHO,VentanaJuego.ALTO);			
		this.setMinimumSize(new Dimension(VentanaJuego.ANCHO,VentanaJuego.ALTO));
		this.setResizable(false);
		this.pack();
	}
	
	public JPanel getPanelSelva() {
		return panelSelva;
	}

	public void setPanelSelva(JPanel panelSelva) {
		this.panelSelva = panelSelva;
		this.setContentPane(panelSelva);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(this.getPlayerModel().isLogueado()){
			this.setVisible(true);
		}
	}
}