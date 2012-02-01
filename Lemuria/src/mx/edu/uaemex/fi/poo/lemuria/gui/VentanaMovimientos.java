package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.Dimension;
import java.awt.Panel;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;

import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorMapa;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorMovimientos;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.TuEstasMuertoException;

public class VentanaMovimientos extends VentanaLemuria implements ActionListener{

    private JButton flechaIzq = new JButton();
    private JButton flechaArr = new JButton();
    private JButton flechaDer = new JButton();
    private JButton flechaAba = new JButton();
    private JRadioButton botonAtaca = new JRadioButton();
    private JRadioButton botonDefiende = new JRadioButton();
    private ButtonGroup grupoBotones = new ButtonGroup();
    private JButton Aceptar = new JButton();
	private Panel panelDirecciones, panelOpciones;
	private JPanel panelVentanaMovimientos;
	private ControladorMovimientos controladorMovimientos;
	private ControladorMapa controladorMapa;
    
	public VentanaMovimientos() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
    	ImageIcon icono = new ImageIcon();
    	
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(350, 170));
        this.setTitle( "Ventana de Movimientos" );
        
        flechaIzq.setIcon(new ImageIcon("FlechaIzq.png"));
        flechaIzq.setBounds(new Rectangle(25, 45, 65, 35));
        flechaIzq.addActionListener(this);
        flechaIzq.setActionCommand("izquierda");
		
		flechaArr.setIcon(new ImageIcon("FlechaArr.png"));
        flechaArr.setBounds(new Rectangle(130, 10, 65, 35));
		flechaArr.addActionListener(this);
		flechaArr.setActionCommand("arriba");
		
        flechaDer.setIcon(new ImageIcon("FlechaDer.png"));
        flechaDer.setBounds(new Rectangle(235, 45, 65, 35));
        flechaDer.addActionListener(this);
        flechaDer.setActionCommand("derecha");

        flechaAba.setIcon(new ImageIcon("FlechaAba.png"));
        flechaAba.setBounds(new Rectangle(130, 45, 65, 35));
		flechaAba.addActionListener(this);
		flechaAba.setActionCommand("abajo");
		
        botonAtaca.setText("Atacar");
        botonAtaca.setBounds(new Rectangle(15, 100, 80, 15));
		botonAtaca.addActionListener(this);
		botonAtaca.setActionCommand("atacar");

        botonDefiende.setText("Defender");
        botonDefiende.setBounds(new Rectangle(120, 100, 80, 15));
		botonDefiende.addActionListener(this);
		botonDefiende.setActionCommand("defender");

        grupoBotones.add(botonAtaca);
        grupoBotones.add(botonDefiende);

        Aceptar.setText("Aceptar");
        Aceptar.setBounds(new Rectangle(225, 97, 90, 20));
		this.Aceptar.addActionListener(this);

        this.getContentPane().add(Aceptar, null);
        this.getContentPane().add(botonDefiende, null);
        this.getContentPane().add(botonAtaca, null);
        this.getContentPane().add(flechaAba, null);
        this.getContentPane().add(flechaDer, null);
        this.getContentPane().add(flechaArr, null);
        this.getContentPane().add(flechaIzq, null);
    }

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == Aceptar){
			if(this.botonAtaca.isSelected()){
				try {
					this.controladorMapa.ataca(true);
				} catch (TuEstasMuertoException e1) {
					JOptionPane.showMessageDialog(null, "Estás muerto x.x", "Sin vida", JOptionPane.ERROR_MESSAGE);
					this.Aceptar.setEnabled(false);
				}
			}
			else if(this.botonDefiende.isSelected()){
				try {
					this.controladorMapa.ataca(false);
				} catch (TuEstasMuertoException e1) {
					JOptionPane.showMessageDialog(null, "Estás muerto x.x", "Sin vida", JOptionPane.ERROR_MESSAGE);
					this.Aceptar.setEnabled(false);
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
			this.flechaAba.setEnabled(false);
			this.flechaArr.setEnabled(false);
			this.flechaIzq.setEnabled(false);
			this.flechaDer.setEnabled(false);
			this.botonAtaca.setEnabled(true);
			this.botonDefiende.setEnabled(true);
		}
		else
		{
			this.flechaAba.setEnabled(true);
			this.flechaArr.setEnabled(true);
			this.flechaIzq.setEnabled(true);
			this.flechaDer.setEnabled(true);
			this.botonAtaca.setEnabled(false);
			this.botonDefiende.setEnabled(false);
		}
	}
	
	public void setControladorMapa(ControladorMapa controladorMapa) {
		this.controladorMapa = controladorMapa;
	}

	public void setControladorMovimientos(
			ControladorMovimientos controladorMovimientos) {
		this.controladorMovimientos = controladorMovimientos;
	}

}
