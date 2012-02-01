package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorLogin;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.VentanaInicialCtrl;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.UsuarioIdData;

// ESCA-JAVA0100:

/**
 * Ventana inicial del Juego.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */

public class VentanaInicial extends VentanaLemuria implements ActionListener {
	/**
	 * Default serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Comando para el bot&oacute;n de aceptar.
	 */
	public static final String ACEPTAR_CMD = "aceptar";
	/**
	 * Comando para el bot&oacute;n de salir.
	 */
	public static final String SALIR_CMD = "salir";
	/**
	 * Comando para el bot&oacute;n de about.
	 */
	public static final String ABOUT_CMD = "about";
	/**
	 * Comando para el bot&oacute;n de registro.
	 */
	public static final String REGISTER_CMD = "registro";
	/**
	 * Talla para las areas de espaciamiento.
	 */
	public static final int DIM = 20;
	/**
	 * Control de la ventana.
	 */
	private VentanaInicialCtrl control;
	/**
	 * Panel
	 */
	private JPanel jContentPane = null;
	/** 
	 * Panel con todos los componentes.
	 */
	private JPanel panelCentral;
	/**
	 * Etiqueta para el campo de login.
	 */
	private JLabel loginLbl;
	/**
	 * Campo para el login.
	 */
	private JTextField loginTxtFld;
	/**
	 * Campo para el login.
	 */
	private JPasswordField passwdTxtFld;
	/**
	 * Etiqueta para el campo de password.
	 */
	private JLabel passwdLbl;
	/**
	 * Panel de botones
	 */
	private JPanel panelDeBotones = null;
	/**
	 * Boton Aceptar.
	 */
	private JButton aceptarBtn;
	/**
	 * Boton Cancelar
	 */
	private JButton cancelBtn;
	/**
	 * Barra de menu.
	 */
	private JMenuBar menuBar;
	/**
	 * Menu principal.
	 */
	private JMenu menu;
	/**
	 * Item de menu;
	 */
	private JMenuItem mItem;

	/**
	 * This is the default constructor
	 */
	
	private ControladorLogin controladorLogin;

	private VentanaCodigosKonami ventanaCodigosKonami;
	
	private VentanaSeleccionarMapa ventanaSeleccionarMapa;
	
	public VentanaInicial() {	
		initialize();
	}
	/**
	 * This method initializes this
	 */
	private void initialize() {		
		this.setTitle("Lemuria");

		jContentPane = new JPanel();
		jContentPane.setLayout(new BorderLayout());

		menuBar = new JMenuBar();
		menu = new JMenu("Archivo");
		mItem = new JMenuItem("Registro");
		Icon icon = new ImageIcon("registroIcon.png");
		mItem.setIcon(icon);
		mItem.setActionCommand(VentanaInicial.REGISTER_CMD);
		mItem.addActionListener(this);
		menu.add(mItem);
		menu.addSeparator();
		mItem = new JMenuItem("Codigos Konami");
		mItem.setActionCommand("codigos");
		mItem.addActionListener(this);
		menu.add(mItem);
		menu.addSeparator();
		mItem = new JMenuItem("Cargar/GuardarMapa");
		mItem.setActionCommand("cargar");
		mItem.addActionListener(this);
		menu.add(mItem);
		menu.addSeparator();
		mItem = new JMenuItem("Salir");
		icon = new ImageIcon("salirIcon.png");		
		mItem.setIcon(icon);
		mItem.setActionCommand(VentanaInicial.SALIR_CMD);
		mItem.addActionListener(this);
		menu.add(mItem);
		menuBar.add(menu);
		menu = new JMenu("Ayuda");
		mItem = new JMenuItem("Cuadro de honor");		
		icon = new ImageIcon("trofeoIcon.png");		
		mItem.setIcon(icon);
		mItem.setEnabled(true);
		mItem.setActionCommand("cuadro de honor");
		mItem.addActionListener(this);
		menu.add(mItem);
		menu.addSeparator();
		mItem = new JMenuItem("About");
		icon = new ImageIcon("aboutIcon.png");
		mItem.setIcon(icon);
		mItem.setActionCommand(VentanaInicial.ABOUT_CMD);
		mItem.addActionListener(this);
		menu.add(mItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);

		this.panelCentral = new JPanel(new GridLayout(2,2));		
		this.loginLbl = new JLabel("login:");
		this.loginTxtFld = new JTextField();
		this.loginTxtFld.setSize(100, 10);
		this.passwdLbl = new JLabel("password:");
		this.passwdTxtFld = new JPasswordField();
		this.panelCentral.add(this.loginLbl);
		this.panelCentral.add(this.loginTxtFld);
		this.panelCentral.add(this.passwdLbl);
		this.panelCentral.add(this.passwdTxtFld);
		this.jContentPane.add(this.panelCentral,BorderLayout.CENTER);

		this.panelDeBotones = new JPanel();
		this.aceptarBtn = new JButton("Aceptar");
		this.aceptarBtn.setActionCommand(VentanaInicial.ACEPTAR_CMD);
		this.aceptarBtn.addActionListener(this);
		this.cancelBtn = new JButton("Cancelar");
		this.cancelBtn.addActionListener(this);
		this.panelDeBotones.add(this.cancelBtn, BoxLayout.X_AXIS);
		this.panelDeBotones.add(this.aceptarBtn, BoxLayout.X_AXIS);
		this.jContentPane.add(this.panelDeBotones, BorderLayout.SOUTH);

		Component cmp = Box.createRigidArea(new Dimension(5,5));	
		jContentPane.add(cmp, BorderLayout.NORTH);
		cmp = Box.createRigidArea(new Dimension(VentanaInicial.DIM,VentanaInicial.DIM));
		this.jContentPane.add(cmp, BorderLayout.EAST);
		cmp = Box.createRigidArea(new Dimension(VentanaInicial.DIM,VentanaInicial.DIM));
		this.jContentPane.add(cmp, BorderLayout.WEST);
		this.setContentPane(this.jContentPane);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.compareTo(VentanaInicial.ACEPTAR_CMD) == 0){
			this.controladorLogin.Hacele();
			return;
		}
		
		if(comando.compareTo(VentanaInicial.SALIR_CMD) == 0){
			System.exit(0);
		}
		
		if(comando.compareTo(VentanaInicial.ABOUT_CMD) == 0){
			JOptionPane.showMessageDialog(this, "Lemuria\n\n Juego desarrollado por el" 
					+ "grupo 21 de POO de la Fac. de Ing. de la UAEM\n\n" 
					+ "Copyright 2011");
			return;
		}
		
		if(comando.compareTo(VentanaInicial.REGISTER_CMD) == 0){
			this.control.registra();
		}
		if(comando.compareTo("cuadro de honor")==0)
		{
			VentanaCuadroDeHonor ventanaCuadroDeHonor=new VentanaCuadroDeHonor();
			ventanaCuadroDeHonor.setVisible(true);
		}
		if(comando.compareTo("codigos")==0){
			ventanaCodigosKonami.setVisible(true);
		}
		if(comando.compareTo("cargar")==0){
			ventanaSeleccionarMapa.setVisible(true);
		}
		else {
			this.loginTxtFld.setText("");
			this.passwdTxtFld.setText("");
		}
	}
	/**
	 * Consulta los datos en la interfaz de usuario.
	 * @return Datos en la interfaz de usuario.
	 */
	public UsuarioIdData getDatos(){
		UsuarioIdData data = new UsuarioIdData();
		data.setLogin(this.loginTxtFld.getText());
		data.setPasswd(new String(this.passwdTxtFld.getPassword()));
		return data;
	}
	/**
	 * Establece el control de la ventana.
	 * @param control control de la ventana.
	 */
	public void setControl(VentanaInicialCtrl control) {
		this.control = control;
	}		

	@Override
	public void update(Observable o, Object arg) {
		if(this.getPlayerModel().isLogueado()){
			this.dispose();
		}
	}
	public JTextField getLoginTxtFld() {
		return loginTxtFld;
	}
	
	public void setLoginTxtFld(JTextField loginTxtFld) {
		this.loginTxtFld = loginTxtFld;
	}
	
	public String getPasswdTxtFld() {
		return new String(this.passwdTxtFld.getPassword());
	}
	
	public ControladorLogin getControladorLogin() {
		return controladorLogin;
	}
	
	public void setControladorLogin(ControladorLogin controladorLogin) {
		this.controladorLogin = controladorLogin;
	}
	public void setVentanaCodigosKonami(VentanaCodigosKonami ventanaCodigosKonami) {
		this.ventanaCodigosKonami = ventanaCodigosKonami;
	}
	public void setVentanaSeleccionarMapa(
			VentanaSeleccionarMapa ventanaSeleccionarMapa) {
		this.ventanaSeleccionarMapa = ventanaSeleccionarMapa;
	}
	
	
	
}