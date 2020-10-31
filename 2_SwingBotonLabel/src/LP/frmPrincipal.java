package LP;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import static LP.Utilidades.*;

public class frmPrincipal extends JFrame implements ActionListener,MouseMotionListener
{
	
	private JButton btnPulsar;
	private JLabel lblPulsar;
	
	
	
	public frmPrincipal()
	{
		
		this.createGui();
		
		this.setVisible(true);
	}
	
	
	private void createGui()
	{
		
		JPanel objAux = (JPanel) this.getContentPane();
		
		this.setSize(new Dimension(400,300));
		objAux.setLayout(new BorderLayout());
		this.setTitle("Ejemplo de botón");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon ButtonIcon = createImageIcon("images/giphy.gif");
		btnPulsar=new JButton("Pulsar",ButtonIcon);
		
		btnPulsar.addActionListener(this);
		objAux.add(btnPulsar,BorderLayout.LINE_END);
//		objAux.add(btnPulsar,BorderLayout.BEFORE_LINE_BEGINS);
		
		
		lblPulsar=new JLabel("Pulsa aquí");
		lblPulsar.addMouseMotionListener(this);
		objAux.add(lblPulsar,BorderLayout.CENTER);
		
		this.pack();
		
		
			
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println(e.getSource());
		
	}


	@Override
	public void mouseDragged(MouseEvent e) 
	{
		System.out.println(e);
		
	}


	@Override
	public void mouseMoved(MouseEvent e) 
	{
		System.out.println(e);
		
	}
	
	
	

}
