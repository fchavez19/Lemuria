package mx.edu.uaemex.fi.poo.lemuria.gui;


import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Observable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorMapa;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorMovimientos;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.TuEstasMuertoException;

public class VentanaMovimientosOriginal extends VentanaLemuria implements ActionListener{
	private JButton botonArriba;
	private JButton botonAbajo;
	private JButton botonIzquierda;
	private JButton botonDerecha;
	private JRadioButton botonAtacar;
	private JRadioButton botonDefender;
	private JButton botonOk;
	private Panel panelDirecciones, panelOpciones;
	private JPanel panelVentanaMovimientos;
	private ButtonGroup grupodebotones;
	private ControladorMovimientos controladorMovimientos;
	private ControladorMapa controladorMapa;

	public void setControladorMapa(ControladorMapa controladorMapa) {
		this.controladorMapa = controladorMapa;
	}

	public void setControladorMovimientos(
			ControladorMovimientos controladorMovimientos) {
		this.controladorMovimientos = controladorMovimientos;
	}

	public VentanaMovimientosOriginal(){ 

		this.botonArriba = new JButton("Arriba");
		this.botonArriba.addActionListener(this);
		this.botonArriba.setActionCommand("arriba");

		this.botonAbajo = new JButton("Abajo");
		this.botonAbajo.addActionListener(this);
		this.botonAbajo.setActionCommand("abajo");

		this.botonIzquierda = new JButton("Izquierda");
		this.botonIzquierda.addActionListener(this);
		this.botonIzquierda.setActionCommand("izquierda");

		this.botonDerecha = new JButton("Derecha");
		this.botonDerecha.addActionListener(this);
		this.botonDerecha.setActionCommand("derecha");

		this.botonAtacar = new JRadioButton("Atacar");
		this.botonAtacar.addActionListener(this);
		this.botonAtacar.setActionCommand("atacar");

		this.botonDefender = new JRadioButton("Defender");
		this.botonDefender.addActionListener(this);
		this.botonDefender.setActionCommand("defender");

		this.botonOk = new JButton("OK");
		this.botonOk.addActionListener(this);
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setResizable(false);
		this.pack();


		grupodebotones = new ButtonGroup(); 

		panelDirecciones = new Panel();
		panelOpciones = new Panel();

		panelVentanaMovimientos = (JPanel) this.getContentPane();

		panelDirecciones.add(botonArriba,BorderLayout.NORTH);
		panelDirecciones.add(botonAbajo,BorderLayout.SOUTH);
		panelDirecciones.add(botonIzquierda,BorderLayout.WEST);
		panelDirecciones.add(botonDerecha,BorderLayout.EAST);

		panelOpciones.add(botonAtacar,BorderLayout.EAST);
		panelOpciones.add(botonDefender,BorderLayout.CENTER);
		panelOpciones.add(botonOk,BorderLayout.WEST);

		panelVentanaMovimientos.add(panelDirecciones,BorderLayout.NORTH);
		panelVentanaMovimientos.add(panelOpciones,BorderLayout.SOUTH);

		grupodebotones.add(botonAtacar);
		grupodebotones.add(botonDefender);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == botonOk){
			if(this.botonAtacar.isSelected()){
				try {
					this.controladorMapa.ataca(true);
				} catch (TuEstasMuertoException e1) {
					JOptionPane.showMessageDialog(null, "Estás muerto x.x", "Sin vida", JOptionPane.ERROR_MESSAGE);
					this.botonOk.setEnabled(false);
				}
			}
			else if(this.botonDefender.isSelected()){
				try {
					this.controladorMapa.ataca(false);
				} catch (TuEstasMuertoException e1) {
					JOptionPane.showMessageDialog(null, "Estás muerto x.x", "Sin vida", JOptionPane.ERROR_MESSAGE);
					this.botonOk.setEnabled(false);
				}
			}
		}
		else{
			this.controladorMapa.Muevete(e.getActionCommand());
		}
	}

	public void update(Observable o, Object arg) {
		if(this.getPlayerModel().isLogueado()){
			this.validate();
			this.setVisible(true);
		}
	}

	public void SetMovimiento(boolean valido){
		if(valido == false){
			this.botonAbajo.setEnabled(false);
			this.botonArriba.setEnabled(false);
			this.botonIzquierda.setEnabled(false);
			this.botonDerecha.setEnabled(false);
			this.botonAtacar.setEnabled(true);
			this.botonDefender.setEnabled(true);
		}
		else
		{
			this.botonAbajo.setEnabled(true);
			this.botonArriba.setEnabled(true);
			this.botonIzquierda.setEnabled(true);
			this.botonDerecha.setEnabled(true);
			this.botonAtacar.setEnabled(false);
			this.botonDefender.setEnabled(false);
		}
	}
}
