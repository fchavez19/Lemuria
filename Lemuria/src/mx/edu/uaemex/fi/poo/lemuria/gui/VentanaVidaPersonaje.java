package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorVentanaVidaPersonaje;

public class VentanaVidaPersonaje extends VentanaLemuria implements ActionListener{

	private static final long serialVersionUID = 5968513980022179188L;
	
	private JProgressBar barraVida = new JProgressBar();
    private JTextField campoVida = new JTextField();
    private JTextField campoPoder = new JTextField();
    private JTextField campoVitalidad = new JTextField();
    private JTextField campoStatusPoints = new JTextField();

    private JSeparator jSeparator1 = new JSeparator();
	private ControladorVentanaVidaPersonaje controladorVentanaVidaPersonaje;
	private JLabel etqPoder = new JLabel();
	private JLabel etqVitalidad = new JLabel();
	private JLabel etqStatusPoints = new JLabel();

	private JButton botonAtaque = new JButton();
	private JButton botonVitalidad = new JButton();

    public VentanaVidaPersonaje() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(180, 170));
        this.setTitle( "Estátus del Personaje" );
        
        campoVida.setBounds(new Rectangle(20, 5, 145, 39));
        barraVida.setBounds(new Rectangle(20, 45, 145, 14));
        jSeparator1.setBounds(new Rectangle(20, 65, 145, 10));
        etqPoder.setBounds(new Rectangle(20, 70, 40, 20));
        etqVitalidad.setBounds(new Rectangle(20, 95, 60, 20));
        campoPoder.setBounds(new Rectangle(65, 70, 40, 20));
        campoVitalidad.setBounds(new Rectangle(75, 95, 30, 20));
        etqStatusPoints.setBounds(new Rectangle(20, 120, 85, 20));
        campoStatusPoints.setBounds(new Rectangle(110, 120, 20, 20));

        botonAtaque.setBounds(new Rectangle(110, 70,20, 20));
        botonAtaque.setIcon(new ImageIcon("FlechaStats.png"));
        botonAtaque.addActionListener(this);
        botonAtaque.setActionCommand("ataque");
        botonAtaque.setEnabled(false);

        botonVitalidad.setBounds(new Rectangle(110, 95,20, 20));
        botonVitalidad.setIcon(new ImageIcon("FlechaStats.png"));
        botonVitalidad.addActionListener(this);
        botonVitalidad.setActionCommand("vitalidad");
        botonVitalidad.setEnabled(false);
        
        etqPoder.setText("Poder: ");
        etqVitalidad.setText("Vitalidad: ");
        etqStatusPoints.setText("Status Points: ");
        campoStatusPoints.setText("0");
        campoVitalidad.setText("0");
        
        barraVida.setForeground(Color.GREEN);
        barraVida.setBackground(Color.LIGHT_GRAY);
        barraVida.setValue(100);
		barraVida.setStringPainted(true);
		
		campoVida.setBorder(BorderFactory.createTitledBorder("Vida del personaje: "));
		campoVida.setEditable(false);        
		
		campoPoder.setBorder(BorderFactory.createLineBorder(new Color(148, 181, 255)));
		campoVitalidad.setBorder(BorderFactory.createLineBorder(new Color(148, 181, 255)));
		
		this.campoPoder.setEditable(false);
		campoVitalidad.setEditable(false);
		campoStatusPoints.setEditable(false);
		
        this.getContentPane().add(jSeparator1, null);
        this.getContentPane().add(campoVida, null);
        this.getContentPane().add(campoPoder, null);
        this.getContentPane().add(campoVitalidad, null);
        this.getContentPane().add(campoStatusPoints, null);
        this.getContentPane().add(barraVida, null);
        this.getContentPane().add(etqPoder, null);
        this.getContentPane().add(etqVitalidad, null);
        this.getContentPane().add(etqStatusPoints, null);
        this.getContentPane().add(botonAtaque, null);
        this.getContentPane().add(botonVitalidad, null);

		this.setResizable(false);
    }

	public ControladorVentanaVidaPersonaje getControladorVentanaVidaPersonaje() {
		return controladorVentanaVidaPersonaje;
	}

	public void setControladorVentanaVidaPersonaje(
			ControladorVentanaVidaPersonaje controladorVentanaVidaPersonaje) {
		this.controladorVentanaVidaPersonaje = controladorVentanaVidaPersonaje;
	}

	public JTextField getCampoVida() {
		return campoVida;
	}

	public void setCampoVida(String string) {
		this.campoVida.setText(string);
	}

	public void update(Observable arg0, Object arg1) {
		if(this.getPlayerModel().isLogueado()){
			this.setVisible(true);
		}
	}

	public void setCampoPoder(String campoPoder) {
		this.campoPoder.setText(campoPoder);
	}

	public JProgressBar getBarraVida() {
		return barraVida;
	}

	public void setBarraVida(JProgressBar barraVida) {
		this.barraVida = barraVida;
	}
	
	public void HabilitaStats(boolean habilita){
		this.botonAtaque.setEnabled(habilita);
		this.botonVitalidad.setEnabled(habilita);
	}
	
	public void setVitalidad(String vitalidad) {
		this.campoVitalidad.setText(vitalidad);
	}
	
	public void setStatusPoints(String statusPoints) {
		this.campoStatusPoints.setText(statusPoints);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("ataque")){
			this.controladorVentanaVidaPersonaje.SubeAtaque();
		}
		
		else if(e.getActionCommand().equals("vitalidad")){
			this.controladorVentanaVidaPersonaje.SubeVitalidad();
		}		
		
	}
	
}