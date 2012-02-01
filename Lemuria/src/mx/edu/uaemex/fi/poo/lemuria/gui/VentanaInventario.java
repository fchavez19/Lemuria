package mx.edu.uaemex.fi.poo.lemuria.gui;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorVentanaInventario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class VentanaInventario extends VentanaLemuria implements ActionListener{
	// La ventana principal

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// El JTabbedPane con sus pestañas e iconos en las mismas.
	private JTabbedPane pestanas = new JTabbedPane();
	private JPanel contenedorArmas =  new JPanel();
	private JPanel contenedorItems=new JPanel();
	private JPanel  todo =new JPanel();
	private JPanel  todo2 =new JPanel();
	private JLabel imageLabel = new JLabel();

	// botones para armas
	private ButtonGroup botonesArmas = new ButtonGroup(); // button group para armas
	private JRadioButton botonEspada = new JRadioButton("ESPADA",false);
	private JRadioButton botonEscudo = new JRadioButton("ESCUDO",false);
	private JRadioButton botonBallesta= new JRadioButton("BALLESTA",false);
	private JRadioButton botonArco = new JRadioButton("ARCO",false);
	private JRadioButton botonDaga = new JRadioButton("DAGA",false);
	private JRadioButton botonNada = new JRadioButton("NADA",true);

	//botones para items
	private ButtonGroup botonesItems = new ButtonGroup(); // button group para items
	private JRadioButton botonPrincesa = new JRadioButton("PRINCESA",true);
	private JRadioButton botonPosionFuerza = new JRadioButton("POSION  DE FUERZA",false);
	private JRadioButton botonEsteorides = new JRadioButton("Esteroides",false);
	private JRadioButton botonPosionEnergia = new JRadioButton("POSION ENERGIA",false);
	private JRadioButton botonPosion = new JRadioButton("Posion de salud  ",false);
	private JRadioButton botonNada2 = new JRadioButton("NADA  ",false);

	private ControladorVentanaInventario controladorVentanaInventario;

	public static final int ANCHO = 576;
	public static final int ALTO = 432;

	public ControladorVentanaInventario getControladorVentanaInventario() {
		return controladorVentanaInventario;
	}

	public void setControladorVentanaInventario(
			ControladorVentanaInventario controladorVentanaInventario) {
		this.controladorVentanaInventario = controladorVentanaInventario;
	}

	public VentanaInventario(){
		contenedorArmas.setLayout(new FlowLayout());
		// agregando los botones al ButtonGroup de armas
		botonesArmas.add(botonEspada);
		botonEspada.addActionListener(this);
		botonEspada.setVisible(false);
		botonesArmas.add(botonEscudo);
		botonEscudo.addActionListener(this);
		botonEscudo.setVisible(false);
		botonesArmas.add(botonBallesta);
		botonBallesta.addActionListener(this);
		botonBallesta.setVisible(false);
		botonesArmas.add(botonDaga);
		botonDaga.addActionListener(this);
		botonDaga.setVisible(false);
		botonesArmas.add(botonArco);
		botonArco.addActionListener(this);
		botonArco.setVisible(false);
		botonesArmas.add(botonNada);
		botonNada.addActionListener(this);

		contenedorItems.setLayout(new FlowLayout());
		// agregando los botones al ButtonGroup de items
		botonesItems.add(botonPrincesa);
		botonPrincesa.addActionListener(this);
		botonPrincesa.setVisible(false);
		botonesItems.add(botonPosion);
		botonPosionFuerza.addActionListener(this);
		botonPosionFuerza.setVisible(false);
		botonesItems.add(botonPosionFuerza);
		botonEsteorides.addActionListener(this);
		botonEsteorides.setVisible(false);
		botonesItems.add(botonEsteorides);
		botonPosionEnergia.addActionListener(this);
		botonPosionEnergia.setVisible(false);
		botonesItems.add(botonPosionEnergia);
		botonPosion.addActionListener(this);
		botonPosion.setVisible(false);
		botonesItems.add(botonNada2);

		//caracteristicas panel de imagen 
		//imagen.setSize(ANCHO,ALTO);			

		//agregando botones al container de armas
		contenedorArmas.add(botonEspada);
		contenedorArmas.add(botonEscudo);
		contenedorArmas.add(botonBallesta);
		contenedorArmas.add(botonArco);
		contenedorArmas.add(botonDaga);
		contenedorArmas.add(botonNada);

		todo.add(contenedorArmas,BorderLayout.NORTH);
		todo.add(imageLabel,BorderLayout.SOUTH);

		todo2.add(contenedorItems,BorderLayout.NORTH);
		todo2.add(imageLabel,BorderLayout.SOUTH);


		//agregando botones al container de items
		contenedorItems.add(botonPrincesa,BoxLayout.X_AXIS);
		contenedorItems.add(botonPosion,BoxLayout.X_AXIS);
		contenedorItems.add(botonPosionFuerza,BoxLayout.LINE_AXIS);
		contenedorItems.add(botonEsteorides,BoxLayout.LINE_AXIS);
		contenedorItems.add(botonPosionEnergia,BoxLayout.LINE_AXIS);
		contenedorItems.add(botonNada2, BoxLayout.LINE_AXIS);
		//agregando pestañas al JTabbledPane
		pestanas.add("ARMAS",new Container().add(todo));
		pestanas.add("ITEMS",new Container().add(todo2));
		//para los iconos 
		pestanas.setIconAt(0, new ImageIcon("caballero.jpg"));
		pestanas.setIconAt(1, new ImageIcon("itemsIcono.jpg"));

		pestanas.setBackgroundAt(0,Color.RED);
		pestanas.setBackgroundAt(1,Color.GREEN);

		this.getContentPane().add(pestanas);
		this.setSize(ANCHO,ALTO);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonArco){
			this.controladorVentanaInventario.Hacele("arco");
			imageLabel.setVisible(false);
			imageLabel = new JLabel(new ImageIcon("arcos.jpg"));
			todo.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonEspada){
			this.controladorVentanaInventario.Hacele("espada");
			imageLabel.setVisible(false);
			imageLabel = new JLabel(new ImageIcon("espada.jpg"));
			todo.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonDaga){
			this.controladorVentanaInventario.Hacele("daga");
			imageLabel.setVisible(false);
			imageLabel = new JLabel(new ImageIcon("daga.jpg"));
			todo.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonBallesta){
			this.controladorVentanaInventario.Hacele("ballesta");
			imageLabel.setVisible(false);
			imageLabel = new JLabel(new ImageIcon("ballesta.jpg"));
			todo.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonEscudo){
			this.controladorVentanaInventario.Hacele("escudo");
			imageLabel.setVisible(false);
			imageLabel = new JLabel(new ImageIcon("escudo.jpg"));
			todo.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonPosionFuerza){
			this.controladorVentanaInventario.Hacele("posion");
			imageLabel.setVisible(false);
			ImageIcon	image = new ImageIcon("potion.fuerza.png");
			imageLabel=new JLabel(image);
			todo2.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonPosionEnergia){
			this.controladorVentanaInventario.Hacele("posion");
			imageLabel.setVisible(false);
			imageLabel = new JLabel(new ImageIcon("pocion-energia.jpg"));
			todo2.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonPrincesa){
			this.controladorVentanaInventario.Hacele("posion");
			imageLabel.setVisible(false);
			imageLabel = new JLabel(new ImageIcon("Princesa_Medea.jpg"));
			todo2.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonPosion){
			this.controladorVentanaInventario.Hacele("posion salud");
			imageLabel.setVisible(false);
			imageLabel = new JLabel(new ImageIcon("pocion.jpg"));
			todo2.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonEsteorides){
			this.controladorVentanaInventario.Hacele("esteroides");
			imageLabel = new JLabel(new ImageIcon("jeringa.jpg"));
			todo2.add(imageLabel,BorderLayout.SOUTH);
		}

		if (e.getSource()==botonNada){
			imageLabel.setVisible(false);
			imageLabel = new JLabel();
			todo2.add(imageLabel,BorderLayout.SOUTH);
			this.controladorVentanaInventario.Hacele("nada");
		}

		if (e.getSource()==botonNada2){
			imageLabel.setVisible(false);
			imageLabel = new JLabel();
			todo.add(imageLabel,BorderLayout.SOUTH);
			this.controladorVentanaInventario.Hacele("nada");
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.setVisible(true);
	}

	public void HabilitaItem(String item, boolean estado){
		if(estado==false){
			this.botonNada.doClick();
			this.botonNada2.doClick();
		}
		
		if(item.compareTo("posion salud")==0){
			this.botonPosion.setVisible(estado);
		}
		
		else if(item.compareTo("esteroides")==0){
			this.botonEsteorides.setVisible(estado);
		}
		else if(item.compareTo("espada")==0){
			this.botonEspada.setVisible(estado);
		}
		else if(item.compareTo("daga")==0){
			this.botonDaga.setVisible(estado);
		}
		else if(item.compareTo("ballesta")==0){
			this.botonBallesta.setVisible(estado);
		}
		else if(item.compareTo("escudo")==0){
			this.botonEscudo.setVisible(estado);
		}
		else if(item.compareTo("arco")==0){
			this.botonArco.setVisible(estado);
		}
		this.repaint();
	}
	
}