//package mx.edu.uaemex.fi.poo.lemuria.gui;
//
//import java.awt.GraphicsDevice;
//import java.awt.GraphicsEnvironment;
//
//public class VentanaDaño {
//
//	public VentanaDaño(){
//	}
//	
//	    public static void main(String[] args) {
//	        // Determine if the GraphicsDevice supports translucency.
//	        GraphicsEnvironment ge = 
//	            GraphicsEnvironment.getLocalGraphicsEnvironment();
//	        GraphicsDevice gd = ge.getDefaultScreenDevice();
//
//	        //If translucent windows aren't supported, exit.
//	        if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
//	            System.err.println(
//	                "Translucency is not supported");
//	                System.exit(0);
//	        }
//	        
//            TranslucentWindow tw = new TranslucentWindow();
//
//    		// Set the window to 55% opaque (45% translucent).
//                    tw.setOpacity(0.55f);
//
//    		// Display the window.
//    		tw.setVisible(true);
//
//}
