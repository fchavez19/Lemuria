package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class VentanaLogueo extends JFrame {
	
	public VentanaLogueo(){
		ImageIcon fondo = new ImageIcon("Login.png");
		JLabel etiquetaFondo = new JLabel();
		etiquetaFondo.setIcon(fondo);
		etiquetaFondo.setSize(fondo.getIconWidth(), fondo.getIconHeight());
		
		JDesktopPane ventanaFondo = new JDesktopPane();
		
		Login login = new Login();
		login.pack();
		login.setVisible(true);
		login.setLocation(this.getX()+250,this.getY()+300);

		ventanaFondo.add(login, new Integer(0));
		ventanaFondo.add(etiquetaFondo, new Integer(0));
		this.getContentPane().add(ventanaFondo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}