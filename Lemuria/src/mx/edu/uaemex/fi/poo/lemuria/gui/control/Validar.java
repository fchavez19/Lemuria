package mx.edu.uaemex.fi.poo.lemuria.gui.control;
import javax.swing.JOptionPane;

public class Validar{

	public static boolean CampoVacio(String cadena, String campo){
		String cadenaPrueba = cadena.replaceAll(" ","");

		if(cadenaPrueba.compareTo("")==0)
		{
	        JOptionPane.showMessageDialog(null, "Error en: " + campo, "Error de campo vacío", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean CampoValido(String numero, String campo){
		numero = numero.replaceAll(" ","");
		char[] cadena = numero.toCharArray();
		int i=0;
		for(i=0; i<numero.length(); i++){
			if(cadena[i]<48 || cadena[i]>57){
		        JOptionPane.showMessageDialog(null, "Datos incorrectos en: " + campo, "Error de datos incorrectos", JOptionPane.ERROR_MESSAGE);
				return false;
			}	
		}
		return true;
	}

	public static boolean CampoTipo(String tipo, String campo){
		
		if( (tipo.compareToIgnoreCase("INT")==0) || (tipo.compareToIgnoreCase("VARCHAR")==0) || 
				(tipo.compareToIgnoreCase("DATE")==0) || (tipo.compareToIgnoreCase("FLOAT")==0) || 
				(tipo.compareToIgnoreCase("CHAR")==0) || (tipo.compareToIgnoreCase("DOUBLE")==0) )
		{
			return true;
		}
		
		else
		{
	        JOptionPane.showMessageDialog(null, "Tipo de dato no existente en: " + campo, "Error de tipo de dato", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

}