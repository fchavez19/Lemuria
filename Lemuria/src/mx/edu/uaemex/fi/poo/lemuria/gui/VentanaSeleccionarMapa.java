package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorMapa;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Mapa;

public class VentanaSeleccionarMapa extends VentanaLemuria implements ActionListener{
	private JButton abrir, guardar;
	private final JFileChooser fc = new JFileChooser();
	private ObjectInputStream in = null;
	private FileInputStream fis = null;
	private File file;
	private String nombreArchivo;
	private Mapa mapa;
	private FileOutputStream fos = null;
	private ObjectOutputStream out = null;
	private ControladorMapa controladorMapa;

	public VentanaSeleccionarMapa(){
		abrir = new JButton("Cargar un mapa");
		abrir.addActionListener(this);
		abrir.setActionCommand("abrir");

		guardar = new JButton("Guardar un mapa");
		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");
		this.setLayout(new GridLayout(1,2));
		this.getContentPane().add(abrir);
		this.getContentPane().add(guardar);
		this.setResizable(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(this.getPlayerModel().isLogueado()){
			this.setVisible(true);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getActionCommand().equals("abrir")){
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				nombreArchivo = file.getName();

				try {
					fis = new FileInputStream(nombreArchivo);
					in = new ObjectInputStream(fis);

					mapa =(Mapa) in.readObject();
					mapa.addObserver(this.controladorMapa);
					mapa.CargarMapa();
					in.close();

				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "No se pudo cargar este mapa. Se usará el default", "Tipo de archivo incorrecto o dañado", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(arg0.getActionCommand().equals("guardar")){
			try{
				fc.showSaveDialog(null);
				fos= new FileOutputStream(fc.getSelectedFile().getName());
				out = new ObjectOutputStream(fos);
				out.writeObject(mapa);
				out.close();
				System.out.println("FIN sin problemas");
			}
			catch(IOException ex){
				System.out.println("Falló: " + ex.getClass());
				ex.printStackTrace();
			}
		}
		this.dispose();
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public void setControladorMapa(ControladorMapa controladorMapa) {
		this.controladorMapa = controladorMapa;
	}



}
