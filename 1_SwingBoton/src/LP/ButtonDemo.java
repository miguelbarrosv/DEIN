package LP;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static LP.Utilidades.*;

/**
 * Ejemplo para el uso de botones.
 * 
 * @author DEIN DM2
 *
 */
public class ButtonDemo extends JPanel implements ActionListener 
{
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private static JFrame frame;
    
    private final String ACTION_COMMAND_DISABLE_BUTTON="ACTION_COMMAND_DISABLE_BUTTON";
    private final String ACTION_COMMAND_ENABLE_BUTTON="ACTION_COMMAND_ENABLE_BUTTON";
    private final String ACTION_COMMAND_MIDDLE_BUTTON="ACTION_COMMAND_MIDDLE_BUTTON";
    
    

    public ButtonDemo() 
    {
        ImageIcon leftButtonIcon = createImageIcon("images/right.gif");
        ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
        ImageIcon rightButtonIcon = createImageIcon("images/left.gif");

        b1 = new JButton("Disable middle button", leftButtonIcon);
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand(ACTION_COMMAND_DISABLE_BUTTON);

        b2 = new JButton("Middle button", middleButtonIcon);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);

        b3 = new JButton("Enable middle button", rightButtonIcon);
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand(ACTION_COMMAND_ENABLE_BUTTON);
        b3.setEnabled(false);

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);

        b1.setToolTipText("Click this button to disable the middle button.");
        b2.setToolTipText("This middle button does nothing when you click it.");
        b3.setToolTipText("Click this button to enable the middle button.");

        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
        add(b3);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (ACTION_COMMAND_DISABLE_BUTTON.equals(e.getActionCommand())) 
        {
            b2.setEnabled(false);
            b1.setEnabled(false);
            b3.setEnabled(true);
        } 
        else if(ACTION_COMMAND_ENABLE_BUTTON.equals(e.getActionCommand()))
        {
            b2.setEnabled(true);
            b1.setEnabled(true);
            b3.setEnabled(false);
        }
        else 
        {
        	
        	Object[] options = {"Yes, please","No, thanks","No eggs, no ham!"};
        	int n = JOptionPane.showOptionDialog(frame, "Would you like some green eggs to go " + "with that ham?", "A Silly Question", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
        										null,    options, options[0]);
        	
        	System.out.println(n);
        	
        	
        	
        }
    }

   
    /**
     * Create the GUI and show it.  For thread safety, 
     * this method should be invoked from the 
     * event-dispatching thread.
     */
    public static void createAndShowGUI() 
    {

        //Create and set up the window.
        frame = new JFrame("ButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ButtonDemo newContentPane = new ButtonDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    
 
}
