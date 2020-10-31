package LP;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Clase de utilidades para la lógica de presentación.
 * @author javier.cerro
 *
 */
public class Utilidades 
{
	
	
	 /**
	  *  Metodo que devuelve un objeto de tipo ImageIcon o null si la ruta no es válida
	  */
    public static ImageIcon createImageIcon(String path) 
    {
    	
        //java.net.URL imgURL = Utilidades.class.getClass().getResource(path);
    	URL imgURL = Thread.currentThread().getContextClassLoader().getResource(path);
    	
        if (imgURL != null) 
        {
            return new ImageIcon(imgURL);
        } 
        else 
        {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
  
}
