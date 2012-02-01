package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// ESCA-JAVA0234:
/**
 * Panel para la ventana principal.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1 (puzzle adventure game)
 */

public class PanelEscenario extends JPanel implements Observer{
	/**
	 * Deafult serial version.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Imagen selvatica de fondo.
	 */
	//private BufferedImage  fondo,enemigo;
	private Image  fondo,enemigo;
	/**
	 * Imagen del guerrero.
	 */
	//BufferedImage guerrero;
	Image guerrero;
	/**
	 * Constructora sin par&aacute;metros. Construye el escenario.
	 * @param fondoImg Nombre de la imagen de fondo.
	 */
	public PanelEscenario(String fondoImg){
		//File input = new File(fondoImg);
		URL fondo_url = this.getClass().getResource("/resources/" + fondoImg);
		URL guerrero_url = this.getClass().getResource("/resources/lemurWarrior.png");
		Toolkit tk = this.getToolkit();
		//fondo = ImageIO.read(input);
		//guerrero = ImageIO.read(new File("resources/lemurWarrior.png"));	
		fondo = tk.getImage(fondo_url);
		guerrero = tk.getImage(guerrero_url);
	}
	
	@Override
	public void paint(Graphics g) {
		  g.drawImage(fondo, 0, 0, null);
		  g.drawImage(guerrero, 50,195 , null);
		  g.drawImage(enemigo, 300, 100, null);
	}

	@Override
	public void update(Observable arg0, Object arg1) {		
	}

	public Image getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(BufferedImage enemigo) {
		this.enemigo = enemigo;
	}

	public Image getFondo() {
		return fondo;
	}

	public void setFondo(BufferedImage fondo) {
		this.fondo = fondo;
	}	
	
	
}
