package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.Validar;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Guerrero;

public class VentanaCodigosKonami extends JFrame implements ActionListener{
	private JTextField codigo, cantidad;
	private JButton aceptar, cancelar;
	private Guerrero guerrero;

	public void setGuerrero(Guerrero guerrero) {
		this.guerrero = guerrero;
	}

	public VentanaCodigosKonami(){
		this.setLayout(new GridLayout(2,2));
		codigo = new JTextField(10);
		codigo.setBorder(BorderFactory.createTitledBorder("Inserte su código: "));
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		aceptar.setActionCommand("aceptar");
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		cancelar.setActionCommand("cancelar");
		cantidad = new JTextField(5);
		cantidad.setEnabled(false);
		this.getContentPane().add(codigo);
		this.getContentPane().add(cantidad);
		this.getContentPane().add(aceptar);
		this.getContentPane().add(cancelar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("aceptar")){
			if(cantidad.isEnabled()){
				if(Validar.CampoValido(cantidad.getText(), "codigo") == true){
					if(codigo.getText().equals("salud")){
						this.guerrero.setNivelDeSalud(Integer.parseInt(cantidad.getText()));
					}
					else{
						this.guerrero.setNivelDePoder(Integer.parseInt(cantidad.getText()));
						JOptionPane.showMessageDialog(null, "El nivel de poder de tu personaje ahora es de: " + this.guerrero.getNivelDePoder(), "Cambio de Nivel de Poder", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			else{
				if(Validar.CampoVacio(this.codigo.getText(),"campo Código Konami")==true){
					if(this.codigo.getText().equals("JassPwnz")){
						this.guerrero.setNivelDeSalud(1000);
						this.guerrero.setDopado(true, 100);
					}
					else if(this.codigo.getText().equals("salud")){
						codigo.setEnabled(false);
						cantidad.setBorder(BorderFactory.createTitledBorder("Inserte los puntos de vida deseados: "));
						cantidad.setEnabled(true);
					}
					else if(this.codigo.getText().equals("poder")){
						codigo.setEnabled(false);
						cantidad.setBorder(BorderFactory.createTitledBorder("Inserte los puntos de ataque deseados: "));
						cantidad.setEnabled(true);
					}
				}
			}
		}
		else if(arg0.getActionCommand().equals("cancelar")){
			this.cantidad.setEnabled(false);
			this.codigo.setEnabled(true);
			this.cantidad.setText("");
			this.codigo.setText("");
			this.dispose();
		}
	}
}
