package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.error.UsuarioRepetidoException;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorRegistro;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.VentanaRegistroCtrl;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.UsuarioData;

// ESCA-JAVA0100:
/**
 * Ventana para recolectar los datos del registro.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class VentanaRegistro extends JFrame implements ActionListener, Observer{
	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Ancho del borde.
	 */
	public static final int ANCHO_DEL_BORDE = 15;
	/**
	 * Panel para los campos de texto de captura de datos.
	 */
	private JPanel dataPanel;
	/**
	 * Panel para los botones.
	 */
	private JPanel btnPanel;
	/**
	 * Etiqueta para el campo de login.
	 */	
	private JLabel loginLbl;
	/**
	 * Campo de texto para el login. 
	 */
	private JTextField loginTxtFld;
	/**
	 * Etiqueta para el campo de password.
	 */
	private JLabel passwdLbl;
	/**
	 * Campo de texto para el password.
	 */
	private JPasswordField passwdTxtFld;
	/**
	 * Etiqueta para el campo de confirmaci&oacute;n de password.
	 */
	private JLabel passwdConfLbl;
	/**
	 * Campo de texto para la confirmaci&oacute;n del password.
	 */
	private JPasswordField passwdConfTxtFld;
	/**
	 * Etiqueta para el campo del nombre de pila.
	 */
	private JLabel nombreLbl;
	/**
	 * Campo de texto para el nombre de pila.
	 */
	private JTextField nombreTxtFld;
	/**
	 * Etiqueta para el campo del apellido paterno.
	 */
	private JLabel apePatLbl;
	/**
	 * Campo de texto para el apellido paterno.
	 */
	private JTextField apePatTxtFld;
	/**
	 * Etiqueta para el campo del apellido materno.
	 */
	private JLabel apeMatLbl;
	/**
	 * Campo de texto para el apellido materno.
	 */
	private JTextField apeMatTxtFld;
	/**
	 * Etiqueta para el campo de edad.
	 */
	private JLabel edadLbl;
	/**
	 * Campo de texto para la edad.
	 */
	private JTextField edadTxtFld;
	/**
	 * Bot&oacute;n de Aceptar.
	 */
	private JButton aceptarBtn;
	/**
	 * Bot&oacute;n de Cancelar.
	 */
	private JButton cancelBtn;
	/**
	 * Etiqueta para el banner.
	 */
	private JLabel bannerLbl;
	/**
	 * Objeto para encapsular datos de comunicaci&oacute;n entre la vista y su control.
	 */
	private UsuarioData data;
	/**
	 * Modelo que ser&aacute; utilizado por la ventana.
	 */
	private Jugador modelo;
	/**
	 * Control de la ventana.
	 */
	private VentanaRegistroCtrl control;	

	/**
	 * Constructora, se instancian todos los componentes visuales y se colocan dentro del
	 * frame.
	 */
	public VentanaRegistro(){
		super("Inscripciones");
		dataPanel = new JPanel(new GridLayout(7, 2, 5, 5));
		
		this.loginLbl = new JLabel("Login: ");
		this.loginTxtFld = new JTextField();		
		this.dataPanel.add(this.loginLbl);
		this.dataPanel.add(this.loginTxtFld);
		this.passwdLbl = new JLabel("Password: ");
		this.passwdTxtFld = new JPasswordField();		
		this.dataPanel.add(this.passwdLbl);
		this.dataPanel.add(this.passwdTxtFld);		
		this.passwdConfLbl = new JLabel("Confirm password: ");
		this.passwdConfTxtFld = new JPasswordField();		
		this.dataPanel.add(this.passwdConfLbl);
		this.dataPanel.add(this.passwdConfTxtFld);		
		this.nombreLbl = new JLabel("Nombre: ");
		this.nombreTxtFld = new JTextField();		
		this.dataPanel.add(this.nombreLbl);
		this.dataPanel.add(this.nombreTxtFld);
		this.apePatLbl = new JLabel("Apellido Paterno: ");
		this.apePatTxtFld = new JTextField();		
		this.dataPanel.add(this.apePatLbl);
		this.dataPanel.add(this.apePatTxtFld);
		this.apeMatLbl = new JLabel("Apellido Materno: ");
		this.apeMatTxtFld = new JTextField();		
		this.dataPanel.add(this.apeMatLbl);
		this.dataPanel.add(this.apeMatTxtFld);
		this.edadLbl = new JLabel("Edad: ");
		this.edadTxtFld = new JTextField();		
		this.dataPanel.add(this.edadLbl);
		this.dataPanel.add(this.edadTxtFld);
		this.dataPanel.setBorder(new EmptyBorder(VentanaRegistro.ANCHO_DEL_BORDE,VentanaRegistro.ANCHO_DEL_BORDE,
				VentanaRegistro.ANCHO_DEL_BORDE,VentanaRegistro.ANCHO_DEL_BORDE));
		
		
		btnPanel = new JPanel();
		this.aceptarBtn = new JButton("Aceptar");
		this.aceptarBtn.setActionCommand("aceptar");
		this.aceptarBtn.addActionListener(this);
		this.cancelBtn = new JButton("Cancelar");
		this.cancelBtn.setActionCommand("cancelar");
		this.cancelBtn.addActionListener(this);
		btnPanel.add(this.aceptarBtn);
		btnPanel.add(this.cancelBtn);
		
		Icon icon = new ImageIcon("banner.png");
		this.bannerLbl = new JLabel();
		this.bannerLbl.setIcon(icon);
		
		this.getContentPane().add(this.bannerLbl, BorderLayout.NORTH);
		this.getContentPane().add(this.dataPanel, BorderLayout.CENTER);
		this.getContentPane().add(this.btnPanel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(200,300);
		this.pack();
	}
	
	/**
	 * Establece el modelo que observar&aacute; la vista.
	 * @param modelo Jugador que servir&aacute; como el modelo que observar&aacute; la vista.
	 */
	public void setModelo(Jugador modelo) {
		this.modelo = modelo;
		this.modelo.addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		data = new UsuarioData();
		if(comando.compareTo("aceptar") == 0){
			String pass = new String(this.passwdTxtFld.getPassword());
			String confPass = new String(this.passwdConfTxtFld.getPassword());
			if(pass.compareTo(confPass) == 0){
				//Llena el objeto de comunicacion con los datos
				data.setLogin(this.loginTxtFld.getText());
				data.setPasswd(pass);
				data.setNombreDePila(this.nombreTxtFld.getText());
				data.setApellidoPaterno(this.apePatTxtFld.getText());
				data.setApellidoMaterno(this.apeMatTxtFld.getText());
				data.setEdad(this.edadTxtFld.getText());
				try{
					ControladorRegistro.Hacele(data);
				} catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(this, "El campo \"Edad\" debe ser un entero");
				}
			} else {
				JOptionPane.showConfirmDialog(this, "Los passwords no son iguales, favor de verificar");
			}
		} else {
			this.borraContenidoComponentes();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		this.dispose();		
	}
	/**
	 * Establece el control de la ventana.
	 * @param control Control de la ventana.
	 */
	public void setControl(VentanaRegistroCtrl control) {
		this.control = control;
	}
	
	private void borraContenidoComponentes(){
		this.loginTxtFld.setText("");
		this.passwdTxtFld.setText("");
		this.passwdConfTxtFld.setText("");
		this.nombreTxtFld.setText("");
		this.apePatTxtFld.setText("");
		this.apeMatTxtFld.setText("");
		this.edadTxtFld.setText("");
	}


	public static void main(String[] args) {
		VentanaRegistro ventana = new VentanaRegistro();
		ventana.setVisible(true);
	}
}

