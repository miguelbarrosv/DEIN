import LP.ButtonDemo;

public class clsMain 
{

	public static void main(String[] args) 
	{
		/*
		 * Se crea el formulario con los botones.
		 */
		
		final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
		
		
		
		ButtonDemo.createAndShowGUI();

	}

}
