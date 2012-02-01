package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.Validar;

public class Login extends JInternalFrame implements ActionListener{
	private JLabel etiquetaUsuario;
	private JLabel etiquetaPassword;
	private JLabel etiquetaError;

	private JTextField campoUsuario;
	private JPasswordField campoPassword;

	private JButton entrar;
	private JButton salir;
	private JButton cancelar;

	private JPanel panelUsuario;
	private JPanel panelPassword;
	private JPanel panelBotones;

	public Login(){
		etiquetaUsuario=new JLabel("Usuario: ");
		etiquetaPassword=new JLabel("Password: ");
		etiquetaError=new JLabel("Verifique los datos");
		etiquetaError.setVisible(false);

		campoUsuario=new JTextField(10);
		campoUsuario.setActionCommand("entrar");
		campoUsuario.addActionListener(this);

		campoPassword=new JPasswordField(10);
		campoPassword.setActionCommand("entrar");
		campoPassword.addActionListener(this);

		entrar= new JButton("Entrar");
		entrar.addActionListener(this);
		entrar.setActionCommand("entrar");

		salir= new JButton("Salir");
		salir.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){dispose();}});

		cancelar= new JButton("Cancelar");
		cancelar.addActionListener(this);
		cancelar.setActionCommand("cancelar");

		panelUsuario= new JPanel();
		panelUsuario.add(etiquetaUsuario,BorderLayout.NORTH);
		panelUsuario.add(campoUsuario,BorderLayout.CENTER);

		panelPassword= new JPanel();
		panelPassword.add(etiquetaPassword,BorderLayout.NORTH);
		panelPassword.add(campoPassword,BorderLayout.CENTER);

		panelBotones= new JPanel();
		panelBotones.setLayout(new GridLayout(1,3));
		panelBotones.add(entrar);
		panelBotones.add(cancelar);
		panelBotones.add(salir);


		this.getContentPane().add(panelUsuario, BorderLayout.NORTH);
		this.getContentPane().add(panelPassword, BorderLayout.CENTER);
		this.getContentPane().add(panelBotones, BorderLayout.SOUTH);
		this.setPreferredSize(new Dimension(280,130));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		String comando = e.getActionCommand();
		if(comando.compareTo("entrar")==0){
			if(Validar.CampoVacio(campoUsuario.getText(),"campo Usuario")==true){
				try{
					FileInputStream fis = null;
					ObjectInputStream in = null;
					String filename = "salida.txt";

					fis= new FileInputStream(filename);
					in = new ObjectInputStream(fis);
					List<Jugador> listaJugador = (List<Jugador>)in.readObject();

					in.close();

					Jugador jugador;
					int i;
					for(i=0; i<listaJugador.size(); i++){
						jugador = listaJugador.get(i);
						if(campoUsuario.getText().compareTo(jugador.getLogin())==0){
							String pass = new String(campoPassword.getPassword()); 
							if(pass.compareTo(jugador.getPassword())==0){
								this.setVisible(false);
								i=listaJugador.size()+1;
							}
						}
					}

					if(i==listaJugador.size()){
						JOptionPane.showMessageDialog(null, "Usuario no encontrado: ", "Usuario o password incorrecto", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(IOException ex){
					ex.printStackTrace();
				}

				catch(ClassNotFoundException ex){
					ex.printStackTrace();			
				}
			}
		}

		else if(comando.compareTo("cancelar")==0){
			campoUsuario.setText("");
			campoPassword.setText("");
		}
		else if(comando.compareTo("salir")==0){
			this.dispose();
		}
	}

	public static boolean BuscarJugador(String nombre){
		try{
			FileInputStream fis = null;
			ObjectInputStream in = null;
			String filename = "salida.txt";

			fis= new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			List<Jugador> listaJugador = (List<Jugador>)in.readObject();

			in.close();
			
			Jugador jugador;
			int i;
			for(i=0; i<listaJugador.size(); i++){
				jugador = listaJugador.get(i);
				System.out.println(jugador.getLogin());
				System.out.println(jugador.getPassword());
				if(jugador.getLogin().compareToIgnoreCase(nombre)==0){
					return true;
				}
			}
			return false;
		}

		catch(IOException ex){
			ex.printStackTrace();
		}

		catch(ClassNotFoundException ex){
			ex.printStackTrace();			
		}
	return false;
	}

}